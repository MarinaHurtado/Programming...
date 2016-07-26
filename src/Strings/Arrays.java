/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strings;

import java.util.*;
/**
 *
 * @author M
 */
public class Arrays {
    
    /* Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

    Example:

    Input: 	

    1 2 3
    4 5 6
    7 8 9

    Return the following :

    [ 
      [1],
      [2, 4],
      [3, 5, 7],
      [6, 8],
      [9]
    ] */
    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
	    
	    int niv;
	    ArrayList<ArrayList<Integer>> arr = new ArrayList();
	    
            for(int i=0; i<a.get(0).size(); i++){
	        niv = 0;
	        ArrayList<Integer> arrInt = new ArrayList();
	        for (int j=i; j>=0; j--){
	            arrInt.add(a.get(niv).get(j));
                    niv++;
	        }
	        arr.add(arrInt);
	    }	    
	    
	    for(int k=1; k<a.size(); k++){
	        ArrayList<Integer> arrInt = new ArrayList();
	        for(int j= a.size()-1; j>=0; j--)
	            arrInt.add(a.get(k).get(j));
	        arr.add(arrInt);
	    }
	    
	    return arr;
	}
    
    /*
    A robot is located at the top-left corner of an A x B grid (marked ‘Start’ in the diagram below).
    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).

    How many possible unique paths are there?
    Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.
    ----------------
    Example :

    Input : A = 2, B = 2
    Output : 2

    2 possible routes : (0, 0) -> (0, 1) -> (1, 1) 
                  OR  : (0, 0) -> (1, 0) -> (1, 1) 
    */
    public int uniquePaths(int a, int b) {
        return recSol(a,b,1,1,0);
    }
	
    private int recSol(int a, int b, int posA, int posB, int n){
        if(posA==a && posB==b) return n+1;
        if(posA==a)
           return recSol(a, b, posA, posB+1, n);
        if(posB==b)
           return recSol(a, b, posA+1, posB, n);
       return recSol(a, b, posA, posB+1, n) + recSol(a, b, posA+1, posB, n);
    }
    
    /* There are two sorted arrays A and B of size m and n respectively.
    Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).
    The overall run time complexity should be O(log (m+n)).

    Sample Input
    A : [1 4 5]
    B : [2 3]

    Sample Output
    3
    NOTE: IF the number of elements in the merged array is even, then the median is the average of n / 2 th and n/2 + 1th element. 
    For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5  */
    public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
	    
	    int sizeA = a.size();
	    int sizeB = b.size();
	    int apA = 0;
	    int apB = 0;
	    Integer auxA = null;
	    Integer auxB = null;
	    double med = (sizeA+sizeB)/2;
	    boolean promedio= false;
	    if((med*10)%10==0)
	       promedio = true;
	       
       if(apA < sizeA){
            auxA = a.get(apA);
            apA++;
       }
       if(apB < sizeB){
            auxB = b.get(apB);
            apB++;
       }
	       
	   int i = 1;
	   while (true){
	       Integer res=0;
	       if(!(i<med)){
	           if(auxA<auxB)
	                res = auxA;
	           else
	                res = auxB;
	       }
	       if(auxA < auxB){
	           if(apA < sizeA){
                    auxA = a.get(apA);
                    apA++;
                }
                else{
                    auxB = b.get(apB);
                    apB++;
                }
	       }
	       else{ 
	           if(apB < sizeB){
                    auxB = b.get(apB);
                    apB++;
                }
                else{
                    auxA = a.get(apA);
                    apA++;
                }
	       }
	       if(!(i<med) && promedio){
	           if(auxA<auxB)
	                res += auxA;
	           else
	                res += auxB;
	           res/=2;
	       }
	       if(!(i<med))
	            return res;
	       i++;
	   }
	}
    
    public static  ArrayList<Integer> plusOne(ArrayList<Integer> a) {
	    int size = a.size();
	    int i=a.size()-1;
	    while(i>=0){
	        int num = a.get(i);
	        if(num<9){
	            a.set(i, ++num);
	            return a;
	        }
	        a.set(i, 0);
	        i--;
	    }
	    ArrayList<Integer> arr = new ArrayList();
	    arr.add(1);
	    for(i=size-1; i>=0; i--)
	        arr.add(a.get(i));
	   return arr;
	}

    
    public static void main(String[] args) {
        /*
        ArrayList<ArrayList<Integer>> arr = new ArrayList();
        ArrayList<Integer> a1 = new ArrayList();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        ArrayList<Integer> a2 = new ArrayList();
        a2.add(4);
        a2.add(5);
        a2.add(6);
        ArrayList<Integer> a3 = new ArrayList();
        a3.add(7);
        a3.add(8);
        a3.add(9);
        arr.add(a1);
        arr.add(a2);
        arr.add(a3);
        System.out.println("Empieza");
        ArrayList<ArrayList<Integer>> res = diagonal(arr);
        System.out.println("Termina");
        
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
               System.out.println("res[]"); //Check
        */
        /*
        List<Integer> a = new ArrayList();
        a.add(0);
        List<Integer> b = new ArrayList();
        b.add(1);
        b.add(20);
        double aux = 1.666; 
        System.out.println(3/2);
        //System.out.println(findMedianSortedArrays(a,b));
        */
        /*
        ArrayList<Integer> arr = new ArrayList();
        arr.add(0);
        plusOne(arr);
        for (int i=0; i<arr.size(); i++)
            System.out.print(arr.get(i));
        */
        

        Double res = 0.0;
        Long a = res.longValue();
        System.out.println( (res -a)==0 );
    }
    
}
