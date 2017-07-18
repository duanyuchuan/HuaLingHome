package com.hualing.hualinghome.HttpUtils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by Administrator on 2017/7/14.
 */

public class BitmapCache implements ImageLoader.ImageCache{
    private LruCache<String , Bitmap> mLruCache;

    public BitmapCache(){
        int maxMemoryCache = (int) ((Runtime.getRuntime().maxMemory()/8)+0.5f);
        mLruCache=new LruCache<String , Bitmap>(maxMemoryCache){
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes()*bitmap.getHeight();
            }
        };
    }
    @Override
    public Bitmap getBitmap(String url) {
        return mLruCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        mLruCache.put(url,bitmap);
        /*
        if(mLruCache.get(url) != bitmap){
            mLruCache.put(url,bitmap);
            String imageName = Md5Helper.toMD5(url);
            String externalStorageState = Environment.getExternalStorageState();
            if(Environment.MEDIA_MOUNTED.equals(externalStorageState)){
                File SDDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsoluteFile();
                File fileDir=new File(SDDir,"imageCacheSplash");
                if(!fileDir.exists()){
                    fileDir.mkdirs();
                }
                File imageFile=new File(fileDir,imageName+".jpg");
                if(imageFile.exists()){
                    return;
                }
                System.out.println("外部存儲設備已經掛載：文件存在");
                try{
                    System.out.println("外部存儲設備已經掛載：");
                    imageFile.createNewFile();
                    FileOutputStream fileOutputStream=new FileOutputStream(imageFile);
                    bitmap.compress(Bitmap.CompressFormat.JPEG,50,fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        */
    }
}
