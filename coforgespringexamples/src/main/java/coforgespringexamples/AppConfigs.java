package coforgespringexamples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigs {
	
	@Bean("a1")
	public static Address createAddresss1() {
		return new Address(9001,"Koramanagala","Bangalore");
	}
	
	@Bean("a2")
	public static Address createAddresss2() {
		return new Address(9002,"James street","Mumbai");
	}
	
	@Bean("p1")
	public Person createPerson() {
		return new Person("Kishore",createAddresss1());
	}

}
