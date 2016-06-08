package healthNetwork.view.customView;

import com.sun.deploy.panel.JSmartTextArea;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * The class is a text field that has auto set text for field name
 * Created by mma on 6/8/2016.
 */
public class MyTextField extends JTextField{

    private String text = "" ;
    private boolean flag = true ;

    public MyTextField(){
        super() ;
    }

    public MyTextField( String name ){
        super() ;
        text = name ;

        this.setFont(new Font("Arial" , Font.CENTER_BASELINE , 12 ) );

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                if( flag == true ) {
                    MyTextField.this.setForeground(Color.LIGHT_GRAY);
                    MyTextField.this.setText(text);
                }

            }
        }) ;
        thread.start();


        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if( flag == true ){
                    MyTextField.this.setCaretPosition(0);
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
                        MyTextField.this.setForeground(Color.BLACK);
                        MyTextField.this.setText("");
                        flag = false;
                    }
                }else{
                    if( MyTextField.this.getText().equals("")) {
                        MyTextField.this.setForeground(Color.LIGHT_GRAY);
                        MyTextField.this.setText(text);
                        MyTextField.this.setCaretPosition(0);
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
