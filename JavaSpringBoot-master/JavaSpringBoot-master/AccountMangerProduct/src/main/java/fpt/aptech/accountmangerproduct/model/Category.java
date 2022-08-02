package fpt.aptech.accountmangerproduct.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cat_name;

    public Category() {
    }

    public Category(Long id, String cat_name) {
        this.id = id;
        this.cat_name = cat_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCat_name() {
        return cat_name;
    }
}
