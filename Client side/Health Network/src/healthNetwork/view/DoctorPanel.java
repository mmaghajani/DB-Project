package healthNetwork.view;

import healthNetwork.Constants;
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
public class DoctorPanel extends JFrame{
    private int width = GraphicHandler.getInstance().getWidthScreen() / 2 ;
    private int height = GraphicHandler.getInstance().getHeightScreen() * 2 / 3 ;

    private MyPanel titleBar ;
    private MyPanel listOfPatient ;
    private MyPanel main ;

    /**
     * Magnitude of imaginary layouts
     */
    private final int heightOfTitleBar = height / 7 ;
    private final int widthOfTitleBar = width ;
    private final int titleBarX = 0 ;
    private final int titleBarY = 0 ;
    private final int titleFontSize = 20 ;
    private final int heightOfListOfPatient = height - heightOfTitleBar ;
    private final int widthOfListOfPatient = width / 4 ;
    private final int listOfPatientX = width - widthOfListOfPatient ;
    private final int listOfPatientY = heightOfTitleBar ;
    private final int widthOfMain = width ;
    private final int heightOfMain = heightOfListOfPatient ;
    private final int mainX = 0 ;
    private final int mainY = listOfPatientY ;

    public DoctorPanel(){
        super();

        initialize();

        setContent() ;

        AddComponentsToFrame() ;

        setVisible(true);
    }

    private void initialize(){
        GraphicHandler graphicHandler = GraphicHandler.getInstance() ;

        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        graphicHandler.placeInCenter(this);
        this.setResizable(false);
        this.setLayout(null);
        this.setUndecorated(true);

        try {
            UIManager
                    .setLookAndFeel(Constants.nimbusLookAndFeel);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void setContent(){
        setTitle() ;

        setListOfPatient() ;

        setMain() ;
    }

    private void setMain() {
        main = new MyPanel(Constants.blueBackJPGPath) ;
        main.setSize(widthOfMain , heightOfMain);
        main.setLocation(mainX , mainY);
    }

    private void setListOfPatient() {
        listOfPatient = new MyPanel(Constants.darkBlueJPGPath) ;
        listOfPatient.setSize(widthOfListOfPatient , heightOfListOfPatient);
        listOfPatient.setLocation(listOfPatientX , listOfPatientY + 10 );

        MyLabel title = new MyLabel("List of patient" , MyLabel.CENTER) ;
        title.setFont(new Font(Constants.segoeFont, Font.BOLD, titleFontSize));
        title.setLocation(0, 0);
        title.setSize(widthOfListOfPatient , heightOfListOfPatient / 10);
        title.setForeground(Color.WHITE);
        listOfPatient.add(title) ;
    }

    private void AddComponentsToFrame() {
        getContentPane().add(titleBar);
        getContentPane().add(listOfPatient) ;
        getContentPane().add(main) ;
//        getContentPane().add(toolBar) ;
//        getContentPane().add(toolBar);
//        getContentPane().add(id) ;
//        getContentPane().add(passwordField) ;
//        getContentPane().add(signIn) ;
//        getContentPane().add(signUp) ;
    }

    private void setTitle(){
        titleBar = new MyPanel(Constants.darkBlueJPGPath) ;
        titleBar.setSize(width , heightOfTitleBar);
        titleBar.setLocation(titleBarX , titleBarY);

        MyLabel name = new MyLabel("Hello Dr." , Constants.darkBlueJPGPath , JLabel.LEFT);
        name.setLocation(titleBarX, titleBarY);
        name.setSize(widthOfTitleBar / 2 , heightOfTitleBar);
        name.setForeground(Color.WHITE);
        name.setBorder(new EmptyBorder(Constants.margin, Constants.margin, Constants.margin, Constants.margin));
        name.setFont(new Font(Constants.segoeFont, Font.BOLD, titleFontSize));

        JToolBar toolBar = new JToolBar();
        toolBar.setSize(Constants.sizeOfSignOutButton , Constants.sizeOfSignOutButton);
        toolBar.setLocation(titleBar.getWidth() - Constants.sizeOfSignOutButton , heightOfTitleBar/2 - toolBar.getHeight()/2);
        toolBar.setForeground(Color.WHITE);
        toolBar.setBorder(BorderFactory.createEmptyBorder());
        toolBar.setFloatable(false);

        MyButton signOut = new MyButton(Constants.darkBlueJPGPath) ;
        signOut.setSize(Constants.sizeOfSignOutButton , Constants.sizeOfSignOutButton);
        signOut.setLocation(0 , 0);
        signOut.setIcon(new ImageIcon(getClass().getResource(Constants.signOutPNGPath)) );
        signOut.setToolTipText("Sign out");
        signOut.setBorder(BorderFactory.createEmptyBorder());


        toolBar.add(signOut) ;
        titleBar.add(name) ;
        titleBar.add(toolBar) ;
    }

    /**
     * This method draws a blue image background of this frame
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Image image = new ImageIcon(getClass().getResource(Constants.blueBackJPGPath)).getImage();
        g.drawImage(image, 0, 0, width, height, null);

        listOfPatient.repaint();
        titleBar.repaint();
        main.repaint();

//        toolBar.getComponent(0).repaint();
//        signIn.repaint();
//        signUp.repaint();
    }

}
