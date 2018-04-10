package practica.edu.pe.lab05_calificado.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import practica.edu.pe.lab05_calificado.Activities.DetailActivity;
import practica.edu.pe.lab05_calificado.Models.Productos;
import practica.edu.pe.lab05_calificado.R;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ViewHolder>{
    private List<Productos> producto;

    public void setProduct(List<Productos> product) {
        this.producto = product;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private Button enviar;
        ImageView Image;
        TextView name;
        TextView phone;

        public ViewHolder(View itemView) {
            super(itemView);
            Image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.title);
            phone = itemView.findViewById(R.id.phone);
            enviar = itemView.findViewById(R.id.button);

            //   descText = itemView.findViewById(R.id.te);

        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final Productos prod = producto.get(position);
        final int resId = holder.itemView.getContext().getResources().getIdentifier(prod.getPicture(), "drawable", holder.itemView.getContext().getPackageName()); //busca la imagen mediante el registro del adaptador people
        holder.Image.setImageResource(resId);

        holder.name.setText(prod.getName());
        holder.phone.setText(prod.getPhone());
        holder.enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("nameText", prod.getPhone() );
                intent.putExtra("nameimg", prod.getName() );
                intent.putExtra("namedis", prod.getDescripcion() );
                intent.putExtra("nameimg2", holder.itemView.getContext().getResources().getIdentifier(prod.getPicture(), "drawable", holder.itemView.getContext().getPackageName()) );


                holder.itemView.getContext().startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return producto.size();
    }



}
