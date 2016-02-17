/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.SeopcOpcion;
import Persistencia.NewHibernateUtil;
import Util.MyUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuElement;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Andres
 */
public class OpcionDaoImplement implements OpcionDao {

    @Override
    public void insertarOpcion(SeopcOpcion opcion) {

    }

    @Override
    public void modificarOpcion(SeopcOpcion opcion) {

    }

    @Override
    public void eliminarOpcion(SeopcOpcion opcion) {

    }

    @Override
    public SeopcOpcion buscarOpcion(SeopcOpcion opcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SeopcOpcion> mostrarSubOpciones(int codigoPadre) {

        Session session = null;
        List<SeopcOpcion> opciones = new ArrayList<>();

        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from SeopcOpcion O where O.seopcOpcion.seopcCodopc=:codigoOpcion");
            query.setParameter("codigoOpcion", codigoPadre);
            opciones = (List<SeopcOpcion>) query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return opciones;
    }

    @Override
    public void crearSubMenuItem(int menuPosition, boolean isTheEnd, int codigoPadre, DefaultSubMenu menuModel) {
        List<SeopcOpcion> auxLista = new ArrayList<>();
        auxLista = mostrarSubOpciones(codigoPadre);
        if (auxLista.isEmpty()) {
            isTheEnd = true;
        } else {
            for (int i = 0; i < auxLista.size(); i++) {
                if (auxLista.get(i).getSevenVentan().getCodigoVentana() == 3) { //Es hoja 
                    crearItem(auxLista.get(i), (DefaultSubMenu) menuModel.getElements().get(menuPosition));
                }
            }
        }
    }

    @Override
    public void crearMenu(int menuPosition, boolean isTheEnd, int codigoPadre, MenuModel menuModel) {
        List<SeopcOpcion> auxLista = new ArrayList<>();
        auxLista = mostrarSubOpciones(codigoPadre);
        if (auxLista.isEmpty()) {
            isTheEnd = true;
        } else {
            for (int i = 0; i < auxLista.size(); i++) {
                if (auxLista.get(i).getSevenVentan().getCodigoVentana() == 1) { //Es raiz
                    //crearItem(auxLista.get(i), (DefaultSubMenu) menuModel.getElements().get(menuPosition));
                    crearSubmenu(auxLista.get(i), menuModel);
                    crearMenu(i, false, auxLista.get(i).getSeopcCodopc(), menuModel);
                } else if (auxLista.get(i).getSevenVentan().getCodigoVentana() == 2) { //Es submenu
                    crearSubSubmenu(auxLista.get(i), (DefaultSubMenu) menuModel.getElements().get(menuPosition));
                    crearSubMenuItem(i, false, auxLista.get(i).getSeopcCodopc(),(DefaultSubMenu) menuModel.getElements().get(menuPosition));
                } else { //Es principal
                    //crearSubmenu(auxLista.get(i), menuModel);
                    //crearMenu(i, false, auxLista.get(i).getSeopcCodopc(), menuModel);
                    crearItem(auxLista.get(i), (DefaultSubMenu) menuModel.getElements().get(menuPosition));
                }
            }
        }
    }

    @Override
    public void crearSubmenu(SeopcOpcion opcion, MenuModel menuModel) {
        DefaultSubMenu submenu = new DefaultSubMenu(opcion.getSeopcNomopc());
        menuModel.addElement(submenu);
    }

    @Override
    public void crearItem(SeopcOpcion opcion, DefaultSubMenu submenu) {

        DefaultMenuItem item = new DefaultMenuItem(opcion.getSeopcNomopc());
        //String myUrl = MyUtil.basePathInicio() + opcion.getSevenVentan().getDescripcionVentana();
        String myUrl = MyUtil.basePathInicio() + opcion.getSeopcDesopc();
        item.setUrl(myUrl);
        submenu.addElement(item);

    }

    @Override
    public void crearSubSubmenu(SeopcOpcion opcion, DefaultSubMenu submenu) {

        MenuElement menuElement = new DefaultSubMenu(opcion.getSeopcNomopc());
        submenu.addElement(menuElement);        
    }

}
