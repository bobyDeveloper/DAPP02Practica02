/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package Practica02;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author boby
 */
public interface RepositoryEmpleado extends JpaRepository<Empleado, Long> {
    
}
