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

import ohos.aafwk.ability.fraction.FractionAbility;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.window.dialog.ToastDialog;

/**
 * MainAbility.
 */
public class MainAbility extends FractionAbility {
    MultiStateFragment mContentFragment;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        mContentFragment = (getFractionManager().getFractionByTag("multistatefragment").isPresent())
                ? ((MultiStateFragment) getFractionManager().getFractionByTag("multistatefragment").get()) : null;
        if (mContentFragment == null) {
            mContentFragment = MultiStateFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getFractionManager(),
                    mContentFragment, ResourceTable.Id_content_frame);
        }
        Button fab = (Button) findComponentById(ResourceTable.Id_fab);
        fab.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                new ToastDialog(getContext()).setText("Replace with your own action").setDuration(1000).show();
                mContentFragment.refresh();
            }
        });
    }
}
