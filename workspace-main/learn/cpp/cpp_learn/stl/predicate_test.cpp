#include <vector>
#include <algorithm>
#include <iostream>
#include <functional>

using namespace std;

struct GreaterFive
{
    bool operator()(int v)
    {
        return v > 5;
    }
};

void test01()
{
    vector<int> v;
    for (int i = 0; i < 10; i++)
    {
        v.push_back(i);
    }

    vector<int>::iterator it = find_if(v.begin(), v.end(), GreaterFive());

    if (it == v.end())
    {
        cout << "未找到！" << endl;
    }
    else
    {
        cout << "找到：" << *it << endl;
    }
}

class MyCompare
{
public:
    bool operator()(int num1, int num2)
    {
        return num1 > num2;
    }
};

void test02()
{
    vector<int> v;
    v.push_back(10);
    v.push_back(40);
    v.push_back(20);
    v.push_back(30);
    v.push_back(50);

    //默认从小到大
    sort(v.begin(), v.end());
    for (vector<int>::iterator it = v.begin(); it != v.end(); it++)
    {
        cout << *it << " ";
    }
    cout << endl;
    cout << "----------------------------" << endl;

    //使用函数对象改变算法策略，排序从大到小
    sort(v.begin(), v.end(), MyCompare());
    for (vector<int>::iterator it = v.begin(); it != v.end(); it++)
    {
        cout << *it << " ";
    }
    cout << endl;
}

void test03()
{
    negate<int> n;
    cout << n(50) << endl;
}

void test04()
{
    plus<int> p;
    cout << p(10, 20) << endl;
}

int main()
{
    test01();
    test02();
    test03();
    test04();
    system("pause");
    return 0;
}