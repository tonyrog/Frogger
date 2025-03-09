import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Representerar en bil-fiende som rör sig horisontellt i rak bana
 */
public class Car extends Enemy {
    private static final int SIZE = 40;
    private static final double MIN_SPEED = 50.0;
    private static final double MAX_SPEED = 150.0;
    private boolean movingRight;
    
    public Car(double x, double y, boolean movingRight) {
        super(x, y);
        this.movingRight = movingRight;
        
        // Slumpmässig hastighet
        speed = MIN_SPEED + Math.random() * (MAX_SPEED - MIN_SPEED);
        
        // Skapa grafisk representation
	if (movingRight) {
	    Image image = new Image("images/blue.png",2*SIZE,SIZE,false,true);
	    ImageView imv = new ImageView();
	    imv.setImage(image);
	    node = imv;
	}
	else {
	    Rectangle rect = new Rectangle(SIZE, SIZE, Color.DARKRED);
	    node = rect;
	}
        updateNodePosition();
    }
    
    @Override
    public void update(double deltaTime) {
        // Uppdatera position baserat på hastighet och riktning
        double movement = speed * deltaTime;
        if (!movingRight) {
            movement = -movement;
        }
        
        setPosition(x + movement, y);
        
        // Återanvänd bilar när de går utanför skärmen
        if ((movingRight && x > 800) || (!movingRight && x < -SIZE)) {
            if (movingRight) {
                setPosition(-SIZE, y);
            } else {
                setPosition(800, y);
            }
        }
    }
}
