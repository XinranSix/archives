#include <iostream>

using namespace std;

const double PI = 3.14;

class Circle
{
public: //访问权限  公共的权限
    //属性
    int m_r; //半径

    //行为
    //获取到圆的周长
    double calculateZC()
    {
        // 2 * pi  * r
        //获取圆的周长
        return 2 * PI * m_r;
    }
};

int main()
{
    //通过圆类，创建圆的对象
    // c1就是一个具体的圆
    Circle c1;
    c1.m_r = 10; //给圆对象的半径 进行赋值操作

    // 2 * pi * 10 = = 62.8
    cout << "圆的周长为： " << c1.calculateZC() << endl;

    system("pause");
    return 0;
}