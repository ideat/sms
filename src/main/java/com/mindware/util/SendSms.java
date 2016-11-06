package com.mindware.util;

import org.smslib.*;
import org.smslib.modem.SerialModemGateway;

import java.io.IOException;

/**
 * Created by freddy on 06-11-16.
 */
public class SendSms {
    private void sendMessage(String mensaje, String celular) throws SMSLibException, InterruptedException, IOException {
        OutboundNotification outboundNotification = new OutboundNotification();

        SerialModemGateway gateway = new SerialModemGateway("modem.com9",
                "COM9", 9600, "Huawei", "E303");
        gateway.setInbound(false);
        gateway.setOutbound(true);
        // gateway.setSimPin("");
        Service.getInstance().setOutboundMessageNotification(outboundNotification);
        Service.getInstance().addGateway(gateway);
        Service.getInstance().startService();

        // Send a message synchronously. "+59160700381"
        OutboundMessage msg = new OutboundMessage(celular,
                mensaje);

//    Service service = Service.getInstance();
        Service.getInstance().sendMessage(msg);

//        Service.getInstance().stopService();


    }

    public class OutboundNotification implements IOutboundMessageNotification
    {
        public void process(AGateway gateway, OutboundMessage msg)
        {
            System.out.println("Outbound handler called from Gateway: " + gateway.getGatewayId());
            System.out.println(msg);
        }
    }
}
