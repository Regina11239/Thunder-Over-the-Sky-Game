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
         x+=5;
         count=0;
      }
   }
   
   public void draw()
   {
      g.setColor(Color.yellow);
      g.fillOval(x-10,y-10,20,20);
   }
}