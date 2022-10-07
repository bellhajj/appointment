/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagudu.Appointment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bagudu.Appointment.model.Users;

/**
 *
 * @author bbagudu
 */
@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

    Users findByUsername(String username);
}
