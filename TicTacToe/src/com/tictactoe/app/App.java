package com.tictactoe.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.util.Random;

public class App extends Application {

	Button button = new Button();
	Button button2 = new Button();
	Button button3 = new Button();
	Button button4 = new Button();
	Button button5 = new Button();
	Button button6 = new Button();
	Button button7 = new Button();
	Button button8 = new Button();
	Button button9 = new Button();
	Button restart = new Button("Restart");

	Stage stage;
	Scene scene1;
	int width = 400;
	int heigth = 400;
	boolean turnX = true;
	double lineLengthS = 100.0;
	double lineLengthE = -100.0;
	int position = -100;
	int positionY = -200;
	boolean winner = false;

	Label playerTurn = new Label("Player O's Turn");
	Label AIOnOff = new Label();


	String[][] arr = new String[3][3];
	Line line1 = new Line(0.0, lineLengthS, 0.0, lineLengthE);
	Line line2 = new Line(0.0, lineLengthS, 0.0, lineLengthE);
	Line line3 = new Line(lineLengthS, 0.0, lineLengthE, 0.0);
	Line line4 = new Line(lineLengthS, 0.0, lineLengthE, 0.0);

	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		StackPane layout1 = new StackPane();

		playerTurn.setTranslateX(position + 45);
		playerTurn.setTranslateY(positionY + 45);
		playerTurn.setFont(Font.font("", FontWeight.BOLD, 35));
		playerTurn.setTextFill(Color.BLACK);

		restart.setTranslateX(100);
		restart.setTranslateY(-35);
		restart.setOnAction(e -> reset());


		button.setOnAction(e -> {
			gameTurns(button);
			if (!turnX)
				arr[0][0] = "o";
			else
				arr[0][0] = "x";
			if (!turnX)
				playerTurn.setText("Player X's Turn");
			else
				playerTurn.setText("Player O's Turn");
			checkWinner(arr);

		});
		button2.setOnAction(e -> {
			gameTurns(button2);
			if (!turnX)
				arr[0][1] = "o";
			else
				arr[0][1] = "x";
			if (!turnX)
				playerTurn.setText("Player X's Turn");
			else
				playerTurn.setText("Player O's Turn");
			checkWinner(arr);
		});
		button3.setOnAction(e -> {
			gameTurns(button3);
			if (!turnX)
				arr[0][2] = "o";
			else
				arr[0][2] = "x";
			if (!turnX)
				playerTurn.setText("Player X's Turn");
			else
				playerTurn.setText("Player O's Turn");
			checkWinner(arr);
		});
		button4.setOnAction(e -> {
			gameTurns(button4);
			if (!turnX)
				arr[1][0] = "o";
			else
				arr[1][0] = "x";
			if (!turnX)
				playerTurn.setText("Player X's Turn");
			else
				playerTurn.setText("Player O's Turn");
			checkWinner(arr);
		});
		button5.setOnAction(e -> {
			gameTurns(button5);
			if (!turnX)
				arr[1][1] = "o";
			else
				arr[1][1] = "x";
			if (!turnX)
				playerTurn.setText("Player X's Turn");
			else
				playerTurn.setText("Player O's Turn");
			checkWinner(arr);
		});
		button6.setOnAction(e -> {
			gameTurns(button6);
			if (!turnX)
				arr[1][2] = "o";
			else
				arr[1][2] = "x";
			if (!turnX)
				playerTurn.setText("Player X's Turn");
			else
				playerTurn.setText("Player O's Turn");
			checkWinner(arr);
		});
		button7.setOnAction(e -> {
			gameTurns(button7);
			if (!turnX)
				arr[2][0] = "o";
			else
				arr[2][0] = "x";
			if (!turnX)
				playerTurn.setText("Player X's Turn");
			else
				playerTurn.setText("Player O's Turn");
			checkWinner(arr);
		});
		button8.setOnAction(e -> {
			gameTurns(button8);
			if (!turnX)
				arr[2][1] = "o";
			else
				arr[2][1] = "x";
			if (!turnX)
				playerTurn.setText("Player X's Turn");
			else
				playerTurn.setText("Player O's Turn");
			checkWinner(arr);
		});
		button9.setOnAction(e -> {
			gameTurns(button9);
			if (!turnX)
				arr[2][2] = "o";
			else
				arr[2][2] = "x";
			if (!turnX)
				playerTurn.setText("Player X's Turn");
			else
				playerTurn.setText("Player O's Turn");
			checkWinner(arr);
		});

		placeButtons();
		createBoard();
		layout1.getChildren().addAll(line1, line2, line3, line4, button, button2, button3, button4, button5, button6,
				button7, button8, button9, playerTurn, restart);

