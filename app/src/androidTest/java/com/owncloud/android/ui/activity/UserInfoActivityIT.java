/*
 * Nextcloud - Android Client
 *
 * SPDX-FileCopyrightText: 2020 Andy Scherzinger <info@andy-scherzinger.de>
 * SPDX-License-Identifier: AGPL-3.0-or-later OR GPL-2.0-only
 */
package com.owncloud.android.ui.activity;

import android.content.Intent;

import com.owncloud.android.AbstractIT;
import com.owncloud.android.lib.common.UserInfo;
import com.owncloud.android.utils.ScreenshotTest;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.intent.rule.IntentsTestRule;

public class UserInfoActivityIT extends AbstractIT {
    @Rule
    public IntentsTestRule<UserInfoActivity> activityRule = new IntentsTestRule<>(UserInfoActivity.class,
                                                                                  true,
                                                                                  false);

    @Test
    @ScreenshotTest
    public void fullUserInfoDetail() {
        final Intent intent = new Intent(targetContext, UserInfoActivity.class);
        intent.putExtra(UserInfoActivity.KEY_ACCOUNT, user);
        UserInfo userInfo = new UserInfo("test",
                                         true,
                                         "Firstname Familyname",
                                         "oss@rocks.com",
                                         "+49 7613 672 255",
                                         "Awesome Place Av.",
                                         "https://www.nextcloud.com",
                                         "nextclouders",
                                         null,
                                         null
        );
        intent.putExtra(UserInfoActivity.KEY_USER_DATA, userInfo);
        UserInfoActivity sut = activityRule.launchActivity(intent);

        shortSleep();
        shortSleep();

        screenshot(sut);
    }
}
