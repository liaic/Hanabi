package ClassSub;

import java.io.*;

public class Class140 implements Class270
{
    public static final int TOP_LEFT = 0;
    public static final int TOP_RIGHT = 1;
    public static final int BOTTOM_RIGHT = 2;
    public static final int BOTTOM_LEFT = 3;
    protected static Class12 GL;
    protected static Class140 inUse;
    public static final int FILTER_LINEAR = 1;
    public static final int FILTER_NEAREST = 2;
    protected Class27 texture;
    protected int width;
    protected int height;
    protected float textureWidth;
    protected float textureHeight;
    protected float textureOffsetX;
    protected float textureOffsetY;
    protected float angle;
    protected float alpha;
    protected String ref;
    protected boolean inited;
    protected byte[] pixelData;
    protected boolean destroyed;
    protected float centerX;
    protected float centerY;
    protected String name;
    protected Class278[] corners;
    private int filter;
    private boolean flipped;
    private Class278 transparent;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    protected Class140(final Class140 class140) {
        super();
        this.alpha = 1.0f;
        this.inited = false;
        this.filter = 9729;
        this.width = class140.getWidth();
        this.height = class140.getHeight();
        this.texture = class140.texture;
        this.textureWidth = class140.textureWidth;
        this.textureHeight = class140.textureHeight;
        this.ref = class140.ref;
        this.textureOffsetX = class140.textureOffsetX;
        this.textureOffsetY = class140.textureOffsetY;
        this.centerX = this.width / 2;
        this.centerY = this.height / 2;
        this.inited = true;
    }
    
    protected Class140() {
        super();
        this.alpha = 1.0f;
        this.inited = false;
        this.filter = 9729;
    }
    
    public Class140(final Class27 texture) {
        super();
        this.alpha = 1.0f;
        this.inited = false;
        this.filter = 9729;
        this.texture = texture;
        this.ref = texture.toString();
        this.clampTexture();
    }
    
    public Class140(final String s) throws Class186 {
        this(s, false);
    }
    
    public Class140(final String s, final Class278 class278) throws Class186 {
        this(s, false, 1, class278);
    }
    
    public Class140(final String s, final boolean b) throws Class186 {
        this(s, b, 1);
    }
    
    public Class140(final String s, final boolean b, final int n) throws Class186 {
        this(s, b, n, null);
    }
    
    public Class140(final String ref, final boolean flipped, final int n, final Class278 transparent) throws Class186 {
        super();
        this.alpha = 1.0f;
        this.inited = false;
        this.filter = 9729;
        this.filter = ((n == 1) ? 9729 : 9728);
        this.transparent = transparent;
        this.flipped = flipped;
        try {
            this.ref = ref;
            int[] array = null;
            if (transparent != null) {
                array = new int[] { (int)(transparent.r * 255.0f), (int)(transparent.g * 255.0f), (int)(transparent.b * 255.0f) };
            }
            this.texture = Class6.get().getTexture(ref, flipped, this.filter, array);
        }
        catch (IOException ex) {
            Class121.error(ex);
            throw new Class186("Failed to load image from: " + ref, ex);
        }
    }
    
    public void setFilter(final int n) {
        this.filter = ((n == 1) ? 9729 : 9728);
        this.texture.bind();
        Class140.GL.glTexParameteri(3553, 10241, this.filter);
        Class140.GL.glTexParameteri(3553, 10240, this.filter);
    }
    
    public Class140(final int n, final int n2) throws Class186 {
        this(n, n2, 2);
    }
    
    public Class140(final int n, final int n2, final int n3) throws Class186 {
        super();
        this.alpha = 1.0f;
        this.inited = false;
        this.filter = 9729;
        this.ref = super.toString();
        this.filter = ((n3 == 1) ? 9729 : 9728);
        try {
            this.texture = Class6.get().createTexture(n, n2, this.filter);
        }
        catch (IOException ex) {
            Class121.error(ex);
            throw new Class186("Failed to create empty image " + n + "x" + n2);
        }
        this.init();
    }
    
    public Class140(final InputStream inputStream, final String s, final boolean b) throws Class186 {
        this(inputStream, s, b, 1);
    }
    
    public Class140(final InputStream inputStream, final String s, final boolean b, final int n) throws Class186 {
        super();
        this.alpha = 1.0f;
        this.inited = false;
        this.filter = 9729;
        this.load(inputStream, s, b, n, null);
    }
    
