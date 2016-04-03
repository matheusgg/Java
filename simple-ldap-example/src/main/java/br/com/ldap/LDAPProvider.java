package br.com.ldap;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.naming.NamingEnumeration;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class LDAPProvider {

	private static final String LDAP_HOST = "ldap://<server>:<port>";
	private static final String DN = "<DistinguishedName. Ex.: DC=teste,DC=sp>";

	public static void main(String[] args) throws Exception {
		LDAPProvider ldapProvider = new LDAPProvider();
		LdapContext ldapContext = ldapProvider.autenticaUsuario("usuario@dominio", "senha");

		List<Map<String, Object>> usuarios = new LDAPProvider().search(ldapContext, "(&(objectClass=user)(sAMAccountName={0}))", "mggoes");
		System.out.println(usuarios);
	}

	public LdapContext autenticaUsuario(String usuario, String senha) throws Exception {
		Hashtable<String, String> env = new Hashtable<>();
		env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
		env.put("java.naming.provider.url", LDAP_HOST);
		env.put("java.naming.security.authentication", "simple");
		env.put("java.naming.security.principal", usuario);
		env.put("java.naming.security.credentials", senha);
		return new InitialLdapContext(env, null);
	}

	public List<Map<String, Object>> search(LdapContext ldapContext, String filtroPesquisa, Object... parametrosFiltro) throws Exception {
		String[] fieldsToBeReturned = { "givenName", "sn", "name", "physicalDeliveryOfficeName", "memberOf", "company", "sAMAccountName", "userPrincipalName",
				"department", "mail" };

		SearchControls searchControls = new SearchControls();
		searchControls.setReturningAttributes(fieldsToBeReturned);
		searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);

		filtroPesquisa = MessageFormat.format(filtroPesquisa, parametrosFiltro);
		NamingEnumeration<SearchResult> dadosRetornados = ldapContext.search(DN, filtroPesquisa, searchControls);

		Map<String, Object> dadosUsuario = null;
		List<Map<String, Object>> usuarios = new ArrayList<>();

		while (dadosRetornados.hasMoreElements()) {
			SearchResult searchResult = (SearchResult) dadosRetornados.next();
			Attributes attributes = searchResult.getAttributes();

			Set<String> returnedAttributes = new HashSet<>();
			NamingEnumeration<String> ids = attributes.getIDs();
			while (ids.hasMoreElements()) {
				returnedAttributes.add(ids.next());
			}

			dadosUsuario = Stream.of(fieldsToBeReturned).filter(returnedAttributes::contains).map(field -> attributes.get(field))
					.collect(Collectors.toMap(attr -> attr.getID(), attr -> {
						try {
							return attr.get();
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
					}));

			if (!dadosUsuario.isEmpty()) {
				usuarios.add(dadosUsuario);
			}
		}

		return usuarios;
	}
}
