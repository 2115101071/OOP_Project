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
    public void act(){
        heromove();
        resetposition();
        shootBullet();
        heroHit();
    }
    public void heromove(){
        // Add your action code here.
        if (Greenfoot.isKeyDown("d")){
            setLocation(getX()+3, getY());
        }
        if (Greenfoot.isKeyDown("a")){
            setLocation(getX()-3, getY());
        }
        if (Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY()-3);
        }
        if (Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY()+3);
        }
    }
    int bulletCount = 0;
    public void shootBullet(){
        bulletCount++;
        if (bulletCount==20){
            Bullet bullet = new Bullet();
            getWorld().addObject (bullet, getX()+50,getY());
            bulletCount = 0;
        }
    }
    public void heroHit(){
        if (isTouching(Enemy.class)){
            removeTouching(Enemy.class);
            Boom boom = new Boom();
            getWorld().addObject(boom, getX(), getY());
            setLocation(50, 200);
        }
    }
    public void resetposition(){
        if (getY()==0){
            setLocation (getX(),398);
        }
        if (getY()==399){
            setLocation (getX(),1);
        }
    }
}
