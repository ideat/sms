package com.mindware.util;

import com.mindware.domain.Mensaje;
import com.mindware.services.MensajeService;
import org.smslib.*;
import org.smslib.modem.SerialModemGateway;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by freddy on 06-11-16.
 */
public class SendSms {
	private SerialModemGateway gateway;

	public SendSms (String puertoModem, String puerto, int baud, String modem, String modelo) throws Exception{
		OutboundNotification outboundNotification = new OutboundNotification();
        gateway = new SerialModemGateway(puertoModem, puerto, baud,modem, modelo);
        gateway.setInbound(true);
        gateway.setOutbound(true);
    //    gateway.setSimPin("111");
        Service.getInstance().setOutboundMessageNotification(outboundNotification);
        Service.getInstance().addGateway(gateway);
 //       Service.getInstance().startService();
		
	}
	
	public void removeGateway(){
		try {
			Service.getInstance().removeGateway(gateway);
		} catch (GatewayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendMessage(String mensaje, String celular, int mensajeId, int numeroIntentos)  {

		Date fecha = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		String hora = sdf.format(fecha);
		//String hora = OffsetTime.now().toString();
		OutboundMessage msg = new OutboundMessage(celular,mensaje);

		Mensaje updateMensaje = new Mensaje();
		updateMensaje.setMensajeId(mensajeId);
		updateMensaje.setEnviado("T");
		updateMensaje.setFechaEnvio(fecha);
		updateMensaje.setHoraEnvio(hora);
		updateMensaje.setNumeroIntentos( numeroIntentos+1);
				
		try {
			
		//	if(0==1) {
			 Service.getInstance().sendMessage(msg);
			// Service.getInstance().queueMessage(msg)
			 actualizarMensaje(updateMensaje);
		//    }
		} catch (TimeoutException | GatewayException | IOException | InterruptedException e) {
			
			e.printStackTrace();
		}

	}


	public void sendMessages(List<Mensaje> mensajes) throws Exception {

		List<OutboundMessage> listaMensajes = new ArrayList<>();
		java.util.Date fecha = new Date();
		String hora = OffsetTime.now().toString();
		List<Mensaje> updateListaMensajes = new ArrayList<>();
		
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
			
			updateListaMensajes.add(updateMensaje);
			//TODO actualizar el mensaje con su estado, fecha y hora de envio y numero de intentos
		
		}

		Service.getInstance().sendMessages(listaMensajes,gateway.getGatewayId());
		actualizarMensajes(updateListaMensajes);
	
	}

	private void actualizarMensajes(List<Mensaje> listaMensajes) {
		MensajeService mensajeService = new MensajeService();
		mensajeService.updateListaMensajes(listaMensajes);

	}
	
	private void actualizarMensaje(Mensaje mensaje) {
		MensajeService mensajeService = new MensajeService();
		mensajeService.updateMensaje(mensaje);

	}

	public class OutboundNotification implements IOutboundMessageNotification {
	    public void process(AGateway gateway, OutboundMessage msg) {
	        System.out.println("Outbound handler called from Gateway: "
	                + gateway.getGatewayId());
	        System.out.println(msg);
	    }
	}
}
