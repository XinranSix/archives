#include <iostream>
#include <vector>
#include <map>

using namespace std;

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        map<int, int> memo;
        vector<vector<int>> res;
        for (int i = 0; i < nums.size(); i++) memo.insert(make_pair(nums[i], i));
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                map<int, int>::iterator it = memo.find(0 - nums[i] - nums[j]);
                if (it != memo.end() && it->second > j) {
                    vector<int> cur;
                    cur.push_back(nums[i]);
                    cur.push_back(nums[j]);
                    cur.push_back(it->first);
                    res.push_back(cur);
                }
            }
        }
        return res;
    }
};

int main() {
	vector<int> res(3, 0);
	Solution().threeSum(res);
	system("pause");
	return 0;
}