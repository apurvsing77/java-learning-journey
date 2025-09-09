package Interviews_prep.Notepade_Pro.listeners;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.function.Supplier;
import java.net.MalformedURLException;
import java.net.URL;


public class StyleActionListener {
    private final Supplier<JTextPane> textPaneSupplier;
    private Component parentFrame;

    public StyleActionListener(Supplier<JTextPane> textPaneSupplier) {
        this.textPaneSupplier = textPaneSupplier;
    }

    public void toggleStyle(Object styleConstant) {
        JTextPane textPane = textPaneSupplier.get();
        StyledDocument doc = textPane.getStyledDocument();
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();

        if (start == end) {
            // Apply style to the caret position for future typing, or just return if no selection
            SimpleAttributeSet inputAttributes = new SimpleAttributeSet(textPane.getInputAttributes());
            if (styleConstant == StyleConstants.Bold) {
                StyleConstants.setBold(inputAttributes, !StyleConstants.isBold(inputAttributes));
            } else if (styleConstant == StyleConstants.Italic) {
                StyleConstants.setItalic(inputAttributes, !StyleConstants.isItalic(inputAttributes));
            } else if (styleConstant == StyleConstants.Underline) {
                StyleConstants.setUnderline(inputAttributes, !StyleConstants.isUnderline(inputAttributes));
            }
            textPane.setCharacterAttributes(inputAttributes, true);
            return;
        }

        SimpleAttributeSet currentAttributes = new SimpleAttributeSet();
        // Check if the current selection already has the style
        // This is a more robust way to toggle than just setting true/false
        boolean styleExists = false;
        if (styleConstant == StyleConstants.Bold) {
            styleExists = StyleConstants.isBold(textPane.getCharacterAttributes());
        } else if (styleConstant == StyleConstants.Italic) {
            styleExists = StyleConstants.isItalic(textPane.getCharacterAttributes());
        } else if (styleConstant == StyleConstants.Underline) {
            styleExists = StyleConstants.isUnderline(textPane.getCharacterAttributes());
        }

        SimpleAttributeSet attr = new SimpleAttributeSet();
        if (styleConstant == StyleConstants.Bold) {
            StyleConstants.setBold(attr, !styleExists);
        } else if (styleConstant == StyleConstants.Italic) {
            StyleConstants.setItalic(attr, !styleExists);
        } else if (styleConstant == StyleConstants.Underline) {
            StyleConstants.setUnderline(attr, !styleExists);
        }
        doc.setCharacterAttributes(start, end - start, attr, false);
    }

    public void indent() {
        JTextPane textPane = textPaneSupplier.get();
        StyledDocument doc = textPane.getStyledDocument();
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();

        SimpleAttributeSet attrs = new SimpleAttributeSet();
        // Get current attributes for the start of the selection to find current indent
        AttributeSet paragraphAttributes = doc.getParagraphElement(start).getAttributes();
        float currentLeftIndent = StyleConstants.getLeftIndent(paragraphAttributes);

        StyleConstants.setLeftIndent(attrs, currentLeftIndent + 20); // Increase indent by 20 points
        doc.setParagraphAttributes(start, end - start, attrs, false);
    }

    public void outdent() {
        JTextPane textPane = textPaneSupplier.get();
        StyledDocument doc = textPane.getStyledDocument();
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();

        SimpleAttributeSet attrs = new SimpleAttributeSet();
        // Get current attributes for the start of the selection to find current indent
        AttributeSet paragraphAttributes = doc.getParagraphElement(start).getAttributes();
        float currentLeftIndent = StyleConstants.getLeftIndent(paragraphAttributes);

        StyleConstants.setLeftIndent(attrs, Math.max(0, currentLeftIndent - 20)); // Decrease, min 0
        doc.setParagraphAttributes(start, end - start, attrs, false);
    }

    public void applyParagraphFormat(String format) {
        JTextPane textPane = textPaneSupplier.get();
        StyledDocument doc = textPane.getStyledDocument();
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();
        if (start == end && doc.getLength() == 0) {
            // If document is empty and no selection, apply to input attributes
            SimpleAttributeSet inputAttrs = new SimpleAttributeSet(textPane.getInputAttributes());
            applyFormatToAttributeSet(inputAttrs, format);
            textPane.setCharacterAttributes(inputAttrs, true);
            return;
        }

        SimpleAttributeSet attrs = new SimpleAttributeSet();
        applyFormatToAttributeSet(attrs, format);

        // Apply to paragraphs covering the selection
        doc.setParagraphAttributes(start, end - start, attrs, false);
    }

    // Helper method to apply font settings based on format
    private void applyFormatToAttributeSet(SimpleAttributeSet attrs, String format) {
        // Resetting previous styles might be necessary for certain attributes
        StyleConstants.setFontFamily(attrs, "SansSerif"); // Default font
        StyleConstants.setBold(attrs, false);
        StyleConstants.setItalic(attrs, false);
        StyleConstants.setUnderline(attrs, false);
        StyleConstants.setForeground(attrs, Color.BLACK); // Default color

        switch (format) {
            case "Paragraph":
                StyleConstants.setFontSize(attrs, 12);
                break;
            case "Heading 1":
                StyleConstants.setFontSize(attrs, 24);
                StyleConstants.setBold(attrs, true);
                break;
            case "Heading 2":
                StyleConstants.setFontSize(attrs, 18);
                StyleConstants.setBold(attrs, true);
                break;
            case "Heading 3":
                StyleConstants.setFontSize(attrs, 14);
                StyleConstants.setBold(attrs, true);
                break;
            // Add more cases as needed for other heading levels
        }
        }

    public void insertLink() {
        JTextPane textPane = textPaneSupplier.get();
        StyledDocument doc = textPane.getStyledDocument();
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();

        String urlText = JOptionPane.showInputDialog(parentFrame, "Enter URL:", "Insert Link", JOptionPane.PLAIN_MESSAGE);
        if (urlText != null && !urlText.trim().isEmpty()) {
            SimpleAttributeSet linkAttrs = new SimpleAttributeSet();
            StyleConstants.setForeground(linkAttrs, Color.BLUE);
            StyleConstants.setUnderline(linkAttrs, true);
            linkAttrs.addAttribute( "link", urlText); // Custom attribute to store the URL

            if (start == end) {
                // No selection, insert the URL as text and apply link style
                try {
                    doc.insertString(start, urlText, linkAttrs);
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
            } else {
                // Apply link style to selected text
                doc.setCharacterAttributes(start, end - start, linkAttrs, false);
            }

            // To make the link clickable, you'd typically need to add a MouseListener to the JTextPane
            // and check if the clicked text has the "link" attribute.
            // This part is more advanced and not directly part of StyleActionListener.
        }
    }    
}