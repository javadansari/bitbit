package CustomViews;

import android.content.Context;
import android.util.AttributeSet;

import com.rey.material.widget.Button;

import tools.PublicMethods;

/**
 * Created by Javad Ansari on 12/29/2016.
 */

public class CustomButton extends Button {
    private PublicMethods pm;

    public CustomButton(Context context) {
        super(context);
        pm = new PublicMethods(context);
        this.setTypeface(pm.getTypeface());
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        pm = new PublicMethods(context);
        this.setTypeface(pm.getTypeface());
    }
}
