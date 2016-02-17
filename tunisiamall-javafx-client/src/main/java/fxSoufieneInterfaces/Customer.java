package fxSoufieneInterfaces;

import java.util.Date;




public class Customer {
	
	private int ID;

	private String Address;


	private Date Birthdate;

	private String FirstName;

	private String Gender;

	private String Job;

	private String LastName;

	private String Login;

	private String Email;

	private String Password;

	private String Phone;

	private String PictureUrl;

	private String FacturationAddr;

	private String ShipementAddr;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Date getBirthdate() {
		return Birthdate;
	}

	public void setBirthdate(Date birthdate) {
		Birthdate = birthdate;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getJob() {
		return Job;
	}

	public void setJob(String job) {
		Job = job;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getPictureUrl() {
		return PictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		PictureUrl = pictureUrl;
	}

	public String getFacturationAddr() {
		return FacturationAddr;
	}

	public void setFacturationAddr(String facturationAddr) {
		FacturationAddr = facturationAddr;
	}

	public String getShipementAddr() {
		return ShipementAddr;
	}

	public void setShipementAddr(String shipementAddr) {
		ShipementAddr = shipementAddr;
	}
	
}
