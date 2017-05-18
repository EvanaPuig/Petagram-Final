package mx.evisoft.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import mx.evisoft.petagram.db.BaseDatos;
import mx.evisoft.petagram.db.ConstantesBaseDatos;
import mx.evisoft.petagram.R;
import mx.evisoft.petagram.pojo.AnimalCompania;

import java.util.ArrayList;

/**
 * Created by Evana Margáin Puig on 3/7/17.
 */

public class ConstructorAnimalCompania {

    private static String TAG = "mx.evisoft.petagram";
    private static final int LIKE = 1;
    private Context context;
    public ConstructorAnimalCompania(Context context) {
        this.context = context;
    }

    public ArrayList<AnimalCompania> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        insertarTresAnimalesCompania(db);
        return  db.obtenerTodosAnimalesCompania();
    }



    public void insertarTresAnimalesCompania(BaseDatos db){
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_ID, 1);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NOMBRE, "Carlitos");
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NUMERO_LIKES, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_FOTO, R.drawable.perro1);

        db.insertarAnimalCompania(contentValues);

        contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_ID, 2);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NOMBRE, "Xola");
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NUMERO_LIKES, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_FOTO, R.drawable.perro2);

        db.insertarAnimalCompania(contentValues);

        contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_ID, 3);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NOMBRE, "Huevo");
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NUMERO_LIKES, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_FOTO, R.drawable.perro3);

        db.insertarAnimalCompania(contentValues);
    }

    public void darLikeAnimalCompania(AnimalCompania animalCompania){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_ID, animalCompania.getId());


        int nuevoLike = animalCompania.getNumeroLikes() + 1;

        Log.d(TAG, String.valueOf(nuevoLike));

        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NUMERO_LIKES, nuevoLike);
        db.actualizarAnimalCompania(contentValues, animalCompania);
    }


}
