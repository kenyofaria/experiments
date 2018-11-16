package com.simplemobiletools.filemanager;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.simplemobiletools.filemanager.activities.MainActivity;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.hamcrest.core.AllOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by kenyo on 10/03/17.
 */


@RunWith(AndroidJUnit4.class)
public class TC4 {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void TC4(){

        onView(withText("DCIM")).perform(click());
        Espresso.onView(
                ViewMatchers.withId(R.id.items_fab)
        ).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(
                ViewMatchers.withId(R.id.items_fab)
        ).check(ViewAssertions.matches(ViewMatchers.isEnabled()));
        Espresso.onView(
                ViewMatchers.withId(R.id.items_fab)
        ).perform(ViewActions.click());

        Espresso.onView(
                ViewMatchers.withId(R.id.dialog_radio_directory)
        ).check(ViewAssertions.matches(ViewMatchers.isChecked()));

        Espresso.onView(
                ViewMatchers.withId(R.id.dialog_radio_file)
        ).check(ViewAssertions.matches(Matchers.not(ViewMatchers.isChecked())));

        String dirToCreate = "test directory two";
        Espresso.onView(
                ViewMatchers.withId(R.id.item_name)
        ).perform(ViewActions.typeText(dirToCreate));

        Espresso.onView(AllOf.allOf(CoreMatchers.instanceOf(android.widget.Button.class),
                ViewMatchers.withText("OK")))
                .perform(ViewActions.click());

        onView(
                withText(dirToCreate)
        ).check(ViewAssertions.matches(isDisplayed()));

        //dialog_radio_directory

    }


}
