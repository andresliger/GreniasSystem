/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.PecliCliente;
import java.util.List;

/**
 *
 * @author Andresin
 */
public interface ClienteDao {
    
    public List<PecliCliente> mostrarClientes();

    public void insertarCliente(PecliCliente cliente);

    public void modificarCliente(PecliCliente cliente);

    public void eliminarCliente(PecliCliente cliente);
    
    public PecliCliente getClientePorId(int id);
}
