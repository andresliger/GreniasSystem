package Model;
// Generated 11/02/2016 9:53:56 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * SesisSistem generated by hbm2java
 */
public class SesisSistem  implements java.io.Serializable {


     private Integer sesisCodsis;
     private String sesisDessis;
     private boolean sesisEstsis;
     private Set<SeopcOpcion> seopcOpcions = new HashSet<SeopcOpcion>(0);

    public SesisSistem() {
    }

	
    public SesisSistem(String sesisDessis, boolean sesisEstsis) {
        this.sesisDessis = sesisDessis;
        this.sesisEstsis = sesisEstsis;
    }
    public SesisSistem(String sesisDessis, boolean sesisEstsis, Set<SeopcOpcion> seopcOpcions) {
       this.sesisDessis = sesisDessis;
       this.sesisEstsis = sesisEstsis;
       this.seopcOpcions = seopcOpcions;
    }
   
    public Integer getSesisCodsis() {
        return this.sesisCodsis;
    }
    
    public void setSesisCodsis(Integer sesisCodsis) {
        this.sesisCodsis = sesisCodsis;
    }
    public String getSesisDessis() {
        return this.sesisDessis;
    }
    
    public void setSesisDessis(String sesisDessis) {
        this.sesisDessis = sesisDessis;
    }
    public boolean isSesisEstsis() {
        return this.sesisEstsis;
    }
    
    public void setSesisEstsis(boolean sesisEstsis) {
        this.sesisEstsis = sesisEstsis;
    }
    public Set<SeopcOpcion> getSeopcOpcions() {
        return this.seopcOpcions;
    }
    
    public void setSeopcOpcions(Set<SeopcOpcion> seopcOpcions) {
        this.seopcOpcions = seopcOpcions;
    }




}


