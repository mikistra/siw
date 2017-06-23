package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.Voto;

public class VotiAnalyzer {

	public  VotiAnalyzer() {}
	
	public List<Voto> leggi(int giorn, FileInputStream inputS) throws IOException, InvalidFormatException
	{
		DataFormatter formatter= new DataFormatter();
		List<Voto> voti= new ArrayList<Voto>();
		boolean allen;
		
		try {
	    
	          
			 FileInputStream inputStream = inputS;
	          
	          XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	          XSSFSheet firstSheet = workbook.getSheetAt(0);
	          
	          Iterator<Row> iterator = firstSheet.iterator();
	          
	          while (iterator.hasNext()) {
	              Row nextRow = iterator.next();
	            
	              Voto voto= new Voto();
	              allen = false;
	              
	              Iterator<Cell> cellIterator = nextRow.cellIterator();
	         //     Cell cell=n;
	              if(nextRow.getCell(0).getCellTypeEnum()==CellType.STRING)
	            	  continue;
	              else
	              {
	            	  while(cellIterator.hasNext())
	            	  {	 
	            		Cell cell= cellIterator.next();
	            		int a= cell.getColumnIndex();
	            		           			            		
	            		
	            		switch (a) {
						case 0:
							voto.setRifgiocatore((int)cell.getNumericCellValue());
							break;
						case 1:
					     	{
							String checkall = cell.getStringCellValue();
							if(checkall.equals("ALL"))
					     		allen=true;
							break;
							}	
						case 3:
							{
							 String tmp=formatter.formatCellValue(cell);
							 
							  if(tmp.contains("*"))
								 voto.setVoto(0); 
							  else
							  {
								  String tmp2=tmp.replace(',', '.');
								  Float tmp3= Float.parseFloat(tmp2);
								  
								  NumberFormat formatto = NumberFormat.getInstance(Locale.US);
								  formatto.setMaximumFractionDigits(1);
								  formatto.setMinimumFractionDigits(1);
								  formatto.setRoundingMode(RoundingMode.HALF_UP); 
								  Float newFloat = new Float(formatto.format(tmp3));		  
										  
								  voto.setVoto(newFloat);
							  }
							break;
							}
						case 4:
							voto.setGf((int)cell.getNumericCellValue());
							break;
						case 5:
							voto.setGs((int)cell.getNumericCellValue());
							break;
						case 6:
							voto.setGf(voto.getGf()+(int)cell.getNumericCellValue());
							break;
						case 9:
							voto.setAutogoal((int)cell.getNumericCellValue());
							break;
						case 10:
							voto.setAmmonizione((int)cell.getNumericCellValue());
							break;
						case 11:
							voto.setEspulsione((int)cell.getNumericCellValue());
							break;
						case 12:
							voto.setAssist((int)cell.getNumericCellValue());
							break;
						case 13:
							voto.setAssist(voto.getAssist()+(int)cell.getNumericCellValue());
							break;
						default:
							break;
						}
	            			
	            			            	  
	            	  
	            	  }
	              }
	              
	              if(!allen)
	              { 
	            	  voto.setGiornata(giorn);
	            	  voti.add(voto);
	              
	              }
	              else
	            	  allen=false;
	         
	          }
	           
	          workbook.close();
	          inputStream.close();
	      
			
			}		
		 catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return voti;
		
		}

		
	}
	
	
//}
