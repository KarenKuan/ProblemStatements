package sg.edu.rp.c346.p02_holidays;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    TextView tvType;
    ArrayList<holiday> holidays;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView) this.findViewById(R.id.lv);
        tvType = (TextView) findViewById(R.id.tvType);

        Intent i = getIntent();
        String types = i.getStringExtra("holidayTypes");
        tvType.setText(types);

        // Create a few module objects in given years array
        holidays = new ArrayList<holiday>();

        if (types == "Secular") {
            holidays.add(new holiday("New Year's Day", "1 January 2020"));
            holidays.add(new holiday("Labour Day", "1 May 2020"));
            holidays.add(new holiday("National Day", "9 August 2020"));
            aa = new HolidayAdapter(this, R.layout.row, holidays);
            lv.setAdapter(aa);
        } else {
            holidays.add(new holiday("Chinese New Year", "25 January 2020 - 26 January 2020"));
            holidays.add(new holiday("Good Friday", "10 April 2020"));
            holidays.add(new holiday("Vesak Day", "7 May 2020"));
            holidays.add(new holiday("Hari Raya Puasa", "24 May 2020"));
            holidays.add(new holiday("Hari Raya Haji", "31 July 2020"));
            holidays.add(new holiday("Deepavali", "14 November 2020"));
            holidays.add(new holiday("Christmas Day", "25 December 2020"));
            aa = new HolidayAdapter(this, R.layout.row, holidays);
            lv.setAdapter(aa);
        }
        // Link this Activity object, the row.xml layout for
        //  each row and the year String array together

        /*
        if (year == "year 1") {
            aa = new ModuleAdapter(this, R.layout.row, year1);
            lv.setAdapter(aa);
        }
        else if (year == "year 2") {
            aa = new ModuleAdapter(this, R.layout.row, year2);
            lv.setAdapter(aa);
        }
        else {
            aa = new ModuleAdapter(this, R.layout.row, year3);
            lv.setAdapter(aa);
        }
         */


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                holiday selectedHolidays = holidays.get(position);
                Toast.makeText(SecondActivity.this, selectedHolidays.getHolidays()
                                 + selectedHolidays.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
