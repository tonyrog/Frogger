import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Representerar huvudmenyn i spelet med knappar för olika alternativ
 */
public class MenuScene {
    private Scene scene;
    private Main app;
    
    public MenuScene(Main app) {
        this.app = app;
        createMenuScene();
    }
    
    private void createMenuScene() {
        VBox menuBox = new VBox(20);
        menuBox.setAlignment(Pos.CENTER);
        menuBox.setPrefSize(800, 600);
        
        // Titel
        Text titleText = new Text("FROGGER");
        titleText.setFont(Font.font(60));
        
        // Knappar
        Button newGameButton = createButton("Nytt Spel", event -> app.startNewGame());
        Button highScoreButton = createButton("Highscore", event -> app.showHighScores());
        Button exitButton = createButton("Avsluta", event -> app.exitGame());
        
        menuBox.getChildren().addAll(titleText, newGameButton, highScoreButton, exitButton);
        
        scene = new Scene(menuBox);
    }
    
    private Button createButton(String text, javafx.event.EventHandler<javafx.event.ActionEvent> handler) {
        Button button = new Button(text);
        button.setPrefWidth(200);
        button.setPrefHeight(40);
        button.setFont(Font.font(16));
        button.setOnAction(handler);
        return button;
    }
    
    public Scene getScene() {
        return scene;
    }
}