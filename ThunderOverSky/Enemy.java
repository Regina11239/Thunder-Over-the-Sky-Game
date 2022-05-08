// Enemy

import java.awt.*;
import java.applet.*;
import java.util.*;

public class Enemy extends GameThing
{
   public Enemy(Graphics g)
   {
      super(g);
      radius=50;
      life=1000;
   }
   
   public int getLife()
   {
      return life;
   }
   
   public void deductLife(int damage)
   {
      life-=damage;
   }
   
   public void checkAlive()
   {
      if(isAlive()&&life<=0)
      {
         kill();
         MainGame.addPoints();
         Player.upgrade();
      }
   }
   
   public void attack(Player player){}
   public void hitPlayer(Player player){}
}
