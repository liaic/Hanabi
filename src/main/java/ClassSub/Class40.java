package ClassSub;

public class Class40<T>
{
    private String text;
    private Class175<T> listener;
    private T object;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class40(final String text, final Class175<T> listener, final T object) {
        super();
        this.text = text;
        this.listener = listener;
        this.object = object;
    }
    
    public String getText() {
        return this.text;
    }
    
    public void setText(final String text) {
        this.text = text;
    }
    
    public Class175<T> getListener() {
        return this.listener;
    }
    
    public void setListener(final Class175<T> listener) {
        this.listener = listener;
    }
    
    public T getObject() {
        return this.object;
    }
    
    public void setObject(final T object) {
        this.object = object;
    }
    
    public void press() {
        if (this.listener != null) {
            this.listener.onClick(this);
        }
    }
}
