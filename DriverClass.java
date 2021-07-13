package predictagefinal;
import java.io.*;
import java.util.Properties;
import java.util.Scanner;
public class DriverClass {

	
	public ArrayList<String> totState = new ArrayList<>();
	
 		
//adding the name of the states to a list in order to determine if the UserInput is valid or not

	
public void totalStates(String directory) throws Exception {
	  File dir = new File(directory);
     for(File fileEntry : dir.listFiles()){
         String s = fileEntry.getName();
         totState.add(s);
	
     }
}
     public boolean validState(String userState) throws Exception {
    	 for(int i=0;i<this.totState.size;i++) {
             if (totState.get(i).equals(userState)) 
             {return true;
             }
    	 }
		return false;
     
     }
	public boolean validGender(String gender) {
		if (!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F")){
			
			return false;
		}
		else {
				return true;
			}
			}
	public boolean ArrayorLinked(String listtype) {
		if (listtype.equals("ArrayList")) {
       	 return true;
       
        }
        else {
       	return false;
       	 
        }
		
		
	}
	public static void main(String[] args) throws Exception {
		DriverClass d = new DriverClass();
		ArrayList<String> totState= new ArrayList();
		List<String> list = null;
		List<String> userInfo= null;
		int currentYear = 2021;
		boolean valid = true;
		while (valid==true) {

		//Acquiring the Files from properties
	
		
		Properties pro = new Properties();
		 InputStream is = new FileInputStream(new File("file.properties"));
         pro.load(is);
         String directory = pro.getProperty("Directory");
         String listType = pro.getProperty("ListType");
       
         
         //determining if we are using a linked or arraylist
        boolean lT= d.ArrayorLinked(listType);
        if(lT==true) {
        	userInfo= new ArrayList<>();
        	
        }
        else {
        	userInfo= new LinkedList<>();
        }
        
 
         
         
         d.totalStates(directory);
         Boolean stateCheck=false;
 		Scanner userIn = new Scanner(System.in);
 		
 		
 			System.out.println("Enter Name of Person (or EXIT to quit):  \n");
 			String userName= userIn.next();
 			userInfo.add(userName);
 			
 			
 			if (userName.equals("Exit") || userName.equals("EXIT") || userName.equals("exit")) {
 				System.exit(0);
 				
 			}
 			else {
 				System.out.println("Input Gender (M/F): \n");
 				String userSex=userIn.next().toUpperCase();
 				boolean vGender = d.validGender(userSex);
 				userInfo.add("1"); 
 				if (vGender==false) {
 					System.out.println("Invalid Gender, Try Again (M/F) \n");
 					String recursiveGender=userIn.next().toUpperCase();
 					userSex=recursiveGender;
 					vGender=d.validGender(recursiveGender);
 					
 				}
 				
 				else{
 				
 					
 					System.out.println("Enter the Abbrevation of State (ex.CA, FL) : ");
 				
 				
 				
 				String userState=userIn.next().toUpperCase();
 				
 				String stateFile= userState +".TXT";
 				boolean vState=d.validState(stateFile);
 				if(vState==false) {
 					System.out.println("Invalid State, Please Try Again: ");
 					String recursiveState=userIn.next().toUpperCase()+".TXT";
 					stateFile= recursiveState;
 					vState=d.validState(stateFile);
 				}
 				else {
 					Scanner scan = new Scanner(new File(directory+"/"+ stateFile));
 					while (scan.hasNextLine()) {
 						String[] dataArr = scan.nextLine().split(",");
 						String state= dataArr[0];
 						String sex = dataArr[1];
 						int year = Integer.parseInt(dataArr[2]);
 						String name = dataArr[3];
 						int total = Integer.parseInt(dataArr[4]);
 						
 			 			userInfo.add("1");
 						//parses through the txt file and determines if the name and gender match up
 						if ((name.equals(userName) && dataArr[1].equals(userSex)&& total>Integer.parseInt(userInfo.get(1) ))) {

 							userInfo.set(1, dataArr[4]);
 							userInfo.set(2,dataArr[2]);
 							
 	                    }
 						
 						
 						
 	 					
 						
 				}
 					if(Integer.parseInt(userInfo.get(2))>0) { // if statement to ensure there was an occurence of the name
 	                    System.out.println(userInfo.get(0) + ", born in " + userState + " is most likely  " + (currentYear - Integer.parseInt(userInfo.get(2))) + " years old");
 	                    
 	                
 	                }
 					else {
 						System.out.println("No Occurences of that name in " + userState);
 					}
 				
 					
 					
 				}
 			
 				}
		}
	}
	}
 				
 			
	}


