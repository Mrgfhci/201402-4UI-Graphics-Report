import java.awt.*;
public class Point {
    int nX = 300;
    int nY = 300;
    private PanMain panMain;
    public void paint(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillOval(nX,nY,25,25);
        
    }
    public Rectangle getBounds() {
        return new Rectangle(nX,nY,25,25);
    }
    public boolean collision() {
        return panMain.hitBox.getBounds().intersects(getBounds());
    }
}