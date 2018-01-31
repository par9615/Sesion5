package com.example.par9615.sesion5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class ActivityMain extends AppCompatActivity {
    AutoCompleteTextView bookAutoComplete;
    EditText name, phone;
    Spinner education;
    RadioGroup sex;
    CheckBox sport;


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
        outState.putBoolean("SPORT", sport.isChecked());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        save(outState);
        super.onSaveInstanceState(outState);
    }
}
