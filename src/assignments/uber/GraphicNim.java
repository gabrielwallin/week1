package assignments.uber;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import static java.lang.System.*;

/**
 * Graphical version of Nim (no game logic implemented)
 * Try to run and then implement it ...
 * Play around, have fun ...
 */
public class GraphicNim extends JPanel {

    public static void main(String[] args) {
        new GraphicNim().program();
    }

    final int width = 400;   // Size of paint area
    final int height = 400;
    final int maxCoin = 13;
    int pile = maxCoin;
    Image computer;
    Image buttons;
    Image coin;
    Clip computerVoice;
    boolean humanIsPlayer = true;

    void program() {
        initResources();
        initGraphics();
        //computerVoice.loop(1);
    }

    class MouseListener extends MouseAdapter {
        // This is called when mouse clicked
        public void mouseClicked(MouseEvent e) {
            if (!humanIsPlayer) {
                return;
            }
            int i = getButtonValue(e.getX(), e.getY());
            pile -= i;
            out.println(pile);
            computerVoice.loop(1);
            repaint(); // Will call paint() below
        }
    }


    private int getButtonValue(int x, int y) {
        if (100 <= x && x <= 150 && y <= 300 && y <= 400) {
            return 1;
        } else {
            return 2;
        }
    }

    // --- Below is initialization and graphics --------------

    // Repaint GUI
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < pile; i++) {
            g2.drawImage(coin, width / 2 - (coin.getWidth(null) / 2), height / 4 + i * 10, null);
        }
        g2.drawImage(computer, 20, 100, this);
        g2.drawImage(buttons, 200, 300, null);
    }

    // Will create a window with a draw area on screen.
    void initGraphics() {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.WHITE);
        JFrame window = new JFrame("NIM");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(this);
        window.addMouseListener(new MouseListener());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    // Get som resources
    void initResources() {
        coin = new ImageIcon(this.getClass()
                .getResource("gold_coin_single.png"))
                .getImage();
        buttons = new ImageIcon(this.getClass()
                .getResource("buttons.png"))
                .getImage();

        // Must use for animated gif (?)
        computer = new ImageIcon(this.getClass()
                .getResource("eyes.gif"))
                .getImage();

        try {
            // Some sounds
            computerVoice = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.
                    getAudioInputStream(this.getClass().getResourceAsStream("atari.wav"));
            computerVoice.open(ais);
            // coinSound
            // bgMusic

        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
