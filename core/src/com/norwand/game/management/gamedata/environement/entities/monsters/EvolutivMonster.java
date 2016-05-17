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
public class EvolutivMonster extends Monster {
    public EvolutivMonster(Floor roompointer, double x, double y) {
        super(roompointer, x, y);
    }

    /**Timer until the next jump of the wolf.
     Can be negative, it means that the wolf is jumping.*/
    private int spritecounter = 50;
    private MathVector direction;

    @Override
    public void update() {
        direction = new MathVector(GameData.get().player.x - posX, GameData.get().player.y - posY);
        if (spritecounter > 33){
            Position temp = direction.getFixedTranslation(posX, posY, (direction.getBasicLength() < 3)?0.1:0.03);
            posX = temp.x;
            posY = temp.y;
        }

        --spritecounter;
        if (spritecounter < 0)
            spritecounter = 50;
        if(knockback())
            GameData.get().player.info.health -= 0.5;
    }

    @Override
    public Pixmap getCurrentSprite() {
        return ImagesHolder.entityset.getTile((direction.getBasicLength() < 3) ? 1970 : 1968);
    }

    @Override
    public DoubleRectangle getHitbox(double posX, double posY) {
        return new DoubleRectangle(posX - 0.35, posY - 0.35, 0.7, 0.7);
    }

    @Override
    public void onhit(double damage) {
        kill();
    }

    @Override
    public void onAct() {
    }// Does nothing

}
