package com.android.airhockey1;

import com.android.airhockey1.FirstOpenGLProjectRenderer;

import android.support.v7.app.ActionBarActivity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class AirHockeyActivity extends ActionBarActivity {
	
	private GLSurfaceView glSurfaceView;
	private boolean rendererSet = false ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(glSurfaceView);
		
		final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
		final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
		final boolean supportEs2 = configurationInfo.reqGlEsVersion >= 0x20000;
    	
		if(supportEs2){
    		glSurfaceView.setEGLContextClientVersion(2);
    		glSurfaceView.setRenderer(new FirstOpenGLProjectRenderer());
    		rendererSet = true ;
    	}
    	else {
    		Toast.makeText(this,"asd",Toast.LENGTH_LONG).show();
    		return ;
    	}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.air_hockey, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
    protected void onPause(){
    	super.onPause();
    	if(rendererSet){
    		glSurfaceView.onPause();
    	}
    }
    
    @Override
    protected void onResume(){
    	super.onResume();
    	if(rendererSet){
    		glSurfaceView.onResume();
    	}
    }
}
