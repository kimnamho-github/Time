package com.example.Time;

import android.app.Application;
import android.graphics.drawable.Drawable;

public class App extends Application {

    public Drawable appIcon;
    public String appName;
    public int usagePercentage;
    public String usageDuration;
    public String Hour;
    public String Second;

    public App(Drawable icon, String appName, int usagePercentage, String usageDuration, String Hour, String Second) {
        this.appIcon = icon;
        this.appName = appName;
        this.usagePercentage = usagePercentage;
        this.usageDuration = usageDuration;
        this.Hour = Hour;
        this.Second = Second;
    }
}
