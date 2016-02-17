/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.SeperPerfil;
import Model.SeusuUsuari;
import Model.SeuxpUsxper;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Andres
 */
public class UsuarioPerfilImplement implements UsuarioPerfilDao{

    @Override
    public SeperPerfil getPerfilFromUsuario(SeusuUsuari usuario) {
        Session session = null;
        SeuxpUsxper usuarioDB = new SeuxpUsxper();
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //session.delete(cliente);
            Query query = session.createQuery("from SeuxpUsxper U where U.seusuUsuari.seusuNombre=:username");
            query.setParameter("username", usuario.getSeusuNombre());
            usuarioDB = (SeuxpUsxper)query.uniqueResult();
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return usuarioDB.getSeperPerfil();
        
    }

    @Override
    public void asignarPerfilUsuario(List<SeperPerfil> perfiles, List<SeusuUsuari> usuarios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void revocarPerfilUsuario(List<SeperPerfil> perfiles, List<SeusuUsuari> usuarios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
