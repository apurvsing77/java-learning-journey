package Interviews_prep.Notepade_Pro.utils;

import javax.swing.*;         // This imports all classes from javax.swing, but sometimes explicit is better for clarity or if there's a conflict
import javax.swing.text.StyledDocument;
import java.awt.*;            // <--- ADD THIS IMPORT for java.awt.Image
import javax.swing.ImageIcon; // <--- ADD THIS EXPLICIT IMPORT for ImageIcon

import java.util.function.Supplier;

public class ImageOperations {
    private final Supplier<JTextPane> textPaneSupplier;
    private final JFrame parentFrame;

    public ImageOperations(Supplier<JTextPane> textPaneSupplier, JFrame parentFrame) {
        this.textPaneSupplier = textPaneSupplier;
        this.parentFrame = parentFrame;
    }

/*
    public void insertImage() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(parentFrame) == JFileChooser.APPROVE_OPTION) {
            try {
                JTextPane textPane = textPaneSupplier.get();
                StyledDocument doc = textPane.getStyledDocument();
                ImageIcon icon = new ImageIcon(chooser.getSelectedFile().getAbsolutePath());

                // Scale the image if it's too big, or use a fixed size
                Image img = icon.getImage(); // 'Image' also needs to be imported from java.awt
                // Example: Scale if width > 200
                if (img.getWidth(null) > 200) {
                    Image newImg = img.getScaledInstance(200, -1, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(newImg);
                }

                textPane.setCaretPosition(doc.getLength()); // Insert at the end
                textPane.insertIcon(icon);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(parentFrame, "Error inserting image: " + ex.getMessage());
            }
        }
    }
*/
public void insertImage() {
    JFileChooser chooser = new JFileChooser();
    if (chooser.showOpenDialog(parentFrame) == JFileChooser.APPROVE_OPTION) {
        try {
            JTextPane textPane = textPaneSupplier.get();
            StyledDocument doc = textPane.getStyledDocument();
            ImageIcon icon = new ImageIcon(chooser.getSelectedFile().getAbsolutePath());

            // Scale the image if it's too big, or use a fixed size
            Image img = icon.getImage(); // 'Image' also needs to be imported from java.awt
            // Example: Scale if width > 200
            if (img.getWidth(null) > 200) {
                Image newImg = img.getScaledInstance(20, -1, Image.SCALE_SMOOTH);
                icon = new ImageIcon(newImg);
            }

            textPane.setCaretPosition(doc.getLength()); // Insert at the end
            textPane.insertIcon(icon);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(parentFrame, "Error inserting image: " + ex.getMessage());
        }
    }
}

}