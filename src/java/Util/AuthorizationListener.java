/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Model.SeusuUsuari;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andres
 */
public class AuthorizationListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        String currentPage = facesContext.getViewRoot().getViewId();
        boolean isLoginPage = (currentPage.lastIndexOf("index.xhtml") > -1) ? true : false;
        boolean isRememeberLogin = false;
        HttpSession sesion = (HttpSession) facesContext.getExternalContext().getSession(true);
        SeusuUsuari usuario = (SeusuUsuari) sesion.getAttribute("usuario");

        if (!isLoginPage && usuario == null) {
            NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
            nh.handleNavigation(facesContext, null, "/index.xhtml");
        } else if (isLoginPage && usuario != null) {
            if (usuario.getSeusuLogged()) {
                NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
                nh.handleNavigation(facesContext, null, "/View/inicio.xhtml");
            }
        } else if (!isLoginPage && usuario != null) {
            isRememeberLogin = (Boolean) sesion.getAttribute("remember");
            if (!isRememeberLogin && !usuario.getSeusuLogged()) {
                NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
                nh.handleNavigation(facesContext, null, "/index.xhtml");
            }
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
