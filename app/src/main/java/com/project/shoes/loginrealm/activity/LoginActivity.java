package com.project.shoes.loginrealm.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.project.shoes.loginrealm.R;
import com.project.shoes.loginrealm.abstracts.LoginView;
import com.project.shoes.loginrealm.presenter.LoginPresenter;
import io.realm.Realm;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private EditText userEditText;
    private EditText passwordEditText;
    private Button buttonLogin;
    private Button buttonRegisterActivity;
    private LoginPresenter loginPresenter;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponentes();
    }

    @Override
    public void sucess() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "SUCESSO", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void failure() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "DADOS INCORRETOS", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initializeComponentes() {
        userEditText = findViewById(R.id.userEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegisterActivity = findViewById(R.id.buttonRegisterActivity);
        buttonLogin.setOnClickListener(this);
        buttonRegisterActivity.setOnClickListener(this);
        loginPresenter = new LoginPresenter(this);
        Realm.init(this);
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void onClick(View view) {
        loginPresenter.verifyButton(view.getId());

    }

    @Override
    public void goToRegister() {
        startActivity(new Intent(LoginActivity.this, CrudActivity.class));
    }

    @Override
    public void verifyField(){
        loginPresenter.verifyFieldEmpty(userEditText.getText().toString(), passwordEditText.getText().toString());

    }

    @Override
    public void fieldNotEmpty() {
       loginPresenter.queryUser(realm, userEditText.getText().toString(), passwordEditText.getText().toString());
    }

    @Override
    public void fieldEmpty() {
        Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
    }
}
