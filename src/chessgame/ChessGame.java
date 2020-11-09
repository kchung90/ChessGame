package chessgame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * This class runs the Chess Game.
 * 
 * @author Ki Sung Chung
 * @version 1.0
 */
public class ChessGame extends Application {
    /** Chess Board. */
    private Board board;
    /** Represents the width of the scene. */
    private final int sceneWidth = 560;
    /** Represents the height of the scene. */
    private final int sceneHeight = 620;
    /** GridPane to hold the board and buttons. */
    private GridPane grid;
    
    /**
     * Starts the program.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        board = new Board();
        grid = new GridPane();
        grid.add(board, 0, 0);
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("./"));
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("ChessSaveFile", "*.ser"));

        // Create buttons for opening and saving the chess games
        Button open = new Button("Open");
        Button save = new Button("Save");
        grid.add(open, 0, 1);
        grid.add(save, 0, 2);
        
        // Opens the saved chess game
        open.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                try {
                    File openFile = fc.showOpenDialog(primaryStage);
                    FileInputStream fis = new FileInputStream(openFile);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Board newBoard = (Board) ois.readObject();
                    newBoard.openSavedGame();
                    grid.getChildren().remove(board);
                    grid.add(newBoard, 0, 0);
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        // Saves the chess game
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                try {
                    File saveFile = fc.showSaveDialog(primaryStage);
                    FileOutputStream ops = new FileOutputStream(saveFile);
                    ObjectOutput out = new ObjectOutputStream(ops);
                    out.writeObject(board);
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        primaryStage.setTitle("Chess Game");
        primaryStage.setScene(new Scene(grid, sceneWidth, sceneHeight));
        primaryStage.show();
    }

    /**
     * Drives the program.
     * 
     * @param args command line argument
     */
    public static void main(String[] args) {
        launch(args);
    }
}
