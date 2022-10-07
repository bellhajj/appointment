/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagudu.Appointment.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bagudu.Appointment.model.Appointment;
import com.bagudu.Appointment.model.Users;
import com.bagudu.Appointment.service.AppointmentService;
import com.bagudu.Appointment.service.UsersService;

/**
 *
 * @author bbagudu
 */
@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UsersService userService;

    @RequestMapping("/book")
    public String bookAppointment() {
        return "book";
    }

    @PostMapping("/book/appointment")
    public String saveAppointment(Appointment appointment, RedirectAttributes redirAttrs, Principal principal) {

        boolean check = appointmentService.checkAppointmentDateAndTime(appointment);

        if (check == true) {

            redirAttrs.addFlashAttribute("error", "The choosen slot is filled up");
            return "redirect:/book";

        } else {

            appointmentService.saveAppointment(appointment);
            String username = principal.getName();
            Users user = userService.findByUsername(username);
            userService.updateUser(user, appointment);

            redirAttrs.addFlashAttribute("success", "Booked Successfully");
            return "redirect:/book";

        }
    }

    @RequestMapping("/booksuccess")
    public String bookSuccess() {
        return "booking_success";
    }

}
