#include <iostream>
#include <string>

using namespace std;

struct studnet
{
    string name;
    int age;
    int score;
};

int main()
{
    studnet stu = {"张三", 18, 100};
    studnet *p = &stu;
    p->score = 80; //指针通过 -> 操作符可以访问成员

    cout << "姓名：" << p->name << " 年龄：" << p->age << " 分数：" << p->score << endl;

    system("pause");
    return 0;
}