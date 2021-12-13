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
