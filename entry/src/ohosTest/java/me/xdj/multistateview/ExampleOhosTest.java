/*
 * Copyright (C) 2020-21 Application Library Engineering Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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