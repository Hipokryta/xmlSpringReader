package com.bluesoft.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
 
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bluesoft.resources.XReader;
import javafx.application.Application;

 
@Controller
@RequestMapping("/UploadFile")
public class FileUploadController {
     
    @RequestMapping(method = RequestMethod.POST)
    public String singleSave(@RequestParam("file") MultipartFile file, @RequestParam("name") String name,
			   RedirectAttributes redirectAttributes ){
    	if(name.toLowerCase().contains(".xlsx")){
	    	try {
	    		XReader.readXLSXFile(file.getInputStream());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
    	}else if(name.toLowerCase().contains(".xml")){
    		try {
	    		XReader.readXMLFile(file.getInputStream());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
    	}
		return "redirect:home";
    }
}
