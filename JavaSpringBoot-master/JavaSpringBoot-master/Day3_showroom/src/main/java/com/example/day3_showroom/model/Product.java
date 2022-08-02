package com.example.day3_showroom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Product {
    @Id
    @Column
    private Long pro_id;
    @Column
    @NotEmpty(message = "Product name can not blank")
    private String pro_name;
    @Column
    @Min(value = 1, message = "price must be greater than zero")
    private int pro_price;
    @JoinColumn(name="man_id",referencedColumnName = "man_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Manufacturer man_id;
}
