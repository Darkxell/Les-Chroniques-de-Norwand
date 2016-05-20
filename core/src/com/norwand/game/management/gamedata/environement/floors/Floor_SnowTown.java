package com.norwand.game.management.gamedata.environement.floors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.FloorData;
import com.norwand.game.management.gamedata.environement.tileentities.allies.PnjCow;
import com.norwand.game.management.gamedata.environement.tileentities.allies.PnjFem;
import com.norwand.game.management.gamedata.environement.tileentities.allies.PnjGuard;
import com.norwand.game.management.gamedata.environement.tileentities.allies.PnjMage;
import com.norwand.game.management.gamedata.environement.tileentities.allies.PnjMasc;
import com.norwand.game.management.gamedata.environement.tileentities.allies.PnjMerchant;
import com.norwand.game.management.gamedata.environement.tileentities.allies.PnjPriestess;
import com.norwand.game.management.gamedata.environement.tileentities.allies.PnjRanger;
import com.norwand.game.management.gamedata.environement.tiles.WarpZone;
import com.norwand.game.management.gamedata.player.Player;

public class Floor_SnowTown extends Floor {
	Music music = Gdx.audio.newMusic(Gdx.files.internal(getMusicPath()));

    public Floor_SnowTown(Player playerpointer) {
	super(new FloorData(Gdx.files.internal(MainGame.ASSETSPATH
		+ "maps/snowvillage.txt")), playerpointer);
		addTileEntity(new PnjMasc(this, 14.5, 17.5, "Pourquoi me parles tu?"));
		addTileEntity(new PnjFem(this, 16.5, 8.5, "Tu est un démon? La vie doit être dure..."));
		addTileEntity(new PnjGuard(this, 32.5, 10.5, "Tu est un démon hein? Tu n'est pas le bienvenu ici, nous avons peur des représailles..."));
		addTileEntity(new PnjMage(this, 18.5, 21.5, "Laisse moi tranquille, ou j'essaie mon nouveau sort sur toi!"));
		addTileEntity(new PnjMerchant(this, 27.5, 9.5, "Je vends des potions, mais pas au démons, le royaume me punirait pour ça..."));
		addTileEntity(new PnjPriestess(this, 20.5, 13.5, "Entre nous, personne n'aime le royaume ici. Prends garde tout de même, nous avons tous peur des représailles."));
		addTileEntity(new PnjCow(this, 25.5, 16.5, "Meuh !"));
		addTileEntity(new PnjRanger(this, 7.5, 7.5, "Je m'entraine pour chasser les monstres! Attention a toi!"));
	setTileAt(34, 12, new WarpZone(getTileAt(34, 12), 1, 11.5) {
		@Override
		public Floor getDestination() {
			return new Floor_WastelandsS(GameData.get().player);
		}
	});

	setTileAt(0, 2,new WarpZone(getTileAt(0, 2), 98, 25.5) {
	    @Override
	    public Floor getDestination() {
		return new Floor_Snow(GameData.get().player);
	    }
	});
    }

	@Override
	public String getDisplayName() {
		return "Village enneigé";
	}

	@Override
	public String getMusicPath() {
		return MainGame.ASSETSPATH + "audio/bgm/allthingsend2.ogg";
	}
}
