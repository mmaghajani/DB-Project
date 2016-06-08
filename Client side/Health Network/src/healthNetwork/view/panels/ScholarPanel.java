package healthNetwork.view.panels;

import healthNetwork.Constants;
import healthNetwork.core.Doctor;
import healthNetwork.core.Scholar;
import healthNetwork.view.customView.MyLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by mma on 6/9/2016.
 */
public class ScholarPanel extends UserPanel {
    public ScholarPanel(){
        super();

        core = new Scholar() ;
    }

    /**
     * Set content based on core object
     */
    protected void setMain() {

    }

    /**
     * Set title and content for drawer based on core object
     */
    protected void setDrawer() {
        MyLabel title = new MyLabel("Records" , MyLabel.CENTER) ;
        title.setFont(new Font(Constants.segoeFont, Font.BOLD, titleFontSize));
        title.setLocation(0, 0);
        title.setSize(widthOfListOfPatient , heightOfListOfPatient / 10);
        title.setForeground(Color.WHITE);
        drawer.add(title) ;
    }

    /**
     * Set title and content for title bar based on core object
     */
    protected void setTitle(){
        MyLabel name = new MyLabel("Hello St." , Constants.darkBlueJPGPath , JLabel.LEFT);
        name.setLocation(titleBarX, titleBarY);
        name.setSize(widthOfTitleBar / 2 , heightOfTitleBar);
        name.setForeground(Color.WHITE);
        name.setBorder(new EmptyBorder(Constants.margin, Constants.margin, Constants.margin, Constants.margin));
        name.setFont(new Font(Constants.segoeFont, Font.BOLD, titleFontSize));
        titleBar.add(name) ;
    }

}
