package id.sch.smktelkom_mlg.tugas01.xiirpl5012.pemesananutapes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etAlm, etNo;
    RadioGroup rg;
    Spinner sp;
    CheckBox cbSep, cbSan, cbKa, cbTa;
    Button bPsn;
    TextView tvHasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etAlm = (EditText) findViewById(R.id.editTextAlamat);
        etNo = (EditText) findViewById(R.id.editTextNo);
        rg = (RadioGroup) findViewById(R.id.radioGroupMetode);
        sp = (Spinner) findViewById(R.id.spinnerBank);
        cbSep = (CheckBox) findViewById(R.id.checkboxSepatu);
        cbSan = (CheckBox) findViewById(R.id.checkboxSandal);
        cbKa = (CheckBox) findViewById(R.id.checkboxKaosKaki);
        cbTa = (CheckBox) findViewById(R.id.checkboxTali);
        bPsn = (Button) findViewById(R.id.buttonPesan);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bPsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
    }

    private void doClick() {
        if (isValid()) ;
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum diisi");
        }

        String nomor = etNo.getText().toString();
        if (nomor.isEmpty()) {
            etNo.setError("Nomor belum diisi");
        }

        String alamat = etAlm.getText().toString();
        if (nomor.isEmpty()) {
            etAlm.setError("Alamat belum diisi");
        }

        String barang = "";
        int Startlen = barang.length();
        if (cbSep.isChecked()) barang += cbSep.getText() + ", ";
        if (cbSan.isChecked()) barang += cbSan.getText() + ", ";
        if (cbKa.isChecked()) barang += cbKa.getText() + ", ";
        if (cbTa.isChecked()) barang += cbTa.getText() + ", ";
        if (barang.length() == Startlen) barang += "Anda Belum Memilih Barang";

        String metode = null;
        if (rg.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            metode = rb.getText().toString();
        }
        if (metode == null) {
            metode = "Pilih Metode Pembayaran";
        }


        String bank = "";
        if (bank == null) {
            bank = "Pilih Bank!";
        } else bank = sp.getSelectedItem().toString();


        tvHasil.setText(
                "Nama                   : " + nama + "\n\n" +
                        "Nomor Telepon  : " + nomor + "\n\n" +
                        "Alamat                 : " + alamat + "\n\n" +
                        "Barang                 : " + barang + "\n\n" +
                        "Metode Bayar     : " + metode + "\n\n" +
                        "Via Bank              : " + bank
        );


        return true;
    }


}
