package Interwiews_prep.ui;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.*;

public class NotePadPro extends JFrame {
    JTabbedPane tabbedPane;
    JButton openBtn, saveBtn, findBtn, replaceBtn, boldBtn, italicBtn, underlineBtn;
    JButton alignLeftBtn, alignCenterBtn, alignRightBtn, insertImgBtn, pdfBtn, printBtn;
    JButton fontBtn, colorBtn, wordWrapBtn, highlightBtn;

    public NotePadPro() {
        setTitle("Advanced Notepad");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        openBtn = new JButton("Open");
        saveBtn = new JButton("Save");
        findBtn = new JButton("Find");
        replaceBtn = new JButton("Replace");
        boldBtn = new JButton("Bold");
        italicBtn = new JButton("Italic");
        underlineBtn = new JButton("Underline");
        alignLeftBtn = new JButton("Left");
        alignCenterBtn = new JButton("Center");
        alignRightBtn = new JButton("Right");
        insertImgBtn = new JButton("Image");
        pdfBtn = new JButton("Save PDF");
        printBtn = new JButton("Print");
        fontBtn = new JButton("Font");
        colorBtn = new JButton("Color");
        wordWrapBtn = new JButton("Word Wrap");
        highlightBtn = new JButton("Highlight");

        // Add buttons to panel
        buttonPanel.add(openBtn); buttonPanel.add(saveBtn);
        buttonPanel.add(findBtn); buttonPanel.add(replaceBtn);
        buttonPanel.add(boldBtn); buttonPanel.add(italicBtn); buttonPanel.add(underlineBtn);
        buttonPanel.add(alignLeftBtn); buttonPanel.add(alignCenterBtn); buttonPanel.add(alignRightBtn);
        buttonPanel.add(insertImgBtn); buttonPanel.add(pdfBtn); buttonPanel.add(printBtn);
        buttonPanel.add(fontBtn); buttonPanel.add(colorBtn); buttonPanel.add(wordWrapBtn);
        buttonPanel.add(highlightBtn);

        add(buttonPanel, BorderLayout.NORTH);

        // Add first tab
        addNewTab();

        // Button actions
        openBtn.addActionListener(e -> openFile());
        saveBtn.addActionListener(e -> saveFile());
        boldBtn.addActionListener(e -> toggleStyle(StyleConstants.Bold));
        italicBtn.addActionListener(e -> toggleStyle(StyleConstants.Italic));
        underlineBtn.addActionListener(e -> toggleStyle(StyleConstants.Underline));
        alignLeftBtn.addActionListener(e -> setAlignment(StyleConstants.ALIGN_LEFT));
        alignCenterBtn.addActionListener(e -> setAlignment(StyleConstants.ALIGN_CENTER));
        alignRightBtn.addActionListener(e -> setAlignment(StyleConstants.ALIGN_RIGHT));
        insertImgBtn.addActionListener(e -> insertImage());
        // Add more button actions here...
    }

    private void addNewTab() {
        JTextPane textPane = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(textPane);
        tabbedPane.addTab("Untitled", scrollPane);
    }

    private JTextPane getCurrentTextPane() {
        JScrollPane scrollPane = (JScrollPane) tabbedPane.getSelectedComponent();
        return (JTextPane) scrollPane.getViewport().getView();
    }

    private void openFile() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                JTextPane textPane = getCurrentTextPane();
                textPane.setText(new String(java.nio.file.Files.readAllBytes(file.toPath())));
                tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), file.getName());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error opening file!");
            }
        }
    }

    private void saveFile() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try (FileWriter writer = new FileWriter(file)) {
                JTextPane textPane = getCurrentTextPane();
                writer.write(textPane.getText());
                tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), file.getName());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file!");
            }
        }
    }

    private void toggleStyle(Object style) {
        JTextPane textPane = getCurrentTextPane();
        StyledDocument doc = textPane.getStyledDocument();
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();
        if (start == end) return;
        SimpleAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setBold(attr, style == StyleConstants.Bold);
        StyleConstants.setItalic(attr, style == StyleConstants.Italic);
        StyleConstants.setUnderline(attr, style == StyleConstants.Underline);
        doc.setCharacterAttributes(start, end - start, attr, false);
    }

    private void setAlignment(int alignment) {
        JTextPane textPane = getCurrentTextPane();
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setAlignment(attr, alignment);
        doc.setParagraphAttributes(0, doc.getLength(), attr, false);
    }

    private void insertImage() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                JTextPane textPane = getCurrentTextPane();
                StyledDocument doc = textPane.getStyledDocument();
                ImageIcon icon = new ImageIcon(chooser.getSelectedFile().getAbsolutePath());
                textPane.setCaretPosition(doc.getLength());
                textPane.insertIcon(icon);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error inserting image!");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new NotePadPro().setVisible(true);
        });
    }
}
