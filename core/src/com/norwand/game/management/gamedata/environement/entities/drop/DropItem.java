package com.norwand.game.management.gamedata.environement.entities.drop;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.entities.Entity;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.utility.objects.DoubleRectangle;
import com.norwand.game.utility.objects.Position;

/**
 * Created by Valentin Marechal on 19/05/2016.
 */
public abstract class DropItem extends Entity {

    public DropItem(Floor roompointer, double x, double y) {
        super(roompointer, x, y);
    }

    @Override
    public void update() {
        Player p = GameData.get().player;
        DoubleRectangle hitbox = getHitbox(posX, posY);
        DoubleRectangle pr = p.hitbox.getRectangle(new Position(p.x, p.y));

        if(pr.intersects(hitbox)) {
            onPickUp();;
            kill();
        }
    }

    @Override
    public abstract Pixmap getCurrentSprite();

    @Override
    public void onAct() {

    }

    @Override
    public DoubleRectangle getHitbox(double posX, double posY) {
        return new DoubleRectangle(posX - 0.15, posY - 0.15, 0.3, 0.3);
    }

    @Override
    public void onhit(double damage) {

    }

    public abstract void onPickUp();
}
