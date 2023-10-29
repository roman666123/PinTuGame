package PinTuGame;
import javax.swing.*;
public class BeginJFrame extends JFrame{
    public BeginJFrame() {
        //设置界面的宽高
        initWindow();

        //初始化菜单

        initBar();


        this.setVisible(true);

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
    }
}
