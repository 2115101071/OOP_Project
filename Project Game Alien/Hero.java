import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Actor
{
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
       // move(3);
       // if (isAtEdge())
       //     setLocation(0, getY());
       
        if (Greenfoot.isKeyDown("W"))
            setLocation(getX(),getY()-4);
            
        if (Greenfoot.isKeyDown("A"))
            setLocation(getX()-4,getY());
            
        if (Greenfoot.isKeyDown("S"))
            setLocation(getX(),getY()+4);
            
        if (Greenfoot.isKeyDown("D"))
            setLocation(getX()+4,getY());
        
    }
    
    int laserTimer = 0;
    public void shootLaser(){
        if (laserTimer == 30){
            addObject(new Laser), getX(), getY());
            laserTimer = 
        }
    }
}
