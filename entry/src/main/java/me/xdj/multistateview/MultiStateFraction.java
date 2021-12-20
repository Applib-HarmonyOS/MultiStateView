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
public class MultiStateFraction extends Fraction {
    public static final int OTHER_STATUS = 1111;
    private MultiStateView mMultiStateView;

    @Override
    public Component onComponentAttached(LayoutScatter inflater, ComponentContainer container,
                                         Intent savedInstanceState) {
        Component view = inflater.parse(ResourceTable.Layout_fraction_content, container, false);
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

    public static MultiStateFraction newInstance() {
        return new MultiStateFraction();
    }

    /**
     * Refresh.
     */
    public void refresh() {
        mMultiStateView.setViewState(MultiStateView.STATE_LOADING);
        mMultiStateView.postDelayed(() -> mMultiStateView.setViewState(MultiStateView.STATE_FAIL), 5000);
    }
}
