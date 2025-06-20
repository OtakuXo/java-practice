package com.snake;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class App extends Application {
   private enum directionOptions {
      right,
      left,
      up,
      down
   };

   private enum gameStateOptions {
      running,
      stopped
   };

   final int tileSize = 20;
   final int colTiles = 40;
   final int rowTiles = 40;
   final int width = tileSize * colTiles;
   final int height = tileSize * rowTiles;
   final int noOfTiles = colTiles * rowTiles;
   final int snakeX[] = new int[noOfTiles];
   final int snakeY[] = new int[noOfTiles];
   private int snakeLength = 4;
   private int score = 0;
   private gameStateOptions gameState = gameStateOptions.stopped;

   private int appleX;
   private int appleY;

   private directionOptions direction = directionOptions.right;

   Pane root = new Pane();
   final Canvas canvas = new Canvas(width, height);
   GraphicsContext gc = canvas.getGraphicsContext2D();
   Button startBtn = new Button("Start");
   Label scoreLabel = new Label("Score" + Integer.toString(score));
   StackPane canvasHolder = new StackPane(canvas);

   public Parent createContent() {
      AnimationTimer timer = new AnimationTimer() {
         private long lastUpdate = 0;

         @Override
         public void handle(long now) {
            scoreLabel.setText("Score" + Integer.toString(score));
            if (gameState == gameStateOptions.running) {
               start();
            } else {
               stop();
            }
            if (now - lastUpdate >= 50_000_000) {
               update();
               draw();
               lastUpdate = now;
            }
         }
      };

      startBtn.setLayoutY(10);
      startBtn.prefHeight(30);
      startBtn.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent arg0) {
            gameState = gameStateOptions.running;
            timer.start();
            snakeX[0] = (tileSize * colTiles) / 2;
            snakeY[0] = (tileSize * rowTiles) / 2;
            snakeLength = 4;
            score = 0;
            spawnApple();
         }

      });

      scoreLabel.setLayoutY(10);
      scoreLabel.setLayoutX(100);
      scoreLabel.prefHeight(30);
      scoreLabel.setFont(new Font(20.0));

      canvasHolder.setStyle("-fx-background-color:#000");
      canvasHolder.setLayoutY(50);

      root.getChildren().add(scoreLabel);
      root.getChildren().add(startBtn);
      root.getChildren().add(canvasHolder);
      return root;
   }

   public void update() {
      checkAppleEaten();
      for (int i = snakeLength; i > 0; i--) {
         snakeX[i] = snakeX[i - 1];
         snakeY[i] = snakeY[i - 1];
      }

      switch (direction) {
         case right:
            snakeX[0] = snakeX[0] + tileSize;
            break;
         case left:
            snakeX[0] = snakeX[0] - tileSize;
            break;
         case up:
            snakeY[0] = snakeY[0] - tileSize;
            break;
         case down:
            snakeY[0] = snakeY[0] + tileSize;
            break;
      }
      gameOver();
   }

   public void draw() {
      gc.clearRect(0, 0, width, height);
      // for (int i = 1; i < colTiles; i++) {
      //    gc.setStroke(Color.WHEAT);
      //    gc.setLineWidth(1);
      //    gc.strokeLine(i * tileSize, 0, i * tileSize, height);
      // }
      // for (int i = 1; i < rowTiles; i++) {
      //    gc.setStroke(Color.WHEAT);
      //    gc.setLineWidth(1);
      //    gc.strokeLine(0, i * tileSize, width, i * tileSize);
      // }

      for (int i = snakeLength; i >= 0; i--) {
         if (i == 0) {
            gc.setFill(Color.BLUE);
            gc.fillRect(snakeX[i], snakeY[i], tileSize, tileSize);
         } else {
            gc.setFill(Color.AQUA);
            gc.fillRect(snakeX[i], snakeY[i], tileSize, tileSize);
         }
      }

      gc.setFill(Color.RED);
      gc.fillOval(appleX, appleY, tileSize, tileSize);
   }

   public void gameOver() {
      for (int i = snakeLength; i > 0; i--) {
         if (snakeX[i] == snakeX[0] && snakeY[i] == snakeY[0]) {
            gameState = gameStateOptions.stopped;
         }
      }

      if (snakeX[0] > width - tileSize) {
         gameState = gameStateOptions.stopped;
      }
      if (snakeX[0] < 0) {
         gameState = gameStateOptions.stopped;
      }
      if (snakeY[0] > height - tileSize) {
         gameState = gameStateOptions.stopped;
      }
      if (snakeY[0] < 0) {
         gameState = gameStateOptions.stopped;
      }
   }

   public void spawnApple() {
      appleX = ((int) (Math.random() * colTiles)) * tileSize;
      appleY = ((int) (Math.random() * rowTiles)) * tileSize;
   }

   public void checkAppleEaten() {
      if (snakeX[0] == appleX && snakeY[0] == appleY) {
         snakeLength++;
         score++;
         spawnApple();
      }
   }

   @Override
   public void start(Stage primaryStage) throws Exception {
      Scene scene = new Scene(createContent());

      scene.setOnKeyPressed(e -> {
         System.out.println(e.getCode());
         switch (e.getCode()) {
            case A:
            case H:
            case LEFT:
               if (direction == directionOptions.right) {
                  return;
               }
               direction = directionOptions.left;
               break;
            case D:
            case L:
            case RIGHT:
               if (direction == directionOptions.left) {
                  return;
               }
               direction = directionOptions.right;
               break;
            case W:
            case K:
            case UP:
               if (direction == directionOptions.down) {
                  return;
               }
               direction = directionOptions.up;
               break;
            case S:
            case J:
            case DOWN:
               if (direction == directionOptions.up) {
                  return;
               }
               direction = directionOptions.down;
               break;
            default:
               break;
         }
      });

      primaryStage.setScene(scene);
      primaryStage.show();
   }

   public static void main(String[] args) {
      launch(args);
   }
}
