package ClassSub;

import net.minecraftforge.fml.relauncher.*;
import com.google.gson.*;
import net.minecraft.client.*;
import net.minecraft.util.*;

@SideOnly(Side.CLIENT)
public class Class213
{
    public static final String PRIMARY_COLOR = "§7";
    public static final String SECONDARY_COLOR = "§1";
    private static final String PREFIX = "§7[§1Hanabi§7] ";
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class213() {
        super();
    }
    
    public static void send(final String s) {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("text", s);
        Minecraft.func_71410_x().field_71439_g.func_145747_a(IChatComponent.Serializer.func_150699_a(jsonObject.toString()));
    }
    
    public static void success(final String s) {
        info(s);
    }
    
    public static void info(final String s) {
        send("§7[§1Hanabi§7] " + s);
    }
    
    public static void showMessageBox(final String s) {
        new Class44(s);
    }
}
