package com.justifiers.foodchef.LoginAndSignUp;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.SingleLineTransformationMethod;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.justifiers.foodchef.BottomNavigationView.ProfileFragment;
import com.justifiers.foodchef.R;
import com.justifiers.foodchef.SettingsActivity;

public class LoginFragment extends Fragment {

    // Declare the variables here
    EditText emailId;
    EditText passwordLogin;
    TextView signUp;
    Button login;
    FirebaseAuth firebaseAuth;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View loginView =  inflater.inflate(R.layout.login_fragment, container, false);

        emailId = loginView.findViewById(R.id.login_email);
        passwordLogin = loginView.findViewById(R.id.login_password);
        signUp = loginView.findViewById(R.id.profile_sign_up);
        login = loginView.findViewById(R.id.profile_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth = FirebaseAuth.getInstance();
                final String email = emailId.getText().toString();
                String password = passwordLogin.getText().toString();
                firebaseAuth = FirebaseAuth.getInstance();
                // check if the email is empty
                if(email.isEmpty()){
                    // throws error for empty email
                    emailId.setError("Please enter your email Address");
                    emailId.requestFocus();
                } if(password.isEmpty()){
                    passwordLogin.setError("Please enter your password");
                    passwordLogin.requestFocus();
                } else {
                    if(password.length() < 8){
                        passwordLogin.setError("Please enter atleast 8 characters for password");
                        passwordLogin.requestFocus();
                    }if(!email.isEmpty() && !password.isEmpty() && password.length() > 8) {
                        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(getActivity(),"Login Successful!", Toast.LENGTH_SHORT).show();
                                    ProfileFragment profileFragment = new ProfileFragment();
                                    getActivity().getSupportFragmentManager().beginTransaction()
                                            .replace(R.id.fragment_container, profileFragment)
                                            .addToBackStack(null)
                                            .commit();
                                }
                            }
                        });
                    }
                }
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUpFragment signupFragment = new SignUpFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, signupFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return loginView;
    }
}
