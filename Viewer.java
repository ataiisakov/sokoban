import javax.swing.JFrame;
public class Viewer {
    private Canvas canvas;

    public Viewer() {

        Controller controller = new Controller(this);
        Model model = controller.getModel();
        canvas = new Canvas(model);

        JFrame frame = new JFrame("Sokoban");
        frame.addKeyListener(controller);
        frame.setSize(1200, 700);
        frame.setLocation(20, 0);
        frame.add("Center", canvas);
        frame.setVisible(true);

    }
    public void updateCanvas() {
        canvas.repaint();
    }
}
