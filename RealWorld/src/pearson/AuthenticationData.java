/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pearson;

import com.pearson.pdn.learningstudio.oauth.OAuthServiceFactory;
import com.pearson.pdn.learningstudio.oauth.config.OAuthConfig;
import java.util.Map;

/**
 *
 * @author Nathan Smith
 */
public class AuthenticationData {
    private OAuthConfig config;
    private OAuthServiceFactory oAuthFactory;
    Map httpHeaders;
    String username;
    String password;
    
    public AuthenticationData(OAuthConfig c, OAuthServiceFactory f, Map headers, String u, String p) {
        this.config = c;
        this.oAuthFactory = f;
        this.username = u;
        this.password = p;
        this.httpHeaders = headers;
    }
    
    public void setConfig(OAuthConfig c)
    {
        this.config = c;
    }
    
    public void setFactory(OAuthServiceFactory f)
    {
        this.oAuthFactory = f;
    }
    
    public OAuthConfig getConfig()
    {
        return this.config;
    }
    
    public OAuthServiceFactory getFactory()
    {
        return this.oAuthFactory;
    }
    
    public void setHeaders(Map m)
    {
        this.httpHeaders = m;
    }
    
    public Map getMapHttpHeaders()
    {
        return this.httpHeaders;
    }
}
