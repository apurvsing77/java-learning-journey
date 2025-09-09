package Interviews_prep.Notepade_Pro.ui;

import Interviews_prep.Notepade_Pro.listeners.AlignmentActionListener;
import Interviews_prep.Notepade_Pro.listeners.StyleActionListener;
import Interviews_prep.Notepade_Pro.ui.components.CustomTextPane;
import Interviews_prep.Notepade_Pro.utils.FileOperations;
import Interviews_prep.Notepade_Pro.utils.ImageOperations;

import javax.swing.*;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.*;

public class NotePadPro extends JFrame {
    private JTabbedPane tabbedPane;
    // Buttons will still be declared here as they are part of the UI
    private JButton openBtn, saveBtn, findBtn, replaceBtn, boldBtn, italicBtn, underlineBtn;
    private JButton alignLeftBtn, alignCenterBtn, alignRightBtn, insertImgBtn, pdfBtn, printBtn;
    private JButton fontBtn, colorBtn, wordWrapBtn, highlightBtn;

    // New buttons based on the image provided
    private JButton orderedListBtn, unorderedListBtn, indentBtn, outdentBtn, linkBtn;
    private JComboBox<String> paragraphFormatComboBox; // For "Paragraph" dropdown

    public NotePadPro() {
        setTitle("Advanced Notepad");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);

        setupToolbar(); // Encapsulate toolbar setup

