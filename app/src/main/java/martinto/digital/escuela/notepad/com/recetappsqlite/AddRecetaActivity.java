package martinto.digital.escuela.notepad.com.recetappsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import martinto.digital.escuela.notepad.com.recetappsqlite.POJOS.Receta;

public class AddRecetaActivity extends AppCompatActivity {
    EditText id,nombre,personas,descripcion,preparacion,fav;
    Button btnadd;
    Receta receta;
    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_receta);
        id=(EditText)findViewById(R.id.idRecetaN);
        nombre=(EditText)findViewById(R.id.nombreRecetaN);
        personas=(EditText)findViewById(R.id.personasRecetaN);
        descripcion=(EditText)findViewById(R.id.descripcionRecetaN);
        preparacion=(EditText)findViewById(R.id.preparacionRecetaN);
        fav=(EditText)findViewById(R.id.favRecetaN);
        btnadd=(Button) findViewById(R.id.btnAdd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                receta=new Receta(id.getText().toString(),nombre.getText().toString(),
                        Integer.valueOf(personas.getText().toString()),
                        descripcion.getText().toString(),
                        preparacion.getText().toString(),
                        "imagen.jpg",Integer.valueOf(fav.getText().toString()));
                data=new Data(getApplicationContext());
                data.open();
                data.insertReceta(receta);
                Toast.makeText(getApplicationContext(),"Se agrego la receta"
                        ,Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
// http://www.subtorrents.net/series/game-of-thrones/