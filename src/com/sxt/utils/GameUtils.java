package com.sxt.utils;

import com.sxt.obj.EnemyObj;
import com.sxt.obj.GmaeObj;
import com.sxt.obj.ShellObj;

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
    //�л���ͼƬ
    public static Image enemyImg= Toolkit.getDefaultToolkit().getImage("imgs/enemy.png");
    //������Ϸ����ļ���
    public  static  List<GmaeObj> gameObjList=new ArrayList<>();
    //�ҷ��ӵ��ļ���
    public static List<ShellObj> shellObjList=new ArrayList<ShellObj>();
    //�л�����
    public static List<EnemyObj> enemyObjList=new ArrayList<>();

}
