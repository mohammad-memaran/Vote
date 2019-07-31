package Vote;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import ir.huri.jcal.*;

public class vote {
	
	public static void main(String args[]) {
		// Creating user-defined class objects
		
		
		
		
Scanner inputStream = new Scanner(System.in);
        
        System.out.print("Enter Firstname : ");
        String firs_tname = inputStream.nextLine();
        
        System.out.print("Enter Lastname : ");
        String last_name = inputStream.nextLine();
        
        System.out.print("Enter National Code : ");
        int national_code = inputStream.nextInt();
        
		person p1 = new person(national_code , firs_tname , last_name);
		
		// creating arraylist
		ArrayList<person> al = new ArrayList<person>();
		al.add(p1);// adding person class object
		
		// Getting Iterator
		Iterator itr = al.iterator();
		// traversing elements of ArrayList object
		while (itr.hasNext()) {
		person pe = (person) itr.next();
		System.out.println(pe.national_code + " " + pe.first_name + " " + pe.last_name);
		}
		 int day, month, year;
	        
         GregorianCalendar date = new GregorianCalendar();
        
         day = date.get(Calendar.DAY_OF_MONTH);
         month = date.get(Calendar.MONTH);
         year = date.get(Calendar.YEAR);
         
         System.out.println("Current date is  "+day+"/"+(month+1)+"/"+year); 
      
     	System.out.println("Enter the mode of your Voting :\n 1. just one choose\n 2. you have more than one choose ");
     	int mode = inputStream.nextInt();
	    
     	if(mode==1) {
	     System.out.println("Choose your favorite Signer :\n 1.Rihanna\n 2.Lionel Richi");
	     int singer = inputStream.nextInt();
	     System.out.println("Your Vote is saved. thank you");
	    }
	    
	    else {		
	     System.out.println("Choose your favorite Football player:\n 1. Leo Messi \t 2. Cr7 \t 3.Pogba \t 4.Zelatan \t 5. Neymar ");
	     int football_player = inputStream.nextInt();
	     System.out.println("Your Votes are saved. thank you");
	    }
     	
	     
	   //  Mode m1 = new Mode (mode , singer , football_player);
		 //	ArrayList<Mode> bl = new ArrayList<Mode>();
		 	//bl.add(m1);
	}
}