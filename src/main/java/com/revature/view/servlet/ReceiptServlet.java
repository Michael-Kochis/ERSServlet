package com.revature.view.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.service.ERSReimbursementService;
import com.revature.view.forms.CommonForms;

public class ReceiptServlet extends HttpServlet {
	private static final long serialVersionUID = -1373415501835834213L;
	private static Logger log = LogManager.getLogger(ReceiptServlet.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	  throws IOException, ServletException {
	    try {
	        List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);
	        for (FileItem item : items) {
	            if (item.isFormField()) {
	                // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
	                String fieldname = item.getFieldName();
	                String fieldvalue = item.getString();
	                // check for params we want here
	            } else {
	                // Process form file field (input type="file").
	                String fieldName = item.getFieldName();
	                String fileName = FilenameUtils.getName(item.getName());
	                InputStream fileContent = item.getInputStream();
	                
	                Long ticket = Long.parseLong(req.getPathInfo().replace('/', ' ').trim() );
	                byte[] buffer = new byte[fileContent.available()];
	                
	                PrintWriter out = res.getWriter();
	                HttpSession sess = req.getSession();
	                String name = (String) sess.getAttribute("username");
	                
	                // do file stuff here.
	                out.println("<br>" + ticket + "<br>");
	                
					out.println(fileName);
	                out.println(fileContent.toString() + "\n\r");
	                out.println("<br>" + item + "<br>");
	                
	                ERSReimbursementService.setReceipt(ticket, buffer);
	                out.println("<img src=\"data:image/png;base64,\" + ${{item}} alt=\"Not working yet.\" /><br>");
	                out.println(CommonForms.reimbUserForm(name));
	            }
	        }
	    } catch (FileUploadException e) {
	        log.warn("Cannot parse multipart request.", e);
	    }
	}

}
