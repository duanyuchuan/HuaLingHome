package com.hualing.hualinghome.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2017/7/13.
 */

public class BitmapOrDrawable {
    /**
     * 将Drawable转换成Bitmap
     * @param drawable
     * @return
     */
    public static Bitmap drawableToBitmap(Drawable drawable){
        Bitmap bitmap=Bitmap.createBitmap(
                drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(),
                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565
        );
        Canvas canvas=new Canvas(bitmap);
        drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }
    /**
     *将Bitmap转换成Drawable
     * @param bitmap
     * @return
     */
    public static Drawable bitmapToDrawable(Bitmap bitmap){
        return new BitmapDrawable(bitmap);
    }
}
