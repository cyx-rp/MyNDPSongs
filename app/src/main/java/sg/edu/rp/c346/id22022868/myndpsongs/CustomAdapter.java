package sg.edu.rp.c346.id22022868.myndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Song> songList;

    public CustomAdapter(@NonNull Context context, int resource, ArrayList<Song> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        songList = objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //getView gets or generates every row in the list
        //so it will be called 5 times to populate the ListView

        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvName = rowView.findViewById(R.id.tvName);
        TextView tvYear = rowView.findViewById(R.id.tvYear);
        TextView tvStars = rowView.findViewById(R.id.tvStars);
        TextView tvSingers = rowView.findViewById(R.id.tvSingers);

        // Obtain the [Android Version information] based on the position - replace [] with wtv data
        Song currentSong = songList.get(position);

        // Set values to the TextView to display the corresponding information
        String starString = "";
        int starNo = currentSong.getStar();

        if (starNo == 1) {
            starString = "*";
        }
        else if (starNo == 2) {
            starString = "* *";
        }
        else if (starNo == 3) {
            starString = "* * *";
        }
        else if (starNo == 4) {
            starString = "* * * *";
        }
        else {
            starString = "* * * * *";
        }

        tvName.setText(currentSong.getTitle());
        tvYear.setText(String.valueOf(currentSong.getYear()));
        tvStars.setText(starString);
        tvSingers.setText(currentSong.getSingers());


        return rowView;
    }





}
