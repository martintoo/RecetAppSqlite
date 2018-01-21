package martinto.digital.escuela.notepad.com.recetappsqlite;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import martinto.digital.escuela.notepad.com.recetappsqlite.Adapters.RecetasAdapter;
import martinto.digital.escuela.notepad.com.recetappsqlite.POJOS.Receta;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewRecetas;
    ArrayList<Receta> recetaArrayList;
    RecetasAdapter recetasAdapter;
    Data data;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createData();
        setContentView(R.layout.activity_main);
        recyclerViewRecetas=(RecyclerView) findViewById(R.id.recyclerRecetas);
        LinearLayoutManager linearLayoutManager=
                new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewRecetas.setLayoutManager(linearLayoutManager);
        //recetasAdapter=new RecetasAdapter(this,recetaArrayList);
        //recyclerViewRecetas.setAdapter(recetasAdapter);
        update();
        //---------------
        // Evento pulsar a la derecha
        //---------------
        ItemTouchHelper.SimpleCallback simpleCallback=
                //Si quisiera varios pongo un pipe ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT
                new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                //muchas direction
                //switch (direction) case 1; case 2
                int position=viewHolder.getAdapterPosition();
                RecetasAdapter recetasAdapter=(RecetasAdapter) recyclerViewRecetas.getAdapter();
                String value=recetasAdapter.listaRecetas.get(position).getNombre();
                data.deleteItem(value);
                update();
            }
        };
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerViewRecetas);
        //---------------
        //Fin evento pulsar a la derecha
        //---------------

        floatingActionButton=(FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AddRecetaActivity.class);
                startActivity(intent);
            }
        });
    }

    public void createData(){
        recetaArrayList=new ArrayList<>();
        recetaArrayList.add(new Receta("1","Sandwich",2,"Pan con tomate,jamon,pepino y queso",
                "Asi es como se cocina un sandwich","http://imagenes.png",5));
        recetaArrayList.add(new Receta("2","Huevos",1,"Huevos con tomate,jamon,pepino y queso",
                "Asi es como se cocina un huevo","http://imagenes.png",2));
        recetaArrayList.add(new Receta("3","Hot cakes",5,"Harica con tomate,jamon,pepino y queso",
                "Asi es como se cocina un hot cake","http://imagenes.png",0));
        recetaArrayList.add(new Receta("4","Donas",2,"Pan con tomate,jamon,pepino y queso",
                "Asi es como se cocina un sandwich","http://imagenes.png",5));
        recetaArrayList.add(new Receta("5","Pescado",3,"Pescado con tomate,jamon,pepino y queso",
                "Asi es como se cocina un Pescado","http://imagenes.png",4));
        recetaArrayList.add(new Receta("6","Tacos",4,"Tacos con tomate,jamon,pepino y queso",
                "Asi es como se cocina un tacos","http://imagenes.png",1));
        recetaArrayList.add(new Receta("7","Empanadas",2,"Empanada con tomate,jamon,pepino y queso",
                "Asi es como se cocina un sandwich","http://imagenes.png",6));
        recetaArrayList.add(new Receta("8","Leche de tigre",7,"Leche de tigre con tomate,jamon,pepino y queso",
                "Asi es como se cocina un Leche de tigre","http://imagenes.png",0));
        data=new Data(this);
        data.open();
        data.insertarRecetas(recetaArrayList);
    }

    public List<Receta> getData(){
        List<Receta> recetas=data.getAll();
        return recetas;
    }

    public void update(){
        recetasAdapter=new RecetasAdapter(this, getData());
        recyclerViewRecetas.setAdapter(recetasAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        update();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.favs:
                recetasAdapter=new RecetasAdapter(this,data.getFavs());
                recyclerViewRecetas.setAdapter(recetasAdapter);
                return true;
            case R.id.personaz:
                recetasAdapter=new RecetasAdapter(this,data.getPersonas(2));
                recyclerViewRecetas.setAdapter(recetasAdapter);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
