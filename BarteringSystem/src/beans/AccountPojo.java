package beans;

import java.util.Date;

public class AccountPojo {
	
	private int userId;
	
	private String emailId;
	
	private String password;
	
	private int loginAttempt;
	
	private String accountBlocked;
	
	private Date unblockTime;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLoginAttempt() {
		return loginAttempt;
	}
	public void setLoginAttempt(int loginAttempt) {
		this.loginAttempt = loginAttempt;
	}
	public String getAccountBlocked() {
		return accountBlocked;
	}
	public void setAccountBlocked(String accountBlocked) {
		this.accountBlocked = accountBlocked;
	}
	public Date getUnblockTime() {
		return unblockTime;
	}
	public void setUnblockTime(Date unblockTime) {
		this.unblockTime = unblockTime;
	}
	public AccountPojo(){
		
	}
	

}
