// Given a sequence of n letters from English alphabet (only lower case) where all the lowercase alphabet a,b,c,….z are assigned with values 1,2,3,…,26 respectively. Write an insertion-sort based algorithm to arrange the given n letters, in an increasing order of their values.

/*
#include <iostream>
using namespace std;

void insertionSortLetters(char sequence[], int n)
{
    int i, j;
    char key;

    for (i = 1; i < n; i++)
    {
        key = sequence[i];
        j = i - 1;
        while (j >= 0 && sequence[j] > key)
        {
            sequence[j + 1] = sequence[j];
            j = j - 1;
        }

        sequence[j + 1] = key;
    }
}

void print(char arr[], int n)
{
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << "\n";
    }
}

int main()
{
    int n;
    cin >> n;

    char sequence[n];
    for (int i = 0; i < n; i++)
    {
        cin >> sequence[i];
    }

    insertionSortLetters(sequence, n);

    print(sequence, n);

    return 0;
}
*/

// Given n points P1, P2, ..., Pn with the coordinates (x1, y1), (x2, y2), ..., (xn, yn) respectively, write an insertion-sort based algorithm and the corresponding code to arrange the points in an increasing order of the distance of the point from the origin (with (0, 0) as the coordinates. Distance between any two points (a1, b1) and (a2, b2) is

#include <iostream>
#include <cmath>
using namespace std;

struct Point
{
    int x;
    int y;
};

double calculateDistance(const Point &p)
{
    return sqrt(p.x * p.x + p.y * p.y);
}

void insertionSort(Point *points, int n)
{
    for (int i = 1; i < n; ++i)
    {
        Point key = points[i];
        int j = i - 1;
        while (j >= 0 && calculateDistance(points[j]) > calculateDistance(key))
        {
            points[j + 1] = points[j];
            --j;
        }
        points[j + 1] = key;
    }
}

int main()
{
    int n;
    cin >> n;

    Point *points = new Point[n];

    for (int i = 0; i < n; ++i)
    {
        cin >> points[i].x >> points[i].y;
    }

    insertionSort(points, n);

    for (int i = 0; i < n; ++i)
    {
        cout << points[i].x << "\n" << points[i].y << "\n";
    }

    return 0;
}
