package com.aqlcalc

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

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
        val html = assets.open("index.html").bufferedReader().use { it.readText() }
        webView.loadDataWithBaseURL("file:///android_asset/", html, "text/html", "UTF-8", null)
        setContentView(webView)
    }
}
