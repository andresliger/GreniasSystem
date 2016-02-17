/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.SeopcOpcion;
import java.util.List;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Andres
 */
public interface OpcionDao {
    public List<SeopcOpcion> mostrarSubOpciones(int codigoPadre);
    public void insertarOpcion(SeopcOpcion opcion);
    public void modificarOpcion(SeopcOpcion opcion);
    public void eliminarOpcion(SeopcOpcion opcion);
    public SeopcOpcion buscarOpcion(SeopcOpcion opcion);
    public void crearMenu(int menuPosition,boolean isTheEnd, int codigoPadre, MenuModel menuModel);
    public void crearSubmenu(SeopcOpcion opcion, MenuModel menuModel);
    public void crearItem(SeopcOpcion opcion, DefaultSubMenu submenu);
    public void crearSubSubmenu(SeopcOpcion opcion, DefaultSubMenu submenu ) ;
    public void crearSubMenuItem(int menuPosition, boolean isTheEnd, int codigoPadre, DefaultSubMenu menuModel);
    
}
