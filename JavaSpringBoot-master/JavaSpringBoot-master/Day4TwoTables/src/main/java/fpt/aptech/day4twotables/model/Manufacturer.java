package fpt.aptech.day4twotables.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Manufacturer")
public class Manufacturer {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long man_id;
    @Column
    private String man_name;

    public Manufacturer(Long man_id, String man_name) {
        this.man_id = man_id;
        this.man_name = man_name;
    }

    public Manufacturer() {
    }

    public Long getMan_id() {
        return man_id;
    }

    public void setMan_id(Long man_id) {
        this.man_id = man_id;
    }

    public String getMan_name() {
        return man_name;
    }

    public void setMan_name(String man_name) {
        this.man_name = man_name;
    }
}
