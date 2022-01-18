/**
 * hold the menu borderBane and the elements
 */
package noteone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Ams
 */
public class Elements extends BorderPane {

    // Holder
    protected final MenuBar mainBar;
    // first menu and it's items
    protected final Menu fileMenu; // file menu items and setname
    protected final MenuItem newMenuItem;
    protected final MenuItem openMenuItem;
    protected final MenuItem saveMenuItem;
    protected final MenuItem exitMenuItem;
    // second menu and it's items
    protected final Menu editMenu;
    protected final MenuItem undoMenuItem;
    protected final MenuItem cutMenuItem;
    protected final MenuItem copyMenuItem;
    protected final MenuItem pasteMenuItem;
    protected final MenuItem deleteMenuItem;
    protected final MenuItem selectAllMenuItem;
    // third menu and it's items
    protected final Menu helpMenu;
    protected final MenuItem aboutMenuItem;
    // protected final MenuItem clipboard; //TODO: clipboard

    // text area
    protected final TextArea text;

    protected Stage stage = new Stage();

    String currentText = null; // to get the text from the notepad
    String currentPath = null; // to know where the file is saved, and if it is saved
    String noteName = null; // to change the app name to the file name

    // to store the clipboard items
    ObservableList<String> cliboardList = FXCollections.observableArrayList(); // TODO: clipboard store

    boolean isNew = false;

