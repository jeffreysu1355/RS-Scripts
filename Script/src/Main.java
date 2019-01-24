import org.dreambot.api.methods.filter.Filter;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.wrappers.interactive.NPC;

/**
 * Created by jeffreysu on 1/23/19.
 */

@ScriptManifest(
        author = "yoyowuz",
        description = "yehaw",
        category = Category.COMBAT,
        version = 0.01,
        name = "yeet"
)
public class Main extends AbstractScript {
    public static final String CHICKEN = "Chicken";
    public static final Filter<NPC> CHICKEN_FILTER = new Filter<NPC>(){
        @Override
        public boolean match(NPC npc){
            if (npc == null){
                return false;
            }
            return npc.getName().equals(CHICKEN) && !npc.isHealthBarVisible();
        }
    };
    @Override
    public int onLoop() {

        if (getLocalPlayer().isInCombat()){

        }else{
            NPC chicken = getNpcs().closest(CHICKEN_FILTER);
            if (chicken != null){
                chicken.interact("Attack");
            }
        }
        return 3000;
    }
}
