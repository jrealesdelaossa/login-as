package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class viewRegister extends AppCompatActivity {

    Button btnReturn;

    EditText firstName;
    EditText lastName;
    EditText brithDate;
    EditText email;
    EditText password;
    EditText confirmPassword;
    Button btnRegister;

    // dates for dialog
    ImageView imageDialog;
    TextView nameDialog;
    TextView messageDialog;
    Button btnCancelDialog;
    Button btnContinueDialog;

    Spinner generoSpinner;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_register);

        firstName = (EditText) findViewById(R.id.nameRegister);
        lastName = findViewById(R.id.lastnameRegister);
        brithDate = (EditText) findViewById(R.id.birthdateRegister);
        email = (EditText) findViewById(R.id.emailRegister);
        password = (EditText) findViewById(R.id.passwordRegister);
        confirmPassword = (EditText) findViewById(R.id.confirmPasswordRegister);

        btnRegister = (Button) findViewById(R.id.btnCreateAccount);

        btnReturn = (Button) findViewById(R.id.btnReturnToLogin);



        brithDate.setOnClickListener(v -> {
                DatePickerDialog dialog = new DatePickerDialog(viewRegister.this, (view1, year, month, dayOfMonth) -> {
                    String date = dayOfMonth + "/" + month + "/" + year;
                    brithDate.setText(date);
                }, 2023, 6, 17);

                dialog.show();
        });

        btnRegister.setOnClickListener(view -> {
            String firstNameInput = firstName.getText().toString();
            String lastNameInput = lastName.getText().toString();
            String brithDateInput = brithDate.getText().toString();
            String emailInput = email.getText().toString();
            String passwordInput = password.getText().toString();
            String confirmPasswordInput = confirmPassword.getText().toString();

            if (firstNameInput.equals("")) {
                firstName.setError("First name is required");
            } else if (lastNameInput.equals("")) {
                lastName.setError("Last name is required");
            } else if (brithDateInput.equals("")) {
                brithDate.setError("Birth date is required");
            } else if (emailInput.equals("")) {
                email.setError("Email is required");
            } else if (passwordInput.equals("")) {
                password.setError("Password is required");
            } else if (confirmPasswordInput.equals("")) {
                confirmPassword.setError("Confirm password is required");
            } else if (!passwordInput.equals(confirmPasswordInput)) {
                confirmPassword.setError("Password and confirm password must be equals");
            } else {
                Toast.makeText(viewRegister.this, "Account created", Toast.LENGTH_LONG).show();
            }


            // Validate password and confirm password
            if (passwordInput.equals(confirmPasswordInput)) {
                Dialog dialog = new Dialog(viewRegister.this);
                dialog.setContentView(R.layout.layoutregistro);
                dialog.show();

                imageDialog = (ImageView) dialog.findViewById(R.id.imageDialog);
                nameDialog = (TextView) dialog.findViewById(R.id.userNameDialog);
                messageDialog = (TextView) dialog.findViewById(R.id.messageDialog);
                btnCancelDialog = (Button) dialog.findViewById(R.id.btnCancelDialog);
                btnContinueDialog = (Button) dialog.findViewById(R.id.btnContinueDialog);

                nameDialog.setText(firstNameInput + " " + lastNameInput);
                messageDialog.setText("Welcome to the app. \n\n" +
                        "Your account has been created successfully. \n" +
                        "Please verify your continue.");

                generoSpinner = (Spinner) findViewById(R.id.genero);
                String genero = generoSpinner.getSelectedItem().toString();

                if (genero.equals("Masculino")) {
                    imageDialog.setImageResource(R.mipmap.personmale);
                } else if (genero.equals("Femenino")) {
                    imageDialog.setImageResource(R.mipmap.personfemale);
                } else {
                    imageDialog.setImageResource(R.mipmap.email);
                }

                btnCancelDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                btnContinueDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        Toast.makeText(viewRegister.this, "Information save correct", Toast.LENGTH_LONG).show();
                        viewRegister.this.finish();
                    }
                });

            } else {
                confirmPassword.setError("Password not match");
            }
        });

        // Return to login
        btnReturn.setOnClickListener(v ->
                startActivities(new Intent[]{new Intent(viewRegister.this, MainActivity.class)})
        );
    }

}