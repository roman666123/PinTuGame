package PinTuGame;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.*;
import java.util.Random;

public class BeginJFrame extends JFrame implements KeyListener, ActionListener {
    private int x = 0, y = 0;
    private int[][] temp2 = new int[4][4];
    private String path = "image\\animal\\animal3\\";
    private Boolean stark = false;
    private int[][] win = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};

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
        int[] temp = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random rd = new Random();
        //乱序数组,使数据乱序
        for (int i = 0; i < temp.length; i++) {
            int ha, hei = rd.nextInt(0, 16);
            ha = temp[i];
            temp[i] = temp[hei];
            temp[hei] = ha;
        }
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp2[i][j] = temp[count];
                count += 1;
                if (temp2[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }
        // 加载图片
        LoadingImages(temp2);
    }

    private void LoadingImages(int[][] temp) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ImageIcon i1 = new ImageIcon(path + temp[i][j] + ".jpg");
                JLabel jb = new JLabel(i1);
                jb.setBounds(j * 105 + 80, i * 105 + 100, 105, 105);
                //添加边框
                jb.setBorder(new BevelBorder(0));
                this.getContentPane().add(jb);
            }
        }
        JLabel jb = new JLabel(new ImageIcon("image\\background.png"));
        jb.setBounds(36, 6, 508, 560);
        this.getContentPane().add(jb);
        JLabel step = new JLabel("步数:" + stepcount);
        step.setBounds(500, 20, 100, 20);
        this.getContentPane().add(step);
    }

    int stepcount = 0;
    JMenuItem ji1 = new JMenuItem("重新游戏");
    JMenuItem ji2 = new JMenuItem("重新登陆");
    JMenuItem ji3 = new JMenuItem("关闭游戏");
    JMenuItem ji4 = new JMenuItem("公众号");

    private void initBar() {
        JMenuBar jb = new JMenuBar();
        JMenu jm = new JMenu("功能");
        JMenu jm1 = new JMenu("快捷键");
        JMenu jm2 = new JMenu("关于我们");
//        JMenuItem ji = new JMenuItem("更换图片");
        //向上添加条目到相应的位置上面
//        jm.add(ji);
        jm.add(ji1);
        jm.add(ji2);
        jm.add(ji3);
        jm2.add(ji4);
        //给相关条目添加动作监听事件
        ji1.addActionListener(this);
        ji2.addActionListener(this);
        ji3.addActionListener(this);
        ji4.addActionListener(this);
        //添加到jb上面
        jb.add(jm);
        jb.add(jm1);
        jb.add(jm2);
        //设置界面菜单
        this.setJMenuBar(jb);
    }

    private void initWindow() {
        this.setSize(600, 680);
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
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            this.getContentPane().removeAll();
            int[][] temp = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
            LoadingImages(temp);
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int choice = e.getKeyCode();
        this.getContentPane().removeAll();
        int judge = 0;
        if (stark) return;
        else {
            switch (choice) {
                case 37:
                    System.out.println("向左移动");
                    judge = y + 1;
                    if (judge >= 0 && judge < 4) {
                        temp2[x][y] = temp2[x][y + 1];
                        temp2[x][y + 1] = 0;
                        y++;
                        stepcount++;
                    }
                    break;
                case 38:
                    judge = x + 1;
                    if (judge >= 0 && judge < 4) {
                        System.out.println("向上移动");
                        temp2[x][y] = temp2[x + 1][y];
                        temp2[x + 1][y] = 0;
                        x++;
                        stepcount++;
                    }
                    break;
                case 39:
                    judge = y - 1;
                    if (judge >= 0 && judge < 4) {
                        System.out.println("向右移动");
                        temp2[x][y] = temp2[x][y - 1];
                        temp2[x][y - 1] = 0;
                        y--;
                        stepcount++;
                    }
                    break;
                case 40:
                    judge = x - 1;
                    if (judge >= 0 && judge < 4) {
                        System.out.println("向下移动");
                        temp2[x][y] = temp2[x - 1][y];
                        temp2[x - 1][y] = 0;
                        x--;
                        stepcount++;
                    }
                    break;
                case 65:
                    break;
                case 87:
                    temp2 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
                    break;
            }
            if (judge()) {
                JLabel jl = new JLabel(new ImageIcon("image\\win.png"));
                jl.setBounds(200, 270, 197, 73);
                this.getContentPane().add(jl);
                LoadingImages(temp2);
                this.getContentPane().repaint();
                stark = true;
                return;
            }
            LoadingImages(temp2);
            this.getContentPane().repaint();
        }
    }


    private boolean judge() {
        for (int i = 0; i < temp2.length; i++) {
            for (int j = 0; j < temp2.length; j++) {
                if (temp2[i][j] != win[i][j]) return false;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();
        if (ob == ji1) {
            //计步器清零
            stepcount =0;
            //胜利判断布尔变量进行重置
            stark = false;
            this.getContentPane().removeAll();
            //重新加载图片
            SetPicture();
            this.getContentPane().repaint();
        } else if (ob == ji2) {
            System.out.println("2");
        } else if (ob == ji3) {
            System.out.println("3");
        } else if (ob == ji4) {
            System.out.println("4");
        }
    }
}
