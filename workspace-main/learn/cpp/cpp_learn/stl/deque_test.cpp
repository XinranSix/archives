#include <iostream>
#include <deque>
#include <algorithm>

using namespace std;

void print_deque(const deque<int> &d)
{
    for (deque<int>::const_iterator it = d.begin(); it != d.end(); it++)
    {
        cout << *it << " ";
    }
    cout << endl;
}

void test01()
{
    deque<int> d1;
    for (int i = 0; i < 10; i++)
    {
        d1.push_back(i);
    }
    print_deque(d1);

    deque<int> d2(d1.begin(), d1.end());
    print_deque(d2);

    deque<int> d3(10, 100);
    print_deque(d3);

    deque<int> d4 = d3;
    print_deque(d4);
}

void test02()
{
    deque<int> d1;
    for (int i = 0; i < 10; i++)
    {
        d1.push_back(i);
    }
    print_deque(d1);

    deque<int> d2;
    d2 = d1;
    print_deque(d2);

    deque<int> d3;
    d3.assign(d1.begin(), d1.end());
    print_deque(d3);

    deque<int> d4;
    d4.assign(10, 100);
    print_deque(d4);
}

void test03()
{
    deque<int> d1;
    for (int i = 0; i < 10; i++)
    {
        d1.push_back(i);
    }
    print_deque(d1);

    if (d1.empty())
    {
        cout << "d1 为空" << endl;
    }
    else
    {
        cout << "d1 不为空" << endl;
        cout << "d1 的大小为" << d1.size() << endl;
    }

    d1.resize(15, 1);
    print_deque(d1);

    d1.resize(5);
    print_deque(d1);
}

void test04()
{
    deque<int> d;

    d.push_back(10);
    d.push_back(20);

    d.push_front(100);
    d.push_front(200);

    print_deque(d);

    d.pop_back();

    d.pop_front();

    print_deque(d);
}

void test05()
{
    deque<int> d;
    d.push_back(10);
    d.push_back(20);
    d.push_front(100);
    d.push_front(200);
    print_deque(d);

    d.insert(d.begin(), 1000);
    print_deque(d);

    d.insert(d.begin(), 2, 10000);
    print_deque(d);

    deque<int> d2;
    d2.push_back(1);
    d2.push_back(2);
    d2.push_back(3);

    d.insert(d.begin(), d2.begin(), d2.end());
    print_deque(d);
}

void test06()
{
    deque<int> d;
    d.push_back(10);
    d.push_back(20);
    d.push_front(100);
    d.push_front(200);

    print_deque(d);

    d.erase(d.begin());
    print_deque(d);

    d.erase(d.begin(), d.end());
    d.clear();
    print_deque(d);
}

void test07()
{
    deque<int> d;
    d.push_back(10);
    d.push_back(20);
    d.push_front(100);
    d.push_front(200);

    for (int i = 0; i < d.size(); i++)
    {
        cout << d[i] << " ";
    }
    cout << endl;

    for (int i = 0; i < d.size(); i++)
    {
        cout << d.at(i) << " ";
    }
    cout << endl;

    cout << "front: " << d.front() << endl;
    cout << "back: " << d.back() << endl;
}

void test08()
{
    deque<int> d;
    d.push_back(10);
    d.push_back(20);
    d.push_front(100);
    d.push_front(200);

    print_deque(d);
    sort(d.begin(), d.end(), [](const int v1, const int v2)
         { return v1 > v2; });
    print_deque(d);
}

int main()
{
    test01();
    test02();
    test03();
    test04();
    test05();
    test06();
    test07();
    test08();
    system("pause");
    return 0;
}
