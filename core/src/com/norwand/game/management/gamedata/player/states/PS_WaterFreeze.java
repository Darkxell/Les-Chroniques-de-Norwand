package com.norwand.game.management.gamedata.player.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.tiles.MagicIce;
import com.norwand.game.management.gamedata.environement.tiles.Tile;
import com.norwand.game.management.gamedata.player.Capacity;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.management.gamedata.player.PlayerState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.Position;

/**
 * Created by Valentin Marechal on 19/05/2016.
 */
public class PS_WaterFreeze extends PlayerState {
    Sound sound = Gdx.audio.newSound(Gdx.files.internal(MainGame.ASSETSPATH + "audio/sfx/ice_break.ogg"));
    private boolean isPlayed = false;

    /**
     * Constructs a new PlayerState using the link to the player.
     *
     * @param player
     */
    public PS_WaterFreeze(Player player, Position cappos) {
        super(player);
        pos = cappos;
    }

    private int counter = 4;
    private Position pos;

    @Override
    public void update() {
        --counter;
        if (counter < 0)
            player.state = new PS_Iddle(player);

        if (counter == 3) {
            for(int i = -1 ; i <= 1 ; ++i)
                for(int j = -1 ; j <= 1 ; ++j)
                    freezeTile(pos.x + i, pos.y + j);
        }

    }

    private void freezeTile(double x, double y) {
        Tile t = GameData.get().currentfloor.getTileAt((int) x, (int) y);

        if (t.type == Tile.TYPE_WATER) {
            if (!isPlayed) {
                sound.play(1.0f);
                isPlayed = true;
            }
            GameData.get().currentfloor.setTileAt((int) x, (int) y, new MagicIce((int) x, (int) y, t));
        }

    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.playerset.getTile(40);
    }

    @Override
    public void onTap(Position pos) {

    }

    @Override
    public void onMoveTo(Position pos) {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onSkillUsed(Position pos, Capacity capacity) {

    }
}
