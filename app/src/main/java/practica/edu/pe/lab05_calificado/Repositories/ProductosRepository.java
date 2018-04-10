package practica.edu.pe.lab05_calificado.Repositories;

import java.util.ArrayList;
import java.util.List;

import practica.edu.pe.lab05_calificado.Models.Productos;

public class ProductosRepository {
    public static List<Productos> productos= new ArrayList<>();

   static {
       productos.add(new Productos("Bembos", "987654321", "bembos", "venta de embutidos"));
       productos.add(new Productos("Corralito", "908765431", "corralito", "venta de pollos"));
       productos.add(new Productos("Pizza hut", "(01)908765", "pizzahut", "venta de pizzas y pastas"));
       productos.add(new Productos("KFC", "987654321", "kfc", "Venta de pollos"));
       productos.add(new Productos("McDonalds", "99765322", "donalds", "Comida"));
   }
    public static List<Productos> getList(){
        return productos;
    }

}
