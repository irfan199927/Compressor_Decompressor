package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Comp_decomp.Compressor;
import Comp_decomp.Decompressor;

public class AppFrame extends JFrame implements ActionListener {

    private JButton compressButton;
    private JButton decompressButton;

    public AppFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("File Compression App");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.LIGHT_GRAY);

        // Add the image label
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Ekaram\\Desktop\\Compressor  Decompressor\\image2.jpg"); // Replace "image.png" with your actual image file
        Image image = imageIcon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setPreferredSize(new Dimension(400, 400));

        compressButton = createButton("Select File to Compress");
        decompressButton = createButton("Select File to Decompress");

        JLabel titleLabel = new JLabel("File Compression App");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 20, 10);
        mainPanel.add(titleLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 5);
        mainPanel.add(imageLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 5, 10, 10);
        mainPanel.add(compressButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(decompressButton, gbc);

        getContentPane().setBackground(new Color(230, 230, 250));
        add(mainPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 40));
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(59, 89, 182));
        button.setFocusPainted(false);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(this);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    Compressor.compressFile(file);
                    JOptionPane.showMessageDialog(this, "File compressed successfully!");
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(this, exception.toString());
                }
            }
        } else if (e.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(this);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    Decompressor.decompressFile(file);
                    JOptionPane.showMessageDialog(this, "File decompressed successfully!");
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(this, exception.toString());
                }
            }
        }
    }

    public static void main(String[] args) {
        new AppFrame();
    }
}
