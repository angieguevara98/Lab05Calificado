package practica.edu.pe.lab05_calificado.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import practica.edu.pe.lab05_calificado.Adapter.ProductosAdapter;
import practica.edu.pe.lab05_calificado.R;
import practica.edu.pe.lab05_calificado.Repositories.ProductosRepository;

public class MainActivity extends AppCompatActivity {

    RecyclerView listproducts;
    ProductosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listproducts = (RecyclerView) findViewById(R.id.RecyclerView);


        listproducts.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ProductosAdapter();
        adapter.setProduct(ProductosRepository.getList());

        listproducts.setAdapter(adapter);

    }




}