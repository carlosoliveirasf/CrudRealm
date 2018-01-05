package com.project.shoes.loginrealm.presenter;

import android.widget.Toast;

import com.project.shoes.loginrealm.R;
import com.project.shoes.loginrealm.abstracts.LoginView;
import com.project.shoes.loginrealm.vo.UserVO;

import java.util.Collection;

import io.realm.Realm;

/**
 * Created by carlos on 1/5/18.
 */

public class LoginPresenter {

    private LoginView loginView;
    private Boolean sucessLogin;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void verifyButton(int oneButton) {
        switch (oneButton) {
            case R.id.buttonLogin:
                loginView.verifyField();
                break;
            case R.id.buttonRegisterActivity:
                loginView.goToRegister();
                break;
        }
    }

    public void verifyFieldEmpty(String user, String password) {
        if (user.isEmpty() || password.isEmpty()) {
            loginView.fieldEmpty();
        } else {
            loginView.fieldNotEmpty();
        }
    }

    public void queryUser(Realm realm, String userName, String password) {
        sucessLogin = Boolean.FALSE;
        final Collection<UserVO> users = realm.where(UserVO.class).findAll();
        for (UserVO user : users) {
            if (user.getUser().equals(userName) && user.getPassword().equals(password)) {
                sucessLogin = Boolean.TRUE;
            }
        }
        if (sucessLogin) {
            loginView.sucess();
        } else {
            loginView.failure();
        }
    }
}
