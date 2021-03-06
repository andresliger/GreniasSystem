package Model;
// Generated 19/02/2016 10:05:19 by Hibernate Tools 4.3.1



/**
 * SeoppOpcperId generated by hbm2java
 */
public class SeoppOpcperId  implements java.io.Serializable {


     private int seperCodper;
     private int seopcCodopc;

    public SeoppOpcperId() {
    }

    public SeoppOpcperId(int seperCodper, int seopcCodopc) {
       this.seperCodper = seperCodper;
       this.seopcCodopc = seopcCodopc;
    }
   
    public int getSeperCodper() {
        return this.seperCodper;
    }
    
    public void setSeperCodper(int seperCodper) {
        this.seperCodper = seperCodper;
    }
    public int getSeopcCodopc() {
        return this.seopcCodopc;
    }
    
    public void setSeopcCodopc(int seopcCodopc) {
        this.seopcCodopc = seopcCodopc;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SeoppOpcperId) ) return false;
		 SeoppOpcperId castOther = ( SeoppOpcperId ) other; 
         
		 return (this.getSeperCodper()==castOther.getSeperCodper())
 && (this.getSeopcCodopc()==castOther.getSeopcCodopc());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getSeperCodper();
         result = 37 * result + this.getSeopcCodopc();
         return result;
   }   


}


