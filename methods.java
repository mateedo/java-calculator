import java.io.*;
import java.util.*;
import java.lang.*;
public class methods{
	public static String calculate(String line)
	{
		ArrayList<String> yer = new ArrayList<String>( );
	      
	      
	      
	      line = line.replaceAll(" ",""); //Remove all the spaces in the string
	      line.toLowerCase();
	      if(!line.equals("store")) {
	      
	      line="("+line+")";//The code solves for everything inside brackets, so it makes sense to put the whole thing in brackets. Otherwise, the output would be the equation with all the brackets solved. Therefore 17/4+16/(2^2) would output 17/4+16/4 instead of 8.25
	      try{
	      String n=""; //equation
	      try{
	      for(int i=0;i<line.length();i++)
	      {
	    	  
	    	  
	        try
	        {
	          if(line.charAt(i)=='.')//Checks for decimal dots
	          {
	            n+=line.charAt(i);//Adds this character to string n, which is the current number that is being read
	          }
	          else if(line.charAt(i) == '?')
	          {
	        	  n+="-";
	          }else
	          {
	            Integer.parseInt(line.charAt(i)+"");//Checks if it is a number. If not, it goes to the catch(Exception e)
	            n+=line.charAt(i);//Adds this character to string n, which is the current number that is being read
	          }
	        }
	        catch(Exception e)//If it is not a number
	        {
	          if(!n.equals(""))//checks if the string n is empty or not. If it is not empty, add the string to the linkedlist. Else, do not, because then you are just adding an empty string
	          {
	            yer.add(n);
	          }
	          n="";//Resets n
	          if(line.charAt(i)=='s' && line.charAt(i+1) == 'q' && line.charAt(i+2) == 'r' && line.charAt(i+3) == 't')//Checks if the input is "sqrt";
	          {
	            yer.add("sqrt");
	            i+=3;
	          }else if(line.charAt(i)=='c' && line.charAt(i+1) == 'b' && line.charAt(i+2) == 'r' && line.charAt(i+3) == 't')
	          {
	            yer.add("cbrt");
	            i+=3;
	          }else if(line.charAt(i) == 'c' && line.charAt(i+1) == 'o' && line.charAt(i+2) == 's'){
	            yer.add("cos");
	            i+=2;
	          }else if(line.charAt(i) == 's' && line.charAt(i+1) == 'i' && line.charAt(i+2) == 'n'){
	            yer.add("sin");
	            i+=2;
	          }else if(line.charAt(i) == 't' && line.charAt(i+1) == 'a' && line.charAt(i+2) == 'n'){
	            yer.add("tan");
	            i+=2;
	          }else if(line.charAt(i) == 'a' && line.charAt(i+1) == 's' && line.charAt(i+2) == 'i' && line.charAt(i+3) == 'n' ){
	            yer.add("asin");
	            i+=3;
	          }else if(line.charAt(i) == 'a' && line.charAt(i+1) == 'c' && line.charAt(i+2) == 'o' && line.charAt(i+3) == 's' ){
	            yer.add("acos");
	            i+=3;
	          }else if(line.charAt(i) == 'a' && line.charAt(i+1) == 't' && line.charAt(i+2) == 'a' && line.charAt(i+3) == 'n' ){
	            yer.add("atan");
	            i+=3;
	          }else if(line.charAt(i) == 'l' && line.charAt(i+1) == 'o' && line.charAt(i+2) == 'g' && line.charAt(i+3) == 'b') {
	        	  yer.add("logb");
	        	  i+=3;
	          }else if(line.charAt(i) == 'l' && line.charAt(i+1) == 'o' && line.charAt(i+2) == 'g') {
	        	  yer.add("log");
	        	  i+=2;
	          }else if(line.charAt(i) == 'l' && line.charAt(i+1) == 'n') {
	        	  yer.add("ln");
	        	  i+=1;
	          }else if(line.charAt(i) == 'r' && line.charAt(i+1) == 't')
	          {
	        	  yer.add("rt");
	        	  i+=1;
	          }else
	          {
	            yer.add(line.charAt(i)+"");//Else, add the operator (+,-,/,*,^)
	          }
	        }
	      }
	    
	      for(int i=yer.size()-1;i>=0;i--)//This for loop goes through the entire arraylist, starting from the end of the list
	      {
	        if(yer.get(i).equals("("))//Checks for open brackets
	        {
	          ArrayList<String>expression=new ArrayList<String>();//New arraylist for making a new equation of what is inside the brackets
	          int cont=i+1;//Counter, indicating the placements of all strings that are to be added to the arraylist
	          while(!yer.get(cont).equals(")"))//Continues to add strings until it reaches a closed bracket
	          {
	            expression.add(yer.get(cont));//Adds the strings to the new equation arraylist
	            cont++;//Increases count
	          }
	          for(int p = 0; p <expression.size();p++)
	          {
	        	  if(expression.get(p).equals("rt"))
	        	{
	        		  double base = Double.parseDouble(expression.get(p-1));
	        		  double root = Double.parseDouble(expression.get(p+1));
	        		  double num = Math.pow(root,1/base);
	        		  expression.remove(p-1);
	        		  expression.remove(p-1);
	        		  expression.remove(p-1);
	        		  expression.add(p-1,Double.toString(num));
	        		  p-=2;
	        	}
	          }
	          for(int p = 0; p< expression.size();p++)
	          {
	        	  if(expression.get(p).equals("ln"))
	        	  {
	        		  double num= Math.log(Double.parseDouble(expression.get(p+1)));
	        		  expression.remove(p);
	        		  expression.remove(p);
	        		  expression.add(p,Double.toString(num));
	        		  p--;
	        	  }
	          }
	          for(int p=0;p<expression.size();p++){
	        	  if(expression.get(p).equals("logb"))
	        	  {
	        		  double num=Math.log(Double.parseDouble(expression.get(p+1)))/Math.log(Double.parseDouble(expression.get(p-1)));
	                  expression.remove(p-1);
	                  expression.remove(p-1);
	                  expression.remove(p-1);
	                  expression.add(p-1,Double.toString(num));
	                  p-=2;
	        	  }
	          }
	          
	          for(int p=0;p<expression.size();p++){
	        	  if(expression.get(p).equals("log")) {
	        		  double as = Double.parseDouble(expression.get(p+1));
	        		  double num = Math.log10(as);
	        		  expression.remove(p);
	        		  expression.remove(p);
	        		  expression.add(p,Double.toString(num));
	        		  p--;
	        	  }
	          }
	          for(int p=0;p<expression.size();p++){
	            if(expression.get(p).equals("asin")){
	             double degrees = Double.parseDouble(expression.get(p+1));
	              double radians = Math.toRadians(degrees);
	              double num=Math.asin(radians);
	              expression.remove(p);
	              expression.remove(p);
	              expression.add(p,Double.toString(num));
	              p--;
	            }
	          }
	          for(int p=0;p<expression.size();p++){
	            if(expression.get(p).equals("atan")){
	              double degrees = Double.parseDouble(expression.get(p+1));
	              double radians = Math.toRadians(degrees);
	              double num=Math.atan(radians);
	              expression.remove(p);
	              expression.remove(p);
	              expression.add(p,Double.toString(num));
	              p--;
	            }
	          }
	          for(int p=0;p<expression.size();p++){
	            if(expression.get(p).equals("acos")){
	              double degrees = Double.parseDouble(expression.get(p+1));
	              double radians = Math.toRadians(degrees);
	              double num=Math.acos(radians);
	              expression.remove(p);
	              expression.remove(p);
	              expression.add(p,Double.toString(num));
	              p--;
	            }
	          }
	          for(int p=0;p<expression.size();p++){
	            if(expression.get(p).equals("sin")){
	             double degrees = Double.parseDouble(expression.get(p+1));
	              double radians = Math.toRadians(degrees);
	              double num=Math.sin(radians);
	              expression.remove(p);
	              expression.remove(p);
	              expression.add(p,Double.toString(num));
	              p--;
	            }
	          }
	          for(int p=0;p<expression.size();p++){
	            if(expression.get(p).equals("tan")){
	              double degrees = Double.parseDouble(expression.get(p+1));
	              double radians = Math.toRadians(degrees);
	              double num=Math.tan(radians);
	              expression.remove(p);
	              expression.remove(p);
	              expression.add(p,Double.toString(num));
	              p--;
	            }
	          }
	          for(int p=0;p<expression.size();p++){
	            if(expression.get(p).equals("cos")){
	            double num;
	            	
	              double degrees = Double.parseDouble(expression.get(p+1));
	              
	              if(degrees%90 == 0 && degrees%180 == 90 || degrees%90 == 0 && degrees%180 == -90) {
	            	  num = 0;
	            	  expression.add(p,Double.toString(num));
	              }else {
	              double radians = Math.toRadians(degrees);
	              num=Math.cos(radians);
	              }
	              expression.remove(p);
	              expression.remove(p);
	              expression.add(p,Double.toString(num));
	              p--;
	            }
	          }
	          for(int p=0;p<expression.size();p++)//This for loop checks for all sqrts
	          {
	            
	            if(expression.get(p).equals("sqrt"))//Solves square roots
	            {
	              double num=Math.sqrt(Double.parseDouble(expression.get(p+1)));
	              expression.remove(p);
	              expression.remove(p);
	              expression.add(p,Double.toString(num));
	              p--;
	            }
	          }
	          for(int p=0;p<expression.size();p++){
	            if(expression.get(p).equals("cbrt"))
	            {
	              double num=Math.cbrt(Double.parseDouble(expression.get(p+1)));
	              expression.remove(p);
	              expression.remove(p);
	              expression.add(p,Double.toString(num));
	              p--;
	            }
	          }
	          for(int p=0;p<expression.size();p++)//This for loop checks for all exponents
	          {
	            if(expression.get(p).equals("^"))//Solves exponents
	            {
	              double num=Math.pow(Double.parseDouble(expression.get(p-1)),Double.parseDouble(expression.get(p+1)));
	              expression.remove(p-1);
	              expression.remove(p-1);
	              expression.remove(p-1);
	              expression.add(p-1,Double.toString(num));
	              p-=2;
	            }
	          }
	          for(int p=0;p<expression.size();p++)//This for loop checks for all divisions
	          {
	            if(expression.get(p).equals("/"))//Solves the divisions
	            {
	              double num=Double.parseDouble(expression.get(p-1))/Double.parseDouble(expression.get(p+1));
	              expression.remove(p-1);
	              expression.remove(p-1);
	              expression.remove(p-1);
	              expression.add(p-1,Double.toString(num));
	              p-=2;
	            }
	          }
	          for(int p=0;p<expression.size();p++)//This for loop checks for all multiplications
	          {
	            if(expression.get(p).equals("*"))//Solves the multiplications
	            {
	              double num=Double.parseDouble(expression.get(p-1))*Double.parseDouble(expression.get(p+1));
	              expression.remove(p-1);
	              expression.remove(p-1);
	              expression.remove(p-1);
	              expression.add(p-1,Double.toString(num));
	              p-=2;
	            }
	          }
	          for(int p=0;p<expression.size();p++)//This for loop checks for all subtractions
	          {
	            if(expression.get(p).equals("-"))//Solves all subtractions
	            {
	              double num=Double.parseDouble(expression.get(p-1))-Double.parseDouble(expression.get(p+1));
	              expression.remove(p-1);
	              expression.remove(p-1);
	              expression.remove(p-1);
	              expression.add(p-1,Double.toString(num));
	              p-=2;
	            }
	          }
	          for(int p=0;p<expression.size();p++)//This for loop checks for all additions
	          {
	            if(expression.get(p).equals("+"))//Solves additions
	            {
	              double num=Double.parseDouble(expression.get(p-1))+Double.parseDouble(expression.get(p+1));
	              expression.remove(p-1);
	              expression.remove(p-1);
	              expression.remove(p-1);
	              expression.add(p-1,Double.toString(num));
	              p-=2;
	            }
	          }
	          for(int rt=0;rt<=cont-i;rt++)
	          {
	            yer.remove(i);//Revomes the original equation's bracket, and the equation inside of the bracket.
	          }
	          yer.add(i,expression.get(0));//Replaces the original equation's bracket, and the equation inside of the bracket, with the numerical value
	          i++;
	        }
	      }
	      }catch(NumberFormatException e)
	      {
	        return "Error4: Invalid Variable Name";
	      }catch(NullPointerException e) {
	    	  return "Error5: No varibale value";
	      }
	      try{	
	    	  Double lol = Double.parseDouble(yer.get(0));
		        
	      }catch(Exception e){
	        return "Error3: Invalid Expression";
	      }
	      //At the end of all of this, the value left over is a single number. It prints4s this value.
	    }catch(ArrayIndexOutOfBoundsException exception){
	      return "Error3: Invalid Expression";
	      
	    
	    
	    }
	      
	}
	      return yer.get(0);
		
}
}
