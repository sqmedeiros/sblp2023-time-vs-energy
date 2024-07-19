#pragma optimize("Bismillahirrahmanirrahim")
//ahmet23 orz...
//Allahuekber
//Sani buyuk Osman Pasa Plevneden cikmam diyor.
//FatihSultanMehmedHan
//YavuzSultanSelimHan
//AbdulhamidHan
#define author tolbi
#include <bits/stdc++.h>
#define int long long
#define endl '\n'
#define vint(x) vector<int> x
#define deci(x) int x;cin>>x;
#define decstr(x) string x;cin>>x;
#define cinarr(x) for (auto &it : x) cin>>it;
#define coutarr(x) for (auto &it : x) cout<<it<<" ";cout<<endl;
#define sortarr(x) sort(x.begin(),x.end())
#define sortrarr(x) sort(x.rbegin(),x.rend())
#define ayahya() chrono::steady_clock().now().time_since_epoch().count()
#define det(x) cout<<"NO\0YES"+x*3<<endl;
#define INF LONG_LONG_MAX
#define rev(x) reverse(x.begin(),x.end());
#define ios ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
#define tol(bi) (1LL<<((int)(bi)))
const int MOD = 1e9+7;
using namespace std;
int32_t main(){
	ios;
	int t=1;
	int tno = 0;
	if (!t) cin>>t;
	while (t-(tno++)){
		deci(n);deci(k);
		vector<pair<int,int>> arr(n);
		vector<int> huh;
		for (int i = 0; i < n; ++i)
		{
			cin>>arr[i].first>>arr[i].second;
			huh.push_back(arr[i].first);
			huh.push_back(arr[i].second);
		}
		sortarr(huh);
		int ind = 1;
		map<int,int> mp;
		for (int i = 0; i < huh.size(); ++i)
		{
			if (mp[huh[i]]) continue;
			mp[huh[i]]=ind++;
		}
		for (int i = 0; i < n; ++i)
		{
			arr[i].first=mp[arr[i].first];
			arr[i].second=mp[arr[i].second];
		}
		sort(arr.begin(),arr.end(),[](pair<int,int> a, pair<int,int> b){
			if (a.second==b.second) return a.first<b.first;
			return a.second<b.second;
		});
		int ans = 0;
		mp.clear();
		mp[0]=k;
		for (int i = 0; i < n; ++i)
		{
			if (mp.upper_bound(-arr[i].first)==mp.end()) continue;
			ans++;
			auto it = mp.upper_bound(-arr[i].first);
			int huhu = (*it).first;
			mp[huhu]--;
			if (mp[huhu]==0) mp.erase(huhu);
			mp[-arr[i].second+1]++;
		}
		cout<<ans<<endl;
	}
}