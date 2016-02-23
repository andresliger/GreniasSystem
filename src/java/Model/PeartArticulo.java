package Model;
// Generated 19/02/2016 10:05:19 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * PeartArticulo generated by hbm2java
 */
public class PeartArticulo  implements java.io.Serializable {


     private int peartNumart;
     private String peartNomart;
     private String peartDescri;
     private BigDecimal peartPreart;
     private int peartCantid;
     private Set<PedetDetalle> pedetDetalles = new HashSet<PedetDetalle>(0);

    public PeartArticulo() {
    }

	
    public PeartArticulo(int peartNumart, String peartNomart, String peartDescri, BigDecimal peartPreart, int peartCantid) {
        this.peartNumart = peartNumart;
        this.peartNomart = peartNomart;
        this.peartDescri = peartDescri;
        this.peartPreart = peartPreart;
        this.peartCantid = peartCantid;
    }
    public PeartArticulo(int peartNumart, String peartNomart, String peartDescri, BigDecimal peartPreart, int peartCantid, Set<PedetDetalle> pedetDetalles) {
       this.peartNumart = peartNumart;
       this.peartNomart = peartNomart;
       this.peartDescri = peartDescri;
       this.peartPreart = peartPreart;
       this.peartCantid = peartCantid;
       this.pedetDetalles = pedetDetalles;
    }
   
    public int getPeartNumart() {
        return this.peartNumart;
    }
    
    public void setPeartNumart(int peartNumart) {
        this.peartNumart = peartNumart;
    }
    public String getPeartNomart() {
        return this.peartNomart;
    }
    
    public void setPeartNomart(String peartNomart) {
        this.peartNomart = peartNomart;
    }
    public String getPeartDescri() {
        return this.peartDescri;
    }
    
    public void setPeartDescri(String peartDescri) {
        this.peartDescri = peartDescri;
    }
    public BigDecimal getPeartPreart() {
        return this.peartPreart;
    }
    
    public void setPeartPreart(BigDecimal peartPreart) {
        this.peartPreart = peartPreart;
    }
    public int getPeartCantid() {
        return this.peartCantid;
    }
    
    public void setPeartCantid(int peartCantid) {
        this.peartCantid = peartCantid;
    }
    public Set<PedetDetalle> getPedetDetalles() {
        return this.pedetDetalles;
    }
    
    public void setPedetDetalles(Set<PedetDetalle> pedetDetalles) {
        this.pedetDetalles = pedetDetalles;
    }




}


