import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lvl2BkgDesert here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lvl2BkgDesert extends World
{

    /**
     * Constructor for objects of class Lvl2BkgDesert.
     * 
     */
  
    public Lvl2BkgDesert()
    {    
        // Create a new world with 800x500 cells with a cell size of 1x1 pixels.
        super(800, 500, 1); 
        
        Greenfoot.playSound("Lvl2Music.mp3");
    
        
        
        Greenfoot.setSpeed(50);
        
        // Create the demon object
        BlueDemon bluedemon = new BlueDemon();
        
        // Put Blue Demon in our world
        addObject(bluedemon,650, getHeight()/4);
        
        
        //adds Launcher into World
        Launcher myLauncher = new Launcher();
        addObject(myLauncher,getWidth()/2,getHeight());
            Rocks myRocks = new Rocks(1, 150);
        int x = getWidth() - getWidth()/5;
        int y = getHeight()- getHeight()/3;
        addObject(myRocks,  x, y);
        
        Rocks myRocks1 = new Rocks(2, 150);
        addObject(myRocks1, getWidth() - getWidth()/2 , getHeight()- getHeight()/3 );
         
        Rocks myRocks2 = new Rocks(3, 150);
        addObject(myRocks2, getWidth()/2 - getWidth()/3 , getHeight()- getHeight()/3);
         
        Rocks myRocks3 = new Rocks(4, 50);
        addObject(myRocks3, getWidth()/2 - getWidth()/5 , getHeight()/2- getHeight()/4);
        
        Rocks myRocks4 = new Rocks(5, 50);
        addObject(myRocks4, getWidth() - getWidth()/3 , getHeight()/2- getHeight()/4);    
        
        //add DemonExplosion into World
        DemonExplosion demonexplosion = new DemonExplosion();
        
      
    }
    
  
        
    
}
