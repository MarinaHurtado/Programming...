/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Math;

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
    
}
