package fpt.aptech.day2camera.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "camera")
public class Camera {
    @Id
    @Column(unique = true)
    @NotBlank(message = "Id is required, cannot blank")
    private String id;
    @Column
    @NotBlank(message = "Name is required")
    private String name;
    @Column
    @NotNull(message = "Price is required")
    @Min(value = 100, message = "price must be greater than 100")
    private Integer price;

    public Camera() {
    }

    public Camera(String id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }


}
