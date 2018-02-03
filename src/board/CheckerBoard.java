/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package board;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Taylor
 */
public class CheckerBoard {
    private double width;
    private double height;
    private int numRows;
    private int numCols;
    private double tileWidth;
    private double tileHeight;
    private AnchorPane anchorPane;
    private Color lightColor;
    private Color darkColor;
    
    public CheckerBoard (int numRows, int numCols, double boardWidth,
double boardHeight) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.width = boardWidth;
        this.height = boardHeight;
        this.lightColor = Color.RED;
        this.darkColor = Color.BLACK;
        
        anchorPane = new AnchorPane();
    }
    
    public CheckerBoard (int numRows, int numCols, double boardWidth,
double boardHeight, Color lightColor, Color darkColor) {
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public AnchorPane build (double width, double height) {
        clear();
        this.width = width;
        this.height = height;
        tileWidth = Math.ceil(width / (double)numCols);
        tileHeight = Math.ceil(height / (double)numRows);
        anchorPane.setPrefWidth(width);
        anchorPane.setPrefHeight(height);
        
        for (int x = 0; x < numRows; x++) {
            for (int y = 0; y < numCols; y++) {
                int z = (x+y) % 2;
                Color c = lightColor;
                if (z == 0)
                    c = darkColor;
                
                Rectangle rect = new Rectangle(tileWidth, tileHeight, c);
                anchorPane.setTopAnchor(rect, tileHeight * x);
                anchorPane.setLeftAnchor(rect, tileWidth * y);
                anchorPane.getChildren().add(rect);
            }
        }
        
        return anchorPane;
                
    }

    public AnchorPane build (double width, double height, Color lightColor, Color darkColor) {
        clear();
        this.lightColor = lightColor;
        this.darkColor = darkColor;
        build(width, height);
        
        return anchorPane;
    }
    
    public AnchorPane build(double width, double height, int numRows, int numCols) {
        clear();
        this.numRows = numRows;
        this.numCols = numCols;
        build(width, height);
        
        return anchorPane;
    }
    
    public void clear() {
        anchorPane.getChildren().clear();
    }
    
    public AnchorPane getBoard() {
        return anchorPane;
    }
    
    public int getRows() {
        return numRows;
    }
    
    public int getColumns() {
        return numCols;
    }
    
    public double getWidth() {
        return anchorPane.getWidth();
    }
    
    public double getHeight() {
        return anchorPane.getHeight();
    }
    
    public double getTileWidth() {
        return tileWidth;
    }
    
    public double getTileHeight() {
        return tileHeight;
    }
}