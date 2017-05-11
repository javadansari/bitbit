package CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

import tools.PublicMethods;

/**
 * Created by Javad Ansari on 12/29/2016.
 */

public class CustomAutoName extends AutoCompleteTextView {
    private PublicMethods pm;

    public CustomAutoName(Context context) {
        super(context);
        pm = new PublicMethods(context);
        this.setTypeface(pm.getTypeface());
    }

    public CustomAutoName(Context context, AttributeSet attrs) {
        super(context, attrs);
        pm = new PublicMethods(context);
        this.setTypeface(pm.getTypeface());
    }
}
