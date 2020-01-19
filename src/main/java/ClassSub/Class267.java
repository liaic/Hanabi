package ClassSub;

class Class267 implements Runnable
{
    final Class108 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class267(final Class108 this$0) {
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
                if (n3 < ((Class127)Class108.getInstance().lyric.get(n)).getTime()) {
                    if (n2 == 0) {
                        Class287.INSTANCE.ly = ((Class127)Class108.getInstance().lyric.get(n - 1)).getText();
                        if (Class108.instance.tLyric.isEmpty()) {
                            try {
                                Class287.INSTANCE.tly = ((Class127)Class108.getInstance().lyric.get(n)).getText();
                            }
                            catch (Exception ex) {
                                Class287.INSTANCE.tly = "";
                            }
                        }
                    }
                    n2 = 1;
                }
                else {
                    ++n;
                    n2 = 0;
                }
            }
            catch (Exception ex2) {
                Class287.INSTANCE.ly = "";
            }
            if (n - 1 > Class108.getInstance().lyric.size() || Class108.getInstance().getCurrentTrack() != currentTrack || !this.this$0.playLyric) {
                break;
            }
            try {
                Thread.sleep(50L);
            }
            catch (Exception ex3) {}
        }
    }
}
