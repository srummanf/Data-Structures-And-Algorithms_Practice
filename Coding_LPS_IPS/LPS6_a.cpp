// Prefix of a word W=x1x2..xn are x1, x1x2, x1x2x3,...,x1x2...xn.  Similarly the Suffix of a word W are xn, x(n-1)xn, x(n-2)x(n-1)xn,..., x3x4...xn, x2x3...xn, x1x2x3,...xn.   The prefixes of the word: ‘bear’ are ’b’, ’be’,‘bea’ & ‘bear’ which are of length 1,2,3,& 4 respectively.  Suffixes of the word : bear are 'r', 'ar', 'ear', 'bear', of length 4,3,2,&1 respectively.   Longest common prefix that occur in the words : ’good’ and ’god’ is ’go’.  Longest common suffix that occur in the words : 'good' and 'god' is 'od'. Conisder the sequences of words: w1= good, w2=goose, w3=density, w4=deared, w5=dearest, w6=dearer. Here : ‘goo’ is a longest common prefix of w1 & w2. ‘deare’ is the longest common prefix of w4, w5 & w6. Among the longest common prefixes, ‘goo’ & ‘deare’, ‘deare’ is the longest of the longest common prefix of the given sequence of words. For the sequence of words :’read’, reading, reader, ready, blue, block, good,goose,goat’, we have the longest common prefixes as : read, bl, goo. Hence, ’read’ is the longest of the longest common prefix of the sequence.  In the same way, longest of the longest common suffix  of the words : 'read'. 'bead', 'lead', 'at, 'cat', 'rat' is 'ead'. Given n words, write a program to compute the longest of the longest common prefix that occurs in the given sequence of words and the longest of the longest common suffixes that occur in the given sequence of words. If there are more than one longest of the longest common prefix, your program should print the one which comes first in the alphabetical order.  Similarly, If there are more than one longest of the longest common suffix, your program should print the one which comes first in the alphabetical order.  If there are no longest of the longest common prefixes, your program should output -1.  If there are no longest of the longest common suffixes , your program should output -2.

// Input Format:

// Enter the word w1;

// Enter the word w2

// : ...

// Enter the word wn:

// Enter $ to indicate the end of input.

// Output format:

// Output the longest of the longest common prefix

// Output the longest of the longest common suffix.

#include <iostream>
#include <vector>
#include <algorithm>
#include <utility>
using namespace std;

template <typename T>
void printVector(vector<T> vec);

bool findString(string str, vector<string> vec);

vector<string> findPrefix(string str);

vector<string> findSuffix(string str);

int main()
{
    vector<string> input;
    int i = 0;
    string temp;
    while (true)
    {
        cin >> temp;
        if (temp == "$")
        {
            break;
        }
        input.emplace_back(temp);
    }

    vector<vector<string>> prefixes;
    for (int i = 0; i < input.size(); i++)
    {
        prefixes.emplace_back(findPrefix(input[i]));
    }

    vector<vector<string>> suffixes;
    for (int i = 0; i < input.size(); i++)
    {
        suffixes.emplace_back(findSuffix(input[i]));
    }

    vector<string> commonPrefix;
    vector<string> commonSuffix;

    for (int i = 0; i < prefixes.size(); i++)
    {
        for (int j = 0; j < prefixes[i].size(); j++)
        {
            for (int k = i + 1; k < prefixes.size(); k++)
            {
                if (findString(prefixes[i][j], prefixes[k]))
                {
                    commonPrefix.emplace_back(prefixes[i][j]);
                    break;
                }
            }
        }
    }

    for (int i = 0; i < suffixes.size(); i++)
    {
        for (int j = 0; j < suffixes[i].size(); j++)
        {
            for (int k = i + 1; k < suffixes.size(); k++)
            {
                if (findString(suffixes[i][j], suffixes[k]))
                {
                    commonSuffix.emplace_back(suffixes[i][j]);
                    break;
                }
            }
        }
    }

    if (!commonPrefix.empty())
    {
        sort(commonPrefix.begin(), commonPrefix.end(), [](const string &s1, const string &s2)
             { return s1.length() > s2.length(); });
        cout << commonPrefix[0] << endl;
    }
    else
    {
        cout << -1 << endl;
    }

    if (!commonSuffix.empty())
    {
        sort(commonSuffix.begin(), commonSuffix.end(), [](const string &s1, const string &s2)
             { return s1.length() > s2.length(); });
        cout << commonSuffix[0] << endl;
    }
    else
    {
        cout << -2 << endl;
    }

    return 0;
}

template <typename T>
void printVector(vector<T> vec)
{
    for (int i = 0; i < vec.size(); i++)
    {
        cout << vec[i] << endl;
    }
}

vector<string> findPrefix(string str)
{
    vector<string> prefix;
    string temp;
    for (int i = 1; i <= str.length(); i++)
    {
        prefix.emplace_back(str.substr(0, i));
    }
    return prefix;
}

vector<string> findSuffix(string str)
{
    vector<string> suffix;
    string temp;
    for (int i = 0; i < str.length(); i++)
    {
        suffix.emplace_back(str.substr(i, str.length() - i));
    }
    return suffix;
}

bool findString(string str, vector<string> vec)
{
    for (int i = 0; i < vec.size(); i++)
    {
        if (vec[i] == str)
        {
            return true;
        }
    }
    return false;
}
