/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Math;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author M
 */
public class Solution {
    
    //Given an integer n, return the number of trailing zeroes in n!.
    //Note: Your solution should be in logarithmic time complexity.
    public int trailingZeroes(int a) {
	    int count=0;
	    for(int i=5; i<=a;  i*=5)
	        count+=(a/i);
	    return count;
	}
    
    /*
    Determine whether an integer is a palindrome. Do this without extra space.

    A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
    Negative numbers are not palindromic.
    */
    public boolean isPalindrome(int a) {
	    if(a<0)
	       return false;
	    boolean ban = true;
	    int count = (int)Math.log10((double)a);
	    while(ban && count>0){
	        int b = a;
	        int pow = (int)(Math.pow(10,count));
	        int l = b / pow;
	        int r = a%10;
	        if(l!=r)
	           return false;
	        a = a - pow*l;
	        a /= 10;
	        count -= 2;
	    }
	    return ban;
	}
    
    //Given 2 non negative integers m and n, find gcd(m, n)
    //GCD of 2 integers m and n is defined as the greatest integer g such that g is a divisor of both m and n.
    //Both m and n fit in a 32 bit signed integer.
    public int gcd(int a, int b) {
	    int div, gcd;
	    if(a==0)
	        return b;
	    if(b==0)
	        return a;
	    if(a>b)
	        div=b;
	    else
	        div=a;
	    while(div>0){
	        if(a%div==0 && b%div==0)
	            return div;
	        div--;
	    }
	    return div;    
    }
    
    /*
    Given an index k, return the kth row of the Pascal’s triangle.
    Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

    Example:
    Input : k = 3
    Return : [1,3,3,1]
    
    NOTE : k is 0 based. k = 0, corresponds to the row [1]. 
    Note:Could you optimize your algorithm to use only O(k) extra space?
    */
    
    public static ArrayList<Integer> getRow(int a) {
	    ArrayList<Integer> arr =  new ArrayList();
	    Hashtable hash = new Hashtable();
	    int factN = getFactorial(hash, a);
	    for(int i=0; i<=a; i++){
	        int factX = getFactorial(hash, i);
	        int aux = getFactorial(hash, a-i);
	        arr.add(factN/(factX*aux));
	    }
	    return arr;
	}
	
	private static int getFactorial(Hashtable hash, int n){
	    Integer fact = (Integer)hash.get(n);
            if(fact==null){
               fact = 1;
               for (int j=2; j<=n; j++)
                    fact *= j; 
               hash.put(n,fact);
            }
            return fact;
	}
        
        
        public static void main(String[] args) {
            getRow(2);
        }
    
}
