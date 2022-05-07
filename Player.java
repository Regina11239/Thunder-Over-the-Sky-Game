// Player

import java.awt.*;
import java.applet.*;
import java.util.*;

public class Player extends GameThing
{
   private ArrayList<PlayerBullet> bullets;
   
   public Player(Graphics g)
   {
      super(g);
      x=30;
      y=360;
      radius=75;
      life=1000;
      bullets=new ArrayList<PlayerBullet>();
   }
   
   public void shoot()
   {
      count++;
      if(count>=200)
      {
         PlayerBullet bullet=new PlayerBullet(g,this);
         bullets.add(bullet);
         count=0;
      }
   }
   
   public void draw()
   {
      g.setColor(Color.red);
      g.fillOval(x-75,y-75,150,150);
   }
   
   public ArrayList<PlayerBullet> getBullets(){return bullets;}
}