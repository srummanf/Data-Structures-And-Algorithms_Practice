#include <iostream>
using namespace std;

void insertionSort(int arr[], int left, int right)
{
    for (int i = left + 1; i <= right; ++i)
    {
        int key = arr[i];
        int j = i - 1;
        while (j >= left && arr[j] > key)
        {
            arr[j + 1] = arr[j];
            --j;
        }
        arr[j + 1] = key;
    }
}

void merge(int arr[], int left, int mid, int right)
{
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int leftArr[n1];
    int rightArr[n2];

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

void modifiedMergeSort(int arr[], int left, int right)
{
    if (left < right)
    {
        if (right - left + 1 <= 3)
        {
            // Apply insertion sort for subarrays of length 3 or less
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

int main()
{
    // Read the number of elements
    int n;
    std::cout << "Enter the number of elements: ";
    std::cin >> n;

    // Read the elements
    int arr[n];
    std::cout << "Enter the elements:\n";
    for (int i = 0; i < n; ++i)
    {
        std::cin >> arr[i];
    }

    // Perform modified merge sort
    modifiedMergeSort(arr, 0, n - 1);

    // Print the sorted array
    std::cout << "Sorted array:\n";
    for (int i = 0; i < n; ++i)
    {
        std::cout << arr[i] << "\n";
    }
    std::cout << "\n";

    return 0;
}
