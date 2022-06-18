package springjdbc;

import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TesSpringJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		PersonDao dao = (PersonDao) ctx.getBean("dao");
		List<Persons> persons = dao.displayPersons();

		for (Persons p1 : persons) {

			System.out.println(p1.getId() + " " + p1.getFirstName() + " " + p1.getLastName() + " " + p1.getAge());
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id of the person");
		int ids = sc.nextInt();
		System.out.println("Enter first name of the person");
		String fname = sc.next();
		System.out.println("Enter lastname of the person");
		String lname = sc.next();
		System.out.println("Enter state of the person");
		int age = sc.nextInt();
		Persons person = new Persons(ids, fname, lname, age);

		dao.insertPerson(person);
		/*
		 * Scanner sc = new Scanner(System.in);
		 * System.out.println("Enter name of the person"); String name = sc.next();
		 * Persons p = dao.searchPerson(name); System.out.println(p);
		 * 
		 * dao.deletePerson(name);
		 * 
		 * List<Persons> persons = dao.displayPersons();
		 * 
		 * for(Persons p1 :persons) {
		 * 
		 * System.out.println(p1.getName()+" "+p1.getCity()+" "+p1.getState()); }
		 * 
		 * 
		 * 
		 * Scanner sc = new Scanner(System.in);
		 * System.out.println("Enter id of the person"); int ids = sc.nextInt();
		 * System.out.println("Enter first name of the person"); String fname =
		 * sc.next(); System.out.println("Enter lastname of the person"); String lname =
		 * sc.next(); System.out.println("Enter state of the person"); int age =
		 * sc.nextInt(); Persons person = new Persons(ids,fname,lname,age);
		 * 
		 * dao.insertPerson(person); /* dao.deletePerson(name); List<Persons> persons =
		 * dao.displayPersons(); for(Persons p :persons) {
		 * System.out.println(p.getName()+" "+p.getCity()+" "+p.getState()); }
		 * 
		 */
	}

}
