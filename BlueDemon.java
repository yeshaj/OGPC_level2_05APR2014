import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.awt.List;


/**
 * Write a description of class BlueDemon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlueDemon extends Actor
{
    /**
     * Act - do whatever the BlueDemon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private static final int WEST = 1;
    private static final int EAST = 2;
    public boolean GameOver;
    //  GreenfootSound proton = new GreenfootSound("proton.wav");

    private int direction;

    public BlueDemon()
    {
            setDirection(WEST);
    }

    public void act()
    {
        ;
        
        if(canMove())
        {

            move();

        }
        else 
        {
            turnWest();
        }
        
        if (touchingBullet())
        {      
           //Remove Bullet and Demon objects;
           Actor d = getOneObjectAtOffset(0, 0, Darts.class);

           //List d  = getObjectsInRange(5, Darts.class);

           if (d != null)
           //if (!getObjectsInRange(50, Darts.class).isEmpty())
           {
               Greenfoot.playSound("explosion.wav");
            //   getWorld().removeObject(d);
               GreenfootImage image = getImage();  
                image.scale(image.getWidth() - 8, image.getHeight() - 10);  
                setImage(image);
    
            //When height of RedDemon is less than 20, Find emplosion and Stop the execution
            if (image.getHeight() <= 100)
            {
               getWorld().addObject(new DemonExplosion(), getWorld().getWidth()/2, getWorld().getHeight()/2);
               GameOver = true;
               getWorld().removeObject(this);
            }
            else
            {
                //Explosion because of hit       
                getWorld().addObject(new Explosion(), getX(), getY());
            }

               
           }
 
    }
        
}   
    
    public boolean touchingBullet()
    {    
     return !getIntersectingObjects(Darts.class).isEmpty();    
     } 

    /**
     * Move one cell forward in the current direction.
     */
    public void move()
    {
        if (!canMove()) {
            return;
        }
        switch(direction) {
            case EAST :
                setLocation(getX() + 2, getY());
                break;
            case WEST :
                setLocation(getX() - 2, getY());
                break;
        }
    }

    /**
     * Test if we can move forward. Return true if we can, false otherwise.
     */
    public boolean canMove()
    {
        World myWorld = getWorld();
        int x = getX();
        int y = getY();
        switch(direction) {
            case WEST :
                x = x-2;
                break;
            case EAST :
                x = x+2;
                break;
        }
        // test for outside border
       if (x <= 20)
       {
           return false;
       }
       
       else if (x >= myWorld.getWidth()) 
       { 
          return false;
       }
        return true;
    }

    /**
     * Turns towards the left.
     */
    public void turnWest()
    {
        switch(direction) {
            case WEST :
                setDirection(EAST);
                break;
            case EAST :
                setDirection(WEST);
                break;
        }
    }

    /**
     * Sets the direction we're facing. The 'direction' parameter must
     * be in the range [0..3].
     */
    public void setDirection(int direction)
    {
        if ((direction >= 1) && (direction <= 2)) {
            this.direction = direction;
        }
        switch(direction) {
            case WEST :
                setRotation(0);
                break;
            case EAST :
                setRotation(0);
                break;
            default :
                break;
        }
    }
    
}