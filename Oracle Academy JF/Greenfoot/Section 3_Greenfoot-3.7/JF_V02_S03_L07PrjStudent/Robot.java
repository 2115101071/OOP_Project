import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Robot here.
 * 
 * @author (Kadek Yuda Mahendra) 
 * @version (a version number or a date)
 */
public class Robot extends Actor
{
    /**
     * Act - do whatever the Robot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        RobotMovement();
        detectWallCollision();
        detectBlockCollision();
        detectHome();
        eatPizza();
    }
    
    public void RobotMovement(){
        //Kode untuk robot bergerak
        if (Greenfoot.isKeyDown("W")){
            setLocation(getX(),getY()-2);
        }
        if (Greenfoot.isKeyDown("S")){
            setLocation(getX(),getY()+2);
        }
        if (Greenfoot.isKeyDown("D")){
            setLocation(getX()+2,getY());
        }
        if (Greenfoot.isKeyDown("A")){
            setLocation(getX()-2,getY());
        }
    }
    
    public void detectWallCollision(){
        //kode untuk mendeteksi robot jika terkena wall maka lokasi akan di set ulang
        if (isTouching(Wall.class)){
            Greenfoot.playSound("hurt.wav");
            setLocation(0,getY());
        }
    }
    
    public void detectBlockCollision(){
        //kode untuk mendeteksi robot jika terkena block maka lokasi akan diset ulang
        if (isTouching(Block.class)){
            Greenfoot.playSound("hurt.wav");
            setLocation(0,getY());
        }
    }
    
    public void detectHome(){
        if (isTouching(Home.class)){
            Greenfoot.playSound("yipee.wav");
            setLocation(48,50);
        }
    }
    
    public void eatPizza(){
        if (isTouching(Pizza.class)){
            Greenfoot.playSound("eat.wav");
        }
    }
}
