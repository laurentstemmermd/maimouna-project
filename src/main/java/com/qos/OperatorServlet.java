package com.qos;

import com.qos.models.Site;
import com.qos.services.SiteService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OperatorServlet extends HttpServlet {
    
    private final SiteService siteService = new SiteService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Site> sites = siteService.getAllSites();
        request.setAttribute("sites", sites);
        request.getRequestDispatcher("/WEB-INF/views/operator/index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        out.write("Interdit".getBytes());
        out.flush();
        out.close();
    }

}
