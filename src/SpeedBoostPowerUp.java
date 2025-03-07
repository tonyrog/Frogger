import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * PowerUp som ger spelaren tillfällig hastighetsbost
 */
public class SpeedBoostPowerUp extends PowerUp {
    
    public SpeedBoostPowerUp(double x, double y) {
        super(x, y);
        
        // Skapa en cyan cirkel för hastighetsboost
        Circle circle = new Circle(SIZE, Color.CYAN);
        node = circle;
        updateNodePosition();
    }
    
    @Override
    public void applyEffect(Frog player) {
        // Aktivera hastighetsboost för spelaren
        player.enableSpeedBoost();
    }
}