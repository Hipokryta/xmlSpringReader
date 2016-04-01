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

	@RequestMapping(method = RequestMethod.POST , produces = "application/json")
	@ResponseBody
	public String singleDelete(HttpServletRequest request, HttpServletResponse response){
		
		Long id = Long.valueOf((Integer.parseInt(request.getParameter("id"))));
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("delete SystemContract where id = :id");
		query.setParameter("id", id);
		int result = query.executeUpdate();
		 
		Transaction tx=null;
		tx=session.beginTransaction();
	    tx.commit();
	    session.close();

	    return "OK";
	}
}
