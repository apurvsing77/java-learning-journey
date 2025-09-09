package Interviews_prep.Notepade_Pro.listeners;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.function.Supplier;

public class FileActionListener { // Class name matches the file name
    private final Supplier<JTextPane> textPaneSupplier;
    private final JTabbedPane tabbedPane;
    private final JFrame parentFrame;

    public FileActionListener(Supplier<JTextPane> textPaneSupplier, JTabbedPane tabbedPane, JFrame parentFrame) {
        this.textPaneSupplier = textPaneSupplier;
        this.tabbedPane = tabbedPane;
        this.parentFrame = parentFrame;
    }

    public void openFile() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(parentFrame) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                JTextPane textPane = textPaneSupplier.get();
                textPane.setText(new String(Files.readAllBytes(file.toPath())));
                tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), file.getName());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(parentFrame, "Error opening file: " + ex.getMessage());
            }
        }
    }

    public void saveFile() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(parentFrame) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try (FileWriter writer = new FileWriter(file)) {
                JTextPane textPane = textPaneSupplier.get();
                writer.write(textPane.getText());
                tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), file.getName());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(parentFrame, "Error saving file: " + ex.getMessage());
            }
        }
    }
}