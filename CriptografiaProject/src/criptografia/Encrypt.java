package criptografia;

import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public final class Encrypt {

	private static String METODO_ENCRIPTACAO_AES;
	private static byte[] KEY;
	private static SecretKeySpec SECRET_KEY_SPEC;

	static {
		Encrypt.METODO_ENCRIPTACAO_AES = "AES";
		Encrypt.KEY = Encrypt.generateKey();
		Encrypt.SECRET_KEY_SPEC = new SecretKeySpec(Encrypt.KEY, Encrypt.METODO_ENCRIPTACAO_AES);
	}

	private Encrypt() {

	}

	public static void main(String[] args) throws Exception {
		String encriptado = Encrypt.encrypt("12345");
		System.out.println("Senha criptografada: " + encriptado);

		String decriptado = Encrypt.decrypt(encriptado);
		System.out.println("Senha descriptografada: " + decriptado);
	}

	/**
	 * Criptografa o texto informado utilizando o algoritmo AES.
	 * 
	 * @param text
	 *            Texto que sera criptografado.
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String text) throws Exception {
		byte[] byteText = text.getBytes();
		Cipher cipher = Cipher.getInstance(Encrypt.METODO_ENCRIPTACAO_AES);
		cipher.init(Cipher.ENCRYPT_MODE, Encrypt.SECRET_KEY_SPEC);
		return new BASE64Encoder().encode(cipher.doFinal(byteText));
	}

	/**
	 * Descriptografa o texto criptografado informado com base no algoritmo AES.
	 * 
	 * @param encryptedText
	 *            Texto que sera descriptografado.
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String encryptedText) throws Exception {
		byte[] encryptedByteText = new BASE64Decoder().decodeBuffer(encryptedText);
		Cipher cipher = Cipher.getInstance(Encrypt.METODO_ENCRIPTACAO_AES);
		cipher.init(Cipher.DECRYPT_MODE, Encrypt.SECRET_KEY_SPEC);
		return new String(cipher.doFinal(encryptedByteText));
	}

	/**
	 * Gera uma chave aleatoria de 16 bytes para utilizacao na criptografia e na
	 * descriptografia dos dados.
	 * 
	 * @return
	 */
	private static byte[] generateKey() {
		byte[] key = new byte[16];
		new Random().nextBytes(key);
		return key;
	}
}
