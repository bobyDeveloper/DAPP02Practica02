/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package Practica02;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author boby
 */
@RestController
@RequestMapping("/api")
public class ControllerEmpleados {
    @Autowired
    private RepositoryEmpleado repositoryEmpleado;

    @GetMapping("/empleado/")
    public List<Empleado> list() {
        return repositoryEmpleado.findAll();
    }

    @GetMapping("/empleado/{id}")
    public Object get(@PathVariable Long id) {
        Optional<Empleado> resEmpleado=repositoryEmpleado.findById(id);
        if(resEmpleado.isPresent())
            return resEmpleado.get();
        else 
            return null;
    }

    @PutMapping("/empleado/{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Empleado empleadop) {
           Optional<Empleado> optionalPersona = repositoryEmpleado.findById(id);
        if (optionalPersona.isPresent()) {
            Empleado emp = optionalPersona.get();
            emp.setNombre(empleadop.getNombre());
            emp.setDireccion(empleadop.getDireccion());
            emp.setTelefono(empleadop.getTelefono());
            repositoryEmpleado.save(emp);
            return ResponseEntity.ok(emp);
        } else {
            return null;
        }
    }

    @PostMapping("/empleado/")
    public ResponseEntity<?> post(@RequestBody Empleado empleado) {
        repositoryEmpleado.save(empleado);
        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
         Optional<Empleado> resEmpleado = repositoryEmpleado.findById(id);
        if (resEmpleado.isPresent()) {
            repositoryEmpleado.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return null;
        }
    }
}