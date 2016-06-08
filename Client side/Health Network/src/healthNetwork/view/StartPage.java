package healthNetwork.view;

import healthNetwork.Constants;
import healthNetwork.view.customView.MyButton;
import healthNetwork.handler.GraphicHandler;
import healthNetwork.view.customView.MyLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class shows start page for signing in or up! For this class supposed a imaginary layout rather than
 * a layout manager for working easier with this.Magnitude of this imaginary layouts is records as final integer
 * Created by mma on 6/8/2016.
 */
public class StartPage extends JFrame {

    private int width = GraphicHandler.getInstance().getWidthScreen() / 4 ;
    private int height = GraphicHandler.getInstance().getHeightScreen() / 3 ;
    private MyLabel title ;
    private JTextField id ;
    private JPasswordField passwordField ;
    private JButton signIn ;
    private JButton signUp ;
    private JToolBar toolBar ;

    /**
     * Magnitude of imaginary layouts
     */
    private final int heightOfTitleBar = height / 7 ;
    private final int widthOfTitleBar = width ;
    private final int titleBarX = 0 ;
    private final int titleBarY = 0 ;
    private final int titleFontSize = 40 ;
    private final int mainPanelX = 0 ;
    private final int mainPanelY = heightOfTitleBar ;
    private final int heightOfMainPanel = height * 5 / 7 ;
    private final int widthOfMainPanel = width ;
    private final int toolBarX = 0 ;
    private final int toolBarY = heightOfTitleBar + heightOfMainPanel ;
    private final int heightOfToolBar = height - ( heightOfMainPanel + heightOfTitleBar ) ;
    private final int widthOfToolBar = width ;

    public StartPage(){
        super();

        initialize();

        setTitle();

     //   setDecodeButton();

     //   setEncodeButton();

        setToolBar() ;

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
                    .setLookAndFeel(Constants.aluminumLookAndFeel);
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

    private void setTitle() {
        title = new MyLabel(Constants.appName, JLabel.CENTER);
        Color c = new Color(50 , 100 , 0 , 0 ) ;
        title.setBackground(c);
        title.setLocation(titleBarX, titleBarY);
        title.setSize(widthOfTitleBar, heightOfTitleBar);
        title.setForeground(Color.WHITE);
        title.setFont(new Font(Constants.fantasticFont, Font.BOLD, titleFontSize));
    }

    private void setToolBar() {
        JButton exit = new MyButton(Constants.exitJPGPath, 1);
        exit.setLocation(0, 0);
        exit.setSize(Constants.sizeOfExitButton, Constants.sizeOfExitButton);
        exit.setIcon(new ImageIcon(getClass().getResource(Constants.exitPNGPath)) );
        exit.setBorder(BorderFactory.createEmptyBorder());
        //exit.setBackground(Color.decode("#01aaeb"));
        exit.setToolTipText("Exit");
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                dispose();
            }
        });

        toolBar = new JToolBar();
        toolBar.setLocation(toolBarX,toolBarY);
        toolBar.setSize(widthOfToolBar, heightOfToolBar);
        toolBar.setBorder(BorderFactory.createEmptyBorder());
        toolBar.add(exit);
    }

    private void AddComponentsToFrame() {
        getContentPane().add(title);
        getContentPane().add(toolBar);
//        getContentPane().add(encode);
//        getContentPane().add(exitBar);

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

        title.repaint();
    }
}
