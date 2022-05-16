package com.sxt;

import com.sxt.obj.*;
import com.sxt.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWin extends JFrame {
    //��Ϸ״̬ 0δ��ʼ 1��Ϸ�� 2��ͣ 3ͨ��ʧ�� 4ͨ�سɹ�
    public static int state=0;

    Image offScreenImage =null;
    int width=600;
    int height=600;
    //��Ϸ���ػ����
    int count=1;
    //�л���������
    int enemyCount=0;
    //��Ϸ�÷�
    public static int score=0;
    //����ͼ����
    Bgobj bgObj=new Bgobj(GameUtils.bgImg,0,-2000,2);
    //�ҷ��ɻ�����
    public PlaneObj planeObj=new PlaneObj(GameUtils.planeImg,290,550,20,30,0,this);
    //�з�boss����
    public BossObj bossObj=null;
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
        //��ͣ
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==32){
                    switch (state){
                        case 1:
                            state=2;
                            break;
                        case 2:
                            state=1;
                            break;
                            default:
                    }
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
            GameUtils.drawWord(gImage,"�����ʼ��Ϸ",Color.yellow,40,180,300);

        }
        if(state==1){
            GameUtils.gameObjList.addAll(GameUtils.explodeObjList);
            for(int i=0;i<GameUtils.gameObjList.size();i++){
                GameUtils.gameObjList.get(i).paintSelf(gImage);
            }
            GameUtils.gameObjList.removeAll(GameUtils.removeList);
        }
        if(state==3){
            //��Ϸʧ��
            gImage.drawImage(GameUtils.explodeImg,planeObj.getX()-35,planeObj.getY()-50,null);
            GameUtils.drawWord(gImage,"GAME��OVER",Color.red,50,180,300);
        }
        if(state==4){
            //��Ϸͨ��
            gImage.drawImage(GameUtils.explodeImg,bossObj.getX()+30,bossObj.getY(),null);
            GameUtils.drawWord(gImage,"��Ϸͨ��",Color.green,50,190,300);
        }
        GameUtils.drawWord(gImage,score+"��",Color.green,40,30,100);
        g.drawImage(offScreenImage,0,0,null);
        count++;
        System.out.println(GameUtils.gameObjList.size());
    }
    void createObj(){
        //�ҷ��ӵ�
        if(count%15==0){
            GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImg,planeObj.getX()+3,planeObj.getY()-16,14,29,5,this));
            GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size()-1));
        }
        if(count%15==0){
            //�л�������
            GameUtils.enemyObjList.add(new EnemyObj(GameUtils.enemyImg,(int)((Math.random()*12)*50),0,49,36,5,this));
            GameUtils.gameObjList.add(GameUtils.enemyObjList.get(GameUtils.enemyObjList.size()-1));
            enemyCount++;
        }
        //boss�ӵ�
        if(count%15==0&&bossObj!=null){
            GameUtils.bulletObjList.add(new BulletObj(GameUtils.bulletImg,bossObj.getX()+76,bossObj.getY()+85,15,25,5,this));
            GameUtils.gameObjList.add(GameUtils.bulletObjList.get(GameUtils.bulletObjList.size()-1));
        }
        if(enemyCount>100&&bossObj==null){
            bossObj=new BossObj(GameUtils.bossImg,250,35,155,100,5,this);
            GameUtils.gameObjList.add(bossObj);
        }
    }
    public static void main(String args[]){
        GameWin gameWin=new GameWin();
        gameWin.launch();
    }
}
