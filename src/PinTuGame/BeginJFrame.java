package PinTuGame;
import javax.swing.*;
import java.util.Random;

public class BeginJFrame extends JFrame{
    public BeginJFrame() {
        //设置界面的宽高
        initWindow();

        //初始化菜单

        initBar();

        //放置图片

        SetPicture();
        this.setVisible(true);

    }

    private void SetPicture() {
        //数组元素乱序处理
        int []temp = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int [][]temp2 =new int[4][4];
        Random rd = new Random();
        rebuildTemp2(temp, temp2, rd);

        for (int i = 0;i< 4;i++){
            for (int j = 0; j < 4; j++) {
                ImageIcon i1 = new ImageIcon("D:\\WorkSpace\\JAVA\\PiniTuGame\\image\\animal\\animal3\\"+temp2[i][j]+".jpg");
                JLabel jb = new JLabel(i1);
                jb.setBounds(j*105,i*105,105,105);
                this.getContentPane().add(jb);
//                this.add(jb);

            }

        }
    }

    private static void rebuildTemp2(int[] temp, int[][] temp2, Random rd) {
        for(int i = 0; i< temp.length; i++){
            int ha ,hei = rd.nextInt(0,16);
            ha = temp[i];
            temp[i] = temp[hei];
            temp[hei] = ha;
        }
        int count = 0;
        for(int i =0;i<4;i++){
            for(int j = 0;j<4;j++){
                temp2[i][j] = temp[count];
                count += 1;
            }
        }
    }

    private void initBar() {
        JMenuBar jb = new JMenuBar();
        JMenu jm = new JMenu("功能");
        JMenu jm1 = new JMenu("快捷键");
        JMenu jm2 = new JMenu("关于我们");
        JMenuItem ji = new JMenuItem("更换图片");
        JMenuItem ji1 = new JMenuItem("重新游戏");
        JMenuItem ji2 = new JMenuItem("重新登陆");
        JMenuItem ji3 = new JMenuItem("关闭游戏");
        JMenuItem ji4 = new JMenuItem("公众号");

        //向上添加条目
        jm.add(ji);
        jm.add(ji1);
        jm.add(ji2);
        jm.add(ji3);
        jm2.add(ji4);

        jb.add(jm);
        jb.add(jm1);
        jb.add(jm2);
        //设置界面菜单
        this.setJMenuBar(jb);
    }

    private void initWindow() {
        this.setSize(600,680);
        //界面的标题设置
        this.setTitle("拼图单机版V1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //取消默认的居中放置,只有取消了才会按照xy轴的形式添加组件
        //隐藏的容器不需要创建对象,这是一个隐藏窗体
        this.setLayout(null);
//        this.setBounds(null);

    }
}
