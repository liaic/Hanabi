package ClassSub;

class Class102 extends Class125
{
    final Class0 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class102(final Class0 this$0, final String s, final boolean b) {
        this.this$0 = this$0;
        super(s, b);
    }
    
    @Override
    public void onPress() {
        this.this$0.mod.set(!this.this$0.mod.isEnabled());
        this.this$0.mod.modButton.toggle();
        super.onPress();
    }
}
