// PlayerBullet

import java.awt.*;
import java.applet.*;

public class PlayerBullet extends GameThing
{
   public PlayerBullet(Graphics g,Player player)
   {
      super(g);
      x=player.getX()+75;
      y=player.getY();
      radius=10;
   }
   
   public void move()
   {
      count++;
      if(count>=10)
      {
         x+=20;
         count=0;
      }
   }
   
   public void draw()
   {
      if(alive)
      {
         g.setColor(new Color(255,145,0));
         g.fillArc(x,y-10,20,20,270,180);
         int xTail[] = {x+10,x-10,x-10,x-15,x-10,x-25,x-5,x-22,x-5,x-23,x-5,x-10,x+10};
         int yTail[] = {y-10,y-10,y-10,y-7,y-5,y-3,y-0,y+4,y+5,y+10,y+12,y+10,y+10};
         g.fillPolygon(xTail,yTail,13);
         g.setColor(new Color(220,0,0));
         g.fillArc(x,y-8,17,17,0,360);
      }
   }
}