package se.frand.app.activityreps;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by victorfrandsen on 6/23/15.
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout. setOrientation(LinearLayout.VERTICAL);

        Button button = new Button(this);
        button.setText("Close Activity");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        layout.addView(button);
        setContentView(layout);
    }
}
