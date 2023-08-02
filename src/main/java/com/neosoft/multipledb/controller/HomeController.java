package com.neosoft.multipledb.controller;


import com.neosoft.multipledb.orders.entities.Order;
import com.neosoft.multipledb.security.entities.User;
import com.neosoft.multipledb.service.UserOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * HomeController.
 *
 * @author Motilal  Kumar.
 *  version 1.0
 *
 */

@RestController
@RequestMapping("/api")
public class HomeController {


    @Autowired
    private UserOrdersService userOrdersService;

    @GetMapping("/get-users")
    public List<User> findAllUsers(){
        return userOrdersService.getUsers();
    }

    @GetMapping("/get-orders")
    public List<Order> findAllOrders(){
        return userOrdersService.getOrders();
    }

}
