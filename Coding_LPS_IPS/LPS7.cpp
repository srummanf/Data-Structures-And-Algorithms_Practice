// Activity Selection Sort Recursive
//     Given a set ‘S’ of ‘n’ activities,
//     implement the recursive greedy algorithm to select a subset of activities from S by selecting the task that finishes first.Sort the activities in ascending order based on finish time and then select the activities

//         Input Format

//             First line contains the number of activities,
//     n

//         Next 'n' line contains the details of the activities such as name of activity,
//     start time and finish time

//         Output Format

//             Print the name of the activities that are selected separated by a space

//                 Input :

//     11

//     a3 0 6

//     a1 1 4

//     a4 5 7

//     a2 3 5

//     a5 3 9

//     a11 12 16

//     a6 5 9

//     a9 8 12

//     a7 6 10

//     a8 8 11

//     a10 2 14

//     Output :

//     a1 a4 a8 a11

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Activity
{
    string name;
    int start_time;
    int finish_time;
};

// Recursive greedy algorithm to select activities
void selectActivities(vector<Activity> &activities, vector<Activity> &selected, int index)
{
    if (index >= activities.size())
        return;

    // Select the activity with the earliest finish time
    selected.push_back(activities[index]);

    // Find the next compatible activity
    int next_index = index + 1;
    while (next_index < activities.size() && activities[next_index].start_time < activities[index].finish_time)
        next_index++;

    // Recursively select activities starting from the next compatible activity
    selectActivities(activities, selected, next_index);
}

int main()
{
    int n;
    // cout << "Enter the number of activities: ";
    cin >> n;

    vector<Activity> activities(n);
    for (int i = 0; i < n; i++)
    {
        // cout << "Enter activity " << i + 1 << " details (name start_time finish_time): ";
        cin >> activities[i].name >> activities[i].start_time >> activities[i].finish_time;
    }

    // Sort activities based on finish time in ascending order
    sort(activities.begin(), activities.end(), [](const Activity &a1, const Activity &a2)
         { return a1.finish_time < a2.finish_time; });

    vector<Activity> selected;
    selectActivities(activities, selected, 0);

    for (const auto &activity : selected)
        cout << activity.name << " ";
    cout << endl;

    return 0;
}