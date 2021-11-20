/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.mintic.misiontic.usa.ciclo3.servicios;

import co.gov.mintic.misiontic.usa.ciclo3.modolo.crud.UsuarioCrudRepositorio;
import co.gov.mintic.misiontic.usa.ciclo3.modolo.entidades.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jarri
 */
@Service
public class UsuarioServicio {
    @Autowired
    UsuarioCrudRepositorio userRepo;
    
    public void guadarUsuario(Usuario alguien){
        userRepo.save(alguien);
    }
    
    public List<Usuario> buscarTodo(){
        return (List<Usuario>)userRepo.findAll();
    }
    /*
    public Optional<Usuario> buscarPorCedula(String cc){
        return userRepo.findById(cc);
    }
    */

     public Usuario buscarPorCedula(String cc){
        return userRepo.findById(cc).orElse(null);
    }
     
     public List<Usuario> buscarUsuarioPorNombre(String nombre){
         return userRepo.findAllByNombre(nombre);
     }
     
      public List<Usuario> buscarUsuarioConNombreParcial(String palabra){
         return userRepo.findByNombreContaining(palabra);
     }
      
      public List<Usuario> buscarPorServerEmail(String server){
          return userRepo.findByEmailEndingWith(server);
      }
      
      public List<Usuario> buscarPorUsuarioSinEmail(){
          return userRepo.buscarSinEmail();
      }
     
      public void eliminarUsuario(String cc){
          userRepo.deleteById(cc);
      }
      
     
     
    
}
