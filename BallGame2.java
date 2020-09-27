
import java.awt.*;
import javax.swing.*;

public class BallGame2 extends JFrame{
	
	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");

	double x = 100;//小球的横坐标
	double y = 100;//小球的纵坐标
	
	
	double degree=3.14/3;//弧度。此处为60度
	
	//话窗口的方法
	public void paint(Graphics g) {
		System.out.println("窗口被画了一次！");
		g.drawImage(desk, 0, 0, null);
		g.drawImage(ball, (int)x, (int)y, null);
		
		x = x+10*Math.cos(degree);
		y = y+10*Math.sin(degree);

		//碰到上下边界
		if(y>500-40-30||y<40+40) {//500是窗口宽度，30是球的直径，40是桌子边框，最后一个40是标题栏的高度
			degree = -degree;
			
		}
		//碰到左右边界兰
		if(x<30||x>856-40-30) {
			degree = 3.14-degree;
		}
	}
	//窗口加载
	void launchFrame() {
		setSize(856,500);
		setLocation(50,50);
		setVisible(true);
		
		
		//重画窗口.每秒画二十五次
		while(true) {
			repaint();
			try {
				Thread.sleep(40);//40ms,1s=1000ms,大约一秒画25次窗口
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("我是梁汉丞，这个项目是个简单的小游戏！");
		BallGame2 game = new BallGame2();
		game.launchFrame();
	}

}
