package com.norwand.game.management.gamedata.environement.entities.monsters;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.entities.Monster;
import com.norwand.game.management.gamedata.environement.entities.particles.BurnDeath;
import com.norwand.game.management.gamedata.environement.entities.particles.DarkAttack;
import com.norwand.game.management.gamedata.environement.entities.particles.FireBall;
import com.norwand.game.management.gamedata.environement.entities.particles.Smoke;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.DoubleRectangle;
import com.norwand.game.utility.objects.MathVector;
import com.norwand.game.utility.objects.Position;

/**
 * Created by V-SSK on 19/05/2016.
 */
public class BossColoseum extends Monster {

    public BossColoseum(Floor roompointer, double x, double y) {
        super(roompointer, x, y);
        hp = 5;
    }

    private int nextjumpin = 100;
    private int spritecounter = 10;
    private MathVector direction;
    private int darkAttack;
    private int fireball;
    private int Form = 464;


    @Override
    public void update() {
        --nextjumpin;
        fireball++;
        darkAttack++;

        MathVector amv = new MathVector(GameData.get().player.x - posX, GameData.get().player.y - posY);

        if (amv.getBasicLength() < 7 && fireball%5 == 0 && fireball >= 60 && (Form == 464 || Form == 472))
            spitFireBall();
        else if (amv.getBasicLength() < 7  &&  darkAttack == 25  && (Form == 466 || Form == 474))
            spitDarkAttack();
        if (amv.getBasicLength() < 7 && fireball%5 == 0 && fireball >= 50 && (Form == 466 || Form == 474))
            spitFireBall();

        if (fireball > 60 && darkAttack > 85) {
            fireball = 0;
            darkAttack = 0;
        }

        if (nextjumpin == 0 && (Form == 464 || Form == 472)) {
            direction = new MathVector(GameData.get().player.x - posX, GameData.get().player.y - posY);
        } else if (nextjumpin < -20) {
            nextjumpin = 100;
        }
        if (nextjumpin < 0 && (Form == 464 || Form == 472)) {
            Position temp = direction.getFixedTranslation(posX, posY, 0.09);
            if (canBeAt(temp.x, temp.y)) {
                posX = temp.x;
                posY = temp.y;
            }
        }
        if (Form == 466 || Form == 474) {
            direction = new MathVector(GameData.get().player.x - posX, GameData.get().player.y - posY);
            Position temp = direction.getFixedTranslation(posX, posY, 0.06);
            posX = temp.x;
            posY = temp.y;
        }

        --spritecounter;
        if (spritecounter < 0)
            spritecounter = 50;
        if (knockback())
            GameData.get().player.info.health -= 0.75;
    }

    @Override
    public Pixmap getCurrentSprite() {
        return ImagesHolder.entityset.getTile((spritecounter < 25) ? Form : Form + 8);
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
        if (hp <= 2 && hp > 0 && (Form == 464 || Form == 472)) {
            Form += 2;
            hp += 4;
            roompointer.addEntity(new Smoke(roompointer, posX, posY));
        }
        if (hp <= 0) {
            kill();
            roompointer.addEntity(new Smoke(roompointer, posX, posY));
        }
    }
    public void spitFireBall() {
        MathVector direction = new MathVector(GameData.get().player.x - posX, GameData.get().player.y - posY);
        roompointer.addEntity(new FireBall(roompointer, posX, posY, direction));
    }

    public void spitDarkAttack() {
        MathVector direction = new MathVector(GameData.get().player.x - posX, GameData.get().player.y - posY);
        roompointer.addEntity(new DarkAttack(roompointer, posX, posY, direction));
    }

}

