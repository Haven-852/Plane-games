package com.sxt;

import com.sxt.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWin extends JFrame {
    //��Ϸ״̬ 0δ��ʼ 1��Ϸ�� 2��ͣ 3ͨ��ʧ�� 4ͨ�سɹ�
    static int state=0;
    public void launch(){
        //���ô����Ƿ�ɼ�
        this.setVisible(true);
        //���ô��ڴ�С
        this.setSize( 600, 600);
        //���ô���λ��
        this.setLocationRelativeTo(null);
        //���ô��ڱ���
        this.setTitle("�ɻ���ս");

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
            g.setFont(new Font("����",Font.BOLD,40));
            g.drawString("�����ʼ��Ϸ",180,300);
        }
        if(state==1){
            g.drawImage(GameUtils.bgImg,0,0,null);
            g.drawImage(GameUtils.bossImg,220,120,null);
            g.drawImage(GameUtils.bgImg,270,350,null);
            g.setColor(Color.yellow);
            g.setFont(new Font("����",Font.BOLD,40));
            g.drawString("��ʼ��Ϸ��",180,300);
        }
    }
    public static void main(String args[]){
        GameWin gameWin=new GameWin();
        gameWin.launch();
    }
}
