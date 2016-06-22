/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first;

import java.util.Random;
import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author Bowen
 */
public class First {

    /**
     * @param args the command line arguments
     */
    
    private static JFrame initGUI(){
        JFrame frame = new JFrame("Plotter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }
    
    private static JPanel initPanel(){
        JPanel content = new JPanel();
        content.setOpaque(true);
        content.setBackground(Color.WHITE);
        content.setLayout(null);
        return content;
    }
    
    private static void sendGUI(int XSIZE, int YSIZE, double amp, double omega, double phi, int SCALE, double PRECISION, int SUM, int CHOICE, JPanel content){
        
        int XTRANS = XSIZE/2;
        int YTRANS = YSIZE/2-YSIZE/12;
        //double pi = Math.PI;
        switch (CHOICE){
            default:
                Draw.drawSin(amp,omega,phi,XTRANS,YTRANS,PRECISION,SCALE,content);
        break;
            case 2:
                Draw.drawFourier(amp,omega,phi,SUM,XTRANS,YTRANS,PRECISION,SCALE,content);
        break;
            case 3:
                Draw.drawSin(amp,omega,phi,XTRANS,YTRANS,PRECISION,SCALE,content);
                Draw.drawFourier(amp,omega,phi,SUM,XTRANS,YTRANS,PRECISION,SCALE,content);
        break;
        }
        Draw.drawAxes(XTRANS,YTRANS,SCALE,PRECISION,content);
        
        Draw.drawLabels(XTRANS,YTRANS,PRECISION,SCALE,content);
    }
        
    private static void displayGUI(JFrame frame, JPanel content, int XSIZE, int YSIZE){
        frame.setContentPane(content);
        frame.setSize(XSIZE, YSIZE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        
    }
    
    public static void main(String... args) {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 0 for automatic values, 1 to change function, 2 for manual settings: "); int MANUAL = input.nextInt(); System.out.print("");
        
        int XSIZE,YSIZE,SCALE,SUM,CHOICE;
        double amp,omega,phi,PRECISION;
        
        
        switch (MANUAL){
            case 2:
        System.out.print("Enter Horizontal Screen Size (Int): "); XSIZE = input.nextInt(); System.out.print("");
        System.out.print("Enter Vertical Screen Size (Int): "); YSIZE = input.nextInt(); System.out.print("");
        System.out.print("Enter Scale (Int): "); SCALE = input.nextInt(); System.out.println("");
        System.out.print("Enter Amplitude: "); amp = input.nextDouble(); System.out.print("");
        System.out.print("Enter Angular Frequency: "); omega = input.nextDouble(); System.out.print("");
        System.out.print("Enter Phase Constant: "); phi = input.nextDouble(); System.out.print("");
        System.out.print("Enter Step Function Precision: "); double iPRECISION = input.nextDouble(); System.out.print("");
        if (iPRECISION<0.001){PRECISION=0.001;}
        else{PRECISION=iPRECISION;}
        System.out.print("Enter 1 for Sine Wave, 2 for Square Fourier Transform, 3 for both: "); CHOICE = input.nextInt(); System.out.print("");
        if (CHOICE==2 || CHOICE==3){
                System.out.print("Enter Sum Constant (Int): "); SUM = input.nextInt(); System.out.print("");
            }
        else{
            SUM = 20;
        }
        break;
            case 1:
        XSIZE=800;YSIZE=600;SCALE=50;SUM=20;PRECISION=0.02;
        System.out.print("Enter Amplitude: "); amp = input.nextDouble(); System.out.print("");
        System.out.print("Enter Angular Frequency: "); omega = input.nextDouble(); System.out.print("");
        System.out.print("Enter Phase Constant: "); phi = input.nextDouble(); System.out.print("");
        System.out.print("Enter 1 for Sine Wave, 2 for Square Fourier Transform, 3 for both: "); CHOICE = input.nextInt(); System.out.print("");
        break;
            default:
        XSIZE=800;YSIZE=600;SCALE=50;SUM=20;CHOICE=3;amp=1;omega=1;phi=0;PRECISION=0.02;
        break;
        }

        
//        SwingUtilities.invokeLater(new Runnable(){
//            public void run()
//            {
        
            JFrame frame = new First().initGUI();      
            JPanel content = new First().initPanel();
            First.sendGUI(XSIZE,YSIZE,amp,omega, phi,SCALE,PRECISION,SUM,CHOICE,content);
            First.displayGUI(frame,content,XSIZE,YSIZE);
        
                
//        }
//    });
        
        }

    
}

