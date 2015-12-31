/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pearson;

import com.pearson.pdn.learningstudio.oauth.OAuthServiceFactory;
import com.pearson.pdn.learningstudio.oauth.config.OAuthConfig;
import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author Nathan Smith
 */
public class AuthenticationData implements Serializable {
    @SuppressWarnings(value={"config", "oAuthFactory"})
    private OAuthConfig config;
    private OAuthServiceFactory oAuthFactory;
    Map httpHeaders;
    String username;
    String password;
    private static final long serialVersionUID = 2;
    
    /**
     *
     * @param c
     * @param f
     * @param headers
     * @param u
     * @param p
     */
    public AuthenticationData(OAuthConfig c, OAuthServiceFactory f, Map headers, String u, String p) {
        this.config = c;
        this.oAuthFactory = f;
        this.username = u;
        this.password = p;
        this.httpHeaders = headers;
    }
    
    /**
     *
     * @param c
     */
    public void setConfig(OAuthConfig c)
    {
        this.config = c;
    }
    
    /**
     *
     * @param f
     */
    public void setFactory(OAuthServiceFactory f)
    {
        this.oAuthFactory = f;
    }
    
    /**
     *
     * @return
     */
    public OAuthConfig getConfig()
    {
        return this.config;
    }
    
    /**
     *
     * @return
     */
    public OAuthServiceFactory getFactory()
    {
        return this.oAuthFactory;
    }
    
    /**
     *
     * @param m
     */
    public void setHeaders(Map m)
    {
        this.httpHeaders = m;
    }
    
    /**
     *
     * @return
     */
    public Map getMapHttpHeaders()
    {
        return this.httpHeaders;
    }
}
