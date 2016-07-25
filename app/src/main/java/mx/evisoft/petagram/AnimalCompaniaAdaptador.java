package mx.evisoft.petagram;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by softtek on 24/07/16.
 */
public class AnimalCompaniaAdaptador extends RecyclerView.Adapter<AnimalCompaniaAdaptador.AnimalCompaniaViewHolder> {

    ArrayList<AnimalCompania> animalesCompania;

    public AnimalCompaniaAdaptador(ArrayList<AnimalCompania> animalesCompania){
        this.animalesCompania = animalesCompania;
    }



    @Override
    public AnimalCompaniaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_animal_compania, parent, false);

        return new AnimalCompaniaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AnimalCompaniaViewHolder animalCompaniaViewHolder, int position) {
        AnimalCompania animalCompania = animalesCompania.get(position);
        animalCompaniaViewHolder.imgvFotoAnimalCompania.setImageResource(animalCompania.getFoto());
        animalCompaniaViewHolder.txtvNombre.setText(animalCompania.getNombre());
        animalCompaniaViewHolder.txtvLikes.setText(animalCompania.getNumeroLikes());
    }

    @Override
    public int getItemCount() {
        return animalesCompania.size();
    }

    public static class AnimalCompaniaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgvFotoAnimalCompania;
        private TextView txtvNombre;
        private TextView txtvLikes;

        public AnimalCompaniaViewHolder(View itemView){
            super(itemView);
            imgvFotoAnimalCompania = (ImageView) itemView.findViewById(R.id.imgvFotoAnimalCompania);
            txtvNombre = (TextView) itemView.findViewById(R.id.txtvNombre);
            txtvLikes = (TextView) itemView.findViewById(R.id.txtvLikes);
        }
    }
}
