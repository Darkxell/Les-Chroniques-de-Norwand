package com.norwand.game.management.gamedata.environement.entities.monsters;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.entities.Monster;
import com.norwand.game.management.gamedata.environement.entities.particles.DarkAttack;
import com.norwand.game.management.gamedata.environement.entities.particles.FireBall;
import com.norwand.game.management.gamedata.environement.entities.particles.Smoke;
import com.norwand.game.management.gamedata.environement.entities.particles.Tornado;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.DoubleRectangle;
import com.norwand.game.utility.objects.MathVector;
import com.norwand.game.utility.objects.Position;

/**
 * Created by V-SSK on 20/05/2016.
 */
public class MiniSnowBoss extends Monster {

    public MiniSnowBoss(Floor roompointer, double x, double y) {
        super(roompointer, x, y);
        hp = 5;
    }

    private int nextjumpin = 100;
    private int spritecounter = 10;
    private MathVector direction;
    private int tornado;



    @Override
    public void update() {
        --nextjumpin;
       tornado++;

        MathVector amv = new MathVector(GameData.get().player.x - posX, GameData.get().player.y - posY);

        if (amv.getBasicLength() < 6 && tornado%5 == 0 && tornado >= 60 )
            spitTornado();


        if (tornado > 100) {
            tornado = 0;

        }






        --spritecounter;
        if (spritecounter < 0)
            spritecounter = 50;
        if (knockback())
            GameData.get().player.info.health -= 0;
    }

    @Override
    public Pixmap getCurrentSprite() {
        return ImagesHolder.entityset.getTile((spritecounter < 25) ? 1168 : 1176);
    }

    @Override
    public void onAct() {

    }

    @Override
    public DoubleRectangle getHitbox(double posX, double posY) {
        return new DoubleRectangle(posX - 0.4, posY - 0.4, 0.8, 0.8);
    }

    @Override
    public void onhit(double damage) {
        hp -= damage;

        if (hp <= 0) {
            kill();
            roompointer.addEntity(new Smoke(roompointer, posX, posY));
        }
    }
    public void spitTornado() {
        MathVector direction = new MathVector(GameData.get().player.x - posX, GameData.get().player.y - posY);
        roompointer.addEntity(new Tornado(roompointer, posX, posY, direction));
    }



}
