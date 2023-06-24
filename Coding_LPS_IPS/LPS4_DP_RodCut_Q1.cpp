// A variation of rod cutting problem is one in which length of the rod will be of length greater than or equal to 8 and you can make cuts of rods of length 3 or 5 only.For each unit of wastage a penalty of Rs .1 should be given. Write an recursive algorithm and implement it to find the maximum revenue that may be generated.
// Input Format

// First line contains the length of the rod,
//  n

// Next line contains the price of rod of length 3 and
// 5 separated by a space

// Output Format

// Print the maximum revenue that may be generated

// sample input:
// 3
// 1 5

// sample output:
// 1

// 10 1 5 8 9 10 17 17 20 24 30
// 20 1 5 8 9 10 17 17 20 24 30 1 5 8 9 10 17 17 20 24 30 20 1 5 8 9 10 17 17 20 24 30 1 5 8 9 10 17 17 20 24 30

#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
using namespace std;

int rodCuttingDP(vector<int> &p, vector<int> &revs, int n)
{
    if (revs[n] > 0)
    {
        return revs[n];
    }
    if (n == 0)
    {
        revs[n] = 0;
        return revs[n];
    }
    if (n > 0 && n < 3)
    {
        revs[n] = -1;
        return revs[n];
    }
    int q = INT_MIN;
    q = max(q, p[2] + rodCuttingDP(p, revs, n - 3));
    if (n >= 5)
    {
        q = max(q, p[4] + rodCuttingDP(p, revs, n - 5));
    }
    revs[n] = q;
    return revs[n];
}

int rodCutting(vector<int> &p, int n)
{
    vector<int> mr(n + 1, INT_MIN);
    int ans = rodCuttingDP(p, mr, n);
    return ans;
}

int main()
{
    int len;
    cin >> len;

    vector<int> prices(len + 1);
    cin >> prices[2];
    cin >> prices[4];

    int ans = rodCutting(prices, len);
    cout << ans << endl;

    return 0;
}

// #include <iostream>
// using namespace std;
// #include <vector>
// #include <limits.h>

// int maximum(int a, int b)
// {
//     if (a > b)
//         return a;
//     return b;
// }

// int cut_rod(vector<int> p, int length)
// {
//     int i;
//     int q = INT_MIN;
//     if (length == 0)
//         return 0;
//     for (i = 1; i <= length; i++)
//     {
//         q = maximum(q, p[i - 1] + cut_rod(p, length - i));
//     }
//     return q;
// }

// int main()
// {
//     vector<int> p;
//     int i, n, price, max_profit;
//     cin >> n;
//     for (i = 0; i < n; i++)
//     {
//         cin >> price;
//         p.push_back(price);
//     }
//     max_profit = cut_rod(p, n);
//     cout << max_profit;
// }

// #include <iostream>
// using namespace std;

// int max_revenue(int n, int p2)
// {
//     if (n < 3)
//         return -1;
//     else if (n == 3 || n == 5)
//         return n;
//     else
//     {
//         if (n >= 5)
//         {
//             return max_revenue(n - 5, p2) + 1 * p2;
//         }
//         int revenue_3 = max_revenue(n - 3, p2) + 1;
//         int revenue_5 = max_revenue(n - 5, p2) + 1;
//         int ans = max(revenue_3, revenue_5);
//         return max(revenue_3, revenue_5);
//     }
// }

// int main()
// {
//     int n;
//     cin >> n;

//     int p1, p2;
//     cin >> p1 >> p2;

//     int maxRevenue = max_revenue(n);

//     int wastage = n - maxRevenue;
//     int penalty = wastage * 1;
//     int revenue = (maxRevenue / 3) * p1 + (maxRevenue % 3) * p2 - penalty;

//     cout << revenue << endl;

//     return 0;
// }

// #include <iostream>
// #include <climits>
// using namespace std;

// int max_revenue(int n, int penalty)
// {
//     if (n < 3)
//         return 0;
//     else if (n == 3 || n == 5)
//         return n;
//     else
//     {
//         int revenue_3 = max_revenue(n - 3, penalty) + 3;
//         int revenue_5 = max_revenue(n - 5, penalty) + 5;
//         int revenue = max(revenue_3, revenue_5) - penalty;
//         return revenue;
//     }
// }

// int main()
// {
//     int n;
//     cin >> n;

//     int price_3, price_5;
//     cin >> price_3 >> price_5;

//     int wastage = n % 3;       // Calculate the wastage units
//     int penalty = wastage * 1; // Rs. 1 penalty for each unit of wastage

//     int maxRevenue = max_revenue(n, penalty);

//     int revenue = (n / 3) * price_3 + wastage * price_5 - penalty;

//     cout << revenue << endl;

//     return 0;
// }

// #include <iostream>
// #include <vector>
// #include <climits>
// using namespace std;

// int maximum(int a, int b)
// {
//     if (a > b)
//         return a;
//     return b;
// }

