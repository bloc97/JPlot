/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jplot;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Bowen
 */
public class Draw {
    
    
        public static void drawAxes(int XTRANS, int YTRANS,int SCALE, double STEP, JPanel content){
        int labheight=10*SCALE;
        
        //JLabel axes[] = new JLabel[labheight];
        JLabel axes;
        
        int k;
        for (k=0; k<(labheight); k++){
            
            axes = new JLabel(".", JLabel.LEFT);
            axes.setSize(30,30);
            axes.setLocation(k+XTRANS-labheight/2,YTRANS);
            content.add(axes);
            
            axes = new JLabel(".", JLabel.LEFT);
            axes.setSize(30,30);
            axes.setLocation(XTRANS,k+YTRANS-labheight/2);
            content.add(axes);

        }
        
        int v;
        for (k=0; k<(50/4); k++){   
            
            for (v=-1; v<=1; v=v+2){
                
            axes = new JLabel(".", JLabel.LEFT);
            axes.setSize(30,30);
            axes.setLocation(v*k+XTRANS,k+YTRANS-labheight/2);
            content.add(axes);

            axes = new JLabel(".", JLabel.LEFT);
            axes.setSize(30,30);
            axes.setLocation(-k+XTRANS+labheight/2,v*k+YTRANS);
            content.add(axes);

            }
        }
        
        
    }
    
    public static void drawLabels(int XTRANS, int YTRANS, double STEP, int SCALE, JPanel content){
        int labelheight=20;
        
        int labelp = labelheight*3;
        
        JLabel label[] = new JLabel[labelp];
        
        int k;
        for (k=0; k<(labelheight); k++){
            
            label[k] = new JLabel(".", JLabel.LEFT);
            label[k].setSize(30,30);
            label[k].setForeground(Color.GREEN);
            label[k].setLocation(XTRANS+SCALE,k+YTRANS-labelheight/2);
            content.add(label[k]);
            
            label[k+labelheight] = new JLabel(".", JLabel.LEFT);
            label[k+labelheight].setSize(30,30);
            label[k+labelheight].setForeground(Color.GREEN);
            label[k+labelheight].setLocation((int)(XTRANS+3.14*SCALE),k+YTRANS-labelheight/2);
            content.add(label[k+labelheight]);
            
            label[k+labelheight*2] = new JLabel(".", JLabel.LEFT);
            label[k+labelheight*2].setSize(30,30);
            label[k+labelheight*2].setForeground(Color.GREEN);
            label[k+labelheight*2].setLocation(k+XTRANS-labelheight/2,YTRANS-SCALE);
            content.add(label[k+labelheight*2]);
            
        }
        
        JLabel scale1;
        scale1 = new JLabel("1", JLabel.LEFT);
        scale1.setSize(30,30);
        scale1.setLocation(XTRANS+SCALE-2,k+YTRANS+labelheight/4);
        content.add(scale1);
        
        JLabel scalepi;
        scalepi = new JLabel("π", JLabel.LEFT);
        scalepi.setSize(30,30);
        scalepi.setLocation((int)(XTRANS+3.14*SCALE)-2,k+YTRANS+labelheight/4-1);
        content.add(scalepi);
    }
    
    public static void drawSin(double a, double z, double c,int XTRANS, int YTRANS, double STEP, int SCALE, JPanel content){

        double max = 2*Fmath.PI/STEP;
        int maxi = (int)max+1;
        
        JLabel label[] = new JLabel[maxi];
        
        double x;
        double y;

        int k;
        int v;
        
        for (int i=0; i<(max); i++){
            x = (i-max/2)*STEP;
            y=a*Fmath.sin(x*z+c);
//            System.out.print(x);
//            System.out.println(" | "+y);
            k=(int)(x*SCALE);
            v=(int)(y*SCALE);
            
            label[i] = new JLabel(".", JLabel.LEFT);
            label[i].setSize(30,30);
            label[i].setLocation(k+XTRANS,-v+YTRANS);
            content.add(label[i]);
            
            
        }
    }
    
    public static void drawFourier(double a, double z, double c, int SUM, int XTRANS, int YTRANS, double STEP, int SCALE, JPanel content){

        double max = Fmath.PI/STEP;
        int maxi = (int)max;
        int sinp = maxi*2+1;
        
        JLabel label[] = new JLabel[sinp];
        
        double x;
        double y;

        int k;
        int v;
        
        for (int i=0; i<(max); i++){
            x = i*STEP;
            y=Fmath.fourier(x*z+c,a,SUM);
//            System.out.print(x);
//            System.out.println(" | "+y);
            k=(int)(x*SCALE);
            v=(int)(y*SCALE);
            
            label[i] = new JLabel(".", JLabel.LEFT);
            label[i].setSize(30,30);
            label[i].setLocation(k+XTRANS,-v+YTRANS);
            content.add(label[i]);
            
            label[i+maxi] = new JLabel(".", JLabel.LEFT);
            label[i+maxi].setSize(30,30);
            label[i+maxi].setLocation(-k+XTRANS,v+YTRANS);
            content.add(label[i+maxi]);
            
        }
        
    }
    
}
