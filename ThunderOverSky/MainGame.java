// MainGame

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;

public class MainGame extends Frame
{
   private int windowWidth=1280,windowHeight=720,waveCount;
   private static int score,level;
   private boolean ready,inGame,inInstructions,inPause,gameOver;
   private Image virtualMem,titlePage,background;
   private Graphics gBuffer;
   private Insets insets;
   private Rectangle start,instructions,back,pause,exit;
   private Player player;
   private ArrayList<PlayerBullet> playerBullets;
   private ArrayList<Enemy> enemies;
   
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
      try
      {
         titlePage=ImageIO.read(new File("TitlePage.png"));
         background=ImageIO.read(new File("Background.jpg"));
      }
      catch(Exception e){}
      start=new Rectangle(125,330,300,100);
      instructions=new Rectangle(125,440,300,100);
      back=new Rectangle(560,600,160,80);
      pause=new Rectangle(20,20,80,40);
      exit = new Rectangle(560,500,160,80);
      player=new Player(gBuffer);
      playerBullets=new ArrayList<PlayerBullet>();
      enemies=new ArrayList<Enemy>();
      
      addMouseListener(new MouseAdapter()
      {
         public void mousePressed(MouseEvent e)
         {
            int x=e.getX()-insets.left;
            int y=e.getY()-insets.top;
            if(!inGame&&!inInstructions)
               if(start.contains(x,y)) { 
            	   score = 0;
               	   level=1;
               	   waveCount = 0;
            	   player.reset();
            	   inGame = true;
               }
              
               else if(instructions.contains(x,y))
                  inInstructions=true;
            if(inInstructions && back.contains(x,y))
               inInstructions=false;
            if(inGame&&!inPause&&pause.contains(x,y))
               inPause=true;
            if(inPause && back.contains(x,y))
               inPause=false;
            if(inPause && exit.contains(x,y)) {
            	inPause = false;
            	inInstructions = false;
            	inGame = false;
            	
            	try
                {
                   titlePage=ImageIO.read(new File("TitlePage.png"));
                   background=ImageIO.read(new File("Background.jpg"));
                }
                catch(Exception f){}
                start=new Rectangle(125,330,300,100);
                instructions=new Rectangle(125,440,300,100);
                back=new Rectangle(560,600,160,80);
                pause=new Rectangle(20,20,80,40);
                exit = new Rectangle(560,500,160,80);
                player=new Player(gBuffer);
                playerBullets=new ArrayList<PlayerBullet>();
                enemies=new ArrayList<Enemy>();
                
            }
            
         }
      });
      
