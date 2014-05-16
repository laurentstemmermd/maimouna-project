/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.qos.services.daos;

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
            final String sql = "SELECT NAME, PATH, TYPE FROM SITES";
            List<Site> result = new ArrayList<Site>();
            try {
                Connection c = dataSource.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next())  {
                    result.add(new Site(rs.getString(1), rs.getString(2), Parser.valueOf(rs.getString(3))));
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
		final String sql = "SELECT PATH, TYPE FROM SITES WHERE NAME = ?";

		try {
			Connection c = dataSource.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			rs.next();
			final String path = rs.getString(1);
			final String type = rs.getString(2);
			ps.close();

			return new Site(name, path, Parser.valueOf(type));
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
        
        public final Boolean addSite(String name, String path, String type) {
            final String sql = "INSERT INTO SITES(NAME, PATH, TYPE) VALUES (?, ?, ?);";

		try {
			Connection c = dataSource.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, name);
                        ps.setString(2, path);
                        ps.setString(3, type);
			int nb = ps.executeUpdate();
			ps.close();

			return nb == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
            
        }
}
