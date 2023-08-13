import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
            public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Mandelbrot Set Visualization");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new Mandelbrot());
                frame.pack();
                frame.setVisible(true);
            });
        }
}
