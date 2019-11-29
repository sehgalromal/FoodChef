package com.justifiers.foodchef.LoginAndSignUp;

import android.content.Intent;
import android.os.Bundle;
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


public class SignUpFragment extends Fragment {

    // Declare Variables here
    EditText emailIdSignUp;
    EditText passwordSignUp;
    EditText nameSignUp;
    Button signUp;
    TextView login;
    FirebaseAuth firebaseAuth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View loginView = inflater.inflate(R.layout.sign_up_fragment, container, false);

        emailIdSignUp = loginView.findViewById(R.id.sign_up_email);
        passwordSignUp = loginView.findViewById(R.id.sign_up_password);
        nameSignUp = loginView.findViewById(R.id.sign_up_name);
        login = loginView.findViewById(R.id.signUp_login_here);
        signUp = loginView.findViewById(R.id.signUp_button);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth = FirebaseAuth.getInstance();
                String email = emailIdSignUp.getText().toString();
                String password = passwordSignUp.getText().toString();
                String name = nameSignUp.getText().toString();
                // check if the email is empty
                if(email.isEmpty()){
                    // throws error for empty email
                    emailIdSignUp.setError("Please enter your email Address");
                    emailIdSignUp.requestFocus();
                } if(password.isEmpty()){
                    passwordSignUp.setError("Please enter your password");
                    passwordSignUp.requestFocus();

                } else {
                    if (password.length() < 8) {
                        passwordSignUp.setError("Please enter atleast 8 characters for passsword");
                        passwordSignUp.requestFocus();
                    }
                } if (name.isEmpty()){
                        nameSignUp.setError("Please enter your name");
                        nameSignUp.requestFocus();
                } if(!email.isEmpty() && !password.isEmpty() && !name.isEmpty() && password.length() > 8) {
                        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()){
                                    Toast.makeText(getActivity(),"SignUp Failed!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getActivity(), "User Successfully Created!!", Toast.LENGTH_SHORT).show();
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
        });

        // if already have existing account it will go to login account
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginFragment loginFragment = new LoginFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, loginFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return loginView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.tool_settings:
                Intent i = new Intent(getActivity(), SettingsActivity.class);
                startActivity(i);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
