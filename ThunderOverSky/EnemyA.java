// EnemyA - bomber

import java.awt.*;
import java.applet.*;
import java.util.*;

public class EnemyA extends Enemy
{
   public EnemyA(Graphics g)
   {
      super(g);
      x=1330;
      y=(int)(Math.random()*580+70);
   }
   
   public void attack(Player player)
   {
      count++;
      if(count>=50)
      {
         x-=5;
         count=0;
      }
      hitPlayer(player);
   }
   
   public void hitPlayer(Player player)
   {
      checkPosition();
      if(isAlive()&&hit(player))
      {
         player.deductLife(100);
         kill();
      }
   }
   
   public void checkPosition()
   {
      if(x+radius<0)
         kill();
   }
   
   public void draw()
   {
      if(alive)
      {
         g.setColor(Color.blue);//////////////////
         g.fillOval(x-50,y-50,100,100);///////////
         g.setColor(Color.red);
         g.fillRect(x-35,y-70,(int)(life/1000.0*70),5);
         g.setColor(Color.black);
         g.drawRect(x-35,y-70,70,5);
      }
   }
}
