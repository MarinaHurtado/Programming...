/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicsAndBits;

/**
 *
 * @author M
 */
public class Bits {
    
    //Write a function that determines the number of 1 bits in the computer’s internal representation
    //of a given integer
    
    public int countOnes(Integer num){
        int count = 0;
        while(num!=0){
            if((1 & num) == 1)
                count++;
            num=num>>>1;
        }
        return count;
    }
    
}
