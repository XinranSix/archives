#include <iostream>
#include <list>

using namespace std;

void print_list(const list<int> &L)
{
    for (list<int>::const_iterator it = L.begin(); it != L.end(); it++)
    {
        cout << *it << " ";
    }
    cout << endl;
}

void test01()
{
    list<int> L1;
    L1.push_back(10);
    L1.push_back(20);
    L1.push_back(30);
    L1.push_back(40);
    print_list(L1);

    list<int> L2(L1.begin(), L1.end());
    print_list(L2);

    list<int> L3(L2);
    print_list(L3);

    list<int> L4(10, 1000);
    print_list(L4);
}

void test02()
{
    list<int> L1;
    L1.push_back(10);
    L1.push_back(20);
    L1.push_back(30);
    L1.push_back(40);

    print_list(L1);

    list<int> L2;
    L2 = L1;
    print_list(L2);

    list<int> L3;
    L3.assign(L2.begin(), L2.end());
    print_list(L3);

    list<int> L4;
    L4.assign(10, 100);
    print_list(L4);
}

void test03()
{
    list<int> L1;
    L1.push_back(10);
    L1.push_back(20);
    L1.push_back(30);
    L1.push_back(40);

    list<int> L2;
    L2.assign(10, 1000);

    cout << "交换前：" << endl;
    print_list(L1);
    print_list(L2);

    cout << endl;

    L1.swap(L2);

    cout << "交换后：" << endl;

    print_list(L1);
    print_list(L2);
}

void test04()
{
    list<int> L1;
    L1.push_back(10);
    L1.push_back(20);
    L1.push_back(30);
    L1.push_back(40);

    if (L1.empty())
    {
        cout << "L1 为空：" << endl;
    }
    else
    {
        cout << "L1 不为空：" << endl;
        cout << "L1 的大小为" << L1.size() << endl;
    }

    L1.resize(10);
    print_list(L1);

    L1.resize(2);
    print_list(L1);
}

void test05()
{
    list<int> L;

    L.push_back(10);
    L.push_back(20);
    L.push_back(30);

    L.push_front(100);
    L.push_front(200);
    L.push_front(300);

    print_list(L);

    L.pop_back();
    print_list(L);

    L.pop_front();
    print_list(L);

    list<int>::iterator it = L.begin();
    L.insert(++it, 1000);
    print_list(L);

    it = L.begin();
    L.erase(++it);
    print_list(L);

    L.push_back(10000);
    L.push_back(10000);
    L.push_back(10000);
    print_list(L);
    L.remove(10000);
    print_list(L);

    L.clear();
    print_list(L);
}

void test06()
{
    list<int> L1;
    L1.push_back(10);
    L1.push_back(20);
    L1.push_back(30);
    L1.push_back(40);

    cout << "第一个元素为：" << L1.front() << endl;
    cout << "最后一个元素为：" << L1.back() << endl;

    list<int>::iterator it = L1.begin();
}

void test07()
{
    list<int> L;
    L.push_back(90);
    L.push_back(30);
    L.push_back(20);
    L.push_back(70);
    print_list(L);

    L.reverse();
    print_list(L);

    L.sort();
    print_list(L);

    L.sort([](const int v1, const int v2)
           { return v1 > v2; });
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
    system("pause");
    return 0;
}