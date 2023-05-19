#include <iostream>
#include <string>

using namespace std;

void test01()
{
    string s1;
    cout << "str1 = " << s1 << endl;

    const char *str = "hello world";
    string s2(str);
    cout << "str2 = " << s2 << endl;

    string s3(s2);
    cout << "str3 = " << s3 << endl;

    string s4(10, 'a');
    cout << "str4 = " << s4 << endl;
}

void test02()
{
    cout << "test02" << endl;
    string str1;
    str1 = "hello world";
    cout << "str1 = " << str1 << endl;

    string str2;
    str2 = str1;
    cout << "str2 = " << str2 << endl;

    string str3;
    str3 = 'a';
    cout << "str3 = " << str3 << endl;

    string str4;
    str4.assign("hello c++");
    cout << "str4 = " << str4 << endl;

    string str5;
    str5.assign("hello c++", 5);
    cout << "str5 = " << str5 << endl;

    string str6;
    str6.assign(str5);
    cout << "str6 = " << str6 << endl;

    string str7;
    str7.assign(5, 'x');
    cout << "str7 = " << str7 << endl;
}

void test03()
{
    cout << "~~~~~test 03~~~~~" << endl;

    string str1 = "我";
    str1 += "爱玩游戏";

    cout << "str1 = " << str1 << endl;

    str1 += ':';
    cout << "str1 = " << str1 << endl;

    string str2 = "LOL DNF";

    str1 += str2;
    cout << "str1 = " << str1 << endl;

    string str3 = "I";
    str3.append(" love");
    str3.append("game abcde", 4);
    str3.append(str2, 4, 3);
    cout << "str3 = " << str3 << endl;
}

void test04()
{
    cout << "~~~~~test 04~~~~~" << endl;

    string str1 = "abcdefgde";

    int pos = str1.find("de");
    if (pos == -1)
    {
        cout << "未找到" << endl;
    }
    else
    {
        cout << "pos = " << pos << endl;
    }

    pos = str1.find("");
}

void test05()
{
    cout << "~~~~~test 05~~~~~" << endl;

    string s1 = "hello";
    string s2 = "aello";

    int ret = s1.compare(s2);

    if (ret == 0)
    {
        cout << "s1 等于 s2" << endl;
    }
    else if (ret > 0)
    {
        cout << "s1 大于 s2" << endl;
    }
    else
    {
        cout << "s1 小于 s2" << endl;
    }
}

void test06()
{
    cout << "~~~~~test 06~~~~~" << endl;

    string str = "hello world";
    for (int i = 0; i < str.size(); i++)
    {
        cout << str[i] << " ";
    }
    cout << endl;
    for (int i = 0; i < str.size(); i++)
    {
        cout << str.at(i) << " ";
    }
    cout << endl;

    //字符修改
    str[0] = 'x';
    str.at(1) = 'x';
    cout << str << endl;
}

void test07()
{
    string str = "hello";
    str.insert(1, "111");
    cout << str << endl;
}

void test08()
{
    cout << "~~~~~test08~~~~~" << endl;
    string str = "abcdefg";
    string sub_str = str.substr(1, 3);
    cout << "sub_str = " << sub_str << endl;

    string email = "hello@sina.com";
    int pos = email.find("@");
    string username = email.substr(0, pos);
    username = email.substr(0, 5);
    cout << "pos:" << pos << " username:" << username << endl;
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