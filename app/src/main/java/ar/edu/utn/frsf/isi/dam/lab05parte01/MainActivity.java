package ar.edu.utn.frsf.isi.dam.lab05parte01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private WebView wv;
    private List<Tarea> tareas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv = (WebView) findViewById(R.id.navegador);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.addJavascriptInterface(new TareaDao(this), "tareaDaoAndroid");
        wv.loadUrl("file:///android_asset/index.html");
    }
}
