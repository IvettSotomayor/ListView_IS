package com.example.a18372908_k.listview_is;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity{
    private List<String> nombres;
    private GridView gridView;
    private MyAdapter myAdapter;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridView = (GridView) findViewById(R.id.gridView);
        nombres = new ArrayList<String>();
        /*nombres.add("Diego");
        nombres.add("Juan");
        nombres.add("Jorge");
        nombres.add("Matias");*/

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridActivity.this, "Click en "+nombres.get(i), Toast.LENGTH_LONG).show();
            }
        });

        //Enlazamos con nuestro adaptador personalizado
        myAdapter = new MyAdapter(this, R.layout.grid_item, nombres);
        gridView.setAdapter(myAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.add_item:
                //Agregamos nuevo nombre
                this.nombres.add("Nombre "+(++contador));
                //Notificamos al adaptador del cambio producido
                this.myAdapter.notifyDataSetChanged();
                return true;

            case R.id.delete_item:
                this.nombres.remove("Nombre "+(contador--));
                //Notificamos al adaptador del cambio producido
                this.myAdapter.notifyDataSetChanged();
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }
    }


}
