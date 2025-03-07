import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * PowerUp som ger spelaren tillfällig odödlighet
 */
public class InvincibilityPowerUp extends PowerUp {
    
    public InvincibilityPowerUp(double x, double y) {
        super(x, y);
        
        // Skapa en gyllene cirkel för odödlighet
        Circle circle = new Circle(SIZE, Color.GOLD);
        node = circle;
        updateNodePosition();
    }
    
    @Override
    public void applyEffect(Frog player) {
        // Aktivera odödlighet för spelaren
        player.enableInvincibility();
    }
}