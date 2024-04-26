/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package Practica02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author boby
 */
@RestController
@RequestMapping("/holamundo")
public class HolaController {
    
    @GetMapping
    public String holamundo(){
        return "Hola Mundo";
    }
    
}
