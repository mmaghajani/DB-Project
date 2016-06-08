package healthNetwork.view.panels;

import healthNetwork.Constants;
import healthNetwork.core.User;
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
public abstract  class UserPanel extends JFrame{
    protected int width = GraphicHandler.getInstance().getWidthScreen() / 2 ;
    protected int height = GraphicHandler.getInstance().getHeightScreen() * 2 / 3 ;

    protected MyPanel titleBar ;
    protected MyPanel drawer ;
    protected MyPanel main ;

    protected User core ;
    /**
     * Magnitude of imaginary layouts
     */
    protected final int heightOfTitleBar = height / 7 ;
    protected final int widthOfTitleBar = width ;
    protected final int titleBarX = 0 ;
    protected final int titleBarY = 0 ;
    protected final int titleFontSize = 20 ;
    protected final int heightOfListOfPatient = height - heightOfTitleBar ;
    protected final int widthOfListOfPatient = width / 4 ;
    protected final int listOfPatientX = width - widthOfListOfPatient ;
    protected final int listOfPatientY = heightOfTitleBar ;
    protected final int widthOfMain = width ;
    protected final int heightOfMain = heightOfListOfPatient ;
    protected final int mainX = 0 ;
    protected final int mainY = listOfPatientY ;

    public UserPanel(){
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

    //set layouts
    private void setContent(){
        main = new MyPanel(Constants.blueBackJPGPath) ;
        main.setSize(widthOfMain , heightOfMain);
        main.setLocation(mainX , mainY);

        drawer = new MyPanel(Constants.darkBlueJPGPath) ;
        drawer.setSize(widthOfListOfPatient , heightOfListOfPatient);
        drawer.setLocation(listOfPatientX , listOfPatientY + 10 );

        titleBar = new MyPanel(Constants.darkBlueJPGPath) ;
        titleBar.setSize(width , heightOfTitleBar);
        titleBar.setLocation(titleBarX , titleBarY);

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
        titleBar.add(toolBar) ;

        setTitle() ;

        setDrawer() ;

        setMain() ;
    }

    protected abstract void setMain() ;

    protected abstract void setDrawer() ;

    protected abstract  void setTitle() ;

    private void AddComponentsToFrame() {
        getContentPane().add(titleBar);
        getContentPane().add(drawer) ;
        getContentPane().add(main) ;
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

        drawer.repaint();
        titleBar.repaint();
        main.repaint();

    }

}
