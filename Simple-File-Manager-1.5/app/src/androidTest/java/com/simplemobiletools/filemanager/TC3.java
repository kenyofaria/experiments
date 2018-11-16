package com.simplemobiletools.filemanager;

import android.support.test.espresso.Espresso;
import static android.support.test.espresso.Espresso.onView;

import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.thatMatchesFirst;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static android.support.test.espresso.action.ViewActions.click;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.simplemobiletools.filemanager.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by kenyo on 10/03/17.
 */

@RunWith(AndroidJUnit4.class)
public class TC3 {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void TC3(){
        onView(withText("home")).check(ViewAssertions.matches(isDisplayed()));
        onView(withText("DCIM")).perform(click());
        onView(withText(" -> DCIM")).check(ViewAssertions.matches(isDisplayed()));
        pressBack();
        onView(withText("home")).check(ViewAssertions.matches(isDisplayed()));
    }

}
