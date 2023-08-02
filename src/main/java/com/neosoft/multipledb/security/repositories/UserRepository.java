package com.neosoft.multipledb.security.repositories;


import com.neosoft.multipledb.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User Repository.
 *
 * @author Motilal  Kumar.
 *  version 1.0
 *
 */

public interface UserRepository extends JpaRepository<User, Integer> {


}
