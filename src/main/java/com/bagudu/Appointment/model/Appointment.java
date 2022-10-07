/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagudu.Appointment.model;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;

/**
 *
 * @author bbagudu
 */
@Entity
public class Appointment implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate appointmentDate;

    private int appointmentTime;
    
    private String center;
    

    @JsonBackReference
    @OneToOne(mappedBy = "appointment")
    private Users user;

    public Appointment() {

    }

    public Appointment(LocalDate appointmentDate, int appointmentTime) {
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public Users getUser() {
        return user;
    }

    public void setAppointmentTime(int appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public int getAppointmentTime() {
        return appointmentTime;
    }
    
    public void setCenter(String center){
        this.center = center;
    }
    
    public String getCenter(){
        return center;
    }
}
