/**
 * 
 */

/**
 * @author User
 *
 */
public class User {
  private String username;
  private int userID;
  private String password;
  private String email;
  private String role;
  
  public User(String username, int userID, String password, String email, String role) {
    super();
    this.username = username;
    this.userID = userID;
    this.password = password;
    this.email = email;
    this.role = role;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public int getUserID() {
    return userID;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getRole() {
    return role;
  }
  
  public void setRole(String role) {
    this.role = role;
  }


}