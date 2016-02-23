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
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Andres
 */
public class UsuarioPerfilImplement implements UsuarioPerfilDao {

    @Override
    public SeperPerfil getPerfilFromUsuario(SeusuUsuari usuario) {
        Session session = null;
        SeuxpUsxper usuarioDB = new SeuxpUsxper();
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //session.delete(cliente);
            Query query = session.createQuery("from SeuxpUsxper U where U.seusuUsuari.seusuNombre=:username order by U.seuxpFecasi desc");
            query.setParameter("username", usuario.getSeusuNombre());
            usuarioDB = (SeuxpUsxper) query.setMaxResults(1).uniqueResult();
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
    public void asignarPerfilUsuario(SeuxpUsxper usuario_x_perfil) {
        Session session = null;        
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(usuario_x_perfil);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void revocarPerfilUsuario(SeuxpUsxper usuario_x_perfil) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(usuario_x_perfil);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }        
        asignarPerfilUsuario(usuario_x_perfil);
        
    }

    @Override
    public List<SeusuUsuari> mostrarUsuariosPorPerfil(SeperPerfil perfil) {
        Session session = null;
        List<SeusuUsuari> lista = new ArrayList<>();
        List<SeuxpUsxper> listaUsuariosPerfil = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from SeuxpUsxper U where U.seperPerfil.seperCodper =:codigoPerfil");
            query.setParameter("username", perfil.getSeperCodper());
            listaUsuariosPerfil = query.list();
            for (int i = 0; i < listaUsuariosPerfil.size(); i++) {
                lista.add(listaUsuariosPerfil.get(i).getSeusuUsuari());
            }
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return lista;
    }

}
