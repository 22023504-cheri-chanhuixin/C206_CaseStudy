/**
 * 
 */

/**
 * @author User
 *
 */
public class Admin {
		private String username;
		private int userID;
		private String password;
		private String contact;
		
		public Admin(String username, int userID, String password, String contact) {
			super();
			this.username = username;
			this.userID = userID;
			this.password = password;
			this.contact = contact;
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

		public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}

		public int getUserID() {
			return userID;
		}
		
		
		
	
}