    Class140(final Class139 class139) {
        this(class139, 1);
        Class85.bindNone();
    }
    
    Class140(final Class139 class139, final int n) {
        this((Class106)class139, n);
        Class85.bindNone();
    }
    
    public Class140(final Class106 class106) {
        this(class106, 1);
    }
    
    public Class140(final Class106 class106, final int n) {
        super();
        this.alpha = 1.0f;
        this.inited = false;
        this.filter = 9729;
        try {
            this.filter = ((n == 1) ? 9729 : 9728);
            this.texture = Class6.get().getTexture(class106, this.filter);
            this.ref = this.texture.toString();
        }
        catch (IOException ex) {
            Class121.error(ex);
        }
    }
    
    public int getFilter() {
        return this.filter;
    }
    
    public String getResourceReference() {
        return this.ref;
    }
    
    public void setImageColor(final float n, final float n2, final float n3, final float n4) {
        this.setColor(0, n, n2, n3, n4);
        this.setColor(1, n, n2, n3, n4);
        this.setColor(3, n, n2, n3, n4);
        this.setColor(2, n, n2, n3, n4);
    }
    
    public void setImageColor(final float n, final float n2, final float n3) {
        this.setColor(0, n, n2, n3);
        this.setColor(1, n, n2, n3);
        this.setColor(3, n, n2, n3);
        this.setColor(2, n, n2, n3);
    }
    
    public void setColor(final int n, final float r, final float g, final float b, final float a) {
        if (this.corners == null) {
            this.corners = new Class278[] { new Class278(1.0f, 1.0f, 1.0f, 1.0f), new Class278(1.0f, 1.0f, 1.0f, 1.0f), new Class278(1.0f, 1.0f, 1.0f, 1.0f), new Class278(1.0f, 1.0f, 1.0f, 1.0f) };
        }
        this.corners[n].r = r;
        this.corners[n].g = g;
        this.corners[n].b = b;
        this.corners[n].a = a;
    }
    
    public void setColor(final int n, final float r, final float g, final float b) {
        if (this.corners == null) {
            this.corners = new Class278[] { new Class278(1.0f, 1.0f, 1.0f, 1.0f), new Class278(1.0f, 1.0f, 1.0f, 1.0f), new Class278(1.0f, 1.0f, 1.0f, 1.0f), new Class278(1.0f, 1.0f, 1.0f, 1.0f) };
        }
        this.corners[n].r = r;
        this.corners[n].g = g;
        this.corners[n].b = b;
    }
    
