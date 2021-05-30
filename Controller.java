
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Controller implements KeyListener{

    private Model model;

    public Controller(Viewer viewer) {
        model = new Model(viewer);
    }


    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        switch(keyCode) {
            case 37:
                model.move("Left");
                break;
            case 38:
                model.move("Up");
                break;
            case 39:
                model.move("Right");
                break;
            case 40:
                model.move("Down");
                break;
        }

    }
    public void keyReleased(KeyEvent event) {

    }

    public void keyTyped(KeyEvent event) {

    }

    public Model getModel() {
        return model;
    }

}