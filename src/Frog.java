import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.animation.FillTransition;
import javafx.util.Duration;

/**
 * Representerar spelarens grodkaraktär
 */
public class Frog extends GameObject {
    private static final int SIZE = 38;
    private static final double DEFAULT_MOVE_DISTANCE = 40;
    
    private double moveDistance = DEFAULT_MOVE_DISTANCE;
    private boolean invincible = false;
    private long invincibilityEndTime = 0;
    private long speedBoostEndTime = 0;
    
    public Frog(double x, double y) {
        super(x, y);
        
        Rectangle rect = new Rectangle(SIZE, SIZE, Color.GREEN);
        node = rect;
        updateNodePosition();
    }
    
    public void moveUp() {
        setPosition(x, Math.max(0, y - moveDistance));
    }
    
    public void moveDown() {
        setPosition(x, y + moveDistance);
    }
    
    public void moveLeft() {
        setPosition(Math.max(0, x - moveDistance), y);
    }
    
    public void moveRight() {
        setPosition(x + moveDistance, y);
    }
    
    public void reset(double x, double y) {
        setPosition(x, y);
        disableInvincibility();
        disableSpeedBoost();
    }
    
    @Override
    public void update(double deltaTime) {
        long currentTime = System.currentTimeMillis();
        
        // Kontrollera om invincibility har löpt ut
        if (invincible && currentTime > invincibilityEndTime) {
            disableInvincibility();
        }
        
        // Kontrollera om speed boost har löpt ut
        if (moveDistance > DEFAULT_MOVE_DISTANCE && currentTime > speedBoostEndTime) {
            disableSpeedBoost();
        }
    }
    
    /**
     * Aktiverar odödlighet i 5 sekunder
     */
    public void enableInvincibility() {
        invincible = true;
        invincibilityEndTime = System.currentTimeMillis() + 5000;
        
        // Visuell effekt
        Rectangle rect = (Rectangle) node;
        rect.setFill(Color.GOLD);
    }
    
    /**
     * Inaktiverar odödlighet
     */
    public void disableInvincibility() {
        invincible = false;
        
        // Återställ utseende
        Rectangle rect = (Rectangle) node;
        rect.setFill(Color.GREEN);
    }
    
    /**
     * Aktiverar hastighetsboost i 5 sekunder
     */
    public void enableSpeedBoost() {
        moveDistance = DEFAULT_MOVE_DISTANCE * 2;
        speedBoostEndTime = System.currentTimeMillis() + 5000;
        
        // Visuell effekt
        Rectangle rect = (Rectangle) node;
        rect.setStroke(Color.CYAN);
        rect.setStrokeWidth(3);
    }
    
    /**
     * Inaktiverar hastighetsboost
     */
    public void disableSpeedBoost() {
        moveDistance = DEFAULT_MOVE_DISTANCE;
        
        // Återställ utseende
        Rectangle rect = (Rectangle) node;
        rect.setStroke(null);
    }
    
    /**
     * Kontrollerar om spelaren är odödlig
     */
    public boolean isInvincible() {
        return invincible;
    }
}