    public void clampTexture() {
        if (Class140.GL.canTextureMirrorClamp()) {
            Class140.GL.glTexParameteri(3553, 10242, 34627);
            Class140.GL.glTexParameteri(3553, 10243, 34627);
        }
        else {
            Class140.GL.glTexParameteri(3553, 10242, 10496);
            Class140.GL.glTexParameteri(3553, 10243, 10496);
        }
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Class116 getGraphics() throws Class186 {
        return Class129.getGraphicsForImage(this);
    }
    
    private void load(final InputStream inputStream, final String ref, final boolean b, final int n, final Class278 class278) throws Class186 {
        this.filter = ((n == 1) ? 9729 : 9728);
        try {
            this.ref = ref;
            int[] array = null;
            if (class278 != null) {
                array = new int[] { (int)(class278.r * 255.0f), (int)(class278.g * 255.0f), (int)(class278.b * 255.0f) };
            }
            this.texture = Class6.get().getTexture(inputStream, ref, b, this.filter, array);
        }
        catch (IOException ex) {
            Class121.error(ex);
            throw new Class186("Failed to load image from: " + ref, ex);
        }
    }
    
    public void bind() {
        this.texture.bind();
    }
    
    protected void reinit() {
        this.inited = false;
        this.init();
    }
    
    protected final void init() {
        if (this.inited) {
            return;
        }
        this.inited = true;
        if (this.texture != null) {
            this.width = this.texture.getImageWidth();
            this.height = this.texture.getImageHeight();
            this.textureOffsetX = 0.0f;
            this.textureOffsetY = 0.0f;
            this.textureWidth = this.texture.getWidth();
            this.textureHeight = this.texture.getHeight();
        }
        this.initImpl();
        this.centerX = this.width / 2;
        this.centerY = this.height / 2;
    }
    
    protected void initImpl() {
    }
    
    public void draw() {
        this.draw(0.0f, 0.0f);
    }
    
    public void drawCentered(final float n, final float n2) {
        this.draw(n - (float)(this.getWidth() / 2), n2 - (float)(this.getHeight() / 2));
    }
    
    @Override
    public void draw(final float n, final float n2) {
        this.init();
        this.draw(n, n2, this.width, this.height);
    }
    
    public void draw(final float n, final float n2, final Class278 class278) {
        this.init();
        this.draw(n, n2, this.width, this.height, class278);
    }
    
    public void drawEmbedded(final float n, final float n2, final float n3, final float n4) {
        this.init();
        if (this.corners == null) {
            Class140.GL.glTexCoord2f(this.textureOffsetX, this.textureOffsetY);
            Class140.GL.glVertex3f(n, n2, 0.0f);
            Class140.GL.glTexCoord2f(this.textureOffsetX, this.textureOffsetY + this.textureHeight);
            Class140.GL.glVertex3f(n, n2 + n4, 0.0f);
            Class140.GL.glTexCoord2f(this.textureOffsetX + this.textureWidth, this.textureOffsetY + this.textureHeight);
            Class140.GL.glVertex3f(n + n3, n2 + n4, 0.0f);
            Class140.GL.glTexCoord2f(this.textureOffsetX + this.textureWidth, this.textureOffsetY);
            Class140.GL.glVertex3f(n + n3, n2, 0.0f);
        }
        else {
            this.corners[0].bind();
            Class140.GL.glTexCoord2f(this.textureOffsetX, this.textureOffsetY);
            Class140.GL.glVertex3f(n, n2, 0.0f);
            this.corners[3].bind();
            Class140.GL.glTexCoord2f(this.textureOffsetX, this.textureOffsetY + this.textureHeight);
            Class140.GL.glVertex3f(n, n2 + n4, 0.0f);
            this.corners[2].bind();
            Class140.GL.glTexCoord2f(this.textureOffsetX + this.textureWidth, this.textureOffsetY + this.textureHeight);
            Class140.GL.glVertex3f(n + n3, n2 + n4, 0.0f);
            this.corners[1].bind();
            Class140.GL.glTexCoord2f(this.textureOffsetX + this.textureWidth, this.textureOffsetY);
            Class140.GL.glVertex3f(n + n3, n2, 0.0f);
        }
    }
    
    public float getTextureOffsetX() {
        this.init();
        return this.textureOffsetX;
    }
    
    public float getTextureOffsetY() {
        this.init();
        return this.textureOffsetY;
    }
    
    public float getTextureWidth() {
        this.init();
        return this.textureWidth;
    }
    
    public float getTextureHeight() {
        this.init();
        return this.textureHeight;
    }
    
    public void draw(final float n, final float n2, final float n3) {
        this.init();
        this.draw(n, n2, (float)this.width * n3, (float)this.height * n3, Class278.white);
    }
    
    public void draw(final float n, final float n2, final float n3, final Class278 class278) {
        this.init();
        this.draw(n, n2, (float)this.width * n3, (float)this.height * n3, class278);
    }
    
    public void draw(final float n, final float n2, final float n3, final float n4) {
        this.init();
        this.draw(n, n2, n3, n4, Class278.white);
    }
    
    public void drawSheared(final float n, final float n2, final float n3, final float n4) {
        this.drawSheared(n, n2, n3, n4, Class278.white);
    }
    
    public void drawSheared(final float n, final float n2, final float n3, final float n4, Class278 white) {
        if (this.alpha != 1.0f) {
            if (white == null) {
                white = Class278.white;
            }
            final Class278 class278;
            white = (class278 = new Class278(white));
            class278.a *= this.alpha;
        }
        if (white != null) {
            white.bind();
        }
        this.texture.bind();
        Class140.GL.glTranslatef(n, n2, 0.0f);
        if (this.angle != 0.0f) {
            Class140.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
            Class140.GL.glRotatef(this.angle, 0.0f, 0.0f, 1.0f);
            Class140.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
        }
        Class140.GL.glBegin(7);
        this.init();
        Class140.GL.glTexCoord2f(this.textureOffsetX, this.textureOffsetY);
        Class140.GL.glVertex3f(0.0f, 0.0f, 0.0f);
        Class140.GL.glTexCoord2f(this.textureOffsetX, this.textureOffsetY + this.textureHeight);
        Class140.GL.glVertex3f(n3, this.height, 0.0f);
        Class140.GL.glTexCoord2f(this.textureOffsetX + this.textureWidth, this.textureOffsetY + this.textureHeight);
        Class140.GL.glVertex3f((float)this.width + n3, (float)this.height + n4, 0.0f);
        Class140.GL.glTexCoord2f(this.textureOffsetX + this.textureWidth, this.textureOffsetY);
        Class140.GL.glVertex3f(this.width, n4, 0.0f);
        Class140.GL.glEnd();
        if (this.angle != 0.0f) {
            Class140.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
            Class140.GL.glRotatef(-this.angle, 0.0f, 0.0f, 1.0f);
            Class140.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
        }
        Class140.GL.glTranslatef(-n, -n2, 0.0f);
    }
    
    public void draw(final float n, final float n2, final float n3, final float n4, Class278 white) {
        if (this.alpha != 1.0f) {
            if (white == null) {
                white = Class278.white;
            }
            final Class278 class278;
            white = (class278 = new Class278(white));
            class278.a *= this.alpha;
        }
        if (white != null) {
            white.bind();
        }
        this.texture.bind();
        Class140.GL.glTranslatef(n, n2, 0.0f);
        if (this.angle != 0.0f) {
            Class140.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
            Class140.GL.glRotatef(this.angle, 0.0f, 0.0f, 1.0f);
            Class140.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
        }
        Class140.GL.glBegin(7);
        this.drawEmbedded(0.0f, 0.0f, n3, n4);
        Class140.GL.glEnd();
        if (this.angle != 0.0f) {
            Class140.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
            Class140.GL.glRotatef(-this.angle, 0.0f, 0.0f, 1.0f);
            Class140.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
        }
        Class140.GL.glTranslatef(-n, -n2, 0.0f);
    }
    
    public void drawFlash(final float n, final float n2, final float n3, final float n4) {
        this.drawFlash(n, n2, n3, n4, Class278.white);
    }
    
    public void setCenterOfRotation(final float centerX, final float centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
    }
    
    public float getCenterOfRotationX() {
        this.init();
        return this.centerX;
    }
    
    public float getCenterOfRotationY() {
        this.init();
        return this.centerY;
    }
    
    public void drawFlash(final float n, final float n2, final float n3, final float n4, final Class278 class278) {
        this.init();
        class278.bind();
        this.texture.bind();
        if (Class140.GL.canSecondaryColor()) {
            Class140.GL.glEnable(33880);
            Class140.GL.glSecondaryColor3ubEXT((byte)(int)(class278.r * 255.0f), (byte)(int)(class278.g * 255.0f), (byte)(int)(class278.b * 255.0f));
        }
        Class140.GL.glTexEnvi(8960, 8704, 8448);
        Class140.GL.glTranslatef(n, n2, 0.0f);
        if (this.angle != 0.0f) {
            Class140.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
            Class140.GL.glRotatef(this.angle, 0.0f, 0.0f, 1.0f);
            Class140.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
        }
        Class140.GL.glBegin(7);
        this.drawEmbedded(0.0f, 0.0f, n3, n4);
        Class140.GL.glEnd();
        if (this.angle != 0.0f) {
            Class140.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
            Class140.GL.glRotatef(-this.angle, 0.0f, 0.0f, 1.0f);
            Class140.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
        }
        Class140.GL.glTranslatef(-n, -n2, 0.0f);
        if (Class140.GL.canSecondaryColor()) {
            Class140.GL.glDisable(33880);
        }
    }
    
    public void drawFlash(final float n, final float n2) {
        this.drawFlash(n, n2, this.getWidth(), this.getHeight());
    }
    
    public void setRotation(final float n) {
        this.angle = n % 360.0f;
    }
    
    public float getRotation() {
        return this.angle;
    }
    
    public float getAlpha() {
        return this.alpha;
    }
    
    public void setAlpha(final float alpha) {
        this.alpha = alpha;
    }
    
    public void rotate(final float n) {
        this.angle += n;
        this.angle %= 360.0f;
    }
    
    public Class140 getSubImage(final int n, final int n2, final int width, final int height) {
        this.init();
        final float textureOffsetX = n / this.width * this.textureWidth + this.textureOffsetX;
        final float textureOffsetY = n2 / this.height * this.textureHeight + this.textureOffsetY;
        final float textureWidth = width / this.width * this.textureWidth;
        final float textureHeight = height / this.height * this.textureHeight;
        final Class140 class140 = new Class140();
        class140.inited = true;
        class140.texture = this.texture;
        class140.textureOffsetX = textureOffsetX;
        class140.textureOffsetY = textureOffsetY;
        class140.textureWidth = textureWidth;
        class140.textureHeight = textureHeight;
        class140.width = width;
        class140.height = height;
        class140.ref = this.ref;
        class140.centerX = width / 2;
        class140.centerY = height / 2;
        return class140;
    }
    
    public void draw(final float n, final float n2, final float n3, final float n4, final float n5, final float n6) {
        this.draw(n, n2, n + (float)this.width, n2 + (float)this.height, n3, n4, n5, n6);
    }
    
    public void draw(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final float n8) {
        this.draw(n, n2, n3, n4, n5, n6, n7, n8, Class278.white);
    }
    
    public void draw(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final float n8, Class278 white) {
        this.init();
        if (this.alpha != 1.0f) {
            if (white == null) {
                white = Class278.white;
            }
            final Class278 class278;
            white = (class278 = new Class278(white));
            class278.a *= this.alpha;
        }
        white.bind();
        this.texture.bind();
        Class140.GL.glTranslatef(n, n2, 0.0f);
        if (this.angle != 0.0f) {
            Class140.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
            Class140.GL.glRotatef(this.angle, 0.0f, 0.0f, 1.0f);
            Class140.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
        }
        Class140.GL.glBegin(7);
        this.drawEmbedded(0.0f, 0.0f, n3 - n, n4 - n2, n5, n6, n7, n8);
        Class140.GL.glEnd();
        if (this.angle != 0.0f) {
            Class140.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
            Class140.GL.glRotatef(-this.angle, 0.0f, 0.0f, 1.0f);
            Class140.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
        }
        Class140.GL.glTranslatef(-n, -n2, 0.0f);
    }
    
    public void drawEmbedded(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final float n8) {
        this.drawEmbedded(n, n2, n3, n4, n5, n6, n7, n8, null);
    }
    
    public void drawEmbedded(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final float n8, final Class278 class278) {
        if (class278 != null) {
            class278.bind();
        }
        final float n9 = n3 - n;
        final float n10 = n4 - n2;
        final float n11 = n7 - n5;
        final float n12 = n8 - n6;
        final float n13 = n5 / this.width * this.textureWidth + this.textureOffsetX;
        final float n14 = n6 / this.height * this.textureHeight + this.textureOffsetY;
        final float n15 = n11 / this.width * this.textureWidth;
        final float n16 = n12 / this.height * this.textureHeight;
        Class140.GL.glTexCoord2f(n13, n14);
        Class140.GL.glVertex3f(n, n2, 0.0f);
        Class140.GL.glTexCoord2f(n13, n14 + n16);
        Class140.GL.glVertex3f(n, n2 + n10, 0.0f);
        Class140.GL.glTexCoord2f(n13 + n15, n14 + n16);
        Class140.GL.glVertex3f(n + n9, n2 + n10, 0.0f);
        Class140.GL.glTexCoord2f(n13 + n15, n14);
        Class140.GL.glVertex3f(n + n9, n2, 0.0f);
    }
    
    public void drawWarped(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final float n8) {
        Class278.white.bind();
        this.texture.bind();
        Class140.GL.glTranslatef(n, n2, 0.0f);
        if (this.angle != 0.0f) {
            Class140.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
            Class140.GL.glRotatef(this.angle, 0.0f, 0.0f, 1.0f);
            Class140.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
        }
        Class140.GL.glBegin(7);
        this.init();
        Class140.GL.glTexCoord2f(this.textureOffsetX, this.textureOffsetY);
        Class140.GL.glVertex3f(0.0f, 0.0f, 0.0f);
        Class140.GL.glTexCoord2f(this.textureOffsetX, this.textureOffsetY + this.textureHeight);
        Class140.GL.glVertex3f(n3 - n, n4 - n2, 0.0f);
        Class140.GL.glTexCoord2f(this.textureOffsetX + this.textureWidth, this.textureOffsetY + this.textureHeight);
        Class140.GL.glVertex3f(n5 - n, n6 - n2, 0.0f);
        Class140.GL.glTexCoord2f(this.textureOffsetX + this.textureWidth, this.textureOffsetY);
        Class140.GL.glVertex3f(n7 - n, n8 - n2, 0.0f);
        Class140.GL.glEnd();
        if (this.angle != 0.0f) {
            Class140.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
            Class140.GL.glRotatef(-this.angle, 0.0f, 0.0f, 1.0f);
            Class140.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
        }
        Class140.GL.glTranslatef(-n, -n2, 0.0f);
    }
    
    public int getWidth() {
        this.init();
        return this.width;
    }
    
    public int getHeight() {
        this.init();
        return this.height;
    }
    
    public Class140 copy() {
        this.init();
        return this.getSubImage(0, 0, this.width, this.height);
    }
    
    public Class140 getScaledCopy(final float n) {
        this.init();
        return this.getScaledCopy((int)(this.width * n), (int)(this.height * n));
    }
    
    public Class140 getScaledCopy(final int width, final int height) {
        this.init();
        final Class140 copy = this.copy();
        copy.width = width;
        copy.height = height;
        copy.centerX = width / 2;
        copy.centerY = height / 2;
        return copy;
    }
    
    public void ensureInverted() {
        if (this.textureHeight > 0.0f) {
            this.textureOffsetY += this.textureHeight;
            this.textureHeight = -this.textureHeight;
        }
    }
    
    public Class140 getFlippedCopy(final boolean b, final boolean b2) {
        this.init();
        final Class140 copy = this.copy();
        if (b) {
            copy.textureOffsetX = this.textureOffsetX + this.textureWidth;
            copy.textureWidth = -this.textureWidth;
        }
        if (b2) {
            copy.textureOffsetY = this.textureOffsetY + this.textureHeight;
            copy.textureHeight = -this.textureHeight;
        }
        return copy;
    }
    
    public void endUse() {
        if (Class140.inUse != this) {
            throw new RuntimeException("The sprite sheet is not currently in use");
        }
        Class140.inUse = null;
        Class140.GL.glEnd();
    }
    
    public void startUse() {
        if (Class140.inUse != null) {
            throw new RuntimeException("Attempt to start use of a sprite sheet before ending use with another - see endUse()");
        }
        (Class140.inUse = this).init();
        Class278.white.bind();
        this.texture.bind();
        Class140.GL.glBegin(7);
    }
    
    @Override
    public String toString() {
        this.init();
        return "[Image " + this.ref + " " + this.width + "x" + this.height + "  " + this.textureOffsetX + "," + this.textureOffsetY + "," + this.textureWidth + "," + this.textureHeight + "]";
    }
    
    public Class27 getTexture() {
        return this.texture;
    }
    
    public void setTexture(final Class27 texture) {
        this.texture = texture;
        this.reinit();
    }
    
    private int translate(final byte b) {
        if (b < 0) {
            return 256 + b;
        }
        return b;
    }
    
    public Class278 getColor(int n, int n2) {
        if (this.pixelData == null) {
            this.pixelData = this.texture.getTextureData();
        }
        final int n3 = (int)(this.textureOffsetX * this.texture.getTextureWidth());
        final int n4 = (int)(this.textureOffsetY * this.texture.getTextureHeight());
        if (this.textureWidth < 0.0f) {
            n = n3 - n;
        }
        else {
            n += n3;
        }
        if (this.textureHeight < 0.0f) {
            n2 = n4 - n2;
        }
        else {
            n2 += n4;
        }
        final int n5 = (n + n2 * this.texture.getTextureWidth()) * (this.texture.hasAlpha() ? 4 : 3);
        if (this.texture.hasAlpha()) {
            return new Class278(this.translate(this.pixelData[n5]), this.translate(this.pixelData[n5 + 1]), this.translate(this.pixelData[n5 + 2]), this.translate(this.pixelData[n5 + 3]));
        }
        return new Class278(this.translate(this.pixelData[n5]), this.translate(this.pixelData[n5 + 1]), this.translate(this.pixelData[n5 + 2]));
    }
    
    public boolean isDestroyed() {
        return this.destroyed;
    }
    
    public void destroy() throws Class186 {
        if (this.isDestroyed()) {
            return;
        }
        this.destroyed = true;
        this.texture.release();
        Class129.releaseGraphicsForImage(this);
    }
    
    public void flushPixelData() {
        this.pixelData = null;
    }
    
    static {
        Class140.GL = Class83.get();
    }
}
