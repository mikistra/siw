package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sun.media.sound.InvalidFormatException;

import model.Voto;
import service.VotiAnalyzer;

/**
 * Servlet implementation class UploadVotiS
 */
@WebServlet("/UploadVotiS")
@MultipartConfig
public class UploadVotiS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadVotiS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			VotiAnalyzer votianalyzer= new VotiAnalyzer();
		
	      Part filePart = request.getPart("fileup");
		
		  InputStream inputstream= filePart.getInputStream();
		  
		  List<Voto> voti=null;
		  
		try {
			voti = votianalyzer.leggi(1, (FileInputStream) inputstream);
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
			e.printStackTrace();
		}		  
	      
		  for (Voto voto : voti) {
			  
			  System.out.println(voto.toString());
							  
		}
	         
			
	}

}
