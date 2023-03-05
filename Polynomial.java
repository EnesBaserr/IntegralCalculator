
package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Polynomial {

	private double deltaX = 0.0001;

	//Example solution:
	//Index 0: Coef. of x^0
	//Index 1: Coef. of x^1
	//Index 2: Coef. of x^2
	//Index 3: Coef. of x^3
	//Index 4: Coef. of x^4
	//If there is no x^n, that coefficient should be 0.

	private ArrayList<Integer> coefficients = new ArrayList<Integer>();
	

	//Fill in coefficients inside the constructor
	public Polynomial(String polynomial) {
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		String coeffStr = "";
		for(int i = 0 ;i<5;i++) {
			coefficients.add(0);
		}
		//to create new coefficient arrayList with elements"0"
		int numberX=0;
		for(int j =0;j<polynomial.length();j++) {
			if(polynomial.charAt(j)=='x') {
				numberX=numberX+1;
			}
		}
		//to use as a counter below.
		int j = 0;
		int counter2 = 0;
		//counting x elements in polynomial.
		String powerString = "" ;
		// to use indexation.
		if(!polynomial.contains("x")) {
			for(int i = 0;i<polynomial.length();i++) {
				coeffStr+=polynomial.charAt(i);
					
				
			}
			int val = Integer.parseInt(coeffStr);
			coefficients.set(0, val);
			//in case of polynomial such as "0","1"etc.	
		}
		
		else {	
			// conditions of all polynomial containing x.
while(j<polynomial.length()) {			
			if(polynomial.charAt(j)=='x') {	
				//to look new string when encounter with x.
				if(j==polynomial.length()-1) {
					//in case of "...+- ax")
					if (coeffStr.equals("-")) {
						coeffStr="-1";
					}
					if(coeffStr.equals("+")) {
						coeffStr="+1";
					}
					//some special conditions.
					int val = Integer.parseInt(coeffStr);
					coefficients.set(1,val);
					break;					
				}
				if(polynomial.charAt(j+1)=='+'||polynomial.charAt(j+1)=='-') {
					// in case of "...+- ax+-...
					if (coeffStr.equals("-")) {
						coeffStr="-1";
					}
					if(coeffStr.equals("+")) {
						coeffStr="+1";
					}
					if(coeffStr.equals("")) {
						coeffStr="+1";
					}
					int coef = Integer.parseInt(coeffStr);
					coefficients.set(1, coef);
										
					coeffStr = "";
					// to keep it null for next step.
					counter2++;
					if(counter2==numberX) {
						// if we reach the limit of number x and then we should look for constants.
		    			if(polynomial.charAt(j+1)=='+'||polynomial.charAt(j+1)=='-') {
		    				int c = j+1;
		    				while(c<polynomial.length()) {
		    					coeffStr+=polynomial.charAt(c);
		    					c++;
		    				}
		    				int val = Integer.parseInt(coeffStr);
		    				coefficients.set(0,val);
		    				break;
		    				//end of the polynomial.
		    			}		    					    				    			
		    					    		}
					else {						
						j=j+1;
						continue;
						
		    		}		    																
				}

				if (coeffStr.equals("-")) {
					coeffStr="-1";
				}
				if(coeffStr.equals("+")) {
					coeffStr="+1";
				}		
				if(coeffStr.equals("")) {
					coeffStr="+1";
				}
				int coeff = Integer.parseInt(coeffStr);
				powerString+=polynomial.charAt(j+2);
				//x[j]="x" then x[j+2]=power
				
				
				int index = Integer.parseInt(powerString);
				//// index in the coefficient array
				//for x^2 --> index2
	    	    coefficients.set(index, coeff); 	    	    
	    		coeffStr ="";
	    		powerString="";
	    		counter2++;
	    		if(counter2==numberX) {
	    			
	    			if(j==polynomial.length()-3) {
	    				break;
	    				// in case of "......ax^n"
	    			}
	    			if(polynomial.charAt(j+3)=='+'||polynomial.charAt(j+3)=='-') {
	    				// in case of constant end of the poly.
	    				int c = j+3;
	    				while(c<polynomial.length()) {
	    					coeffStr+=polynomial.charAt(c);
	    					c++;
	    				}
	    				int val = Integer.parseInt(coeffStr);
	    				coefficients.set(0,val);
	    				break;
	    			}
	    		}
	    		else {	    			
	    			j=j+3;
	    			//unless all x are scanned, continue with other elements.
	    		}	    		
			}			
			coeffStr += polynomial.charAt(j);
			// adding chars into string at every step till it encounters with "x"
			if(polynomial.charAt(j+1)=='+'||polynomial.charAt(j+1)=='-') {
				int val =Integer.parseInt(coeffStr);
				coefficients.set(0, val);
				coeffStr="";
			}		    
		      j++;
		      
		}
		}

		


		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	}

	public double valueAt(double point) {
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		double val=0;
		for(int k = 0;k<5;k++) {
			val+=coefficients.get(k)*Math.pow(point, k);
		}
		return val;

		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	}

	public void setDeltaX(double deltaX) {
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		this.deltaX=deltaX;


		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	}


	public int computeIntegral(int min, int max) {
		
		double integration = 0;
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		int n =(int)((max-min)/deltaX);
		

		
		for(int k = 0;k<n;k++) {
			integration+=valueAt(k*deltaX+min)*deltaX;
		}
		//riemann sum
		
		

		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
		
		return (int)integration;
	}

}

