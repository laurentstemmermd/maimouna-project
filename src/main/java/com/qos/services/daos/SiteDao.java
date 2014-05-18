/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.qos.services.daos;

import com.qos.models.Connector;
import com.qos.models.Parser;
import com.qos.models.Site;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 8/30/13
 * Time: 11:28 AM
 */
@Service
public class SiteDao {

	@Resource
	private DataSource dataSource;

        public final List<Site> getAllSites() {
            final String sql = "SELECT ID, NAME, HOST, USERNAME, PASSWORD, LOG_PATH, LOG_TYPE, CONNECTION_TYPE FROM SITES";
            List<Site> result = new ArrayList<Site>();
            try {
                Connection c = dataSource.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next())  {
                    result.add(new Site(
                            rs.getInt("ID"),
                            rs.getString("NAME"), 
                            rs.getString("HOST"), 
                            rs.getString("USERNAME"), 
                            rs.getString("PASSWORD"), 
                            rs.getString("LOG_PATH"),  
                            Parser.valueOf(rs.getString("LOG_TYPE")),  
                            Connector.valueOf(rs.getString("CONNECTION_TYPE"))
                        ));
                }
                rs.close();
                ps.close();
                c.close();
                return result;
            } catch (SQLException e) {
                    e.printStackTrace();
            }

            return null;
        }
        
	public final Site getSite(String name) {
		final String sql = "SELECT ID, NAME, HOST, USERNAME, PASSWORD, LOG_PATH, LOG_TYPE, CONNECTION_TYPE FROM SITES WHERE NAME = ?";

		try {
			Connection c = dataSource.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			rs.next();

			Site site = new Site(
                            rs.getInt("ID"),
                            rs.getString("NAME"), 
                            rs.getString("HOST"), 
                            rs.getString("USERNAME"), 
                            rs.getString("PASSWORD"), 
                            rs.getString("LOG_PATH"),  
                            Parser.valueOf(rs.getString("LOG_TYPE")),  
                            Connector.valueOf(rs.getString("CONNECTION_TYPE"))
                        );
                        rs.close();
			ps.close();
                        return site;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
        
        public final Boolean removeSite(String name) {
            final String sql = "DELETE FROM SITES WHERE NAME = ?";

		try {
			Connection c = dataSource.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, name);
			int nb = ps.executeUpdate();
			ps.close();

			return nb == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
            
        }
        
        public final Boolean addSite(
                String name, 
                String host, 
                String userName, 
                String password, 
                String logPath, 
                String logType, 
                String connectionType) {

            final String sql = "INSERT INTO SITES(name, host, username, password, log_path, log_type, connection_type) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?);";

            try {
                    Connection c = dataSource.getConnection();
                    PreparedStatement ps = c.prepareStatement(sql);
                    ps.setString(1, name);
                    ps.setString(2, host);
                    ps.setString(3, userName);
                    ps.setString(4, password);
                    ps.setString(5, logPath);
                    ps.setString(6, logType);
                    ps.setString(7, connectionType);
                    
                    int nb = ps.executeUpdate();
                    ps.close();

                    return nb == 1;
            } catch (SQLException e) {
                    e.printStackTrace();
            }

            return false;
        }
}
