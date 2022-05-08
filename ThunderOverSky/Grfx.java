// The Grfx Class for ThunderOverTheSky

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.applet.*;

public class Grfx
{
	static final Color red=Color.red;
	static final Color green=Color.green;
	static final Color blue=Color.blue;
	static final Color orange=Color.orange;
	static final Color cyan=Color.cyan;
	static final Color magenta=Color.magenta;
	static final Color yellow=Color.yellow;
	static final Color gray=Color.gray;
	static final Color lightGray=Color.lightGray;
	static final Color darkGray=Color.darkGray;
	static final Color pink=Color.pink;
	static final Color black=Color.black;
	static final Color white=Color.white;
	static final Color lightRed=new Color(255,128,128);
	static final Color darkRed=new Color(192,0,0);
	static final Color lightOrange=new Color(255,224,0);
	static final Color darkOrange=new Color(255,128,0);
	static final Color lightYellow=new Color(255,255,128);
	static final Color darkYellow=new Color(192,192,0);
	static final Color lightGreen=new Color(128,255,128);
	static final Color darkGreen=new Color(0,128,0);
	static final Color lightBlue=new Color(128,128,255);
	static final Color darkBlue=new Color(0,0,128);
	static final Color lightMagenta=new Color(255,64,255);
	static final Color darkMagenta=new Color(192,0,192);
	static final Color lightCyan=new Color(128,255,255);
	static final Color darkCyan=new Color(0,192,192);
	static final Color lightPink=new Color(255,194,194);
	static final Color darkPink=new Color(240,150,150);
	static final Color tan=new Color(210,180,140);
	static final Color lightTan=new Color(231,198,154);
	static final Color darkTan=new Color(189,145,87);
	static final Color brown=new Color(150,100,15);
	static final Color violet=new Color(240,128,240);
	static final Color purple=new Color(128,0,128);
	static final Color turquoise=new Color(64,224,208);
	static final Color gold=new Color(255,215,0);
	static final Color silver=new Color(192,192,192);
	static final Color bronze=new Color(164,102,40);
   
   public static int random(int min,int max)
   {
      int range=max-min+1;
      int number=(int)(range*Math.random()+min);
      return number;
   }
   
   public static void delay(int n)
   {
      long startDelay=System.currentTimeMillis();
      long endDelay=0;
      while(endDelay-startDelay<n)
         endDelay=System.currentTimeMillis();
   }
   
   public static void setColor(Graphics g,int colorNum)
   {
      colorNum%=10;
      switch(colorNum)
      {
         case 0:g.setColor(black);break;
			case 1:g.setColor(red);break;
			case 2:g.setColor(green);break;
			case 3:g.setColor(blue);break;
			case 4:g.setColor(yellow);break;
			case 5:g.setColor(cyan);break;
			case 6:g.setColor(magenta);break;
			case 7:g.setColor(gray);break;
			case 8:g.setColor(orange);break;
			case 9:g.setColor(pink);break;
			default:g.setColor(white);
		}
	}
   
   public static void setColor(Graphics g,int red,int green,int blue)
   {
      Color newColor=new Color(red,green,blue);
      g.setColor(newColor);
   }
   
   public static void setBackground(Graphics g,Color bgColor)
   {
      g.setColor(bgColor);
      fillRectangle(g,0,0,4800,3600);
   }
   
   public static void drawPixel(Graphics g,int x,int y)
   {
      g.drawLine(x,y,x,y);
   }
   
   public static void drawPoint(Graphics g,int x,int y)
   {
      g.fillRect(x-1,y-1,3,3);
   }
   
   public static void drawCircle(Graphics g,int centerX,int centerY,int radius)
   {
      int diameter=2*radius;
      g.drawOval(centerX-radius,centerY-radius,diameter,diameter);
   }
   
   public static void drawArc(Graphics g,int centerX,int centerY,int hRadius,int vRadius,int start,int finish)
   {
      int hDiameter=2*hRadius;
      int vDiameter=2*vRadius;
      if(finish<start)
         finish+=360;
      int newStart=90-start;
      int newFinish=start-finish;
      g.drawArc(centerX-hRadius,centerY-vRadius,hDiameter,vDiameter,newStart,newFinish);
   }
   
   public static void drawTriangle(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3)
   {
      Polygon myPoly=new Polygon();
      myPoly.addPoint(x1,y1);
      myPoly.addPoint(x2,y2);
      myPoly.addPoint(x3,y3);
      g.drawPolygon(myPoly);
   }
   
