/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strings;

import java.util.*;
import java.math.*;

/**
 *
 * @author M
 */
public class StringsFunctions {
    
    /*Write an efficient function to find the first nonrepeated character in a string. For
    instance, the first nonrepeated character in “total” is ‘o’ and the first nonrepeated
    character in “teeter” is ‘r’. Discuss the efficiency of your algorithm. */
    public static Character FirstNonRepeated(String s){ //O(N^2)
        s.toLowerCase();
        char[] chArr = s.toCharArray();
        for (int i=0; i<chArr.length; i++){
            char c = chArr[i];
            if(c<97){
                boolean flag= false;
                for (int j=1+1; j<chArr.length; j++){
                    char comp=chArr[j];
                    if(comp==c){
                        chArr[j]='A';
                        flag=true;
                    }
                }
                if(!flag)
                    return c;
            }
        }
        return null;
    }
    
    //O(n)
    public static Character FirstNonRepeatedN(String s){ 
        Hashtable hash = new Hashtable();
        int len = s.length();
        for (int i=0; i<len; i++){
            Character c = s.charAt(i);
            Integer counter = (Integer)hash.get(c.hashCode());
            if(counter==null)
                counter=0;
            counter++;
            hash.put(c.hashCode(), counter);
        }
        for(int i=0; i<len; i++){
            Character c = s.charAt(i);
            Integer counter = (Integer)hash.get(c.hashCode());
            if(counter==1)
                return c;
        }
        return null;
    }
    
    /* Write an efficient function in C# that deletes characters from a string. Use the prototype
    string removeChars( string str, string remove );
    where any character existing in remove must be deleted from str. For example,
    given a str of “Battle of the Vowels: Hawaii vs. Grozny” and a remove of “aeiou”,
    the function should transform str to “Bttl f th Vwls: Hw vs. Grzny”. Justify any
    design decisions you make and discuss the efficiency of your solution.*/
    public static String removeChar(String str, String remove){
        StringBuilder newString = new StringBuilder();
        int lenStr = str.length();
        int lenRemove = remove.length();
        for (int i=0; i<lenStr; i++){
            char toPut = str.charAt(i);
            int j;
            for(j=0; j<lenRemove; j++){
                if(toPut==remove.charAt(j))
                    break;
            }
            if(j==lenRemove)
                newString.append(toPut);
        }
        return newString.toString();
    }
    
    //More efficient
    public static String removeCharEf(String str, String remove){
        Hashtable hash = new Hashtable();
        int lenRemove = remove.length();
        for (int i=0; i<lenRemove; i++){
            Character ch = remove.charAt(i);
            hash.put(ch.hashCode(), true);
        }
        char[] charArray = str.toCharArray();
        int lenCharArray = charArray.length;
        int j=0;
        for (int i=0; i<lenCharArray; i++){
            Character toPut = charArray[i];
            Object code = toPut.hashCode();
            if(hash.get(code)==null){
                charArray[j]=toPut;
                j++;
            }
        }
        StringBuilder newString = new StringBuilder();
        for(int i=0;i<j; i++){
            newString.append(charArray[i]);
        }
        return newString.toString();
    }
    
    /*Write a function that reverses the order of the words in a string. For example, your
    function should transform the string “Do or do not, there is no try.” to “try. no is
    there not, do or Do”. Assume that all words are space delimited and treat punctuation
    the same as letters.*/
    
    public static String reversePhrase(String str){
        StringBuilder stBuild = new StringBuilder();
        int j=str.length();
        for(int i = str.length()-1; i>=0; i--){
            char c=str.charAt(i);
            if(c==' ' || i==0){
                if(i==0)
                    stBuild.append(" ");
                for(int k=i; k<j; k++){
                    stBuild.append(str.charAt(k));
                }
                j=i;
            }
        }
        return stBuild.toString();
    }
    
    public static String reversePhraseSplit(String str){
        String[] words = str.split(" ");
        StringBuilder newString = new StringBuilder();
        for (int i=words.length-1; i>=0; i--){
            newString.append(words[i]);
            newString.append(" ");
        }
        return newString.toString();
    }
    
