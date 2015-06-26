package se.frand.app.activityx5;

import android.app.ListActivity;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

/**
 * Created by victorfrandsen on 6/24/15.
 */
public class MyListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(android.R.layout.list_content);

        MatrixCursor cursor = new MatrixCursor(new String[]{"_id"});
        cursor.addRow(new Integer[] {1});
        cursor.addRow(new Integer[] {2});
        cursor.addRow(new Integer[] {3});
        cursor.addRow(new Integer[] {4});
        cursor.addRow(new Integer[] {5});
        cursor.addRow(new Integer[] {6});
        cursor.addRow(new Integer[] {7});
        cursor.addRow(new Integer[] {8});

        ListAdapter adapter = new SimpleCursorAdapter(
                this,
                android.R.layout.activity_list_item,
                cursor,
                new String[]{"_id"},
                new int[]{android.R.id.text1}
        );

        setListAdapter(adapter);
    }

}
