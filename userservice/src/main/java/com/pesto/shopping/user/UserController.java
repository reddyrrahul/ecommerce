package com.pesto.shopping.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public ResponseEntity<UserBean> getUser(@PathVariable("userId") Long userId) {
        return new ResponseEntity<UserBean>(userService.getUser(userId), HttpStatus.OK);
    }


    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<UserBean> addUser(@RequestBody UserBean userBean) {
        return new ResponseEntity<UserBean>(userService.addUser(userBean), HttpStatus.OK);
    }


    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public ResponseEntity<UserBean> upDateUser(@RequestBody UserBean userBean) {
        return new ResponseEntity<UserBean>(userService.updateUser(userBean), HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
    }

}
