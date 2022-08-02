package fpt.aptech.day2employees.model;

import javax.persistence.*;

@Entity
@Table
public class Employee {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column
    private String lastname;
    @Column
    private String firstname;
    @Column
    private String email;

    public Employee() {
    }

    public Employee(Long id, String lastname, String firstname, String email) {
        Id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
    }

    public Employee(String lastname, String firstname, String email) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
