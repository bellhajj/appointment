package com.bagudu.Appointment;

import com.bagudu.Appointment.model.Users;
import com.bagudu.Appointment.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AppointmentApplication {
    
    @Autowired
    private BCryptPasswordEncoder encoder;

    public static void main(String[] args) {
        SpringApplication.run(AppointmentApplication.class, args);
    }
    
    //Pregister Users
    @Bean
    public CommandLineRunner mappingDemo(UsersRepository usersRepository) {
        return args -> {
            usersRepository.save(new Users("Bello", "Bagudu", "bagudu", "08188645565", encoder.encode("password123"), "bagudu@outlook.com"));
            usersRepository.save(new Users("Michael", "Dawodu", "dawodu", "08089784523", encoder.encode("password123"), "dawodu@gmail.com"));
            usersRepository.save(new Users("Aliyu", "Bagudu", "aliyu", "08188645565", encoder.encode("password123"), "aliyu@outlook.com"));
            usersRepository.save(new Users("Anam-Ndu", "Ekpedeme", "ekpedeme", "08089784523", encoder.encode("password123"), "ekpedeme@gmail.com"));
        };
    }

}
