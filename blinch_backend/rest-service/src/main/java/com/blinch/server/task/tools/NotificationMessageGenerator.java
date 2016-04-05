package com.blinch.server.task.tools;

/*
 * Copyright 2014 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

public class NotificationMessageGenerator {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static enum Platform {
		// Apple Push Notification Service
		APNS,
		// Sandbox version of Apple Push Notification Service
		APNS_SANDBOX,
		// Amazon Device Messaging
		ADM,
		// Google Cloud Messaging
		GCM,
		// Baidu CloudMessaging Service
		BAIDU,
		// Windows Notification Service
		WNS,
		// Microsoft Push Notificaion Service
		MPNS;
	}

	public static String jsonify(Object message) {
		try {
			return objectMapper.writeValueAsString(message);
		} catch (Exception e) {
			e.printStackTrace();
			throw (RuntimeException) e;
		}
	}

	public static String getSampleAppleMessage() {
		Map<String, Object> appleMessageMap = new HashMap<String, Object>();
		Map<String, Object> appMessageMap = new HashMap<String, Object>();

		appMessageMap.put("alert", "You have been matched by Blinch.");
		appMessageMap.put("badge", 1);
		appMessageMap.put("sound", "default");
		appleMessageMap.put("aps", appMessageMap);

		return jsonify(appleMessageMap);
	}

	public static String getSampleAndroidMessage() {
		Map<String, Object> androidMessageMap = new HashMap<String, Object>();
		androidMessageMap.put("collapse_key", "Welcome");
		androidMessageMap.put("data", getData());
		androidMessageMap.put("delay_while_idle", true);
		androidMessageMap.put("time_to_live", 125);
		androidMessageMap.put("dry_run", false);
		return jsonify(androidMessageMap);
	}

	private static Map<String, String> getData() {
		Map<String, String> payload = new HashMap<String, String>();
		payload.put("message", "Hello World!");
		return payload;
	}

}