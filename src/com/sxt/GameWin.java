package com.sxt;

import com.sxt.obj.*;
import com.sxt.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWin extends JFrame {
    //��Ϸ״̬ 0δ��ʼ 1��Ϸ�� 2��ͣ 3ͨ��ʧ�� 4ͨ�سɹ�
    static int state=0;

    Image offScreenImage =null;
    int width=600;
    int height=600;
    //��Ϸ���ػ����
    int count=1;

    //����ͼ����
    Bgobj bgObj=new Bgobj(GameUtils.bgImg,0,-2000,2);
    //�ҷ��ɻ�����
    PlaneObj planeObj=new PlaneObj(GameUtils.planeImg,290,550,20,30,0,this);

    public void launch(){
        //���ô����Ƿ�ɼ�
        this.setVisible(true);
        //���ô��ڴ�С
        this.setSize( width, height);
        //���ô���λ��
        this.setLocationRelativeTo(null);
        //���ô��ڱ���
        this.setTitle("�ɻ���ս");
        GameUtils.gameObjList.add(bgObj);
        GameUtils.gameObjList.add(planeObj);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton()==1 && state==0){
                    state=1;
                    repaint();
                }
            }
        });
        while(true){
            if(state==1){
                createObj();
                repaint();
            }

            try{
                Thread.sleep(25);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        if(offScreenImage==null){
            offScreenImage=createImage(width,height);
        }
        Graphics gImage = offScreenImage.getGraphics();
        gImage.fillRect(0,0,width,height);
        if(state==0){
            gImage.drawImage(GameUtils.bgImg,0,0,null);
            gImage.drawImage(GameUtils.bossImg,220,120,null);
            gImage.drawImage(GameUtils.explodeImg,270,350,null);
            gImage.setColor(Color.yellow);
            gImage.setFont(new Font("����",Font.BOLD,40));
            gImage.drawString("�����ʼ��Ϸ",180,300);
        }
        if(state==1){
            for(int i=0;i<GameUtils.gameObjList.size();i++){
                GameUtils.gameObjList.get(i).paintSelf(gImage);
            }

        }
        g.drawImage(offScreenImage,0,0,null);
        count++;
    }
    void createObj(){
        //�ҷ��ӵ�
        if(count%15==0){
            GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImg,planeObj.getX()+3,planeObj.getY()-16,14,29,5,this));
            GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size()-1));
        }
        if(count%15==0){
            GameUtils.enemyObjList.add(new EnemyObj(GameUtils.enemyImg,(int)((Math.random()*12)*50),0,49,36,5,this);
            GameUtils.gameObjList.add(GameUtils.enemyObjList.get(GameUtils.enemyObjList.size()-1));
            
        }
    }
    public static void main(String args[]){
        GameWin gameWin=new GameWin();
        gameWin.launch();
    }
}
