///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package first;
//
//import java.util.Random;
//import java.awt.*;
//import javax.swing.*;
//
///**
// *
// * @author Bowen
// */
//public class First {
//
//    /**
//     * @param args the command line arguments
//     */
//    
//    private void displayGUI(int XSIZE, int YSIZE, double amp, double omega, double phi, int SCALE, double PRECISION, int SUM)
//    {
//        JFrame frame = new JFrame("Plotter");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JPanel content = new JPanel();
//        content.setOpaque(true);
//        content.setBackground(Color.WHITE);
//        content.setLayout(null);
//        
//        
//        int XTRANS = XSIZE/2;
//        int YTRANS = YSIZE/2-YSIZE/12;
//        double pi = 3.14159265;
//        
//        
//        drawSin(amp,omega,phi,XTRANS,YTRANS,PRECISION,SCALE,pi,content);
//        
//        drawFourier(amp,omega,phi,SUM,XTRANS,YTRANS,PRECISION,SCALE,pi,content);
//        
//        drawAxes(XTRANS,YTRANS,SCALE,PRECISION,content);
//        
//        drawLabels(XTRANS,YTRANS,PRECISION,SCALE,content);
//        
//
//        frame.setContentPane(content);
//        frame.setSize(XSIZE, YSIZE);
//        frame.setLocationByPlatform(true);
//        frame.setVisible(true);
//        
//    }
//    
//    public static void main(String... args) {
//        
//        int XSIZE=1920;
//        int YSIZE=1080;
//        double amp=1;
//        double omega=1;
//        double phi=0;
//        int SCALE=100;
//        double PRECISION=0.01;
//        int SUM=30;
//        
//        SwingUtilities.invokeLater(new Runnable()
//        {
//            public void run()
//            {
//
//        new First().displayGUI(XSIZE,YSIZE,amp,omega,phi,SCALE,PRECISION,SUM);
//                
//        }
//        });
//        
////        float[] test = {1,2,3,4,5};
////        for (int i = 0; i < test.length; i++) {
////            System.out.println(test[i]);
////        }
////        
////        int[][] matr;
////        matr = new int[4][4];
////        matr[0][0]=2;
////        
////        for (int i=1; i<10; i++){
////        Random rand = new Random();
////        int rnd = rand.nextInt(40);
////                
////        System.out.println(rnd);
////        }
//
//
//        
//        
//        
//        // TODO code application logic here
//        
////        Object cu[]=new Object[10];
////        
////        for (int i = 0; i < 10; i++) {
////            
////            cu[i]=new Object("Beining"+i,i+10);
////            
////        System.out.println("Health of: " + cu[i].getName() + " is");
////        System.out.print(cu[i].getHealth());
////        System.out.println(" What a noob");
////            
////        }
//        
//        
//        }
//
//
//    public static double fSin(double i, double a, double pi){
//        double x=i%pi;
//        double y=0;
//        if (i>=0){
//        y=(16*x*(pi-x))/(5*pi*pi-4*x*(pi-x));
//        }
//        if (i<0){
//        x=x-180;
//        y=-(16*x*(pi-x))/(5*pi*pi-4*x*(pi-x));
//        }
//        return y*a;
//    }
//    
//    public static double fCos(double i, double a, double pi){
//        double x = i+pi/2;
//        double y = fSin(x,a,pi);
//        return y;
//    }
//    
//    public static double fFourier(double x, double h, int max, double pi){
//        double a0=h/2;
//        double sum=a0;
//        double bn;
//        for (int i=1; i<=max; i=i+2){
//            bn = (2*h)/(i*pi);
//            sum = sum + bn*Math.sin(x*i);
//        }
//        return sum;
//    }
//        
//    public static void drawSin(double a, double z, double c,int XTRANS, int YTRANS, double STEP, int SCALE, double pi, JPanel content){
//
//        double max = pi/STEP;
//        int maxi = (int)max;
//        int sinp = maxi*2+1;
//        
//        JLabel label[] = new JLabel[sinp];
//        
//        double x;
//        double y;
//
//        int k;
//        int v;
//        
//        for (int i=0; i<(max); i++){
//            x = i*STEP;
//            y=fSin(x*z+c,a,pi);
////            System.out.print(x);
////            System.out.println(" | "+y);
//            k=(int)(x*SCALE);
//            v=(int)(y*SCALE);
//            
//            label[i] = new JLabel(".", JLabel.LEFT);
//            label[i].setSize(30,30);
//            label[i].setLocation(k+XTRANS,-v+YTRANS);
//            content.add(label[i]);
//            
//            label[i+maxi] = new JLabel(".", JLabel.LEFT);
//            label[i+maxi].setSize(30,30);
//            label[i+maxi].setLocation(-k+XTRANS,v+YTRANS);
//            content.add(label[i+maxi]);
//            
//        }
//    }
//    
//    public static void drawAxes(int XTRANS, int YTRANS,int SCALE, double STEP, JPanel content){
//        int labheight=10*SCALE;
//        
//        int labp = labheight*2;
//        
//        JLabel axes[] = new JLabel[labp];
//        
//        int k;
//        for (k=0; k<(labheight); k++){
//            
//            axes[k] = new JLabel(".", JLabel.LEFT);
//            axes[k].setSize(30,30);
//            axes[k].setLocation(k+XTRANS-labheight/2,YTRANS);
//            content.add(axes[k]);
//            
//            axes[k+labheight] = new JLabel(".", JLabel.LEFT);
//            axes[k+labheight].setSize(30,30);
//            axes[k+labheight].setLocation(XTRANS,k+YTRANS-labheight/2);
//            content.add(axes[k+labheight]);
//            
//        }
//    }
//    
//    public static void drawLabels(int XTRANS, int YTRANS, double STEP, int SCALE, JPanel content){
//        int labelheight=20;
//        
//        int labelp = labelheight*3;
//        
//        JLabel label[] = new JLabel[labelp];
//        
//        int k;
//        for (k=0; k<(labelheight); k++){
//            
//            label[k] = new JLabel(".", JLabel.LEFT);
//            label[k].setSize(30,30);
//            label[k].setForeground(Color.GREEN);
//            label[k].setLocation(XTRANS+SCALE,k+YTRANS-labelheight/2);
//            content.add(label[k]);
//            
//            label[k+labelheight] = new JLabel(".", JLabel.LEFT);
//            label[k+labelheight].setSize(30,30);
//            label[k+labelheight].setForeground(Color.GREEN);
//            label[k+labelheight].setLocation((int)(XTRANS+3.14*SCALE),k+YTRANS-labelheight/2);
//            content.add(label[k+labelheight]);
//            
//            label[k+labelheight*2] = new JLabel(".", JLabel.LEFT);
//            label[k+labelheight*2].setSize(30,30);
//            label[k+labelheight*2].setForeground(Color.GREEN);
//            label[k+labelheight*2].setLocation(k+XTRANS-labelheight/2,YTRANS-SCALE);
//            content.add(label[k+labelheight*2]);
//            
//        }
//        
//        JLabel scale1;
//        scale1 = new JLabel("1", JLabel.LEFT);
//        scale1.setSize(30,30);
//        scale1.setLocation(XTRANS+SCALE-2,k+YTRANS+labelheight/4);
//        content.add(scale1);
//        
//        JLabel scalepi;
//        scalepi = new JLabel("π", JLabel.LEFT);
//        scalepi.setSize(30,30);
//        scalepi.setLocation((int)(XTRANS+3.14*SCALE)-2,k+YTRANS+labelheight/4-1);
//        content.add(scalepi);
//    }
//    
//    public static void drawFourier(double a, double z, double c, int SUM, int XTRANS, int YTRANS, double STEP, int SCALE, double pi, JPanel content){
//
//        double max = pi/STEP;
//        int maxi = (int)max;
//        int sinp = maxi*2+1;
//        
//        JLabel label[] = new JLabel[sinp];
//        
//        double x;
//        double y;
//
//        int k;
//        int v;
//        
//        for (int i=0; i<(max); i++){
//            x = i*STEP;
//            y=fFourier(x*z+c,a,SUM,pi);
////            System.out.print(x);
////            System.out.println(" | "+y);
//            k=(int)(x*SCALE);
//            v=(int)(y*SCALE);
//            
//            label[i] = new JLabel(".", JLabel.LEFT);
//            label[i].setSize(30,30);
//            label[i].setLocation(k+XTRANS,-v+YTRANS);
//            content.add(label[i]);
//            
//            label[i+maxi] = new JLabel(".", JLabel.LEFT);
//            label[i+maxi].setSize(30,30);
//            label[i+maxi].setLocation(-k+XTRANS,v+YTRANS);
//            content.add(label[i+maxi]);
//            
//        }
//        
//    }
//    
//}
//







//        float[] test = {1,2,3,4,5};
//        for (int i = 0; i < test.length; i++) {
//            System.out.println(test[i]);
//        }
//        
//        int[][] matr;
//        matr = new int[4][4];
//        matr[0][0]=2;
//        
//        for (int i=1; i<10; i++){
//        Random rand = new Random();
//        int rnd = rand.nextInt(40);
//                
//        System.out.println(rnd);
//        }


        
        
        
        // TODO code application logic here
        
//        Object cu[]=new Object[10];
//        
//        for (int i = 0; i < 10; i++) {
//            
//            cu[i]=new Object("Beining"+i,i+10);
//            
//        System.out.println("Health of: " + cu[i].getName() + " is");
//        System.out.print(cu[i].getHealth());
//        System.out.println(" What a noob");
//            
//        }
        