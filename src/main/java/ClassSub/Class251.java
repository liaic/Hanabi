package ClassSub;

import java.util.*;
import java.net.*;
import org.jetbrains.annotations.*;
import net.minecraft.util.*;
import com.mojang.authlib.yggdrasil.*;
import com.mojang.authlib.*;
import net.minecraft.client.*;
import java.awt.*;
import org.lwjgl.input.*;

public class Class251
{
    private static final Random RANDOM;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class251() {
        super();
    }
    
    public static int random(final int n, final int n2) {
        if (n2 <= n) {
            return n;
        }
        return Class251.RANDOM.nextInt(n2 - n) + n;
    }
    
    public static Session createSession(final String username, final String password, @NotNull final Proxy proxy) throws Exception {
        final YggdrasilUserAuthentication yggdrasilUserAuthentication = (YggdrasilUserAuthentication)new YggdrasilAuthenticationService(proxy, "").createUserAuthentication(Agent.MINECRAFT);
        yggdrasilUserAuthentication.setUsername(username);
        yggdrasilUserAuthentication.setPassword(password);
        yggdrasilUserAuthentication.logIn();
        return new Session(yggdrasilUserAuthentication.getSelectedProfile().getName(), yggdrasilUserAuthentication.getSelectedProfile().getId().toString(), yggdrasilUserAuthentication.getAuthenticatedToken(), "mojang");
    }
    
    public static double getDirection() {
        final Minecraft func_71410_x = Minecraft.func_71410_x();
        float field_70177_z = func_71410_x.field_71439_g.field_70177_z;
        if (func_71410_x.field_71439_g.field_70701_bs < 0.0f) {
            field_70177_z += 180.0f;
        }
        float n = 1.0f;
        if (func_71410_x.field_71439_g.field_70701_bs < 0.0f) {
            n = -0.5f;
        }
        else if (func_71410_x.field_71439_g.field_70701_bs > 0.0f) {
            n = 0.5f;
        }
        if (func_71410_x.field_71439_g.field_70702_br > 0.0f) {
            field_70177_z -= 90.0f * n;
        }
        if (func_71410_x.field_71439_g.field_70702_br < 0.0f) {
            field_70177_z += 90.0f * n;
        }
        return Math.toRadians(field_70177_z);
    }
    
    public static Point calculateMouseLocation() {
        final Minecraft func_71410_x = Minecraft.func_71410_x();
        int field_74335_Z = func_71410_x.field_71474_y.field_74335_Z;
        if (field_74335_Z == 0) {
            field_74335_Z = 1000;
        }
        int n;
        for (n = 0; n < field_74335_Z && func_71410_x.field_71443_c / (n + 1) >= 320 && func_71410_x.field_71440_d / (n + 1) >= 240; ++n) {}
        return new Point(Mouse.getX() / n, func_71410_x.field_71440_d / n - Mouse.getY() / n - 1);
    }
    
    static {
        RANDOM = new Random();
    }
}
