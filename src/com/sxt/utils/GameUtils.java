package com.sxt.utils;

import com.sxt.obj.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class GameUtils {
    //����ͼƬ
    public static Image bgImg= Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg");
    //bossͼƬ
    public static Image bossImg= Toolkit.getDefaultToolkit().getImage("imgs/boss.png");
    //��ըͼƬ
    public static Image explodeImg= Toolkit.getDefaultToolkit().getImage("imgs/explode/e6.gif");
    //�ҷ�ս����
    public static Image planeImg= Toolkit.getDefaultToolkit().getImage("imgs/plane.png");
    //�ҷ��ӵ���ͼƬ
    public static Image shellImg= Toolkit.getDefaultToolkit().getImage("imgs/shell.png");
    //�з��ӵ���ͼƬ
    public static Image bulletImg= Toolkit.getDefaultToolkit().getImage("imgs/bullet.png");
    //�л���ͼƬ
    public static Image enemyImg= Toolkit.getDefaultToolkit().getImage("imgs/enemy.png");
    //������Ϸ����ļ���
    public  static  List<GmaeObj> gameObjList=new ArrayList<>();
    //�ҷ��ӵ��ļ���
    public static List<ShellObj> shellObjList=new ArrayList<ShellObj>();
    //�л�����
    public static List<EnemyObj> enemyObjList=new ArrayList<>();
    //Ҫɾ��Ԫ�صļ���
    public static List<GmaeObj> removeList=new ArrayList<>();
    //�з��ӵ��ļ���
    public static List<BulletObj> bulletObjList=new ArrayList<>();
    //�����ַ���������
    public static void drawWord(Graphics gImage,String str,Color color,int size,int x,int y){
        gImage.setColor(color);
        gImage.setFont(new Font("����",Font.BOLD,size));
        gImage.drawString(str, x, y);
    }
    //��ը��ļ���
    public static List<ExplodeObj> explodeObjList=new ArrayList<>();

}
