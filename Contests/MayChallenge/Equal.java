/*
* Henrique Teske Barbieri
* HackerRank - 20/20 Hack - May Challenge - Equal
* https://www.hackerrank.com/contests/may13/challenges/equal
* N friends have a different number of chocolats. Make everyone have the sma ammount 
* following these rules:
* (i) give one chocolate to every colleague other than chosen one.
* (ii) give two chocolates to every colleague other than chosen one.
* (iii) give five chocolates to every colleague other than chosen one.
* Output: the minimum times these operations must be applied so everyone has the same ammount
* Approach: Order the ammount and apply the rules from the smallest, holding the next item
* until they are equal. Repeat until everyone have the same ammount.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T;
        T = in.nextInt();
        
        for (int j = 0 ; j< T ; j++){
            int operations = 0;
            int acumPrev = 0;
            int acumNext = 0;
            int N = in.nextInt();
            ArrayList<Integer> colleagues = new ArrayList<Integer>();
            for (int i = 0 ; i< N ; i++){
                colleagues.add(in.nextInt());
            }
            
            Collections.sort(colleagues);
            
            for (int i = 1 ; i<N ; i++){
                while (i<N && colleagues.get(i-1)+acumPrev == colleagues.get(i)+acumNext) i++;
                if (i<N){
                    int lo = colleagues.get(i-1)+acumPrev;
                    int hi = colleagues.get(i)+acumNext;
                    operations = operations+countOperations(hi - lo);
                    acumPrev = acumNext;
                    acumNext = acumNext + hi - lo;
                    
                }
            }
            
            System.out.println(operations);
            
        }
        
    }
    
    /*
    * finds which operation must be applied based on the difference between two numbers
    */
    private static int countOperations(int diff){
        int operations = 0;
        
        operations = operations + (diff / 5);
        diff = diff % 5;
        if (diff>=2){ 
           operations = operations + (diff / 2);
           diff = diff % 2;
        }
        if (diff==1){ 
           operations = operations + 1;
        }
        return operations;
    }
    
   
}
