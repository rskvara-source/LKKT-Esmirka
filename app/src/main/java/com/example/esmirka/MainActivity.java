package com.example.esmirka;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText usernameInput;
    private EditText passwordInput;
    private Button loginButton;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = findViewById(R.id.username);
        passwordInput = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginBtn);
        webView = findViewById(R.id.webview);

        loginButton.setOnClickListener(v -> handleLogin());
    }

    private void handleLogin() {
        String username = usernameInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Vyplňte prosím všechna pole", Toast.LENGTH_SHORT).show();
            return;
        }

        // Povolte JavaScript pro WebView
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        // Přihlášení a otevření webové stránky
        String url = "https://esmirka.lkkt.cz";
        webView.loadUrl(url);

        // Skryjte přihlašovací formulář
        findViewById(R.id.loginForm).setVisibility(android.view.View.GONE);
        webView.setVisibility(android.view.View.VISIBLE);
    }
}