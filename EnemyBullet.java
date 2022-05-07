// EnemyBullet

import java.awt.*;
import java.applet.*;

public class EnemyBullet extends GameThing
{
   public EnemyBullet(Graphics g,Enemy enemy)
   {
      super(g);
      x=enemy.getX()-50;
      y=enemy.getY();
      radius=10;
   }
   
   public void move()
   {
      count++;
      if(count>=10)
      {
         x-=10;
         count=0;
      }
   }
   
   public void draw()
   {
      if(alive)
      {
         g.setColor(Color.magenta);///////////////
         g.fillOval(x-10,y-10,20,20);/////////////
      }
   }
}