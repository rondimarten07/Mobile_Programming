package com.example.rondiuts;

import static java.util.logging.Logger.global;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView txtDate, txtNama, editDate, isiSubtotal, txtPajak, isiTotal, isiKembalian;
    private EditText editNama,editmakanan1, editmakanan2, editmakanan3, editminuman1, editminuman2, editminuman3 ;
    private EditText editTunai;
    private Calendar calendar;
    private DatePicker datePicker;
    private int day, month, year;
    private CheckBox cbmakanan1, cbmakanan2, cbmakanan3, cbminuman1, cbminuman2, cbminuman3;
    private Button btnPesan, btnBayar;
    String text = "";
    private int jml;
    String qyt = "";



    public void initUI() {
        //Tanggal Otomatis
        calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);


        txtDate = findViewById(R.id.txt_date);
        editDate = findViewById(R.id.edit_date);
        txtNama = findViewById(R.id.txt_nama);
        editNama = findViewById(R.id.edit_nama);
        cbmakanan1 = findViewById(R.id.cb_makanan1);
        cbmakanan2 = findViewById(R.id.cb_makanan2);
        cbmakanan3 = findViewById(R.id.cb_makanan3);
        cbminuman1 = findViewById(R.id.cb_minuman1);
        cbminuman2 = findViewById(R.id.cb_minuman2);
        cbminuman3 = findViewById(R.id.cb_minuman3);
        editmakanan1 = findViewById(R.id.edit_makanan1);
        editmakanan2 = findViewById(R.id.edit_makanan2);
        editmakanan3 = findViewById(R.id.edit_makanan3);
        editminuman1 = findViewById(R.id.edit_minuman1);
        editminuman2 = findViewById(R.id.edit_minuman2);
        editminuman3 = findViewById(R.id.edit_minuman3);
        btnPesan = findViewById(R.id.pesan);
        btnBayar = findViewById(R.id.bayar);
        txtPajak = findViewById(R.id.pajak);
        isiTotal = findViewById(R.id.isi_total);

        isiSubtotal = findViewById(R.id.isi_subtotal);
        isiKembalian = findViewById(R.id.isi_kembalian);
        editTunai = findViewById(R.id.edit_tunai);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        final int harga_makanan1 = 35000;
        final int harga_makanan2 = 30000;
        final int harga_makanan3 = 20000;
        final int harga_minuman1 = 10000;
        final int harga_minuman2 = 18000;
        final int harga_minuman3 = 15000;


        btnPesan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                int totPesan=0;

                if(cbmakanan1.isChecked()){
                    text += "Honey Garlic Chicken" + "\n";
                    jml = Integer.parseInt(String.valueOf(editmakanan1.getText()));
                    qyt += "" + jml + "\n";
                    int hitung = jml*harga_makanan1;
                    totPesan += hitung;

                }

                if(cbmakanan2.isChecked()){
                    text += "Beef Burger" + "\n";
                    jml = Integer.parseInt(String.valueOf(editmakanan2.getText()));
                    qyt += "" + jml + "\n";
                    int hitung = jml*harga_makanan2;
                    totPesan += hitung;

                }

                if(cbmakanan3.isChecked()){
                    text += "Reguler Fries" + "\n";
                    jml = Integer.parseInt(String.valueOf(editmakanan3.getText()));
                    int hitung = jml*harga_makanan3;
                    qyt += "" + jml + "\n";
                    totPesan += hitung;
                }

                if(cbminuman1.isChecked()){
                    text += "Ice Cream" + "\n";
                    jml = Integer.parseInt(String.valueOf(editminuman1.getText()));
                    int hitung = jml*harga_minuman1;
                    qyt += "" + jml + "\n";
                    totPesan += hitung;

                }

                if(cbminuman2.isChecked()){
                    text += "Flurry Oreo" + "\n";
                    jml = Integer.parseInt(String.valueOf(editminuman2.getText()));
                    int hitung = jml*harga_minuman2;
                    qyt += "" + jml + "\n";
                    totPesan += hitung;

                }

                if(cbminuman3.isChecked()){
                    text += "Fanta Float" + "\n";
                    jml = Integer.parseInt(String.valueOf(editminuman3.getText()));
                    int hitung = jml*harga_minuman3;
                    qyt += "" + jml + "\n";
                    totPesan += hitung;

                }

                Toast.makeText(MainActivity.this, "Pesanan Berhasil Ditambahkan", Toast.LENGTH_LONG).show();

                isiSubtotal.setText("" +totPesan);
                int pajak = (int) (totPesan * 0.10);
                txtPajak.setText("" + pajak);

                int total = (int) (totPesan + pajak);
                isiTotal.setText("" + total);


            }

        });

        btnBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                int jumlahBayar = Integer.parseInt(String.valueOf(editTunai.getText()));
                int jumlahTotal = Integer.parseInt("" + isiTotal.getText());
                int kembalian = (jumlahBayar - jumlahTotal);

                isiKembalian.setText("" + kembalian);


                if (jumlahBayar <= jumlahTotal){
                    Toast.makeText(MainActivity.this, "Uang Anda Tidak Cukup", Toast.LENGTH_LONG).show();
                    isiKembalian.setText("");
                }else {
                    Toast.makeText(MainActivity.this, "Pembayaran Berhasil", Toast.LENGTH_LONG).show();

                }


            }

        });



        showDate(day, month + 1, year);
    }


    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int dayOfMonth, int month, int year) {
            showDate(dayOfMonth, month + 1, year);
        }
    };

    private void showDate(int day, int month, int year) {
        editDate.setText(new StringBuilder()
                .append(day).append("/")
                .append(month).append("/")
                .append(year));

    }

    public void CetakStruk(View view) {

        Intent hubung= new Intent(MainActivity.this, StrukActivity.class);

        hubung.putExtra("tanggal", editDate.getText().toString());
        hubung.putExtra("nama", editNama.getText().toString());
        hubung.putExtra("text", text);
        hubung.putExtra("qyt", qyt);
        hubung.putExtra("subtotal", isiTotal.getText().toString());
        hubung.putExtra("pajak", txtPajak.getText().toString());
        hubung.putExtra("total", isiTotal.getText().toString());
        hubung.putExtra("tunai", editTunai.getText().toString());
        hubung.putExtra("kembalian", isiKembalian.getText().toString());
        startActivity(hubung);

        Toast.makeText(MainActivity.this, "Berhasil Di Cetak", Toast.LENGTH_LONG).show();


    }


}








