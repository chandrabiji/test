package com.chandra.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
@Path("/customer")
public class GetCustomerService {
	@GET
	@Path("/{cno}")
	public String getCustomerName(@PathParam("cno")int cno)
	{
		String cname = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			PreparedStatement ps = con.prepareStatement("select cname from customer where cno=?");
			ps.setInt(1, cno);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				cname=rs.getString(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cname;
	}

}
