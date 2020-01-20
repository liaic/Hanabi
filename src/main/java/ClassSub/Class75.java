package ClassSub;

public class Class75 extends Class249
{
    public static final String PACKET_ID = "SUDO";
    public final String targetPlayer;
    public final String command;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class75(final String targetPlayer, final String command) {
        super("SUDO::" + targetPlayer + "::" + command, Class298.SEND);
        this.targetPlayer = targetPlayer;
        this.command = command;
    }
    
    public Class75(final String s) {
        this(s.split("::")[1], s.split("::")[2]);
    }
}
