/*
* Henrique Teske Barbieri
* HackerRank - Search - Flowers
* K friends want to buy N flowers. Flower number i costs ci. 
* If a customer has already bought x flowers, he should pay (x+1)*ci dollars to buy flower number i
* Outcome: the minimum amount of money paid in order to buy all N flowers
*
* Approach: Buy the more expensive flowers first
*/

import java.util.*;

class Solution{
    public static void main( String args[] ){
    	   
        Scanner in = new Scanner(System.in);
        
        int N, K, mult, i;
        N = in.nextInt();
        K = in.nextInt();
        
        int C[] = new int[N];
        int result = 0;
        
        i=0;
        while (in.hasNextInt()){
            C[i] = in.nextInt();
            i++;
        }
        
        Arrays.sort(C);
        
        mult = 0;
        int s = 0;
        for (i = 0 ; i<N ; i++){
            //every time every one has bought a flower increases the multiplicator
            if (i%K==0) mult++;
            
            //adds the price paid to the result
            result += C[N-i-1]*mult;

        }
        
        System.out.println( result );
		
    }
}
