/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagudu.Appointment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bagudu.Appointment.model.Appointment;
import com.bagudu.Appointment.model.Users;
import com.bagudu.Appointment.repository.UsersRepository;
/**
 *
 * @author bbagudu
 */
@Service
public class UsersService {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void saveUser(Users user) {       
        
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);       

    }

    public Users findByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    public void updateUser(Users user, Appointment appointment) {

        user.setAppointment(appointment);
        userRepository.save(user);
    }

}
