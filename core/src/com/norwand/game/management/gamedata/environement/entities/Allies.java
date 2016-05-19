package com.norwand.game.management.gamedata.environement.entities;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.utility.objects.DoubleRectangle;

/**
 * Created by ASUS on 19/05/2016.
 */
public abstract class Allies extends Entity {
    public Allies(Floor roompointer, double x, double y) {
        super(roompointer, x, y);
    }


}