    /**
     * @param stage is the main stage
     */
    public Elements(Stage stage) {
        this.stage = stage;

        // initialization
        mainBar = new MenuBar();
        fileMenu = new Menu();
        newMenuItem = new MenuItem();
        openMenuItem = new MenuItem();
        saveMenuItem = new MenuItem();
        exitMenuItem = new MenuItem();

        editMenu = new Menu();
        undoMenuItem = new MenuItem();
        cutMenuItem = new MenuItem();
        copyMenuItem = new MenuItem();
        pasteMenuItem = new MenuItem();
        deleteMenuItem = new MenuItem();
        selectAllMenuItem = new MenuItem();

        helpMenu = new Menu();
        aboutMenuItem = new MenuItem();

        text = new TextArea();

        /** label and action the file menu */
        fileMenu.setText("file");
        fileMenu.setMnemonicParsing(false); // check documentation for more info

        /** new file */
        newMenuItem.setText("new");
        newMenuItem.setMnemonicParsing(false);
        newMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        newMenuItem.setOnAction((ActionEvent e) -> {
            saveAlert();
            rename();
            isNew = true;
        });

        /** open file */
        openMenuItem.setText("open");
        openMenuItem.setMnemonicParsing(false);
        openMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
        openMenuItem.setOnAction((ActionEvent e) -> {
            if (currentPath != null) {
                String name = save();
                if (!name.equals("exists :")) {
                    rename(name);
                }
            }
            open();
        });

        /** save current file */
        saveMenuItem.setText("save");
        saveMenuItem.setMnemonicParsing(false);
        saveMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        saveMenuItem.setOnAction((ActionEvent e) -> {
            String name = save();
            if (!name.equals("exists :")) {
                rename(name);
            }
        });

        /** exit the pad */
        exitMenuItem.setText("exit");
        exitMenuItem.setMnemonicParsing(false);
        exitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.W, KeyCombination.CONTROL_DOWN));
        exitMenuItem.setOnAction((ActionEvent e) -> {
            saveAlert();
            close();
        });

        /** edit menu */
        editMenu.setText("edit");
        editMenu.setMnemonicParsing(false);

        /** copy */
        copyMenuItem.setText("copy");
        copyMenuItem.setMnemonicParsing(false);
        copyMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));
        copyMenuItem.setOnAction((ActionEvent e) -> {
            cliboardList.add(text.getSelectedText());
            text.copy();
        });

        /** cut */
        cutMenuItem.setText("cut");
        cutMenuItem.setMnemonicParsing(false);
        cutMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
        cutMenuItem.setOnAction((ActionEvent e) -> {
            cliboardList.add(text.getSelectedText());
            text.cut();
        });

        /** paste */
        pasteMenuItem.setText("paste");
        pasteMenuItem.setMnemonicParsing(false);
        pasteMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN));
        pasteMenuItem.setOnAction((ActionEvent e) -> {
            text.paste();
        });

        /** delete */
        deleteMenuItem.setText("delete");
        deleteMenuItem.setMnemonicParsing(false);
        deleteMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.D, KeyCodeCombination.ALT_DOWN));
        // deleteMenuItem.setAccelerator(KeyCode.DELETE);
        deleteMenuItem.setOnAction((ActionEvent e) -> {
            cliboardList.add(text.getSelectedText());
            text.deleteText(text.getSelection());
        });

        /** undo */
        undoMenuItem.setText("undo");
        undoMenuItem.setMnemonicParsing(false);
        undoMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN));
        undoMenuItem.setOnAction((ActionEvent e) -> {
            //TODO: undo
            //text.undo(); 
        });

        /** select all */
        selectAllMenuItem.setText("Select All");
        selectAllMenuItem.setMnemonicParsing(false);
        selectAllMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        selectAllMenuItem.setOnAction((ActionEvent e) -> {
            text.selectAll();
        });

        /** help menu */
        helpMenu.setText("help");
        helpMenu.setMnemonicParsing(false);

        /** about */
        aboutMenuItem.setText("about");
        aboutMenuItem.setMnemonicParsing(false);
        aboutMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.H, KeyCombination.CONTROL_DOWN));
        aboutMenuItem.setOnAction((ActionEvent e) -> {
            Alert about = new Alert(
                    AlertType.INFORMATION, "Created by Ams\nas part of ITI_Java laps");
            about.show();
        });// TODO: add real info

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500);
        setPrefWidth(700);

        BorderPane.setAlignment(mainBar, Pos.CENTER);
        setTop(mainBar); // set the menu bar at the top

        // add the file items to the file menu
        fileMenu.getItems().add(newMenuItem);
        fileMenu.getItems().add(openMenuItem);
        fileMenu.getItems().add(saveMenuItem);
        fileMenu.getItems().add(exitMenuItem);
        mainBar.getMenus().add(fileMenu); // add the file menu to the menu bar

        // add the edit items to the edit menu
        editMenu.getItems().add(undoMenuItem);
        editMenu.getItems().add(cutMenuItem);
        editMenu.getItems().add(copyMenuItem);
        editMenu.getItems().add(pasteMenuItem);
        editMenu.getItems().add(deleteMenuItem);
        editMenu.getItems().add(selectAllMenuItem);
        mainBar.getMenus().add(editMenu); // add the edit menu to the menu bar

        // add the help item to the help menu
        helpMenu.getItems().add(aboutMenuItem);
        mainBar.getMenus().add(helpMenu);

        BorderPane.setAlignment(text, Pos.CENTER);
        text.setPrefHeight(stage.getHeight());
        text.setPrefWidth(stage.getWidth());
        setCenter(text); // set the text area at center
    }

    String name;

    protected String save() {

        if (currentPath == null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save File");
            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt"));
            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("Java files (*.java)", "*.java"));
            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("All files", "*.*"));
            File selectedFile = fileChooser.showSaveDialog(stage);
            if (selectedFile != null) {
                String path = selectedFile.getPath();
                currentPath = path;
                name = selectedFile.getName();
            }
        }
        try {
            if (currentPath != null) {
                FileOutputStream fileOutputStream = new FileOutputStream(currentPath);
                byte[] textArray = text.getText().getBytes();
                fileOutputStream.write(textArray);
                text.appendText(""); // to set the cursor at the end
                currentText = text.getText();
                fileOutputStream.close();
                name = "exists :";
            } else {
                System.err.println("You did not choose file to save\nPlease save the file to close");
                name = "untitled";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Elements.class.getName()).log(Level.SEVERE,
                    "fill not found -trying to save", ex);
            Alert alert = new Alert(AlertType.ERROR, "can't access the file to save");
            alert.show();
            if (currentPath == null) {
                name = "untitled";
            }
        } catch (IOException ex) {
            Logger.getLogger(Elements.class.getName()).log(Level.SEVERE,
                    "IO -trying to save", ex);
            Alert alert = new Alert(AlertType.ERROR, "can't access the file to save");
            alert.show();
            if (currentPath == null) {
                name = "untitled";
            }
        }
        return name;
    }

    int choice;

    protected int saveAlert() {

        ButtonType saveButton = new ButtonType("SAVE");
        ButtonType dontSave = new ButtonType("Do not Save");
        ButtonType cancelButton = new ButtonType("cancel");

        String textNow = text.getText();
        if (currentText == null && textNow.isEmpty() == true || currentText == textNow) {
            text.clear();
            choice = 1;
        } else {
            Alert alert = new Alert(AlertType.WARNING,
                    "Do you want to save changes??", saveButton, dontSave, cancelButton);

            alert.showAndWait().ifPresent(response -> {
                if (response == saveButton) {
                    save();
                    text.clear();
                    currentText = text.getText();
                    choice = 2;
                } else if (response == dontSave || response == cancelButton) {
                    text.clear();
                    currentText = text.getText();
                    choice = 3;
                }
            });
        }
        return choice;
    }

    public void rename() {
        currentText = text.getText();
        noteName = "untitled";
        stage.setTitle(noteName);
    }

    public void rename(File file) {
        currentText = text.getText();
        noteName = file.getName();
        stage.setTitle(noteName);
    }

    public void open() {
        // create file chooser object to open new file
        FileChooser fileChooser = new FileChooser();
        // set informative title
        fileChooser.setTitle("open file");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt"));
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("someFile", "*.*"));
        // open the file chooser dialogue
        File openedFile = fileChooser.showOpenDialog(stage);

        // check for the file and open it
        if (openedFile != null) { // was selected
            String path = openedFile.getPath(); // get the file location
            currentPath = path; // "Global" way to know which file is open
            try {
                FileInputStream fip = new FileInputStream(path);
                int size = fip.available();
                byte b[] = new byte[size];
                fip.read(b);
                text.setText(""); // clear the text area for append
                text.appendText(new String(b)); // choose append to set the cursor at the end
                rename(openedFile);
                fip.close();
            } catch (IOException ex) {
                Logger.getLogger(Elements.class.getName()).log(Level.SEVERE, "file open failed", ex);
            }
        }
    }

    public void rename(String name) {
        currentText = text.getText();
        noteName = name;
        stage.setTitle(noteName);
    }

    private void close() {
        stage.close();
        System.exit(0);
        Platform.exit();
    }

}