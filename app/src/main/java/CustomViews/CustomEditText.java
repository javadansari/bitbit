package CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import tools.PublicMethods;

/**
 * Created by Javad Ansari on 12/30/2016.
 */

public class CustomEditText extends EditText {
    private PublicMethods pm;

    public CustomEditText(Context context) {
        super(context);
        pm = new PublicMethods(context);
        this.setTypeface(pm.getTypeface());
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        pm = new PublicMethods(context);
        this.setTypeface(pm.getTypeface());
    }


}
