/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recurssion;

/**
 *
 * @author M
 */
public class RecurssionFunctions {
    
    /* Implement a function to perform a binary search on a sorted array of integers to find
    the index of a given integer. Use this method declaration: */
    public static int binarySearch( int[] array, int lower, int upper, int target ){
        int pos = ((upper-lower)/2)+lower;
        int n = array[pos];
        if(n == target)
            return pos;
        if(lower==upper)
            return -1;
        if(n>=target)
            return binarySearch(array,lower,pos-1,target);
        else
            return binarySearch(array,pos+1,upper,target);
    }
    
    /* Implement a routine that prints all possible orderings of the characters in a string. In
    other words, print all permutations that use all the characters from the original
    string. For example, given the string “hat”, your function should print the strings
    “tha”, “aht”, “tah”, “ath”, “hta”, and “hat”. Treat each character in the input string as
    a distinct character, even if it is repeated. Given the string “aaa”, your routine should
    print “aaa” six times. You may print the permutations in any order you choose. */
    public static void permutationsString(String str){
        int n = str.length();
        boolean[] arr = new boolean[n]; //Arreglo para saber si ya usé las letras
        for(int i=0; i<n; i++)
            arr[i]=false; //Al principio no he usado ninguna letra
        StringBuilder st = new StringBuilder();
        permST(str, arr, 0, st);
    }
    
    private static void permST(String str, boolean[] arr, int n, StringBuilder printing){
        if(n==str.length()){
            System.out.println(printing.toString()); //Si ya no hay letras pendientes, imprime
            return;
        }
        else{
            for(int i=0; i<arr.length; i++){ //Reviso para cada letra si ya la usé
                if(!arr[i]){ //Si no la he usado...
                    printing.append(str.charAt(i)); //La uso
                    arr[i]=true; //Marco que ya la usé
                    permST(str,arr,n+1,printing); //Sigo con el resto de la palabra
                    arr[i]=false; //Dejo las cosas como estaban: no la he usado y no está en la palabra
                    printing.setLength(printing.length()-1); //IMPORTANTE
                }
            }
        }
    }
    
    /*Implement a function that prints all possible combinations of the characters in a
    string. These combinations range in length from one to the length of the string. Two
    combinations that differ only in ordering of their characters are the same combination.
    In other words, “12” and “31” are different combinations from the input string
    “123”, but “21” is the same as “12”. */
    public static void combinationsString(String str){
        int n = str.length();
        StringBuilder st = new StringBuilder();
        for(int i=1; i<n; i++)
            combST(str, 0, st, i);
        System.out.println(str);
    }
    
    private static void combST(String str, int n, StringBuilder printing, int len){
        if(n>len){
            System.out.println(printing.toString());
            return;
        }
        else{
            for(int i=n; i<str.length(); i++){ 
                printing.append(str.charAt(i));
                combST(str, i+1, printing, len);
                printing.setLength(printing.length()-1);
            }
        }
    }
    
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        //System.out.println(binarySearch(array,0,9,0));
        //System.out.println(binarySearch(array,0,9,9));
        //System.out.println(binarySearch(array,0,9,5));
        //System.out.println(binarySearch(array,0,9,69));
        //permutationsString("HAT");
        //permutationsString("ABCD");
        //permutationsString(" ");
        //permutationsString("AAA");
        combinationsString("1234");
    }
    
}
