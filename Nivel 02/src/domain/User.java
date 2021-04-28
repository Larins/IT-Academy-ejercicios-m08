package domain;
import java.util.*;

public class User {
	
	public static String name;
	public static String surname;
	public static String regDate;

	
	public User(String name, String surname, String regDate) {
		this.name = name;
		this.surname = surname;
		this.regDate = regDate;

	}
	
	public String getname() {
		return name;
	}
	
	public String getsurname() {
		return surname;
	}
	
	public String getregDate() {
		return regDate;
	}
	
	public static void main(String[] args) {
	}

}
