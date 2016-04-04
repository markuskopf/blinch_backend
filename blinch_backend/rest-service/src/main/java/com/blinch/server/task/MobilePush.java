package com.blinch.server.task;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.blinch.server.task.tools.AmazonSNSClientWrapper;
import com.blinch.server.task.tools.SampleMessageGenerator;

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

    public static final Map<SampleMessageGenerator.Platform, Map<String, MessageAttributeValue>> attributesMap = new HashMap<SampleMessageGenerator.Platform, Map<String, MessageAttributeValue>>();
    static {
        attributesMap.put(SampleMessageGenerator.Platform.ADM, null);
        attributesMap.put(SampleMessageGenerator.Platform.GCM, null);
        attributesMap.put(SampleMessageGenerator.Platform.APNS, null);
        attributesMap.put(SampleMessageGenerator.Platform.APNS_SANDBOX, null);
    }


    public void demoAppleSandboxAppNotification() {
        // TODO: Please fill in following values for your application. You can
        // also change the notification payload as per your preferences using
        // the method
        // com.amazonaws.sns.samples.tools.SampleMessageGenerator.getSampleAppleMessage()
        String certificate = "-----BEGIN CERTIFICATE-----\n" +
                "MIIFozCCBIugAwIBAgIILdV16Y0XTOIwDQYJKoZIhvcNAQEFBQAwgZYxCzAJBgNV\n" +
                "BAYTAlVTMRMwEQYDVQQKDApBcHBsZSBJbmMuMSwwKgYDVQQLDCNBcHBsZSBXb3Js\n" +
                "ZHdpZGUgRGV2ZWxvcGVyIFJlbGF0aW9uczFEMEIGA1UEAww7QXBwbGUgV29ybGR3\n" +
                "aWRlIERldmVsb3BlciBSZWxhdGlvbnMgQ2VydGlmaWNhdGlvbiBBdXRob3JpdHkw\n" +
                "HhcNMTYwMzMwMTQxNTM1WhcNMTcwMzMwMTQxNTM1WjCBojEvMC0GCgmSJomT8ixk\n" +
                "AQEMH2NvbS5ibGluY2guUHVzaE5vdGlmaWNhdGlvbkRlbW8xTTBLBgNVBAMMREFw\n" +
                "cGxlIERldmVsb3BtZW50IElPUyBQdXNoIFNlcnZpY2VzOiBjb20uYmxpbmNoLlB1\n" +
                "c2hOb3RpZmljYXRpb25EZW1vMRMwEQYDVQQLDApZOUoyN0EzNFhaMQswCQYDVQQG\n" +
                "EwJVUzCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAM5rwB3USEAWl8Cq\n" +
                "v3o/zaw7mT0rd58rvV86PRe7De4deGLGT7fkow0NTHf5l1DFhFGhgjBE9rH/bHVS\n" +
                "rr+7KHzAy4c8qLyZ8fik87ViI7yxT1zLMAPrUg6sPqRphod5G42wKJUQctMlAiD9\n" +
                "W8Cyf+h4Ubv5Brnns0An10ORu3PAASJXOUKinLkHaVWccDFLJdwykqmSKxzIbEdK\n" +
                "/CMDTg2bnimdJ7b4FGY8rE4aV8z3k5GfBWArVvsMZ6IlWrNektoD5UXTSG2P5fXW\n" +
                "hZxP4pgQr6mK2yBvsnfo/RqxawDbqCeOjpxd08spPmfq4l3YDcphmjqSf+om+jqW\n" +
                "BGTRbnkCAwEAAaOCAeUwggHhMB0GA1UdDgQWBBRC7LH3Vx+FOsPpHw3xp4tJg20N\n" +
                "9DAJBgNVHRMEAjAAMB8GA1UdIwQYMBaAFIgnFwmpthhgi+zruvZHWcVSVKO3MIIB\n" +
                "DwYDVR0gBIIBBjCCAQIwgf8GCSqGSIb3Y2QFATCB8TCBwwYIKwYBBQUHAgIwgbYM\n" +
                "gbNSZWxpYW5jZSBvbiB0aGlzIGNlcnRpZmljYXRlIGJ5IGFueSBwYXJ0eSBhc3N1\n" +
                "bWVzIGFjY2VwdGFuY2Ugb2YgdGhlIHRoZW4gYXBwbGljYWJsZSBzdGFuZGFyZCB0\n" +
                "ZXJtcyBhbmQgY29uZGl0aW9ucyBvZiB1c2UsIGNlcnRpZmljYXRlIHBvbGljeSBh\n" +
                "bmQgY2VydGlmaWNhdGlvbiBwcmFjdGljZSBzdGF0ZW1lbnRzLjApBggrBgEFBQcC\n" +
                "ARYdaHR0cDovL3d3dy5hcHBsZS5jb20vYXBwbGVjYS8wTQYDVR0fBEYwRDBCoECg\n" +
                "PoY8aHR0cDovL2RldmVsb3Blci5hcHBsZS5jb20vY2VydGlmaWNhdGlvbmF1dGhv\n" +
                "cml0eS93d2RyY2EuY3JsMAsGA1UdDwQEAwIHgDATBgNVHSUEDDAKBggrBgEFBQcD\n" +
                "AjAQBgoqhkiG92NkBgMBBAIFADANBgkqhkiG9w0BAQUFAAOCAQEAHn5HP8nc/W20\n" +
                "3r9jFBWE9d3NSgXUAcosGqdICzPNKfIk5mGhplakJ6H7wc+WfulJJD02d8bBDeA9\n" +
                "5spW8iNEeBScnHXSUqyszDGwz0lvYd/fIsTEUY/fIrsNK/LNQuLHVDN0KcIhQv2t\n" +
                "iPUbKD2YrWibBprv3aKAUUFYYQQ/97de9fhaSnB4Gihd4HItd8WPGUIQ/rxpV4wx\n" +
                "AqL6ISgl8XGkuvrm9pXReG+CLJBosqLmKgKSoZ8gKcQz9NkmYG5zw5ELVtq7PcL6\n" +
                "Wtn7w4BLehDhXS7+XzsjMmkzbI/rQta3d7B1rJqJ8CqaqDYb7XUCag3Fo+QZgohK\n" +
                "wJ3lt24K/w==\n" +
                "-----END CERTIFICATE-----"; // This should be in pem format with \n at the
        // end of each line.


        String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
                "MIIEpAIBAAKCAQEAzmvAHdRIQBaXwKq/ej/NrDuZPSt3nyu9Xzo9F7sN7h14YsZP\n" +
                "t+SjDQ1Md/mXUMWEUaGCMET2sf9sdVKuv7sofMDLhzyovJnx+KTztWIjvLFPXMsw\n" +
                "A+tSDqw+pGmGh3kbjbAolRBy0yUCIP1bwLJ/6HhRu/kGueezQCfXQ5G7c8ABIlc5\n" +
                "QqKcuQdpVZxwMUsl3DKSqZIrHMhsR0r8IwNODZueKZ0ntvgUZjysThpXzPeTkZ8F\n" +
                "YCtW+wxnoiVas16S2gPlRdNIbY/l9daFnE/imBCvqYrbIG+yd+j9GrFrANuoJ46O\n" +
                "nF3Tyyk+Z+riXdgNymGaOpJ/6ib6OpYEZNFueQIDAQABAoIBAQDKWS33D8XTrVIN\n" +
                "eFRDjpAbqkDJifa1fbchxoFk5eT96r28dhJnfiWoAcVYRr9iWn0fWGe60Z/TVUQI\n" +
                "rojHQryproTViU0PtQlSaMDOqenGazoVCMmEzgWehJLTsO5DlyC/gFQH7Bvjh3/S\n" +
                "vwpWl6RzSp802SUS0GMTHPsULaPIDkkgaFCU9EoR0CNToMHmlOYT9eOMDG0EH0ai\n" +
                "l1Oq2Ynz7KAs3Is5GPC8vUyBYKT7uATYRlmcHHHXy/0m9KYshvIoAE5U1BEls8bN\n" +
                "Vw36dqiY02CrtiFjAr1ahGszo2bkj71+QSrvbx0jgqtMdRfMVlkoDWI82gPoDsHA\n" +
                "nDHnIaBBAoGBAO13rTosKV+3HFFP+SzqiGi0Lc+b8eOZWrdXPMzBE1CNcGTBOsXR\n" +
                "6gZpvYOYM8t3PvZKcgGap18t6UGMnz2b9tBzWS7FlHsIbH9i+FrX87IVTjF5np7I\n" +
                "L+DFm+KEIuZaSqDF7DdaL13lHxfgl6tqof5xpECNs7qzOau5+T+FKqzdAoGBAN6H\n" +
                "zJi4knVDvRKemzEDPzSqTlbhwu1PpAxvyNs7Do744d8bJ+apeTDaywZZ0Kd6WHNj\n" +
                "eJ942wUwdppRMXS0ZvvNatG0Z6WOTj5KctGtNrxtas4kWw6L+LqMNx3nOxDyqnWs\n" +
                "RFerqL55s5LGgbFDEvjEYhK4iWWWO6QI6rvWujBNAoGAKuIQ00+ETTepEnoJunXE\n" +
                "GnxnRXWY8gwQmMlVPnijf0l7gYZvkae9xli0E56Zw+WN5jY9blK6ZPLKi77URvDy\n" +
                "WmRqN4sQrEMyLLL3vJgA9yjnzQF0hqIKG2I0K2zHTKgDkBMN/FT59s/YlJxHZ3pD\n" +
                "NMra6ZltWorhIETeYP0wXrUCgYByVwCPcDcAvd+Gk6xWEL8HRoKeLb5ExWkbYsyn\n" +
                "qL6gQ817H67u3CGDMsii6L9HbpvIHlI6TpTrI62tOQ7aUl+f/jpmqfWfoXEenI5G\n" +
                "omO/idEZPqDy5oTVBXrEiK1W1fk0IWG0UmWQCWR1hD3bYQV8gRuLVvpyEjFu5Y4H\n" +
                "Ghvs+QKBgQC9GIa5Y1QVJWGRkJ67b5ysdnxU5hLenA2IequaWgDTNKIg7TTCY5J0\n" +
                "6mrnKIkvZNKYoL+oRWPPLfu+815fo+yWRBV+vrQ0oHaOR8MPGM+l/prY4K34cbMV\n" +
                "P3d94NhZmisidaaFkJERmu2YeYHNUMtpyS0NXWJrBMtlAQcflZ0ZTw==\n" +
                "-----END RSA PRIVATE KEY-----\n"; // This should be in pem format with \n at the
        // end of each line.
        String applicationName = "PushNotificationDemo";
        String deviceToken = "a17890bc9a50586788faa37e75c69a595779b6e073f2e297423bbf6273065f07"; // This is 64 hex characters.
        snsClientWrapper.demoNotification(SampleMessageGenerator.Platform.APNS_SANDBOX, certificate,
                privateKey, deviceToken, applicationName, attributesMap);
    }

}
