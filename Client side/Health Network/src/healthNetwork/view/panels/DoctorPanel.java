package healthNetwork.view.panels;

import healthNetwork.Constants;
import healthNetwork.core.Doctor;
import healthNetwork.handler.GraphicHandler;
import healthNetwork.view.customView.MyButton;
import healthNetwork.view.customView.MyLabel;
import healthNetwork.view.customView.MyPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by mma on 6/8/2016.
 */
public class DoctorPanel extends UserPanel{

    public DoctorPanel(){
        super();

        core = new Doctor() ;
    }

    protected void setMain() {

    }

    protected void setDrawer() {
        MyLabel title = new MyLabel("List of patient" , MyLabel.CENTER) ;
        title.setFont(new Font(Constants.segoeFont, Font.BOLD, titleFontSize));
        title.setLocation(0, 0);
        title.setSize(widthOfListOfPatient , heightOfListOfPatient / 10);
        title.setForeground(Color.WHITE);
        drawer.add(title) ;
    }

    protected void setTitle(){
        MyLabel name = new MyLabel("Hello Dr." , Constants.darkBlueJPGPath , JLabel.LEFT);
        name.setLocation(titleBarX, titleBarY);
        name.setSize(widthOfTitleBar / 2 , heightOfTitleBar);
        name.setForeground(Color.WHITE);
        name.setBorder(new EmptyBorder(Constants.margin, Constants.margin, Constants.margin, Constants.margin));
        name.setFont(new Font(Constants.segoeFont, Font.BOLD, titleFontSize));
        titleBar.add(name) ;
    }

}
