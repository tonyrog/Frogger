import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Basklass för alla powerups i spelet
 */
public abstract class PowerUp extends GameObject {
    protected static final int SIZE = 15;
    
    public PowerUp(double x, double y) {
        super(x, y);
    }
    
    /**
     * Applicerar powerup-effekten på spelaren
     * @param player Spelaren som tar powerupen
     */
    public abstract void applyEffect(Frog player);
    
    @Override
    public void update(double deltaTime) {
        // Powerups är statiska i grundformen, men kan överskrivas för animeringseffekter
    }
}