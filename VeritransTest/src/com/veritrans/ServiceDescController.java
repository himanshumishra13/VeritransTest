package com.veritrans;

import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/Veritrans")
public class ServiceDescController {
	
	
	@GET
	@Path("/count") //for record count
	@Produces(MediaType.TEXT_PLAIN)
	public String getTotRecords() throws URISyntaxException{
		ServiceDescDao dao=new ServiceDescDao();
		return Integer.toString(dao.getRecordCount());
	}
	
	@GET
	@Path("/search") //for search by name
	@Produces(MediaType.APPLICATION_JSON)
	public ServiceDesc getSearchByName(@QueryParam("query") String query) throws URISyntaxException{
		ServiceDescDao dao=new ServiceDescDao();
		return dao.getResultOfNameSearch(query);
	}
	
	@GET
	@Path("/list")  //to list all records
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ServiceDesc> getList() throws URISyntaxException
	{
		ServiceDescDao dao=new ServiceDescDao();
		return dao.getList();
	}
	
	@GET
	@Path("/search1") //to search by currency
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ServiceDesc> getListByCurrency(@QueryParam("query") String query) throws URISyntaxException{
		ServiceDescDao dao=new ServiceDescDao();
		return dao.getListByCurrency(query);
	}
}
