package com.bluesoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Handler for the update cell action
 */
@Controller
@RequestMapping("/DeleteData")
public class DeleteData {

	/**
	 * This servlet handles post request from the JEditable and updates company property that is edited
	 */
	@RequestMapping(method = RequestMethod.POST , produces = "application/json")
	@ResponseBody
	public String singleDelete(HttpServletRequest request, HttpServletResponse response){
		
		Long id = Long.valueOf((Integer.parseInt(request.getParameter("id"))));
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		 //String query = String.format("update SystemContract set %s = '%s' where id = %d",columnName,value,id);
		 Query query = session.createQuery("delete SystemContract where id = :id");
		 query.setParameter("id", id);
		 int result = query.executeUpdate();
		 
		 Transaction tx=null;
		 tx=session.beginTransaction();
	      tx.commit();
	      session.close();
		 //selectQuery.setParameter("id", id);
		 //selectQuery.setParameter("columnName", columnName);
		 //selectQuery.setParameter("value", value);
		//int columnId = Integer.parseInt(request.getParameter("columnId"));
		//int columnPosition = Integer.parseInt(request.getParameter("columnPosition"));
		//int rowId = Integer.parseInt(request.getParameter("rowId"));
		//String value = request.getParameter("value");
		//String columnName = request.getParameter("columnName");


	      return "OK";
		//response.getWriter().print("Error - company cannot be found");
	}


}
