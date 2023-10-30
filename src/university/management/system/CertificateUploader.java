package university.management.system;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class CertificateUploader extends JFrame {

    private JButton btnUpload;

    public CertificateUploader() {
        initComponents();
    }

    private void initComponents() {
        btnUpload = new JButton("Upload Certificate");
        btnUpload.addActionListener(e -> handleUpload());

        this.setLayout(new java.awt.FlowLayout());
        this.add(btnUpload);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private void handleUpload() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Certificate Files", "cer", "crt"));
        int returnValue = fileChooser.showOpenDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            // Do something with the selected file, e.g., save to a specific directory.
            saveFile(selectedFile);
        }
    }

    private void saveFile(File sourceFile) {
        String destinationPath = "path_to_save_directory"; // Replace with your desired path
        File destFile = new File(destinationPath, sourceFile.getName());

        try (FileChannel sourceChannel = new FileInputStream(sourceFile).getChannel();
             FileChannel destChannel = new FileOutputStream(destFile).getChannel()) {

            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
            JOptionPane.showMessageDialog(this, "File Uploaded Successfully!");

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error uploading the file!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CertificateUploader());
    }
}