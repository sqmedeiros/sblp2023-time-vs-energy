#include <iostream>
 
using namespace std;
 
long long sizeA[200000]{}, desire[200000]{}, temp[200000]{};
bool isRising{};
 
namespace own
{
	void sorting(long long num[], long long temp[], long long start, long long end)
	{
		if (start + 1 >= end)
		{
			if (num[start] > num[end] && start <= end)
			{
				num[start] = temp[end];
				num[end] = temp[start];
			}
			return;
		}
 
		isRising = true;
		for (long long i{ start + 1 }; i <= end; ++i)
			if (num[i] < num[i - 1])
			{
				isRising = false;
				break;
			}
 
		if (!isRising)
		{
			long double ranNum{ 0 };
			for (long long i{ start }; i <= end; ++i)
			{
				ranNum = ranNum + static_cast<long double>(num[i]) / (end - start + 1);
			}
			long long countUp{ start }, countDown{ end };
			for (long long i{ start }; i <= end; ++i)
			{
				if (num[i] > ranNum)
				{
					temp[countDown] = num[i];
					--countDown;
				}
				else
				{
					temp[countUp] = num[i];
					++countUp;
				}
			}
			for (long long i{ start }; i <= end; ++i)
			{
				num[i] = temp[i];
			}
			sorting(num, temp, start, countUp - 1);
			sorting(num, temp, countDown + 1, end);
		}
		else return;
	}
 
	int abs(int x)
	{
		if (x < 0) 
			return -x;
		else return x;
	}
}
 
int main()
{
	long long appli{}, apart{};
	int diff{};
	cin >> appli >> apart >> diff;
 
	for (int i{ 1 }; i <= appli; ++i)
		cin >> desire[i];
	for (int i{ 1 }; i <= apart; ++i)
		cin >> sizeA[i];
 
	own::sorting(desire, temp, 1, appli);
	/*for (int i{ 1 }; i <= appli; ++i)
		cout << desire[i] << " ";
	cout << '\n';*/
	
	own::sorting(sizeA, temp, 1, apart);
	/*for (int i{ 1 }; i <= apart; ++i)
		cout << sizeA[i] << " ";
	cout << '\n';*/
 
	int chosen{ 0 }, counter{ 0 }, start{ 0 };
 
	for (int i{ 1 }; i <= apart; ++i)
	{
		if (sizeA[i] >= desire[1] - diff)
		{
			start = i;
			break;
		}
	}
 
	for (int i{ start }; i <= apart; ++i)
	{
		if (desire[appli] < sizeA[i] - diff)
			break;
		for (int j{ chosen + 1 }; j <= appli && desire[j] <= sizeA[i] + diff; ++j)
		{
			if (own::abs(static_cast<int>(desire[j]) - static_cast<int>(sizeA[i])) <= diff)
			{
				chosen = j;
				++counter; break;
			}
		}
	}
	cout << counter;
	return 0;
}