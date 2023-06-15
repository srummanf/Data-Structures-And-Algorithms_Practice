#include <iostream>
// using namespace std;

// int max_revenue(int n)
// {
//     if (n < 3)
//         return 0;
//     else if (n == 3 || n == 5)
//         return n;
//     else
//     {
//         int revenue_3 = max_revenue(n - 3) + 1;
//         int revenue_5 = max_revenue(n - 5) + 1;
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