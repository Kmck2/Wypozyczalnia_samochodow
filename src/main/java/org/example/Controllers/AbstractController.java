package org.example.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public abstract class AbstractController
{
   public void show(ActionEvent event, String path) {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent parent;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
       try {
           parent = loader.load();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
       init();
        Scene scene = new Scene(parent);
        stage.setScene(scene);

    }

    public void init()
    {

    }

    }

