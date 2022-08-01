package atos.upgrade.restapimssql.model;



import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private String emailid;

    public Employee() {
    }

    public Employee(long id, String firstName, String lastName, String emailid) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailid = emailid;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email_address", nullable = false)
    public String getEmailId() {
        return emailid;
    }
    public void setEmailId(String emailID) {
        this.emailid = emailID;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailid
                + "]";
    }
}
