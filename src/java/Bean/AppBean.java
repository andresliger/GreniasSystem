/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Util.MyUtil;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Andres
 */
@ManagedBean
@ApplicationScoped
public class AppBean {

    /**
     * Creates a new instance of AppBean
     */
    public AppBean() {
    }
    
    public String getBaseURL()
    {
        return MyUtil.baseURL();
    }
}
