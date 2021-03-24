package demo01.E06;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ClassInfo extends JFrame {
    String[] columns;
    JTable table;
    DefaultTableModel model; // 默认表格模型

    // 初始化界面
    public void init() {
        setTitle("用List集合传递学生信息");


        Container container = getContentPane();

        // 创建表格
        table = new JTable();
        table.setRowHeight(23); // 设置行高

        columns = new String[]{"姓名", "性别", "出生日期"}; // 列名数组
        model = new DefaultTableModel(columns, 0);

        table.setModel(model);  // 设置表格类型

        List<String> students = getStudent();
        for (String info : students) {
            String[] args = info.split(",");
            model.addRow(args); // 把学生信息添加到表格的行
        }

        // 滚动面板
        container.add(new JScrollPane(table));

        setBounds(100, 100, 300, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    // 创建List集合对象
    public List<String> getStudent() {
        List<String> list = new ArrayList<>();

        list.add("张三,男,1980-1-1");
        list.add("李四,男,1990-1-1");
        list.add("王五,男,1910-1-1");
        list.add("陈六,男,1940-1-1");
        list.add("胡七,男,1970-1-1");
        list.add("张三,男,1980-1-1");
        list.add("李四,男,1990-1-1");
        list.add("王五,男,1910-1-1");
        list.add("陈六,男,1940-1-1");
        list.add("胡七,男,1970-1-1");
        list.add("张三,男,1980-1-1");
        list.add("李四,男,1990-1-1");
        list.add("王五,男,1910-1-1");
        list.add("陈六,男,1940-1-1");
        list.add("胡七,男,1970-1-1");

        return list;
    }


    public static void main(String[] args) {
        new ClassInfo().init();
    }
}
