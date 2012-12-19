/*
Copyright (C) 2011 by Daniel Shookowsky

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/
package net.practicaldeveloper.phonegap.plugins;

import org.json.JSONArray;
import org.json.JSONException;

import android.telephony.SmsManager;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;

public class SmsPlugin extends CordovaPlugin {
	public final String ACTION_SEND_SMS = "SendSMS";
	
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

		boolean result = false;
		
		if (action.equals(ACTION_SEND_SMS)) {
			try {
				String phoneNumber = args.getString(0);
				String message = args.getString(1);
				sendSMS(phoneNumber, message);
				callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, result));
				result = true;
			}
			catch (JSONException ex) {
				callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR));
				result = false;
			}			
		}
		
		return result;
	}

	private void sendSMS(String phoneNumber, String message) {
		SmsManager manager = SmsManager.getDefault();
		manager.sendTextMessage(phoneNumber, null, message, null, null);
	}

}
