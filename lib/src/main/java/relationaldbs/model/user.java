package relationaldbs.model;

public class User {
//Fields
	private String name;
	private String surname;
	private double balance;
	private String password;
	private String residence;
	private boolean login;
	private String nicknameString;
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

	public boolean getLogin() {
		return login;
	}

	public void setLogin(Boolean login) {
		this.login = login;
	}

	public String getMemoryLogin() {
		return nicknameString;
	}

	public void setMemoryLogin(String memoryLogin) {
		this.nicknameString = memoryLogin;
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
	public  User(String name, String surname, double balance,String password, String residence, Boolean login, String memorylogin, boolean singup) {
		this.name = name;
		this.surname = surname;
		this.balance = balance;
		this.password = password;
		this.residence = residence;
		this.login = login;
		this.nicknameString = memorylogin;
		this.singup = singup;
	}
	

}
