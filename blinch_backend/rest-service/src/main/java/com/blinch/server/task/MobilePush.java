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
        return "-----BEGIN RSA PRIVATE KEY-----\n" +
                "MIIEpAIBAAKCAQEA4vorBjyYj5Eb8wmQOE5ZjQ/FOvBYKsGmpnV6d5IM8Z3A/DUi\n" +
                "dDtY4a+fiERffiNfpGul9PXEGFDkAEv8XSW8AAaKOlvCSAAl+U/DEuXpuVualGuB\n" +
                "LZtBSW+fMkiAuZ/zyF1Nu6dRgIbzzgo9C1BhJE+1722ENSBqsGaaJf6CfwdZ5gy6\n" +
                "KR+5PcBPI6Avpaf5O+p99wj/Hp4KbxPwczFBAPEIKcD46ShBv2acnK8KLi4Ee2zA\n" +
                "4s2mEOLUWx6lFpue/4bayfXWUx90O1qzvhdS29lpcS+Zd5qFjBnV0YKw8cKbdvZq\n" +
                "hmrlJKRlDYkE9zeYe4DEUs+GqIkfr/dRC2D8twIDAQABAoIBAQCSfvrj9JpXF0Zd\n" +
                "z89YuCEObZ5T0ypktkZUa8CWihp2m+YiIj1RnbhZOdwSvGaR6Ezjt2MOvs1JEHSI\n" +
                "SILir+cucQoobm7vv8DCsBttCB2ZOCmGH/jpMaqqtjOe5bLHnBhhOu9f7bcp6HBV\n" +
                "jMAnnEKGiDgaB6psC7cwkZhua11YlHORy/dc6CHYOCoReeg1vZnoEjRBMS4C2xNo\n" +
                "hyu0oAksYaV2skcVlTI6CzbPRU1H8xSRc2QidMqYuTb/HTbIPahk2DsD2C6YSG30\n" +
                "lnL1bpkk2kYkkUvKDM/e4kjJ7TcTZCBHaQ0hezuvS4By1mxgIj4cajcX8f+5GPOb\n" +
                "VYCU9qc5AoGBAPxE1uCJ9DFhuGgmIeXVHsZWOGNRb4zQhIWdf3TwrvstcjG6Kv+X\n" +
                "jhHA3ie9y4wpSMwx5MI1baYHGVkzv9WWzGJCDZpLOo6mwVTjNsj1rIwtZGXk/Bsx\n" +
                "5aurlJEDVeSmtvRwW6mxureUZbQxqgHSeM9yocx/CqCbtHS7D7nDpnQFAoGBAOZV\n" +
                "kTsGn17S4tGrr7+ZAKVvrAmxQNLXvkZko0Q2Z5WADjbNXx5XMucQeyYTIt336tnu\n" +
                "U1ZqjbraW4JUZBtXknhFqVTB17p973aj9ALSn6seA43e3WYzZq6U7y70sNytv7S7\n" +
                "DbFEezoIo6RuhxXXYHkeOJK7KRgSEVxOpTMHjmaLAoGAWSAxEm9q2K9/qTwfqcWb\n" +
                "89KuZVh2Irfguhwk1bna+F7cA3mUi2yOAvOzCTNi4IgNcicGfR7HOGs1p3BDDEEU\n" +
                "wHo5uBNwAsojb8w+pM03Qucem2lFMI52aCpceMdG51uHM+EmYVOrdgR10i3htHcZ\n" +
                "u6DyTP9tT8TzAnK8YZMgEckCgYEAi5zaBtkgyK0y5rwWLyBij+R8dvOFw0caAjkF\n" +
                "7Va8upWACB+7w/w+0mfe/VkkDT80jxwyT3MOrW+lf/3/H8OY+GXhGYrVZCjpeRQv\n" +
                "13YraeErblbkBAqr9q43vFJ80YZPaRDoX8aOmsKZzhVgtBB0XXW//NCNPBXXiAfz\n" +
                "glbWLbkCgYAl2KAIqXBUaSqAtBvhmdZJ2xMsqN7I+Y6oJlF3Xl6s0KSlt8H0h+9V\n" +
                "2+D23YdgFh0G52JSlB6uEc7eUuVpDBM2M2zyRQPAsS8o9jgTRdNZCFdYYHIp0dFr\n" +
                "EdSzDYoGunSB0lnqEepjrwamw3YGPF+dyUIa5z5gbBFFRZTkIZsS7g==\n" +
                "-----END RSA PRIVATE KEY-----";
    }

    private String getCertificate() {
        // end of each line.
        return "-----BEGIN CERTIFICATE-----\n" +
                "MIIFgTCCBGmgAwIBAgIIIFiM6xajBfowDQYJKoZIhvcNAQEFBQAwgZYxCzAJBgNV\n" +
                "BAYTAlVTMRMwEQYDVQQKDApBcHBsZSBJbmMuMSwwKgYDVQQLDCNBcHBsZSBXb3Js\n" +
                "ZHdpZGUgRGV2ZWxvcGVyIFJlbGF0aW9uczFEMEIGA1UEAww7QXBwbGUgV29ybGR3\n" +
                "aWRlIERldmVsb3BlciBSZWxhdGlvbnMgQ2VydGlmaWNhdGlvbiBBdXRob3JpdHkw\n" +
                "HhcNMTYwNDEyMDgxMjIzWhcNMTcwNDEyMDgxMjIzWjCBgDEeMBwGCgmSJomT8ixk\n" +
                "AQEMDmNvbS5ibGluY2guYXBwMTwwOgYDVQQDDDNBcHBsZSBEZXZlbG9wbWVudCBJ\n" +
                "T1MgUHVzaCBTZXJ2aWNlczogY29tLmJsaW5jaC5hcHAxEzARBgNVBAsMClk5SjI3\n" +
                "QTM0WFoxCzAJBgNVBAYTAlVTMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKC\n" +
                "AQEA4vorBjyYj5Eb8wmQOE5ZjQ/FOvBYKsGmpnV6d5IM8Z3A/DUidDtY4a+fiERf\n" +
                "fiNfpGul9PXEGFDkAEv8XSW8AAaKOlvCSAAl+U/DEuXpuVualGuBLZtBSW+fMkiA\n" +
                "uZ/zyF1Nu6dRgIbzzgo9C1BhJE+1722ENSBqsGaaJf6CfwdZ5gy6KR+5PcBPI6Av\n" +
                "paf5O+p99wj/Hp4KbxPwczFBAPEIKcD46ShBv2acnK8KLi4Ee2zA4s2mEOLUWx6l\n" +
                "Fpue/4bayfXWUx90O1qzvhdS29lpcS+Zd5qFjBnV0YKw8cKbdvZqhmrlJKRlDYkE\n" +
                "9zeYe4DEUs+GqIkfr/dRC2D8twIDAQABo4IB5TCCAeEwHQYDVR0OBBYEFCJYdvjO\n" +
                "Py5sv5J1aQeN9XmPqGzHMAkGA1UdEwQCMAAwHwYDVR0jBBgwFoAUiCcXCam2GGCL\n" +
                "7Ou69kdZxVJUo7cwggEPBgNVHSAEggEGMIIBAjCB/wYJKoZIhvdjZAUBMIHxMIHD\n" +
                "BggrBgEFBQcCAjCBtgyBs1JlbGlhbmNlIG9uIHRoaXMgY2VydGlmaWNhdGUgYnkg\n" +
                "YW55IHBhcnR5IGFzc3VtZXMgYWNjZXB0YW5jZSBvZiB0aGUgdGhlbiBhcHBsaWNh\n" +
                "YmxlIHN0YW5kYXJkIHRlcm1zIGFuZCBjb25kaXRpb25zIG9mIHVzZSwgY2VydGlm\n" +
                "aWNhdGUgcG9saWN5IGFuZCBjZXJ0aWZpY2F0aW9uIHByYWN0aWNlIHN0YXRlbWVu\n" +
                "dHMuMCkGCCsGAQUFBwIBFh1odHRwOi8vd3d3LmFwcGxlLmNvbS9hcHBsZWNhLzBN\n" +
                "BgNVHR8ERjBEMEKgQKA+hjxodHRwOi8vZGV2ZWxvcGVyLmFwcGxlLmNvbS9jZXJ0\n" +
                "aWZpY2F0aW9uYXV0aG9yaXR5L3d3ZHJjYS5jcmwwCwYDVR0PBAQDAgeAMBMGA1Ud\n" +
                "JQQMMAoGCCsGAQUFBwMCMBAGCiqGSIb3Y2QGAwEEAgUAMA0GCSqGSIb3DQEBBQUA\n" +
                "A4IBAQADU38WpcL6EwVd+LicKJjxnaEGjOSKM6uUUgSXnu/k4qeoZOX+eVxkcUyU\n" +
                "40uoTbUmH1Sf5JUvPVVMlS6pZT7qITYPuaF86Hy68yYrUtqcqsxQ2QKDJBvkiVaG\n" +
                "syP7zLeOOfmlzb2MZUs0m/p/B2dWVtOzp/ZeOSCK/rJRl62Ij/F+4F/+Vn9DhSba\n" +
                "on0WwZuLpq3SvvQ10u3f6uqpwfjpIUafW7gS4oSzupvwm/1CER8PMKepwBWXR3yp\n" +
                "Hg1svkpFd23YgtKHFOBCAfq7GkemwcO3izp2bzKTEhY/hrAS5XAF3mNEQZggThI0\n" +
                "H3/LlKJtqYg8BK2b0Xt/NYgN2e7f\n" +
                "-----END CERTIFICATE-----";
    }

}
