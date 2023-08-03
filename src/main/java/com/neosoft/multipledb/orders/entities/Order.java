package com.neosoft.multipledb.orders.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/**
 * Order Entity.
 *
 * @author Motilal  Kumar.
 *  version 1.0
 *
 */

@Entity
@Table(name="orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(nullable=false, name="cust_name")
    private String customerName;
    @Column(nullable=false, name="cust_email")
    private String customerEmail;


}
