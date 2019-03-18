package com.wuyan.sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="rectangleBtn"
    private Button rectangleBtn; // Value injected by FXMLLoader

    @FXML // fx:id="headPane"
    private Pane headPane; // Value injected by FXMLLoader

    @FXML // fx:id="displayPane"
    private Pane displayPane; // Value injected by FXMLLoader

    @FXML // fx:id="circleBtn"
    private Button circleBtn; // Value injected by FXMLLoader

    @FXML // fx:id="triangleBtn"
    private Button triangleBtn; // Value injected by FXMLLoader

    private Circle circle;

    private Rectangle rectangle;

    private Triangle triangle;

    /**
     * This method is called by the FXMLLoader when initialization is complete
     * @param location
     * @param resources
     */
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        assert rectangleBtn != null : "fx:id=\"rectangle\" was not injected: check your FXML file 'sample.fxml'.";
        assert headPane != null : "fx:id=\"headPane\" was not injected: check your FXML file 'sample.fxml'.";
        assert displayPane != null : "fx:id=\"displayPane\" was not injected: check your FXML file 'sample.fxml'.";
        assert circleBtn != null : "fx:id=\"circle\" was not injected: check your FXML file 'sample.fxml'.";
        assert triangleBtn != null : "fx:id=\"triangle\" was not injected: check your FXML file 'sample.fxml'.";

        this.circle = new Circle(circleBtn);
        this.rectangle = new Rectangle(rectangleBtn);
        this.triangle = new Triangle(triangleBtn);

    }

    public void draw(ActionEvent event) {
        Object o = event.getSource();
        Button btn = (Button)o;
        Shape shape = (Shape) btn.getUserData();
        shape.erase(displayPane);
        shape.draw(displayPane, 0, 0);
        System.out.printf("%s button Clicked!\n", event.getSource().toString());
    }

}
