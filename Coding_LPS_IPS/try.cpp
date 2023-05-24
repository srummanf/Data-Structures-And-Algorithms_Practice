#include <iostream>
using namespace std;

void merge(float arr[], int low, int mid1, int mid2, int high)
{
    int n1 = mid1 - low + 1;
    int n2 = mid2 - mid1;
    int n3 = high - mid2;

    float left[n1], middle[n2], right[n3];

    for (int i = 0; i < n1; i++)
        left[i] = arr[low + i];
    for (int i = 0; i < n2; i++)
        middle[i] = arr[mid1 + 1 + i];
    for (int i = 0; i < n3; i++)
        right[i] = arr[mid2 + 1 + i];

    int i = 0, j = 0, k = 0, p = low;

    while (i < n1 && j < n2 && k < n3)
    {
        if (left[i] <= middle[j] && left[i] <= right[k])
        {
            arr[p] = left[i];
            i++;
        }
        else if (middle[j] <= left[i] && middle[j] <= right[k])
        {
            arr[p] = middle[j];
            j++;
        }
        else
        {
            arr[p] = right[k];
            k++;
        }
        p++;
    }

    while (i < n1)
    {
        arr[p] = left[i];
        i++;
        p++;
    }

    while (j < n2)
    {
        arr[p] = middle[j];
        j++;
        p++;
    }

    while (k < n3)
    {
        arr[p] = right[k];
        k++;
        p++;
    }
}

void mergeSort(float arr[], int low, int high)
{
    if (low < high)
    {
        int mid1 = low + (high - low) / 3;
        int mid2 = low + 2 * (high - low) / 3;

        mergeSort(arr, low, mid1);
        mergeSort(arr, mid1 + 1, mid2);
        mergeSort(arr, mid2 + 1, high);

        merge(arr, low, mid1, mid2, high);
    }
}

void printArray(float arr[], int size)
{
    for (int i = 0; i < size; i++)
        cout << arr[i] << "\n";
}

int main()
{
    int n;
    cin >> n;

    float arr[n];
    for (int i = 0; i < n; ++i)
    {
        cin >> arr[i];
    }
    mergeSort(arr, 0, n - 1);
    printArray(arr, n);
    return 0;
}
