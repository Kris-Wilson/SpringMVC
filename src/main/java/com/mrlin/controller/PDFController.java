package com.mrlin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PDFController {

    @RequestMapping(value = "/pdf", method = RequestMethod.GET)
    public ModelAndView pdf() {
        //user data
        Map<String, String> userData = new HashMap<String, String>();
        userData.put("100", "Xiao.Lu");
        userData.put("102", "User 102");
        userData.put("301", "User 301");
        userData.put("400", "User 400");
        return new ModelAndView("UserSummary", "userData", userData);
    }
}
