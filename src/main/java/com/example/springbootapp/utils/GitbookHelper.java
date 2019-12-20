package com.example.springbootapp.utils;

/**
 * desc: GitBook帮助类
 * author: sadcoder333
 * date: 2019/12/20
 **/
public class GitbookHelper {


    public static void main(String[] args) {
        printDir("从C到C++",
                "1.学习C++之前要先学习C语言吗？\n" +
                        "2.C++类和对象到底是什么意思？\n" +
                        "3.如何编译和运行C++程序？\n" +
                        "4.C++命名空间\n" +
                        "5.C++头文件和std命名空间\n" +
                        "6.C++输入输出（cin和cout）\n" +
                        "7.C++变量的定义位置\n" +
                        "8.C++布尔类型（bool）\n" +
                        "9.C++中的const又玩出了新花样\n" +
                        "10.C++ new和delete运算符简介\n" +
                        "11.C++内联函数\n" +
                        "12.内联函数也可以用来代替宏\n" +
                        "13.如何规范地使用内联函数\n" +
                        "14.C++函数的默认参数\n" +
                        "15.到底在什么地方指定默认参数\n" +
                        "16.C++函数重载详解\n" +
                        "17.函数重载过程中的二义性和类型转换");
    }


    public static void printDir(String dir, String str) {
        String[] files = str.split("\n");
        for (int i = 0; i < files.length; i++) {
            String name = files[i];
            String friendlyName = files[i].replace(" ", "");
            System.out.println("- [" + name + "](" + dir + "/" + friendlyName + ".md)");
        }
    }
}
