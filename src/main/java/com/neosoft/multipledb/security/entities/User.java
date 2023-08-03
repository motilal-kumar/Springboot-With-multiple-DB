package com.neosoft.multipledb.security.entities;


import jakarta.persistence.*;
import lombok.*;

/**
 * User Entity.
 *
 * @author Motilal  Kumar.
 *  version 1.0
 *
 */

@Data
@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false, unique=true)
    private String email;
    private boolean disabled;

}
