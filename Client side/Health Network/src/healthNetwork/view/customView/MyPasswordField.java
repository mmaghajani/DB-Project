package healthNetwork.view.customView;

import com.sun.deploy.panel.JSmartTextArea;
import javax.swing.*;

import java.awt.event.*;

/**
 * The class is a text field that has auto set text for field name
 * Created by mma on 6/8/2016.
 */
public class MyPasswordField extends JPasswordField{

    private String text = "" ;
    private boolean flag = true ;

    public MyPasswordField(){
        super() ;
    }

    public MyPasswordField( String name ){
        super() ;
        text = name ;

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                if( flag == true ) {
                    char c = 0 ;
                    MyPasswordField.this.setEchoChar(c);
                    MyPasswordField.this.setText(text);
                }

            }
        }) ;
        thread.start();
        System.out.println( this.getEchoChar() ) ;
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if( flag == true ){
                    MyPasswordField.this.setCaretPosition(0);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if( flag == true ) {
                    if( e.getKeyChar() != '\b') {
                        MyPasswordField.this.setEchoChar('•');
                        MyPasswordField.this.setText("");
                        flag = false;
                    }
                }else{
                    if( MyPasswordField.this.getText().equals("")) {
                        char c = 0 ;
                        MyPasswordField.this.setEchoChar(c);
                        MyPasswordField.this.setText(text);
                        MyPasswordField.this.setCaretPosition(0);
                        flag = true;
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}
