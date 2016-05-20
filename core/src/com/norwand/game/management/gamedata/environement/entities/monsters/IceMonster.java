package com.norwand.game.management.gamedata.environement.entities.monsters;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.entities.Monster;
import com.norwand.game.management.gamedata.environement.entities.particles.FireBall;
import com.norwand.game.management.gamedata.environement.entities.particles.SpraySnow;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.DoubleRectangle;
import com.norwand.game.utility.objects.MathVector;

/**
 * Created by V-SSK on 17/05/2016.
 */
// add projectile for this monster ( snowballs)
public class IceMonster extends Monster {
    public IceMonster(Floor roompointer, double x, double y) {
        super(roompointer, x, y);
    }
    private int spritecounter = 25;
    private int spraySnow;

    @Override
    public void update() {
        spraySnow++;
        --spritecounter;

        if (spritecounter < 0)
            spritecounter = 50;

        MathVector amv = new MathVector(GameData.get().player.x - posX, GameData.get().player.y - posY);

        if (amv.getBasicLength() < 7 && spraySnow > 30 && spraySnow % 5 == 0)
            spitSpraySnow();

        if(spraySnow > 50)
            spraySnow = 0;
        if(knockback())
            GameData.get().player.info.health -= 0.20;
    }

    @Override
    public Pixmap getCurrentSprite() {
        return ImagesHolder.entityset.getTile((spritecounter < 25) ? 725 : 733);
    }

    @Override
    public void onAct() {

    }

    @Override
    public DoubleRectangle getHitbox(double posX, double posY) {
        return new DoubleRectangle(posX - 0.35, posY - 0.35, 0.7, 0.7);
    }

    @Override
    public void onhit(double damage) {
        kill();
    }

    public void spitSpraySnow() {
        MathVector direction = new MathVector(GameData.get().player.x - posX, GameData.get().player.y - posY);
        roompointer.addEntity(new SpraySnow(roompointer, posX, posY, direction));
    }
}
