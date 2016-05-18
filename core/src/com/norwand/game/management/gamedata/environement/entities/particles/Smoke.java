package com.norwand.game.management.gamedata.environement.entities.particles;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.entities.Entity;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.DoubleRectangle;

/**
 * Created by Valentin Marechal on 18/05/2016.
 */
public class Smoke extends Entity {

    private int counter;

    public Smoke(Floor roompointer, double x, double y) {
        super(roompointer, x, y);
    }

    @Override
    public void update() {
        ++counter;
        if(counter >= 40)
            kill();
    }

    @Override
    public Pixmap getCurrentSprite() {
        return ImagesHolder.entityset.getTile(2650 + counter/10);
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