      addKeyListener(new KeyAdapter()
      {
         public void keyPressed(KeyEvent e)
         {
            int key=e.getKeyCode();
            if(inGame&&!inPause)
               if(key==KeyEvent.VK_LEFT)
                  player.move(-20,0);
               else if(key==KeyEvent.VK_RIGHT)
                  player.move(20,0);
               else if(key==KeyEvent.VK_UP)
                  player.move(0,-20);
               else if(key==KeyEvent.VK_DOWN)
                  player.move(0,20);
         }
      });
      ready = true;
   }
   
   public void paint(Graphics g)
   {
      if(ready)
      {
         Graphics g2D=(Graphics2D)g;
         insets=getInsets();
         g2D.translate(insets.left,insets.top);
         if(!inGame&&!inInstructions)
            drawTitlePage(gBuffer);
         if(inGame&&!inPause&&!gameOver)
         {
            drawGame(gBuffer);
            displayScore(gBuffer);
            addEnemies();
            checkGameOver();
            player.shoot();
            playerBullets=player.getBullets();
            for(int k=0;k<playerBullets.size();k++)
            {
               playerBullets.get(k).move();
               playerBullets.get(k).draw();
            }
            player.draw();
            for(int k=0;k<enemies.size();k++)
            {
               enemies.get(k).draw();
               enemies.get(k).checkAlive();
               if(enemies.get(k).isAlive())
                  enemies.get(k).attack(player);
            }
            player.bulletHit(enemies);
         }
         if(gameOver)
            displayGameOver(gBuffer);
         if(inGame&&inPause&&!gameOver)
            drawPause(gBuffer);
         if(inInstructions)
            drawInstructions(gBuffer);
         g.drawImage(virtualMem,0,0,this);
      }
      repaint();
   }
   
   public void drawTitlePage(Graphics g)
   {
      g.drawImage(titlePage,0,0,windowWidth,windowHeight,this);
      g.setColor(new Color(0,0,128));
      g.setFont(new Font("Impact",Font.ITALIC,64));
      g.drawString("OVER THE SKY",100,260);
      g.fillRect(125,330,300,100);
      g.fillRect(125,440,300,100);
      g.setColor(Color.red);
      g.setFont(new Font("Impact",Font.ITALIC,96));
      g.drawString("THUNDER",100,180);
      drawRectangle(g,125,330,425,430,5);
      drawRectangle(g,125,440,425,540,5);
      g.setFont(new Font("Georgia",Font.BOLD,32));
      g.drawString("Click to Start",170,390);
      g.drawString("Instructions",180,500);
   }
   
   public void drawGame(Graphics g)
   {
      g.drawImage(background,0,0,windowWidth,windowHeight,this);
      g.setColor(Color.yellow);
      g.fillRect(20,20,80,40);
      g.setColor(Color.black);
      g.fillRect(53,31,5,20);
      g.fillRect(64,31,5,20);
      drawRectangle(g,20,20,100,60,2);
   }
   
   public void drawPause(Graphics g)
   {
      g.setColor(new Color(0,0,128));
      g.fillRect(0,0,windowWidth,windowHeight);
      g.setColor(Color.red);
      roundRectangle(g,560,600,720,680,10,5);
      g.setFont(new Font("Georgia",Font.BOLD,32));
      g.drawString("Resume",575,650);
      g.setColor(Color.red);
      roundRectangle(g,560,500,720,580,10,5);
      g.setFont(new Font("Georgia",Font.BOLD,32));
      g.drawString("Exit",607,550);
      g.setColor(Color.yellow);
      g.drawString("Game Paused",535,350);
   }
   
   public void drawInstructions(Graphics g)
   {
      g.setColor(new Color(170,127,250));
      g.fillRect(0,0,windowWidth,windowHeight);
      g.setColor(Color.black);
      roundRectangle(g,560,600,720,680,10,5);
      g.setFont(new Font("Baskerville",Font.BOLD,32));
      g.drawString("Back",600,650);
      g.setColor(Color.BLACK);
      g.drawString("Instructions",545,80);
      g.setFont(new Font("Avenir",Font.PLAIN,32));
      g.setColor(new Color(242,211,85));
      g.drawString("In this game, the players need to use arrow keys to move the dragon Benares.", 100, 150);
      g.drawString("Benares can shoot fireballs to attack the two types of enemies.", 100, 200);
      g.drawString("Beware of the health points.", 100, 250);
      g.drawString("The game gets progressively more difficult as the level of games increase.", 100, 350);
      g.drawString("Once Barnes loses all his health points, the game ends.", 100, 300);
   }
   
   public void update(Graphics g)
   {
      paint(g);
   }
   
   public void addEnemies()
   {
      boolean allClear=true;
      for(int k=0;k<enemies.size();k++)
         if(enemies.get(k).isAlive())
            allClear=false;
      if(allClear)
      {
         for(int k=0;k<level+2;k++)
            if(k<(level+2)/2)
               enemies.add(new EnemyB(gBuffer));
            else
               enemies.add(new EnemyA(gBuffer));
         waveCount++;
         if(waveCount==2)
         {
            waveCount=0;
            nextLevel();
         }
      }
   }
   
   public void nextLevel()
   {
      level++;
   }
   
   public static void addPoints()
   {
      score+=100;
   }
   
   public static void displayScore(Graphics g)
   {
      g.setColor(Color.black);
      g.setFont(new Font("Georgia",Font.BOLD,32));
      g.drawString("Level: "+level,850,30);
      g.drawString("Score: "+score,1020,30);
   }
   
   public void checkGameOver()
   {
      if(player.getLife()<=0)
         gameOver=true;
   }
   
   public void displayGameOver(Graphics g)
   {
      g.setColor(Color.red);
      g.setFont(new Font("Georgia",Font.BOLD,32));
      g.drawString("Game Over!",550,350);
   }
   
   public static void drawRectangle(Graphics g,int x1,int y1,int x2,int y2,int thickness)
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
   
   public static void roundRectangle(Graphics g,int x1,int y1,int x2,int y2,int pixels,int thickness)
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
}