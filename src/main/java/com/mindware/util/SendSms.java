package com.mindware.util;

import com.mindware.domain.Mensaje;
import com.mindware.services.MensajeService;
import org.smslib.*;
import org.smslib.modem.SerialModemGateway;

import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by freddy on 06-11-16.
 */
public class SendSms {



	public void sendMessage(List<Mensaje> mensajes) throws Exception {

		OutboundNotification outboundNotification = new OutboundNotification();
//	    System.out.println("Sample of Send message from a serial gsm modem.");
//	    System.out.println(Library.getLibraryDescription());
//	    System.out.println("Version: " + Library.getLibraryVersion());
	    SerialModemGateway gateway = new SerialModemGateway("modem.com6", "COM6", 9600, "Huawei", "E303");
	   
	    gateway.setInbound(false);
	    gateway.setOutbound(true);

	    Service.getInstance().setOutboundMessageNotification(outboundNotification);
	    Service.getInstance().addGateway(gateway);
	    Service.getInstance().startService();
	    
	    System.out.println();
	    System.out.println("Modem Information:");
	    System.out.println("  Manufacturer: " + gateway.getManufacturer());
	    System.out.println("  Model: " + gateway.getModel());
	    System.out.println("  Serial No: " + gateway.getSerialNo());
	    System.out.println("  SIM IMSI: " + gateway.getImsi());
	    System.out.println("  Signal Level: " + gateway.getSignalLevel()
	            + " dBm");
	    System.out.println("  Battery Level: " + gateway.getBatteryLevel()
	            + "%");

	    // Send a message synchronously.
//		OutboundMessage msg = new OutboundMessage("+59179707808",
//				"Mensaje de Prueba");
		List<OutboundMessage> listaMensajes = new ArrayList<>();
		java.util.Date fecha = new Date();
		String hora = OffsetTime.now().toString();

		try {
			for (Mensaje mensaje : mensajes) {
				Mensaje updateMensaje = new Mensaje();
				OutboundMessage msg = new OutboundMessage(mensaje.getCelular(),
						mensaje.getMensaje());
				listaMensajes.add(msg);

				updateMensaje.setMensajeId(mensaje.getMensajeId());
				updateMensaje.setEnviado("T");
				updateMensaje.setFechaEnvio(fecha);
				updateMensaje.setHoraEnvio(hora);
				updateMensaje.setNumeroIntentos( mensaje.getNumeroIntentos()+1);
				//TODO actualizar el mensaje con su estado, fecha y hora de envio y numero de intentos

				System.out.println(msg);
			}
			Service.getInstance().sendMessages(listaMensajes,gateway.getGatewayId());

		} finally {
			Service.getInstance().stopService();
		}
	}

	private void actualizarMensaje() {
		MensajeService mensajeService = new MensajeService();

	}

	public class OutboundNotification implements IOutboundMessageNotification {
	    public void process(AGateway gateway, OutboundMessage msg) {
	        System.out.println("Outbound handler called from Gateway: "
	                + gateway.getGatewayId());
	        System.out.println(msg);
	    }
	}
}
