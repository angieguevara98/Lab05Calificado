package practica.edu.pe.lab05_calificado.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import practica.edu.pe.lab05_calificado.Adapter.ProductosAdapter;
import practica.edu.pe.lab05_calificado.Models.Producto;
import practica.edu.pe.lab05_calificado.R;
import practica.edu.pe.lab05_calificado.Repositories.ProductosRepository;

public class SearchActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    EditText editText;

    ProductosAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ProductosAdapter();
        adapter.setProduct(ProductosRepository.getList());

        recyclerView.setAdapter(adapter);

        editText=(EditText) findViewById(R.id.buscar);
        Bundle bundle=getIntent().getExtras();
        String dato=bundle.getString("mensaje").toString();
        editText.setText(dato);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });


    }
    private void filter(String s) {
        ArrayList<Producto> filterList = new ArrayList<>();
        for (Producto item : ProductosRepository.getList()) {
            if (item.getName().toLowerCase().contains(s.toLowerCase())) {filterList.add(item);}
        }
        adapter.filterList(filterList);

        }
    }


