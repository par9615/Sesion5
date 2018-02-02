package com.example.par9615.sesion5;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {
    AlertDialog.Builder cleanDialogBuilder;
    AlertDialog cleanDialog;
    AutoCompleteTextView bookAutoComplete;
    EditText name, phone;
    Spinner education;
    RadioGroup sex;
    RadioButton selected_sex;
    CheckBox sport;
    Student student;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///IDs setting
        bookAutoComplete = findViewById(R.id.activity_main_book_autocomplete);
        name = findViewById(R.id.activity_main_name_edit_text);
        phone = findViewById(R.id.activity_main_phone_edit_text);
        education = findViewById(R.id.activity_main_education_spinner);
        sex = findViewById(R.id.activity_main_sex_radio_group);
        sport = findViewById(R.id.activity_main_sport_checkbox);
        ///

        ///AutoCompleteTextView initialization
        String[] books = getResources().getStringArray(R.array.book_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, books);
        bookAutoComplete.setAdapter(adapter);
        ///

        ///Dialog initialization
        cleanDialogBuilder = new AlertDialog.Builder(ActivityMain.this);
        cleanDialogBuilder.setMessage(R.string.activity_main_clean_message);
        cleanDialogBuilder.setPositiveButton(R.string.activity_main_clean_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cleanContent();
            }
        });
        cleanDialogBuilder.setNegativeButton(R.string.activity_main_clean_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        cleanDialog = cleanDialogBuilder.create();
        ///

    }

    public void cleanContent() {
        name.getText().clear();
        phone.getText().clear();
        bookAutoComplete.getText().clear();
        education.setSelection(0);
        sex.check(R.id.activity_main_radio_button_f);
        sport.setChecked(false);

    }

    public void restore(Bundle savedInstanceState)
    {
        name.setText(savedInstanceState.getString("NAME"));
        phone.setText(savedInstanceState.getString("PHONE"));
        education.setSelection(savedInstanceState.getInt("EDUCATION"));
        sex.check(savedInstanceState.getInt("SEX"));
        sport.setChecked(savedInstanceState.getBoolean("SPORT"));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        restore(savedInstanceState);
    }

    public void save(Bundle outState)
    {
        outState.putString("NAME", name.getText().toString());
        outState.putString("PHONE", phone.getText().toString());
        outState.putInt("EDUCATION", education.getSelectedItemPosition());
        outState.putInt("SEX", sex.getCheckedRadioButtonId());
        outState.putString("BOOK", bookAutoComplete.getText().toString());
        outState.putBoolean("SPORT", sport.isChecked());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        save(outState);
        super.onSaveInstanceState(outState);
    }

    public void showMessage()
    {
        selected_sex = findViewById(sex.getCheckedRadioButtonId());
       student = new Student(name.getText().toString(),
                            phone.getText().toString(),
                            education.getSelectedItem().toString(),
                            selected_sex.getText().toString(),
                            bookAutoComplete.getText().toString(),
                            sport.isChecked());

        Toast.makeText(ActivityMain.this, student.toString(), Toast.LENGTH_LONG).show();
    }

    public void showCleanDialog(View view) {
        cleanDialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.activity_menu_save:
                showMessage();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return true;
    }

}
