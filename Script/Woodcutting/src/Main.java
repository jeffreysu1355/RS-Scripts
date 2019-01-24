import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.wrappers.interactive.GameObject;

/**
 * Created by jeffreysu on 1/23/19.
 */
@ScriptManifest(
        author = "yoyowuz",
        description = "asdf",
        category = Category.WOODCUTTING,
        version = 0.01,
        name = "asdf"
)
public class Main extends AbstractScript{
    @Override
    public int onLoop() {
        if (getInventory().isFull()){
            getInventory().dropAll("Logs");
            sleep(Calculations.random(400,500));
        }else{
            GameObject tree = getGameObjects().closest("Tree");
            if (tree != null){
                tree.interact("Chop down");
                sleep(Calculations.random(400,1000));

                sleepUntil(() -> !getLocalPlayer().isAnimating(), 15000);
            }
        }
        return 500;
    }
}
