package se.frand.app.buttonviewxn;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;


public class MainActivity extends Activity {


    private Button buttonAdd;
    private ArrayList<Button> buttonList;
    private ArrayList<Integer> intList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        buttonList = new ArrayList<Button>();
        intList = new ArrayList<Integer>();


        buttonAdd = new Button(this);
        buttonAdd.setText("+");
        layout.addView(buttonAdd);
        
        final Integer start = 1;
        Button firstButton = makeButton(start - 1);
        intList.add(start);
        buttonList.add(firstButton);
        //providing in an int instead of a string will look for a Resource at the id of the int
        //this will produce a NotFoundException as there is no resource at the id
        firstButton.setText(start.toString());
        layout.addView(firstButton, start - 1);



        //set up add button
        //adds all numbers from intList and makes a new button
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get a button object. make it in makeButton so i can use 'this'
                Button button = makeButton(buttonList.size());
                Integer n = addAll(intList);
                button.setText(n.toString());
                //add the number to the end of the list
                intList.add(n);
                //add the button to the end of the list
                buttonList.add(button);
                //add the button to the layout
                layout.addView(button, layout.getChildCount() - 1);
            }
        });

        setContentView(layout);

    }

    private Button makeButton(final int position){
        final Button button = new Button(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = intList.get(position) * 2;
                intList.set(position, n);
                Button b = (Button) v;
                b.setText("" + n);
            }
        });
        return button;
    }

    private int addAll(ArrayList<Integer> list) {

        int total = 0;
        for(Integer i: intList){
            total += i;
        }
        return total;
    }
}
