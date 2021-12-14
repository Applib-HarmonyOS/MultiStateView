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

import ohos.aafwk.ability.fraction.Fraction;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.LayoutScatter;
import me.xdj.view.MultiStateView;

/**
 * Created by xdj on 16/2/5.
 */
public class MultiStateFragment extends Fraction {
    public static final int OTHER_STATUS = 1111;
    private MultiStateView mMultiStateView;

    @Override
    public Component onComponentAttached(LayoutScatter inflater, ComponentContainer container,
                                         Intent savedInstanceState) {
        Component view = inflater.parse(ResourceTable.Layout_fragment_content, container, false);
        mMultiStateView = (MultiStateView) view.findComponentById(ResourceTable.Id_multi_state_view);
        Button mcontentTv = (Button) view.findComponentById(ResourceTable.Id_content_tv);
        mMultiStateView.addViewForStatus(OTHER_STATUS, ResourceTable.Layout_view_other_status);

        mcontentTv.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                mMultiStateView.setViewState(MultiStateView.STATE_LOADING);
                mMultiStateView.setViewState(OTHER_STATUS);
            }
        });

        mMultiStateView.setOnInflateListener(new MultiStateView.OnInflateListener() {
            @Override
            public void onInflate(int state, Component view) {
                if (state == MultiStateView.STATE_FAIL) {
                    view.findComponentById(ResourceTable.Id_retry).setClickedListener(new Component.ClickedListener() {
                        @Override
                        public void onClick(Component component) {
                            mMultiStateView.setViewState(MultiStateView.STATE_LOADING);
                            mMultiStateView.setViewState(MultiStateView.STATE_EMPTY);
                        }
                    });
                } else if (state == MultiStateView.STATE_EMPTY) {
                    view.findComponentById(ResourceTable.Id_retry).setClickedListener(new Component.ClickedListener() {
                        @Override
                        public void onClick(Component component) {
                            mMultiStateView.setViewState(MultiStateView.STATE_LOADING);
                            mMultiStateView.setViewState(MultiStateView.STATE_CONTENT);
                        }
                    });
                } else if (state == MultiStateView.STATE_CONTENT) {
                    view.setClickedListener(new Component.ClickedListener() {
                        @Override
                        public void onClick(Component component) {
                            mMultiStateView.setViewState(MultiStateView.STATE_LOADING);
                            mMultiStateView.setViewState(OTHER_STATUS);
                        }
                    });
                }
            }
        });

        mMultiStateView.setViewState(MultiStateView.STATE_LOADING);
        mMultiStateView.postDelayed(() -> mMultiStateView.setViewState(MultiStateView.STATE_FAIL), 5000);

        return view;
    }

    public static MultiStateFragment newInstance() {
        return new MultiStateFragment();
    }

    /**
     * Refresh.
     */
    public void refresh() {
        mMultiStateView.setViewState(MultiStateView.STATE_LOADING);
        mMultiStateView.postDelayed(() -> mMultiStateView.setViewState(MultiStateView.STATE_FAIL), 5000);
    }
}
