package demo01.E03;

import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        String name;
        String language;
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入新员工的名字:");
        name = sc.nextLine();
        System.out.println("请输入新员工应聘的编程语言");
        language = sc.nextLine();

        switch (language.hashCode()) {
            case 3254818:
            case 2301506:
            case 2269730:
                System.out.println("员工" + name + "被分配到Java开发部门");
                break;
            case 3104:
            case 2112:
                System.out.println("员工" + name + "被分配到C#开发部门");
                break;
            case -709190099:
            case 955463181:
            case 9745901:
                System.out.println("员工" + name + "被分配到ASP.NET开发部门");
                break;
            default:
                System.out.println("本公司不需要" + language + "语言的程序开发人员");
        }

    }
}
