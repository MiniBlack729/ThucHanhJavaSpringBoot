package fpt.aptech.accountmangerproduct.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "userinrole")
public class UserInRole implements Serializable {
    @Id
    @Column
    private Long user_id;
    @Column
    private Long role_id;

    public UserInRole() {
    }

    public UserInRole(Long user_id, Long role_id) {
        this.user_id = user_id;
        this.role_id = role_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }
}
