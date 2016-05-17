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
public class DevilEye extends Monster {
    public DevilEye(Floor roompointer, double x, double y) {
        super(roompointer, x, y);
    }
    private int spritecounter = 10;
    private MathVector direction;

    @Override
    public void update() {

        direction = new MathVector(GameData.get().player.x - posX, GameData.get().player.y - posY);
        if (direction.getBasicLength() < 4){
            Position temp = direction.getFixedTranslation(posX, posY, (spritecounter>33)?0.1:0.8);
            posX = temp.x;
            posY = temp.y;
        }

        --spritecounter;
        if (spritecounter < 0 )
            spritecounter = 40;
        if(knockback())
            GameData.get().player.info.health -= 0.25;

    }

    @Override
    public Pixmap getCurrentSprite() {
        return ImagesHolder.entityset.getTile((spritecounter < 25) ? 786 : 794);
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
