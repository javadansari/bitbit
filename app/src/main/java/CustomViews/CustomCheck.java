package CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;

import tools.PublicMethods;

/**
 * Created by Javad Ansari on 12/29/2016.
 */

public class CustomCheck extends com.rey.material.widget.CheckBox {
    private PublicMethods pm;

    public CustomCheck(Context context) {
        super(context);
        pm = new PublicMethods(context);
        this.setTypeface(pm.getTypeface());
    }

    public CustomCheck(Context context, AttributeSet attrs) {
        super(context, attrs);
        pm = new PublicMethods(context);
        this.setTypeface(pm.getTypeface());
    }
}
