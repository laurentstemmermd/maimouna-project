package com.qos.filters;

import com.qos.models.User;
import com.qos.services.LoginService;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter implements javax.servlet.Filter {
  public static final String CURRENT_USER_IN_REQUEST = "current_user";

  public void doFilter(final ServletRequest givenRequest,
                       final ServletResponse givenResponse,
                       FilterChain chain)
       throws java.io.IOException, javax.servlet.ServletException  {
      
    HttpServletRequest request = (HttpServletRequest) givenRequest;
    HttpServletResponse response = (HttpServletResponse) givenResponse;
    String requestURI = request.getRequestURI();
    
    User u = getCurrentUser(request);
    
    if (requestURI.startsWith("/admin/")) {
        if(u == null || u.getPrivilege() != User.Privilege.ADMIN) {
            forbiddenResponse(response);

        }
    } else if (requestURI.startsWith("/operator/")){
        if(u == null || u.getPrivilege() != User.Privilege.OPERATOR) {
            forbiddenResponse(response);
        }
    }
    
    chain.doFilter(givenRequest, response);
  }
  
  public static User getCurrentUser(HttpServletRequest request) {
      String email = (String) request.getSession().getAttribute(CURRENT_USER_IN_REQUEST);
      return new LoginService().getUser(email);
  }

  private void forbiddenResponse(HttpServletResponse response) 
          throws java.io.IOException {
    ServletOutputStream out = response.getOutputStream();
    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    out.write("Interdit".getBytes());
    out.flush();
    out.close();
  }

  private FilterConfig filterConfig;
  public void init(final FilterConfig filterConfig) {
    this.filterConfig = filterConfig;
  }

  public void destroy() {
  }
}
