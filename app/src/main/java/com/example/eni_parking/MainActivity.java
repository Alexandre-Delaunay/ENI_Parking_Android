package com.example.eni_parking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.eni_parking.activity.HomeActivity;
import com.example.eni_parking.bo.Agency;
import com.example.eni_parking.bo.Manager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(AppDatabase.getAppDatabase(this).agencyDao().loadAllAgencies().length == 0){
            createData();
        }

        Spinner dropdownAgency = ((Spinner) findViewById(R.id.dpAgency));

        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, AppDatabase.getAppDatabase(this).agencyDao().loadAllAgencies());

        dropdownAgency.setAdapter(spinnerArrayAdapter);

        Button btnLogin = findViewById(R.id.btnLogin);

        final MainActivity context = this;
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = ((EditText) findViewById(R.id.txtLogin)).getText().toString();
                String password = ((EditText) findViewById(R.id.txtPassword)).getText().toString();
                Spinner dropdownAgency = ((Spinner) findViewById(R.id.dpAgency));
                Agency agency = (Agency)dropdownAgency.getSelectedItem();

                if (TextUtils.isEmpty(login) || TextUtils.isEmpty(password)){
                    Toast.makeText(context,"Veuillez renseigner tout les champs", Toast.LENGTH_LONG).show();
                }
                else{
                    Manager user = AppDatabase.getAppDatabase(context).managerDao().findByMailAndPass(login, password, agency.getId());

                    if(user==null){
                        Toast.makeText(context,"L'utilisateur n'est pas connu, réessayer de vous reconnecter", Toast.LENGTH_LONG).show();
                    }
                    else{
                        // IF VALID
                        Intent intent = new Intent(context, HomeActivity.class);
                        context.startActivityForResult(intent,2);
                        context.finish();
                    }
                }
            }
        });
    }

    private void createData(){
        Agency agency1 = new Agency();
        agency1.setName("Agence 1");
        agency1.setPhone("0606060606");
        agency1.setAddress("");
        AppDatabase.getAppDatabase(this).agencyDao().insertAgency(agency1);
        Agency agency2 = new Agency();
        agency2.setName("Agence 2");
        agency2.setPhone("0606060606");
        agency2.setAddress("");
        AppDatabase.getAppDatabase(this).agencyDao().insertAgency(agency2);

        Manager manager1 = new Manager();
        manager1.setAgencyID(1);
        manager1.setFirstname("Jean");
        manager1.setLastname("René");
        manager1.setMail("manager1@gmail.com");
        manager1.setPassword("Manager1");
        AppDatabase.getAppDatabase(this).managerDao().insertManager(manager1);
        Manager manager2 = new Manager();
        manager2.setAgencyID(2);
        manager2.setFirstname("Pierre");
        manager2.setLastname("Marie");
        manager2.setMail("manager2@gmail.com");
        manager2.setPassword("Manager2");
        AppDatabase.getAppDatabase(this).managerDao().insertManager(manager2);
    }
}
