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
 * Created by V-SSK on 20/05/2016.
 */
public class SpraySnow extends Monster{
    private int counter;
    private MathVector direction;

    public SpraySnow(Floor roompointer, double x, double y, MathVector direction) {
        super(roompointer, x, y);
        this.direction = direction;
    }

    @Override
    public void update() {
        ++counter;
        if(counter > 50)
            counter = 0;

        Position pos = direction.getFixedTranslation(posX, posY, 0.15);
        posX = pos.x;
        posY = pos.y;
        if(!canBeAt(posX, posY))
            kill();

        if(knockback()) {
            GameData.get().player.info.health -= 0.25;
            kill();
        }
    }

    @Override
    public Pixmap getCurrentSprite() {
        return ImagesHolder.particleset.getTile((counter < 25) ? 100 : 108);
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
