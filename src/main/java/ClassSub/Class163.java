package ClassSub;

public final class Class163
{
    private static Class12 GL;
    private static Class247 LSR;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class163() {
        super();
    }
    
    public static final void draw(final Class68 class68) {
        final Class27 lastBind = Class85.getLastBind();
        Class85.bindNone();
        final float[] array = (float[])class68.getPoints();
        Class163.LSR.start();
        for (int i = 0; i < array.length; i += 2) {
            Class163.LSR.vertex(array[i], array[i + 1]);
        }
        if (class68.closed()) {
            Class163.LSR.vertex(array[0], array[1]);
        }
        Class163.LSR.end();
        if (lastBind == null) {
            Class85.bindNone();
        }
        else {
            lastBind.bind();
        }
    }
    
    public static final void draw(final Class68 class68, final Class90 class69) {
        final float[] array = (float[])class68.getPoints();
        final Class27 lastBind = Class85.getLastBind();
        Class85.bindNone();
        final float[] array2 = (float[])class68.getCenter();
        Class163.GL.glBegin(3);
        for (int i = 0; i < array.length; i += 2) {
            class69.colorAt(class68, array[i], array[i + 1]).bind();
            final Class271 offset = class69.getOffsetAt(class68, array[i], array[i + 1]);
            Class163.GL.glVertex2f(array[i] + offset.x, array[i + 1] + offset.y);
        }
        if (class68.closed()) {
            class69.colorAt(class68, array[0], array[1]).bind();
            final Class271 offset2 = class69.getOffsetAt(class68, array[0], array[1]);
            Class163.GL.glVertex2f(array[0] + offset2.x, array[1] + offset2.y);
        }
        Class163.GL.glEnd();
        if (lastBind == null) {
            Class85.bindNone();
        }
        else {
            lastBind.bind();
        }
    }
    
    public static boolean validFill(final Class68 class68) {
        return class68.getTriangles() != null && class68.getTriangles().getTriangleCount() != 0;
    }
    
    public static final void fill(final Class68 class68) {
        final class Class114 implements Class50
        {
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class114() {
                super();
            }
            
            @Override
            public float[] preRenderPoint(final Class68 class68, final float n, final float n2) {
                return null;
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: athrow         
        //     4: aload_0        
        //     5: invokestatic    ClassSub/Class163.validFill:(LClassSub/Class68;)Z
        //     8: ifne            16
        //    11: return         
        //    12: nop            
        //    13: nop            
        //    14: nop            
        //    15: athrow         
        //    16: invokestatic    ClassSub/Class85.getLastBind:()LClassSub/Class27;
        //    19: astore_1       
        //    20: invokestatic    ClassSub/Class85.bindNone:()V
        //    23: aload_0        
        //    24: new             LClassSub/Class114;
        //    27: dup            
        //    28: invokespecial   ClassSub/Class114.<init>:()V
        //    31: invokestatic    ClassSub/Class163.fill:(LClassSub/Class68;LClassSub/Class50;)V
        //    34: aload_1        
        //    35: ifnonnull       50
        //    38: invokestatic    ClassSub/Class85.bindNone:()V
        //    41: goto            54
        //    44: nop            
        //    45: nop            
        //    46: nop            
        //    47: nop            
        //    48: nop            
        //    49: athrow         
        //    50: aload_1        
        //    51: invokevirtual   ClassSub/Class27.bind:()V
        //    54: return         
        //    55: nop            
        //    56: nop            
        //    57: nop            
        //    58: athrow         
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.convertType(AstBuilder.java:324)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.convertType(AstBuilder.java:153)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1120)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1010)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveForgeJarDecompiled(FileSaver.java:228)
        //     at us.deathmarine.luyten.FileSaver.lambda$saveAllForgeDir$0(FileSaver.java:142)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static final void fill(final Class68 class68, final Class50 class69) {
        final Class42 triangles = class68.getTriangles();
        Class163.GL.glBegin(4);
        for (int i = 0; i < triangles.getTriangleCount(); ++i) {
            for (int j = 0; j < 3; ++j) {
                final float[] array = (float[])triangles.getTrianglePoint(i, j);
                final float[] array2 = (float[])class69.preRenderPoint(class68, array[0], array[1]);
                if (array2 == null) {
                    Class163.GL.glVertex2f(array[0], array[1]);
                }
                else {
                    Class163.GL.glVertex2f(array2[0], array2[1]);
                }
            }
        }
        Class163.GL.glEnd();
    }
    
