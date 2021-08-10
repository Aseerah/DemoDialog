package sg.edu.rp.c346.id20009530.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //step1
    Button buttonDemo1, buttonDemo2, buttonDemo3, buttonDemo4, buttonDatePicker, buttonDemo5;
    TextView tv2, tv3, tv4, tvDatePicker, tv5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //step2
        buttonDemo1 = findViewById(R.id.buttonDemo1);
        buttonDemo2 = findViewById(R.id.buttonDemo2);
        buttonDemo3 = findViewById(R.id.buttonDemo3);
        buttonDemo4 = findViewById(R.id.buttonDemo4);
        buttonDatePicker = findViewById(R.id.buttonDemoDatePicker);
        buttonDemo5 = findViewById(R.id.buttonDemo5);


        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tvDatePicker = findViewById(R.id.tvDatePicker);
        tv5 = findViewById(R.id.tv5);


        buttonDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create the dialog builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //set dialog details
//                myBuilder.setTitle("Demo 1-Simple Dialog");
//                myBuilder.setMessage("I can develop Anroid App.");
//                myBuilder.setCancelable(false);
//                myBuilder.setPositiveButton("close",null);

                myBuilder.setTitle("Congratulations !!");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Dismiss", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        buttonDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create the dialog builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //set dialog details
                myBuilder.setTitle("Demo 2-Button Dialog");
                myBuilder.setMessage("Select one of the button below");
                myBuilder.setCancelable(false);

                //configure the 'positive button'
                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tv2.setText("You have selected Yes.");
                    }
                });

                //configure the 'negative button'
                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tv2.setText("You have selected No.");
                    }
                });


                // configure the neutral button
                myBuilder.setNeutralButton("cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        buttonDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inflate the input.cml layout
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                //obtain the ui Component in the input.xml layout file
                //it needs to be defined as 'final', so that it can be used in the onClick() method later

                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                //create the dialog builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //set dialog details
                myBuilder.setView(viewDialog); // set the view of the dialog
                myBuilder.setTitle("Demo 3-Text input Dialog");

                //configure the 'positive button'
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Extract the text entered by the user
                        String message = etInput.getText().toString();
                        // Set the text to the textView
                        tv3.setText(message);
                    }
                });

                // configure the neutral button
                myBuilder.setNegativeButton("cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });


        buttonDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inflate the input.cml layout
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.exercise3, null);

                //obtain the ui Component in the input.xml layout file
                //it needs to be defined as 'final', so that it can be used in the onClick() method later

                final EditText etInput = viewDialog.findViewById(R.id.etNo1);
                final EditText etInput2 = viewDialog.findViewById(R.id.etNo2);

                //create the dialog builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //set dialog details
                myBuilder.setView(viewDialog); // set the view of the dialog
//                myBuilder.setTitle("Exercise 3");

                //configure the 'positive button'
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Extract the text entered by the user
                        int num1 = Integer.parseInt(etInput.getText().toString());
                        int num2 = Integer.parseInt(etInput2.getText().toString());
                        // Set the text to the textView
                        int message = num1 + num2;
                        tv4.setText("The sum is " + message);
                    }
                });

                // configure the neutral button
                myBuilder.setNegativeButton("cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        buttonDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // create the listener to set the date
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvDatePicker.setText("Date: " + dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                };
//
//                //create the date picker dialog
//                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, 2014,11,31);
//                myDateDialog.show();

                // create the date picker dialog to show the current date
                Calendar now = Calendar.getInstance();
                int year = now.get(Calendar.YEAR);
                int month = now.get(Calendar.MONTH);
                int day = now.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, year, month, day);
                myDateDialog.show();


            }
        });

        buttonDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // create the listener to set the date
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tv5.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };

//                // create the time picker dialog
//                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, 20, 00,false);
//                myTimeDialog.show();

                // Create the Date Picker Dialog to show the current date when it first appears
                Calendar now = Calendar.getInstance();
                int hourOfDay = now.get(Calendar.HOUR_OF_DAY);  // Current Hour
                int minute = now.get(Calendar.MINUTE);  // Current Minute
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                        myTimeListener, hourOfDay, minute, true);

                myTimeDialog.show();

            }
        });

    }
}