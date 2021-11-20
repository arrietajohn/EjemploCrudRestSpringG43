/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.mintic.misiontic.usa.ciclo3.modolo.crud;

import co.gov.mintic.misiontic.usa.ciclo3.modolo.entidades.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jarri
 */
@Repository
public interface UsuarioCrudRepositorio extends CrudRepository<Usuario, String> {
    public List<Usuario> findAllByNombre(String nombre);
    public List<Usuario> findByNombreContaining(String palabra);
    public List<Usuario> findByEmailEndingWith(String palabra);
    @Query("SELECT u FROM Usuario u WHERE email is NULL")
    public List<Usuario> buscarSinEmail();
    
}
