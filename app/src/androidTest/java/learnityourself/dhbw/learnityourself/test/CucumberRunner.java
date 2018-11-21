package learnityourself.dhbw.learnityourself.test;
import android.os.Bundle;
import android.support.test.runner.MonitoringInstrumentation;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.android.CucumberInstrumentationCore;
import cucumber.api.junit.Cucumber;


//@RunWith(Cucumber.class)
@CucumberOptions(features={"res"}, glue={"learnityourself.dhbw.learnityourself.test"})
public class CucumberRunner extends MonitoringInstrumentation {
    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);
    @Override
    public void onCreate(Bundle arguments) {
        super.onCreate(arguments);

        instrumentationCore.create(arguments);
        start();
    }
    @Override
    public void onStart() {
        super.onStart();
        waitForIdleSync();
        instrumentationCore.start();
    }
}