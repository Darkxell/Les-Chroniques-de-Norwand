package com.norwand.game.management.gamedata.environement.tiles;

import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.AnimatedSprite;

public class MagicIce extends Tile{

	/**The time left fefore the tile decay.*/
	private int decay = 150;
	/**X position of the tile in the floor*/
	private int px;
	/**Y position of the tile in the floor*/
	private int py;
	/**Backuptile before the magicfreeze.*/
	private Tile backuptile;
	
	/**Builds a new MagicIce tile.*/
	public MagicIce(int x,int y,Tile backup){
		super(TYPE_ICE,null,null);
		px = x;
		py = y;
		backuptile = backup;
		background = new AnimatedSprite[] { ImagesHolder.tileset.getTileAnimation(184) };;
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
