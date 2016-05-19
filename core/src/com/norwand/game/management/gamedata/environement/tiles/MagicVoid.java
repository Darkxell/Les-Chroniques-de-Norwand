package com.norwand.game.management.gamedata.environement.tiles;

import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.AnimatedSprite;

/**
 * Created by Alex on 19/05/2016.
 */
public class MagicVoid extends Tile {

    /**The time left fefore the tile decay.*/
    private int decay = 25;
    /**X position of the tile in the floor*/
    private int px;
    /**Y position of the tile in the floor*/
    private int py;
    /**Backuptile before the magicvanish.*/
    private Tile backuptile;

    /**Builds a new MagicIce tile.*/
    public MagicVoid(int x,int y,Tile backup){
        super(TYPE_VOID,null,null);
        px = x;
        py = y;
        backuptile = backup;
        background = new AnimatedSprite[] { ImagesHolder.tileset.getTileAnimation(1185) };
        foreground = null;
    }

    @Override
    public void update(){
        //super.update();
        --decay;
        if(decay<0){
            GameData.get().currentfloor.setTileAt(px, py, backuptile);
        }
    }
}
