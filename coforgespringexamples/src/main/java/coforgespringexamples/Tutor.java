package coforgespringexamples;
import java.util.*;
public class Tutor {
	
	String name;
	int exp;
	List<String> languages;
	Set<String> degrees;
	Map<String,String> country;
	
	
	@Override
	public String toString() {
		return "Tutor [name=" + name + ", exp=" + exp + ", languages=" + languages + ", degrees=" + degrees
				+ ", country=" + country + "]";
	}
	public Map<String, String> getCountry() {
		return country;
	}
	public void setCountry(Map<String, String> country) {
		this.country = country;
	}
	public Set<String> getDegrees() {
		return degrees;
	}
	public void setDegrees(Set<String> degrees) {
		this.degrees = degrees;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public List<String> getLanguages() {
		return languages;
	}
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
	

}
