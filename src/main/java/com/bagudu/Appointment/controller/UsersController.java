/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagudu.Appointment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author bbagudu
 */
@Controller
public class UsersController {

    //@Autowired
    //private UsersService userService;
    //User register for appointment
    /*@RequestMapping("/register")
    public String home() {
        return "register";
    }

    //Registration Success Page
    @RequestMapping("/success")
    public String regSuccess() {
        return "reg_success";
    }

    //User registration Post
    @PostMapping("/user/book")
    public String bookUser(Users user) throws IOException {

        userService.saveUser(user);
        return "redirect:/success";
    }*/
    //Users Login Page
    @RequestMapping("/login")
    public String loginUser() {
        return "login";
    }

    //Users logout
    @GetMapping("/logout")
    public String logout() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
