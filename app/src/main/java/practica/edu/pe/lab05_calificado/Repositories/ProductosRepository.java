package practica.edu.pe.lab05_calificado.Repositories;

import java.util.ArrayList;
import java.util.List;

import practica.edu.pe.lab05_calificado.Models.Producto;

public class ProductosRepository {
    private static List<Producto> productos= new ArrayList<>();

   static {
       productos.add(new Producto("Bembos", "987654321", "bembos", "venta de embutidos"));
       productos.add(new Producto("Corralito", "908765431", "corralito", "venta de pollos"));
       productos.add(new Producto("Pizza hut", "(01)908765", "pizzahut", "venta de pizzas y pastas"));
       productos.add(new Producto("KFC", "987654321", "kfc", "Venta de pollos"));
       productos.add(new Producto("McDonalds", "99765322", "donalds", "Comida"));
   }
    public static List<Producto> getList(){
        return productos;
    }

}
