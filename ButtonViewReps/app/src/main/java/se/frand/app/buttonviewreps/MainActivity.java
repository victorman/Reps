package se.frand.app.buttonviewreps;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends Activity {

    private int clicks0 = 0;
    private int clicks1 = 0;
    private Button button0;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        button0 = new Button(this);
        button0.setText("" + clicks0);
        layout.addView(button0);
        button1 = new Button(this);
        button1.setText("" + clicks1);
        layout.addView(button1);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks0++;
                button0.setText("" + clicks0);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks1++;
                button1.setText("" + clicks1);
            }
        });

        setContentView(layout);

    }
}
