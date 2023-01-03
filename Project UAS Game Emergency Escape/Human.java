import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Human here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Human extends Actor
{
    int keyGet = 0;
    int coinGet = 0;
    int score = 0;
    int lives = 3;
    
    public Human()
    {
        
    }
    
    public void act()
    {
        // Add your action code here.
        HumanMovement();
        detectBlockCollision();
        getKeys();
        getCoin();
        showStatus();
        detectGhostCollision();
    }
    
     public void HumanMovement(){
        //Kode untuk robot bergerak
        if (Greenfoot.isKeyDown("W")){
            setLocation(getX(),getY()-4);
        }
        if (Greenfoot.isKeyDown("S")){
            setLocation(getX(),getY()+4);

        }
        if (Greenfoot.isKeyDown("D")){
            setLocation(getX()+4,getY());
       
        }
        if (Greenfoot.isKeyDown("A")){
            setLocation(getX()-4,getY());
           
        }
    }
    
    public void detectGhostCollision(){
        if(isTouching(Ghost1.class)){
            Greenfoot.playSound("death.mp3");
            Greenfoot.setWorld(new GameOver());
        }
    }
    public void detectBlockCollision(){
        //kode untuk mendeteksi robot jika terkena block maka lokasi akan diset ulang
        if (isTouching(Block.class)){
            Greenfoot.playSound("death.mp3");
            setLocation(0,getY());
        }
    }
    
    public void detectWallCollision(){
        //kode untuk mendeteksi robot jika terkena block maka lokasi akan diset ulang
        if (isTouching(Block.class)){
            Greenfoot.playSound("death.mp3");
            setLocation(0,getY());
        }
    }
    
    public void getKeys(){
        if (isTouching(Keys.class)){
            Greenfoot.playSound("mariocoin.mp3");
            removeTouching(Keys.class);
            keyGet++;
        }
    }
    
    public void getCoin(){
        if (isTouching(Coin.class)){
            Greenfoot.playSound("mariocoin.mp3");
            removeTouching(Coin.class);
            coinGet++;
        }
    }
    
    
    public void increaseKeys(){
        if (keyGet == 1){
            score++;
        }
    }
    
    public void increaseCoin(){
        if (coinGet == 3){
            score++;
        }
    }
    
    public void showStatus(){
        getWorld().showText("Lives : "+lives,71,530);
        getWorld().showText("Keys : "+keyGet,71,550);
        getWorld().showText("Coin : "+coinGet,71,570);
    }
}
