package tools;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by Javad Ansari on 1/22/2017.
 */

public class searchTextWatcher {

//    autocompleteView.addTextChangedListener(searchTextWatcher);

    TextWatcher searchTextWatcher = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
//            // user typed: start the timer

//            new Thread(new Runnable() {
//                public void run() {
//
//
//                    timer = new Timer();
//                    timer.schedule(new TimerTask() {
//                        @Override
//                        public void run() {
//
//                            SearchGo();
//                            // do your actual work here
//                        }
//                    }, 600); // 600ms delay before the timer executes the „run“ method from TimerTask
//                }
//            }).start();
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // nothing to do here
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // user is typing: reset already started timer (if existing)
//            if (timer != null) {
//                timer.cancel();
//            }
//            if (((AutoCompleteTextView) bookTitle).isPerformingCompletion()) {
//                return;
//            }
//            if (s.length() < 2) {
//                return;
//            }

//            String query = s.toString();
//            adapter.clear();


        }
    };



}
