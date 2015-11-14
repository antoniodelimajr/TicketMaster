package br.com.core;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "FiltroAdmin", urlPatterns = {"/admin/*"})
public class FiltroAdmin implements Filter {
    
    public FiltroAdmin() {}    

    @Override
    public void init(FilterConfig filterConfig) {}
    
    @Override
    public void destroy() {}
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws 
            IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;        
        HttpSession sessao = req.getSession();
        
        LoginMB loginMB = (LoginMB) sessao.getAttribute("loginMB");                   

        if(loginMB != null && loginMB.getIsLogged()){
            if(loginMB.getLogin().getIsAdmin()){
                chain.doFilter(request, response);
            } else {
                resp.sendRedirect(req.getContextPath()+"/public/ultra/principal.jsf");
            }
            
        } else {
            resp.sendRedirect(req.getContextPath()+"/login.jsf");
        }        
    }
}
