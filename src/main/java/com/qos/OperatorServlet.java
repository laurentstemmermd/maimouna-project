package com.qos;

import com.qos.models.Log;
import com.qos.models.Site;
import com.qos.services.LogService;
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
    private final LogService logService = new LogService();
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        if (requestURI.startsWith("/operator/index")) {
            List<Site> sites = siteService.getAllSites();
            request.setAttribute("sites", sites);
            request.getRequestDispatcher("/WEB-INF/views/operator/index.jsp").forward(request, response);
            return;
        } else if (requestURI.startsWith("/operator/site")) {
            String siteName = request.getParameter("name");
            Site site = siteService.getSite(siteName);
            List<Log> logs = logService.getLogs(siteName);
            request.setAttribute("site", site);
            request.setAttribute("logs", logs);
            
            if (requestURI.startsWith("/operator/site/detail")) {
                request.getRequestDispatcher("/WEB-INF/views/site/index.jsp").forward(request, response);
                return;
            }
            
        }
        ServletOutputStream out = response.getOutputStream();
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        out.write("Cette page n'existe pas".getBytes());
        out.flush();
        out.close();
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
