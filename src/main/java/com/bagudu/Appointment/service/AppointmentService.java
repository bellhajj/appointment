/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagudu.Appointment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.Appointment.model.Appointment;
import com.bagudu.Appointment.repository.AppointmentRepository;

/**
 *
 * @author bbagudu
 */
@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public void saveAppointment(Appointment appointment) {

        appointmentRepository.save(appointment);
    }
    
    /*
        Check if the date, time and center has already been booked
    */
    public boolean checkAppointmentDateAndTime(Appointment appointment) {       
      
        
        Long numberOfSameDateTimeAndCenter =  appointmentRepository.numberCounter(appointment.getAppointmentDate(), appointment.getCenter(), appointment.getAppointmentTime());
        
        return numberOfSameDateTimeAndCenter >= 3;

    }

}
