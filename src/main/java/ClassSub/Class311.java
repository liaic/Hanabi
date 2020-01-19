package ClassSub;

import java.io.*;

class Class311 implements Runnable
{
    final Class146 val$track;
    final Class108 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class311(final Class108 this$0, final Class146 val$track) {
        this.this$0 = this$0;
        this.val$track = val$track;
        super();
    }
    
    @Override
    public void run() {
        Class194.INSTANCE.downLoadSong(this.this$0.musicFolder.getAbsolutePath(), String.valueOf(this.val$track.getId()), Class194.INSTANCE.getDownloadUrl(String.valueOf(this.val$track.getId())));
        final File file = new File(this.this$0.musicFolder, this.val$track.getId() + ".mp3");
        this.this$0.play(this.val$track);
        this.this$0.loadingThread = null;
    }
}
