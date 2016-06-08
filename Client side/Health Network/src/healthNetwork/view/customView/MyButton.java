package healthNetwork.view.customView;

import healthNetwork.Constants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 * Created by mma on 6/5/2016.
 */
public class MyButton extends JButton {

    private Image image = null;
    private final int fontSize = 15 ;

    public MyButton(String text, String path) {
        // TODO Auto-generated constructor stub
        super(text);
        initialize(path) ;

    }

    public MyButton(String path) {
        // TODO Auto-generated constructor stub
        super();
        initialize(path);
    }

    public MyButton() {
        // TODO Auto-generated constructor stub
        super();
        initialize();
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

    private void initialize(String path){
        this.image = new ImageIcon(getClass().getResource(path)).getImage();
        this.setFont(new Font(Constants.segoeFont , Font.CENTER_BASELINE , fontSize ) );
        this.setForeground(Constants.gray);
    }

    private void initialize(){
        this.setFont(new Font(Constants.segoeFont , Font.CENTER_BASELINE , fontSize ) );
        this.setForeground(Constants.gray);
    }
}
