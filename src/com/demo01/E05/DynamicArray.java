package demo01.E05;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DynamicArray extends JFrame{
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }

        // invoke 调用
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    DynamicArray frame = new DynamicArray();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

     /**
      * create the frame.
      */
     private JPanel contentPanel;
     private final JPanel panel = new JPanel();
     private JList list;
     private JTextField textField;
     private ArrayList<String> arrayList = new ArrayList();


     public DynamicArray() {
         setTitle("动态数组保存学生的名字");
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setBounds(100, 100, 337, 269);

         contentPanel = new JPanel();
         // 外边距
         contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//         BorderLayout(int hgap, int vgap) :  构造一个具有指定组件（hgap为横向间距，vgap为纵向间距）间距的边框布局。
         // 边界布局-东西南北中
         contentPanel.setLayout(new BorderLayout(0, 0));
         setContentPane(contentPanel);

         JScrollPane scrollPane = new JScrollPane();
         contentPanel.add(scrollPane, BorderLayout.CENTER);

         list = new JList();
         scrollPane.setViewportView(list);

         JPanel panel_1 = new JPanel();
         scrollPane.setColumnHeaderView(panel_1);


         JLabel label = new JLabel("学生姓名: ");
         panel_1.add(label);

         textField = new JTextField();
         textField.setColumns(10);
         panel_1.add(textField);

         panel.setPreferredSize(new Dimension(100, 100));
         contentPanel.add(panel, BorderLayout.EAST);
         // 流式布局
         panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

         JButton btn1 = new JButton("添加学生");
         btn1.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 do_button_1_actionPerformed(e);
             }
         });
         panel.add(btn1);

         JButton btn2 = new JButton("删除学生");
         btn2.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 do_button_2_actionPerformed(e);
             }
         });
         panel.add(btn2);


     }

    private void do_button_1_actionPerformed(ActionEvent e) {
         textField.requestFocusInWindow();
         textField.selectAll(); // 选择文本框准备下次输入
         String text = textField.getText();
         if (text == null) {
             return;
         }
         arrayList.add(text);
         replaceModel();
    }

    private void do_button_2_actionPerformed(ActionEvent e) {
        int selectedIndex = list.getSelectedIndex(); // 获取列表控件的选择坐标
        arrayList.remove(selectedIndex);
        replaceModel();
    }

    private void replaceModel() {
        // 为列表控件设置数据模型显示数组集合中的数据
         list.setModel(new AbstractListModel() {
             @Override
             public int getSize() {
                 return arrayList.size();
             }

             @Override
             public Object getElementAt(int index) {
                 return arrayList.get(index);
             }
         });
    }
}
