package ClassSub;

public class Class121 extends Class249
{
    public static final String PACKET_ID = "INGAMENAME";
    public final String inGamename;
    public final boolean isClientFriend;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class121(final String inGamename, final String s) {
        super("INGAMENAME::" + inGamename + "::" + s, Class298.SEND);
        this.inGamename = inGamename;
        this.isClientFriend = s.equals("true");
    }
    
    public Class121(final String s) {
        this(s.split("::")[1], s.split("::")[2]);
    }
}
