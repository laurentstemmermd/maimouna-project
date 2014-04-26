package com.qos.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter implements javax.servlet.Filter {
  private FilterConfig filterConfig;

  public void doFilter(final ServletRequest givenRequest,
                       final ServletResponse givenResponse,
                       FilterChain chain)
       throws java.io.IOException, javax.servlet.ServletException  {
      
    HttpServletRequest request = (HttpServletRequest) givenRequest;
    HttpServletResponse response = (HttpServletResponse) givenResponse;
    String requestURI = request.getRequestURI();
    
    if (requestURI.startsWith("/admin/")) {
        if(!checkIfAdmin(request)) {
            forbiddenResponse(response);

        }
    } else if (requestURI.startsWith("/operator/")){
        if(!checkIfOperator(request)) {
            forbiddenResponse(response);
        }
    }
    
    chain.doFilter(givenRequest, response);
  }

  private Boolean checkIfAdmin(HttpServletRequest request) {
      return false;
  }
  
  private Boolean checkIfOperator(HttpServletRequest request) {
      return false;
  }
  
  private void forbiddenResponse(HttpServletResponse response) 
          throws java.io.IOException {
    ServletOutputStream out = response.getOutputStream();
    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    out.write("Interdit".getBytes());
    out.flush();
    out.close();
  }

  public void init(final FilterConfig filterConfig) {
    this.filterConfig = filterConfig;
  }

  public void destroy() {
  }
}
