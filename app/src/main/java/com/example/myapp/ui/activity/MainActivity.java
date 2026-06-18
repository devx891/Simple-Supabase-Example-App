package com.example.myapp.ui.activity;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapp.databinding.ActivityMainBinding;
import com.example.myapp.network.ApiService;
import com.example.myapp.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.myapp.data.model.User;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        fetchUsers();
    }
    
    private void fetchUsers() {

        ApiService apiService =
                RetrofitClient.getClient()
                        .create(ApiService.class);

        apiService.getUsers().enqueue(new Callback<List<User>>() {

            @Override
            public void onResponse(Call<List<User>> call,
                                   Response<List<User>> response) {

                if (response.isSuccessful()
                        && response.body() != null) {

                    StringBuilder builder =
                            new StringBuilder();

                    for (User user : response.body()) {

                        builder.append("ID: ")
                                .append(user.getId())
                                .append("\n");

                        builder.append("Name: ")
                                .append(user.getName())
                                .append("\n");

                        builder.append("Email: ")
                                .append(user.getEmail())
                                .append("\n\n");
                    }

                    binding.textView.setText(builder.toString());

                } else {

                    binding.textView.setText("Failed to fetch data");
                }
            }

            @Override
            public void onFailure(Call<List<User>> call,
                                  Throwable t) {

                binding.textView.setText(t.getMessage());
            }
        });
    }
    
    

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}