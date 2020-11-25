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
class MainCanvas extends Canvas
{
	Image heroImg[][]=new Image[4][3];
	Image currentImg;
	int heroX,heroY;
	int flag;
	public MainCanvas(){
	try
		{
		    for (int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}	
			}
			currentImg=heroImg[3][1];
	        heroX=120;
			heroY=100;
			flag=1;
			}
		catch (IOException e)
		{
			e.printStackTrace();
		}
   }
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);
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
	repaint();
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
