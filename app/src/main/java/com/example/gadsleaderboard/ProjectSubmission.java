package com.example.gadsleaderboard;


import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class ProjectSubmission extends AppCompatActivity {

    TextView firstNameField;
    TextView lastNameField;
    TextView emailField;
    TextView gitLinkField;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submission);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);



        Button submitButton = findViewById(R.id.button_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });



    }
    public void confirmDialog () {
        final AlertDialog.Builder confirm = new AlertDialog.Builder(this);

        View menuView = getLayoutInflater().inflate(R.layout.confirm_sub,null);
        confirm.setView(menuView);

        ImageView iconClose = menuView.findViewById(R.id.iconClose);
        Button yesButton = menuView.findViewById(R.id.button_yes);




        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirm.setCancelable(true);

                //Network Connection
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://docs.google.com/forms/d/e/")
                        .build();
                final GoogleWeb googleWeb = retrofit.create(GoogleWeb.class);

                firstNameField = findViewById(R.id.firstName);
                lastNameField = findViewById(R.id.lastName);
                emailField = findViewById(R.id.email);
                gitLinkField = findViewById(R.id.gitLink);

                String firstName = firstNameField.getText().toString();
                String lastName = lastNameField.getText().toString();
                String email = emailField.getText().toString();
                String gitLink = gitLinkField.getText().toString();
                Call<Void> googleWebCall = googleWeb.sendForm(firstName, lastName, email, gitLink);
                googleWebCall.enqueue(callCallBack);



            }
        });
        iconClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirm.setCancelable(true);
                //finish();
            }
        });

        Objects.requireNonNull(confirm.show().getWindow()).setBackgroundDrawableResource(R.drawable.round_rec);


    }


    private final Callback<Void> callCallBack = new Callback<Void>() {
        @Override
        public void onResponse(Call<Void> call, Response<Void> response) {
            successSub();
        }

        @Override
        public void onFailure(Call<Void> call, Throwable throwable) {
            errorSub();
        }
    };




    private void successSub() {
        final AlertDialog.Builder confirmSuccess = new AlertDialog.Builder(this);

        View menuView = getLayoutInflater().inflate(R.layout.success_sub,null);
        confirmSuccess.setView(menuView);
        Objects.requireNonNull(confirmSuccess.show().getWindow()).setBackgroundDrawableResource(R.drawable.round_rec);
    }

    private void errorSub() {
        final AlertDialog.Builder confirmError = new AlertDialog.Builder(this);

        View menuView = getLayoutInflater().inflate(R.layout.error_sub,null);
        confirmError.setView(menuView);
        Objects.requireNonNull(confirmError.show().getWindow()).setBackgroundDrawableResource(R.drawable.round_rec);
    }

}
