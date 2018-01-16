package martinto.digital.escuela.notepad.com.recetappsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import martinto.digital.escuela.notepad.com.recetappsqlite.Adapters.RecetasAdapter;
import martinto.digital.escuela.notepad.com.recetappsqlite.POJOS.Receta;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewRecetas;
    ArrayList<Receta> recetaArrayList;
    RecetasAdapter recetasAdapter;

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
        recetasAdapter=new RecetasAdapter(this,recetaArrayList);
        recyclerViewRecetas.setAdapter(recetasAdapter);
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

    }
}
