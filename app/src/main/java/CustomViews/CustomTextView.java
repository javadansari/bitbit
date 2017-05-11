package CustomViews;

import android.content.Context;
import android.util.AttributeSet;

import tools.PublicMethods;

/**
 * Created by Javad Ansari on 12/29/2016.
 */

public class CustomTextView extends android.widget.TextView {
    private PublicMethods pm;

    public CustomTextView(Context context) {
        super(context);
        pm = new PublicMethods(context);
        this.setTypeface(pm.getTypeface());
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        pm = new PublicMethods(context);
        this.setTypeface(pm.getTypeface());
    }
}
