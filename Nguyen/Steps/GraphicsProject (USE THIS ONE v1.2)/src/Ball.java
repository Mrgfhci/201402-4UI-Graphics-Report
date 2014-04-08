
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {

    private static final int nDiameter = 30;
    private PanGame panGame;
    int nX;
    int nY;
    static int nScore = 0;

    public Ball(PanGame panGame) {
        this.panGame = panGame;
        nX = (int) (Math.random() * (784 - nDiameter));//using panGame.getWidth() or .getHeight() would give me 0 here so I manually inputted the values
        nY = (int) (Math.random() * (462 - nDiameter));
    }

    void Spawn() {
        if (collision()) {
            nX = (int) (Math.random() * (panGame.getWidth() - nDiameter));
            nY = (int) (Math.random() * (panGame.getHeight() - nDiameter));
            nScore++;
        }
    }
    public static int getScore() {
        return nScore;
    }
    private boolean collision() {
        return panGame.imgSquare.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g) {
        g.fillOval(nX, nY, nDiameter, nDiameter);
    }

    public Rectangle getBounds() {
        return new Rectangle(nX, nY, nDiameter, nDiameter);
    }
}
