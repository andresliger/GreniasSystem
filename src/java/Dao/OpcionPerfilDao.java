/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.SeopcOpcion;
import Model.SeoppOpcper;
import Model.SeperPerfil;
import java.util.List;

/**
 *
 * @author Andres
 */
public interface OpcionPerfilDao {
    
    public SeopcOpcion mostrarOpcionPorPerfil(SeperPerfil perfil);
    public void asignarOpcionesPerfil(List<SeopcOpcion> opciones, List<SeperPerfil> perfiles);
    public void modificarOpcionesPerfil(List<SeopcOpcion> opciones, List<SeperPerfil> perfiles);
    public void eliminarOpcionesPerfil(List<SeopcOpcion> opciones, List<SeperPerfil> perfiles);
    
}
