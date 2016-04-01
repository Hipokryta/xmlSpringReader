package com.bluesoft.resources;

	import java.io.*;
	import java.sql.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.JSONArray;
import org.json.JSONObject;

import com.bluesoft.entities.SystemContract;
	 
	@SuppressWarnings("serial")
	@WebServlet("/AjaxDataSource")
	public class JqueryDatatablePlugin extends HttpServlet {
	 
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {

		 final DataTableRequestParam param = DataTablesParamUtility.getParam(request);
		 
		 String sEcho = param.sEcho;

		 
		 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		  Session session = sessionFactory.openSession();
		  
		 Query query = session.createQuery("from SystemContract");
		  
		  response.setContentType("application/json");
		  PrintWriter out = response.getWriter();
		  List<SystemContract> list = query.list();
		  
		  JSONObject result = new JSONObject();

		  result.put("sEcho", sEcho);
		  result.put("iTotalRecords", 3);
		  result.put("iTotalDisplayRecords", 3);
			
		  result.put("aaData", convertToJSONArray(list));
		  out.print(result);
		  session.close();
	 }

	 public JSONArray convertToJSONArray(List<SystemContract> list){
		 JSONArray result = new JSONArray();
		 for (SystemContract systemContract : list) {
			 JSONObject system = new JSONObject();
			 system.put("id", systemContract.getId());
			 system.put("active", systemContract.getActive());
			 system.put("amount", systemContract.getAmount());
			 system.put("amount_period", systemContract.getAmountPeriod());
			 system.put("amount_type", systemContract.getAmountType());
			 system.put("auth", systemContract.getAuthorizationPercent());
			 system.put("from_date", systemContract.getFromDate());
			 system.put("order_number", systemContract.getOrderNumber());
			 system.put("request", systemContract.getRequest());
			 system.put("to_date", systemContract.getToDate());
			 system.put("system_id", systemContract.getSystem().getId());
			 
			 result.put(system);
			
		}
		 
		 return	result;
	 }
	 
}
