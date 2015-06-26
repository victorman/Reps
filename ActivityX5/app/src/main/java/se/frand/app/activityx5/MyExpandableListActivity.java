package se.frand.app.activityx5;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by victorfrandsen on 6/24/15.
 */
public class MyExpandableListActivity extends ExpandableListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.onCreate(savedInstanceState);
        setContentView(android.R.layout.expandable_list_content);

        /*
         * Set up list elements
         *
         * Activities
         *  - Activity
         *  - ActionBarActivity
         *  - ExpandableListActivity
         *  - ListActivity
         *  - TabActivity
         * Views
         *  - TextView
         *  - Button
         *  - ViewGroup
         * Layouts
         *  - LinearLayout
         *  - RelativeLayout
         *  - FrameLayout
         */

        ArrayList<HashMap<String,String>> groupList = new ArrayList<HashMap<String,String>>();
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("group", "The First Group");
        HashMap<String,String> group2 = new HashMap<String, String>();
        group2.put("group", "The Second Group");
        groupList.add(map);
        groupList.add(group2);

        ArrayList<ArrayList<HashMap<String, String>>> childLists = new ArrayList<ArrayList<HashMap<String, String>>>();
        ArrayList<HashMap<String,String>> group1List = new ArrayList<HashMap<String,String>>();
        HashMap<String,String> item1 = new HashMap<String,String>();
        item1.put("item", "The First Item");
        group1List.add(item1);
        ArrayList<HashMap<String,String>> group2List = new ArrayList<HashMap<String,String>>();
        HashMap<String,String> item2 = new HashMap<String,String>();
        item2.put("item", "The Second Item");
        group2List.add(item2);
        childLists.add(group1List);
        childLists.add(group2List);

        ExpandableListAdapter adapter;
        adapter = new SimpleExpandableListAdapter(
                this,
                groupList,
                android.R.layout.simple_expandable_list_item_1,
                new String[] {"group"},
                new int[] {android.R.id.text1},
                childLists,
                android.R.layout.simple_expandable_list_item_2,
                new String[]{"item"},
                new int[] {android.R.id.text2}
        );

        setListAdapter(adapter);
    }
}
