package com.qos;

import com.qos.filters.AuthFilter;
import com.qos.models.User;
import com.qos.services.LoginService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    
    private final LoginService loginService = new LoginService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User u = loginService.login(request.getParameter("login"), request.getParameter("password"));
        
        if (u == null) {
            response.sendRedirect("/?error=true");
        } else {
            request.getSession().setAttribute(AuthFilter.CURRENT_USER_IN_REQUEST, request.getParameter("login"));
            if(u.getPrivilege() == User.Privilege.ADMIN) {
                response.sendRedirect("/admin/index");
            } else {
                response.sendRedirect("/operator/index");
            }
        }
    }

}
