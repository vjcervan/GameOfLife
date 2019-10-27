import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimateGameOfLife extends Application
{
	private GridPane pane = new GridPane();
	private Timeline animation;
	private GameOfLife game;
	
	@Override
	public void start(Stage primaryStage)
	{
		pane.setAlignment(Pos.CENTER);
		game = new GameOfLife(20, 20);
		//game.oscillatePatternInitialGrid();
		//game.blockPatternInitialGrid();
		game.randomizeInitialGrid();
		updateGrid();
		
		Scene scene = new Scene(pane, game.getGrid().length * 30, game.getGrid()[0].length * 30);
		primaryStage.setTitle("Game of Life");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		animation = new Timeline(new KeyFrame(Duration.millis(500), e -> { game.nextIteration(); updateGrid(); } ));
		animation.setCycleCount(100);
		animation.play();
	}
	
	private void updateGrid()
	{
		int[][] g = game.getGrid();
		for (int i = 0; i < g.length; i++)
		{
			for (int j = 0; j < g[i].length; j++)
			{
				Rectangle r = new Rectangle(0, 0, 20, 20);
				r.setStroke(Color.BLACK);
				if (g[i][j] == 1)
					r.setFill(Color.BLACK);	
				else
					r.setFill(Color.WHITE);
						
				pane.add(r, j, i);		
			}
		}
	}
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}
}