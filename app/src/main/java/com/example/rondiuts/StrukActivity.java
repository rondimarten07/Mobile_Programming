package com.example.rondiuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.audiofx.PresetReverb;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StrukActivity extends AppCompatActivity implements View.OnClickListener   {
    TextView txtNama, txtDate, txtMakanan,
            txtSub, txtPajak, txtTotal, txtBayar, txtKembalian, txtqyt1, txtqyt2, txtqyt3, txtqyt4, txtqyt5, txtqyt6;
    Button btnKembali;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_struk);

        txtDate = (TextView) findViewById(R.id.txt_date);
        txtNama = (TextView) findViewById(R.id.txt_nama);
        txtMakanan = (TextView) findViewById(R.id.txt_makanan);
        txtqyt1 = (TextView) findViewById(R.id.txt_qyt);
        txtSub = (TextView) findViewById(R.id.txt_sub);
        txtPajak = (TextView) findViewById(R.id.txt_pajak);
        txtTotal = (TextView) findViewById(R.id.txt_total);
        txtBayar = (TextView) findViewById(R.id.txt_tunai);
        txtKembalian = (TextView) findViewById(R.id.txt_kembalian);

        String tgl = getIntent().getExtras().getString("tanggal");
        String nama = getIntent().getExtras().getString("nama");
        String makanan = getIntent().getExtras().getString("text");
        String qyt = getIntent().getExtras().getString("qyt");
        String subtotal = getIntent().getExtras().getString("subtotal");
        String pajak = getIntent().getExtras().getString("pajak");
        String total = getIntent().getExtras().getString("total");
        String tunai= getIntent().getExtras().getString("tunai");
        String kembalian = getIntent().getExtras().getString("kembalian");

        txtDate.setText("Tanggal : " + tgl);
        txtNama.setText("Nama  : " + nama);
        txtMakanan.setText("Nama Pesanan \n"
                + makanan
        + "\n");
        txtqyt1.setText("Jumlah Beli \n" + qyt);
        txtSub.setText("Sub Total : " + subtotal);
        txtPajak.setText("Pajak : " + pajak);
        txtTotal.setText("Total : " + total);
        txtBayar.setText("Jumlah Bayar :" + tunai);
        txtKembalian.setText("Jumlah Kembalian :" + kembalian);

        this.setTitle("STRUK PEMBAYARAN");
        btnKembali = findViewById(R.id.btn_kembali);
        btnKembali.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_kembali:
                Intent m = new Intent(this, MainActivity.class);
                startActivity(m);
                break;
        }
    }
}
