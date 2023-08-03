package com.neosoft.multipledb.orders.repositories;


import com.neosoft.multipledb.orders.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * OrderRepository.
 *
 * @author Motilal Kumar.
 *  version 1.0
 *
 */

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
