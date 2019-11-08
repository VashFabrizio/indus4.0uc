package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class AsistenciaActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtMiId;
    ImageView ivMiQR;
    Button btnAsistenciaPrincipal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asistencia);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        txtMiId = findViewById(R.id.txtMiId);
        ivMiQR = findViewById(R.id.ivMiQR);
        btnAsistenciaPrincipal = findViewById(R.id.btnAsistenciaPrincipal);
        btnAsistenciaPrincipal.setOnClickListener(this);
        Bundle datos = this.getIntent().getExtras();
        String correo = datos.getString("correo_usr");

        txtMiId.setText(correo);


        generarQR(correo);

    }

    @Override
    public void onClick(View view) {
        finish();
    }

    private void generarQR(String correo){
        String texto = correo;
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(texto, BarcodeFormat.QR_CODE,200,200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            ivMiQR.setImageBitmap(bitmap);
        }catch (WriterException e){
            e.printStackTrace();
        }
    }
}