    /*Write two conversion routines. The first routine converts a string to a signed integer.
    You may assume that the string only contains digits and the minus character (‘-’),
    that it is a properly formatted integer number, and that the number is within the
    range of an int type. The second routine converts a signed integer stored as an int
    back to a string.  */
    public static int StringToInteger(String str){
        int number=0;
        boolean flag = false;
        for(int i=0; i<str.length(); i++){
            Character c=str.charAt(i);
            if(i==0 && c=='-'){
                flag = true;
            }
            else{
                int temp = c - '0';
                number *= 10; //Muchas menos multiplicaciones!
                number +=temp;
            }
        }
        if (flag)
            number *= -1;
        return number;
    }
    
    
    
    public static String IntToString(int num){
        if(num==0)
            return "0";
        StringBuilder st = new StringBuilder();
        boolean flag = false;
        if(num<0){
            flag = true;
            num*=-1;
        }
        while(num>=1){
            int n = num%10;
            st.append(n);
            num /= 10;
        }
        if(flag)
            st.append("-");
        return st.reverse().toString();
    }
    
    /*
    Given an input string, reverse the string word by word.

    Example:
    Given s = "the sky is blue",
    return "blue is sky the".

    A sequence of non-space characters constitutes a word.
    Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
    If there are multiple spaces between words, reduce them to a single space in the reversed string. */
    public static String reverseWords(String a) {
	    String[] arr = a.split(" ");
	    StringBuilder cad = new StringBuilder();
	    for(int i= arr.length-1; i>=0; i--){
	        String w = arr[i];
                try{
                if(w.charAt(0)!= ' '){
                    for(int j=0; j<w.length(); j++){
                        char c = w.charAt(j);
                        if(c!=' '){
                            cad.append(c);
                        }
                    }
                    cad.append(' ');
                }
                } catch(Exception e){}
	    }
	    cad.deleteCharAt(cad.length()-1);
	    return cad.toString();
	}
    
    /*
    Implement atoi to convert a string to an integer.

    Example :
    Input : "9 2704"
    Output : 9
    Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.

    Questions: 
    Q1. Does string contain whitespace characters before the number? Yes 
    Q2. Can the string have garbage characters after the number? Yes. Ignore it. 
    Q3. If no numeric character is found before encountering garbage characters, what should I do? Return 0. 
    Q4. What if the integer overflows? Return INT_MAX if the number is positive, INT_MIN otherwise. 
    Warning : DO NOT USE LIBRARY FUNCTION FOR ATOI.
    */
    public class Solution {
	public int atoi(final String a) {
	    int j=0;
	    while(a.charAt(j)==' ')
	        j++;
	        
	    int res = 0;
	    int len = a.length();
	    boolean ban = false;
	    if(a.charAt(j) == '-'){
	        ban = true;
	        j++;
	    }
	    else if(a.charAt(j)=='+'){
	        j++;
	    }
	    
	    for(int i=j; i<len; i++){
	        Character c = a.charAt(i);
	        if(isNumber(c)){
    	        try{
    	            res = Math.multiplyExact(res, 10);
    	            res = Math.addExact(res, Character.getNumericValue(c));
    	        } catch (Exception e){
    	            if(ban)
    	                return Integer.MIN_VALUE;
    	            else
    	               return Integer.MAX_VALUE;
    	        }
	        }
	        else
	            break;
	    }
	    
	    if(ban)
	        return res*-1;
	   else
	        return res;
	}
	
	public boolean isNumber(char c){
	    if (c=='0' ||
           c=='1' ||
           c=='2' ||
           c=='3' ||
           c=='4' ||
           c=='5' ||
           c=='6' ||
           c=='7' ||
           c=='8' ||
           c=='9')
	       return true;
	   else
	        return false;
	}
}
    
        
    ////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static void main(String[] args) {
        //System.out.println(FirstNonRepeatedN("HHOoLA"));
        //System.out.println(removeCharEf("ABCDEFGHI","CEFGHI"));
        //System.out.println(reversePhraseSplit("Do or do not, there is no try."));
        //System.out.println(StringToInteger("-12345"));
        //System.out.println(StringToInteger("0"));
        //System.out.println(StringToInteger("-1"));
        //System.out.println(StringToInteger("1"));
        //System.out.println(IntToString(0));
        //System.out.println(IntToString(1));
        //System.out.println(IntToString(-1));
        //System.out.println(IntToString(-274));
        System.out.println(reverseWords("hola  como     estas_"));
        System.out.println(' ' == ' ');
    }
    
}
