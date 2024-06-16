#include <iostream>

using namespace std;

int main(void)
{
    int n, x;

    scanf("%d %d", &n, &x);
    int *arr = new int[n];

    for (int i = 0; i < n; i++)
    {
        scanf("%d",&arr[i]);
    }

    int sum = 0;
    int max = 0;

    for (int i = 0; i < x; i++)
    {
        sum += arr[i];
        max = sum;
    }

    for (int i = 0; i < n - x; i++)
    {
        sum -= arr[i];
        sum += arr[i + x];
        if (sum > max)
        {
            max = sum;
        }
    }
    printf("%d", max);
}