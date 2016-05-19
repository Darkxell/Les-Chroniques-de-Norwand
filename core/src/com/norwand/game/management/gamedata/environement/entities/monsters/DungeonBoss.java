package com.norwand.game.management.gamedata.environement.entities.monsters;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.entities.Monster;
import com.norwand.game.management.gamedata.environement.entities.particles.FireBall;
import com.norwand.game.management.gamedata.environement.entities.particles.IceBall;
import com.norwand.game.management.gamedata.environement.entities.particles.LittleTornado;
import com.norwand.game.management.gamedata.environement.entities.particles.Tornado;
import com.norwand.game.management.gamedata.player.states.PS_Drown;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.DoubleRectangle;
import com.norwand.game.utility.objects.MathVector;
import com.norwand.game.utility.objects.Position;

/**
 * Created by Valentin Marechal on 19/05/2016.
 */
public class DungeonBoss extends Monster {

    private int spritecounter;
    private int iceballcounter;
    private int nextjumpin = 50;

    private boolean isGoingRight = true;

    private static final byte STATE_MOVEONLY = 1;
    private static final byte STATE_SPITICEBALLSEEP = 2;
    private static final byte STATE_SPITICEBALL = 3;
    private static final byte STATE_GROUNDBREAK = 4;
    private static final byte STATE_SPITWATERBALL = 5;
    private static final byte STATE_SPITLASER = 6;

    private int state = STATE_SPITICEBALL;

    MathVector shotdirection = new MathVector(Math.random() * 2 -1, Math.random());
    MathVector movedirection;
    MathVector gobackposition;
    MathVector jumpdirection;
    MathVector translateposition;

    public DungeonBoss(Floor roompointer, double x, double y) {
        super(roompointer, x, y);
    }

    @Override
    public void update() {
        ++spritecounter;
        if(spritecounter >= 50)
            spritecounter = 0;

        switch (state) {
            case STATE_MOVEONLY :
                //Moves
                movedirection = new MathVector(GameData.get().player.x - posX, GameData.get().player.y - posY);
                Position temp = movedirection.getFixedTranslation(posX, posY, 0.03);
                posX = temp.x;
                posY = temp.y;

                //Jumps
                --nextjumpin;
                if (nextjumpin == 0) {
                    jumpdirection = new MathVector(GameData.get().player.x - posX, GameData.get().player.y - posY);
                } else if (nextjumpin < - (int) (Math.random() * 7 + 10)) {
                    nextjumpin = (int) (Math.random() * 100) + 10;
                }
                if (nextjumpin < 0) {
                    Position temp3 = jumpdirection.getFixedTranslation(posX, posY, 0.2);
                    if (canBeAt(temp3.x, temp3.y)) {
                        posX = temp3.x;
                        posY = temp3.y;
                    }
                }

                //Go back to spawn
                if(knockback())
                    GameData.get().player.info.health -= 0.25;

                if(GameData.get().player.state instanceof PS_Drown) {
                    gobackposition = new MathVector(9.5 - posX, 7.5 - posY);
                    Position temp2 = gobackposition.getFixedTranslation(posX, posY, gobackposition.getBasicLength()/16);
                    posX = temp2.x;
                    posY = temp2.y;
                }

                break;

            case STATE_SPITICEBALLSEEP:
                ++iceballcounter;

                if(posX < 14.5 && isGoingRight) {
                    posX += 0.12;
                    System.out.println("1");
                }
                else if (posX >= 14.5){
                    isGoingRight = false;
                    System.out.println("2");
                }
                if(posX > 4.5 && !isGoingRight) {
                    posX-= 0.12;
                    System.out.println("3");
                }
                else if(posX <= 4.5) {
                    isGoingRight = true;
                    System.out.println("4");
                }

                if(iceballcounter >= 20) {
                    iceballcounter = 1;
                    shotdirection = new MathVector(/*Math.random() * 2 -1, Math.random()*/0,1);
                }

                if (iceballcounter  % 9 == 0)
                    spitIceBall(shotdirection.x, shotdirection.y);
                break;

            case STATE_SPITICEBALL:
                ++iceballcounter;

                shotdirection = new MathVector(Math.random() * 2 -1, Math.random());

                if(iceballcounter >= 20)
                    iceballcounter = 1;

                if (iceballcounter  < 7)
                    spitIceBall(shotdirection.x, shotdirection.y);

            case STATE_GROUNDBREAK:


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
