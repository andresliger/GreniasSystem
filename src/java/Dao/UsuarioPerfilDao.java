/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.SeperPerfil;
import Model.SeusuUsuari;
import Model.SeuxpUsxper;
import java.util.List;

/**
 *
 * @author Andres
 */
public interface UsuarioPerfilDao {
    
    public SeperPerfil getPerfilFromUsuario(SeusuUsuari usuario);
    public void asignarPerfilUsuario(SeuxpUsxper usuario_x_perfil);
    public void revocarPerfilUsuario(SeuxpUsxper usuario_x_perfil) ;
    public List<SeusuUsuari> mostrarUsuariosPorPerfil(SeperPerfil perfil);

}
