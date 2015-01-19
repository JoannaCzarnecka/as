package com.example.patryk.cookbook;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.patryk.cookbook.data.EmailAndPassword;
import com.example.patryk.cookbook.data.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;

@EActivity (R.layout.activity_login)
public class LoginActivity extends ActionBarActivity {

    @Bean
    @NonConfigurationInstance
    RestLoginBackgroundTask restLoginBackgroundTask;

    @ViewById
    EditText email;

    @ViewById
    EditText password;

    ProgressDialog ringProgressDialog;

    @AfterViews
    void init() {
        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Logowanie...");
        ringProgressDialog.setIndeterminate(true);
    }

    @Click
    void loginClicked()    {
        ringProgressDialog.show();
        EmailAndPassword emailAndPassword = new EmailAndPassword();
        emailAndPassword.email = email.getText().toString(); //"example@example.com";
        emailAndPassword.password = password.getText().toString(); //"test00";
        restLoginBackgroundTask.login(emailAndPassword);
    }

    @Click(R.id.register)
    void registerClicked(){
        startActivity(new Intent(this, RegisterActivity_.class));
    }

    public void loginSuccess(User user) {
        ringProgressDialog.dismiss();
        AddActivity_.intent(this).user(user).start();
        Toast.makeText(this, "Zalogowano!", Toast.LENGTH_LONG).show();
    }

    public void showError(Exception e) {
        ringProgressDialog.dismiss();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }

}

