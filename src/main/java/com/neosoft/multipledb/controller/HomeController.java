package com.neosoft.multipledb.controller;


import com.neosoft.multipledb.orders.entities.Order;
import com.neosoft.multipledb.security.entities.User;
import com.neosoft.multipledb.service.UserOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * HomeController.
 *
 * @author Motilal  Kumar.
 * version 1.0
 */

@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private UserOrdersService userOrdersService;

    @GetMapping("/get-users")
    public ResponseEntity<Map<String, List<Object>>> findAllUsers() {

        Map<String, List<Object>> map = new HashMap<>();

        List<User> userList = userOrdersService.getUsers();
        List<Order> orderList = userOrdersService.getOrders();

//        List<User> userList1 = Optional.of(userList).get();
//        List<Order> orderList1 = Optional.of(orderList).get();

        map.put("user", (List<Object>) (Object) userList);
        map.put("order", (List<Object>) (Object) orderList);

        return ResponseEntity.ok(map);
    }


   /* @GetMapping("/get-orders")
    public ResponseEntity<List<Order>> findAllOrders(){

        List<Order> userList = userOrdersService.getOrders();
        return ResponseEntity.ok(userList);
    }
*/



    /*  @GetMapping("/get-users")
    public List<User> findAllUsers(){
        return userOrdersService.getUsers();
    }
*/
  /*  @GetMapping("/get-orders")
    public List<Order> findAllOrders(){
        return userOrdersService.getOrders();
    }*/

}
