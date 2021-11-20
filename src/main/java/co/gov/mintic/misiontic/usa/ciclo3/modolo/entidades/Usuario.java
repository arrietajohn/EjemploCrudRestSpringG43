/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.mintic.misiontic.usa.ciclo3.modolo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author JOHN CARLOS ARRIETA ARRIETA
 */
@Entity
@Table(name="TablaUser")

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    // GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 20)
    private String cedula; 
    @Column(length = 20, name = "password")
    private String clave;
    @Column(length = 100)
    private String nombre;
    @Column(length = 70, unique = true)
    private String email;
    
    // SETTER Y GETTER

    public Usuario(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public Usuario() {
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.mintic.misiontic.usa.ciclo3.modolo.entidades.Usuario[ id=" + cedula + " ]";
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
