package com.example.welcome;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.welcome.model.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView register;
    private static final String TAG = "MainActivity";

    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = ApiClient.getClient().create((ApiInterface.class));

        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this, Register.class);
                // startActivity(intent);
                 // getData();
               // getSingleTodo();
              //  getSingleTodo();
               // getQueryData();
                postData();
            }
        });

    }

    private void postData()
    {
        Todo todo=new Todo(3,"get milk",false);

        Call call=apiInterface.postTodos(todo);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Log.e(TAG, "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e(TAG, "onResponse: "+t.getLocalizedMessage());
            }
        });
    }

    private void getQueryData()
    {
        Call<List<Todo>> call=apiInterface.getTodoUsingQuery(3,true);
        call.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                Log.e(TAG, "onResponse: "+response.body());
            }
            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {

            }
        });
    }

    private void getSingleTodo()
    {
        Call<Todo> call=apiInterface.getTodo(3);
        call.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                Log.e(TAG, "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                Log.e(TAG, "onResponse: "+t.getLocalizedMessage());

            }
        });
    }

    private void getData()
    {
            Call<List<Todo>> call = apiInterface.getTodos();
            call.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                Log.e(TAG, "onResponse: " + response.body());

                for(int i=0;i<response.body().size();i++)
                {
                    System.out.println(response.body().get(i).getId());
                }
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }
}

