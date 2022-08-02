package fpt.aptech.accountmangerproduct.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;
    @Column
    //ko dat name co _ ko se ko dung dc Query findAllByName ben ProductRepository, loi .UnsatisfiedDependencyException
    private String productname;
    @Column
    private int price;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id") //tham chieu toi cot id cua tb category
    private Category category_id;

    public Product() {
    }

    public Product(Long product_id, String productname, int price, Category category_id) {
        this.product_id = product_id;
        this.productname = productname;
        this.price = price;
        this.category_id = category_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }
}
