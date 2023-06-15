#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;

int fact(int n)
{
    if (n == 1)
    {
        return 1;
    }
    else
    {
        return n * fact(n - 1);
    }
}
float summ(int n, int x)
{
    if (n == 1)
    {
        return 1;
    }
    else
    {
        return pow(-1, n - 1) * pow(x, 2 * n - 1) / fact(2 * n - 1) + summ(n - 1, x);
    }
}

float brutef(int n, int x)
{
    float sum = 0.0;
    int num = n;
    for (int i = 1; i <= (2 * num) - 1; i = i + 1)
    {

        sum = sum + pow(-1, i - 1) * pow(x, 2 * i - 1) / fact(2 * i - 1);
    }
    return sum;
}

int main()
{
    clock_t tStart = clock();
    int n, x;
    cin >> n;
    cin >> x;
    cout << setprecision(3) << summ(n, x) << "\n";
    cout << brutef(n, x);
    double time1 = (double)(clock() - tStart) / CLOCKS_PER_SEC;
    cout << "Time taken is " << time1 << endl;


    
}
