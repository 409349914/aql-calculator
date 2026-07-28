package com.aqlcalc

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val webView = WebView(this)
        webView.settings.apply {
            javaScriptEnabled = true
            builtInZoomControls = false
            loadWithOverviewMode = true
            useWideViewPort = true
        }
        webView.webViewClient = WebViewClient()
        // Read HTML from assets and load with base URL (works on all Android versions)
        val html = assets.open("index.html").bufferedReader().use { it.readText() }
        webView.loadDataWithBaseURL("file:///android_asset/", html, "text/html", "UTF-8", null)
        setContentView(webView)
    }

    override fun onBackPressed() {
        val wv = findViewById<WebView>(android.R.id.content).getChildAt(0) as? WebView
        if (wv != null && wv.canGoBack()) wv.goBack() else super.onBackPressed()
    }
}
