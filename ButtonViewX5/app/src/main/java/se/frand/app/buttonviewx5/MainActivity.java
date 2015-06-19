package se.frand.app.buttonviewx5;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends Activity {

    private Button buttonAll;
    private Button button0;
    private Button button1;
    private Button button2;
    private TextView thouTextView;

    private ArrayList<String> col0;
    private ArrayList<String> col1;
    private ArrayList<String> col2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //shakespeaere insult words from:
        //http://teachwithict.weebly.com/shakespearean-insult-generator.html#sthash.G3lVlylB.dpbs
        parseWordColumns(getResources().openRawResource(R.raw.insult));

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);


        buttonAll = new Button(this);
        buttonAll.setText("All");
        layout.addView(buttonAll);
        button0 = new Button(this);
        button0.setText(nextWord(col0));
        layout.addView(button0);
        button1 = new Button(this);
        button1.setText(nextWord(col1));
        layout.addView(button1);
        button2 = new Button(this);
        button2.setText(nextWord(col2));
        layout.addView(button2);
        thouTextView = new TextView(this);
        layout.addView(thouTextView);
        setThouTextView();


        buttonAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button0.setText(nextWord(col0));
                button1.setText(nextWord(col1));
                button2.setText(nextWord(col2));
                setThouTextView();
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button0.setText(nextWord(col0));
                setThouTextView();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setText(nextWord(col1));
                setThouTextView();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setText(nextWord(col2));
                setThouTextView();
            }
        });

        setContentView(layout);

    }

    private int parseWordColumns(InputStream is) {
        final int COLUMNS = 3;
        col0 = new ArrayList<String>();
        col1 = new ArrayList<String>();
        col2 = new ArrayList<String>();

        int lines = 0;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line = null;
            while ((line = reader.readLine()) != null) {
                lines++;
                switch (lines % COLUMNS) {
                    case 1:
                        col0.add(line);
                        break;
                    case 2:
                        col1.add(line);
                        break;
                    default:
                        col2.add(line);

                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines / COLUMNS;
    }

    private String nextWord(ArrayList<String> list) {
        Random r = new Random();
        return list.get(r.nextInt(list.size()));
    }

    private void setThouTextView() {
        thouTextView.setText("Thou " + button0.getText() + " " + button1.getText() + " " + button2.getText() + "!");
    }
}
