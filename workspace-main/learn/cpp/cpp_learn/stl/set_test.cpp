#include <iostream>
#include <set>

using namespace std;

void print_set(set<int> &s)
{
    for (set<int>::iterator it = s.begin(); it != s.end(); it++)
    {
        cout << *it << " ";
    }
    cout << endl;
}

void test01()
{
    set<int> s1;

    s1.insert(10);
    s1.insert(40);
    s1.insert(30);
    s1.insert(20);
    print_set(s1);

    set<int> s2(s1);
    print_set(s2);

    set<int> s3;
    s3 = s2;
    print_set(s3);
}

void test02()
{
    set<int> s1;

    s1.insert(10);
    s1.insert(30);
    s1.insert(20);
    s1.insert(40);

    if (s1.empty())
    {
        cout << "s1 为空" << endl;
    }
    else
    {
        cout << "s1 不为空" << endl;
        cout << "s1 的大小为" << s1.size() << endl;
    }
}

void test03()
{
    set<int> s1;

    s1.insert(10);
    s1.insert(30);
    s1.insert(20);
    s1.insert(40);

    set<int> s2;

    s2.insert(100);
    s2.insert(300);
    s2.insert(200);
    s2.insert(400);

    cout << "交换前" << endl;
    print_set(s1);
    print_set(s2);

    cout << "交换后" << endl;
    s1.swap(s2);
    print_set(s1);
    print_set(s2);
}

void test04()
{
    set<int> s1;

    s1.insert(10);
    s1.insert(30);
    s1.insert(20);
    s1.insert(40);

    print_set(s1);

    s1.erase(s1.begin());
    print_set(s1);

    s1.erase(30);
    print_set(s1);

    // s1.erase(s1.begin(), s1.end());
    s1.clear();
    print_set(s1);
}

void test05()
{
    set<int> s1;

    s1.insert(10);
    s1.insert(30);
    s1.insert(20);
    s1.insert(40);

    set<int>::iterator pos = s1.find(30);

    if (pos != s1.end())
    {
        cout << "找到了元素：" << *pos << endl;
    }
    else
    {
        cout << "未找到元素：" << endl;
    }

    int num = s1.count(30);
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
    set<int> s1;
    s1.insert(10);
    s1.insert(40);
    s1.insert(20);
    s1.insert(30);
    s1.insert(50);

    for (set<int>::iterator it = s1.begin(); it != s1.end(); it++)
    {
        cout << *it << " ";
    }
    cout << endl;

    set<int, MyCompare> s2;
    s2.insert(10);
    s2.insert(40);
    s2.insert(20);
    s2.insert(30);
    s2.insert(50);

    for (set<int, MyCompare>::iterator it = s2.begin(); it != s2.end(); it++)
    {
        cout << *it << " ";
    }
    cout << endl;
}

class Person
{
public:
    Person(string name, int age)
    {
        this->m_Name = name;
        this->m_Age = age;
    }

    string m_Name;
    int m_Age;
};

class comparePerson
{
public:
    bool operator()(const Person &p1, const Person &p2)
    {
        //按照年龄进行排序  降序
        return p1.m_Age > p2.m_Age;
    }
};

void test07()
{
    set<Person, comparePerson> s;

    Person p1("刘备", 23);
    Person p2("关羽", 27);
    Person p3("张飞", 25);
    Person p4("赵云", 21);

    s.insert(p1);
    s.insert(p2);
    s.insert(p3);
    s.insert(p4);

    for (set<Person, comparePerson>::iterator it = s.begin(); it != s.end(); it++)
    {
        cout << "姓名： " << it->m_Name << " 年龄： " << it->m_Age << endl;
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
    test07();
    system("pause");
    return 0;
}