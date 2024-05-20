import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;

public class ModelViewer {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("View the Model");
            frame.setLayout(new BorderLayout()); // Use BorderLayout

            final JFXPanel fxPanel = new JFXPanel();
            frame.add(fxPanel, BorderLayout.CENTER); // Add JFXPanel at the center

            // Create a panel for buttons
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Set the layout

            // Create buttons
            JButton saveButton = new JButton("Save");
            saveButton.setBackground(new Color(229, 215, 27));
            saveButton.setForeground(new Color(150, 93, 30));
            saveButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
            JButton editButton = new JButton("Edit");
            editButton.setBackground(new Color(229, 215, 27));
            editButton.setForeground(new Color(150, 93, 30));
            editButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
            JButton deleteButton = new JButton("Delete");
            deleteButton.setBackground(new Color(229, 215, 27));
            deleteButton.setForeground(new Color(150, 93, 30));
            deleteButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
            JButton returnButton = new JButton("Return");
            returnButton.setBackground(new Color(229, 215, 27));
            returnButton.setForeground(new Color(150, 93, 30));
            returnButton.setFont(new Font("Arial Black", Font.PLAIN, 14));

            // Add action listeners for the buttons
            saveButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(frame,
                        "Successfully saved to your directory",
                        "Save Successful",
                        JOptionPane.INFORMATION_MESSAGE);
            });

            editButton.addActionListener(e -> frame.dispose());

            deleteButton.addActionListener(e -> {
                int result = JOptionPane.showConfirmDialog(frame,
                        "Are you sure?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    frame.dispose();
                }
            });

            returnButton.addActionListener(e -> frame.dispose());

            // Add buttons to the panel
            buttonPanel.add(saveButton);
            buttonPanel.add(editButton);
            buttonPanel.add(deleteButton);
            buttonPanel.add(returnButton);

            // Add the panel of buttons to the bottom of the frame
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setSize(900, 700);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            Platform.runLater(() -> {
                initFX(fxPanel);
            });
        });
    }

    private static void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        WebView webView = new WebView();
        webView.getEngine().load("https://sketchfab.com/3d-models/high-poly-bed-716bfa90dca549e8a076f0b4f367accc/embed");

        Scene scene = new Scene(webView);
        fxPanel.setScene(scene);
    }

}