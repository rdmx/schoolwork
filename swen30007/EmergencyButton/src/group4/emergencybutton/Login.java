package group4.emergencybutton;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import android.os.Bundle;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);	
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	// No Menu
        return false;
    }
    
	@Override
	public void onBackPressed() {
		// Don't Support "Back"
	}
	
	public void logIn(View view){
		
		hideSoftKeyboard(Login.this);
		
		EditText etuser = (EditText) findViewById(R.id.edit_username);
		EditText etpass = (EditText) findViewById(R.id.edit_password);

		String user = etuser.getText().toString();
		String pass = etpass.getText().toString();
		
		ParseUser.logInInBackground(user, pass, new LogInCallback() {
			  public void done(ParseUser user, ParseException e) {
			    if (user != null) {
			      // Hooray! The user is logged in.
			    	ParseUser currentuser = ParseUser.getCurrentUser();
			    	loggedIn(currentuser.get("Type").toString());
			    } else {
			    	Toast.makeText(Login.this, "Login Failure! Please Try Again!", Toast.LENGTH_LONG).show();
			    }
			  }
			});
	}
	
	public static void hideSoftKeyboard(Activity activity) {
	    InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
	    inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
	}
	
    private void loggedIn(String type){
    	
    	if (type.equals("Caree")){
	    	Intent intent = new Intent(this, CareeHome.class);
	    	startActivity(intent);
    	}
    	else{
	    	Intent intent = new Intent(this, CarerHome.class);
	    	startActivity(intent);
    	}
    }
    

}
