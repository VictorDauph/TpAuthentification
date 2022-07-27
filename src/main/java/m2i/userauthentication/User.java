package m2i.userauthentication;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="utilisateurs")
public class User {
    
    // Properties
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY )
    @JsonProperty("id")
    private int id;
    
    @Column
    @JsonProperty("lastName")
    private String lastName;
    
    @Column
    @JsonProperty("firstName")
    private String firstName;
    
    @Column(
    columnDefinition="ENUM('normal', 'admin')"
    )
    @JsonProperty("role")
    private String role;
    
    @Column
    @JsonProperty("email")
    private String email;
    
    @Column(
        columnDefinition="VARCHAR(40)",
        nullable=false
    )
    @JsonProperty(value="password", access=Access.WRITE_ONLY)
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
    
    @Override
    public String toString() {
        return String.format(id+", utilisateur : "+ lastName+" "+firstName+" "+", email : "+email+", role : "+ role);
    }    
    
}
