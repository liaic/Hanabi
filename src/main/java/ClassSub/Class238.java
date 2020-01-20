package ClassSub;

public class Class238 extends Class249
{
    public static final String PACKET_ID = "SERVERCHAT";
    public final String message;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class238(final String s, final String message) {
        super("SERVERCHAT::" + message, Class298.RECIEVE);
        this.message = message;
        if (s != null) {
            Class158.LOGGER.log("[Server -> " + s + "]" + message);
        }
    }
    
    public Class238(final String s) {
        this(null, s.split("::")[1]);
    }
}
