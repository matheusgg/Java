package processor;

import processor.annotation.Invoke;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;
import java.util.List;
import java.util.Set;

/**
 * Annotation Processors é uma API que possibilita a execucao de uma
 * determinada lógica durante o processo de compilacao. Com essa API é possível
 * realizar validacoes, gerar codigo e novos fontes que serao compilados. Dentro
 * de uma IDE, um AnnotationProcessor é invocado a cada aevento de build, onde a
 * IDE realizara a compilacao das classes.
 *
 * @author Matheus
 */
//@SupportedAnnotationTypes("processor.annotation.Invoke")
//@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class AppProcessor extends AbstractProcessor {

	private Messager messager;
	private Elements elementsUtil;

	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		this.messager = super.processingEnv.getMessager();
		this.elementsUtil = super.processingEnv.getElementUtils();
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		Set<? extends Element> elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(Invoke.class);

		for (Element element : elementsAnnotatedWith) {

			// Recuperando o Mirror da anotacao Invoke
			AnnotationMirror mirror = null;
			Invoke invoke = element.getAnnotation(Invoke.class);
			List<? extends AnnotationMirror> annotationMirrors = element.getAnnotationMirrors();

			for (AnnotationMirror annotationMirror : annotationMirrors) {
				if (invoke.toString().equals(annotationMirror.toString())) {
					mirror = annotationMirror;
					break;
				}
			}

			String methodName = invoke.value();
			boolean valido = false;

			// Recuperando o tipo do elemento
			TypeElement typeElement = this.elementsUtil.getTypeElement(element.asType().toString());

			// Recuperando todos os membros (atributos e metodos)
			List<? extends Element> members = this.elementsUtil.getAllMembers(typeElement);

			for (Element member : members) {
				// Recuperando os nomes dos metodos apenas
				if (ElementKind.METHOD.equals(member.getKind()) && methodName.equals(member.getSimpleName().toString())) {
					valido = true;
					break;
				}
			}

			if (!valido) {
				this.messager.printMessage(Diagnostic.Kind.ERROR, "O tipo " + typeElement + " não possui o método " + methodName, element, mirror);
			}
		}

		return false;
	}
}
