// Modify the algorithm developed in problem 4(matrix chain multiplication problem)to find the way to parenthesize that will have maximum number of multiplications.Print the matrices with parenthesis that will have maximum number of multiplications as well.For example given three matrices and dimension as follows :

//     4 10 100 5 50

//     The code must print the m table as
//     5000 75000 25000

//     S table as
//     1 1 2

//     Maximum cost is
//     75000

//     Paraenthesization of matrices is(A1(A2A3))

//         Input Format

//     First line contains the number of matrices
//     + 1,
//     n

//     Next line contains the dimensions of the matrices in the chain

//     Output Format

//     Print the mtable

//     Print the s table

//     Print the maximum cost

//     Print the parenthesization that will lead to maximum cost

//     Example :

//     Input :

//     4

//     10 100 5 50

//     Output :

//     5000 75000

//     25000

//     1 1

//     2

//     75000

//     (A1(A2A3))

#include <iostream>
#include <climits>
using namespace std;

const int MAX_SIZE = 100;

int matrixChain(int p[], int n, int m[MAX_SIZE][MAX_SIZE], int s[MAX_SIZE][MAX_SIZE], int i, int j)
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
    m[i][j] = INT_MIN;
    int k, q;
    for (k = i; k < j; k++)
    {
        q = matrixChain(p, n, m, s, i, k) + matrixChain(p, n, m, s, k + 1, j) + p[i - 1] * p[k] * p[j];
        if (q > m[i][j])
        {
            m[i][j] = q;
            s[i][j] = k;
        }
    }
    return m[i][j];
}

void printParenthesis(int s[MAX_SIZE][MAX_SIZE], int i, int j)
{
    if (i == j)
    {
        cout << "A" << i;
        return;
    }
    cout << "(";
    printParenthesis(s, i, s[i][j]);
    printParenthesis(s, s[i][j] + 1, j);
    cout << ")";
}

void printTable(int table[MAX_SIZE][MAX_SIZE], int n)
{
    int i, j;
    for (i = 1; i < n - 1; i++)
    {
        for (j = i + 1; j < n; j++)
        {
            cout << table[i][j] << " ";
        }

        cout << endl;
    }
}

int main()
{
    int n, i, j;
    cin >> n;
    int p[MAX_SIZE];
    for (i = 0; i < n; i++)
    {
        cin >> p[i];
    }
    int m[MAX_SIZE][MAX_SIZE], s[MAX_SIZE][MAX_SIZE];
    for (i = 1; i < n; i++)
    {
        for (j = i + 1; j < n; j++)
        {
            m[i][j] = -1;
            s[i][j] = -1;
        }
    }
    int maxCost = matrixChain(p, n, m, s, 1, n - 1);
    printTable(m, n);
    printTable(s, n);
    cout << maxCost << endl;
    printParenthesis(s, 1, n - 1);
    cout << endl;

    return 0;
}