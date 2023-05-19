#include <iostream>
#include <vector>

using namespace std;

void print_vector(vector<int> &v)
{
    for (vector<int>::iterator it = v.begin(); it != v.end(); it++)
    {
        cout << *it << " ";
    }
    cout << endl;
}

void test01()
{
    vector<int> v1;
    for (int i = 0; i < 10; i++)
    {
        v1.push_back(i);
    }
    print_vector(v1);

    vector<int> v2(v1.begin(), v1.end());
    print_vector(v2);

    vector<int> v3(10, 100);
    print_vector(v3);

    vector<int> v4(v3);
    print_vector(v4);
}

void test02()
{
    vector<int> v1;
    for (int i = 0; i < 10; i++)
    {
        v1.push_back(i);
    }
    print_vector(v1);

    vector<int> v2;
    v2 = v1;
    print_vector(v2);

    vector<int> v3;
    v3.assign(v1.begin(), v1.end());
    print_vector(v3);

    vector<int> v4;
    v4.assign(10, 100);
    print_vector(v4);
}

void test03()
{
    vector<int> v1;
    for (int i = 0; i < 10; i++)
    {
        v1.push_back(i);
    }
    print_vector(v1);
    if (v1.empty())
    {
        cout << "v1 为空" << endl;
    }
    else
    {
        cout << "v1 不为空" << endl;
        cout << "v1 的容量" << v1.capacity() << endl;
        cout << "v1 的大小" << v1.size() << endl;
    }

    v1.resize(15, 10);
    print_vector(v1);

    v1.resize(5);
    print_vector(v1);
}

void test04()
{
    vector<int> v1;

    //尾插
    v1.push_back(10);
    v1.push_back(20);
    v1.push_back(30);
    v1.push_back(40);
    v1.push_back(50);

    print_vector(v1);

    v1.pop_back();
    print_vector(v1);

    v1.insert(v1.begin(), 100);
    print_vector(v1);

    v1.insert(v1.begin(), 2, 1000);
    print_vector(v1);

    v1.erase(v1.begin());
    print_vector(v1);

    v1.erase(v1.begin(), v1.end());
    print_vector(v1);

    v1.clear();
    print_vector(v1);
}

void test05()
{
    vector<int> v1;

    for (int i = 0; i < 10; i++)
    {
        v1.push_back(i);
    }
    for (int i = 0; i < v1.size(); i++)
    {
        cout << v1[i] << " ";
    }
    cout << endl;

    for (int i = 0; i < v1.size(); i++)
    {
        cout << v1.at(i) << " ";
    }

    cout << endl;

    cout << "v1 的第一个元素为：" << v1.front() << endl;
    cout << "v2 的最后一个元素为：" << v1.back() << endl;
}

void test06()
{
    vector<int> v1;
    for (int i = 0; i < 10; i++)
    {
        v1.push_back(i);
    }
    print_vector(v1);
    vector<int> v2;
    for (int i = 10; i > 0; i--)
    {
        v2.push_back(i);
    }
    print_vector(v2);
    cout << "互换后" << endl;
    v1.swap(v2);
    print_vector(v1);
    print_vector(v2);
}

void test07()
{
    vector<int> v;
    for (int i = 0; i < 100000; i++)
    {
        v.push_back(i);
    }

    cout << "v 的容量为：" << v.capacity() << endl;
    cout << "v 的大小为：" << v.size() << endl;

    v.resize(3);

    cout << "v 的容量为：" << v.capacity() << endl;
    cout << "v 的大小为：" << v.size() << endl;

    vector<int>(v).swap(v);

    cout << "v 的容量为：" << v.capacity() << endl;
    cout << "v 的大小为：" << v.size() << endl;
}

void test08()
{
    vector<int> v;

    v.reserve(100000);

    int num = 0;
    int *p = nullptr;
    for (int i = 0; i < 100000; i++)
    {
        v.push_back(i);
        if (p != &v[0])
        {
            p = &v[0];
            num++;
        }
    }
    cout << "num:" << num << endl;
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