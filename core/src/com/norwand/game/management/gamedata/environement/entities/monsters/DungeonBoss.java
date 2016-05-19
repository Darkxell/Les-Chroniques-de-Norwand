package com.norwand.game.management.gamedata.environement.entities.monsters;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.entities.Monster;
import com.norwand.game.management.gamedata.environement.entities.particles.FireBall;
import com.norwand.game.management.gamedata.environement.entities.particles.IceBall;
import com.norwand.game.management.gamedata.environement.entities.particles.LittleTornado;
import com.norwand.game.management.gamedata.environement.entities.particles.Tornado;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.DoubleRectangle;
import com.norwand.game.utility.objects.MathVector;

/**
 * Created by Valentin Marechal on 19/05/2016.
 */
public class DungeonBoss extends Monster {

    private int spritecounter;
    private int tornadocounter;

    private byte state;

    private static final byte state_MoveOnly = 1;
    private static final byte state_SpitIceBall = 2;
    private static final byte state_SpitWaterBall = 3;
    private static final byte state_SpitLaser = 4;

    public DungeonBoss(Floor roompointer, double x, double y) {
        super(roompointer, x, y);
    }

    @Override
    public void update() {
        state = state_SpitIceBall;
        ++spritecounter;
        if(spritecounter >= 50)
            spritecounter = 0;

        switch (state) {
            case state_MoveOnly:
                //todo
                break;
            case state_SpitIceBall:
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                spitIceBall(Math.random()  * 2 - 1, Math.random()  * 2 - 1);
                break;


        }
    }

    public void spitIceBall(double x, double y) {
        MathVector direction = new MathVector(x, y);
        roompointer.addEntity(new IceBall(roompointer, posX, posY, direction));
    }

    @Override
    public Pixmap getCurrentSprite() {
        return ImagesHolder.entityset.getTile((spritecounter < 25) ? 243 : 251);
    }

    @Override
    public void onAct() {

    }

    @Override
    public DoubleRectangle getHitbox(double posX, double posY) {
        return new DoubleRectangle(posX - 0.5, posY - 0.5, 1, 1);
    }

    @Override
    public void onhit(double damage) {

    }
}