   public static void drawQuad(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4)
   {
      Polygon myPoly=new Polygon();
      myPoly.addPoint(x1,y1);
      myPoly.addPoint(x2,y2);
      myPoly.addPoint(x3,y3);
      myPoly.addPoint(x4,y4);
      g.drawPolygon(myPoly);
   }
   
   public static void drawRectangle(Graphics g,int x1,int y1,int x2,int y2)
   {
      int temp;
      if(x1>x2){temp=x1;x1=x2;x2=temp;}
      if(y1>y2){temp=y1;y1=y2;y2=temp;}
      int width=x2-x1+1;
      int height=y2-y1+1;
      g.drawRect(x1,y1,width,height);
   }
   
   public static void drawRoundedRectangle(Graphics g,int x1,int y1,int x2,int y2,int pixels)
   {
      int temp;
      if(x1>x2){temp=x1;x1=x2;x2=temp;}
      if(y1>y2){temp=y1;y1=y2;y2=temp;}
      int width=x2-x1+1;
      int height=y2-y1+1;
      int diameter=pixels*2;
      g.drawRoundRect(x1,y1,width,height,diameter,diameter);
   }
   
   public static void drawStar(Graphics g,int centerX,int centerY,int radius,int points)
   {
      double r2;
      if(points%2==0)
         r2=radius*Math.sin(Math.PI/points)/Math.sin(Math.PI*2/points);
      else
         r2=radius*Math.sin(Math.PI/2/points)/Math.sin(Math.PI*3/2/points);
      int[] starX=new int[2*points];
      int[] starY=new int[2*points];
      for(int k=0;k<2*points;k++)
      {
         double actualR;
         if(k%2==0)
            actualR=radius;
         else
            actualR=r2;
         starX[k]=(int)(centerX+actualR*Math.cos(Math.PI*k/points-Math.PI/2));
         starY[k]=(int)(centerY+actualR*Math.sin(Math.PI*k/points-Math.PI/2));
      }
      g.drawPolygon(starX,starY,2*points);
   }
   
   public static void drawThickLine(Graphics g,int x1,int y1,int x2,int y2,int thickness)
   {
      if(thickness<2)
         thickness=2;
      int start=-thickness/2;
      int finish;
      if(thickness%2==0)
         finish=thickness/2;
      else
         finish=thickness/2-1;
      for(int x=start;x<=finish;x++)
         for(int y=start;y<=finish;y++)
            g.drawLine(x1+x,y1+y,x2+x,y2+y);
   }
   
   public static void drawThickCircle(Graphics g,int centerX,int centerY,int radius,int thickness)
   {
      int diameter=2*radius-1;
      if(thickness<2)
         thickness=2;
      thickness--;
      for(int j=0;j<thickness;j++)
         g.drawOval(centerX-radius+j,centerY-radius+j,diameter-2*j,diameter-2*j);
		centerX++;
      for(int j=0;j<thickness;j++)
         g.drawOval(centerX-radius+j,centerY-radius+j,diameter-2*j,diameter-2*j);
      centerY++;
      for(int j=0;j<thickness;j++)
         g.drawOval(centerX-radius+j,centerY-radius+j,diameter-2*j,diameter-2*j);
      centerX--;
      for(int j=0;j<thickness; j++)
         g.drawOval(centerX-radius+j,centerY-radius+j,diameter-2*j,diameter-2*j);
   }
   
   public static void drawThickArc(Graphics g,int centerX,int centerY,int hRadius,int vRadius,int start,int finish,int thickness)
   {
      int hDiameter=2*hRadius-1;
      int vDiameter=2*vRadius-1;
      if(thickness<2)
         thickness=2;
      thickness--;
      for(int j=0;j<thickness;j++)
         drawArc(g,centerX,centerY,hRadius-j,vRadius-j,start,finish);
      centerX++;
      for(int j=0;j<thickness;j++)
         drawArc(g,centerX,centerY,hRadius-j,vRadius-j,start,finish);
      centerY++;
      for(int j=0;j<thickness;j++)
         drawArc(g,centerX,centerY,hRadius-j,vRadius-j,start,finish);
      centerX--;
      for(int j=0;j<thickness;j++)
         drawArc(g,centerX,centerY,hRadius-j,vRadius-j,start,finish);
   }
   
   public static void drawThickTriangle(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int thickness)
   {
      for(int x=0;x<thickness;x++)
         for(int y=0;y<thickness;y++)
            drawTriangle(g,x1+x,y1+y,x2+x,y2+y,x3+x,y3+y);
   }
   
   public static void drawThickQuad(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,int thickness)
   {
      for(int x=0;x<thickness;x++)
         for(int y=0;y<thickness;y++)
            drawQuad(g,x1+x,y1+y,x2+x,y2+y,x3+x,y3+y,x4+x,y4+y);
   }
   
