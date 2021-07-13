package predictagefinal;

import java.io.*;
import java.util.*;

public class ReadPropertiesFileTest {
	//test Class from when i had trouble finding my directory
	public static void main(String args[]) throws IOException {
	      Properties prop = readPropertiesFile("file.properties");
	      System.out.println("List: "+ prop.getProperty("ListType"));
	      System.out.println("Directory: "+ prop.getProperty("Directory"));
	   }
	   public static Properties readPropertiesFile(String fileName) throws IOException {
	      FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream(fileName);
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         fis.close();
	      }
	      return prop;
	   }
	}