package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JTextField nameField, valueField;
    private JButton addButton, readButton;
    private JTextArea outputArea;

    public MainFrame() {
        setTitle("Quản lý XML");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Tên thẻ:"));
        nameField = new JTextField(15);
        add(nameField);

        add(new JLabel("Giá trị:"));
        valueField = new JTextField(15);
        add(valueField);

        addButton = new JButton("Thêm Thẻ");
        add(addButton);

        readButton = new JButton("Đọc XML");
        add(readButton);

        outputArea = new JTextArea(10, 30);
        add(new JScrollPane(outputArea));
    }

    public String getTagName() {
        return nameField.getText();
    }

    public String getTagValue() {
        return valueField.getText();
    }

    public void setAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void setReadButtonListener(ActionListener listener) {
        readButton.addActionListener(listener);
    }

    public void setOutputText(String text) {
        outputArea.setText(text);
    }
}