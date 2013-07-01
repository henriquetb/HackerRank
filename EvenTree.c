/*
* Henrique Teske Barbieri
* HackerRank - Graph Theory - Even Tree
* given a tree (a simple connected graph with no cycles). You have to remove as 
* many edges from the tree as possible to obtain a forest with the condition 
* that : Each connected component of the forest should contain an even number of vertices
*/

#include <stdio.h>

int main(void) {
  int i, result=0, father, nVertices, nEdges, verticeF, verticeP;

	scanf("%d", &nVertices);//number of vertices
	scanf("%d", &nEdges);//number of edges
	int vertices[nVertices][2];

	for (i = 1 ; i<=nVertices ; i++){
		vertices[i][0] = -1;//i vertice's father
		vertices[i][1] = 1;//number of vertices below i (including i)
	}

	for (i=1; i<=nEdges; i++) {
		scanf("%d", &verticeF);//ith vertice
		scanf("%d", &verticeP);//ith vertice's father

		vertices[verticeF][0] = verticeP;
    //the amount of vertices of the father is the actual amount plus the sons amount
		vertices[verticeP][1] = vertices[verticeP][1]+vertices[verticeF][1];

		father = vertices[verticeP][0];
		while(father!=-1)
		{
			vertices[father][1] += vertices[verticeF][1];
			father = vertices[father][0];
		}
	}



	for (i = 1 ; i<=nVertices ; i++){
		if ( vertices[i][1]%2 == 0 && vertices[i][0]!=-1)
			result++;
	}
  
	printf("%d", result);
	return 0;
}
