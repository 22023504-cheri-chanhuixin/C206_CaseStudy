/**
 * 
 */

/**
 * @author User
 *
 */
public class User {
	private String username;
	private String userID;
	private String password;
	private String contact;
	private String role;
	
	public User(String username, String userID, String password, String contact, String role) {
		super();
		this.username = username;
		this.userID = userID;
		this.password = password;
		this.contact = contact;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	

}
