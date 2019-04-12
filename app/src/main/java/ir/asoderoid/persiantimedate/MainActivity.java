package ir.asoderoid.persiantimedate;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.time.RadialPickerLayout;
import com.mohamadamin.persianmaterialdatetimepicker.time.TimePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener
        ,DatePickerDialog.OnDateSetListener {

    Button btnPickDate , btnPickTime;
    TimePickerDialog timePickerDialog ;
    DatePickerDialog datePickerDialog ;


    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPickDate = (Button) findViewById(R.id.btnPickDate);
        btnPickTime = (Button) findViewById(R.id.btnPickTime);


        btnPickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PersianCalendar now = new PersianCalendar();
                datePickerDialog = DatePickerDialog.newInstance(
                        MainActivity.this,
                        now.getPersianYear(),
                        now.getPersianMonth(),
                        now.getPersianDay()
                );
                datePickerDialog.show(getFragmentManager(), "DatePickerDialog");
                datePickerDialog.setThemeDark(true);

            }
        });

        btnPickTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PersianCalendar now = new PersianCalendar();
                timePickerDialog = TimePickerDialog.newInstance(
                        MainActivity.this , now.get(PersianCalendar.HOUR_OF_DAY),
                        now.get(PersianCalendar.MINUTE) , true);
                timePickerDialog.show(getFragmentManager() , "TimePickerDialog");
                timePickerDialog.setThemeDark(true);
            }
        });






//        timePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//            @Override
//            public void onCancel(DialogInterface dialogInterface) {
//                Log.d("TTT", "Dialog was cancelled");
//            }
//        });



//        datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//            @Override
//            public void onCancel(DialogInterface dialogInterface) {
//                Log.d("TimePicker", "Dialog was cancelled");
//            }
//        });

    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {
        String time = hourOfDay + ":" + minute;

        Toast.makeText(this, "Time Is: " + time, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

      //  String date = dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
        String date = year + "-" + (monthOfYear+1) + "-" + dayOfMonth;
        Toast.makeText(getApplicationContext(),"Date Is: " + date, Toast.LENGTH_SHORT).show();
    }
}
