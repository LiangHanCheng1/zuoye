
import java.awt.*;
import javax.swing.*;

public class BallGame2 extends JFrame{
	
	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");

	double x = 100;//С��ĺ�����
	double y = 100;//С���������
	
	
	double degree=3.14/3;//���ȡ��˴�Ϊ60��
	
	//�����ڵķ���
	public void paint(Graphics g) {
		System.out.println("���ڱ�����һ�Σ�");
		g.drawImage(desk, 0, 0, null);
		g.drawImage(ball, (int)x, (int)y, null);
		
		x = x+10*Math.cos(degree);
		y = y+10*Math.sin(degree);

		//�������±߽�
		if(y>500-40-30||y<40+40) {//500�Ǵ��ڿ�ȣ�30�����ֱ����40�����ӱ߿����һ��40�Ǳ������ĸ߶�
			degree = -degree;
			
		}
		//�������ұ߽���
		if(x<30||x>856-40-30) {
			degree = 3.14-degree;
		}
	}
	//���ڼ���
	void launchFrame() {
		setSize(856,500);
		setLocation(50,50);
		setVisible(true);
		
		
		//�ػ�����.ÿ�뻭��ʮ���
		while(true) {
			repaint();
			try {
				Thread.sleep(40);//40ms,1s=1000ms,��Լһ�뻭25�δ���
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("��������ة�������Ŀ�Ǹ��򵥵�С��Ϸ��");
		BallGame2 game = new BallGame2();
		game.launchFrame();
	}

}
