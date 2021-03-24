package demo01.E04;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class RedirectOutputStream {
    public static void main(String[] args) {
        try {
            PrintStream out = System.out;
            // 重定向输出流
            PrintStream ps = new PrintStream("./log.txt");

            System.setOut(ps); // 没有执行重定向, 那么以下的第1-3语句都输出

            String name = "Luffe";
            System.out.println("语句1名字变量成功定义, 初始值为Luffe");
            int age = 18;
            System.out.println("语句2年龄变量成功定义, 初始值为18");
            //整合变量
            String info = name + "今年" + age + "岁";
            System.out.println("语句3整合两个变量为info的字符串变量, 结果是:" + info);

            System.setOut(out);

            System.out.println("语句4程序运行完毕, 请查看日志文件!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }




    }
}
