package space.codekingdoms.lightmagi.hungergames;

import com.codekingdoms.nozzle.base.BasePlayer;
import org.bukkit.Sound;
import org.bukkit.GameMode;

public class Player extends BasePlayer {
    
    public void onDeath() {
        
        setGameMode(GameMode.SPECTATOR);
        getGame().checkGameOver();
        getGame().playSound(Sound.ENTITY_LIGHTNING_THUNDER);
    
    }
    
    public void onJoin() {
        
        if (getGame().gamePhase > 1) {
            
            setGameMode(GameMode.SPECTATOR);
            sendMessage("There's already a game in progress! You've been made a spectator!");
            
        }
        
        else {
            
            getGame().movePlayerToSpawn(this);
            
        }
        
    
    }
    
    public void startPlaying() {
        
        setGameMode(GameMode.ADVENTURE);
        clearInventory();
        setFoodLevel(20);
        setHealth(20);
        canMove = false;
    
    }
    
    
}