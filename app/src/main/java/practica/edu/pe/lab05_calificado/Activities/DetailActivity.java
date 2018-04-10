package practica.edu.pe.lab05_calificado.Activities;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import practica.edu.pe.lab05_calificado.R;
import practica.edu.pe.lab05_calificado.Activities.DetailActivity;

public class DetailActivity extends AppCompatActivity {
    Button send;
    private Button volver;
    private static final int numero=985184554;
    private static final int PERMISSIONS_REQUEST=100;
    final int SEND_SMS_PERMISSION_REQUEST_CODE= 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        send= (Button) findViewById(R.id.button);

        volver = (Button)findViewById(R.id.volver);

        getIncomingIntent();


    }


    public void volver(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);


    }


    public void getIncomingIntent(){

        if (getIntent().hasExtra("nameText")&& getIntent().hasExtra("nameimg")&& getIntent().hasExtra("namedis")&& getIntent().hasExtra("nameadr")&& getIntent().hasExtra("nameimg2")){
            String im=getIntent().getStringExtra("nameText");

            String img=getIntent().getStringExtra("nameimg");
            String imgdes=getIntent().getStringExtra("namedis");
            String adress=getIntent().getStringExtra("nameadr");
            Integer img2=getIntent().getIntExtra("nameimg2",2);

            settext(im,img,imgdes,adress,img2);
        }
    }
    public void settext(String im, String img, String imgdes, String adress,Integer img2){
        TextView name=findViewById(R.id.textView2);
        name.setText(img);
        TextView name2=findViewById(R.id.text);
        name2.setText(im);
        TextView name3=findViewById(R.id.textInformation);
        name3.setText(imgdes);
        TextView name4=findViewById(R.id.txtdireccion);
        name4.setText(adress);
        ImageView name5=findViewById(R.id.imagedetalle);
        name5.setImageResource(img2);


    }
//metodo para os permispoos de llamada

    public void call(View view){

        // Check permission (Api 22 check in Manifest, Api 23 check by requestPermissions)
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // Dont have permission => request one or many permissions (String[])
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSIONS_REQUEST);
        }else {
            // Have permission

            openCallApplication();
        }
    }


    // On request permissions result
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        switch (requestCode) {
            case PERMISSIONS_REQUEST: {
                if (permissions[0].equals(Manifest.permission.CALL_PHONE)) {
                    if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                        openCallApplication();
                    }else{
                        Toast.makeText(this, "CALL_PHONE permissions declined!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
    public void openCallApplication(){
        String numero=getIntent().getStringExtra("nameText");

        if(numero.isEmpty()){
            Toast.makeText(this, "Phone number required!", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+numero));

        // Is necesary to check permission again before startActivity
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
            startActivity(intent);
    }


    //llamada del enlace de la web
    public void callurl(View view){
        // Check permission (Api 22 check in Manifest, Api 23 check by requestPermissions)
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // Dont have permission => request one or many permissions (String[])
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSIONS_REQUEST);
        }else {
            // Have permission

            openWeb();        }
    }



    public void openWeb(){
        String urltext=getIntent().getStringExtra("nameweb");
        if(urltext.isEmpty()){
            Toast.makeText(this, "Direccion es requerida", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://"+urltext));


        // Is necesary to check permission again before startActivity
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
            startActivity(intent);
    }




    //permisos para enviar mensaje
    public boolean checkPermission(String permission){
        int check = ContextCompat.checkSelfPermission(this,permission);
        return (check== PackageManager.PERMISSION_GRANTED);
    }

//metodo par enviar el mensaje


}
