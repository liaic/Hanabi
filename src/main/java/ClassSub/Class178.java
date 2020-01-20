package ClassSub;

public class Class178 extends Class249
{
    public static final String PACKET_ID = "WHOIS";
    public final String targetClient;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class178(final String s) {
        super("WHOIS::" + (s.startsWith("WHOIS::") ? s.split("::")[1] : s), Class298.SEND);
        this.targetClient = (s.startsWith("WHOIS::") ? s.split("::")[1] : s);
    }
}
