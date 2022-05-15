package com.sxt.obj;

import com.sxt.GameWin;

import java.awt.*;

public class EnemyObj extends GmaeObj {
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public EnemyObj() {
        super();
    }

    public EnemyObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
