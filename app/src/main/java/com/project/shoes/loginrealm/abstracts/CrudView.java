package com.project.shoes.loginrealm.abstracts;

/**
 * Created by carlos on 1/5/18.
 */

public interface CrudView {

    void registerUser();
    void sucess();
    void failure();
    void fieldNotEmpty();
    void fieldEmpty();
}
