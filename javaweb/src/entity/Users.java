package entity;
/*
 * 
 * */
public class Users {
   private int userid;
   private String username;
   private String password;
   private int power;
   private String sex;
   private String text;
   
   public  Users(){
	   
   }
   public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}
   public Users(String username, String password, int power, String sex, String text ) {
		this.username = username;
		this.password = password;
		this.power = power;
		this.sex = sex;
		this.text = text;
	}
   
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public int getPower() {
	return power;
}
public void setPower(int power) {
	this.power = power;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}

   
   
}
