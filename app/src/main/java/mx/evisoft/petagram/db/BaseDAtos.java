package mx.evisoft.petagram.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;

import mx.evisoft.petagram.RecyclerView.AnimalCompania;

/**
 * Created by Evana Margáin Puig on 13/11/16.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA + "(" +
                                        ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_ID            + " INTEGER PRIMARY KEY, " +
                                        ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NOMBRE        + " TEXT, " +
                                        ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NUMERO_LIKES  + " INTEGER, " +
                                        ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_FOTO          + " INTEGER" +
                                        ")";

        db.execSQL(queryCrearTablaContacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA);
        onCreate(db);
    }

    public ArrayList<AnimalCompania> obtenerTodosAnimalesCompania(){
        ArrayList<AnimalCompania> animalesCompania = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){
            AnimalCompania animalCompaniaActual = new AnimalCompania();

            animalCompaniaActual.setId(registros.getInt(0));
            animalCompaniaActual.setNombre(registros.getString(1));
            animalCompaniaActual.setNumeroLikes(registros.getInt(2));
            animalCompaniaActual.setFoto(registros.getInt(3));
            animalesCompania.add(animalCompaniaActual);
        }

        return  animalesCompania;
    }

    public ArrayList<AnimalCompania> obtenerFavoritos(){
        ArrayList<AnimalCompania> animalesCompania = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA + " ORDER BY " + ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NUMERO_LIKES +  " DESC LIMIT 5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){
            AnimalCompania animalCompaniaActual = new AnimalCompania();

            animalCompaniaActual.setId(registros.getInt(0));
            animalCompaniaActual.setNombre(registros.getString(1));
            animalCompaniaActual.setNumeroLikes(registros.getInt(2));
            animalCompaniaActual.setFoto(registros.getInt(3));
            animalesCompania.add(animalCompaniaActual);
        }

        return  animalesCompania;
    }

    public void insertarAnimalCompania(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA, null, contentValues);

        db.close();
    }

    public void actualizarAnimalCompania(ContentValues contentValues, AnimalCompania animalCompania){
        SQLiteDatabase db = this.getWritableDatabase();

        db.update(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA, contentValues, "id=" + animalCompania.getId(), null);
    }
}
