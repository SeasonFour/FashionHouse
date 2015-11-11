package com.ellekay.lucie.fashionhouse;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/*import com.parse.ParseFacebookUtils;*/


public class SignUp extends AppCompatActivity implements View.OnClickListener {

    EditText etEmail, etPassword;
    String email, password;
    ParseUser user;
    ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Parse.initialize(this, "Pfeqj5fHsKxhPyJ3jAl5qWKYeVzeBJUsFlZDYWs0", "j3KLdZTzsLQJRcKaceWrejzlp4NQW9e1EkExPnaW");
        setContentView(R.layout.activity_sign_up);
         etEmail = (EditText) findViewById(R.id.email);
         etPassword = (EditText) findViewById(R.id.password);
        Button fbBtn = (Button) findViewById(R.id.signUpBtn);
        fbBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        Log.d("signup", "email:" +email);
        Log.d("signup", "password:" +password);;

        if (email != null){
            new SignUpFn().execute();
        }else{
            Toast.makeText(getBaseContext(), "Sign up not successful",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public  class SignUpFn extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(SignUp.this);
            pDialog.setTitle("Fashion House");
            pDialog.setMessage("Signing up...");
            pDialog.setIndeterminate(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... params) {
            user = new ParseUser();
            user.setEmail(email);
            user.setPassword(password);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null){
                        Toast.makeText(getBaseContext(), "Successfully signed up", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getBaseContext(), Home.class);
                        startActivity(i);
                    }else {
                        Toast.makeText(getBaseContext(),
                                "Sign up incomplete.",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
            //super.onPostExecute(aVoid);
        }
    }
}

