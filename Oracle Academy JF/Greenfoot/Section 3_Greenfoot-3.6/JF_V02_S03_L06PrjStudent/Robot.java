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
    }
    
    public void RobotMovement(){
        //Kode untuk robot bergerak
    }
    
    public void detectWallCollision(){
        //kode untuk mendeteksi robot jika terkena wall maka lokasi akan di set ulang
        if (isTouching(Wall.class)){
            setLocation(0,getY());
        }
    }
    
    public void detectBlockCollision(){
        //kode untuk mendeteksi robot jika terkena block maka lokasi akan diset ulang
        if (isTouching(Block.class)){
            setLocation(0,getY());
        }
    }
}
