// Player

import java.awt.*;
import java.applet.*;
import java.util.*;

public class Player extends GameThing
{
   private ArrayList<PlayerBullet> bullets;
   private static int life=1000, hitCount, attack=50;
   
   public Player(Graphics g)
   {
      super(g);
      x=100;
      y=360;
      radius=75;
      bullets=new ArrayList<PlayerBullet>();
   }
  
   public void reset() {
	   bullets = new ArrayList<PlayerBullet>();
	   life=1000;
	   hitCount = 0; 
	   attack=50;
	   
   }
   
   public void shoot()
   {
      count++;
      if(count>=50)
      {
         PlayerBullet bullet=new PlayerBullet(g,this);
         bullets.add(bullet);
         count=0;
      }
   }
   
   public void move(int deltaX,int deltaY)
   {
      if(x+radius+deltaX<1280&&x-radius+deltaX>0&&y+radius+deltaY<720&&y-radius+deltaY>0)
         super.move(deltaX,deltaY);
   }
   
   public void draw()
   {
      x = x+85;
      g.setColor(Color.black);
      Polygon up = new Polygon();
		up.addPoint(x,y);
		up.addPoint(x-10,y-5);
		up.addPoint(x-10,y-15);
		up.addPoint(x-25,y-20);
		up.addPoint(x-25,y-30);
		up.addPoint(x-25,y-15);
		up.addPoint(x-15,y-10);
		up.addPoint(x-15,y-5);
      up.addPoint(x-40,y-5);
      up.addPoint(x-60,y-20);
      up.addPoint(x-40,y-45);
      
      up.addPoint(x-50,y-55);
      up.addPoint(x-60,y-55);
      up.addPoint(x-90,y-35);
      up.addPoint(x-75,y-30);
      up.addPoint(x-85,y-10);
      up.addPoint(x-170,y);
      
      g.fillPolygon(up);
      
      Polygon wingEdge1 = new Polygon();
      wingEdge1.addPoint(x-40,y-45);//additional wings
      wingEdge1.addPoint(x-35,y-50);
      wingEdge1.addPoint(x-45,y-60);
      wingEdge1.addPoint(x-60,y-60);
      wingEdge1.addPoint(x-80,y-55);
      wingEdge1.addPoint(x-50,y-55);
      g.setColor(Color.red);
      g.fillPolygon(wingEdge1);
      g.setColor(Color.black);
      g.drawPolygon(wingEdge1);
      
      Polygon wingEdge2 = new Polygon();
      wingEdge2.addPoint(x-35,y-50);//additional wings
      wingEdge2.addPoint(x-25,y-55);
      wingEdge2.addPoint(x-37,y-85);
      wingEdge2.addPoint(x-41,y-80);
      wingEdge2.addPoint(x-39,y-65);
      wingEdge2.addPoint(x-60,y-85);
      wingEdge2.addPoint(x-70,y-85);
      wingEdge2.addPoint(x-57,y-75);
      wingEdge2.addPoint(x-55,y-70);
      wingEdge2.addPoint(x-80,y-70);
      wingEdge2.addPoint(x-73,y-65);
      wingEdge2.addPoint(x-60,y-60);
      wingEdge2.addPoint(x-45,y-60);
      g.setColor(Color.red);
      g.fillPolygon(wingEdge2);
      g.setColor(Color.black);
      g.drawPolygon(wingEdge2);

      Polygon Body1 = new Polygon();
      Body1.addPoint(x-40,y);
      Body1.addPoint(x-35,y-5);
      Body1.addPoint(x-40,y-5);
      Body1.addPoint(x-60,y-20);
      Body1.addPoint(x-65,y-15);
      Body1.addPoint(x-60,y-10);
      Body1.addPoint(x-75,y);

      g.setColor(Color.red);
      g.fillPolygon(Body1);
      
      Polygon Body2 = new Polygon();
      Body2.addPoint(x-75,y);
      Body2.addPoint(x-65,y-5);
      Body2.addPoint(x-70,y-15);
      Body2.addPoint(x-80,y-7);
      Body2.addPoint(x-103,y-6);
      Body2.addPoint(x-120,y-5);
      Body2.addPoint(x-140,y);
            
      g.setColor(Color.red);
      g.fillPolygon(Body2);
      g.setColor(Color.black);
      g.drawPolygon(Body2);

      Polygon horn = new Polygon();
      horn.addPoint(x-10,y-5);
		horn.addPoint(x-10,y-15);
		horn.addPoint(x-25,y-20);
		horn.addPoint(x-25,y-30);
		horn.addPoint(x-25,y-15);
		horn.addPoint(x-15,y-10);
		horn.addPoint(x-15,y-5);
      
      g.setColor(new Color(242,209,20));
      g.fillPolygon(horn);

      Polygon connect = new Polygon();
      connect.addPoint(x-65,y-15);
      connect.addPoint(x-60,y-10);
      connect.addPoint(x-65,y-7);
      connect.addPoint(x-70,y-15);
      connect.addPoint(x-45,y-50);
      connect.addPoint(x-40,y-45);
      
      g.setColor(Color.gray);
      g.fillPolygon(connect);

      
            
//---------------------------------------------------
      
      Polygon down = new Polygon();
		down.addPoint(x,y);
		down.addPoint(x-10,y+5);
		down.addPoint(x-10,y+15);
		down.addPoint(x-25,y+20);
		down.addPoint(x-25,y+30);
		down.addPoint(x-25,y+15);
		down.addPoint(x-15,y+10);
		down.addPoint(x-15,y+5);
      down.addPoint(x-40,y+5);
      down.addPoint(x-60,y+20);
      down.addPoint(x-40,y+45);
      
      down.addPoint(x-50,y+55);
      down.addPoint(x-60,y+55);
      down.addPoint(x-90,y+35);
      down.addPoint(x-75,y+30);
      down.addPoint(x-85,y+10);
      down.addPoint(x-170,y);
      g.setColor(Color.black);
		g.fillPolygon(down);	
	  
   
      Polygon wingEdgeD1 = new Polygon();
      wingEdgeD1.addPoint(x-40,y+45);//additional wings
      wingEdgeD1.addPoint(x-35,y+50);
      wingEdgeD1.addPoint(x-45,y+60);
      wingEdgeD1.addPoint(x-60,y+60);
      wingEdgeD1.addPoint(x-80,y+55);
      wingEdgeD1.addPoint(x-50,y+55);
      g.setColor(Color.red);
      g.fillPolygon(wingEdgeD1);
       g.setColor(Color.black);
      g.drawPolygon(wingEdgeD1);

      Polygon wingEdgeD2 = new Polygon();
      wingEdgeD2.addPoint(x-35,y+50);//additional wings
      wingEdgeD2.addPoint(x-25,y+55);
      wingEdgeD2.addPoint(x-37,y+85);
      wingEdgeD2.addPoint(x-41,y+80);
      wingEdgeD2.addPoint(x-39,y+65);
      wingEdgeD2.addPoint(x-60,y+85);
      wingEdgeD2.addPoint(x-70,y+85);
      wingEdgeD2.addPoint(x-57,y+75);
      wingEdgeD2.addPoint(x-55,y+70);
      wingEdgeD2.addPoint(x-80,y+70);
      wingEdgeD2.addPoint(x-73,y+65);
      wingEdgeD2.addPoint(x-60,y+60);
      wingEdgeD2.addPoint(x-45,y+60);
      g.setColor(Color.red);
      g.fillPolygon(wingEdgeD2);
      g.setColor(Color.black);
      g.drawPolygon(wingEdgeD2);

      Polygon Body1D = new Polygon();
      Body1D.addPoint(x-40,y);
      Body1D.addPoint(x-35,y+5);
      Body1D.addPoint(x-40,y+5);
      Body1D.addPoint(x-60,y+20);
      Body1D.addPoint(x-65,y+15);
      Body1D.addPoint(x-60,y+10);
      Body1D.addPoint(x-75,y);

      g.setColor(Color.red);
      g.fillPolygon(Body1D);
      
       Polygon Body2D = new Polygon();
      Body2D.addPoint(x-75,y);
      Body2D.addPoint(x-65,y+5);
      Body2D.addPoint(x-70,y+15);
      Body2D.addPoint(x-80,y+7);
      Body2D.addPoint(x-103,y+6);
      Body2D.addPoint(x-120,y+5);
      Body2D.addPoint(x-140,y);
            
      g.setColor(Color.red);
      g.fillPolygon(Body2D);
      g.setColor(Color.black);
      g.drawPolygon(Body2D);

      Polygon hornD = new Polygon();
      hornD.addPoint(x-10,y+5);
		hornD.addPoint(x-10,y+15);
		hornD.addPoint(x-25,y+20);
		hornD.addPoint(x-25,y+30);
		hornD.addPoint(x-25,y+15);
		hornD.addPoint(x-15,y+10);
		hornD.addPoint(x-15,y+5);
      
      g.setColor(new Color(242,209,20));
      g.fillPolygon(hornD);
      
      Polygon mouth = new Polygon();
      mouth.addPoint(x,y);
		mouth.addPoint(x-10,y-5);
		mouth.addPoint(x-10,y+5);
		      
      g.setColor(Color.red);
      g.fillPolygon(mouth);
      
      Polygon connectD = new Polygon();
      connectD.addPoint(x-65,y+15);
      connectD.addPoint(x-60,y+10);
      connectD.addPoint(x-65,y+7);
      connectD.addPoint(x-70,y+15);
      connectD.addPoint(x-45,y+50);
      connectD.addPoint(x-40,y+45);
      
      g.setColor(Color.gray);
      g.fillPolygon(connectD);
      
      x = x-85;

      g.setColor(Color.red);
      g.fillRect(x-60,y-95,(int)(life/1000.0*120),5);
      g.setColor(Color.black);
      g.drawRect(x-60,y-95,120,5);
      
   }
   
   public ArrayList<PlayerBullet> getBullets()
   {
      return bullets;
   }
   
   public void checkBullet()
   {
      for(int k=0;k<bullets.size();k++)
         if(bullets.get(k).getX()>1280)
            bullets.get(k).kill();
   }
   
   public void bulletHit(ArrayList<Enemy> enemies)
   {
      checkBullet();
      for(int k=0;k<bullets.size();k++)
         for(int m=0;m<enemies.size();m++)
            if(bullets.get(k).isAlive()&&enemies.get(m).isAlive()&&bullets.get(k).hit(enemies.get(m)))
            {
               bullets.get(k).kill();
               enemies.get(m).deductLife(attack);
               hitCount++;
            }
   }
   
   public int getLife()
   {
      return life;
   }
   
   public void deductLife(int damage)
   {
      life-=damage;
   }
   
   public static void upgrade()
   {
      int randInt=(int)(Math.random()*100+1);
      if(randInt<=life/10)
         attack+=1;
      else
         life+=50;
      if(life>1000)
         life=1000;
   }
}