    public static final void texture(final Class68 class68, final Class140 class69) {
        texture(class68, class69, 0.01f, 0.01f);
    }
    
    public static final void textureFit(final Class68 class68, final Class140 class69) {
        textureFit(class68, class69, 1.0f, 1.0f);
    }
    
    public static final void texture(final Class68 class68, final Class140 class69, final float n, final float n2) {
        final class Class49 implements Class50
        {
            final float val$scaleX;
            final float val$scaleY;
            final Class140 val$image;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class49(final float val$scaleX, final float val$scaleY, final Class140 val$image) {
                this.val$scaleX = val$scaleX;
                this.val$scaleY = val$scaleY;
                this.val$image = val$image;
                super();
            }
            
            @Override
            public float[] preRenderPoint(final Class68 class68, final float n, final float n2) {
                Class163.access$000().glTexCoord2f(this.val$image.getTextureOffsetX() + this.val$image.getTextureWidth() * (n * this.val$scaleX), this.val$image.getTextureOffsetY() + this.val$image.getTextureHeight() * (n2 * this.val$scaleY));
                return null;
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: athrow         
        //     4: aload_0        
        //     5: invokestatic    ClassSub/Class163.validFill:(LClassSub/Class68;)Z
        //     8: ifne            17
        //    11: return         
        //    12: nop            
        //    13: nop            
        //    14: nop            
        //    15: nop            
        //    16: athrow         
        //    17: invokestatic    ClassSub/Class85.getLastBind:()LClassSub/Class27;
        //    20: astore          4
        //    22: aload_1        
        //    23: invokevirtual   ClassSub/Class140.getTexture:()LClassSub/Class27;
        //    26: invokevirtual   ClassSub/Class27.bind:()V
        //    29: aload_0        
        //    30: new             LClassSub/Class49;
        //    33: dup            
        //    34: fload_2        
        //    35: fload_3        
        //    36: aload_1        
        //    37: invokespecial   ClassSub/Class49.<init>:(FFLClassSub/Class140;)V
        //    40: invokestatic    ClassSub/Class163.fill:(LClassSub/Class68;LClassSub/Class50;)V
        //    43: aload_0        
        //    44: invokevirtual   ClassSub/Class68.getPoints:()[F
        //    47: checkcast       [F
        //    50: astore          5
        //    52: aload           4
        //    54: ifnonnull       70
        //    57: invokestatic    ClassSub/Class85.bindNone:()V
        //    60: goto            75
        //    63: nop            
        //    64: nop            
        //    65: nop            
        //    66: nop            
        //    67: nop            
        //    68: nop            
        //    69: athrow         
        //    70: aload           4
        //    72: invokevirtual   ClassSub/Class27.bind:()V
        //    75: return         
        //    76: nop            
        //    77: nop            
        //    78: nop            
        //    79: nop            
        //    80: athrow         
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.convertType(AstBuilder.java:324)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.convertType(AstBuilder.java:153)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1120)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1010)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveForgeJarDecompiled(FileSaver.java:228)
        //     at us.deathmarine.luyten.FileSaver.lambda$saveAllForgeDir$0(FileSaver.java:142)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static final void textureFit(final Class68 class68, final Class140 class69, final float n, final float n2) {
        final class Class316 implements Class50
        {
            final float val$scaleX;
            final float val$scaleY;
            final Class140 val$image;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class316(final float val$scaleX, final float val$scaleY, final Class140 val$image) {
                this.val$scaleX = val$scaleX;
                this.val$scaleY = val$scaleY;
                this.val$image = val$image;
                super();
            }
            
            @Override
            public float[] preRenderPoint(final Class68 class68, float n, float n2) {
                n -= class68.getMinX();
                n2 -= class68.getMinY();
                n /= class68.getMaxX() - class68.getMinX();
                n2 /= class68.getMaxY() - class68.getMinY();
                Class163.access$000().glTexCoord2f(this.val$image.getTextureOffsetX() + this.val$image.getTextureWidth() * (n * this.val$scaleX), this.val$image.getTextureOffsetY() + this.val$image.getTextureHeight() * (n2 * this.val$scaleY));
                return null;
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: athrow         
        //     4: aload_0        
        //     5: invokestatic    ClassSub/Class163.validFill:(LClassSub/Class68;)Z
        //     8: ifne            17
        //    11: return         
        //    12: nop            
        //    13: nop            
        //    14: nop            
        //    15: nop            
        //    16: athrow         
        //    17: aload_0        
        //    18: invokevirtual   ClassSub/Class68.getPoints:()[F
        //    21: checkcast       [F
        //    24: astore          4
        //    26: invokestatic    ClassSub/Class85.getLastBind:()LClassSub/Class27;
        //    29: astore          5
        //    31: aload_1        
        //    32: invokevirtual   ClassSub/Class140.getTexture:()LClassSub/Class27;
        //    35: invokevirtual   ClassSub/Class27.bind:()V
        //    38: aload_0        
        //    39: invokevirtual   ClassSub/Class68.getX:()F
        //    42: fstore          6
        //    44: aload_0        
        //    45: invokevirtual   ClassSub/Class68.getY:()F
        //    48: fstore          7
        //    50: aload_0        
        //    51: invokevirtual   ClassSub/Class68.getMaxX:()F
        //    54: fload           6
        //    56: fsub           
        //    57: fstore          8
        //    59: aload_0        
        //    60: invokevirtual   ClassSub/Class68.getMaxY:()F
        //    63: fload           7
        //    65: fsub           
        //    66: fstore          9
        //    68: aload_0        
        //    69: new             LClassSub/Class316;
        //    72: dup            
        //    73: fload_2        
        //    74: fload_3        
        //    75: aload_1        
        //    76: invokespecial   ClassSub/Class316.<init>:(FFLClassSub/Class140;)V
        //    79: invokestatic    ClassSub/Class163.fill:(LClassSub/Class68;LClassSub/Class50;)V
        //    82: aload           5
        //    84: ifnonnull       100
        //    87: invokestatic    ClassSub/Class85.bindNone:()V
        //    90: goto            105
        //    93: nop            
        //    94: nop            
        //    95: nop            
        //    96: nop            
        //    97: nop            
        //    98: nop            
        //    99: athrow         
        //   100: aload           5
        //   102: invokevirtual   ClassSub/Class27.bind:()V
        //   105: return         
        //   106: nop            
        //   107: nop            
        //   108: nop            
        //   109: nop            
        //   110: athrow         
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.convertType(AstBuilder.java:324)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.convertType(AstBuilder.java:153)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1120)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1010)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveForgeJarDecompiled(FileSaver.java:228)
        //     at us.deathmarine.luyten.FileSaver.lambda$saveAllForgeDir$0(FileSaver.java:142)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static final void fill(final Class68 class68, final Class90 class69) {
        final class Class1 implements Class50
        {
            final Class90 val$fill;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class1(final Class90 val$fill) {
                this.val$fill = val$fill;
                super();
            }
            
            @Override
            public float[] preRenderPoint(final Class68 class68, final float n, final float n2) {
                this.val$fill.colorAt(class68, n, n2).bind();
                final Class271 offset = this.val$fill.getOffsetAt(class68, n, n2);
                return new float[] { offset.x + n, offset.y + n2 };
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: athrow         
        //     4: aload_0        
        //     5: invokestatic    ClassSub/Class163.validFill:(LClassSub/Class68;)Z
        //     8: ifne            17
        //    11: return         
        //    12: nop            
        //    13: nop            
        //    14: nop            
        //    15: nop            
        //    16: athrow         
        //    17: invokestatic    ClassSub/Class85.getLastBind:()LClassSub/Class27;
        //    20: astore_2       
        //    21: invokestatic    ClassSub/Class85.bindNone:()V
        //    24: aload_0        
        //    25: invokevirtual   ClassSub/Class68.getCenter:()[F
        //    28: checkcast       [F
        //    31: astore_3       
        //    32: aload_0        
        //    33: new             LClassSub/Class1;
        //    36: dup            
        //    37: aload_1        
        //    38: invokespecial   ClassSub/Class1.<init>:(LClassSub/Class90;)V
        //    41: invokestatic    ClassSub/Class163.fill:(LClassSub/Class68;LClassSub/Class50;)V
        //    44: aload_2        
        //    45: ifnonnull       61
        //    48: invokestatic    ClassSub/Class85.bindNone:()V
        //    51: goto            65
        //    54: nop            
        //    55: nop            
        //    56: nop            
        //    57: nop            
        //    58: nop            
        //    59: nop            
        //    60: athrow         
        //    61: aload_2        
        //    62: invokevirtual   ClassSub/Class27.bind:()V
        //    65: return         
        //    66: nop            
        //    67: nop            
        //    68: nop            
        //    69: nop            
        //    70: athrow         
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.convertType(AstBuilder.java:324)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.convertType(AstBuilder.java:153)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1120)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1010)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveForgeJarDecompiled(FileSaver.java:228)
        //     at us.deathmarine.luyten.FileSaver.lambda$saveAllForgeDir$0(FileSaver.java:142)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static final void texture(final Class68 class68, final Class140 class69, final float n, final float n2, final Class90 class70) {
        final class Class94 implements Class50
        {
            final Class90 val$fill;
            final float[] val$center;
            final float val$scaleX;
            final float val$scaleY;
            final Class140 val$image;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class94(final Class90 val$fill, final float[] val$center, final float val$scaleX, final float val$scaleY, final Class140 val$image) {
                this.val$fill = val$fill;
                this.val$center = val$center;
                this.val$scaleX = val$scaleX;
                this.val$scaleY = val$scaleY;
                this.val$image = val$image;
                super();
            }
            
            @Override
            public float[] preRenderPoint(final Class68 class68, float n, float n2) {
                this.val$fill.colorAt(class68, n - this.val$center[0], n2 - this.val$center[1]).bind();
                final Class271 offset = this.val$fill.getOffsetAt(class68, n, n2);
                n += offset.x;
                n2 += offset.y;
                Class163.access$000().glTexCoord2f(this.val$image.getTextureOffsetX() + this.val$image.getTextureWidth() * (n * this.val$scaleX), this.val$image.getTextureOffsetY() + this.val$image.getTextureHeight() * (n2 * this.val$scaleY));
                return new float[] { offset.x + n, offset.y + n2 };
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: athrow         
        //     4: aload_0        
        //     5: invokestatic    ClassSub/Class163.validFill:(LClassSub/Class68;)Z
        //     8: ifne            17
        //    11: return         
        //    12: nop            
        //    13: nop            
        //    14: nop            
        //    15: nop            
        //    16: athrow         
        //    17: invokestatic    ClassSub/Class85.getLastBind:()LClassSub/Class27;
        //    20: astore          5
        //    22: aload_1        
        //    23: invokevirtual   ClassSub/Class140.getTexture:()LClassSub/Class27;
        //    26: invokevirtual   ClassSub/Class27.bind:()V
        //    29: aload_0        
        //    30: invokevirtual   ClassSub/Class68.getCenter:()[F
        //    33: checkcast       [F
        //    36: astore          6
        //    38: aload_0        
        //    39: new             LClassSub/Class94;
        //    42: dup            
        //    43: aload           4
        //    45: aload           6
        //    47: fload_2        
        //    48: fload_3        
        //    49: aload_1        
        //    50: invokespecial   ClassSub/Class94.<init>:(LClassSub/Class90;[FFFLClassSub/Class140;)V
        //    53: invokestatic    ClassSub/Class163.fill:(LClassSub/Class68;LClassSub/Class50;)V
        //    56: aload           5
        //    58: ifnonnull       74
        //    61: invokestatic    ClassSub/Class85.bindNone:()V
        //    64: goto            79
        //    67: nop            
        //    68: nop            
        //    69: nop            
        //    70: nop            
        //    71: nop            
        //    72: nop            
        //    73: athrow         
        //    74: aload           5
        //    76: invokevirtual   ClassSub/Class27.bind:()V
        //    79: return         
        //    80: nop            
        //    81: nop            
        //    82: nop            
        //    83: nop            
        //    84: athrow         
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.convertType(AstBuilder.java:324)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.convertType(AstBuilder.java:153)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1120)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1010)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveForgeJarDecompiled(FileSaver.java:228)
        //     at us.deathmarine.luyten.FileSaver.lambda$saveAllForgeDir$0(FileSaver.java:142)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static final void texture(final Class68 class68, final Class140 class69, final Class193 class70) {
        final class Class304 implements Class50
        {
            final Class193 val$gen;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class304(final Class193 val$gen) {
                this.val$gen = val$gen;
                super();
            }
            
            @Override
            public float[] preRenderPoint(final Class68 class68, final float n, final float n2) {
                final Class271 coord = this.val$gen.getCoordFor(n, n2);
                Class163.access$000().glTexCoord2f(coord.x, coord.y);
                return new float[] { n, n2 };
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: athrow         
        //     4: invokestatic    ClassSub/Class85.getLastBind:()LClassSub/Class27;
        //     7: astore_3       
        //     8: aload_1        
        //     9: invokevirtual   ClassSub/Class140.getTexture:()LClassSub/Class27;
        //    12: invokevirtual   ClassSub/Class27.bind:()V
        //    15: aload_0        
        //    16: invokevirtual   ClassSub/Class68.getCenter:()[F
        //    19: checkcast       [F
        //    22: astore          4
        //    24: aload_0        
        //    25: new             LClassSub/Class304;
        //    28: dup            
        //    29: aload_2        
        //    30: invokespecial   ClassSub/Class304.<init>:(LClassSub/Class193;)V
        //    33: invokestatic    ClassSub/Class163.fill:(LClassSub/Class68;LClassSub/Class50;)V
        //    36: aload_3        
        //    37: ifnonnull       53
        //    40: invokestatic    ClassSub/Class85.bindNone:()V
        //    43: goto            57
        //    46: nop            
        //    47: nop            
        //    48: nop            
        //    49: nop            
        //    50: nop            
        //    51: nop            
        //    52: athrow         
        //    53: aload_3        
        //    54: invokevirtual   ClassSub/Class27.bind:()V
        //    57: return         
        //    58: nop            
        //    59: nop            
        //    60: nop            
        //    61: nop            
        //    62: athrow         
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.convertType(AstBuilder.java:324)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.convertType(AstBuilder.java:153)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1120)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1010)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveForgeJarDecompiled(FileSaver.java:228)
        //     at us.deathmarine.luyten.FileSaver.lambda$saveAllForgeDir$0(FileSaver.java:142)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static Class12 access$000() {
        return Class163.GL;
    }
    
    static {
        Class163.GL = Class83.get();
        Class163.LSR = Class83.getLineStripRenderer();
    }
}
