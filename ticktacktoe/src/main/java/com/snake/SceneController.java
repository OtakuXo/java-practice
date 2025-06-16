package com.snake;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
   private Stage stage;
   private Scene scene;
   private Parent root;

   public void goToMainScene(ActionEvent event) throws Exception {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/Main.fxml"));
      root = loader.load();
      stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      String css = this.getClass().getResource("/styles.css").toExternalForm();
      scene.getStylesheets().add(css);
      stage.show();
   }

   public void goToMenuScene(ActionEvent event) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("/Menu.fxml"));
      stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      Scene scene = new Scene(root);
      stage.setScene(scene);
      String css = this.getClass().getResource("/styles.css").toExternalForm();
      scene.getStylesheets().add(css);
      stage.show();
   }

}
