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
public class Tree extends Monster {
    public Tree(Floor roompointer, double x, double y) {
        super(roompointer, x, y);
    }

    /**Timer until the next jump of the wolf.
     Can be negative, it means that the wolf is jumping.*/
    private int spritecounter = 50;
    private MathVector direction;

    @Override
    public void update() {
        direction = new MathVector(GameData.get().player.x - posX, GameData.get().player.y - posY);
        Position temp = direction.getFixedTranslation(posX, posY, (direction.getBasicLength() < 2.5)?0.08:0);
        posX = temp.x;
        posY = temp.y;

        --spritecounter;
        if (spritecounter < 0)
            spritecounter = 50;
        if(knockback())
            GameData.get().player.info.health -= 0.5;
    }

    @Override
    public Pixmap getCurrentSprite() {
        if ((direction.getBasicLength() > 2.5))
         return ImagesHolder.tileset.getTile(2889);
        else
            return ImagesHolder.entityset.getTile((spritecounter < 25) ? 1619 : 1627);
    }

    @Override
    public DoubleRectangle getHitbox(double posX, double posY) {
        return new DoubleRectangle(posX - 0.5, posY - 0.5, 1, 1);
    }

    @Override
    public void onhit(double damage) {
        kill();
    }

    @Override
    public void onAct() {
    }// Does nothing

}
