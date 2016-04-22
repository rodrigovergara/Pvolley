package com.example.jefferson.pvolley;

import android.Manifest;
import android.app.DownloadManager;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button btn_send;
    private EditText edt_name, edt_phone, edt_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_name = (EditText) findViewById(R.id.edt_name);
        edt_phone = (EditText) findViewById(R.id.edt_phone);
        edt_email = (EditText) findViewById(R.id.edt_email);
        btn_send = (Button) findViewById(R.id.btn_send);




        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "HOLA", Toast.LENGTH_LONG).show();
                createNewUser();
            }
        });
    }










    private void createNewUser()
    {
        Pvolley.getInstance().add(new StringRequest(Request.Method.POST,"http://rodrigo3moviles.pe.hu/creacion.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Algo salio mal");
                Log.d("mal", "mal");
                error.printStackTrace();
            }
        })  {

            protected  Map<String,String> getParams()throws AuthFailureError{
                Log.d("llega","llega");
                Map<String,String>params= new HashMap<>();
                params.put("name",edt_name.getText().toString());
                params.put("email",edt_email.getText().toString());
                params.put("phone",edt_phone.getText().toString());
                Log.d("pasas", "pasas");
                return params;
            }
        });


    }



}
