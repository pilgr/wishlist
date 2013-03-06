package name.pilgr.wishlist;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Feedback
 * User: alex
 * Date: 3/6/13
 * Time: 10:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class Feedback {

    public static void sendFeedback(Context context, String titleForChooserDialog, String subject, String body, String email) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        i.putExtra(Intent.EXTRA_SUBJECT, subject);
        i.putExtra(Intent.EXTRA_TEXT, body);
        i.setType("message/rfc822");
        try {
            context.startActivity(Intent.createChooser(i, titleForChooserDialog));
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(context, "You have no apps for sending feedback", Toast.LENGTH_SHORT).show();
        }
    }


}
