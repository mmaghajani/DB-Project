package healthNetwork.view.customView;

import healthNetwork.Constants;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Created by mma on 6/5/2016.
 */
public class MyButton extends JButton {

    private Image image = null;

    public MyButton(String text, String path) {
        // TODO Auto-generated constructor stub
        super(text);
        this.image = new ImageIcon(getClass().getResource(path)).getImage();
    }

    public MyButton(String path) {
        // TODO Auto-generated constructor stub
        super();
        this.image = new ImageIcon(getClass().getResource(path)).getImage();
    }

    public MyButton() {
        // TODO Auto-generated constructor stub
        super();
    }

    /**
     * Paint button with its image if image not null
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        if (image != null)
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
        super.paint(g);
    }
}
