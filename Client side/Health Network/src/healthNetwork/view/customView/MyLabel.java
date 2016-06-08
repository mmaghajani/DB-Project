package healthNetwork.view.customView;

import healthNetwork.Constants;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Created by mma on 6/5/2016.
 */
public class MyLabel extends JLabel {

    private Image image = null;

    public MyLabel(String text, ImageIcon image, int x) {
        super(text, image, x);// TODO Auto-generated constructor stub
        this.image = image.getImage() ;
    }

    public MyLabel(String s, int x) {
        // TODO Auto-generated constructor stub
        super(s, x);
    }

    public MyLabel(String text, String path, int x) {
        super(text, x);
        image = new ImageIcon(getClass().getResource(path)).getImage();
    }

    /**
     * Paint label with its image if image not null
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        if (image != null)
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
        super.paint(g);
    }
}

