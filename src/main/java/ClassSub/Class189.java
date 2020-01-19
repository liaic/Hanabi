package ClassSub;

import java.util.*;
import java.nio.*;
import java.io.*;

public class Class189 implements Class232
{
    private ArrayList sources;
    private Class232 picked;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class189() {
        super();
        this.sources = new ArrayList();
    }
    
    public void add(final Class232 class232) {
        this.sources.add(class232);
    }
    
    @Override
    public ByteBuffer loadImage(final InputStream inputStream) throws IOException {
        return this.loadImage(inputStream, false, null);
    }
    
    @Override
    public ByteBuffer loadImage(final InputStream inputStream, final boolean b, final int[] array) throws IOException {
        return this.loadImage(inputStream, b, false, array);
    }
    
    @Override
    public ByteBuffer loadImage(final InputStream inputStream, final boolean b, final boolean b2, final int[] array) throws IOException {
        final Class64 class64 = new Class64();
        ByteBuffer loadImage = null;
        final BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, inputStream.available());
        bufferedInputStream.mark(inputStream.available());
        int i = 0;
        while (i < this.sources.size()) {
            bufferedInputStream.reset();
            try {
                final Class232 picked = (Class232)this.sources.get(i);
                loadImage = picked.loadImage(bufferedInputStream, b, b2, array);
                this.picked = picked;
            }
            catch (Exception ex) {
                Class121.warn(this.sources.get(i).getClass() + " failed to read the data", ex);
                class64.addException(ex);
                ++i;
                continue;
            }
            break;
        }
        if (this.picked == null) {
            throw class64;
        }
        return loadImage;
    }
    
    private void checkPicked() {
        if (this.picked == null) {
            throw new RuntimeException("Attempt to make use of uninitialised or invalid composite image data");
        }
    }
    
    @Override
    public int getDepth() {
        this.checkPicked();
        return this.picked.getDepth();
    }
    
    @Override
    public int getHeight() {
        this.checkPicked();
        return this.picked.getHeight();
    }
    
    @Override
    public ByteBuffer getImageBufferData() {
        this.checkPicked();
        return this.picked.getImageBufferData();
    }
    
    @Override
    public int getTexHeight() {
        this.checkPicked();
        return this.picked.getTexHeight();
    }
    
    @Override
    public int getTexWidth() {
        this.checkPicked();
        return this.picked.getTexWidth();
    }
    
    @Override
    public int getWidth() {
        this.checkPicked();
        return this.picked.getWidth();
    }
    
    @Override
    public void configureEdging(final boolean b) {
        for (int i = 0; i < this.sources.size(); ++i) {
            ((Class232)this.sources.get(i)).configureEdging(b);
        }
    }
}
