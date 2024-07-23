#include <iostream>
#include <vector>
#include <algorithm>
 
using namespace std;
 
int check(vector <int> c){
    sort(c.begin(),c.end());
    int counter=1;
    int b = c[0];
    for (int i = 0; i < c.size(); i++)
    {
        cerr << c[i] << ' ';
        if(b!=c[i])
        {
            counter++;
        }
        b=c[i];
    }
    return counter;
}
 
int main()
{
    int n;
    cin >> n;
    vector <int> x;
    for (int i = 0; i < n; i++)
    {
        int b;
        cin >> b;
        x.push_back(b);
    }
    cout << check(x);
}