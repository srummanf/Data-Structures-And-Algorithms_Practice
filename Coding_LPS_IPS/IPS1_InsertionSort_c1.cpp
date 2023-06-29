 #include <iostream>
using namespace std;
int main()
{
    int key, i, j, n, num_comp;
    cout << "Enter the size of array: ";
    cin >> n;
    int elements[n];
    for (i = 0; i < n; i++)
    {
        cout << "Enter element " << i + 1 << ": ";
        cin >> elements[i];
    }
    int query, flag;
    cout << "Enter the value to be searched:";
    cin >> query;
    num_comp = 0;
    for (j = 1; j < n; j++)
    {
        key = elements[j];
        i = j - 1;
        while ((i >= 0) && (elements[i] > key))
        {
            num_comp++;
            elements[i + 1] = elements[i];
            i = i - 1;
        }
        elements[i + 1] = key;
    }
    for (i = 0; i < n; i++)
    {
        if (elements[i] == query)
        {
            cout << "Element found at position " << i + 1 << endl;
            break;
        }
    }
}
