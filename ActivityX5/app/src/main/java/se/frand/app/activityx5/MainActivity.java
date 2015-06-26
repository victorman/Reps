package se.frand.app.activityx5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/*
 * Open Five Activities. Instead of opening one activity with 5 different buttons, starting
 * a new instance of an activity 5 different times, I will look at all the different types of
 * activities.
 * Implement Options:
 *  - ListActivity
 *  - ExpandableListActivity
 *  - TabActivity
 *  - NativeActivity
 *  - LauncherActivity
 *  - ActionBarActivity (deprecated)
 *  - AppCompatActivity
 *  - FragmentActivity
 *  - AliasActivity
 *  - AccountAuthenticatorActivity
 *  - other implicit intent activities
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        //implement listview
        Button listActivityButton = new Button(this);
        listActivityButton.setText("Show MyListActivity");
        listActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyListActivity.class);
                startActivity(intent);
            }
        });
        Button expandableListActivityButton = new Button(this);
        expandableListActivityButton.setText("Show MyExpandableListActivity");
        expandableListActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyExpandableListActivity.class);
                startActivity(intent);
            }
        });

        layout.addView(listActivityButton);
        layout.addView(expandableListActivityButton);
        setContentView(layout);
    }
}
