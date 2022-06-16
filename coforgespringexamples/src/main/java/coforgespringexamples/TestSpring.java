package coforgespringexamples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		Address a1 = (Address) context.getBean("addr");
		System.out.println(a1.hashCode());
		Address a2 = (Address) context.getBean("addr");
		System.out.println(a2.hashCode());
		
		Person person = (Person) context.getBean("p");
		System.out.println(person);
		
		Tutor tutor = (Tutor) context.getBean("tutor");
		System.out.println(tutor);
	
	}
}
