/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.SeopcOpcion;
import Model.SeoppOpcper;
import Model.SeperPerfil;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Andres
 */
public class OpcionPerfilImplement implements OpcionPerfilDao {

    @Override
    public SeopcOpcion mostrarOpcionPorPerfil(SeperPerfil perfil) {
        Session session = null;
        SeoppOpcper opcionDB=new SeoppOpcper();
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //"from Pedet P left join fetch P.peartArticulo left join fetch P.pevntVentas"
            Query query = session.createQuery("from SeoppOpcper A left join fetch A.seperPerfil left join fetch A.seopcOpcion where A.seperPerfil.seperCodper=:codigoPerfil");
            query.setParameter("codigoPerfil", perfil.getSeperCodper());
            opcionDB = (SeoppOpcper)query.uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return opcionDB.getSeopcOpcion();
    }

    @Override
    public void asignarOpcionesPerfil(List<SeopcOpcion> opciones, List<SeperPerfil> perfiles) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarOpcionesPerfil(List<SeopcOpcion> opciones, List<SeperPerfil> perfiles) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarOpcionesPerfil(List<SeopcOpcion> opciones, List<SeperPerfil> perfiles) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
