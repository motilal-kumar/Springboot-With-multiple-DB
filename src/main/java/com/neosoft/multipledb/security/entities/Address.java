package com.neosoft.multipledb.security.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Address Entity.
 *
 * @author Motilal  Kumar.
 *  version 1.0
 *
 */

@Entity
@Table(name="addresses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(nullable=false)
    private String city;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


}
