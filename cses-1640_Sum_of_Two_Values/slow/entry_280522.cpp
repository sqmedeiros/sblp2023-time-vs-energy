#include <bits/stdc++.h>
#define int long long
using namespace std ;
 
vector<int>v[101] ;
int32_t main()
{
    int n,m ;
    cin>>n >>m;
    int a[n+2] ;
 
    int add=0 ;
    set<int>st ;
    for(int i=0;i<n;i++)
    {
        cin>>a[i] ;
        int x=a[i]%100 ;
        v[x].push_back(a[i]) ;
    }
    int aa=-1,bb=-1,f=0 ;
    for(int i=0;i<n;i++)
    {
        int x,y ;
        if(a[i]>=m)continue ;
        x=a[i] ;
        y=m-a[i] ;
        if(x==y)
        {
            int cnt=0 ;
            for(int j=0 ;j<v[x%100].size();j++)
            {
 
                if(v[x%100][j]==x)cnt++ ;
                if(cnt==2)
                {
                    aa=bb=x ;
                    f=1 ;
                    break ;
                }
            }
 
        }
        else
        {
            int cnt=0 ;
             for(int j=0 ;j<v[y%100].size();j++)
            {
 
                if(v[y%100][j]==y)cnt++ ;
                if(cnt==1)
                {
                    aa=x ;
                    bb=y ;
                    f=1 ;
                    break ;
                }
            }
        }
        if(f==1 )break ;
    }
    if(aa==-1 and bb==-1)
    {
        cout<<"IMPOSSIBLE\n" ;
    }
    else
    {
        for(int i=0;i<n;i++)
        {
            if(a[i]==aa)
            {
                cout<<i+1<<" ";
                aa=-1 ;
            }
            else if(a[i]==bb)
            {
                cout<<i+1<<" ";
                bb=-1 ;
            }
        }
    }
 
}