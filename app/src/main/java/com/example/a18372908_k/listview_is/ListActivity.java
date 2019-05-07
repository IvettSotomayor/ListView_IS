package com.example.a18372908_k.listview_is;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        final List<String> nombres = new ArrayList<String>();
        nombres.add("Diego");
        nombres.add("Juan");
        nombres.add("Jorge");
        nombres.add("Matias");
        nombres.add("Diego");
        nombres.add("Juan");
        nombres.add("Jorge");
        nombres.add("Matias");
        nombres.add("Diego");
        nombres.add("Juan");
        nombres.add("Jorge");
        nombres.add("Matias");
        nombres.add("Diego");
        nombres.add("Juan");
        nombres.add("Jorge");
        nombres.add("Matias");
        nombres.add("Diego");
        nombres.add("Juan");
        nombres.add("Jorge");
        nombres.add("Matias");

        //Forma visual que mostraremos los datos
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres);
        //Enlazamos el adaptador con el listview
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Toast.makeText(ListActivity.this, "click en "+nombres.get(i), Toast.LENGTH_LONG).show();
            }
        });

        //Enlazamos con nuestro adaptador personalizado
        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, nombres);
        listView.setAdapter(myAdapter);

    }
}
