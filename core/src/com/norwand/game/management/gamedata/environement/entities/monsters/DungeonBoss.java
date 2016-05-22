package com.norwand.game.management.gamedata.environement.entities.monsters;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.entities.Monster;
import com.norwand.game.management.gamedata.environement.entities.particles.IceBall;
import com.norwand.game.management.gamedata.environement.entities.particles.Smoke;
import com.norwand.game.management.gamedata.environement.tiles.MagicVoid;
import com.norwand.game.management.gamedata.environement.tiles.Tile;
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
    private int nextvanish = 300;

    boolean vanished = false;

    private boolean isGoingRight = true;

    private static final byte STATE_MOVEONLY = 1;
    private static final byte STATE_SPITICEBALLSWEEP = 2;
    private static final byte STATE_SPITICEBALL = 3;
    private static final byte STATE_GROUNDBREAK = 4;
    private static final byte STATE_SPITWATERBALL = 5;
    private static final byte STATE_SPITLASER = 6;

    private byte state = STATE_MOVEONLY;
    private int nextState = 400;

    MathVector shotdirection = new MathVector(Math.random() * 2 - 1, Math.random());
    MathVector movedirection;
    MathVector gobackposition;
    MathVector jumpdirection;

    public DungeonBoss(Floor roompointer, double x, double y) {
        super(roompointer, x, y);
        hp = 6;
    }

    @Override
    public void update() {
        ++spritecounter;

        if (invicibilityFrames > 0)
            invicibilityFrames--;

        if (spritecounter >= 50)
            spritecounter = 0;

        if (new MathVector(GameData.get().player.x - posX, GameData.get().player.y - posY).getBasicLength() > 15)
            return;

        if (knockback())
            GameData.get().player.info.health -= 0.25;

        switch (state) {

            case STATE_MOVEONLY:
                --nextState;

                if (nextState > 0) {
                    executeSTATE_MOVEONLY();
                }
                //transition from 1 state to an other
                else {
                    goTo(9.5, 4.5, 0.1);

                    if (new MathVector(9.5 - posX, 4.5 - posY).getBasicLength() < 0.1) {
                        state = STATE_SPITICEBALLSWEEP;
                        iceballcounter = 0;
                        nextState = generateNextState();
                    }
                }
                break;


            case STATE_SPITICEBALLSWEEP:
                ++iceballcounter;
                --nextState;

                if (nextState > 0) {
                    executeSTATE_SPITICEBALLSWEEP();
                } else {
                    state = STATE_SPITICEBALL;
                    iceballcounter = 0;
                    nextState = generateNextState();
                }

                break;


            case STATE_SPITICEBALL:
                ++iceballcounter;
                --nextState;

                if (nextState > 0) {
                    executeSTATE_SPITICEBALL();
                }

                else {

                    goTo(9.5, 7.5, 0.1);

                    if (new MathVector(9.5 - posX, 7.5 - posY).getBasicLength() < 0.1) {
                        state = STATE_GROUNDBREAK;
                        nextvanish = 300;
                        vanished = false;
                        nextState = generateNextState();
                    }
                }

                break;

            case STATE_GROUNDBREAK:
                --nextState;

                if (nextState > 0) {
                    executeSTATE_GROUNDBREAK();
                } else {
                    state = STATE_MOVEONLY;
                    nextState = generateNextState();
                }
                break;
        }
    }

    private void vanishFloor() {
        for (int i = 4; i < 15; ++i)
            for (int j = 4; j < 12; ++j)
                if (i != 9 || j != 7) {
                    Tile t = GameData.get().currentfloor.getTileAt(i, j);
                    GameData.get().currentfloor.setTileAt(i, j, new MagicVoid(i, j, t));
                }
    }

    /**
     * Function that generates how long the next state will last (expressed in number of frame)
     *
     * @return number of frame the state will long
     */
    int generateNextState() {

        int numberOfFrames = 0;

        switch (state) {

            //the move only state longs between 350 & 450 frames
            case STATE_MOVEONLY:
                numberOfFrames = (400 + (int) Math.random() * 100 - 50);
                break;

            //the spit iceballs sate longs between 300 & 400 fames;
            case STATE_SPITICEBALLSWEEP:
                numberOfFrames = (350 + (int) Math.random() * 100 - 50);
                break;

            //the spit iceballs sate longs between 150 & 250 frames
            case STATE_SPITICEBALL:
                numberOfFrames = (200 + (int) Math.random() * 100 - 50);
                break;

            //the ground break sate longs 500 frames
            case STATE_GROUNDBREAK:
                numberOfFrames = 500;
                break;
        }

        return numberOfFrames;
    }

    /**
     * function that moves the monster on a specified position
     *
     * @param x     value of the x-axis
     * @param y     value of the y-axis
     * @param speed the number of frame per update
     */
    private void goTo(double x, double y, double speed) {
        MathVector direction = new MathVector(x - posX, y - posY);
        Position temp = direction.getFixedTranslation(posX, posY, speed);
        posX = temp.x;
        posY = temp.y;
    }

    private void executeSTATE_MOVEONLY() {
        //follow the player
        goTo(GameData.get().player.x, GameData.get().player.y, 0.03);

        //Jumps
        --nextjumpin;
        if (nextjumpin == 0) {
            jumpdirection = new MathVector(GameData.get().player.x - posX, GameData.get().player.y - posY);
        } else if (nextjumpin < -(int) (Math.random() * 7 + 10)) {
            nextjumpin = (int) (Math.random() * 100) + 10;
        }

        if (nextjumpin < 0) {
            Position temp3 = jumpdirection.getFixedTranslation(posX, posY, 0.2);
            if (canBeAt(temp3.x, temp3.y)) {
                posX = temp3.x;
                posY = temp3.y;
            }
        }

        //Go back to spawn if the player is drowning
        if (GameData.get().player.state instanceof PS_Drown) {
            gobackposition = new MathVector(9.5 - posX, 7.5 - posY);
            Position temp2 = gobackposition.getFixedTranslation(posX, posY, gobackposition.getBasicLength() / 16);
            posX = temp2.x;
            posY = temp2.y;
        }

    }

    private void executeSTATE_SPITICEBALLSWEEP() {
        if (posX < 14.5 && isGoingRight) {
            posX += 0.12;
        } else if (posX >= 14.5) {
            isGoingRight = false;
        }
        if (posX > 4.5 && !isGoingRight) {
            posX -= 0.12;
        } else if (posX <= 4.5) {
            isGoingRight = true;
        }

        if (iceballcounter >= 20) {
            iceballcounter = 0;
            shotdirection = new MathVector(0, 1);
        }

        if (iceballcounter % 10 == 0)
            spitIceBall(shotdirection.x, shotdirection.y);
    }

    private void executeSTATE_SPITICEBALL() {
        shotdirection = new MathVector(Math.random() * 2 - 1, Math.random());

        if (iceballcounter >= 20)
            iceballcounter = 0;

        if (iceballcounter < 7 && !(GameData.get().player.state instanceof PS_Drown))
            spitIceBall(shotdirection.x, shotdirection.y);
    }

    private void executeSTATE_GROUNDBREAK() {
        //longs 500 frames
        --nextvanish;

        if (nextvanish < 150 && nextvanish > 10) {
            GameData.get().player.cam.x += 0.2;
            GameData.get().player.cam.y += 0.2;
        }

        if (nextvanish < 10 && !vanished) {
            vanishFloor();
            vanished = true;
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
        if (invicibilityFrames == 0) {
            invicibilityFrames = 5;
            hp -= damage;
            if (hp <= 0) {
                kill();
                roompointer.addEntity(new Smoke(roompointer, posX, posY));
            }
        }
    }
}
