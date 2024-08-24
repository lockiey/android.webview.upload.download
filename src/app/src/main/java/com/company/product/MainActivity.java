package com.example.votreapplication; // Remplacez par le nom de votre package

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private ProgressBar progressBar; // Ajout d'une barre de progression

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Assurez-vous d'avoir le bon layout

        webView = findViewById(R.id.webView);
        progressBar = findViewById(R.id.progressBar); // Récupérez la ProgressBar (à ajouter dans votre layout)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); 

        // Gestion des événements de la WebView
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE); // Afficher la ProgressBar
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE); // Masquer la ProgressBar
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                // Afficher un message d'erreur en cas de problème de chargement
                Toast.makeText(MainActivity.this, "Erreur de chargement : " + description, Toast.LENGTH_SHORT).show();
            }
        });

        webView.loadUrl("file:///android_asset/index.html"); 
    }
}
