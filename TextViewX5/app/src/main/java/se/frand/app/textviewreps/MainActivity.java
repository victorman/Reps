package se.frand.app.textviewreps;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //we do not have a resource file so we will make our layout object here
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        //create our views programmatically
        TextView[] views = new TextView[5];
        for(int i=0; i < views.length; i++) {
            views[i] = new TextView(this);
            views[i].setText("Item " + (i + 1));
            layout.addView(views[i]);
        }

        //finally add the layout as the content view
        //Layout extends View so setContentView(View) is used
        setContentView(layout);
    }
}
