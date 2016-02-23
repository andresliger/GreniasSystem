/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.UsuarioDao;
import Dao.UsuarioDaoImplement;
import Model.SeusuUsuari;
import Util.EncryptUtil;
import Util.MyUtil;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Andres
 */
@ManagedBean
@Named(value = "usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {

    /**
     * Creates a new instance of UsuarioBean
     */
    SeusuUsuari usuario;
    List<SeusuUsuari> usuarios;

    public UsuarioBean() {
        usuario = new SeusuUsuari();
    }

    public SeusuUsuari getUsuario() {
        return usuario;
    }

    public void setUsuario(SeusuUsuari usuario) {
        this.usuario = usuario;
    }

    public List<SeusuUsuari> getUsuarios() {
        UsuarioDao linkDao = new UsuarioDaoImplement();
        usuarios = linkDao.mostrarUsuarios();
        return usuarios;

    }

    public void setUsuarios(List<SeusuUsuari> usuarios) {
        this.usuarios = usuarios;
    }

    public void insertar() {
        UsuarioDao linkDao = new UsuarioDaoImplement();
        linkDao.insertarUsuario(usuario);
        usuario = new SeusuUsuari();

    }

    public void modificar() {
        UsuarioDao linkDao = new UsuarioDaoImplement();
        linkDao.modificarUsuario(usuario);
        usuario = new SeusuUsuari();

    }

    public void eliminar() {
        UsuarioDao linkDao = new UsuarioDaoImplement();
        linkDao.eliminarUsuario(usuario);
        usuario = new SeusuUsuari();
    }

    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        String ruta = "";
        UsuarioDao linkDao = new UsuarioDaoImplement();
        SeusuUsuari myUserDB = linkDao.buscarUsuario(usuario.getSeusuNombre());

        if (myUserDB != null) {
            if (EncryptUtil.encriptarMD5(usuario.getSeusuPasswd()).equals(myUserDB.getSeusuPasswd())) {
                loggedIn = true;
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("remember", usuario.getSeusuLogged());
                myUserDB.setSeusuLogged(true);
                usuario = myUserDB;
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);

                modificar();
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", usuario.getSeusuNombre());
                ruta = MyUtil.basePathLogin() + "View/inicio.xhtml";
            } else {
                loggedIn = false;
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error de ingreso", "Usuario o contraseña incorrectos");
            }
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error de ingreso", "Usuario o contraseña incorrectos");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
        context.addCallbackParam("ruta", ruta);
    }

    public void logout() {
        String ruta = MyUtil.basePathLogin() + "index.xhtml";
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("isLogged", false);
        SeusuUsuari usuario = (SeusuUsuari) session.getAttribute("usuario");
        usuario.setSeusuLogged(false);
        this.usuario=usuario;
        modificar();
        session.invalidate();
        context.addCallbackParam("loggedOut", true);
        context.addCallbackParam("ruta", ruta);

    }

}
