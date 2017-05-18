package mx.evisoft.petagram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.evisoft.petagram.DetalleAnimalCompania;
import mx.evisoft.petagram.R;
import mx.evisoft.petagram.pojo.AnimalCompania;

/**
 * Created by Evana Margáin Puig on 24/07/16.
 */
public class AnimalCompaniaAdaptador extends RecyclerView.Adapter<AnimalCompaniaAdaptador.AnimalCompaniaViewHolder> {

    ArrayList<AnimalCompania> animalesCompania;

    Activity activity;


    public AnimalCompaniaAdaptador(ArrayList<AnimalCompania> animalesCompania, Activity activity){
        this.animalesCompania = animalesCompania;
        this.activity = activity;
    }



    @Override
    public AnimalCompaniaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_animal_compania, parent, false);

        return new AnimalCompaniaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final AnimalCompaniaViewHolder animalCompaniaViewHolder, int position) {
        final AnimalCompania animalCompania = animalesCompania.get(position);
        //animalCompaniaViewHolder.imgvFotoAnimalCompania.setImageResource(animalCompania.getFoto());
        //animalCompaniaViewHolder.txtvNombre.setText(animalCompania.getNombre());

        Integer numeroLikes = animalCompania.getNumeroLikes();

        animalCompaniaViewHolder.txtvLikes.setText(numeroLikes.toString());

        animalCompaniaViewHolder.imgvFotoAnimalCompania.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, animalCompania.getNombre(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(activity, DetalleAnimalCompania.class);
                intent.putExtra("url", animalCompania.getUrlFoto());
                intent.putExtra("like", animalCompania.getNumeroLikes());
                activity.startActivity(intent);

            }
        });

        /*
        animalCompaniaViewHolder.imgvHuesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + animalCompania.getNombre(),
                        Toast.LENGTH_SHORT).show();

                Integer numeroLikes = animalCompania.getNumeroLikes();
                numeroLikes += 1;
                animalCompania.setNumeroLikes(numeroLikes);

                ConstructorAnimalCompania constructorAnimalCompania = new ConstructorAnimalCompania(activity);
                constructorAnimalCompania.darLikeAnimalCompania(animalCompania);
                animalCompaniaViewHolder.txtvLikes.setText(String.valueOf(animalCompania.getNumeroLikes()));


            }
        });*/
    }

    @Override
    public int getItemCount() {
        return animalesCompania.size();
    }

    public static class AnimalCompaniaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgvFotoAnimalCompania;
        //private TextView txtvNombre;
        private TextView txtvLikes;
        //private ImageView imgvHuesoBlanco;


        public AnimalCompaniaViewHolder(View itemView){
            super(itemView);
            imgvFotoAnimalCompania = (ImageView) itemView.findViewById(R.id.imgvFotoAnimalCompania);
            //txtvNombre = (TextView) itemView.findViewById(R.id.txtvNombre);
            txtvLikes = (TextView) itemView.findViewById(R.id.txtvLikes);
            //imgvHuesoBlanco = (ImageView) itemView.findViewById(R.id.imgvHuesoBlanco);
        }
    }
}
