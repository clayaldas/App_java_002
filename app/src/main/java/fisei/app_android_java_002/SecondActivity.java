package fisei.app_android_java_002;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    private TextView textViewMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewMessage = findViewById(R.id.textViewMessage);

        Bundle  bundleExtras  = getIntent().getExtras();
        String user = bundleExtras.getString("user");
        String password = bundleExtras.getString("password");

        textViewMessage.setText("Usuario: " + user + "    clave: " + password);
    }

    public void onClicFinish(View view) {
        finish();
    }
    public void onClicBrowser(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http:www.google.com"));
        startActivity(intent);
    }

    public void onClicCall(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: +59347837489"));
        startActivity(intent);
    }
    public void onClicThirdActivity(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

}