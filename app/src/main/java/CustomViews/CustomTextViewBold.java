package CustomViews;

import android.content.Context;
import android.util.AttributeSet;

import tools.PublicMethods;

/**
 * Created by Javad Ansari on 12/29/2016.
 */

public class CustomTextViewBold extends android.widget.TextView {
    private PublicMethods pm;

    public CustomTextViewBold(Context context) {
        super(context);
        pm = new PublicMethods(context);
        this.setTypeface(pm.getTypefaceBold());
    }

    public CustomTextViewBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        pm = new PublicMethods(context);
        this.setTypeface(pm.getTypefaceBold());
    }
}
