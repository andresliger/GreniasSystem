/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.ClienteDao;
import Dao.ClienteDaoImplement;
import Model.PecliCliente;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Andresin
 */
@ManagedBean
@Named(value = "clienteBean")
@ViewScoped

public class clienteBean implements Serializable{

    /**
     * Creates a new instance of clienteBean
     */
    private List<PecliCliente> clientes;
    private PecliCliente cliente;

    public clienteBean() {
        cliente = new PecliCliente();
    }

    public List<PecliCliente> getClientes() {
        ClienteDao linkDao = new ClienteDaoImplement();
        clientes = linkDao.mostrarClientes();
        return clientes;
    }

    public void setClientes(List<PecliCliente> clientes) {
        this.clientes = clientes;
    }

    public PecliCliente getCliente() {
        return cliente;
    }

    public void setCliente(PecliCliente cliente) {
        this.cliente = cliente;
    }

    public void insertar() {
        ClienteDao linkDao = new ClienteDaoImplement();
        linkDao.insertarCliente(cliente);
        cliente = new PecliCliente();
    }

    public void modificar() {
        ClienteDao linkDao = new ClienteDaoImplement();
        linkDao.modificarCliente(cliente);
        cliente = new PecliCliente();
    }

    public void eliminar() {
        ClienteDao linkDao = new ClienteDaoImplement();
        linkDao.eliminarCliente(cliente);
        cliente = new PecliCliente();
    }

}
