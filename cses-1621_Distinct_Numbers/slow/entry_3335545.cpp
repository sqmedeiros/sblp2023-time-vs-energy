/****************************************************************
Objective:
 
Author: VKM
****************************************************************/
 
//#include<iostream>
//#include<vector>
//#include<string>
//#include<algorithm>
//#include<math.h>
 
/*
You are given a list of n integers, and your task is to calculate the number of distinct values in the list.
 
Input
 
The first input line has an integer n: the number of values.
 
The second line has n integers x1,x2,…,xn.
 
Output
 
Print one integers: the number of distinct values.
 
Constraints
1 ≤ n ≤ 2*10^5
1 ≤ xi ≤ 10^9
Example
 
Input:
5
2 3 2 2 3
 
Output:
2
*/
 
#include <bits/stdc++.h>
 
using namespace ::std;
 
int main()
 
{
    ios::sync_with_stdio(0);
    
    vector <vector <int>> table (11,{0});
    long n;
    cin >> n;
    long temp, temp_mod;
    int flag;
    long counter = 0;
 
    for (long i = 0; i < n; i++)
    {
        cin >> temp;
        flag = 0;
        temp_mod = temp%11;
        for(auto j:table[temp_mod])
        {
            if (j == temp)
                {
                    flag = 1;
                    break;
                }
        }
        if (flag == 0)
        {
            table[temp_mod].push_back(temp);
            counter += 1;
        }
    }
    cout << counter << endl;
 
    return 0;
}
 
 
// int main()
 
// {
//     ios::sync_with_stdio(0);
    
 
//     long n;
//     cin >> n;
//     long temp;
//     set<int> s1;
 
//     for (long i = 0; i < n; i++)
//     {
//         cin >> temp;
//         s1.insert(temp);
//     }
//     cout << s1.size() << endl;
 
//     return 0;
// }
 
// The reason the solution below does not work, is because of a lack of memory
// Creating a contiguious memory consisting of 10^10 blocks is not feasible,
// if each block was just 1 Bit (Bool), it would conusme ~1250Mb of space
// on the heap and if each block was an integer (8 Bits) it would take 10Gb of
// space on the heap.
// {
//     ios::sync_with_stdio(0);
 
//     long max = pow(10, 10) + 1;
//     // vector<long> directory {max,0};
 
//     int *directory = new int[max]();
//     if (!directory)
//     {
//         cout << "Memory allocation failed\n";
//     }
 
//     long n = 0;
//     cin >> n;
//     long temp = 0;
//     long counter = 0;
 
//     for (long i = 0; i < n; i++)
//     {
//         cin >> temp;
//         if (directory[temp] == 0)
//         {
//             counter += 1;
//             directory[temp] = 1;
//         }
//     }
 
//     cout << counter << endl;
//     delete[] directory;
 
//     return 0;
// }