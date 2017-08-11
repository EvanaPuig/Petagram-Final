package mx.evisoft.petagram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mx.evisoft.petagram.R;
import mx.evisoft.petagram.pojo.AnimalCompania;
import mx.evisoft.petagram.pojo.AnimalCompaniaProfile;

/**
 * Created by Evana Margáin Puig on 24/07/16.
 */
public class AnimalCompaniaProfileAdaptador extends RecyclerView.Adapter<AnimalCompaniaProfileAdaptador.AnimalCompaniaViewHolder> {

    ArrayList<AnimalCompania> animalesCompania;

    Activity activity;

    public AnimalCompaniaProfileAdaptador(ArrayList<AnimalCompania> animalesCompania, Activity activity){
        this.animalesCompania = animalesCompania;
        this.activity = activity;
    }



    @Override
    public AnimalCompaniaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_animal_compania_profile, parent, false);

        return new AnimalCompaniaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final AnimalCompaniaViewHolder animalCompaniaViewHolder, int position) {
        //final AnimalCompaniaProfile animalCompania = fotos.get(position);
        final AnimalCompania animalCompania = animalesCompania.get(position);
        Picasso.with(activity)
                .load(animalCompania.getUrlFoto())
                .placeholder(R.drawable.perro2)
                .into(animalCompaniaViewHolder.imgvFotoAnimalCompania);
        animalCompaniaViewHolder.txtvLikes.setText(animalCompania.getLikes());

    }

    @Override
    public int getItemCount() {
        return animalesCompania.size();
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
