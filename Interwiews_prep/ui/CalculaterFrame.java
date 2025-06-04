package Interviews_prep.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculaterFrame extends JFrame implements ActionListener {

    private JTextField num1Field, num2Field, resultField;
    private JButton addButton, multButton, divButton, subButton;

    public CalculaterFrame() {
        setTitle("Simple Calculator");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(200, 150, 255));


        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));


        JPanel inputPanel = new JPanel(new FlowLayout());
        JPanel inputPanelLeft = new JPanel(new FlowLayout());
        JPanel inputPanelRight = new JPanel(new FlowLayout());



        JLabel num1Label = new JLabel("Number 1:");
        num1Field = new JTextField(5);
        JLabel num2Label = new JLabel("Number 2:");
        num2Field = new JTextField(5);
        inputPanelLeft.add(num1Label);
        inputPanelLeft.add(num1Field);
        inputPanelRight.add(num2Label);
        inputPanelRight.add(num2Field);
        inputPanel.add(inputPanelLeft,0);
        inputPanel.add(inputPanelRight,1);

        inputPanel.setMaximumSize(new Dimension(350,50));
        inputPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        addButton = new JButton("Add");
        addButton.addActionListener(this);
        multButton = new JButton("Mult");
        multButton.addActionListener(this);
        subButton = new JButton("Sub");
        subButton.addActionListener(this);
        divButton = new JButton("Div");
        divButton.addActionListener(this);

        buttonPanel.setMaximumSize(new Dimension(350,50));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);



        buttonPanel.add(addButton);
        buttonPanel.add(multButton);
        buttonPanel.add(subButton);
        buttonPanel.add(divButton);


        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel,BoxLayout.Y_AXIS));
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultField = new JTextField(12);

        resultField.setMaximumSize(new Dimension(350,50));
        resultField.setAlignmentX(Component.CENTER_ALIGNMENT);

        resultField.setEditable(false);

        resultPanel.add(resultLabel);
        add(Box.createVerticalStrut(10));
        resultPanel.add(resultField);


        add(inputPanel);
        add(Box.createVerticalStrut(10));
        add(buttonPanel);
        add(Box.createVerticalStrut(10));
        add(resultPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            float num1 = Float.parseFloat(num1Field.getText());
            float num2 = Float.parseFloat(num2Field.getText());
            float result = 0;

            if (e.getSource() == addButton) result = num1 + num2;
            if (e.getSource() == multButton) result = num1 * num2;
            if (e.getSource() == subButton) result = num1 - num2;
            if (e.getSource() == divButton)
            {
                if (num2 == 0){
                    throw new ArithmeticException("Cannot divide by zero");
                }else
                    result = num1 / num2;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input");
        } catch (ArithmeticException ex) {
            resultField.setText("Can't divide by zero");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculaterFrame::new);
    }
}
