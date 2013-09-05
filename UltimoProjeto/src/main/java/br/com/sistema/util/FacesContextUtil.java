/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.util;

import javax.faces.context.FacesContext;
import org.hibernate.Session;

/**
 *
 * @author Marcos
 */
public class FacesContextUtil {
    
    private static final String HIBERNATE_SESSION = "hibernate_session";
    
    public static void setRequestSession(Session session){
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(HIBERNATE_SESSION, session);
    }

    public static Session getHRequestSession() {
        return (Session)FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(HIBERNATE_SESSION);
    } 
}
