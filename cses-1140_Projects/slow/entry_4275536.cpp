#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <sstream>
#include <queue>
#include <deque>
#include <bitset>
#include <iterator>
#include <list>
#include <stack>
#include <map>
#include <set>
#include <functional>
#include <numeric>
#include <utility>
#include <limits>
#include <time.h>
#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
 
using namespace std;
 
int main()
{       
    long long int n;
    cin>>n;
    vector<long long int>a(n),b(n),p(n);
    map<long long int,long long int>m;
    for(long long int i=0;i<n;i++)
    {
        cin>>a[i]>>b[i]>>p[i];
        m[a[i]]=0;
        m[b[i]]=0;
    }
    long long int counter=0;
    for(auto it=m.begin();it!=m.end();it++)
    {
        it->second=counter++;
    }
    vector<vector<pair<long long int,long long int>>>dates(counter);
    for(long long int i=0;i<n;i++)
    {   
        dates[m[b[i]]].push_back({m[a[i]],p[i]});
    }
    vector<pair<long long int,long long int>>dp;
    long long int prev=0;
    for(long long int i=0;i<counter;i++)
    {   
        long long int ans=0;
        for(long long int j=0;j<dates[i].size();j++)
        {   
            pair<long long int,long long int>p={dates[i][j].first,0};
            auto it=lower_bound(dp.begin(),dp.end(),p);
            if(it!=dp.begin())
            {
                it--;
                ans=max(ans,(*it).second+dates[i][j].second);
            }
            else ans=max(ans,dates[i][j].second);
        }
        ans=max(ans,prev);
        dp.push_back({i,ans});
        prev=ans;
    }
    cout<<prev<<"\n";
}