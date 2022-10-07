/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagudu.Appointment.repository;

import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bagudu.Appointment.model.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 *
 * @author bbagudu
 */
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    
    @Query(value = "SELECT COUNT(id) FROM Appointment WHERE appointmentDate=:appointmentDate AND center=:center AND appointmentTime=:appointmentTime")
    public Long numberCounter(@Param("appointmentDate") LocalDate appointmentDate, @Param("center") String center, @Param("appointmentTime") int appointmentTime);
}
