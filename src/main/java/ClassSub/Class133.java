package ClassSub;

import net.minecraft.client.*;
import net.minecraft.util.*;
import java.net.*;
import com.mojang.authlib.yggdrasil.*;
import com.mojang.authlib.*;
import com.mojang.authlib.exceptions.*;
import cn.Hanabi.injection.interfaces.*;
import cn.Hanabi.*;

public final class Class133 extends Thread
{
    private Class98 alt;
    private String status;
    private Minecraft mc;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class133(final Class98 alt) {
        super("Alt Login Thread");
        this.mc = Minecraft.func_71410_x();
        this.alt = alt;
        this.status = EnumChatFormatting.GRAY + "Waiting...";
    }
    
    private Session createSession(final String username, final String password) {
        final YggdrasilUserAuthentication yggdrasilUserAuthentication = (YggdrasilUserAuthentication)new YggdrasilAuthenticationService(Proxy.NO_PROXY, "").createUserAuthentication(Agent.MINECRAFT);
        yggdrasilUserAuthentication.setUsername(username);
        yggdrasilUserAuthentication.setPassword(password);
        try {
            yggdrasilUserAuthentication.logIn();
            return new Session(yggdrasilUserAuthentication.getSelectedProfile().getName(), yggdrasilUserAuthentication.getSelectedProfile().getId().toString(), yggdrasilUserAuthentication.getAuthenticatedToken(), "mojang");
        }
        catch (AuthenticationException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public String getStatus() {
        return this.status;
    }
    
    @Override
    public void run() {
        if (this.alt.getPassword().equals("")) {
            ((IMinecraft)Minecraft.func_71410_x()).setSession(new Session(this.alt.getUsername(), "", "", "mojang"));
            this.status = EnumChatFormatting.GREEN + "Logged in. (" + this.alt.getUsername() + " - offline name)";
            return;
        }
        this.status = EnumChatFormatting.AQUA + "Logging in...";
        final Session session = this.createSession(this.alt.getUsername(), this.alt.getPassword());
        if (session == null) {
            this.status = EnumChatFormatting.RED + "Login failed!";
        }
        else {
            Class91.lastAlt = new Class98(this.alt.getUsername(), this.alt.getPassword());
            this.status = EnumChatFormatting.GREEN + "Logged in. (" + session.func_111285_a() + ")";
            this.alt.setMask(session.func_111285_a());
            ((IMinecraft)Minecraft.func_71410_x()).setSession(session);
            try {
                Hanabi.INSTANCE.altFileMgr.getFile(Class169.class).saveFile();
            }
            catch (Exception ex) {}
        }
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
}
