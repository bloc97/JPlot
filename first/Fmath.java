/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first;

/**
 *
 * @author Bowen
 */
public class Fmath {
    
    static double PI = 3.14159265;
    
    
    public static double sin(double i){
        double x=i%(2*PI);
        double y;
        
        int v=1; int w=1;
        if (x>PI) {x=x-PI;w=-1;}
        if (x<-PI) {x=x+2*PI;}
        if (x<0 && x>=-PI) {x=x+PI;v=-1;}
        y=v*w*(16*x*(PI-x))/(5*PI*PI-4*x*(PI-x));

        return y;
    }
    
    public static double cos(double i){
        double x = i+PI/2;
        double y = sin(x);
        return y;
    }
    
    public static double fourier(double x, double h, int max){
       // double a0=h/2;
        double a0=0;
        double sum=a0;
        double bn;
        for (int i=1; i<=max; i=i+2){
            bn = (2*h)/(i*PI);
            sum = sum + bn*Math.sin(x*i);
        }
        return sum*2;
    }
    
    
    
}
