package com.example.season5.app;

import android.graphics.Typeface;

import java.lang.reflect.Field;

public class FontOveride {
    public static void setDefalutFont(String fontName) {

        final Typeface typeface = Typeface.createFromAsset(Application.getContext().getAssets(), "font/"+fontName);

        try {

            final Field  staticField=  Typeface.class.getDeclaredField("MONOSPACE");
            staticField.setAccessible(true);
            staticField.set(null,typeface);

        }
        catch (Exception t){

        }


    }
}
