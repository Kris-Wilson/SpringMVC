package com.mrlin.controller;

import com.mrlin.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @ResponseBody
    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public User getUser(@PathVariable String name) {
        User user = new User();
        user.setName(name);
        user.setId(1);
        return user;
    }
}
