package mx.evisoft.petagram.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.evisoft.petagram.R;
import mx.evisoft.petagram.RecyclerView.AnimalCompania;
import mx.evisoft.petagram.RecyclerView.AnimalCompaniaProfile;

/**
 * Created by Evana Margáin Puig on 24/07/16.
 */
public class AnimalCompaniaProfileAdaptador extends RecyclerView.Adapter<AnimalCompaniaProfileAdaptador.AnimalCompaniaViewHolder> {

    ArrayList<AnimalCompaniaProfile> fotos;

    public AnimalCompaniaProfileAdaptador(ArrayList<AnimalCompaniaProfile> fotos){
        this.fotos = fotos;
    }



    @Override
    public AnimalCompaniaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_animal_compania_profile, parent, false);

        return new AnimalCompaniaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final AnimalCompaniaViewHolder animalCompaniaViewHolder, int position) {
        final AnimalCompaniaProfile animalCompania = fotos.get(position);
        animalCompaniaViewHolder.imgvFotoAnimalCompania.setImageResource(animalCompania.getFoto());
        animalCompaniaViewHolder.txtvLikes.setText(animalCompania.getNumeroLikes());

    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public static class AnimalCompaniaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgvFotoAnimalCompania;
        private TextView txtvLikes;


        public AnimalCompaniaViewHolder(View itemView){
            super(itemView);
            imgvFotoAnimalCompania = (ImageView) itemView.findViewById(R.id.imgvFotoAnimalCompania);
            txtvLikes = (TextView) itemView.findViewById(R.id.txtvLikes);
        }
    }
}