// int cut_rod(vector<int> &p, int length)
// {
//     int i;
//     int q = INT_MIN;
//     if (length == 0)
//         return 0;
//     for (i = 1; i <= length; i++)
//     {
//         int price = p[i - 1];
//         if (i == 3 || i == 5) // Handle cuts of rod length 3 or 5
//             price -= 1;       // Apply penalty of Rs. 1 for each unit of wastage
//         q = maximum(q, price + cut_rod(p, length - i));
//     }
//     return q;
// }

// int main()
// {
//     vector<int> p;
//     int i, n, price, max_profit;
//     cin >> n;
//     for (i = 0; i < n; i++)
//     {
//         cin >> price;
//         p.push_back(price);
//     }
//     max_profit = cut_rod(p, n);
//     cout << max_profit << endl;
//     return 0;
// }

// #include <iostream>
// #include <climits>
// using namespace std;

// int max_revenue(int n, int penalty)
// {
//     if (n < 3)
//         return 0;
//     else if (n == 3 || n == 5)
//         return n;
//     else
//     {
//         int revenue_3 = max_revenue(n - 3, penalty) + 1;
//         int revenue_5 = max_revenue(n - 5, penalty) + 1;
//         int ans =
//         return max(revenue_3, revenue_5) + ;
//     }
// }

// int main()
// {
//     int n;
//     cin >> n;

//     int price_3, price_5;
//     cin >> price_3 >> price_5;

//     int wastage = n % 3;       // Calculate the wastage units
//     int penalty = wastage * 1; // Rs. 1 penalty for each unit of wastage

//     int maxRevenue = max_revenue(n, penalty);

//     int revenue = (n / 3) * price_3 + wastage * price_5 - penalty;

//     cout << revenue << endl;

//     return 0;
// }

// #include <iostream>
// #include <algorithm>
// #include <climits>
// using namespace std;

// int rodCuttingDP(int p[], int revs[], int n)
// {
//     if (revs[n] > 0)
//     {
//         return revs[n];
//     }
//     if (n == 0)
//     {
//         revs[n] = 0;
//         return revs[n];
//     }
//     if (n > 0 && n < 3)
//     {
//         revs[n] = -1;
//         return revs[n];
//     }
//     int q = INT_MIN;
//     q = max(q, p[2] + rodCuttingDP(p, revs, n - 3));
//     if (n >= 5)
//     {
//         q = max(q, p[4] + rodCuttingDP(p, revs, n - 5));
//     }
//     revs[n] = q;
//     return revs[n];
// }
// int rodCutting(int *p, int n)
// {
//     int *mr = new int(n + 1);
//     for (int i = 0; i < n + 1; i++)
//     {
//         mr[i] = INT_MIN;
//     }
//     int ans = rodCuttingDP(p, mr, n);
//     /*for (int i = 0; i < n+1; i++) {
//         cout << mr[i] << endl;
//     }*/
//     return ans;
// }
// int main()
// {
//     int len, i;
//     // cout << "Enter maximum length of the rod: ";
//     cin >> len;
//     int *prices = new int(len);
//     // cout << "Enter price for length 3: ";
//     cin >> prices[2];
//     // cout << "Enter price for length 5: ";
//     cin >> prices[4];
//     int ans = rodCutting(prices, len);
//     cout << ans << endl;
//     return 0;
// }

// #include <iostream>
// using namespace std;

// int maxRevenue(int n, int price3, int price5)
// {
//     if (n < 0)
//         return INT_MIN;
//     if (n == 0)
//         return 0;
//     int revenue3 = maxRevenue(n - 3, price3, price5);
//     int revenue5 = maxRevenue(n - 5, price3, price5);
//     int maxRevenue = max(revenue3, revenue5);
//     if (maxRevenue == INT_MIN)
//         return INT_MIN;
//     return maxRevenue + ((n - maxRevenue * 3) / 5) * price5 + ((n - maxRevenue * 3) % 5) * price3;
// }

// int main()
// {
//     int n, price3, price5;
//     cin >> n >> price3 >> price5;
//     cout << maxRevenue(n, price3, price5) << endl;
//     return 0;
// }
#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
using namespace std;

int rodCuttingDP(vector<int> &p, vector<int> &revs, int n)
{
    if (revs[n] > 0)
    {
        return revs[n];
    }
    if (n == 0)
    {
        revs[n] = 0;
        return revs[n];
    }
    if (n > 0 && n < 3)
    {
        revs[n] = -1;
        return revs[n];
    }
    int q = INT_MIN;
    q = max(q, p[2] + rodCuttingDP(p, revs, n - 3));
    if (n >= 5)
    {
        q = max(q, p[4] + rodCuttingDP(p, revs, n - 5));
    }
    revs[n] = q;
    return revs[n];
}

int rodCutting(vector<int> &p, int n)
{
    vector<int> mr(n + 1, INT_MIN);
    int ans = rodCuttingDP(p, mr, n);
    return ans;
}

int main()
{
    int len;
    cin >> len;

    vector<int> prices(len + 1);
    cin >> prices[2];
    cin >> prices[4];

    int ans = rodCutting(prices, len);
    cout << ans << endl;

    return 0;
}
