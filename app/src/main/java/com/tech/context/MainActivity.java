package com.tech.context;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imgSuper;
    Button btnMenu;
    ListView usersList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgSuper = findViewById(R.id.imgSuper);
        btnMenu = findViewById(R.id.btnMenu);
        usersList = findViewById(R.id.usersList);
        registerForContextMenu(imgSuper);

        ArrayList<String> values = new ArrayList<>();
        values.add("alger");
        values.add("annaba");
        values.add("oran");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,values);
        usersList.setAdapter(adapter);



        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupmenu = new PopupMenu(MainActivity.this,btnMenu);
                popupmenu.getMenuInflater().inflate(R.menu.wilaya,popupmenu.getMenu());

                popupmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();

                        return false;
                    }
                });

                popupmenu.show();
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.wilaya,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.alger :
                Toast.makeText(this, "alger selectionner", Toast.LENGTH_SHORT).show();

                break;

            case R.id.oran :
                Toast.makeText(this, "oran selectionner", Toast.LENGTH_SHORT).show();

                break;

            case R.id.annaba :
                Toast.makeText(this, "annaba selectionner", Toast.LENGTH_SHORT).show();

                break;
        }

        return super.onContextItemSelected(item);
    }
}
