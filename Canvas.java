import javax.swing.JPanel;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Font;

public class Canvas extends JPanel {

    private Model model;
    Color box;
    private Image imageGamer;
    private Image imageWall;
    private Image imageBox;
    private Image imageGoal;


    public Canvas(Model model) {
        this.model = model;
        setBackground(Color.black);
        box = new Color(165, 42, 42);
        File fileNameGamer = new File("images/gamer.png");
        File fileNameGoal = new File("images/goal.png");
        File fileNameWall = new File("images/wall.png");
        File fileNameBox = new File("images/box.png");
        try {
            imageGamer = ImageIO.read(fileNameGamer);
            imageWall = ImageIO.read(fileNameWall);
            imageBox = ImageIO.read(fileNameBox);
            imageGoal = ImageIO.read(fileNameGoal);


        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (model.getInit()) {
            drawDesktop(g);

        }else{
            g.setColor(Color.red);
            g.setFont(new Font("Impact",Font.BOLD,50));
            g.drawString("Error!",200,300);
        }
    }

    private void drawDesktop(Graphics g) {
        int x = 50;
        int y = 50;
        int width = 50;
        int height = 50;
        int offset = 5;
        for (int i = 0; i < model.desktop.length; i++) {
            for (int j = 0; j < model.desktop[i].length; j++) {
                if (model.desktop[i][j] == 1) {
                    g.setColor(Color.yellow);
                    g.fillRect(x, y, width, height);
                    //    g.setColor(box);
                    //       g.fillRect(x,y,width,height);
                    g.drawImage(imageGamer, x, y, 50, 50, null);

                } else if (model.desktop[i][j] == 2) {
                    g.setColor(Color.yellow);
                    g.fillRect(x, y, width, height);
                    //    g.setColor(box);
                    //       g.fillRect(x,y,width,height);
                    g.drawImage(imageWall, x, y, 50, 50, null);

                } else if (model.desktop[i][j] == 3) {
                    g.setColor(Color.yellow);
                    g.fillRect(x, y, width, height);
                    g.drawImage(imageBox, x, y, 50, 50, null);

                } else if (model.desktop[i][j] == 4) {
                    g.setColor(Color.yellow);
                    g.fillRect(x, y, width, height);
                    //    g.setColor(box);
                    //       g.fillRect(x,y,width,height);
                    g.drawImage(imageGoal, x, y, 50, 50, null);

                } else {
                    g.setColor(Color.yellow);
                    g.drawRect(x, y, width, height);
                }

                x = x + width + offset;
            }

            x = 50;
            y = y + height + offset;


        }
    }
}