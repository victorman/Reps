package se.frand.app.textviewreps;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //create our views programmatically
        TextView a = new TextView(this);
        a.setText("A");
        TextView b = new TextView(this);
        b.setText("B");

        //we do not have a resource file so we will make our layout object here
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        //add the views to our layout
        layout.addView(a);
        layout.addView(b);

        //finally add the layout as the content view
        //Layout extends View so setContentView(View) is used
        setContentView(layout);
    }



}
