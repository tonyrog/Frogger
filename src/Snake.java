import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Representerar en orm-fiende som jagar spelaren
 */
public class Snake extends Enemy {
    private static final int SIZE = 35;
    private static final double CHASE_SPEED = 60.0;
    private Frog target;
    
    public Snake(double x, double y, Frog target) {
        super(x, y);
        this.target = target;
        
        // Sätt basfart
        speed = CHASE_SPEED;
        
        // Skapa grafisk representation
        Rectangle rect = new Rectangle(SIZE, SIZE, Color.DARKGREEN);
        node = rect;
        updateNodePosition();
    }
    
    /**
     * Sätter spelaren som måltavla för ormen
     */
    @Override
    public void setTarget(Frog target) {
        this.target = target;
    }
    
    @Override
    public void update(double deltaTime) {
        // Om inget mål finns, gör ingenting
        if (target == null) {
            return;
        }
        
        // Beräkna riktning mot spelaren
        double dx = target.getX() - x;
        double dy = target.getY() - y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        
        // Normalisera riktningen om det behövs
        if (distance > 0) {
            dx /= distance;
            dy /= distance;
        }
        
        // Uppdatera position baserat på hastighet
        double movement = speed * deltaTime;
        setPosition(x + dx * movement, y + dy * movement);
    }
}
