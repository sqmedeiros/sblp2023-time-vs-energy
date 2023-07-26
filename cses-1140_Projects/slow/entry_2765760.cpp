#include <bits/stdc++.h>
 
using namespace std; 
 
struct project {
	int a; 
	int b; 
	long long p; 
}; 
 
bool mycompare (project p1, project p2) {
	return p1.b < p2.b; 
}
 
int main() {
	//ifstream fin ("test.txt"); 
	//ofstream log ("log.txt"); 
	
	int n; 
	cin >> n; 
	long long rawa [n]; 
	long long rawb [n]; 
	long long p [n]; 
	map<long long, int> lookup; 
	for (int i = 0; i < n; i++) {
		cin >> rawa[i] >> rawb[i] >> p[i]; 
		if (lookup.count(rawa[i]) == 0) lookup[rawa[i]] = 1; 
		if (lookup.count(rawb[i]) == 0) lookup[rawb[i]] = 1; 
	}
	
	int counter = 1; 
	for (auto elem : lookup) {
		lookup[elem.first] = counter; 
		counter++; 
	}
	
	/*for (auto elem : lookup) {
		cout << elem.first << " " << elem.second << "\n"; 
	}
	cout << "\n"; */
	
	vector<project> v; 
	for (int i = 0; i < n; i++) {
		project newp = {lookup[rawa[i]], lookup[rawb[i]], p[i]}; 
		v.push_back(newp); 
	}
	sort(v.begin(), v.end(), mycompare); 	
	
	/*for (auto elem : v) {
		cout << elem.a << " " << elem.b << " " << elem.p << "\n"; 
	}
	cout << "\n"; 
	
	cout << counter << "\n"; */
	
	long long output [counter]; 
	for (int i = 0; i < counter; i++) {
		output[i] = 0; 
	}
	int prev_index = -1; 
	int current_index = -1; 
	for (int i = 1; i < counter; i++) {
		output[i] = output[i-1]; 
		
		prev_index = current_index; 
		while ((current_index == -1 || v[current_index].b <= i) && current_index < n) current_index++; 
		current_index--; 
		
		//cout << "for i = " << i << " we have prev = " << prev_index << " and curr = " << current_index << "\n"; 
		
		for (int j = prev_index + 1; j <= current_index; j++) {
			output[i] = max(output[i], output[v[j].a - 1] + v[j].p); 
		}
	}
	
	/*for (int i = 0; i < counter; i++) {
		cout << output[i] << " "; 
	}
	cout << "\n"; */
	
	cout << output[counter-1]; 
	
	
	
	
	
	
}