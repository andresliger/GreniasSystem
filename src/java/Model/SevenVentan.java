package Model;
// Generated 19/02/2016 10:05:19 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * SevenVentan generated by hbm2java
 */
public class SevenVentan  implements java.io.Serializable {


     private Integer sevenCodigo;
     private String sevenNombre;
     private String seveDescri;
     private Set<SeopcOpcion> seopcOpcions = new HashSet<SeopcOpcion>(0);

    public SevenVentan() {
    }

	
    public SevenVentan(String seveDescri) {
        this.seveDescri = seveDescri;
    }
    public SevenVentan(String sevenNombre, String seveDescri, Set<SeopcOpcion> seopcOpcions) {
       this.sevenNombre = sevenNombre;
       this.seveDescri = seveDescri;
       this.seopcOpcions = seopcOpcions;
    }
   
    public Integer getSevenCodigo() {
        return this.sevenCodigo;
    }
    
    public void setSevenCodigo(Integer sevenCodigo) {
        this.sevenCodigo = sevenCodigo;
    }
    public String getSevenNombre() {
        return this.sevenNombre;
    }
    
    public void setSevenNombre(String sevenNombre) {
        this.sevenNombre = sevenNombre;
    }
    public String getSeveDescri() {
        return this.seveDescri;
    }
    
    public void setSeveDescri(String seveDescri) {
        this.seveDescri = seveDescri;
    }
    public Set<SeopcOpcion> getSeopcOpcions() {
        return this.seopcOpcions;
    }
    
    public void setSeopcOpcions(Set<SeopcOpcion> seopcOpcions) {
        this.seopcOpcions = seopcOpcions;
    }




}


