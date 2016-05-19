package com.norwand.game.management.gamedata.environement.entities.particles;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.entities.Monster;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.DoubleRectangle;
import com.norwand.game.utility.objects.MathVector;
import com.norwand.game.utility.objects.Position;

/**
 * Created by V-SSK on 19/05/2016.
 */
public class DarkAttack extends Monster {
    private int counter;
    private MathVector direction;

    public DarkAttack(Floor roompointer, double x, double y, MathVector direction) {
        super(roompointer, x, y);
        this.direction = direction;
    }

    @Override
    public void update() {
        ++counter;
        if(counter > 20)
            counter = 0;

        Position pos = direction.getFixedTranslation(posX, posY, 0.25);
        posX = pos.x;
        posY = pos.y;
        if(!canBeAt(posX, posY))
            kill();

        if(knockback()) {
            GameData.get().player.info.health -= 1;
            kill();
        }
    }

    @Override
    public Pixmap getCurrentSprite() {
        return ImagesHolder.entityset.getTile((counter > 10) ? 747 : 739);
    }

    @Override
    public void onAct() {

    }

    @Override
    public DoubleRectangle getHitbox(double posX, double posY) {
        return new DoubleRectangle(posX - 0.25, posY - 0.25, 0.5, 0.5);
    }

    @Override
    public void onhit(double damage) {

    }


}
