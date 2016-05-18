package com.norwand.game.management.gamedata.environement.entities.particles;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.entities.Entity;
import com.norwand.game.management.gamedata.environement.entities.Monster;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.DoubleRectangle;

/**
 * Created by Valentin Marechal on 18/05/2016.
 */
public class Tornado extends Monster {

    private int counter;

    public Tornado(Floor roompointer, double x, double y) {
        super(roompointer, x, y);
    }

    @Override
    public void update() {
        ++counter;
        if(counter > 50)
            counter = 0;
    }

    @Override
    public Pixmap getCurrentSprite() {
        return ImagesHolder.particleset.getTile((counter < 25) ? 145 : 153);
    }

    @Override
    public void onAct() {

    }

    @Override
    public DoubleRectangle getHitbox(double posX, double posY) {
        return null;
    }

    @Override
    public void onhit(double damage) {

    }
}
