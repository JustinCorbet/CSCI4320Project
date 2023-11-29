package com.example.csci4320project;

import androidx.test.espresso.Espresso.*;
import androidx.test.espresso.action.ViewActions.*;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.assertion.ViewAssertions.*;
import androidx.test.espresso.matcher.ViewMatchers.*;

import static org.junit.Assert.*;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.Rule;
import org.junit.Test;

import kotlin.jvm.JvmField;

public class LoginTest {
    @Rule
    ActivityTestRule test = new ActivityTestRule(Login.class);
    private Login mActivity = null;

    @Test
    void loginTest(){
        
    }
}