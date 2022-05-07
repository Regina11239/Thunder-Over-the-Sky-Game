// GameThing

import java.awt.*;
import java.applet.*;

public class GameThing
{
   int x,y,radius,life,count;
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
}