package m2i.userauthentication;


public class User {
    
    // Properties
    private int id;
    private String lastName;
    private String firstName;
    private String role;
    private String email;
    private String password;

    
    // Constructors
    public User() {
    }

    public User(String lastName, String firstName, String role, String email, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.role = role;
        this.email = email;
        this.password = password;
    }
    

    // Getters
    public int getId() {
        return this.id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getRole() {
        return this.role;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
    
    
    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
