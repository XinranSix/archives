#include <eigen3/Eigen/Eigen>
#include <iostream>

int main() {
    Eigen::Matrix3f r_45, t_1_2;

    float t = 45.0f / 180.0f * (float) std::acos(-1);

    r_45 << std::cos(t), -std::sin(t), 0.0f,
            std::sin(t), std::cos(t), 0.0f,
            0.0f, 0.0f, 1.0f;

    t_1_2 << 1.0f, 0.0f, 1.0f,
             0.0f, 1.0f, 2.0f,
             0.0f, 0.0f, 1.0f;

    Eigen::Vector3f p(2, 1, 1);
    
    std::cout << (t_1_2 * r_45) * p << std::endl;

    return 0;
}


/*
void test() {
    float a = 1.0, b = 2.0;
    std::cout << a << std::endl;
    std::cout << a / b << std::endl;
    std::cout << std::sqrt(a) << std::endl;
    std::cout << std::acos(-1) << std::endl;
    std::cout << std::sin(30.0 / 180.0 * acos(-1)) << std::endl;

    // Example of vector
    std::cout << "Example of vector \n";

    Eigen::Vector3f v(1.0f, 2.0f, 3.0f);
    Eigen::Vector3f w(1.0f, 0.0f, 0.0f);

    std::cout << "Example of output \n";
    std::cout << v << std::endl;

    std::cout << "Example of add \n";
    std::cout << v + w << std::endl;

    std::cout << "Example of scalar multiply \n";
    std::cout << v * 3.0f << std::endl;
    std::cout << 2.0f * v << std::endl;

    std::cout << "Example of dot product" << std::endl;
    std::cout << v.dot(w) << std::endl;

    std::cout << "Example of cross product" << std::endl;
    std::cout << v.cross(w) << std::endl;

    // Example of matrix
    std::cout << "Example of matrix \n";

    Eigen::Matrix3f i, j;
    i << 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0;
    j << 2.0, 3.0, 1.0, 4.0, 6.0, 5.0, 9.0, 7.0, 8.0;

    std::cout << "Example of outpuy \n";
    std::cout << i << std::endl;

    std::cout << "Example of add \n";
    std::cout << i + j << std::endl;

    std::cout << "Example of scalar multiply \n";
    std::cout << i * 2.0 << std::endl;
    std::cout << 2.0 * i << std::endl;

    std::cout << "Example of multiply \n";
    std::cout << i * j << std::endl;

    std::cout << "Example of multiply vector\n";
    std::cout << i * v << std::endl;

    return 0;
}
*/