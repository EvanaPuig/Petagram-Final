package mx.evisoft.petagram.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.evisoft.petagram.R;
import mx.evisoft.petagram.RecyclerView.AnimalCompania;
import mx.evisoft.petagram.db.BaseDatos;
import mx.evisoft.petagram.db.ConstantesBaseDatos;

/**
 * Created by Evana Margáin Puig on 24/07/16.
 */
public class AnimalCompaniaAdaptador extends RecyclerView.Adapter<AnimalCompaniaAdaptador.AnimalCompaniaViewHolder> {

    ArrayList<AnimalCompania> animalesCompania;

    private Context context;


    public AnimalCompaniaAdaptador(ArrayList<AnimalCompania> animalesCompania, Context context){
        this.animalesCompania = animalesCompania;
        this.context = context;
    }



    @Override
    public AnimalCompaniaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_animal_compania, parent, false);

        return new AnimalCompaniaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final AnimalCompaniaViewHolder animalCompaniaViewHolder, int position) {
        final AnimalCompania animalCompania = animalesCompania.get(position);
        animalCompaniaViewHolder.imgvFotoAnimalCompania.setImageResource(animalCompania.getFoto());
        animalCompaniaViewHolder.txtvNombre.setText(animalCompania.getNombre());

        Integer numeroLikes = animalCompania.getNumeroLikes();

        animalCompaniaViewHolder.txtvLikes.setText(numeroLikes.toString());


        animalCompaniaViewHolder.imgvHuesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer numeroLikes = animalCompania.getNumeroLikes();
                numeroLikes += 1;
                animalCompania.setNumeroLikes(numeroLikes);
                animalCompaniaViewHolder.txtvLikes.setText(numeroLikes.toString());

                BaseDatos db = new BaseDatos(context);
                insertarContactoLike(db, animalCompania);


            }
        });
    }

    @Override
    public int getItemCount() {
        return animalesCompania.size();
    }

    public static class AnimalCompaniaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgvFotoAnimalCompania;
        private TextView txtvNombre;
        private TextView txtvLikes;
        private ImageView imgvHuesoBlanco;


        public AnimalCompaniaViewHolder(View itemView){
            super(itemView);
            imgvFotoAnimalCompania = (ImageView) itemView.findViewById(R.id.imgvFotoAnimalCompania);
            txtvNombre = (TextView) itemView.findViewById(R.id.txtvNombre);
            txtvLikes = (TextView) itemView.findViewById(R.id.txtvLikes);
            imgvHuesoBlanco = (ImageView) itemView.findViewById(R.id.imgvHuesoBlanco);
        }
    }

    public void insertarContactoLike(BaseDatos db, AnimalCompania animalCompania){
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_ID, animalCompania.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NOMBRE, animalCompania.getNombre());
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NUMERO_LIKES, animalCompania.getNumeroLikes());
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_FOTO, animalCompania.getFoto());

        db.actualizarAnimalCompania(contentValues, animalCompania);

    }
}
