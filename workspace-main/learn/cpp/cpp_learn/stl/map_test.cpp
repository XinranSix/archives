#include <iostream>
#include <map>

using namespace std;

void print_map(const map<int, int> &m)
{
    for (map<int, int>::const_iterator it = m.begin(); it != m.end(); it++)
    {
        cout << "key = " << it->first << " value = " << it->second << endl;
    }
    cout << endl;
}

void test01()
{
    map<int, int> m; //默认构造
    m.insert(pair<int, int>(1, 10));
    m.insert(pair<int, int>(2, 20));
    m.insert(pair<int, int>(3, 30));

    print_map(m);

    map<int, int> m2(m);
    print_map(m2);

    map<int, int> m3;
    m3 = m2;
    print_map(m3);
}

void test02()
{
    map<int, int> m;
    m.insert(pair<int, int>(1, 10));
    m.insert(pair<int, int>(2, 20));
    m.insert(pair<int, int>(3, 30));

    if (m.empty())
    {
        cout << "m 为空" << endl;
    }
    else
    {
        cout << "m 不为空" << endl;
        cout << "m 的大小为：" << m.size() << endl;
    }
}

void test03()
{
    map<int, int> m;
    m.insert(pair<int, int>(1, 10));
    m.insert(pair<int, int>(2, 20));
    m.insert(pair<int, int>(3, 30));

    map<int, int> m2;
    m2.insert(pair<int, int>(4, 100));
    m2.insert(pair<int, int>(5, 200));
    m2.insert(pair<int, int>(6, 300));

    cout << "交换前" << endl;
    print_map(m);
    print_map(m2);

    cout << "交换后" << endl;
    m.swap(m2);
    print_map(m);
    print_map(m2);
}

void test04()
{
    map<int, int> m;
    m.insert(pair<int, int>(1, 10));
    m.insert(make_pair(2, 20));
    m.insert(map<int, int>::value_type(3, 30));
    m[4] = 40;
    print_map(m);

    //删除
    m.erase(m.begin());
    print_map(m);

    m.erase(3);
    print_map(m);

    //清空
    m.erase(m.begin(), m.end());
    m.clear();
    print_map(m);
}

void test05()
{
    map<int, int> m;
    m.insert(pair<int, int>(1, 10));
    m.insert(pair<int, int>(2, 20));
    m.insert(pair<int, int>(3, 30));

    map<int, int>::iterator pos = m.find(3);
    if (pos != m.end())
    {
        cout << "找到了元素 key = "
             << (*pos).first
             << " value = "
             << (*pos).second
             << endl;
    }
    else
    {
        cout << "未找到元素" << endl;
    }

    int num = m.count(3);
    cout << "num = " << num << endl;
}

class MyCompare
{
public:
    bool operator()(int v1, int v2)
    {
        return v1 > v2;
    }
};

void test06()
{
    //默认从小到大排序
    //利用仿函数实现从大到小排序
    map<int, int, MyCompare> m;

    m.insert(make_pair(1, 10));
    m.insert(make_pair(2, 20));
    m.insert(make_pair(3, 30));
    m.insert(make_pair(4, 40));
    m.insert(make_pair(5, 50));

    for (map<int, int, MyCompare>::iterator it = m.begin(); it != m.end(); it++)
    {
        cout << "key:"
             << it->first
             << " value:"
             << it->second
             << endl;
    }
}

int main()
{
    test01();
    test02();
    test03();
    test04();
    test05();
    test06();
    system("pause");
    return 0;
}