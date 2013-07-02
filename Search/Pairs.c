/*
* Henrique Teske Barbieri
* HackerRank - Search - Pairs
* Given N numbers [N<=10^5], count the total pairs of numbers that have a difference of K. [K>0 and K<1e9]
* Approach: nested loop comparing every number with each other
*/

#include <stdio.h>

int main() {
    int N, K;
    int counter = 0;
    
    scanf("%d", &N);
    scanf("%d", &K);
    
    int array[N];
    
    
    for ( int i = 0 ; i < N ; ++i ) {
        scanf("%d", &array[i]);
    }
    
    //compares every number with each other checking their differences. Increases counter if |difference| == K.
    for ( int i = 0 ; i < N ; ++i ) {
        for ( int j = i ; j < N ; ++j ) {
                if (array[i]-array[j]==K || array[j]-array[i]==K)
                    counter++;
        }
    }
    
    printf("%d", counter);
}
