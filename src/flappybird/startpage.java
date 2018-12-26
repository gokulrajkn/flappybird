/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import static flappybird.FlappyBird.home;
import static flappybird.homepage.gamemode;
import static flappybird.homepage.globtimer;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author bayasys
 */
//public class startpage extends javax.swing.JFrame {
public class startpage extends javax.swing.JPanel implements ActionListener {

    /**
     * @param args the command line arguments
     */
    Boolean refreshed = true;
    Random rand = new Random();
    int x, y, a1, h1, h2, h3, h4, rectmove, newrec, score;
    Timer timer;

    public startpage() {
        score = 0;
        x = 150;
        y = 270;
        rectmove = 0;
        a1 = 280;
        h1 = (rand.nextInt(16) + 4) * 20;
        h2 = (rand.nextInt(16) + 4) * 20;
        h3 = (rand.nextInt(16) + 4) * 20;
        h4 = (rand.nextInt(16) + 4) * 20;
        timer = new Timer(20, this);
        int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
        InputMap inMap = getInputMap(condition);
        ActionMap actMap = getActionMap();
        inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "Top");
        actMap.put("Top", new MyClass());
        this.setFocusable(true);
        this.requestFocusInWindow();

//        setSize(new Dimension(600, 600));
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//        JPanel p = new JPanel() { 
//            @Override
//            public void paintComponent(Graphics g) {
//                Graphics2D g2 = (Graphics2D) g;
////                Shape line = new Line2D.Double(3, 3, 303, 303);
//                Shape rectup = new Rectangle(130, 0, 30, 190);
//                Shape rectdown = new Rectangle(130, 260, 30, 300);
//                Shape circle = new Ellipse2D.Double(200, 200, 25, 25);
////                Shape roundRect = new RoundRectangle2D.Double(20, 20, 250, 250, 5, 25);
////                g2.draw(line);
//                g2.draw(rectup);
//                g2.draw(rectdown);
//                g2.draw(circle);
////                g2.draw(roundRect);
//            }
//        };
        JFrame Fram = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (Fram != null) {
            Fram.setTitle("Flappy Bird          " + FlappyBird.username + "                   SCORE : 00");
        }
//        this.getContentPane().add(p);
    }

    public void birdup() {
        y = y - 50;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        BufferedImage img = null;
        BufferedImage img1 = null;
        String filepath = new File("").getAbsolutePath() + File.separatorChar + "src" + File.separatorChar + "flappybird" + File.separatorChar + "bird.png";
        String filepath1 = new File("").getAbsolutePath() + File.separatorChar + "src" + File.separatorChar + "flappybird" + File.separatorChar + "bg.png";
        try {
            img = ImageIO.read(new File(filepath));
            img1 = ImageIO.read(new File(filepath1));
        } catch (IOException e) {
        }
        g.drawImage(img1, 0, 0,1200,600, null);
        g.drawImage(img, x, y, 50, 50, null);
//        g.fillOval(x, y, 30, 30);
        g.setColor(Color.GREEN);
        g.fillRect(a1, 0, 60, h1);
        g.fillRect(a1, h1 + 120, 60, 440 - h1);
        g.fillRect(a1 + 400, 0, 60, h2);
        g.fillRect(a1 + 400, h2 + 120, 60, 440 - h2);
        g.fillRect(a1 + 800, 0, 60, h3);
        g.fillRect(a1 + 800, h3 + 120, 60, 440 - h3);

    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                new startpage();
//            }
//        });
//    }
    @Override
    public void actionPerformed(ActionEvent e) {
//        x += 1;
        String line = null;
        Integer[] hs = new Integer[6];
        String[] username = new String[6];
        Integer cnt = 0;
        if (y <= 0 || y >= 600 || (x + 25 > a1 && x + 25 < a1 + 60 && (y <= h1 || y >= h1 + 120))
                || (x + 25 > a1 + 400 && x + 25 < a1 + 460 && (y <= h2 || y >= h2 + 120))
                || (x + 25 > a1 + 800 && x + 25 < a1 + 860 && (y <= h3 || y >= h3 + 120))
                || y + 25 <= 0 || y + 25 >= 600 || (x + 50 > a1 && x + 50 < a1 + 60 && (y + 25 <= h1 || y + 25 >= h1 + 120))
                || (x + 50 > a1 + 400 && x + 50 < a1 + 460 && (y + 25 <= h2 || y + 25 >= h2 + 120))
                || (x + 50 > a1 + 800 && x + 50 < a1 + 860 && (y + 25 <= h3 || y + 25 >= h3 + 120))
                || y + 25 <= 0 || y + 25 >= 600 || (x > a1 && x < a1 + 60 && (y + 25 <= h1 || y + 25 >= h1 + 120))
                || (x > a1 + 400 && x < a1 + 460 && (y + 25 <= h2 || y + 25 >= h2 + 120))
                || (x > a1 + 800 && x < a1 + 860 && (y + 25 <= h3 || y + 25 >= h3 + 120))
                || y + 50 <= 0 || y + 50 >= 600 || (x + 25 > a1 && x + 25 < a1 + 60 && (y + 50 <= h1 || y + 50 >= h1 + 120))
                || (x + 25 > a1 + 400 && x + 25 < a1 + 460 && (y + 50 <= h2 || y + 50 >= h2 + 120))
                || (x + 25 > a1 + 800 && x + 25 < a1 + 860 && (y + 50 <= h3 || y + 50 >= h3 + 120))) {
            globtimer.stop();
            y = 600;
            Frame[] curframe = Frame.getFrames();
//            this.hide();
            String filepath = new File("").getAbsolutePath() + File.separatorChar + "src" + File.separatorChar + "flappybird" + File.separatorChar + "higscore.txt";
            File file = new File(filepath);

            try {
                //Create the file
                FileWriter writer;
                if (file.createNewFile()) {
                    writer = new FileWriter(file);
                    writer.write(score + " - " + FlappyBird.username);
                    writer.close();
                } else {
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader
                            = new BufferedReader(fileReader);

                    while ((line = bufferedReader.readLine()) != null) {
                        if (cnt < 5) {
                            hs[cnt] = Integer.parseInt(line.substring(0, line.indexOf(" ")));
                            username[cnt] = (line.substring(line.indexOf("-") + 2)).toString();
                            cnt++;
                        }
                    }
                    hs[cnt] = score;
                    username[cnt] = FlappyBird.username;
                    int temp = 0;
                    String unametemp;
                    String data = "";
                    for (int i = 0; i <= cnt + 1; i++) {
                        for (int j = i + 1; j < cnt + 1; j++) {
                            if (hs[i] < hs[j]) {
                                temp = hs[j];
                                unametemp = username[j];
                                hs[j] = hs[i];
                                username[j] = username[i];
                                hs[i] = temp;
                                username[i] = unametemp;
                            }
                        }
                    }
                    data = hs[0].toString() + " - " + username[0];
                    for (int i = 1; i < 5; i++) {
                        if(hs[i] != null && username[i] != null)
                        data += "\n" + hs[i].toString() + " - " + username[i];
                    }
                    writer = new FileWriter(file);
                    writer.write(data);
                    writer.close();
                }

//Write Content
            } catch (IOException ex) {
                Logger.getLogger(startpage.class.getName()).log(Level.SEVERE, null, ex);
            }
//            final JOptionPane pane = new JOptionPane();
            int input = JOptionPane.showConfirmDialog(null, "Your score: " + score + "\n Do you want to try again?", "Game Over", JOptionPane.YES_NO_OPTION);
//            JOptionPane.getRootFrame().dispose();
            if (input == JOptionPane.YES_OPTION) {
                for (Frame frame : curframe) {
                    frame.hide();
                }
                home.show();
//                startpage view1 = new startpage();
//                view1.setVisible(true);
//                view1.setSize(1200, 600);
//                JFrame f = new JFrame("Flappy Bird");
//                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                f.setAlwaysOnTop(true);
//                f.add(view1);
//                f.setSize(1200, 600);
//                f.setVisible(true);
//                globtimer = view1.timer;
//                globtimer.start();

            } else if (input == JOptionPane.CANCEL_OPTION) {
                for (Frame frame : curframe) {
                    frame.hide();
                }
                System.exit(0);
            }
        }

        y += gamemode;
//        if (rectmove == 60) {
//            rectmove = 0;
//            x = x - 60;
        if (refreshed && a1 < 210) {
            score++;
            refreshed = false;
            JFrame Fram = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (Fram != null) {
                Fram.setTitle("Flappy Bird          " + FlappyBird.username + "                   SCORE : " + score);
            }
        }
        a1 = a1 - 1;
//        }
        if (a1 < 0) {
            a1 = a1 + 400;
            refreshed = true;
            newrec = (rand.nextInt(16) + 4) * 20;
            h1 = h2;
            h2 = h3;
            h3 = newrec;
        }
        rectmove++;
        repaint();//To change body of generated methods, choose Tools | Templates.
    }

    public class MyClass extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
//            if (e.getKeyCode() == KeyEvent.VK_KP_UP) {
            birdup();
//            }
        }
    }
}
