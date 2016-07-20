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
//    public static void combinationsString(String str){
//        int n = str.length();
//        StringBuilder st = new StringBuilder();
//        for(int i=1; i<n; i++)
//            combST(str, 0, st, i);
//        System.out.println(str);
//    }
//    
//    private static void combST(String str, int n, StringBuilder printing, int len){
//        if(n==len){
//            System.out.println(printing.toString());
//            return;
//        }
//        else{
//            for(int i=n; i<str.length(); i++){ 
//                printing.append(str.charAt(i));
//                combST(str, i+1, printing, len);
//                printing.setLength(printing.length()-1);
//            }
//        }
//    }
    
    public static void combinations(String str){
        StringBuilder st = new StringBuilder();
        for(int i=1; i<=str.length(); i++){
            combinationsAux(str, st, 0, i);
        }
    }
    
    public static void combinationsAux(String str, StringBuilder printing, int n, int length){
        if(n==length){
            System.out.println(printing.toString());
            return;
        }
        else{
            for(int i=n; i<str.length(); i++){
                printing.append(str.charAt(i));
                combinationsAux(str, printing, i+1, length);
                printing.setLength(printing.length()-1);
            }
        }   
    }
    
    /* Write a routine that takes a seven-digit telephone number and prints out all of the
    possible “words” or combinations of letters that can represent the given number.
    Because the 0 and 1 keys have no letters on them, you should change only the digits
    2–9 to letters. You’ll be passed an array of seven integers, with each element being
    one digit in the number. You may assume that only valid phone numbers will be
    passed to your routine. You can use the helper routine
    char getCharKey( int telephoneKey, int place )
    which takes a telephone key (0–9) and a place of either 1, 2, 3 and returns the character
    corresponding to the letter in that position on the specified key. For example,
    GetCharKey(3, 2) will return ‘E’ because the telephone key 3 has the letters “DEF”
    on it and ‘E’ is the second letter. */

//    public static void numberToWord(int[] phone){
//        StringBuilder st = new StringBuilder();
//        int k=0;
//        words(phone, st, 0);
//    }
//    
//    private static void words(int[] phone, StringBuilder st, int n){
//        if(n>=7){
//            System.out.println(st.toString());
//            return;
//        }
//        int number = phone[n];
//        if(number==1 || number == 0){
//            st.append(number);
//            words(phone, st, n+1);
//            st.setLength(st.length()-1);
//        }
//        else{
//            for(int i=1; i<=3; i++){
//                char c = getCharKey(number,i);
//                st.append(c);
//                words(phone, st, n+1);
//                st.setLength(st.length()-1);
//            }
//        }
//    }
    
    public static void numberToWord(int[] phone){
        StringBuilder st = new StringBuilder();
        int k=0;
        System.out.println(words(phone, st, 0, k));
    }
    
    private static int words(int[] phone, StringBuilder st, int n, int k){
        if(n>=7){
            System.out.println(st.toString());
            return k+1;
        }
        int number = phone[n];
        if(number==1 || number == 0){
            st.append(number);
            k = words(phone, st, n+1, k);
            st.setLength(st.length()-1);
        }
        else{
            for(int i=1; i<=3; i++){
                char c = getCharKey(number,i);
                st.append(c);
                k = words(phone, st, n+1, k);
                st.setLength(st.length()-1);
            }
        }
        return k;
    }
    
    public static char getCharKey( int telephoneKey, int place ){
        char[][] aux = new char[10][4];
        aux[2][1] = 'A';
        aux[2][2] = 'B';
        aux[2][3] = 'C';
        aux[3][1] = 'D';
        aux[3][2] = 'E';
        aux[3][3] = 'F';
        aux[4][1] = 'G';
        aux[4][2] = 'H';
        aux[4][3] = 'I';
        aux[5][1] = 'J';
        aux[5][2] = 'K';
        aux[5][3] = 'L';
        aux[6][1] = 'M';
        aux[6][2] = 'N';
        aux[6][3] = 'O';
        aux[7][1] = 'P';
        aux[7][2] = 'R';
        aux[7][3] = 'S';
        aux[8][1] = 'T';
        aux[8][2] = 'U';
        aux[8][3] = 'V';
        aux[9][1] = 'W';
        aux[9][2] = 'X';
        aux[9][3] = 'Y';
        return aux[telephoneKey][place];
    }
    
    //Checar, da más reespuestas de las necesarias
    public static void toWords(int[] numbers){
        int ansCount = 0;
        char[] word = new char[7];
        int [] value = {0,0,0,0,0,0,0};
        for(int i=0; i<7; i++){
            if (numbers[i]==0)
                word[i]= '0';
            else if (numbers[i]==1)
                word[i]= '1';
            else
                word[i]= getCharKey(numbers[i], 1);
        }
        System.out.println(new String(word));
        while(true){
            if(numbers[6]>1){
                value[6]++;
                word[6]=getCharKey(numbers[6], value[6]%3+1);
            }
            for(int i=5; i>=0; i--){
                if(value[i+1]%3==0){
                    value[i]++;
                    int num = numbers[i];
                    if (num>1)
                        word[i]=getCharKey(num, (value[i])%3+1); 
                    if(i==0 && (value[0]==3 || num<2)){
                        System.out.println(ansCount);
                        return;
                    }
                }
                else 
                    break;
            }
            System.out.println(new String(word));
            ansCount++;
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
        //combinations("1234");
        int[] num = {4,9,7,1,9,2,7};
        //numberToWord(num);
        toWords(num);
    }
    
}
