package CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;

import com.rey.material.widget.Button;

import tools.PublicMethods;

/**
 * Created by Javad Ansari on 12/29/2016.
 */

public class CustomCheckBold extends com.rey.material.widget.CheckBox {
    private PublicMethods pm;

    public CustomCheckBold(Context context) {
        super(context);
        pm = new PublicMethods(context);
        this.setTypeface(pm.getTypefaceBold());
    }

    public CustomCheckBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        pm = new PublicMethods(context);
        this.setTypeface(pm.getTypefaceBold());
    }
}
