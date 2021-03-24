package demo01.E02;

import java.util.Scanner;

public class InputCode {
    public static void main(String[] args) {

        String str;

        Scanner sc = new Scanner(System.in);

        System.out.print("请输入身份证号:");
        str = sc.nextLine();

        System.out.println("原来你的身份证号码是"+str.length()+"位数字啊");

    }
}
