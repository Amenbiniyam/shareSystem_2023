package com.act.sharemanagementApi.controller;

import com.act.sharemanagementApi.model.User;
import com.act.sharemanagementApi.service.JwtUserDetailsService;
import com.act.sharemanagementApi.service.UserService;
import com.act.sharemanagementApi.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class APIController {
    private final UserService userService;
   // private final ProductService productService;
    //private final CartItemService cartItemService;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    public APIController(UserService userService) {
        this.userService = userService;
     //   this.productService = productService;
        //this.cartItemService = cartItemService;
    }

    @PostMapping("/create-token")
    public ResponseEntity<?> createToken (@RequestBody Map<String, String> user) throws Exception {
        Map<String, Object> tokenResponse = new HashMap<>();
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(user.get("username"));
        final String token = jwtUtil.generateToken(userDetails);

        tokenResponse.put("token", token);
        return ResponseEntity.ok(tokenResponse);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers () {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser (@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser (@PathVariable("id") Long id, @RequestBody Map<String, Object> user) {
        User newUser = new User(
                (String) user.get("username"),
                (String) user.get("password"),
                (String) user.get("email"),
                (String) user.get("name"),
                (String) user.get("address")
        );

        return new ResponseEntity<>(userService.updateUser(id, newUser), HttpStatus.OK);
    }

//    @GetMapping("/users/{id}/cart")
//    public ResponseEntity<List<CartItem>> getUserCart (@PathVariable("id") Long id) {
//        System.out.println(userService.getUser(id).getCartItems().size());
//        return new ResponseEntity<>(userService.getUser(id).getCartItems(), HttpStatus.OK);
//    }

//    @PostMapping("/users/{id}/cart/add/{productId}")
//    public ResponseEntity<User> addToUserCart (@PathVariable("id") Long id,
//                                               @PathVariable("productId") Long productId) {
//        User user = userService.getUser(id);
//        Product product = productService.getProduct(productId);
//
//        CartItem cartItem = new CartItem(user, product, 1);
//        cartItemService.addCartItem(cartItem);
//
//        return new ResponseEntity<>(userService.getUser(id), HttpStatus.CREATED);
//    }





    @Transactional
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }







}
