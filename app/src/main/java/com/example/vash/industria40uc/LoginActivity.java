package com.example.vash.industria40uc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsuario, etContra;
    Button btnIngresar;
    String usuario, pasword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etContra = findViewById(R.id.etContra);
        etUsuario = findViewById(R.id.etUsuario);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        usuario = etUsuario.getText().toString();
        pasword = etContra.getText().toString();

        if(!usuario.isEmpty() && !pasword.isEmpty()){
            validarUsuario("http://ymarquez.webfactional.com/serviciosRest/controladores/user.php");
        }else{
            Toast.makeText(LoginActivity.this,"NO SE PERMITEN CAMPOS VACIOS",Toast.LENGTH_SHORT).show();

        }

    }

    private void validarUsuario(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    Intent i = new Intent(getApplicationContext(),AsistenciaActivity.class);
                    i.putExtra("correo_usr",etUsuario.getText().toString());
                    startActivity(i);
                }else{
                    Toast.makeText(LoginActivity.this,"CREDENCIALES INVALIDAS",Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String, String>();
                parametros.put("usuario",etUsuario.getText().toString());
                parametros.put("password",etContra.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