		scene1 = new Scene(layout1, width, heigth, Color.WHITE);
		stage.setScene(scene1);
		stage.setTitle("Tic-Tac-Toe Game");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}


	public void reset() {
		button.setGraphic(null);
		button2.setGraphic(null);
		button3.setGraphic(null);
		button4.setGraphic(null);
		button5.setGraphic(null);
		button6.setGraphic(null);
		button7.setGraphic(null);
		button8.setGraphic(null);
		button9.setGraphic(null);

		turnX = true;
		winner = false;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = null;
			}
		}
		if (!turnX)
			playerTurn.setText("Player X's Turn");
		else
			playerTurn.setText("Player O's Turn");
	}

	public void checkWinner(String[][] a) {
		int counterL = 0;
		for (int i = 0; i < 3; i++) {
			int counterR = 0, counterC = 0;

			for (int j = 0; j < 3; j++) {
				// check rows
				if ("x".equals(a[i][j]))
					counterR++;
				if ("o".equals(a[i][j]))
					counterR--;

				// check column
				if ("x".equals(a[j][i]))
					counterC++;
				if ("o".equals(a[j][i]))
					counterC--;

				if (i + j == 2) {
					if ("x".equals(a[i][j]))
						counterL++;
					if ("o".equals(a[i][j]))
						counterL--;
				}
			}
			if ((counterR == 3 || counterC == 3 || counterL == 3) && winner != true) {
				playerTurn.setText("X WINS!");
				winner = true;

			}
			if ((counterR == -3 || counterC == -3 || counterL == -3) && winner != true) {
				playerTurn.setText("O WINS!");
				winner = true;
			}
		}
		int counterR = 0;

		for (int i = 0; i < 3; i++) {
			if ("x".equals(a[i][i]))
				counterR++;
			if ("o".equals(a[i][i]))
				counterR--;
		}

		if (counterR == 3 && winner == false) {
			playerTurn.setText("X WINS!");
			winner = true;
		}
		if (counterR == -3 && winner == false) {
			playerTurn.setText("O WINS!");
			winner = true;
		}

		int counter = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (a[i][j] != null)
					counter++;
			}
		}
		if (counter == 9 && winner == false) {
			playerTurn.setText("Game is a Tie");
		}

	}

	public void gameTurns(Button b) {
		if (winner)
			return;
		Text X = new Text("X");
		X.setFont(Font.font("", FontWeight.BOLD, 50));
		Text O = new Text("O");
		O.setFont(Font.font("", FontWeight.BOLD, 50));

		if (!turnX && b.getGraphic() == null) {
			b.setGraphic(X);
			turnX = true;

		} else if (turnX && b.getGraphic() == null) {
			b.setGraphic(O);
			turnX = false;
		}
	}

	public void createBoard() {
		line1.setStrokeWidth(3.0);
		line2.setStrokeWidth(3.0);
		line3.setStrokeWidth(3.0);
		line4.setStrokeWidth(3.0);

		line1.setTranslateX(position);
		line1.setTranslateY(positionY + 195);
		line2.setTranslateX(position + 70);
		line2.setTranslateY(positionY + 195);
		line3.setTranslateX(position + 35);
		line3.setTranslateY(positionY + 160);
		line4.setTranslateX(position + 35);
		line4.setTranslateY(positionY + 230);
	}

	public void placeButtons() {
		button.setMinHeight(65);
		button.setMinWidth(65);
		button.setTranslateX(position - 35);
		button.setTranslateY(positionY + 125);

		button2.setMinHeight(65);
		button2.setMinWidth(65);
		button2.setTranslateX(position + 35);
		button2.setTranslateY(positionY + 125);

		button3.setMinHeight(65);
		button3.setMinWidth(65);
		button3.setTranslateX(position + 105);
		button3.setTranslateY(positionY + 125);

		button4.setMinHeight(65);
		button4.setMinWidth(65);
		button4.setTranslateX(position - 35);
		button4.setTranslateY(positionY + 195);

		button5.setMinHeight(65);
		button5.setMinWidth(65);
		button5.setTranslateX(position + 35);
		button5.setTranslateY(positionY + 195);

		button6.setMinHeight(65);
		button6.setMinWidth(65);
		button6.setTranslateX(position + 105);
		button6.setTranslateY(positionY + 195);

		button7.setMinHeight(65);
		button7.setMinWidth(65);
		button7.setTranslateX(position - 35);
		button7.setTranslateY(positionY + 265);

		button8.setMinHeight(65);
		button8.setMinWidth(65);
		button8.setTranslateX(position + 35);
		button8.setTranslateY(positionY + 265);

		button9.setMinHeight(65);
		button9.setMinWidth(65);
		button9.setTranslateX(position + 105);
		button9.setTranslateY(positionY + 265);

		button.setBackground(Background.EMPTY);
		button2.setBackground(Background.EMPTY);
		button3.setBackground(Background.EMPTY);
		button4.setBackground(Background.EMPTY);
		button5.setBackground(Background.EMPTY);
		button6.setBackground(Background.EMPTY);
		button7.setBackground(Background.EMPTY);
		button8.setBackground(Background.EMPTY);
		button9.setBackground(Background.EMPTY);
	}
}