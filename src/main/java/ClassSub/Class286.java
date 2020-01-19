package ClassSub;

class Class286 implements Runnable
{
    final Class108 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class286(final Class108 this$0) {
        this.this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        int n = 1;
        int n2 = 0;
        final Class146 currentTrack = Class108.getInstance().getCurrentTrack();
        while (true) {
            final long n3 = (long)Class108.getInstance().getMediaPlayer().getCurrentTime().toMillis();
            try {
                if (n3 <= ((Class127)Class108.getInstance().tLyric.get(n)).getTime()) {
                    if (n2 == 0) {
                        Class287.INSTANCE.tly = ((Class127)Class108.getInstance().tLyric.get(n - 1)).getText();
                    }
                    n2 = 1;
                }
                else {
                    ++n;
                    n2 = 0;
                }
            }
            catch (Exception ex) {
                Class287.INSTANCE.tly = "";
            }
            if (n - 1 > Class108.getInstance().tLyric.size() || Class108.getInstance().getCurrentTrack() != currentTrack || !this.this$0.playTranslateLyric) {
                break;
            }
            try {
                Thread.sleep(50L);
            }
            catch (Exception ex2) {}
        }
    }
}