   public static void drawThickRectangle(Graphics g,int x1,int y1,int x2,int y2,int thickness)
   {
      if(thickness<2)
         thickness=2;
      int temp;
      if(x1>x2){temp=x1;x1=x2;x2=temp;}
      if(y1>y2){temp=y1;y1=y2;y2=temp;}
      int width=x2-x1+1;
      int height=y2-y1+1;
      for(int j=0;j<thickness;j++)
         g.drawRect(x1+j,y1+j,width-2*j,height-2*j);
   }
   
   public static void drawThickRoundedRectangle(Graphics g,int x1,int y1,int x2,int y2,int pixels,int thickness)
   {
      int temp;
      if(x1>x2){temp=x1;x1=x2;x2=temp;}
      if(y1>y2){temp=y1;y1=y2;y2=temp;}
      int width=x2-x1+1;
      int height=y2-y1+1;
      int diameter=pixels*2;
      if(thickness<2)
         thickness=2;
      thickness--;
      for(int j=0;j<thickness;j++)
         g.drawRoundRect(x1+j,y1+j,width-2*j,height-2*j,diameter,diameter);
      x1++;
      for(int j=0;j<thickness;j++)
         g.drawRoundRect(x1+j,y1+j,width-2*j,height-2*j,diameter,diameter);
      y1++;
      for(int j=0;j<thickness;j++)
         g.drawRoundRect(x1+j,y1+j,width-2*j,height-2*j,diameter,diameter);
      x1--;
      for(int j=0;j<thickness;j++)
         g.drawRoundRect(x1+j,y1+j,width-2*j,height-2*j,diameter,diameter);
   }
   
   public static void fillCircle(Graphics g,int centerX,int centerY,int radius)
   {
      int diameter=2*radius;
      g.fillOval(centerX-radius,centerY-radius,diameter,diameter);
   }
   
   public static void fillArc(Graphics g,int centerX,int centerY,int hRadius,int vRadius,int start,int finish)
   {
      int hDiameter=2*hRadius;
      int vDiameter=2*vRadius;
      if(finish<start)
         finish+=360;
      int newStart=90-start;
      int newFinish=start-finish;
      g.fillArc(centerX-hRadius,centerY-vRadius,hDiameter,vDiameter,newStart,newFinish);
   }
   
   public static void fillTriangle(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3)
   {
      Polygon myPoly=new Polygon();
      myPoly.addPoint(x1,y1);
      myPoly.addPoint(x2,y2);
      myPoly.addPoint(x3,y3);
      g.fillPolygon(myPoly);
   }
   
   public static void fillQuad(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4)
   {
      Polygon myPoly=new Polygon();
      myPoly.addPoint(x1,y1);
      myPoly.addPoint(x2,y2);
      myPoly.addPoint(x3,y3);
      myPoly.addPoint(x4,y4);
      g.fillPolygon(myPoly);
   }
   
   public static void fillRectangle(Graphics g,int x1,int y1,int x2,int y2)
   {
      int temp;
      if(x1>x2){temp=x1;x1=x2;x2=temp;}
      if(y1>y2){temp=y1;y1=y2;y2=temp;}
      int width=x2-x1+1;
      int height=y2-y1+1;
      g.fillRect(x1,y1,width,height);
   }
   
   public static void fillRoundedRectangle(Graphics g,int x1,int y1,int x2,int y2,int pixels)
   {
      int temp;
      if(x1>x2){temp=x1;x1=x2;x2=temp;}
      if(y1>y2){temp=y1;y1=y2;y2=temp;}
      int width=x2-x1+1;
      int height=y2-y1+1;
      int diameter=pixels*2;
      g.fillRoundRect(x1,y1,width,height,diameter,diameter);
   }
   
   public static void fillStar(Graphics g,int centerX,int centerY,int radius,int points)
   {
      double r2;
      if(points%2==0)
         r2=radius*Math.sin(Math.PI/points)/Math.sin(Math.PI*2/points);
      else
         r2=radius*Math.sin(Math.PI/2/points)/Math.sin(Math.PI*3/2/points);
      int[] starX=new int[2*points];
      int[] starY=new int[2*points];
      for(int k=0;k<2*points;k++)
      {
         double actualR;
         if(k%2==0)
            actualR=radius;
         else
            actualR=r2;
         starX[k]=(int)(centerX+actualR*Math.cos(Math.PI*k/points-Math.PI/2));
         starY[k]=(int)(centerY+actualR*Math.sin(Math.PI*k/points-Math.PI/2));
      }
      g.fillPolygon(starX,starY,2*points);
   }
}
