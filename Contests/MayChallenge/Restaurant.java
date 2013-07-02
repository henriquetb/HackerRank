/*
* Henrique Teske Barbieri
* HackerRank - 20/20 Hack - May Challenge - Restaurant
* T testcases. Cut the bread of size l * b into smaller identical pieces such that each 
* piece is a square having maximum possible side length with no left over piece of bread
* output: the number of squares of maximum size for each testcase
* approach: Test each possible integer length from the size of the 
* smallest side to 1 and add slices every time if finds a solution
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l, b;
        int T = in.nextInt();
        for (int i = 0 ; i<T ; i++){
            l = in.nextInt();
            b = in.nextInt();
            
            int length;
            if (b<l) length = b;
            else length = l;
            
            boolean found = false;
            
            while (length >0 && found==false){
                if (b%length==0 && l%length==0){
                    found=true;
                    System.out.println(b/length*l/length);
                }
                length--;
            }
            found = false;
            //System.out.println(slices);
        }
    }
}
