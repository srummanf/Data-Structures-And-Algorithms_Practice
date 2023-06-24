#include <iostream>
#include <algorithm>
#include <climits>
#include <vector>
using namespace std;

int rcdp(vector<int> &p, vector<int> &revs, int n, vector<int> &props, int t)
{
    if (revs[n] >= 0)
    {
        return revs[n];
    }
    if (n == 0)
    {
        revs[n] = 0;
        return revs[n];
    }
    if (n > 0 && n < props[0])
    {
        revs[n] = -1;
        return revs[n];
    }
    int q = INT_MIN;
    for (int i = 0; i < t; i++)
    {
        if (props[i] <= n)
        {
            q = max(q, p[props[i] - 1] + rcdp(p, revs, n - props[i], props, t));
        }
    }
    revs[n] = q;
    return revs[n];
}

int rc(vector<int> &p, int n, vector<int> &props, int t)
{
    vector<int> maxRevs(n + 1, INT_MIN);
    int maxRev = rcdp(p, maxRevs, n, props, t);
    return maxRev;
}

int main()
{
    int len, i;
    cin >> len;
    vector<int> prices(len);
    for (i = 0; i < len; ++i)
    {
        cin >> prices[i];
    }
    int t;
    cin >> t;
    vector<int> props(t);
    for (i = 0; i < t; i++)
    {
        cin >> props[i];
    }
    int maxRev = rc(prices, len, props, t);
    cout << maxRev << endl;
    return 0;
}
