package com.bluesoft.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bluesoft.entities.SystemContract;
import com.google.gson.Gson;

/**
 * Handling adding new data
 */

@Controller
@RequestMapping("/AddData")
public class AddData {
     
    private String saveDirectory = "E:/Test/Upload/";
     
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String singleAdd(@ModelAttribute  SystemContract system){
    	
    	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.save(system);
		
		Transaction tx=null;
		tx=session.beginTransaction();
	    tx.commit();
	    session.close();
        
    	return "ok";
    }
}