// Given the sequence X = ABCCDEFGACD, Y = AFCGFCABD, Longest Common Alternating Subsequence(LCAS)
// of X and Y is FAD.As an illustraton, the characters of FAD occurs in both X and Y in such a way that F and A are separated by exactly one character, A and D are also separated by exactly one character, in X and Y.Let X_m be a string of length m and Y_n be a string of length n.Given two sequences<X_m, Y_n>, design a dynamic programming based pseudocode and an appropriate code to compute LCAS of X_m and Y_n.Your code should print all the possible LCAS of X_m and Y_n.If LCAS of X and Y is an empty string, your algorithm should return -1

//                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 Input Format Enter the string X

//                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     Enter the string Y

//                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         Output format :

//     Print the LCAS of X and
//     Y

#include <iostream>
#include <limits.h>
#include <vector>
    using namespace std;
void LCAS(vector<vector<char>> &b, string s1, string s2, int i, int j, int m, int n)
{
    if (i > m || j > n)
    {
        return;
    }
    if (b[i][j] == 'd')
    {
        cout << s1[i - 1];
        return LCAS(b, s1, s2, i + 2, j + 2, m, n);
    }
    return;
}
void lcs_length(string x, string y, vector<vector<int>> &c, vector<vector<char>> &b)
{
    int m, n, i, j;
    m = x.length();
    n = y.length();
    for (i = 1; i <= m; i++)
    {
        for (j = 1; j <= n; j++)
        {
            if (x[i - 1] == y[j - 1])
            {
                c[i][j] = c[i - 1][j - 1] + 1;
                b[i][j] = 'd';
            }
            else if (c[i - 1][j] >= c[i][j - 1])
            {
                c[i][j] = c[i - 1][j];
                b[i][j] = 'u';
            }
            else
            {
                c[i][j] = c[i][j - 1];
                b[i][j] = 'l';
            }
        }
    }
}
void print_LCS(vector<vector<char>> &b, string x, int i, int j)
{
    if ((i == 0) || (j == 0))
        return;
    if (b[i][j] == 'd')
    {
        print_LCS(b, x, i - 1, j - 1);
        cout << x[i - 1];
    }
    else if (b[i][j] == 'u')
    {
        print_LCS(b, x, i - 1, j);
    }
    else
        print_LCS(b, x, i, j - 1);
}
int main()
{
    string x, y;
    int i, j;
    cin >> x >> y;
    vector<vector<int>> c(x.length() + 1, vector<int>(y.length() + 1, 0));
    vector<vector<char>> b(x.length() + 1, vector<char>(y.length() + 1, ' '));
    lcs_length(x, y, c, b);
    if (c[x.length()][y.length()] == 0)
    {
        cout << -1 << endl;
    }
    else
    {
        for (i = 1; i < x.length() - 1; i++)
        { 
            int flag = 0;
            for (j = 1; j < y.length() - 1; j++)
            {
                if (b[i][j] == 'd' && b[i + 2][j + 2] == 'd')
                {
                    flag = 1;
                    LCAS(b, x, y, i, j, x.length(), y.length());
                }
            }
            if (i != x.length() - 2 && flag == 1)
            {
                cout << endl;
            }
        }
    }
}
