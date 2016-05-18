package com.norwand.game.management.gamedata.environement.entities;

import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.management.gamedata.player.states.PS_Dash;
import com.norwand.game.management.gamedata.player.states.PS_Knockback;
import com.norwand.game.utility.objects.DoubleRectangle;
import com.norwand.game.utility.objects.MathVector;
import com.norwand.game.utility.objects.Position;

public abstract class Monster extends Entity {

    public Monster(Floor roompointer, double x, double y) {
        super(roompointer, x, y);
    }

    /**
     * Knockback the player from this monster if it collides with the player
     * hitbox. THis doesn't do any damage tho.
     *
     * @return True if the player has been knocked back, false otherwise.
     */
    public boolean knockback() {
        Player p = GameData.get().player;
        DoubleRectangle hitbox = getHitbox(super.posX, super.posY);
        DoubleRectangle pr = p.hitbox.getRectangle(new Position(p.x, p.y));
        if (pr.intersects(hitbox) && !(p.state instanceof PS_Knockback) && !(p.state instanceof PS_Dash)) {
            p.state = new PS_Knockback(p, new MathVector(p.x - super.posX, p.y - super.posY));
            return true;
        }
        return false;
    }
}
