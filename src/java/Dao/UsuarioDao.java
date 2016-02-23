/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.SeperPerfil;
import Model.SeusuUsuari;
import java.util.List;

/**
 *
 * @author Andres
 */
public interface UsuarioDao {
    
    public List<SeusuUsuari> mostrarUsuarios();
    public void insertarUsuario(SeusuUsuari usuario);
    public void modificarUsuario(SeusuUsuari usuario);
    public void eliminarUsuario(SeusuUsuari usuario);
    public SeusuUsuari buscarUsuario(String usuario);
    
}
