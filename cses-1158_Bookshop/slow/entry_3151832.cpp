#include<iostream>
 
using namespace std;
 
int main()
{
    int n,x;
    scanf("%d %d",&n,&x);
    int h[n],s[n];
    for(int i=0;i<n;i++)
        scanf("%d",h+i);
    for(int i=0;i<n;i++)
        scanf("%d",s+i);
    int a[x+1][n+1];
    for(int i=0;i<=x;i++)
        a[i][0] = 0;
    for(int i=0;i<=x;i++)
    {
        for(int j=1;j<=n;j++)
        {
            a[i][j] = a[i][j-1];
            int t=i-h[j-1];
            if(t>=0&&a[i][j]<(a[t][j-1]+s[j-1]))
                a[i][j] = a[t][j-1]+s[j-1];
        }
    }
    printf("%d",a[x][n]);
}