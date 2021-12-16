package me.xdj.multistateview;

import ohos.aafwk.ability.fraction.Fraction;
import ohos.aafwk.ability.fraction.FractionManager;
import ohos.aafwk.ability.fraction.FractionScheduler;

/**
 * Created by xdj on 16/9/13.
 */

public class ActivityUtils {
    private ActivityUtils() {
        throw new IllegalStateException("Utils class");
    }

    /**
     * AddFragementMethod.
     *
     * @param fm FractionManager.
     * @param fragment Fragment.
     * @param contentId ContentId.
     */
    public static void addFragmentToActivity(FractionManager fm, Fraction fragment, int contentId) {
        FractionScheduler ft = fm.startFractionScheduler();
        ft.add(contentId, fragment);
        ft.submit();
    }
}
