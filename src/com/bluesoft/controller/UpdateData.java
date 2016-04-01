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

@Controller
@RequestMapping("/UpdateData")
public class UpdateData {

	@RequestMapping(method = RequestMethod.POST , produces = "application/json")
	@ResponseBody
	public String singleSave(HttpServletRequest request, HttpServletResponse response){
		int id = Integer.parseInt(request.getParameter("id"));
		String value = request.getParameter("value");
		int columnIndex = Integer.parseInt(request.getParameter("columnIndex"));
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		String columnName = "";
		
			switch (columnIndex)
            {
                case 0:
                	columnName = "id";
                    break;
                case 1:
                	columnName = "active";
                    break;
                case 2:
                	columnName = "amount";
                    break;
                case 3:
                	columnName = "amount_period";
                    break;
                case 4:
                	columnName = "amount_type";
                    break;
                case 5:
                	columnName = "authorization_percent";
                    break;
                case 6:
                	columnName = "from_date";
                    break;
                case 7:
                	columnName = "order_number";
                    break;
                case 8:
                	columnName = "request";
                    break;
                case 9:
                	columnName = "to_date";
                    break;
                case 10:
                	columnName = "system_id";
                    break;
            }
		 String query = String.format("update SystemContract set %s = '%s' where id = %d",columnName,value,id);
		 Query selectQuery = session.createQuery(query);
		 int resultOfQuery = selectQuery.executeUpdate();
		 
		 Transaction tx=null;
		 tx=session.beginTransaction();
	     tx.commit();
	     session.close();

	     return "OK";
	}


}
