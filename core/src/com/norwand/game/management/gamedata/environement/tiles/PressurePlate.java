package com.norwand.game.management.gamedata.environement.tiles;


import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.AnimatedSprite;

public abstract class PressurePlate extends Tile{

    private boolean ispressed = false;
    private int px;
    private int py;


    public PressurePlate(int x,int y) {
        super(Tile.TYPE_NORMAL, new AnimatedSprite[] { ImagesHolder.tileset.getTileAnimation(250) }, null);
        px = x;
        py = y;
    }

    @Override
    public void update(){
        if(!ispressed && (int)GameData.get().player.x == px && (int)GameData.get().player.y == py){
            background = new AnimatedSprite[] { ImagesHolder.tileset.getTileAnimation(250)};
            onTrigger();
            ispressed = true;
        }

    }

    /**Called when the player steps on the pressure plate.*/
    public abstract void onTrigger();
}
