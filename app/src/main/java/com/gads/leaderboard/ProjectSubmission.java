package com.gads.leaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectSubmission extends AppCompatActivity {
    APIService mAPIService;
    EditText fName, lName, email1, git1;
    Button sub;
    ProgressBar progress2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submission);
        fName = findViewById(R.id.textFirstName);
        lName = findViewById(R.id.textSecondName);
        email1 = findViewById(R.id.textEmail);
        git1 = findViewById(R.id.textGit);
        sub = findViewById(R.id.submit);
        progress2 = findViewById(R.id.progress);
        progress2.setVisibility(View.VISIBLE);

        mAPIService = ApiUtils.getAPIService();

        sub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String firstName = fName.getText().toString().trim();
                String secondName = lName.getText().toString().trim();
                String email = email1.getText().toString().trim();
                String git = git1.getText().toString().trim();
                if (!TextUtils.isEmpty(firstName) && !TextUtils.isEmpty(secondName) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(git)) {
                    sendPost(firstName, secondName, email, git);

                }
            }

        });

    }


    public void sendPost(String firstName, String secondName, String email, String git){
        mAPIService.savePost(firstName, secondName, email, git).enqueue(new Callback<Submission>() {
            @Override
            public void onResponse(Call<Submission> call, Response<Submission> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(ProjectSubmission.this, "Submitted successfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ProjectSubmission.this, "Error occurred", Toast.LENGTH_SHORT).show();
                    progress2.setVisibility(View.GONE);

                }

            }

            @Override
            public void onFailure(Call<Submission> call, Throwable t) {
                Toast.makeText(ProjectSubmission.this, "Error occurred", Toast.LENGTH_SHORT).show();
                progress2.setVisibility(View.GONE);

            }

        });
    }


}
