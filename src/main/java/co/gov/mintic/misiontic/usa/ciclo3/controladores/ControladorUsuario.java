/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.mintic.misiontic.usa.ciclo3.controladores;

import co.gov.mintic.misiontic.usa.ciclo3.modolo.entidades.Usuario;
import co.gov.mintic.misiontic.usa.ciclo3.servicios.UsuarioServicio;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author jarri
 */
@RestController
@RequestMapping("/api")
public class ControladorUsuario {
    
    @Autowired
    UsuarioServicio userServicio;
    
    @GetMapping("/usuarios")
    public List<Usuario> mostrarTodo() {
        return userServicio.buscarTodo();
    }
    
    @GetMapping("/usuarios/{cc}")
    public Usuario mostrarPorCedula(@PathVariable("cc") String cedula) {
        return userServicio.buscarPorCedula(cedula);
    }
    
    @PostMapping("/usuarios")
    public ResponseEntity guardar(@RequestBody Usuario user) {
        userServicio.guadarUsuario(user);
        return ResponseEntity.status(201).build();
    }
    
    
    @GetMapping("/usuarios-nombre/{nombre}")
    public List<Usuario> mostrarPorNombre(@PathVariable String nombre){
        return userServicio.buscarUsuarioPorNombre(nombre);
    }
    
    @GetMapping("/usuarios-nombre-x/{palabra}")
    public List<Usuario> mostrarPorCoincidenciaDeNombre(@PathVariable String palabra){
        return userServicio.buscarUsuarioConNombreParcial(palabra);
    }
    
    @GetMapping("/usuarios-server-email/{server}")
    public List<Usuario> mostrarServerEmail(@PathVariable("server") String servidor){
        return userServicio.buscarPorServerEmail(servidor);
    }
    
    @GetMapping("/usuarios-sin-email")
    public List<Usuario> mostrarSinEmail(){
        return userServicio.buscarPorUsuarioSinEmail();
    }
    
   
    @DeleteMapping("usuarios/{id}")
    public ResponseEntity<?> emilinar(@PathVariable String id) {
         userServicio.eliminarUsuario(id);
        return ResponseEntity.status(204).build();
    }
    
}
