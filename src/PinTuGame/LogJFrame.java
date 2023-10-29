package PinTuGame;

import javax.swing.*;

public class LogJFrame extends JFrame implements VerificationCode{
    private String UserName;
    private String Password;
    public LogJFrame(){
        this.setSize(480,500);
        this.setTitle("拼图小游戏V1.0");
        this.setAlwaysOnTop(true);
    }

}
