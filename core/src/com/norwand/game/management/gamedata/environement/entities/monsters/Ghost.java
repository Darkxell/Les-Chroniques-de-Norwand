package com.norwand.game.management.gamedata.environement.entities.monsters;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.entities.Monster;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.DoubleRectangle;
import com.norwand.game.utility.objects.MathVector;
import com.norwand.game.utility.objects.Position;

/**
 * Created by V-SSK on 17/05/2016.
 */
public class Ghost extends Monster {
    public Ghost(Floor roompointer, double x, double y) {
        super(roompointer, x, y);
    }

    private int spritecounter = 70;
    private MathVector direction;

    @Override
    public void update() {
        direction = new MathVector(GameData.get().player.x - posX, GameData.get().player.y - posY);
        Position temp = direction.getFixedTranslation(posX, posY, 0.03);
        posX = temp.x;
        posY = temp.y;
        --spritecounter;
        if (spritecounter < 0)
            spritecounter = 70;
        if(knockback())
            GameData.get().player.info.health -= 0.2;
    }

    @Override
    public Pixmap getCurrentSprite() {
        return ImagesHolder.entityset.getTile((spritecounter < 25) ? 2450 : 2455);
    }

    @Override
    public DoubleRectangle getHitbox(double posX, double posY) {
        return new DoubleRectangle(posX - 0.3, posY - 0.3, 0.6, 0.6);
    }

    @Override
    public void onhit(double damage) {
        kill();
    }

    @Override
    public void onAct() {
    }// Does nothing

}
