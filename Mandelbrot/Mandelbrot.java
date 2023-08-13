import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Mandelbrot extends JPanel {
    private double zoom = 2.0;
    private final int WIDTH = 1200, HEIGHT = 700;

    public Mandelbrot() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        // Timer
        Timer timer = new Timer(1000 / 60, e -> repaint());
        timer.start();

        // Mouse listener
        addMouseWheelListener(e -> {
            int notches = e.getWheelRotation();
            if (notches < 0) {
                zoom *= 1.1; // Zoom in by increasing zoom factor
            } else {
                zoom /= 1.1; // Zoom out by decreasing zoom factor
            }
        });
    }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            BufferedImage bmp = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

            for (int x = 0; x < WIDTH; x++) {
                for (int y = 0; y < HEIGHT; y++) {
                    // this is worst part 
                    double a = (double) ((x + (0 / 1 / zoom)) - ((WIDTH / 2d) / 1)) / (double) (WIDTH / zoom / 1 / 1.777);
                    double b = (double) ((y + (0 / 1 / zoom)) - ((HEIGHT / 2d) / 1)) / (double) (HEIGHT / zoom / 1);

                    Complex c = new Complex(a, b);
                    Complex z = new Complex(0, 0);

                    int it = 0;
                    do {
                        it++;
                        z.sqrt();
                        z.add(c);

                        if (z.magnitude() > 2.0) break;
                    } while (it < 100);

                    int color = it < 100 ? new Color(it, it, it).getRGB() : new Color(255, 255, 255).getRGB();
                    bmp.setRGB(x, y, color);  
                }
            }

            g.drawImage(bmp, 0, 0, this);
        }
}

