/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashing;

/**
 *
 * @author M
 */
public class Solution {
    
    public String fractionToDecimal(int numerator, int denominator) {
	    Number a = numerator;
	    Number b = denominator;
	    Double numm = a.doubleValue();
	    Double den = b.doubleValue();
	    Double res = numm/den;
	    
	    if( (res-res.longValue()) == 0 ){
	        Long in = res.longValue();
	        return in.toString();
	    }
	    
	    String st = res.toString();
	    StringBuilder cad = new StringBuilder();
	    boolean ban = false;
	    for(int i=0; i<st.length(); i++){
	        char num = st.charAt(i);
	        if(ban)
    	        try{
    	            if(num != '0' && num == st.charAt(i+1)){
    	                cad.append("(");
    	                cad.append(num);
    	                cad.append(")");
    	                return cad.toString();
    	            }
    	        } catch(Exception e){}
	        if(num == '.')
	            ban = true;
	       cad.append(num);
	    }
	   return res.toString();
	   
	}
    
}
