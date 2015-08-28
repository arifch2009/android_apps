/**
* The HelloWorld program implements an application that
* simply displays "Hello World!" to the standard output.
*
* @author  Zara Ali
* @version 1.0
* @since   2014-03-31 
*/


package in.arif.smsrcver;

import com.example.smsrcver.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class NewMessage extends Activity {

 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_message);
		TextView tv1=(TextView)findViewById(R.id.TextView01);
		Intent intent = getIntent();
		String newMessage=intent.getStringExtra("Message");
		String number=intent.getStringExtra("SenderNum");
		tv1.setText("SMS message from:"+number+"\n\n"+
					"Message:"+newMessage);
	}	

 
}
