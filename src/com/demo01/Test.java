package demo01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class Test extends JFrame {

    private JPanel contentPane;
    private final JPanel panel = new JPanel();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        //invoke 调用
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Test frame = new Test();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Test() {
//        setTitle("\u7528\u52A8\u6001\u6570\u7EC4\u4FDD\u5B58\u5B66\u751F\u59D3\u540D");
        setTitle("用动态数组保存学生名字");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 337, 269);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        list = new JList();
        scrollPane.setViewportView(list);

        JPanel panel_1 = new JPanel();
        scrollPane.setColumnHeaderView(panel_1);

        JLabel label = new JLabel("学生姓名:");
        panel_1.add(label);

        textField = new JTextField();
        panel_1.add(textField);
        textField.setColumns(10);
        panel.setPreferredSize(new Dimension(100, 10));
        contentPane.add(panel, BorderLayout.EAST);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton button = new JButton("添加学生");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel.add(button);

        JButton button_1 = new JButton("删除学生");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        panel.add(button_1);
    }

    private ArrayList<String> arraylist = new ArrayList<String>();
    private JTextField textField;
    private JList list;

    protected void do_button_actionPerformed(ActionEvent e) {
        textField.requestFocusInWindow();
        textField.selectAll();// 选择文本框文本准备下次输入
        String text = textField.getText();// 获取用户输入姓名
        if (text.isEmpty())// 过滤为输入姓名的情况
            return;
        arraylist.add(text);// 把姓名添加到数组集合中
        replaceModel();// 把数组集合中内容显示到界面列表控件中
    }

    protected void do_button_1_actionPerformed(ActionEvent e) {
        Object value = list.getSelectedValue();// 获取列表控件的选择项
        arraylist.remove(value);// 从数组集合中移除用户的选择项
        replaceModel();// 把数组集合中内容显示到界面列表控件中
    }

    private void replaceModel() {
        // 为列表控件设置数据模型显示数组集合中的数据
        list.setModel(new AbstractListModel() {
            @Override
            public int getSize() {// 获取数组大小
                return arraylist.size();
            }

            @Override
            public Object getElementAt(int index) {// 获取指定索引元素
                return arraylist.get(index);
            }
        });
    }
}
