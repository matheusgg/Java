package annotations.project.anotacoes;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * Annotations s�o instru��es que fornece informa��es sobre o c�digo e podem ser
 * interpretadas pelos compiladores, desta forma � poss�vel informar para um 
 * compilador se uma determinada tarefa deva ser executada ou n�o.
 */
@Documented
/*
 * Informa que esta Annotation deve ser utilizada apenas em m�todos
 */
@Target(value = ElementType.METHOD)
/*
 * Informa que os valores deste Annotation podem ser acessados em tempo de
 * execu��o atrav�s de Reflection
 */
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ShowMethod {
	/*
	 * A declara��o de campos em annotations se assemelha a m�todos, por�m sem
	 * par�metros e modificadores de acesso. � poss�vel definir tamb�m um valor
	 * padr�o. Quando a annotation possui apenas um campo chamado value, n�o �
	 * necess�rio especific�-lo no momento da utiliza��o da annotation, ficando
	 * desta forma: @ShowMethod(2)
	 */
	int value() default 1;
}
