package ar.edu.utn.frsf.isi.dam.lab05parte01;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.webkit.JavascriptInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by mdominguez on 23/11/17.
 */

public class TareaDao {

    private Context contexto;
    private TareaDBHelper dbHelper;

    public TareaDao(Context c){
        this.contexto= c;
        dbHelper = new TareaDBHelper(c);
    }

    @JavascriptInterface
    public void crearTarea(String nombre,String detalle){
        // Gets the data repository in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("descripcion", detalle);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert("TAREA", null, values);
    }

    @JavascriptInterface
    public String listaJson(){
        JSONArray arregloJSON = new JSONArray();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT _id,nombre,descripcion FROM TAREA",null);
        if (c.getCount() > 0){
            c.moveToFirst();
            do {
                JSONObject fila = new JSONObject();
                try {
                    fila.put("id",c.getInt(c.getColumnIndex("_id")));
                    fila.put("nombre",c.getString(c.getColumnIndex("nombre")));
                    fila.put("descripcion",c.getString(c.getColumnIndex("descripcion")));
                    arregloJSON.put(fila);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } while (c.moveToNext());
            c.close();
        }
        return  arregloJSON.toString();
    }
}
