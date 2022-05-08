// EnemyB - shooter

import java.awt.*;
import java.applet.*;
import java.util.*;

public class EnemyB extends Enemy
{
   private ArrayList<EnemyBullet> bullets;
   
   public EnemyB(Graphics g)
   {
      super(g);
      x=(int)(Math.random()*400+810);
      y=(int)(Math.random()*580+70);
      bullets=new ArrayList<EnemyBullet>();
   }
   
   public void attack(Player player)
   {
      count++;
      if(count>=1000)
      {
         EnemyBullet bullet=new EnemyBullet(g,this);
         bullets.add(bullet);
         count=0;
      }
      for(int k=0;k<bullets.size();k++)
      {
         bullets.get(k).move();
         bullets.get(k).draw();
      }
      hitPlayer(player);
   }
   
   public void hitPlayer(Player player)
   {
      checkBullet();
      for(int k=0;k<bullets.size();k++)
         if(bullets.get(k).isAlive()&&bullets.get(k).hit(player))
         {
            player.deductLife(50);
            bullets.get(k).kill();
         }
   }
   
   public ArrayList<EnemyBullet> getBullets()
   {
      return bullets;
   }
   
   public void checkBullet()
   {
      for(int k=0;k<bullets.size();k++)
         if(bullets.get(k).getX()<0)
            bullets.get(k).kill();
   }
   
   public void draw()
   {
      if(alive)
      {
         g.setColor(new Color(50,212,255));
         int xHex[] = {x-5,x+5,x+46,x+41,x-41,x-46};
         int yHex[] = {y+50,y+50,y-18,y-30,y-30,y-18};
      	g.fillPolygon(xHex,yHex,6);
            
         g.setColor(new Color(0,0,255));
         int xTri[] = {x-43,x+43,x};
         int yTri[] = {y-25,y-25,y+50};
         g.fillPolygon(xTri,yTri,3);

         g.setColor(Color.red);
         g.fillRect(x-35,y-70,(int)(life/1000.0*70),5);
         g.setColor(Color.black);
         g.drawRect(x-35,y-70,70,5);
      }
   }
}