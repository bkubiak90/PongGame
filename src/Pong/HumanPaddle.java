package Pong;

import java.awt.*;

public class HumanPaddle implements Paddle{
    double y, yVel;
    boolean upAccel, downAccel;
    final double GRAVITY = 0.75;
    int player, x;

    public HumanPaddle(int player) {
        upAccel = false;
        downAccel = false;
        y = 210;
        yVel = 0;
        if (player == 1) {
            x = 20;
        } else {
            x = 660;
        }
        this.player = player;
    }

    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(x, (int)y, 20, 80);
    }

    public void move() {
        if (upAccel) {
            yVel -= 1.5;
        } else if (downAccel) {
            yVel += 1.5;
        } else if (!upAccel && ! downAccel) {
            yVel *= GRAVITY;
        }

        if (yVel >= 5)
            yVel = 5;
        else if (yVel <= -5)
            yVel = -5;

        if (y < 0.0)
            y = 0.0;
        else if (y > 420.0)
            y = 420.0;

        y += yVel;
    }

    public void setUpAccel(boolean input) {
        upAccel = input;
    }

    public void setDownAccel(boolean input) {
        downAccel = input;
    }

    public int getY() {
        return (int) y;
    }
}
