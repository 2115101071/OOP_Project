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
    int score = 0;
    int lives = 3;
    int pizzaEaten = 0;
    private GreenfootImage gameOver = new GreenfootImage("gameover.png");
    public void act()
    {
        // Add your action code here.
        RobotMovement();
        detectWallCollision();
        detectBlockCollision();
        detectHome();
        eatPizza();
        showStatus();
    }
    
    public void RobotMovement(){
        //Kode untuk robot bergerak
        if (Greenfoot.isKeyDown("W")){
            setLocation(getX(),getY()-2);
            animate();
        }
        if (Greenfoot.isKeyDown("S")){
            setLocation(getX(),getY()+2);
            animate();
        }
        if (Greenfoot.isKeyDown("D")){
            setLocation(getX()+2,getY());
            animate();
        }
        if (Greenfoot.isKeyDown("A")){
            setLocation(getX()-2,getY());
            animate();
        }
    }
    
    public void detectWallCollision(){
        //kode untuk mendeteksi robot jika terkena wall maka lokasi akan di set ulang
        if (isTouching(Wall.class)){
            Greenfoot.playSound("hurt.wav");
            setLocation(0,getY());
            removeLife();
        }
    }
    
    public void detectBlockCollision(){
        //kode untuk mendeteksi robot jika terkena block maka lokasi akan diset ulang
        if (isTouching(Block.class)){
            Greenfoot.playSound("hurt.wav");
            setLocation(0,getY());
            removeLife();
        }
    }
    
    public void detectHome(){
        if (isTouching(Home.class)){
            Greenfoot.playSound("yipee.wav");
            setLocation(48,50);
            if (pizzaEaten == 5){
                pizzaEaten = 0;
            }
        }
    }
    
    public void eatPizza(){
        if (isTouching(Pizza.class)){
            Greenfoot.playSound("eat.wav");
            removeTouching(Pizza.class);
            pizzaEaten++;
        }
    }
    
    private GreenfootImage robotimage1 = new GreenfootImage("man01.png");
    private GreenfootImage robotimage2 = new GreenfootImage("man02.png");
    
    public void animate(){
        if (getImage().equals(robotimage1)){
            setImage(robotimage2);
        }else{
            setImage(robotimage1);
        }
    }
    
    public void removeLife(){
        lives--;
        testEndGame();
    }
    
    public void testEndGame(){
        if (lives < 0 || pizzaEaten == 5){
            GreenfootImage image = new GreenfootImage(gameOver);
            setImage(image);
            Greenfoot.stop();
        }
    }
    
    public void increaseScore(){
        if (pizzaEaten == 5){
            score++;
        }
    }
    
    public void showStatus(){
        getWorld().showText("Score : "+score,71,530);
        getWorld().showText("Pizza : "+pizzaEaten,71,550);
        getWorld().showText("Lives : "+lives,71,570);
    }
}
