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
	int x,y;
	Image downImg,leftImg,upImg,rightImg,currentImg;//�������
	public MainCanvas(){
	try
		{
            downImg=Image.createImage("/sayo10.png");//����
			leftImg=Image.createImage("/sayo12.png");//����
			upImg=Image.createImage("/sayo14.png");//����
			rightImg=Image.createImage("/sayo16.png");//����
			currentImg=downImg;
			x=120;
			y=100;
	}
	catch (IOException e)
		{
	       e.printStackTrace();
	}
   }
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);/*120:x���ꡢ100��y����*/
	
}
public void keyPressed(int keyCode){
    int action=getGameAction(keyCode);
	if(action==LEFT){
	currentImg=leftImg;
	System.out.println("����ת");
	x=x-3;
	}
	if(action==RIGHT){
	currentImg=rightImg;
	System.out.println("����ת");
	x=x+3;
	}
	if(action==UP){
	currentImg=upImg;
	System.out.println("����ת");
	y=y-3;
    }
    if(action==DOWN){
	currentImg=downImg;
	System.out.println("����ת");
	y=y+3;
	}
	repaint();
}
}
