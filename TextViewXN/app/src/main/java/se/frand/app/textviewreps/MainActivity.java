package se.frand.app.textviewreps;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //we do not have a resource file so we will make our layout object here
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        try {
            //find our items.txt file in the raw directory assuming it starts from res/
            InputStream is = getResources().openRawResource(R.raw.items);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            //create our views programmatically
            String line = null;
            while ((line = reader.readLine()) != null) {
                TextView view = new TextView(this);
                view.setText(line);
                layout.addView(view);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //finally add the layout as the content view
        //Layout extends View so setContentView(View) is used
        setContentView(layout);
    }
}
