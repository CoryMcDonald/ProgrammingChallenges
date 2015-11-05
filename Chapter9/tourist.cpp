#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <algorithm>  
#include <iostream>

using namespace std;
int main()
{
    int n, m, c = 1;
    while (scanf("%d%d", &n, &m) == 2)
    {
        if (n == 0 && m == 0)   break;
        int dist[105][105] = { 0 };
        for (int i = 0; i < m; i++){
            int a, b, w;
            scanf("%d%d%d", &a, &b, &w);
            dist[a][b] = dist[b][a] = max(dist[a][b], w);
        }
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    dist[i][j] = max(dist[i][j], min(dist[i][k], dist[k][j]));
        int source, dest, people;
        scanf("%d%d%d", &source, &dest, &people);
        printf("Scenario #%d\n", c++);
        printf("Minimum Number of Trips = %d\n", (int)ceil((double)people / (dist[source][dest] - 1)));
        putchar('\n');
    }
    return 0;
}