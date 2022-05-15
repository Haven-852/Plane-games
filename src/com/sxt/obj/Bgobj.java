package com.sxt.obj;

import com.sxt.GameWin;

import java.awt.*;

public class Bgobj extends GmaeObj {
    public Bgobj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    public Bgobj() {
        super();
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y+=speed;
        if(y>=0){
            y=-2000;
        }
    }
}
