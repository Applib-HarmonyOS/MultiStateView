package me.xdj.multistateview;

import me.xdj.view.MultiStateView;
import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;
import ohos.app.Context;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleOhosTest {
    private Context context;
    private MultiStateView multiStateView;
    @Test
    public void testBundleName() {
        final String actualBundleName = AbilityDelegatorRegistry.getArguments().getTestBundleName();
        assertEquals("me.xdj.multistateview", actualBundleName);
    }
    @Before
    public void setUp(){
        context = AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();
    }
    @Test
    public void testStateView()
    {
        int state=10001;
        multiStateView=new MultiStateView(context);
        multiStateView.setViewState(state);
        assertEquals(10001,multiStateView.getViewState());
    }
    @Test
    public void testCurrentView()
    {
        multiStateView=new MultiStateView(context);
        assertNull(multiStateView.getCurrentView());
    }
}