package com.project.shoes.loginrealm.presenter;

import com.project.shoes.loginrealm.abstracts.CrudView;
import com.project.shoes.loginrealm.vo.UserVO;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

/**
 * Created by carlos on 1/5/18.
 */

public class CrudPresenter {
    private CrudView crudView;

    public CrudPresenter(CrudView crudView) {
        this.crudView = crudView;
    }

    public void verifyFieldEmpty(String user, String password) {
        if (user.isEmpty() || password.isEmpty()) {
            crudView.fieldEmpty();
        } else {
            crudView.fieldNotEmpty();
        }
    }

    public void registerUser(Realm realm, String user, String password){
        try {
            realm.beginTransaction();
            realm.copyToRealm(new UserVO(user, password));
            realm.commitTransaction();
            crudView.sucess();
        } catch (RealmPrimaryKeyConstraintException e) {
            e.getMessage();
            realm.cancelTransaction();
            crudView.failure();
        }
    }
}
