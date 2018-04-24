package practica.edu.pe.lab05_calificado.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import practica.edu.pe.lab05_calificado.Adapter.ProductosAdapter;
import practica.edu.pe.lab05_calificado.R;
import practica.edu.pe.lab05_calificado.Repositories.ProductosRepository;

public class MainActivity extends AppCompatActivity {
    Button buscar;
    EditText text;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text= findViewById(R.id.text);
        buscar=findViewById(R.id.buscar);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                intent.putExtra("mensaje", text.getText().toString());
                startActivity(intent);
            }
        });


    }




}