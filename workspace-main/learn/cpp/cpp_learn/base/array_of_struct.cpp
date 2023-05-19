#include <iostream>
#include <string>

using namespace std;

struct student
{
    string name;
    int age;
    int score;
};

int main()
{
    struct student arr[3] = {
        {"张三", 18, 80},
        {"李四", 19, 60},
        {"王五", 20, 70}};

    for (int i = 0; i < 3; i++)
    {
        cout << "姓名：" << arr[i].name << " 年龄：" << arr[i].age << " 分数：" << arr[i].score << endl;
    }

    system("pause");
    return 0;
}