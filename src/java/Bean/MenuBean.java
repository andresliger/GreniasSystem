/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.OpcionDao;
import Dao.OpcionDaoImplement;
import Dao.OpcionPerfilDao;
import Dao.OpcionPerfilImplement;
import Dao.UsuarioPerfilDao;
import Dao.UsuarioPerfilImplement;
import Model.SeopcOpcion;
import Model.SeperPerfil;
import Model.SeusuUsuari;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Andres
 */
@ManagedBean
@ViewScoped
public class MenuBean implements Serializable {

    /**
     * Creates a new instance of MenuBean
     */
    private MenuModel model;

    public MenuBean() {
    }

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) facesContext.getExternalContext().getSession(true);
        SeusuUsuari usuario = (SeusuUsuari) sesion.getAttribute("usuario");
        cargarPrivilegios(usuario);
        
        
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void cargarPrivilegios(SeusuUsuari usuario) {
        
        SeperPerfil perfil= new SeperPerfil();
        SeopcOpcion opcion= new SeopcOpcion();
        UsuarioPerfilDao linkUsuPer = new UsuarioPerfilImplement();
        OpcionPerfilDao linkOpcPer = new OpcionPerfilImplement();
        OpcionDao linkOpcion = new OpcionDaoImplement();
        perfil=linkUsuPer.getPerfilFromUsuario(usuario);
        opcion=linkOpcPer.mostrarOpcionPorPerfil(perfil);
        linkOpcion.crearMenu(0,false,opcion.getSeopcCodopc() , model);
        
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }
    
    

}
