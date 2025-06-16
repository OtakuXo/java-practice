package com.snake;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
   private char[] state = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
   private String turn = "x";

   private int[][] winConditions = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
         { 0, 4, 8 }, { 2, 4, 6 } };

   @FXML
   private AnchorPane winningMessage = new AnchorPane();

   public void checkWinner() {
      for (int i = 0; i < winConditions.length; i++) {
         char a = state[winConditions[i][0]];
         char b = state[winConditions[i][1]];
         char c = state[winConditions[i][2]];

         if (a == ' ' || b == ' ' || c == ' ') {
            continue;
         }

         if (a == b && b == c) {
            winningMessage.setVisible(true);
         }
      }
   }

   // 0
   @FXML
   private AnchorPane anchorPane0X = new AnchorPane();
   @FXML
   private AnchorPane anchorPane0O = new AnchorPane();
   @FXML
   private Button btn0 = new Button();

   public void Button0(ActionEvent event) {
      btn0.setDisable(true);
      if (turn == "x") {
         anchorPane0X.setVisible(true);
         state[0] = 'x';
         turn = "o";
         checkWinner();
         return;
      }
      anchorPane0O.setVisible(true);
      state[0] = 'o';
      turn = "x";
      checkWinner();
   }

   // 1
   @FXML
   private AnchorPane anchorPane1X = new AnchorPane();
   @FXML
   private AnchorPane anchorPane1O = new AnchorPane();
   @FXML
   private Button btn1 = new Button();

   public void Button1(ActionEvent event) {
      btn1.setDisable(true);
      if (turn == "x") {
         anchorPane1X.setVisible(true);
         state[1] = 'x';
         turn = "o";
         checkWinner();
         return;
      }
      anchorPane1O.setVisible(true);
      state[1] = 'o';
      turn = "x";
      checkWinner();
   }

   // 2
   @FXML
   private AnchorPane anchorPane2X = new AnchorPane();
   @FXML
   private AnchorPane anchorPane2O = new AnchorPane();
   @FXML
   private Button btn2 = new Button();

   public void Button2(ActionEvent event) {
      btn2.setDisable(true);
      if (turn == "x") {
         anchorPane2X.setVisible(true);
         state[2] = 'x';
         turn = "o";
         checkWinner();
         return;
      }
      anchorPane2O.setVisible(true);
      state[2] = 'o';
      turn = "x";
      checkWinner();
   }

   // 3
   @FXML
   private AnchorPane anchorPane3X = new AnchorPane();
   @FXML
   private AnchorPane anchorPane3O = new AnchorPane();
   @FXML
   private Button btn3 = new Button();

   public void Button3(ActionEvent event) {
      btn3.setDisable(true);
      if (turn == "x") {
         anchorPane3X.setVisible(true);
         state[3] = 'x';
         turn = "o";
         checkWinner();
         return;
      }
      anchorPane3O.setVisible(true);
      state[3] = 'o';
      turn = "x";
      checkWinner();
   }

   // 4
   @FXML
   private AnchorPane anchorPane4X = new AnchorPane();
   @FXML
   private AnchorPane anchorPane4O = new AnchorPane();
   @FXML
   private Button btn4 = new Button();

   public void Button4(ActionEvent event) {
      btn4.setDisable(true);
      if (turn == "x") {
         anchorPane4X.setVisible(true);
         state[4] = 'x';
         turn = "o";
         checkWinner();
         return;
      }
      anchorPane4O.setVisible(true);
      state[4] = 'o';
      turn = "x";
      checkWinner();
   }

   // 5
   @FXML
   private AnchorPane anchorPane5X = new AnchorPane();
   @FXML
   private AnchorPane anchorPane5O = new AnchorPane();
   @FXML
   private Button btn5 = new Button();

   public void Button5(ActionEvent event) {
      btn5.setDisable(true);
      if (turn == "x") {
         anchorPane5X.setVisible(true);
         state[5] = 'x';
         turn = "o";
         checkWinner();
         return;
      }
      anchorPane5O.setVisible(true);
      state[5] = 'o';
      turn = "x";
      checkWinner();
   }

   // 6
   @FXML
   private AnchorPane anchorPane6X = new AnchorPane();
   @FXML
   private AnchorPane anchorPane6O = new AnchorPane();
   @FXML
   private Button btn6 = new Button();

   public void Button6(ActionEvent event) {
      btn6.setDisable(true);
      if (turn == "x") {
         anchorPane6X.setVisible(true);
         state[6] = 'x';
         turn = "o";
         checkWinner();
         return;
      }
      anchorPane6O.setVisible(true);
      state[6] = 'o';
      turn = "x";
      checkWinner();
   }

   // 7
   @FXML
   private AnchorPane anchorPane7X = new AnchorPane();
   @FXML
   private AnchorPane anchorPane7O = new AnchorPane();
   @FXML
   private Button btn7 = new Button();

   public void Button7(ActionEvent event) {
      btn7.setDisable(true);
      if (turn == "x") {
         anchorPane7X.setVisible(true);
         state[7] = 'x';
         turn = "o";
         checkWinner();
         return;
      }
      anchorPane7O.setVisible(true);
      state[7] = 'o';
      turn = "x";
      checkWinner();
   }

   // 8
   @FXML
   private AnchorPane anchorPane8X = new AnchorPane();
   @FXML
   private AnchorPane anchorPane8O = new AnchorPane();
   @FXML
   private Button btn8 = new Button();

   public void Button8(ActionEvent event) {
      btn8.setDisable(true);
      if (turn == "x") {
         anchorPane8X.setVisible(true);
         state[8] = 'x';
         turn = "o";
         checkWinner();
         return;
      }
      anchorPane8O.setVisible(true);
      state[8] = 'o';
      turn = "x";
      checkWinner();
   }

   public void resetBtn(ActionEvent event) {
      for (int i = 0; i < state.length; i++) {
         state[i] = ' ';
      }

      anchorPane0X.setVisible(false);
      anchorPane1X.setVisible(false);
      anchorPane2X.setVisible(false);
      anchorPane3X.setVisible(false);
      anchorPane4X.setVisible(false);
      anchorPane5X.setVisible(false);
      anchorPane6X.setVisible(false);
      anchorPane7X.setVisible(false);
      anchorPane8X.setVisible(false);

      anchorPane0O.setVisible(false);
      anchorPane1O.setVisible(false);
      anchorPane2O.setVisible(false);
      anchorPane3O.setVisible(false);
      anchorPane4O.setVisible(false);
      anchorPane5O.setVisible(false);
      anchorPane6O.setVisible(false);
      anchorPane7O.setVisible(false);
      anchorPane8O.setVisible(false);

      btn0.setDisable(false);
      btn1.setDisable(false);
      btn2.setDisable(false);
      btn3.setDisable(false);
      btn4.setDisable(false);
      btn5.setDisable(false);
      btn6.setDisable(false);
      btn7.setDisable(false);
      btn8.setDisable(false);

      winningMessage.setVisible(false);
   }

   public void menuBtn(ActionEvent event) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("/Menu.fxml"));
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      Scene scene = new Scene(root);
      stage.setScene(scene);
      String css = this.getClass().getResource("/styles.css").toExternalForm();
      scene.getStylesheets().add(css);
      stage.show();
   }
}
