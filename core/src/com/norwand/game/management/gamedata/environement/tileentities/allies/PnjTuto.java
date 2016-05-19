package com.norwand.game.management.gamedata.environement.tileentities.allies;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.tileentities.TileEntity;
import com.norwand.game.management.gamedata.environement.tiles.Tile;
import com.norwand.game.management.gamedata.items.Equipable.Armor.LeatherArmor;
import com.norwand.game.management.gamedata.items.Equipable.Boots.LeatherBoots;
import com.norwand.game.management.gamedata.items.Equipable.Helmet.LeatherHelmet;
import com.norwand.game.management.gamedata.items.Equipable.Weapon.Sword.CopperSword;
import com.norwand.game.management.gamedata.player.Inventory;
import com.norwand.game.management.gamestates.top.launched.explore.dialog.DialogState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.AnimatedSprite;
import com.norwand.game.utility.objects.DoubleRectangle;

import static com.norwand.game.resources.ImagesHolder.*;

/**
 * Pnj in the prison to launch the game.
 */
public class PnjTuto extends TileEntity {

    private int sprite_counter;
    private int walkcounter;

    public PnjTuto(Floor roompointer, double x, double y) {
        super(Tile.TYPE_SOLID, roompointer, x, y);
        actable = true;
    }

    @Override
    public void update() {
        ++sprite_counter;
        if (sprite_counter >= 50)
            sprite_counter = 0;
        if(walkcounter>=1)walkcounter++;
        if(walkcounter>1 && walkcounter<12)
            posX -= 0.1;
        if(walkcounter>10 && walkcounter<44)
            posY -= 0.1;
        if(walkcounter>40 && walkcounter<55)
            posX += 0.1;
        if(walkcounter == 20)
            opendoor();
    }

    @Override
    public Pixmap getCurrentSprite() {
        return entityset.getTile((sprite_counter < 25) ? 1793 : 1801);
    }

    @Override
    public void onAct() {
        if(walkcounter==0){
            MainGame.game.state.substate.substate.substate = new DialogState(MainGame.game.state.substate.substate
                    , "Ah, tu te bouges enfin! C'est bientôt ton tour dans l'arène, alors dépèche toi!" +
                    "Voici ton armure, equipe toi dans le menu et va te battre! Ne te fais pas attendre " +
                    "par le public...");
            walkcounter = 1;
            Inventory pointer = GameData.get().player.inventory;
            pointer.addEquipable(new LeatherArmor());
            pointer.addEquipable(new LeatherBoots());
            pointer.addEquipable(new LeatherHelmet());
            pointer.addEquipable(new CopperSword());
        }
        else
            MainGame.game.state.substate.substate.substate = new DialogState(MainGame.game.state.substate.substate
                    , "Ne me dérange pas et va te battre!");

    }

    private void opendoor(){
        roompointer.setTileAt(9,7,new Tile(Tile.TYPE_NORMAL,new AnimatedSprite[] {
                ImagesHolder.tileset.getTileAnimation(225)},null));
    }

    @Override
    public DoubleRectangle getHitbox(double posX, double posY) {
        return new DoubleRectangle(posX - 0.5, posY - 0.5, 1, 1);
    }

    @Override
    public void onhit(double damage) {

    }
}
