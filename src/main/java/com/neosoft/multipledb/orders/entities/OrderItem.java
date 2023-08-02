package com.neosoft.multipledb.orders.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Order Item Entity.
 *
 * @author Motilal  Kumar.
 *  version 1.0
 *
 */

@Entity
@Table(name="order_items")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String productCode;
    private int quantity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;


}
