/**
* The SMS Reciever program implements an application that
* simply displays a new incoming message to the screen.
*
* @author  Arif Ahmed (arifch2009@gmail.com)
* @version 1.0
* @since   2014-12-26 
*/

package in.arif.smsrcver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class Incoming_Sms extends BroadcastReceiver{

	// Get the object of SmsManager
    final SmsManager sms = SmsManager.getDefault();
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		 // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();
 
        try {
             
            if (bundle != null) {
                 
                final Object[] pdusObj = (Object[]) bundle.get("pdus");
                 
                for (int i = 0; i < pdusObj.length; i++) {
                     
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();
                     
                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();
                    intent=new Intent(context, NewMessage.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("SenderNum", senderNum);
                    intent.putExtra("Message", message);
                    context.startActivity(intent);
                    
                    Log.i("SmsReceiver", "senderNum: "+ senderNum + "; message: " + message);
                     
 
                    
                }  
              }  
 
        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" +e);
             
		
        }
	}
			
}
