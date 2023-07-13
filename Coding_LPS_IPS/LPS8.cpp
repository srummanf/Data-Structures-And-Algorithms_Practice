// Naive string matching without Overlapping
//     Given a text T and a pattern P,
//     implement the naive algorithm to print the non - overlapping positions of P in T.For example, if T is "aaaaaaaa" and pattern is "aa" then the code should print 0, 2, 4, 6(programming indices - non - over lapping)

//                                                                                                                                                                                  Input Format

//     First line contains the text,
//     T

//     Next line contains the pattern,
//     P

//         Output Format

//         Print non
//         - overlapping indices,
//     one value in one line

//     Example :

//     Input :

//     aaaaaaaa

//     aa

//     Output :

//     0

//     2

//     4

//     6

#include <iostream>
#include <string>

bool checkPattern(const std::string &T, const std::string &P, int s)
{
    int m = P.length();
    for (int i = 0; i < m; i++)
    {
        if (P[i] != T[s + i + 1])
            return false;
    }
    return true;
}

void naiveStringMatcher(const std::string &T, const std::string &P)
{
    int n = T.length();
    int m = P.length();
    int s = -1;
    while (s <= n - m - 1)
    {
        if (checkPattern(T, P, s))
        {
            std::cout << s + 1 << std::endl;
            s += m;
        }
        else
        {
            s++;
        }
    }
}

int main()
{
    std::string T, P;
    std::cin >> T >> P;
    naiveStringMatcher(T, P);
    return 0;
}
