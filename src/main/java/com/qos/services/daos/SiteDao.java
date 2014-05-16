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

/**
 * User: nwong
 * Date: 8/30/13
 * Time: 11:28 AM
 */
@Service
public class SiteDao {

	@Resource
	private DataSource dataSource;

	public final Site getSite(String name) {

		final String sql = "SELECT PATH, TYPE FROM HELLO WHERE NAME = ?";

		try {
			Connection c = dataSource.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			rs.next();
			final String path = rs.getString(2);
			final String type = rs.getString(3);
			ps.close();

			return new Site(name, path, Parser.valueOf(type));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