        // Add first tab on startup
        addNewTab();
    }

    // Helper method to create buttons with icons
    // This method assumes icons are in resources/icons/ and named correctly
    private JButton createIconButton(String iconName, String tooltip) {
        System.out.println(getClass().getResource("/icons/" + iconName + ".png"));
        try {
            // Ensure the path is correct relative to the classpath
            ImageIcon icon = new ImageIcon(getClass().getResource("/icons/" + iconName + ".png"));
            System.out.println(getClass().getResource("/icons/" + iconName + ".png"));
            JButton button = new JButton(icon);
            button.setToolTipText(tooltip);
            button.setPreferredSize(new Dimension(22, 22)); // Adjust size as needed
            return button;
        } catch (NullPointerException e) {
            System.err.println("Icon not found: /resources/icons/" + iconName + ".png - Using text button instead.");
            return new JButton(tooltip); // Fallback to text if icon not found
        }
    }

    private void setupToolbar() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Use FlowLayout for better alignment

        // Initialize buttons
        findBtn = new JButton("Find");
        replaceBtn = new JButton("Replace");
        saveBtn = createIconButton("save", "Save File");
        boldBtn = createIconButton("bold", "Bold (Ctrl+B)");
        italicBtn = createIconButton("italic", "Italic (Ctrl+I)");
        underlineBtn = createIconButton("underline", "Underline (Ctrl+U)");

        // Paragraph dropdown
        String[] paragraphFormats = {"Paragraph", "Heading 1", "Heading 2", "Heading 3"}; // Example formats
        paragraphFormatComboBox = new JComboBox<>(paragraphFormats);
        paragraphFormatComboBox.setToolTipText("Paragraph Format");

        alignLeftBtn = createIconButton("align_left", "Align Left");
        alignCenterBtn = createIconButton("align_center", "Align Center");
        alignRightBtn = createIconButton("align_right", "Align Right");
        orderedListBtn = createIconButton("list_ordered", "Ordered List");
        unorderedListBtn = createIconButton("list_unordered", "Unordered List");
        indentBtn = createIconButton("indent", "Indent");
        outdentBtn = createIconButton("outdent", "Outdent");
        linkBtn = createIconButton("link", "Insert Link");
        insertImgBtn = createIconButton("image", "Insert Image");

        // Text-only buttons
        openBtn = new JButton("Open");
        saveBtn = new JButton("Save");
        pdfBtn = new JButton("Save PDF");
        printBtn = new JButton("Print");
        fontBtn = new JButton("Font");
        colorBtn = new JButton("Color");
        wordWrapBtn = new JButton("Word Wrap");
        highlightBtn = new JButton("Highlight");

        // Add buttons to panel
        buttonPanel.add(boldBtn);
        buttonPanel.add(italicBtn);
        buttonPanel.add(underlineBtn);
        buttonPanel.add(paragraphFormatComboBox);
        buttonPanel.add(alignLeftBtn);
        buttonPanel.add(alignCenterBtn);
        buttonPanel.add(alignRightBtn);
        buttonPanel.add(orderedListBtn);
        buttonPanel.add(unorderedListBtn);
        buttonPanel.add(indentBtn);
        buttonPanel.add(outdentBtn);
        buttonPanel.add(linkBtn);
        buttonPanel.add(insertImgBtn);
        buttonPanel.add(openBtn);
        buttonPanel.add(saveBtn);
        buttonPanel.add(findBtn);
        buttonPanel.add(replaceBtn);
        buttonPanel.add(pdfBtn);
        buttonPanel.add(printBtn);
        buttonPanel.add(fontBtn);
        buttonPanel.add(colorBtn);
        buttonPanel.add(wordWrapBtn);
        buttonPanel.add(highlightBtn);

        add(buttonPanel, BorderLayout.NORTH);

        // Attach action listeners
        FileOperations fileOperations = new FileOperations(this::getCurrentTextPane, tabbedPane, this);
        openBtn.addActionListener(e -> fileOperations.openFile());
        saveBtn.addActionListener(e -> fileOperations.saveFile());

        StyleActionListener styleActionListener = new StyleActionListener(this::getCurrentTextPane);
        boldBtn.addActionListener(e -> styleActionListener.toggleStyle(StyleConstants.Bold));
        italicBtn.addActionListener(e -> styleActionListener.toggleStyle(StyleConstants.Italic));
        underlineBtn.addActionListener(e -> styleActionListener.toggleStyle(StyleConstants.Underline));
        indentBtn.addActionListener(e -> styleActionListener.indent());
        outdentBtn.addActionListener(e -> styleActionListener.outdent());
        // Link operations
        linkBtn.addActionListener(e -> styleActionListener.insertLink());

        AlignmentActionListener alignmentActionListener = new AlignmentActionListener(this::getCurrentTextPane);
        alignLeftBtn.addActionListener(e -> alignmentActionListener.setAlignment(StyleConstants.ALIGN_LEFT));
        alignCenterBtn.addActionListener(e -> alignmentActionListener.setAlignment(StyleConstants.ALIGN_CENTER));
        alignRightBtn.addActionListener(e -> alignmentActionListener.setAlignment(StyleConstants.ALIGN_RIGHT));

        ImageOperations imageOperations = new ImageOperations(this::getCurrentTextPane, this);
        insertImgBtn.addActionListener(e -> imageOperations.insertImage());


        paragraphFormatComboBox.addActionListener(e -> {
            String selectedFormat = (String) paragraphFormatComboBox.getSelectedItem();
            styleActionListener.applyParagraphFormat(selectedFormat);
        });

        // Using the correct action names from StyledEditorKit
        orderedListBtn.addActionListener(new StyledEditorKit.AlignmentAction("Ordered List", StyleConstants.ALIGN_LEFT));
        unorderedListBtn.addActionListener(new StyledEditorKit.AlignmentAction("Unordered List", StyleConstants.ALIGN_LEFT));

    }

    public void addNewTab() {
        CustomTextPane textPane = new CustomTextPane(); // Use your custom text pane
        JScrollPane scrollPane = new JScrollPane(textPane);
        tabbedPane.addTab("Untitled", scrollPane);
    }

    public JTextPane getCurrentTextPane() {
        // Handle case where no tab is selected, or a tab is empty
        if (tabbedPane.getSelectedComponent() == null) {
            addNewTab(); // Add a new tab if none exist
        }
        JScrollPane scrollPane = (JScrollPane) tabbedPane.getSelectedComponent();
        return (JTextPane) scrollPane.getViewport().getView();
    }
}