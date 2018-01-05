package com.project.shoes.loginrealm.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.project.shoes.loginrealm.R;
import com.project.shoes.loginrealm.abstracts.CrudView;
import com.project.shoes.loginrealm.presenter.CrudPresenter;

import io.realm.Realm;

public class CrudActivity extends AppCompatActivity implements View.OnClickListener, CrudView {

    private EditText registerUser;
    private EditText registerPassword;
    private Button buttonRegister;
    private Realm realm;
    private CrudPresenter crudPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);
        initializeComponentes();
    }

    private void initializeComponentes() {
        registerUser = findViewById(R.id.registerUser);
        registerPassword = findViewById(R.id.registerPassword);
        buttonRegister = findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(this);
        realm = Realm.getDefaultInstance();
        crudPresenter = new CrudPresenter(this);
    }

    @Override
    public void registerUser() {
       crudPresenter.registerUser(realm, registerUser.getText().toString(), registerPassword.getText().toString());
    }

    @Override
    public void sucess() {
        Toast.makeText(this, "Usuario Cadastrado", Toast.LENGTH_LONG).show();
    }

    @Override
    public void failure() {
        Toast.makeText(this, "Ja existe um usuario", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        crudPresenter.verifyFieldEmpty(registerUser.getText().toString(), registerPassword.getText().toString());
    }

    @Override
    public void fieldEmpty() {
        Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fieldNotEmpty() {
        registerUser();
    }
}
