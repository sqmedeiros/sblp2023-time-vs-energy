#include<bits/stdc++.h>
using namespace std;
 
//10 99 -59 31 83 -79 64 -20 -87 40 -31
int main()
{
    //ifstream inpu("test_input.txt");
    long long int n,last=0,min=-999999999;
    cin>>n;
    if(n==1)
    {
        int in;
        cin>>in;
        cout<<in;
        return 0;
    }
    long long int num[n+5]={0};
    list<long long int> intlist;
    long long int nums[n+1]={0};
    for(int i=0;i<n;i++)
    {
        scanf("%lld",&num[i]);
        if(num[i]>min) min=num[i];
        if(i>0&&num[i]*num[i-1]>=0)
        {
            num[i-1]+=num[i];
            num[i]=0;
            i--;
            n--;
        }
 
    }
    //for(int i=0;i<n;i++) cout<<num[i]<<" "; cout<<endl;
    for(int i=0;i<n;i++)
    {
        intlist.push_back(num[i]);
    }
    //cout<<intlist.size()<<endl;
 
    bool positive=0;
    long long int total=0,max=-99999999,k=0;
    bool pr=0;
 
    for(auto i=intlist.begin();i!=intlist.end();i++)
    {
        if(pr==1)
        {
            pr=0;
            i--;
        }
 
        auto i1=prev(i,-1);
        if(i1==intlist.end()){
            break;
        }
        auto i2=prev(i,-2);
        if(i2==intlist.end()){
            break;
        }
        //cout<<*i<<" "<<*i1<<" "<<*i2<<endl;
        if(*i+*i1>=0&&*i2+*i1>=0&&*i>0&&*i1<0&&*i2>0)
        {
            *i+=*i1+*i2;
            intlist.erase(i2);
            intlist.erase(i1);
            pr=1;
        }
        if(*i>0&&*i1>0&&pr==0)
        {
            *i+=*i1;
            intlist.erase(i1);
            pr=1;
        }
    }
    //cout<<intlist.size()<<endl;
 
    //for(auto i:intlist) cout<<i<<" ";cout<<endl;
    int h=0;
    nums[0]=0;
    for(auto i:intlist)
    {
        if(max<i)max=i;
        total+=i;
        nums[h]=total;
        h++;
    }
    //
 
    int g=0;
    if(nums[0]<0)g=1;
    for(int i=g;i<h;i+=2)
    {
        for(int j=g;j<i;j++)
        if(nums[i]-nums[j]>max)
        {
            max=nums[i]-nums[j];
            k=j;
        }
    }
    //cout<<max;
    if(max<min) max=min;
    cout<<max;
}


