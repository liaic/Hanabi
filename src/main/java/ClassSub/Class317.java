package ClassSub;

class Class317 implements Runnable
{
    final Class146 val$track;
    final Class108 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class317(final Class108 this$0, final Class146 val$track) {
        this.this$0 = this$0;
        this.val$track = val$track;
        super();
    }
    
    @Override
    public void run() {
        if (Class108.instance.isLoop) {
            this.this$0.play(this.val$track);
        }
        else {
            this.this$0.next();
        }
    }
}
