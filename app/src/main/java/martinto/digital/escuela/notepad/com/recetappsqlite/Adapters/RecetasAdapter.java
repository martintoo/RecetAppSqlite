package martinto.digital.escuela.notepad.com.recetappsqlite.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import martinto.digital.escuela.notepad.com.recetappsqlite.POJOS.Receta;
import martinto.digital.escuela.notepad.com.recetappsqlite.R;

/**
 * Created by martinto on 16/01/18.
 */

public class RecetasAdapter extends RecyclerView.Adapter<RecetasAdapter.ViewHolder> {
    Context context;
    List<Receta> listaRecetas;

    public RecetasAdapter(Context context, List<Receta> listaRecetas) {
        this.context = context;
        this.listaRecetas = listaRecetas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageView;
        TextView nombre,personas,descripcion,preparacion;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView=(CardView)itemView.findViewById(R.id.cardview);
            imageView=(ImageView)itemView.findViewById(R.id.imagee);
            nombre=(TextView)itemView.findViewById(R.id.nombre);
            personas=(TextView)itemView.findViewById(R.id.personas);
            descripcion=(TextView)itemView.findViewById(R.id.descripcion);
            preparacion=(TextView)itemView.findViewById(R.id.preparacion);
        }
    }
}
