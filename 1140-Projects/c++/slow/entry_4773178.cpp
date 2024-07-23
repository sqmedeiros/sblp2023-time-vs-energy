#include <bits/stdc++.h>
 
using namespace std;
 
bool compare(vector<long long int> a, vector<long long int> b)
{
	return a[1] < b[1];
}
 
int main()
{
	int n;  
	cin >> n;
 
	vector<int> A(n);
	vector<vector<long long int>> A_B_P(n, vector<long long int>(3));
	for(int i=0; i<n; i++)
	{
		cin >> A[i] >> A_B_P[i][1] >> A_B_P[i][2];
		A_B_P[i][0] = A[i];
		A_B_P[i][1]++;
	}
 
	sort(A.begin(), A.end());
	sort(A_B_P.begin(), A_B_P.end(), compare);
 
	// for(int i=0; i<n; i++)
	// {
	// 	cout << A_B_P[i][1] << ' ' << A_B_P[i][2] << endl;
	// }
 
	map<int, long long int> dp;
 
	long long int i = 0, j = 0, lastProfit = 0;
	while(j < n)
	{
		if(i < n and A[i] < A_B_P[j][1])
		{
			dp[A[i]] = lastProfit;
			i++;
			continue;
		}
 
		dp[A_B_P[j][1]] = max(lastProfit, dp[A_B_P[j][0]] + A_B_P[j][2]);
		lastProfit = dp[A_B_P[j][1]];
		j++;
	} 
 
	cout << lastProfit << endl;
 
	return 0;
}