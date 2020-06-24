package Week3;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.stream.*;
import org.openqa.selenium.WebElement;
import java.util.function.*;

public class payPal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Declare a String as PayPal India
         String names = "PayPal India"; 
 		
         // Convert it into a character array
         char[] ch = names.toCharArray(); 
         for (char c : ch) { 
             System.out.println(c); 
         } 
          
         //Declare a Set as charSet for Character
         Set<Character> charSet = new LinkedHashSet<Character>();
         
         //Declare a Set as dupCharSet for duplicate Character
         Set<Character> dupCharSet  = new LinkedHashSet<Character>();
 		 
         //Iterate character array and add it into charSet
         //if the character is already in the charSet then, add it to the dupCharSet
         for (int i=0; i<ch.length; i++) {
        	 boolean t = charSet.add(ch[i]);
        	 if(t == false)
        	 {
        		 dupCharSet.add(ch[i]);
        	 }
 		 }
         
         System.out.println("Characters in Charset"); 
         for (Character eachChar : charSet) {
     		System.out.println(eachChar);
     	 } 
         System.out.println("Characters in Duplicate Charset"); 
         for (Character eachChar : dupCharSet) {
      		System.out.println(eachChar);
      	 } 
         
         //Check the dupCharSet elements and remove those in the charSet
         charSet.removeAll(dupCharSet);
         System.out.println("After removal of duplicates : Characters in Charset");
         for (Character eachChar : charSet) {
      		System.out.println(eachChar);
      	 } 
          System.out.println("After removal of duplicates : Characters in Duplicate Charset"); 
          for (Character eachChar : dupCharSet) {
       		System.out.println(eachChar);
       	 } 
          //Check the iterator variable isn't equals to an empty space
          System.out.println("Print variables without space");
          for (Character eachChar : charSet) {
        	  if (eachChar != ' ')
       		System.out.println(eachChar);
       	 }
	}

}
