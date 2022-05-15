package com.sxt.utils;

import com.sxt.obj.EnemyObj;
import com.sxt.obj.GmaeObj;
import com.sxt.obj.ShellObj;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class GameUtils {
    //背景图片
    public static Image bgImg= Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg");
    //boss图片
    public static Image bossImg= Toolkit.getDefaultToolkit().getImage("imgs/boss.png");
    //爆炸图片
    public static Image explodeImg= Toolkit.getDefaultToolkit().getImage("imgs/explode/e6.gif");
    //我方战斗机
    public static Image planeImg= Toolkit.getDefaultToolkit().getImage("imgs/plane.png");
    //我方子弹的图片
    public static Image shellImg= Toolkit.getDefaultToolkit().getImage("imgs/shell.png");
    //敌机的图片
    public static Image enemyImg= Toolkit.getDefaultToolkit().getImage("imgs/enemy.png");
    //所有游戏物体的集合
    public  static  List<GmaeObj> gameObjList=new ArrayList<>();
    //我方子弹的集合
    public static List<ShellObj> shellObjList=new ArrayList<ShellObj>();
    //敌机集合
    public static List<EnemyObj> enemyObjList=new ArrayList<>();

}
