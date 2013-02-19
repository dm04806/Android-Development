package com.example.webview;

import android.os.Bundle;
import android.app.Activity;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebChromeClient;
import android.webkit.JsResult;

public class MainActivity extends Activity {

	WebView webview;
    
	@Override
    public void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        
        //simplest way to load in a webpage (although js wont work)
        //webview = new WebView(this);		
        //webview.loadUrl("http://www.mobvcasting.com/mmtest/index.html");
        //setContentView(webview);
        
        
        webview = new WebView(this);		

        // Enable JavaScript overall
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        
        // Enable JavaScript Alerts
        webview.setWebChromeClient(new WebChromeClient() {
        	public boolean onJSAlert(WebView view, String url, String message, JsResult result)
        	{
        		return true;
        	}
        });

        setContentView(webview);
        
        webview.loadUrl("http://www.mobvcasting.com/mmtest/index.html");
    }

}
