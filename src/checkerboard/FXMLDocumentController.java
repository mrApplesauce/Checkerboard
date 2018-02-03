/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Taylor
 */
public class FXMLDocumentController implements Initializable, Startable {
    
    private Stage stage;
    
    private final int numRows = 8;
    private final int numCols = 8;
    
    private board.CheckerBoard checkerboard;
    
    @FXML
    private VBox vBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    } 
    
    @Override
    public void start (Stage stage) {
        this.stage = stage;
        
        checkerboard = new board.CheckerBoard(8, 8, stage.getWidth(), stage.getHeight());
        vBox.getChildren().add(checkerboard.getBoard());
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refresh();
        };
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        
        refresh();
    }
    
    private void clear() {
        checkerboard.clear();
    }
    
    private void refresh() {
        checkerboard.build(this.stage.getWidth(), this.stage.getHeight());
    }
    
    @FXML
    private void defaultColorScheme(ActionEvent event) {
        checkerboard.build(this.stage.getWidth(), this.stage.getHeight(), Color.RED, Color.BLACK);
    }
    
    @FXML
    private void blueColorScheme(ActionEvent event) {
        checkerboard.build(checkerboard.getWidth(), checkerboard.getHeight(), Color.LIGHTBLUE, Color.DARKBLUE);
    }

    @FXML
    private void changeGrid16(ActionEvent event) {
        checkerboard.build(checkerboard.getWidth(), checkerboard.getHeight(), 16, 16);
    }
    
    @FXML
    private void changeGrid10(ActionEvent event) {
        checkerboard.build(checkerboard.getWidth(), checkerboard.getHeight(), 10, 10);
    }
    
    @FXML
    private void changeGrid8(ActionEvent event) {
        checkerboard.build(checkerboard.getWidth(), checkerboard.getHeight(), 8, 8);
    }
    
    @FXML
    private void changeGrid3(ActionEvent event) {
        checkerboard.build(checkerboard.getWidth(), checkerboard.getHeight(), 3, 3);
    }
    
}
