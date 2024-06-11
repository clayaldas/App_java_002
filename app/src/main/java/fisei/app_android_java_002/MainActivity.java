package fisei.app_android_java_002;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUser;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextUser = findViewById(R.id.editTextUser);
        editTextPassword = findViewById(R.id.editTextPassword);
    }

    public void onClicOk (View view) {
        String user = editTextUser.getText().toString();
        String password = editTextPassword.getText().toString();

        if (!user.matches("") && !password.matches("")) {
            Intent intent = new Intent(this, SecondActivity.class);

            intent.putExtra("user", user);
            intent.putExtra("password", password);

            startActivity(intent);
        }
        else  {
            Toast.makeText(this, "Los campos son requeridos", Toast.LENGTH_SHORT).show();
        }
    }
}