package bcr.sabel.com.bcr;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by mkoenig on 01.03.2018.
 */

public class BroadcastReceiverBeispiel extends BroadcastReceiver {
    public static final String TAG = BroadcastReceiver.class.getSimpleName();
    
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Log.d(TAG, "Bootvorgang abgeschlossen");

            String message = DateFormat.getDateTimeInstance().format(new Date());
            Notification.Builder builder = new Notification.Builder(context);
            builder.setSmallIcon(R.drawable.ic_launcher_background).setContentTitle("Bootvorgang").setContentText(message).setWhen(System.currentTimeMillis());
            Notification notification = builder.build();
            NotificationManager m = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            m.notify(4211, notification);
        }

//        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
        Log.d(TAG, "Aitplainmode");
        Toast.makeText(context, "Airplanemode", Toast.LENGTH_LONG).show();
//        }
    }
}
