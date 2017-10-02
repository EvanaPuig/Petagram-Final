package mx.evisoft.petagram;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by evana.margain on 16/08/17.
 */

public class NotificationService extends FirebaseMessagingService {

    private String user = "";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        super.onMessageReceived(remoteMessage);
        Log.d("Firebase", "From: " + remoteMessage.getFrom());
        Log.d("Firebase", "Notification Message Body: " + remoteMessage.getNotification());

        if (remoteMessage.getData().size() > 0) {
            Log.d("dd", "Message data payload: " + remoteMessage.getData());
            user = remoteMessage.getData().get("user");
        }

        Intent intent = new Intent(this, MainActivity.class);
        intent.setAction("goingToProfile");
        intent.putExtra("user", "whatever");
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificacion = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.map_marker_marker_outside_pink)
                .setContentTitle(remoteMessage.getNotification().getTitle())
                .setContentText(remoteMessage.getNotification().getBody())
                .setSound(sonido)
                .setAutoCancel(true);


        notificacion.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificacion.build());
    }
}
