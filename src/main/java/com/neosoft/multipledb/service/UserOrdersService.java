package com.neosoft.multipledb.service;


import com.neosoft.multipledb.orders.entities.Order;
import com.neosoft.multipledb.orders.repositories.OrderRepository;
import com.neosoft.multipledb.security.entities.User;
import com.neosoft.multipledb.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * UserOrderService.
 *
 * @author Motilal  Kumar.
 *  version 1.0
 *
 */

@Service
public class UserOrdersService {

    @Autowired
    private OrderRepository orderRepository;

     @Autowired
    private UserRepository userRepository;

    @Transactional(transactionManager="securityTransactionManager")
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    @Transactional(transactionManager="ordersTransactionManager")
    public List<Order> getOrders()
    {
        return orderRepository.findAll();
    }


}
