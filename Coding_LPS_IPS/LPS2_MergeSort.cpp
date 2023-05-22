// Merge Sort without sentinels
/*
#include <iostream>

using namespace std;

void merge(float A[], int p,int q, int r)
{
    int n1 = q - p + 1;
    int n2 = r - q;
    float L1[n1], L2[n2];
    for (int i = 0; i < n1; ++i)
    {
        L1[i] = A[p + i];
    }
    for (int i = 0; i < n2; ++i)
    {
        L2[i] = A[q + i + 1];
    }
    int i = 0, j = 0, k = p;
    while (i < n1 && j < n2)
    {
        if (L1[i] <= L2[j])
        {
            A[k] = L1[i];
            i++;
        }
        else
        {
            A[k] = L2[j];
            j++;
        }
        k++;
    }

    while (i < n1)
    {
        A[k] = L1[i];
        i++;
        k++;
    }
    while (i < n2)
    {
        A[k] = L2[j];
        j++;
        k++;
    }
    while (j < n2)
    {
        A[k] = L2[j];
        j++;
        k++;
    }
}

void mergeSort(float A[], int l, int r)
{
    int m;
    if (l < r)
    {
        m = l + (r - l) / 2;
        mergeSort(A, l, m);
        mergeSort(A, m + 1, r);
        merge(A, l, m, r);
    }
}

void print(float A[], int n)
{
    for (int i = 0; i < n; i++)
    {
        cout << A[i] << "\n";
    }
}

int main()
{
    int n;
    cin >> n;
    float A[n];
    for (int i = 0; i < n; i++)
    {
        cin >> A[i];
    }
    mergeSort(A, 0, n - 1);
    print(A, n);
}

*/

// In the ‘merge-sort’ algorithm, an array of size n, is divided till we get n arrays of size 1. Modify the merge-sort algorithm in such a way that division is not carried out on any subarray of length 4. That is, the minimum length of all the subarrays should be 3 and for the subarray of length 3, apply any constant-time sorting algorithm. Write the code for the modified algorithm.
/*
#include <iostream>
using namespace std;

void insertionSort(float arr[], int left, int right)
{
    for (int i = left + 1; i <= right; ++i)
    {
        float key = arr[i];
        int j = i - 1;
        while (j >= left && arr[j] > key)
        {
            arr[j + 1] = arr[j];
            --j;
        }
        arr[j + 1] = key;
    }
}

void merge(float arr[], int left, int mid, int right)
{
    int n1 = mid - left + 1;
    int n2 = right - mid;

    float leftArr[n1];
    float rightArr[n2];

    for (int i = 0; i < n1; ++i)
    {
        leftArr[i] = arr[left + i];
    }
    for (int i = 0; i < n2; ++i)
    {
        rightArr[i] = arr[mid + 1 + i];
    }

    int i = 0;
    int j = 0;
    int k = left;

    while (i < n1 && j < n2)
    {
        if (leftArr[i] <= rightArr[j])
        {
            arr[k] = leftArr[i];
            ++i;
        }
        else
        {
            arr[k] = rightArr[j];
            ++j;
        }
        ++k;
    }

    while (i < n1)
    {
        arr[k] = leftArr[i];
        ++i;
        ++k;
    }

    while (j < n2)
    {
        arr[k] = rightArr[j];
        ++j;
        ++k;
    }
}

void modifiedMergeSort(float arr[], int left, int right)
{
    if (left < right)
    {
        if (right - left + 1 <= 3)
        {
            insertionSort(arr, left, right);
        }
        else
        {
            int mid = left + (right - left) / 2;
            modifiedMergeSort(arr, left, mid);
            modifiedMergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
}

void print(float A[], int n)
{
    for (int i = 0; i < n; i++)
    {
        cout << A[i] << "\n";
    }
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

    modifiedMergeSort(arr, 0, n - 1);

    print(arr, n);

    return 0;
}
*/