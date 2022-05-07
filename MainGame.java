// MainGame

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;

public class MainGame extends Frame
{
   private int windowWidth=1280,windowHeight=720;
   private boolean ready,inGame,inScoreboard,inInstructions,inPause;
   private Image virtualMem,titlePage;
   private Graphics gBuffer;
   private Insets insets;
   private Rectangle start,scoreboard,instructions,back,pause;
   private Player player;
   private ArrayList<PlayerBullet> bullets;
   
   public static void main(String[] args)
   {
      MainGame game=new MainGame();
      game.addWindowListener(new WindowAdapter()
      {public void windowClosing(WindowEvent e)
      {System.exit(0);}});
   }
   
   public MainGame()
   {
      super("Thunders Over the Sky");
      setSize(windowWidth+18,windowHeight+47);
      setVisible(true);
      virtualMem=createImage(windowWidth,windowHeight);
      gBuffer=virtualMem.getGraphics();
      try{titlePage=ImageIO.read(new File("TitlePage.png"));}
      catch(Exception e){}
      start=new Rectangle(125,330,300,100);
      scoreboard=new Rectangle(125,440,300,100);
      instructions=new Rectangle(125,550,300,100);
      back=new Rectangle(560,600,160,80);
      pause=new Rectangle(20,20,80,40);
      player=new Player(gBuffer);
      bullets=new ArrayList<PlayerBullet>();
      
      addMouseListener(new MouseAdapter()
      {
         public void mousePressed(MouseEvent e)
         {
            int x=e.getX()-insets.left;
            int y=e.getY()-insets.top;
            if(!inGame&&!inScoreboard&&!inInstructions)
               if(start.contains(x,y))
                  inGame=true;
               else if(scoreboard.contains(x,y))
                  inScoreboard=true;
               else if(instructions.contains(x,y))
                  inInstructions=true;
            if((inScoreboard||inInstructions)&&back.contains(x,y))
               inScoreboard=inInstructions=false;
            if(inGame&&!inPause&&pause.contains(x,y))
               inPause=true;
            if(inPause&&back.contains(x,y))
               inPause=false;
         }
      });
      addKeyListener(new KeyAdapter()
      {
         public void keyPressed(KeyEvent e)
         {
            int key=e.getKeyCode();
            if(inGame&&!inPause)
               if(key==KeyEvent.VK_LEFT)
                  player.move(-10,0);
               else if(key==KeyEvent.VK_RIGHT)
                  player.move(10,0);
               else if(key==KeyEvent.VK_UP)
                  player.move(0,-10);
               else if(key==KeyEvent.VK_DOWN)
                  player.move(0,10);
         }
      });
      ready=true;
   }
   
   public void paint(Graphics g)
   {
      if(ready)
      {
         Graphics g2D=(Graphics2D)g;
         insets=getInsets();
         g2D.translate(insets.left,insets.top);
         if(!inGame&&!inScoreboard&&!inInstructions)
            drawTitlePage(gBuffer);
         if(inGame&&!inPause)
         {
            drawGame(gBuffer);
            player.draw();
            player.shoot();
            bullets=player.getBullets();
            for(int k=0;k<bullets.size();k++)
            {
               bullets.get(k).move();
               bullets.get(k).draw();
            }
         }
         if(inGame&&inPause)
            drawPause(gBuffer);
         if(inScoreboard)
            drawScoreboard(gBuffer);
         if(inInstructions)
            drawInstructions(gBuffer);
         g.drawImage(virtualMem,0,0,this);
      }
      repaint();
   }
   
   public void drawTitlePage(Graphics g)
   {
      g.drawImage(titlePage,0,0,windowWidth,windowHeight,this);
      g.setColor(Grfx.darkBlue);
      g.setFont(new Font("Impact",Font.ITALIC,64));
      g.drawString("OVER THE SKY",100,260);
      g.fillRect(125,330,300,100);
      g.fillRect(125,440,300,100);
      g.fillRect(125,550,300,100);
      g.setColor(Grfx.red);
      g.setFont(new Font("Impact",Font.ITALIC,96));
      g.drawString("THUNDER",100,180);
      Grfx.drawThickRectangle(g,125,330,425,430,5);
      Grfx.drawThickRectangle(g,125,440,425,540,5);
      Grfx.drawThickRectangle(g,125,550,425,650,5);
      g.setFont(new Font("Georgia",Font.BOLD,32));
      g.drawString("Click to Start",170,390);
      g.drawString("Scoreboard",180,500);
      g.drawString("Instructions",175,610);
   }
   
   public void drawGame(Graphics g)
   {
      g.setColor(Grfx.white);
      g.fillRect(0,0,windowWidth,windowHeight);
      g.setColor(Grfx.yellow);
      g.fillRect(20,20,80,40);
      g.setColor(Grfx.black);
      g.fillRect(53,31,5,20);
      g.fillRect(64,31,5,20);
      Grfx.drawThickRectangle(g,20,20,100,60,2);
      g.setColor(Grfx.red);
      g.setFont(new Font("Georgia",Font.BOLD,32));
      g.drawString("Game in construction...",450,350);
   }
   
   public void drawPause(Graphics g)
   {
      g.setColor(Grfx.darkBlue);
      g.fillRect(0,0,windowWidth,windowHeight);
      g.setColor(Grfx.red);
      Grfx.drawThickRectangle(g,560,600,720,680,5);
      g.setFont(new Font("Georgia",Font.BOLD,32));
      g.drawString("Back",600,650);
      g.setColor(Grfx.yellow);
      g.drawString("Game Paused",535,350);
   }
   
   public void drawScoreboard(Graphics g)
   {
      g.setColor(Grfx.darkBlue);
      g.fillRect(0,0,windowWidth,windowHeight);
      g.setColor(Grfx.red);
      Grfx.drawThickRectangle(g,560,600,720,680,5);
      g.setFont(new Font("Georgia",Font.BOLD,32));
      g.drawString("Back",600,650);
      g.setColor(Grfx.yellow);
      g.drawString("Scoreboard",550,80);
   }
   
   public void drawInstructions(Graphics g)
   {
      g.setColor(Grfx.darkBlue);
      g.fillRect(0,0,windowWidth,windowHeight);
      g.setColor(Grfx.red);
      Grfx.drawThickRectangle(g,560,600,720,680,5);
      g.setFont(new Font("Georgia",Font.BOLD,32));
      g.drawString("Back",600,650);
      g.setColor(Grfx.yellow);
      g.drawString("Instructions",545,80);
   }
   
   public void update(Graphics g)
   {
      paint(g);
   }
}