package sg.edu.rp.c346.id22022868.myndpsongs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTitle;
    EditText etSingers;
    EditText etYear;
    RadioGroup rgStars;
    Button btnInsert;
    Button btnShowList;
    ListView lvSongs;
    String title;
    String singers;
    int year;
    String yearCheck;
    int stars;
    ArrayList<Song> Songs;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etTitle);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        rgStars = findViewById(R.id.rgStars);
        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnShowList);
        //lvSongs = findViewById(R.id.lvSongs);




        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create DBHelper object, pass it in this activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                //Converting inputs to string
                title = etTitle.getText().toString();
                singers = etSingers.getText().toString();
                yearCheck = etYear.getText().toString();
                //condition to prevent nullpointerexception
                if (!yearCheck.isEmpty()) {
                    year = Integer.parseInt(yearCheck);
                }

                //if else statement to get ID of button selected so that we can assign value to that button
                if (rgStars.getCheckedRadioButtonId() == R.id.radioButton) {
                    stars = 1;
                } else if (rgStars.getCheckedRadioButtonId() == R.id.radioButton2) {
                    stars = 2;
                } else if (rgStars.getCheckedRadioButtonId() == R.id.radioButton3) {
                    stars = 3;
                } else if (rgStars.getCheckedRadioButtonId() == R.id.radioButton4) {
                    stars = 4;
                } else {
                    stars = 5;
                }

                if (!title.isEmpty() && !singers.isEmpty() && !yearCheck.isEmpty()) {
                    //Insert a task
                    db.insertSong(title, singers, year, stars);
                }

            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*// Create the DBHelper object, passing in the activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<Song> Songs = db.getSongDetails();

                //Closing database connection
                db.close();

                adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, Songs);
                lvSongs.setAdapter(adapter);
                adapter.notifyDataSetChanged();*/

                Intent i = new Intent(MainActivity.this, ListViewActivity.class);
                //i.putExtra("data", );
                startActivity(i);




            }
        });



















    }
}