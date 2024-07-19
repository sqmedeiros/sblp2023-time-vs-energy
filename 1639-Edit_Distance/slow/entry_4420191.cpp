#include<bits/stdc++.h>
using namespace std;
#define lli long long int
int solve(string &s1,string &s2,vector<vector<lli>> &ans,int i,int j){
    if(i<0)return j+1;
    if(j<0)return i+1;
    if(ans[i][j] != -1)return ans[i][j];
    return ans[i][j] = s1[i]==s2[j]?solve(s1,s2,ans,i-1,j-1) : min(solve(s1,s2,ans,i-1,j)+1,min(solve(s1,s2,ans,i-1,j-1)+1,solve(s1,s2,ans,i,j-1)+1));
}
int main(int argc, char const *argv[])
{
    string s1,s2;
    cin>>s1>>s2;
    vector<vector<lli>> ans(s1.length(),vector<lli> (s2.length(),-1));
    cout<<solve(s1,s2,ans,s1.length()-1,s2.length()-1);
    return 0;
}