package com.ramoscruz.basictodoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItems = (ListView) findViewById(R.id.lvItems);
        items =  new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,items);
        lvItems.setAdapter(itemsAdapter);
        items.add("1er item");
        items.add("2do item");

        setUpViewListener();
    }

    private void setUpViewListener() {
        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                items.remove(i);
                itemsAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    public void onAddItem(View view){
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String message = etNewItem.getText().toString();
        itemsAdapter.add(message);
        etNewItem.setText("");
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }*/
}
