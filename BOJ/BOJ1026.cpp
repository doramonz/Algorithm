#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

bool compare(int a, int b) { return a < b; }

int main(void) {
  ios::sync_with_stdio(false);
  cin.tie(NULL);

  int n;
  vector<int> a;
  vector<int> b;

  cin >> n;

  for (int i = 0; i < n; i++) {
    int t;
    cin >> t;
    a.push_back(t);
  }
  for (int i = 0; i < n; i++) {
    int t;
    cin >> t;
    b.push_back(t);
  }

  sort(a.begin(), a.end(), compare);
  sort(b.begin(), b.end(), compare);

  int res = 0;

  for (int i = 0; i < n; i++) {
    res = res + a.at(i) * b.at(n - i - 1);
  }
  cout << res;
}