/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import static flappybird.homepage.gamemode;
import java.awt.Frame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author bayasys
 */
public class FlappyBird {

    /**
     * @param args the command line arguments
     */
    public static String username;
    public static homepage home;
    public static void main(String[] args) {
        home = new homepage();
        home.setVisible(true);
        home.setSize(400, 400);
        gamemode = 1;
    }

}
