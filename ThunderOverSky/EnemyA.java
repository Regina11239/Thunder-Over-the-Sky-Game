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
         g.setColor(new Color(252,0,172));
         g.drawLine(x-20,y-14,x-50,y-4);
         g.drawLine(x-20,y+14,x-50,y+4);		
         int xCoord[] = {x-20,x-50,x-50,x-20};
   		int yCoord[] = {y-14,y-4,y+4,y+14};
   		g.fillPolygon(xCoord,yCoord,4);
         g.fillArc(x-27*2,y-4,10,8,90,180);
         g.fillArc(x-16*2,y-14,24,14*2,270,180);
               
      for (int k = 100; k <= 225; k++)
   		{
   			g.setColor(new Color(k,0,180));
   			g.fillArc(x-30+k/5,y-k/5,k/10,k/10,0,360);
            g.fillArc(x-30+k/5,y+k/10,k/10,k/10,0,360);
   	   }
           
      g.setColor(new Color(255,0,160));
      int xw2[] = {x-15,x-5,x+5};
		int yw2[] = {y+15,y+50,y+40};
		g.fillPolygon(xw2,yw2,3);
      
      g.setColor(new Color(255,0,160));
      int xw2U[] = {x-15,x-5,x+5};
		int yw2U[] = {y+15,y+50,y+40};
		g.fillPolygon(xw2U,yw2U,3);
      int xw2D[] = {x-15,x-5,x+5};
		int yw2D[] = {y-15,y-50,y-40};
		g.fillPolygon(xw2D,yw2D,3);
      
      g.setColor(new Color(255,110,177));
      g.drawArc(x-20,y-10,15,15,0,360);
      g.drawArc(x-19,y-10,14,14,0,360);
      g.drawArc(x-18,y-10,13,13,0,360);
      g.drawArc(x-17,y-10,12,12,0,360);
         g.setColor(Color.red);
         g.fillRect(x-35,y-70,(int)(life/1000.0*70),5);
         g.setColor(Color.black);
         g.drawRect(x-35,y-70,70,5);
      }
   }
}