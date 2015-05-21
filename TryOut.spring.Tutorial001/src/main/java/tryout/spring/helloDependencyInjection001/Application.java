package tryout.spring.helloDependencyInjection001;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * @date
 * @author Lindhauer
 *Aus einem Tutorial vom http://projects.spring.io/spring-framework/#quick-start
 *
 *The example above shows the basic concept of dependency injection,
 *the MessagePrinter is decoupled from the MessageService implementation,
 *with Spring Framework wiring everything together.
 *
 */
@Configuration
@ComponentScan
public class Application {

	//Fehler, der auftritt, wenn man diese Bean nicht definiert: 
	//org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'messagePrinter' defined in file [C:\1fgl\ws-fgl\TryOutSpring\fgl.tryout.spring01\target\classes\tryout\spring\helloDependencyInjection001\MessagePrinter.class]: Unsatisfied dependency expressed through constructor argument with index 0 of type [tryout.spring.helloDependencyInjection001.MessageService]: : No qualifying bean of type [tryout.spring.helloDependencyInjection001.MessageService] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {}; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type [tryout.spring.helloDependencyInjection001.MessageService] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {}
	@Bean
	MessageService mockMessageService(){
		return new MessageService() {
			public String getMessage(){
				return "Hello World";
			}
		};
	}
	
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		printer.printMessage();

	}
	
	

}
