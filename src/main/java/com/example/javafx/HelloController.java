package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class HelloController {

    @FXML
    private Button chooseFile;

    @FXML
    private Button copeFile;

    @FXML
    private Button selectFolder;

    @FXML
    private Label welcomeText;

    private File needFile;
    private File needDirectory;

    @FXML
    void chooseFileAction(ActionEvent event) {
        JFileChooser chooser = new JFileChooser();
        int replay = chooser.showOpenDialog(null);
        needFile = chooser.getSelectedFile();
        System.out.println(needFile);
    }

    @FXML
    void copeFileAction(ActionEvent event) throws IOException {
        Path pathFile = needFile.toPath();
        Path pathDirectory = needDirectory.toPath().resolve(pathFile.getFileName());
        Files.copy(pathFile, pathDirectory);
        if (Files.exists(pathDirectory)) {
            System.exit(0);
        }
    }

    @FXML
    void selectFolderAction(ActionEvent event) {
        JFileChooser chooser = new JFileChooser();
        int replay = chooser.showOpenDialog(null);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        needDirectory = chooser.getCurrentDirectory();
        System.out.println(needDirectory);
    }

}
