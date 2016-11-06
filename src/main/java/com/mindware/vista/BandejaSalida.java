package com.mindware.vista;

import com.mindware.domain.Mensaje;
import com.mindware.services.MensajeService;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.ui.*;

import java.util.List;

public class BandejaSalida extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Table tblSalida;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private NativeButton btnEliminar;
	@AutoGenerated
	private NativeButton btnreenviar;
	@AutoGenerated
	private NativeButton btnenviar;
	private NativeButton btnCargarMensajes;

	private MensajeService mensajeService;

	public BandejaSalida() {
		buildMainLayout();
		cabeceraTabla();
		setCompositionRoot(mainLayout);

		//Llena bandeja de salida

		cargarMensajes();

	}
	
	private void cargarMensajes() {
		btnCargarMensajes.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(Button.ClickEvent event) {
				mensajeService = new MensajeService();
				llenarBandejaSalida(mensajeService.findMensajesUsuario(1,"F")); //;
			}
		});

	}


	private void cabeceraTabla() {

		tblSalida.addContainerProperty("ID", Integer.class, null);
		tblSalida.addContainerProperty("Celular", String.class, null);
		tblSalida.addContainerProperty("Nombre Contacto", String.class, null);
		tblSalida.addContainerProperty("Mensaje", String.class, null);
		tblSalida.addContainerProperty("Longitud mensaje", Integer.class, null);
		tblSalida.setPageLength(20);
	}

	private void llenarBandejaSalida(List<Mensaje> mensajes) {
		if (mensajes.size() > 0) {
			IndexedContainer containerMensaje = new IndexedContainer();

			containerMensaje.addContainerProperty("ID", Integer.class,"");
			containerMensaje.addContainerProperty("Celular", String.class,"");
			containerMensaje.addContainerProperty("Nombre", String.class,"");
			containerMensaje.addContainerProperty("Mensaje", String.class,"");
			containerMensaje.addContainerProperty("Longitud", Integer.class,"");

			for(Mensaje mensaje : mensajes) {
				Item item = containerMensaje.addItem(mensaje);
				item.getItemProperty("ID").setValue(mensaje.getMensajeId());
				item.getItemProperty("Celular").setValue(mensaje.getCelular());
				item.getItemProperty("Nombre").setValue(mensaje.getNombre());
				item.getItemProperty("Mensaje").setValue(mensaje.getMensaje());
				item.getItemProperty("Longitud").setValue(mensaje.getLongitudSms());
			}
			tblSalida.setContainerDataSource(containerMensaje);



		}

	}

	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		mainLayout.addComponent(horizontalLayout_1, "top:20.0px;left:100.0px;");
		
		// tblSalida
		tblSalida = new Table();
		tblSalida.setCaption("Mensajes a Enviar");
		tblSalida.setImmediate(false);
		tblSalida.setWidth("100.0%");
		tblSalida.setHeight("100.0%");
		tblSalida.setSelectable(true);
		tblSalida.setMultiSelectMode(MultiSelectMode.SIMPLE);
		tblSalida.setMultiSelect(true);
		mainLayout.addComponent(tblSalida, "top:80.0px;right:54.0px;bottom:118.0px;left:12.0px;");
		
		return mainLayout;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("100.0%");
		horizontalLayout_1.setHeight("40px");
		horizontalLayout_1.setMargin(false);

		// btnCargarMensajes
		btnCargarMensajes = new NativeButton();
		btnCargarMensajes.setCaption("Cargar Mensajes");
		btnCargarMensajes.setImmediate(false);
		btnCargarMensajes.setWidth("130px");
		btnCargarMensajes.setHeight("40px");
		horizontalLayout_1.addComponent(btnCargarMensajes);
		horizontalLayout_1.setComponentAlignment(btnCargarMensajes, new Alignment(20));

		// btnenviar
		btnenviar = new NativeButton();
		btnenviar.setCaption("Enviar");
		btnenviar.setImmediate(false);
		btnenviar.setWidth("130px");
		btnenviar.setHeight("40px");
		horizontalLayout_1.addComponent(btnenviar);
		horizontalLayout_1.setComponentAlignment(btnenviar, new Alignment(20));

		
		// btnreenviar
		btnreenviar = new NativeButton();
		btnreenviar.setCaption("Reenviar");
		btnreenviar.setImmediate(false);
		btnreenviar.setWidth("130px");
		btnreenviar.setHeight("40px");
		horizontalLayout_1.addComponent(btnreenviar);
		horizontalLayout_1.setComponentAlignment(btnreenviar, new Alignment(20));

		
		// btnEliminar
		btnEliminar = new NativeButton();
		btnEliminar.setCaption("Eliminar");
		btnEliminar.setImmediate(false);
		btnEliminar.setWidth("130px");
		btnEliminar.setHeight("40px");
		horizontalLayout_1.addComponent(btnEliminar);
		horizontalLayout_1.setComponentAlignment(btnEliminar, new Alignment(20));
		
		return horizontalLayout_1;
	}

}
