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
public class Drake extends Monster {
    public Drake(Floor roompointer, double x, double y) {
        super(roompointer, x, y);
    }
    private int nextjumpin = 270;
    private int spritecounter = 10;
    private MathVector jumpdirection;

    @Override
    public void update() {
        --nextjumpin;
        if(nextjumpin == 0){
            jumpdirection = new MathVector(GameData.get().player.x - posX, GameData.get().player.y - posY);
        }else if(nextjumpin < -20){
            nextjumpin = 270;
        }
        if (nextjumpin < 0){
            Position temp = jumpdirection.getFixedTranslation(posX, posY, 0.15);
            if (canBeAt(temp.x, temp.y)) {
                posX = temp.x;
                posY = temp.y;
            }
        }
        --spritecounter;
        if (spritecounter < 0)
            spritecounter = 50;
        if(knockback())
            GameData.get().player.info.health -= 2;

    }

    @Override
    public Pixmap getCurrentSprite() {
        if(nextjumpin < 0)
            return ImagesHolder.entityset.getTile(1983);
        return ImagesHolder.entityset.getTile((spritecounter < 25) ? 1975 : 1983);
    }

    @Override
    public void onAct() {

    }

    @Override
    public DoubleRectangle getHitbox(double posX, double posY) {
        return new DoubleRectangle(posX - 0.35, posY - 0.35, 0.8, 0.8);
    }

    @Override
    public void onhit(double damage) {
        kill();
    }
}
