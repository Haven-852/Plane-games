package com.sxt;

import com.sxt.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWin extends JFrame {
    //游戏状态 0未开始 1游戏中 2暂停 3通关失败 4通关成功
    static int state=0;
    public void launch(){
        //设置窗口是否可见
        this.setVisible(true);
        //设置窗口大小
        this.setSize( 600, 600);
        //设置窗口位置
        this.setLocationRelativeTo(null);
        //设置窗口标题
        this.setTitle("飞机大战");

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton()==1 && state==0){
                    state=1;
                    repaint();
                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        if(state==0){
            g.drawImage(GameUtils.bgImg,0,0,null);
            g.drawImage(GameUtils.bossImg,220,120,null);
            g.drawImage(GameUtils.bgImg,270,350,null);
            g.setColor(Color.yellow);
            g.setFont(new Font("仿宋",Font.BOLD,40));
            g.drawString("点击开始游戏",180,300);
        }
        if(state==1){
            g.drawImage(GameUtils.bgImg,0,0,null);
            g.drawImage(GameUtils.bossImg,220,120,null);
            g.drawImage(GameUtils.bgImg,270,350,null);
            g.setColor(Color.yellow);
            g.setFont(new Font("仿宋",Font.BOLD,40));
            g.drawString("开始游戏了",180,300);
        }
    }
    public static void main(String args[]){
        GameWin gameWin=new GameWin();
        gameWin.launch();
    }
}
