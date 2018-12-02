package com.blinch.server.task;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.blinch.server.task.tools.AmazonSNSClientWrapper;
import com.blinch.server.task.tools.NotificationMessageGenerator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by markuskopf on 04/04/16.
 */
public class MobilePush {

    private AmazonSNSClientWrapper snsClientWrapper;

    public MobilePush(AmazonSNS snsClient) {
        this.snsClientWrapper = new AmazonSNSClientWrapper(snsClient);
    }

    public static final Map<NotificationMessageGenerator.Platform, Map<String, MessageAttributeValue>> attributesMap = new HashMap<NotificationMessageGenerator.Platform, Map<String, MessageAttributeValue>>();
    static {
        attributesMap.put(NotificationMessageGenerator.Platform.ADM, null);
        attributesMap.put(NotificationMessageGenerator.Platform.GCM, null);
        attributesMap.put(NotificationMessageGenerator.Platform.APNS, null);
        attributesMap.put(NotificationMessageGenerator.Platform.APNS_SANDBOX, null);
    }

    public void appleSandboxAppNotification(String deviceToken) {

        String certificate = getCertificate();
        String privateKey = getPrivateKey();
        String applicationName = "PushNotificationDemo";

        snsClientWrapper.demoNotification(NotificationMessageGenerator.Platform.APNS_SANDBOX, certificate,
                privateKey, deviceToken, applicationName, attributesMap);
    }

    private String getPrivateKey() {
        // end of each line.
        return "";
    }

    private String getCertificate() {
        // end of each line.
        return "";
    }

}
