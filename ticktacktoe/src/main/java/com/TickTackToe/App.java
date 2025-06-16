package com.TickTackToe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class App extends Application {
   public static void main(String[] args) {
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("/Menu.fxml"));
      Scene scene = new Scene(root);
      String css = this.getClass().getResource("/styles.css").toExternalForm();
      scene.getStylesheets().add(css);
      primaryStage.setScene(scene);
      primaryStage.show();
   }

}
