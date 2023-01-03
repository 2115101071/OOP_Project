import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        move(10);
        bulletHit();
    }
    
    public void bulletHit(){
        if (isTouching(Enemy.class)){
            removeTouching(Enemy.class);
            Boom boom = new Boom();
            getWorld().addObject(boom, getX(), getY());
            getWorld().removeObject(this);
        }else if (getX()==599){
            getWorld().removeObject(this);
        }
    }
}
