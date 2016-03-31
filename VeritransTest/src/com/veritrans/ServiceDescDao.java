package com.veritrans;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ServiceDescDao {
	
	DatabaseAccess data;
	Connection connection;
	
	public ServiceDescDao() throws URISyntaxException{
		try{
			data=new DatabaseAccess();
			connect();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	private void connect() throws SQLException, URISyntaxException
	{
		try
		{
			data.connect();
			connection = data.connection;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public int getRecordCount()
	{
		PreparedStatement st;
		int l=-1;
		try{
			String sql="SELECT COUNT(*) FROM VT_SERVICES";
			st=connection.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				l=rs.getInt(1);
			}
			data.disconnect();
			return l;
			
		  }
		catch(Exception e)
		{
			e.printStackTrace();
			st=null;
			return -1;
		}
	}
	
	public ServiceDesc getResultOfNameSearch(String name)
	{
		PreparedStatement st;
		ServiceDesc serv=new ServiceDesc();
		try{
			String sql="SELECT * FROM VT_SERVICES WHERE NAME ='"+name+"'";
			st=connection.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				serv.setId(rs.getInt(1));
				serv.setName(rs.getString(2));
				serv.setImage(rs.getString(3));
				serv.setDescription(rs.getString(4));
				if(Integer.parseInt(rs.getString(5))==0)
					serv.setBranding(false);
				else
					serv.setBranding(true);
				serv.setRating(rs.getFloat(6));
				if((int)rs.getFloat(7)==0)
					serv.setSetup_fee(false);
				else
					serv.setSetup_fee(true);
				serv.setTransaction_fee(rs.getString(8));
				serv.setHow_to_url(rs.getString(9));
				serv.setCurrencies(rs.getString(10));
				
			}
			data.disconnect();
			return serv;		
		}
		catch(Exception e){
			e.printStackTrace();
			st=null;
			return null;
		}
	}
	
	public ArrayList<ServiceDesc> getList()
	{
		PreparedStatement st;
		ArrayList<ServiceDesc> list=new ArrayList<ServiceDesc>();
		try{
			String sql="SELECT * FROM VT_SERVICES";
			st=connection.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				ServiceDesc serv=new ServiceDesc();
				serv.setId(rs.getInt(1));
				serv.setName(rs.getString(2));
				serv.setImage(rs.getString(3));
				serv.setDescription(rs.getString(4));
				if(Integer.parseInt(rs.getString(5))==0)
					serv.setBranding(false);
				else
					serv.setBranding(true);
				serv.setRating(rs.getFloat(6));
				if((int)rs.getFloat(7)==0)
					serv.setSetup_fee(false);
				else
					serv.setSetup_fee(true);
				serv.setTransaction_fee(rs.getString(8));
				serv.setHow_to_url(rs.getString(9));
				serv.setCurrencies(rs.getString(10));
				list.add(serv);
				
			}
			data.disconnect();
			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			st=null;
			return null;
		}
	}
	
	public ArrayList<ServiceDesc> getListByCurrency(String curr)
	{
		PreparedStatement st;
		ArrayList<ServiceDesc> list=new ArrayList<ServiceDesc>();
		try{
			String sql="SELECT * FROM VT_SERVICES WHERE CURRENCIES LIKE '%"+curr+"%'";
			st=connection.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				ServiceDesc serv=new ServiceDesc();
				serv.setId(rs.getInt(1));
				serv.setName(rs.getString(2));
				serv.setImage(rs.getString(3));
				serv.setDescription(rs.getString(4));
				if(Integer.parseInt(rs.getString(5))==0)
					serv.setBranding(false);
				else
					serv.setBranding(true);
				serv.setRating(rs.getFloat(6));
				if((int)rs.getFloat(7)==0)
					serv.setSetup_fee(false);
				else
					serv.setSetup_fee(true);
				serv.setTransaction_fee(rs.getString(8));
				serv.setHow_to_url(rs.getString(9));
				serv.setCurrencies(rs.getString(10));
				list.add(serv);
				
			}
			data.disconnect();
			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			st=null;
			return null;
		}
	}
}
