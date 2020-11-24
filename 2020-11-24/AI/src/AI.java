import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas implements Runnable
{
	Thread thread;
	int heroX,heroY,bossX,bossY;
	int flag;
	Image heroImg[][]=new Image[4][3];
	Image currentImg;//定义变量
	Image bossImg;
	public MainCanvas(){
	try
		{
           for (int i=0;i<heroImg.length;i++)
           {
			   for (int j=0;j<heroImg[i].length;j++)
			   {
				   heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
			   }
           }
            bossImg=Image.createImage("/zuzu000.png");
			currentImg=heroImg[3][1];
			heroX=120;
			heroY=100;
			bossX=0;
			bossY=0;
			flag=1;
            thread=new Thread(this);
			thread.start();
	}
	catch (IOException e)
		{
	       e.printStackTrace();
	}
   }
   public void run(){
		while(true){
			try
			{
				Thread.sleep(200);//FPS：屏幕刷新率
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			if(bossX<heroX){
				bossX++;
			}
			else{
				bossX--;
			}

			if(bossY<heroY){
				bossY++;
			}else{
				bossY--;
			}
			repaint();
		}
	}
	public void paint(Graphics g){
		g.setColor(154,255,154);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);/*120:x坐标、100：y坐标*/
	    g.drawImage(bossImg,bossX,bossY,0);
}
public void keyPressed(int keyCode){
    int action=getGameAction(keyCode);
	if(action==LEFT){
	  changePicAndDirection(0);
	  heroX=heroX-3;
	}
	if(action==RIGHT){
	  changePicAndDirection(1);
	  heroX=heroX+3;
	}
	if(action==UP){
	  changePicAndDirection(2);
	  heroY=heroY-3;
    }
    if(action==DOWN){
	  changePicAndDirection(3);
	  heroY=heroY+3;
	}	
}
void changePicAndDirection(int direction){
	  if(flag==1){
	    currentImg=heroImg[direction][0];
	    flag++;
	  }
	  else if(flag==2){
	    currentImg=heroImg[direction][2];
	    flag=1;
	  }
   }
}
