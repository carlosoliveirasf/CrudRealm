package com.project.shoes.loginrealm.abstracts;

import android.view.View;

/**
 * Created by carlos on 1/5/18.
 */

public interface LoginView {

    void goToRegister();
    void fieldEmpty();
    void fieldNotEmpty();
    void verifyField();
    void sucess();
    void failure();
}
