/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.OpcionDao;
import Dao.OpcionDaoImplement;
import Model.SeopcOpcion;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Andres
 */
@ManagedBean
@Named(value = "opcionBean")
@ViewScoped
public class OpcionBean implements Serializable{
    
    private SeopcOpcion opcion;
    private List<SeopcOpcion> opciones;

    public OpcionBean() {
        opcion = new SeopcOpcion();
    }

    public SeopcOpcion getOpcion() {
        return opcion;
    }

    public void setOpcion(SeopcOpcion opcion) {
        this.opcion = opcion;
    }

    public List<SeopcOpcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<SeopcOpcion> opciones) {
        this.opciones = opciones;
    }
    
    public List<SeopcOpcion> getOpcionesXSistema(int codigoSistema) {
        OpcionDao linkDao = new OpcionDaoImplement();
        //opciones = linkDao.mostrarOpcionesPorSistema(codigoSistema);
        return opciones;
    }
    
    
    
    
    
}
