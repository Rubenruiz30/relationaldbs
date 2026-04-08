package relationaldbs.model;

import java.util.jar.Attributes.Name;

public class user {
//Fields
	private String name;
	private String surname;
	private double balance;
	private String password;
	private String residence;
	private String login;
	private String memoryLogin;
	private boolean singup;
	
//Methods

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMemoryLogin() {
		return memoryLogin;
	}

	public void setMemoryLogin(String memoryLogin) {
		this.memoryLogin = memoryLogin;
	}

	public boolean isSingup() {
		return singup;
	}

	public void setSingup(boolean singup) {
		this.singup = singup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
//Constructors
	public  user(String name, String surname, double balance) {
		this.name = name;
		this.surname = surname;
		this.balance = balance;
	}

}
