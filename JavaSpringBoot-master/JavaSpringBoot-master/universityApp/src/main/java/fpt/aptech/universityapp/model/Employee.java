package fpt.aptech.universityapp.model;

import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    private Long id;
    @NotNull
    @Column
    private String empname;
    @NonNull
    @Column
    private int salary;
    @Column
    private  String phone;
    @JoinColumn(name = "departmentbyid", referencedColumnName = "depid")
    @ManyToOne
    private Department departmentbyid;

    public Employee() {
    }

    public Employee(Long id, String empname, int salary, String phone, Department departmentbyid) {
        this.id = id;
        this.empname = empname;
        this.salary = salary;
        this.phone = phone;
        this.departmentbyid = departmentbyid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Department getDepartmentbyid() {
        return departmentbyid;
    }

    public void setDepartmentbyid(Department departmentbyid) {
        this.departmentbyid = departmentbyid;
    }
}
