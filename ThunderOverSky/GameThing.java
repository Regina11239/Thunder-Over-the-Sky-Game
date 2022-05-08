// GameThing

import java.awt.*;
import java.applet.*;
import java.util.*;

public class GameThing
{
   int x,y,radius,life,count;
   boolean alive=true;
   Graphics g;
   
   public GameThing(Graphics g){this.g=g;}
   
   public void move(int deltaX,int deltaY)
   {
      x+=deltaX;
      y+=deltaY;
   }
   
   public void draw(){}
   public int getX(){return x;}
   public int getY(){return y;}
   public int getR(){return radius;}
   
   public boolean hit(GameThing other)
   {
      double distance=Math.sqrt((this.getX()-other.getX())*(this.getX()-other.getX())+(this.getY()-other.getY())*(this.getY()-other.getY()));
      double rSum=this.getR()+other.getR();
      return rSum>distance;
   }
   
   public boolean isAlive()
   {
      return alive;
   }
   
   public void kill()
   {
      alive=false;
   }
}