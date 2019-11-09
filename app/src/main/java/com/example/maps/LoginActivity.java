package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

public class LoginActivity extends AppCompatActivity {
    private static final String ARCHI_PREFERENCIA="Preferencias_app";
    EditText etUsuario, etContra;
    Button btnIngresar;
    String usuario, pasword;
    CheckBox checkBox;
    Boolean isSaved;
    public String user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        isSaved = false;
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        etContra = findViewById(R.id.etContra);
        etUsuario = findViewById(R.id.etUsuario);
        checkBox = findViewById(R.id.checkBox);
        btnIngresar = findViewById(R.id.btnIngresar);

        SharedPreferences preferencias = getSharedPreferences(ARCHI_PREFERENCIA , 0);
        if (preferencias.contains("usuario") && preferencias.contains("password") ) {
             user = preferencias.getString("usuario","1");
             pass = preferencias.getString("password","1");
            isSaved = true;
            etUsuario.setText(user);
            etContra.setText(pass);
            checkBox.setVisibility(View.GONE);
        }
        etUsuario.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String changetext = etUsuario.getText().toString();
                if (changetext != user) {
                    isSaved = false ;
                    checkBox.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String changetext = editable.toString();
                if (changetext.equals(user))
                {
                    isSaved = true ;
                    checkBox.setVisibility(View.GONE);

                }
            }
        });

    }

    public void Send (View view) {
        usuario = etUsuario.getText().toString();
        pasword = etContra.getText().toString();


        if(!usuario.isEmpty() && !pasword.isEmpty()){
            validarUsuario("http://ymarquez.webfactional.com/serviciosRest/controladores/user.php");
            }else{
            Toast.makeText(LoginActivity.this,"Rellene los campos",Toast.LENGTH_SHORT).show();

        }

    }

    private void validarUsuario(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty() && response.length()>1){
                    if (checkBox.isChecked() && !isSaved)
                    {
                        SharedPreferences preferences= getSharedPreferences(ARCHI_PREFERENCIA,0);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("usuario",usuario);
                        editor.putString("password",pasword);
                        editor.commit();
                    }
                    Intent i = new Intent(getBaseContext(),Menu.class);
                    i.putExtra("email" , usuario );
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,"Usuario inválido",Toast.LENGTH_SHORT).show();
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