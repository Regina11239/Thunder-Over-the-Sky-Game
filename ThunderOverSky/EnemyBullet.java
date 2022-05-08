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
         g.setColor(new Color(0,0,255));
         g.fillArc(x-10,y-10,20,20,0,360);  
         
         g.setColor(new Color(139,227,243));
         g.fillArc(x-8,y-8,16,16,0,360);
      }
   }
}