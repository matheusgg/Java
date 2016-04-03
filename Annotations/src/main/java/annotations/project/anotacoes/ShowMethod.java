package annotations.project.anotacoes;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * Annotations são instruções que fornece informações sobre o código e podem ser
 * interpretadas pelos compiladores, desta forma é possível informar para um 
 * compilador se uma determinada tarefa deva ser executada ou não.
 */
@Documented
/*
 * Informa que esta Annotation deve ser utilizada apenas em métodos
 */
@Target(value = ElementType.METHOD)
/*
 * Informa que os valores deste Annotation podem ser acessados em tempo de
 * execução através de Reflection
 */
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ShowMethod {
	/*
	 * A declaração de campos em annotations se assemelha a métodos, porém sem
	 * parâmetros e modificadores de acesso. É possível definir também um valor
	 * padrão. Quando a annotation possui apenas um campo chamado value, não é
	 * necessário especificá-lo no momento da utilização da annotation, ficando
	 * desta forma: @ShowMethod(2)
	 */
	int value() default 1;
}
