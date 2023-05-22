#include <iostream>
using namespace std;

void InsertionSortAsc(int arr[], int n)
{
    int key, i, j, num_comp;
    num_comp = 0;
    for (j = 1; j < n; j++)
    {
        key = arr[j];
        i = j - 1;
        while ((i >= 0) && (arr[i] > key))
        {
            num_comp++;
            arr[i + 1] = arr[i];
            i = i - 1;
        }
        arr[i + 1] = key;
    }
}

void InsertionSortDesc(int arr[], int n)
{
    int key, i, j, num_comp;
    num_comp = 0;
    for (j = 1; j < n; j++)
    {
        key = arr[j];
        i = j - 1;
        while ((i >= 0) && (arr[i] < key))
        {
            num_comp++;
            arr[i + 1] = arr[i];
            i = i - 1;
        }
        arr[i + 1] = key;
    }
}

void print(int arr[], int n)
{
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
}

int main()
{
    int n;
    cout << "Enter the size of array: ";
    cin >> n;
    int elements[n];
    for (int i = 0; i < n; i++)
    {
        cout << "Enter element " << i + 1 << ": ";
        cin >> elements[i];
    }
    int A[50], B[50];
    int x = 0, y = 0;
    for (int i = 0; i < n; i++)
    {
        if (elements[i] >= 0)
        {
            A[x] = elements[i];
            x++;
        }
        else
        {
            B[y] = elements[i];
            y++;
        }
    }
    InsertionSortAsc(A, x);
    InsertionSortDesc(B, y);
    print(B, y);
    print(A, x);
}
