package demo01.E04;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class RedirectOutputStreamExtend {
    public static void main(String[] args) {

        try {
            PrintStream err = System.err;
            PrintStream ps = new PrintStream("./err.txt");
            System.setErr(ps);  // 设置使用新的输出流

            String e1 = "error1";
            System.err.println("e2设置为error1");
            String e2 = "error2";
            System.err.println("e2设置为error2");

            // 整合
            String info = "错误有:" + e1 +"," + e2;
            // serr
            System.err.println("整合变量, 结果:" + info);

            System.setErr(err); // 恢复原有的输出流

            System.out.println("程序运行完毕, 请查看日志文件!");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
