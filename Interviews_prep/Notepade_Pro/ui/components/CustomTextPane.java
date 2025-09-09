package Interviews_prep.Notepade_Pro.ui.components;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;

public class CustomTextPane extends JTextPane {
    public CustomTextPane() {
        // You can set default properties here, e.g., font, initial text
        setEditorKit(new StyledEditorKit()); // Ensure it supports styled text
    }

    // Add any specific methods or properties related to your text pane here
}