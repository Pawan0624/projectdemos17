package coforgespringexamples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class TestJavaConfigfiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ApplicationContext context = 
			//		new ClassPathXmlApplicationContext("springs.xml");
		 
		 AnnotationConfigApplicationContext ctx = 
					new AnnotationConfigApplicationContext(AppConfigs.class);
		 
		Address addr= (Address) ctx.getBean("a2");
		System.out.println(addr);
		
		Person person = (Person) ctx.getBean("p1");
		System.out.println(person);

	}

}
