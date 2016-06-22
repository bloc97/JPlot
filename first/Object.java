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
public class Object{
    private String name;
    private int health;
    private int que;

    public Object() {
    }
    
    public Object(String name) {
        this.name = name;
    }
    
    public Object(String name,int health) {
        this.name = name;
        this.health = health;
    }          

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }  
        
}
