package com.hualing.hualinghome.HttpUtils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;

/**加载本地文件的工具类
 * Created by Administrator on 2017/7/16.
 */

public class LoadFileByLocal {
    /**
     * 从资产目录中获取图片文件
     * @param context
     * @param fileName
     * @return
     * @throws Exception
     */
    public static Bitmap loadImageByAssets(Context context,String fileName) throws Exception{
        AssetManager assetsManager = context.getResources().getAssets();
        InputStream inputStream= assetsManager.open(fileName);
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        inputStream.close();
        return bitmap;
    }
}
