import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class Rocks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocks extends Actor
{
    /**
     * Act - do whatever the Rocks wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int shotstaken = 0;
    int count = 0;
    int health = 100;
    boolean colorchanged = false;
    int number;
    int scalefactor;
    int randtime;
    public Rocks(int num, int sf)
    {
        GreenfootImage img = getImage();
        scalefactor = sf; 
        img.scale(sf, sf);
        setImage(img);     
        number = num;
        randtime = (Greenfoot.getRandomNumber(7) + 2)*100;
    }
    
    public int getNumber()
    {
        return number;
    }
    public void act() 
    {
        count++;
        //Detects when the dart hits the rock. When it does, the action follows.
        Actor Darts=getOneIntersectingObject(Darts.class);
        if(Darts!=null)
        {
          getWorld().removeObject(Darts);
          if(colorchanged)
          {
              Greenfoot.playSound("explosion.wav");
              shotstaken++;
          }
        }
        //Detects when explodes
        //Actor  = getOneIntersectingObject(.class);
        if(shotstaken > 3)
        {
            getWorld().addObject(new Explosion(), getX(), getY());
            shotstaken = 0;
            Greenfoot.playSound("explosion.wav");
        } 
        //
        if(!colorchanged)
        {
            if(count % randtime == 0)
            {
                GreenfootImage img1 = new GreenfootImage("rock-color.png");
                img1.scale(scalefactor, scalefactor);
                setImage(img1);
                colorchanged = true;
            }
        }
        else if(colorchanged)
        {
            if(count % 100 == 0)
            {
                GreenfootImage img = new GreenfootImage("rock.png");
                img.scale(scalefactor, scalefactor);
                setImage(img);  
                colorchanged = false;
                randtime = (Greenfoot.getRandomNumber(7) + 2)*100;        
            }
        }
    }
}
