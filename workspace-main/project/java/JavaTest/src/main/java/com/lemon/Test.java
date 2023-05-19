package com.lemon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        File src = new File("C:\\Users\\yaojie\\Desktop\\src");
        File dist = new File("C:\\Users\\yaojie\\Desktop\\dist");
        read(src, dist, 0);
    }


    private static void read(File src, File dist, int cur) throws IOException {
        if (cur == 0) {
            File[] files = src.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    return;
                }
                File file1 = new File(dist, file.getName());
                file1.mkdir();
                read(file, file1, cur + 1);
            }
        }
        if (cur == 1) {
            File[] files = src.listFiles();
            FileWriter fileWriter = new FileWriter(new File(dist, "CMakeLists.txt"));
            for (File file : files) {
                if (file.isFile()) {
                    return;
                }
                File file1 = new File(dist, file.getName());
                file1.mkdir();
                fileWriter.write("add_subdirectory(" + file1.getName() + ")\n");
                fileWriter.flush();
                read(file, file1, cur + 1);
            }
        }
        if (cur == 2) {
            // File[] files = src.listFiles();
            FileWriter fileWriter = new FileWriter(new File(dist, "CMakeLists.txt"));
            fileWriter.write("aux_source_directory (. SRC_LIST)\n" +
                    "\n" +
                    "add_executable(" + src.getName() + " ${SRC_LIST})\n" +
                    "\n" +
                    "find_package(glad CONFIG REQUIRED)\n" +
                    "find_package(OpenGL REQUIRED)\n" +
                    "find_package(glfw3 CONFIG REQUIRED)\n" +
                    "\n" +
                    "target_link_libraries(" + src.getName() + " PRIVATE glfw)\n" +
                    "target_link_libraries(" + src.getName() + " PRIVATE OpenGL::GL)\n" +
                    "target_link_libraries(" + src.getName() + " PRIVATE glad::glad)\n");
            fileWriter.flush();
            fileWriter = new FileWriter(new File(dist, "main.cpp"));
            fileWriter.write("#include <iostream>\n" +
                    "\n" +
                    "int main() {\n" +
                    "    std::cout << \"He llo\" << std::endl;\n" +
                    "    return 0;\n" +
                    "}");
            fileWriter.flush();
        }
    }
}
