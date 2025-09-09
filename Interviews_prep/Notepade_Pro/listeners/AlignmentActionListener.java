package Interviews_prep.Notepade_Pro.listeners;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.util.function.Supplier;

public class AlignmentActionListener {
    private final Supplier<JTextPane> textPaneSupplier;

    public AlignmentActionListener(Supplier<JTextPane> textPaneSupplier) {
        this.textPaneSupplier = textPaneSupplier;
    }

    public void setAlignment(int alignment) {
        JTextPane textPane = textPaneSupplier.get();
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setAlignment(attr, alignment);
        // Apply to the current paragraph(s) containing the selection
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();
        doc.setParagraphAttributes(start, end - start, attr, false);
    }
}