package android.support.test.rule;

import android.app.Activity;

public class ControlledActivityTestRule<T extends Activity> extends ActivityTestRule<T> {
    public ControlledActivityTestRule(Class<T> activityClass) {
        super(activityClass, false);
    }

    public ControlledActivityTestRule(Class<T> activityClass, boolean initialTouchMode) {
        super(activityClass, initialTouchMode, true);
    }

    public ControlledActivityTestRule(Class<T> activityClass, boolean initialTouchMode, boolean launchActivity) {
        super(activityClass, initialTouchMode, launchActivity);
    }

    public void finish() {
        finishActivity();
    }

    public void relaunchActivity() {
        finishActivity();
        launchActivity();
    }

    public void launchActivity() {
        launchActivity(getActivityIntent());
    }

}