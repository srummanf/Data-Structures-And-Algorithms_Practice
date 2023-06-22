// Develop a top down dynamic programming algorithm to find minimum cost for matrix chain multiplication. Print the tables maintained by the algorithm. For example, when there are six matrices and the input given is

// 7
// 30 35 15 5 10 20 25

// M table should be printed as

// 15750 7875 9375 11875 15125
// 2625 4375 7125 10500
// 750 2500 5375
// 1000 3500
// 5000
// S table should be printed as
// 1 1 3 3 3
// 2 3 3 3
// 3 3 3
// 4 5
// 5
// Input Format

// First line contains the number of matrices +1, n

// Next line contains the dimensions of the matrices in the chain

// Output Format

// Print the mtable

// Print the s table

// Print the minimum cost

// Example:

// Input:

// 7

// 30 35 15 5 10 20 25

// Output:

// 15750 7875 9375 11875 15125

// 2625 4375 7125 10500

// 750 2500 5375

// 1000 3500

// 5000

// 1 1 3 3 3

// 2 3 3 3

// 3 3 3

// 4 5

// 5

// 15125

#include <iostream>
#include <climits>
using namespace std;

int matrixChain(int p[], int n, int i, int j, int m[][100], int s[][100])
{
    if (m[i][j] > -1)
    {
        return m[i][j];
    }
    if (i == j)
    {
        m[i][j] = 0;
        return m[i][j];
    }
    m[i][j] = INT_MAX;
    int q = 0, k;
    for (k = i; k < j; k++)
    {
        q = matrixChain(p, n, i, k, m, s) + matrixChain(p, n, k + 1, j, m, s) + p[i - 1] * p[k] * p[j];
        if (q < m[i][j])
        {
            m[i][j] = q;
            s[i][j] = k;
        }
    }
    return m[i][j];
}

int main()
{
    int n, i, j;
    cin >> n;
    int p[n];
    for (int i = 0; i < n; i++)
    {
        cin >> p[i];
    }
    int m[n][100]; // Array to store the multiplication costs
    int s[n][100]; // Array to store the bracket positions
    for (i = 1; i < n; i++)
    {
        for (j = 1; j < n; j++)
        {
            m[i][j] = -1;
            s[i][j] = -1;
        }
    }
    int minCost = matrixChain(p, n, 1, n - 1, m, s);

    // Print the cost matrix
    for (i = 1; i < n; i++)
    {
        for (j = 1; j < n; j++)
        {
            if (m[i][j] > 0)
                cout << m[i][j] << " ";
        }
        if (i != n - 1)
        {
            cout << endl;
        }
    }

    // Print the brackets matrix
    for (i = 1; i < n; i++)
    {
        for (j = 1; j < n; j++)
        {
            if (s[i][j] > 0)
                cout << s[i][j] << " ";
        }
        if (i != n - 1)
        {
            cout << endl;
        }
    }

    // Print the minimum cost
    cout << minCost << endl;
    return 0;
}
