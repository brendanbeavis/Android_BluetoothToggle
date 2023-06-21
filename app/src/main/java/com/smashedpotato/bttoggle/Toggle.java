package com.smashedpotato.bttoggle;

import android.os.Bundle;
import android.widget.Toast;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;

public class Toggle extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if(mBluetoothAdapter==null)
		{
			end("\n   Bluetooth not found   \n");
		}
		else{
			if (mBluetoothAdapter.isEnabled()){
				mBluetoothAdapter.disable();
				end("\n   Bluetooth Disabled   \n");
			}
			else{
				mBluetoothAdapter.enable();
				end("\n   Bluetooth Enabled   \n");
			}
		}
		
	}
	private void end(String result){
		Toast.makeText(getApplicationContext(), result,  Toast.LENGTH_SHORT).show();
		finish();
	}
	protected void onFinish(){
		try {
		    Thread.sleep(1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		android.os.Process.killProcess(android.os.Process.myPid());
	}
}


