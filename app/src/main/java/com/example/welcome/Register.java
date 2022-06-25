package com.example.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    EditText userName,userEmail,userPassword,userMobileNumber;
    Button register;
    String userNameStr,userEmailStr,userPasswordStr,userMobileNumberStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userName=findViewById(R.id.userName);
        userEmail=findViewById(R.id.userEmail);
        userPassword=findViewById(R.id.userPassword);
        userMobileNumber=findViewById(R.id.userNumber);

        register=findViewById(R.id.register);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                userNameStr=userName.getText().toString();
                userEmailStr=userEmail.getText().toString();
                userPasswordStr=userPassword.getText().toString();
                userMobileNumberStr=userMobileNumber.getText().toString();

                Log.d("userName",userNameStr);
                Log.d("userEmail",userEmailStr);
                Log.d("userPassword",userPasswordStr);
                Log.d("userMobile",userMobileNumberStr);

            }
        });






    }
}