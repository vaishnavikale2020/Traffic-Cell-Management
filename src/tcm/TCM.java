/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author lenovo
 */
public class TCM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         try {
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(TCM.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(TCM.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(TCM.class.getName()).log(Level.SEVERE, null, ex);
         } catch (UnsupportedLookAndFeelException ex) {
             Logger.getLogger(TCM.class.getName()).log(Level.SEVERE, null, ex);
         }
         Splash s=new Splash();
         s.setVisible(true);
         try
            {
                for(int i=0;i<=100;i++)
                {
                    
                Thread.sleep(35);
                s.loadingpercentage.setText(Integer.toString(i)+"%");
                s.progressbar.setValue(i);
                 if(i==10)
                {
               s.red.setForeground(Color.red);
                }
                 if(i==20)
                {
                s.red.setForeground(Color.black);
                }
                if(i==30)
                {
                s.red.setForeground(Color.RED);                
                }
                if(i==40)
                {
                s.red.setForeground(Color.black);               
                }
                if(i==50)
                {
                s.red.setForeground(Color.red);
                }    
                if(i==60)
                {
                s.red.setForeground(Color.black);               
                }
                if(i==70)
                {
                s.red.setForeground(Color.red);               
                }
                if(i==80)
                {
                s.red.setForeground(Color.black);               
                }
                if(i==90)
                {
                s.red.setForeground(Color.red);               
                }
                if(i==100)
                {
                s.red.setForeground(Color.black);               
                
                s.dispose();
                }
                }
                
                
                s.dispose();
            }
         catch(Exception e){
         
         }
         loginForm f=new loginForm();                 
         f.setVisible(true);
     }
    }
    

