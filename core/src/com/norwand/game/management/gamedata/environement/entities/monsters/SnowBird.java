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
public class SnowBird extends Monster {
    public SnowBird(Floor roompointer, double x, double y) {
        super(roompointer, x, y);
    }
    private int spritecounter = 10;
    private MathVector direction;
    @Override
    public void update() {

        direction = new MathVector(GameData.get().player.x - posX, GameData.get().player.y - posY);
        if (direction.getBasicLength() < 6) {
            Position temp = direction.getFixedTranslation(posX, posY, (spritecounter > 15) ? 0.02 : 0.06);
            posX = temp.x;
            posY = temp.y;
        }
        --spritecounter;
        if (spritecounter < 0 )
            spritecounter = 30;
        if(knockback())
            GameData.get().player.info.health -= 0.5;

    }

    @Override
    public Pixmap getCurrentSprite() {
        return ImagesHolder.entityset.getTile((spritecounter < 15) ? 100 : 108);
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
}
