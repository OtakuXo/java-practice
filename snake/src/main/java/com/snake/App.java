package com.snake;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

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
   private gameStateOptions gameState = gameStateOptions.stopped;

   private int appleX;
   private int appleY;

   private directionOptions direction = directionOptions.right;

   Pane root = new Pane();
   final Canvas canvas = new Canvas(width, height);
   GraphicsContext gc = canvas.getGraphicsContext2D();

   public Parent createContent() {
      AnimationTimer timer = new AnimationTimer() {
         private long lastUpdate = 0;

         @Override
         public void handle(long now) {
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
      snakeX[0] = (tileSize * colTiles) / 2;
      snakeY[0] = (tileSize * rowTiles) / 2;
      spawnApple();
      timer.start();

      StackPane canvasHolder = new StackPane(canvas);
      canvasHolder.setStyle("-fx-background-color:#000");
      canvasHolder.setLayoutY(50);
      root.getChildren().add(canvasHolder);
      return root;
   }

   public void update() {

      System.out.println(gameState);
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
      for (int i = 1; i < colTiles; i++) {
         gc.setStroke(Color.WHEAT);
         gc.setLineWidth(1);
         gc.strokeLine(i * tileSize, 0, i * tileSize, height);
      }
      for (int i = 1; i < rowTiles; i++) {
         gc.setStroke(Color.WHEAT);
         gc.setLineWidth(1);
         gc.strokeLine(0, i * tileSize, width, i * tileSize);
      }

      for (int i = snakeLength; i >= 0; i--) {
         if (i == 0) {
            gc.setFill(Color.BLUE);
            gc.fillRect(snakeX[i], snakeY[i], tileSize, tileSize);
         } else {
            gc.setFill(Color.AQUA);
            gc.fillRect(snakeX[i], snakeY[i], tileSize, tileSize);
         }
      }

      for (int i = 0; i < snakeLength; i++) {
         gc.setFill(Color.RED);
         gc.fillOval(appleX, appleY, tileSize, tileSize);
      }
   }

   public void gameOver() {
      System.out.println(snakeY[0]);
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

   @Override
   public void start(Stage primaryStage) throws Exception {
      gameState = gameStateOptions.running;
      Scene scene = new Scene(createContent());

      scene.setOnKeyPressed(e -> {
         System.out.println(e.getCode());
         switch (e.getCode()) {
            case A:
            case LEFT:
               direction = directionOptions.left;
               break;
            case D:
            case RIGHT:
               direction = directionOptions.right;
               break;
            case W:
            case UP:
               direction = directionOptions.up;
               break;
            case S:
            case DOWN:
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
