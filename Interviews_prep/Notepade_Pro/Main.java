package Interviews_prep.Notepade_Pro;

import Interviews_prep.Notepade_Pro.ui.NotePadPro;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new NotePadPro().setVisible(true);
        });
    }
}