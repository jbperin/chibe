// BuzzAlarmReceiver.java --- Receives alarms from the Android alarm
// manager to buzz when needed

// Copyright (C) 2016 Marien Raat <marienraat@riseup.net>

// Author: Marien Raat <marienraat@riseup.net>

// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// as published by the Free Software Foundation; either version 3
// of the License, or (at your option) any later version.

// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
package com.jmstudios.buzzer.timing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.os.Vibrator;

import com.jmstudios.buzzer.timing.BuzzAlarmScheduler;

public class BuzzAlarmReceiver extends BroadcastReceiver {
    private final static String TAG = "BuzzAlarmReceiver";
    private final static boolean DEBUG = true;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (DEBUG) Log.i(TAG, "Buzz alarm received");

        buzz(context);

        // Schedule new alarm
        BuzzAlarmScheduler.rescheduleAlarm(context);
    }

    private void buzz(Context context) {
        Vibrator vibrator = (Vibrator) context.
            getSystemService(Context.VIBRATOR_SERVICE);

        long[] vibrationPattern = {0, 300};
        int noRepeat = -1;

        vibrator.vibrate(vibrationPattern, noRepeat);
    }
}