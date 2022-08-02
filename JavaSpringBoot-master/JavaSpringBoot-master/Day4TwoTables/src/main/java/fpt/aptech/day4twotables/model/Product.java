package fpt.aptech.day4twotables.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column
    private Long pro_id;
    @Column
    @NotNull(message = "Product Name can not blank")
    private String pro_name;
    @Column
    private int pro_price;
    @JoinColumn(name = "man_id", referencedColumnName = "man_id")
    @ManyToOne
    private Manufacturer man_id;

    public Product(Long pro_id, String pro_name, int pro_price, Manufacturer man_id) {
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.pro_price = pro_price;
        this.man_id = man_id;
    }

    public Product() {
    }

    public Long getPro_id() {
        return pro_id;
    }

    public void setPro_id(Long pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public int getPro_price() {
        return pro_price;
    }

    public void setPro_price(int pro_price) {
        this.pro_price = pro_price;
    }

    public Manufacturer getMan_id() {
        return man_id;
    }

    public void setMan_id(Manufacturer man_id) {
        this.man_id = man_id;
    }
}
