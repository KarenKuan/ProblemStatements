package sg.edu.rp.c346.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<holiday> {

    private Context context;
    private ArrayList<holiday> hols;
    private TextView tvholidaysName, tvHolidaysDate;
    private ImageView ivholidaypic;

    public HolidayAdapter(Context context, int resource, ArrayList<holiday> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        hols = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvholidaysName = (TextView) rowView.findViewById(R.id.tvholidaysName);
        tvHolidaysDate = (TextView) rowView.findViewById(R.id.tvholidaysDate);

        // Get the ImageView object
        ivholidaypic = (ImageView) rowView.findViewById(R.id.ivholidaypic);

        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        holiday currentHols = hols.get(position);
        // Set the TextView to show the food

        tvholidaysName.setText(currentHols.getHolidays());
        tvHolidaysDate.setText(currentHols.getDate());

        // Set the image to secular or nonprog accordingly
        if (currentHols.getHolidays() == "New Year's Day") {
            ivholidaypic.setImageResource(R.drawable.newyear);
        }
        else if (currentHols.getHolidays() == "Chinese New Year") {
            ivholidaypic.setImageResource(R.drawable.cny);
        }
        else if (currentHols.getHolidays() == "Good Friday") {
            ivholidaypic.setImageResource(R.drawable.goodfriday);
        }
        else if (currentHols.getHolidays() == "Labour Day") {
            ivholidaypic.setImageResource(R.drawable.labourday);
        }
        else if (currentHols.getHolidays() == "Vesak Day") {
            ivholidaypic.setImageResource(R.drawable.vesakday);
        }
        else if (currentHols.getHolidays() == "Hari Raya Puasa") {
            ivholidaypic.setImageResource(R.drawable.harirayapuasa);
        }
        else if (currentHols.getHolidays() == "Hari Raya Haji") {
            ivholidaypic.setImageResource(R.drawable.harirayahaji);
        }
        else if (currentHols.getHolidays() == "National Day") {
            ivholidaypic.setImageResource(R.drawable.nationalday);
        }
        else if (currentHols.getHolidays() == "Deepavali") {
            ivholidaypic.setImageResource(R.drawable.deepavali);
        }
        else if (currentHols.getHolidays() == "Christmas Day") {
            ivholidaypic.setImageResource(R.drawable.christmas);
        }
        // Return the nicely done up View to the ListView
        return rowView;
    }
}
