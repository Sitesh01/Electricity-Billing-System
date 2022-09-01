package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    
    Thread t;
    
    public Splash(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/elect.jpg"));
        Image i2 = i1.getImage().getScaledInstance(730,475,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        setVisible(true);
        int x = 1;
        for(int j=2;j<500;j+=4,x+=1){
            setSize(j+x,j);
            setLocation(700-(j+x)/2,350-j/2);
            
            try{
                Thread.sleep(7);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        
        t = new Thread(this);
        t.start();
        setVisible(true);
    }
    
    public void run(){
        try {
            Thread.sleep(5000);
            setVisible(false);
      
            new Login();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        Splash s = new Splash();
    }
}
