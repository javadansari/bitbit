package tools;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Javad Ansari on 12/29/2016.
 */

public class PublicMethods {
    private Context mContext;

    public PublicMethods(Context mContext) {
        this.mContext = mContext;
    }
    public Typeface getTypeface (){
        return Typeface.createFromAsset(mContext.getAssets(),"Sans.ttf");
    }
    public Typeface getTypefaceBold (){
        return Typeface.createFromAsset(mContext.getAssets(),"SansBold.ttf");
    }
}
