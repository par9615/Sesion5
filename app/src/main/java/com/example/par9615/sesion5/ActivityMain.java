package com.example.par9615.sesion5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class ActivityMain extends AppCompatActivity {
    AutoCompleteTextView bookAutoComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///AutoCompleteTextView initialization
        bookAutoComplete = findViewById(R.id.activity_main_book_autocomplete);
        String[] books = getResources().getStringArray(R.array.book_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, books);
        bookAutoComplete.setAdapter(adapter);
        ///

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
