package fpt.aptech.universityapp.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "department")
public class Department {
    @Id
    private String depid;
    @Column
    private String depname;
    @Column
    @OneToMany(mappedBy = "departmentbyid")
    private Collection<Employee>employeesById;


    public Collection<Employee> getEmployeesById() {
        return employeesById;
    }

    public void setEmployeesById(Collection<Employee> employeesById) {
        this.employeesById = employeesById;
    }

    public String getDepid() {
        return depid;
    }

    public void setDepid(String depid) {
        this.depid = depid;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }
}
