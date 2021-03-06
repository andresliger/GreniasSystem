package Model;
// Generated 19/02/2016 10:05:19 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * SeoppOpcper generated by hbm2java
 */
public class SeoppOpcper  implements java.io.Serializable {


     private SeoppOpcperId id;
     private SeopcOpcion seopcOpcion;
     private SeperPerfil seperPerfil;
     private Date seoppFecasi;
     private boolean seoppEstad;
     private SepriPrivil sepriPrivil;

    public SeoppOpcper() {
    }

	
    public SeoppOpcper(SeoppOpcperId id, SeopcOpcion seopcOpcion, SeperPerfil seperPerfil, Date seoppFecasi, boolean seoppEstad) {
        this.id = id;
        this.seopcOpcion = seopcOpcion;
        this.seperPerfil = seperPerfil;
        this.seoppFecasi = seoppFecasi;
        this.seoppEstad = seoppEstad;
    }
    public SeoppOpcper(SeoppOpcperId id, SeopcOpcion seopcOpcion, SeperPerfil seperPerfil, Date seoppFecasi, boolean seoppEstad, SepriPrivil sepriPrivil) {
       this.id = id;
       this.seopcOpcion = seopcOpcion;
       this.seperPerfil = seperPerfil;
       this.seoppFecasi = seoppFecasi;
       this.seoppEstad = seoppEstad;
       this.sepriPrivil = sepriPrivil;
    }
   
    public SeoppOpcperId getId() {
        return this.id;
    }
    
    public void setId(SeoppOpcperId id) {
        this.id = id;
    }
    public SeopcOpcion getSeopcOpcion() {
        return this.seopcOpcion;
    }
    
    public void setSeopcOpcion(SeopcOpcion seopcOpcion) {
        this.seopcOpcion = seopcOpcion;
    }
    public SeperPerfil getSeperPerfil() {
        return this.seperPerfil;
    }
    
    public void setSeperPerfil(SeperPerfil seperPerfil) {
        this.seperPerfil = seperPerfil;
    }
    public Date getSeoppFecasi() {
        return this.seoppFecasi;
    }
    
    public void setSeoppFecasi(Date seoppFecasi) {
        this.seoppFecasi = seoppFecasi;
    }
    public boolean isSeoppEstad() {
        return this.seoppEstad;
    }
    
    public void setSeoppEstad(boolean seoppEstad) {
        this.seoppEstad = seoppEstad;
    }
    public SepriPrivil getSepriPrivil() {
        return this.sepriPrivil;
    }
    
    public void setSepriPrivil(SepriPrivil sepriPrivil) {
        this.sepriPrivil = sepriPrivil;
    }




}


