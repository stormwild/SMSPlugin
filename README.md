# SMS plugin for Phonegap #
By Daniel Shookowsky

## This is a fork of Daniel Shookowsky's SMS Plugin for Phonegap updated for Cordova 2.2.0 ##

## Adding the Plugin to your project ##
1. To install the plugin, move smsplugin.js to your project's www folder and include a reference to it in your html files. 
2. Add the java files from src to your project's src hierarchy
3. Reference the plugin in your res/xml/config.xml file
    <plugin name="SmsPlugin" value="net.practicaldeveloper.phonegap.plugins.SmsPlugin"/>
4. Ensure that your manifest contains the necessary permissions to send SMS messages:

<uses-permission android:name="android.permission.SEND_SMS"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

## Using the plugin ##
 
### send ###
Send an sms message.  For example:

	var sms = cordova.require("cordova/plugin/sms");
		
	var onSendSuccess = function() {
		alert('Message sent successfully');	
	}
	
	var onSendError = function(e) {
		alert('Message Failed:' + e);
	}

	var onDeviceReady = function() {		
		sms.send('09171234567', 'SMS Message here', onSendSuccess, onSendError);
	}

	$(document).on('deviceready', onDeviceReady);	

	
## Licence ##

The MIT License

Copyright (c) 2011 Daniel Shookowsky

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