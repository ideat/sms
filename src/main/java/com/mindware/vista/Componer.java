package com.mindware.vista;

import com.mindware.domain.Contacto;
import com.mindware.domain.Mensaje;
import com.mindware.services.ContactoService;
import com.mindware.services.MensajeService;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Property;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.AbstractTextField.TextChangeEventMode;
import de.steinwedel.messagebox.MessageBox;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("serial")
public class Componer extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private TextArea txtMensaje;
	@AutoGenerated
	private Label lblContador;
	@AutoGenerated
	private ComboBox cmbVariables;
	@AutoGenerated
	private AbsoluteLayout absoluteLayout_3;
	@AutoGenerated
	private Label label_4;
	@AutoGenerated
	private Label label_3;
	@AutoGenerated
	private Label label_2;
	@AutoGenerated
	private ComboBox cmbGrupo;
	@AutoGenerated
	private TextField txtAsunto;
	@AutoGenerated
	private TextField txtNumeros;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private NativeButton btnLimpiar;
	@AutoGenerated
	private NativeButton btnEnviar;
	@AutoGenerated
	private NativeButton btnEnviarBandejaSalida;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private Label titulo;
	private GridLayout gridLayout;
	private String grupo;
	private MensajeService mensajeService;
	private ContactoService contactoService;

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public Componer() {
		
		buildMainLayout();
		llenaVarialbles();
		grupo = "";
		setCompositionRoot(mainLayout);
		txtMensaje.addTextChangeListener(new TextChangeListener() {
			
			public void textChange(TextChangeEvent event) {
				int len = event.getText().length();
				lblContador.setValue(len + " de " + txtMensaje.getMaxLength());
				
			}
		});
		txtMensaje.setTextChangeEventMode(TextChangeEventMode.EAGER);
		txtMensaje.addTextChangeListener(new TextChangeListener() {
			
			public void textChange(TextChangeEvent event) {
				int len = event.getText().length();
				lblContador.setValue(len + " de " + txtMensaje.getMaxLength());
			}
			
		});

		cmbGrupo.addValueChangeListener(new Property.ValueChangeListener() {
			@Override
			public void valueChange(Property.ValueChangeEvent event) {
				 grupo = event.getProperty().getValue().toString();
			}
		});
		
		txtMensaje.setTextChangeEventMode(TextChangeEventMode.EAGER);
		setVariable();
		Formato();
		//Envio de mensajes
		sendMessages();
	}

	private void sendMessages() {
		btnEnviarBandejaSalida.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(Button.ClickEvent event) {
				try {
					mensajeService = new MensajeService();
					contactoService = new ContactoService();
					//TODO reemplazar el 1 por el codigo de usuario de logeo
					List<Mensaje> mensajes = mensajeService.prepararMensajes(txtMensaje.getValue(),
							contactoService.contactSelected(1,
									numeroCelulares(txtNumeros.getValue())), grupo);
					mensajeService.insertarMensaje(mensajes);
					MessageBox.createInfo()
							.withCaption("Bandeja Salida")
							.withMessage("Mensajes enviados a la Bandeja de Salida")
							.open();
					limpiar();
				}
				catch (Exception e) {
					MessageBox.createError()
							.withCaption("Error")
							.withMessage("Error al enviar a la Bandeja de Salida " + e)
							.withAbortButton()
							.open();
				}

			}
		});


	}


	private void limpiar() {
		txtMensaje.clear();
		txtNumeros.clear();

	}

	private void setVariable () {
		cmbVariables.addListener(new Listener() {
			@Override
			public void componentEvent(Event event) {
				txtMensaje.setValue(txtMensaje.getValue().toString() + "#"+cmbVariables.getValue().toString()+"#");

			}
		});
	}


	private void llenaVarialbles() {
		cmbVariables.addItem("celular");
		cmbVariables.addItem("nombre");
		cmbVariables.addItem("campo1");
		cmbVariables.addItem("campo2");
		cmbVariables.addItem("campo3");
	}

	private void Formato() {
		titulo.setContentMode(ContentMode.HTML);
		titulo.setStyleName("titulo");
		btnEnviarBandejaSalida.addStyleName("boton");
	//	btnEnvioRapido.addStyleName("boton");
		btnLimpiar.addStyleName("boton");
		btnEnviar.addStyleName("boton");
	}

	//Obtiene la lista de contactos seleccionados
	private List<Contacto> obtenerListaContactos() {
		contactoService = new ContactoService();
		//TODO: Reemplazar 1 por el codigo de usuario
		List<Contacto> listContactos = contactoService.contactSelected(1,
				numeroCelulares(txtNumeros.getValue().toString()));
		return listContactos;
	}

	public List<String> numeroCelulares(String celulares) {
		txtNumeros.setValue(celulares);
		String[] cel = celulares.split(",");
		List<String> listCell = Arrays.asList(cel);
		return listCell;

	}
	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("460px");
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("460px");
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		mainLayout.addComponent(horizontalLayout_1, "top:2.0px;left:0.0px;");
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		mainLayout.addComponent(horizontalLayout_2, "top:85.0px;left:0.0px;");
		
		// absoluteLayout_3
		absoluteLayout_3 = buildAbsoluteLayout_3();
		mainLayout.addComponent(absoluteLayout_3, "top:177.0px;left:18.0px;");
		
		// cmbVariables
		cmbVariables = new ComboBox();
		cmbVariables.setCaption("Lista Variables");
		cmbVariables.setImmediate(true);
		cmbVariables.setWidth("197px");
		cmbVariables.setHeight("-1px");
		mainLayout.addComponent(cmbVariables, "top:316.0px;left:363.0px;");
		
		// lblContador
		lblContador = new Label();
		lblContador.setImmediate(false);
		lblContador.setWidth("-1px");
		lblContador.setHeight("-1px");
		lblContador.setValue("0 de 160");
		mainLayout.addComponent(lblContador, "top:322.0px;left:40.0px;");
		
		// txtMensaje
		txtMensaje = new TextArea();
		txtMensaje.setImmediate(false);
		txtMensaje.setWidth("580px");
		txtMensaje.setHeight("-1px");
		txtMensaje.setMaxLength(160);
		mainLayout.addComponent(txtMensaje, "top:345.0px;left:20.0px;");
		
		return mainLayout;
	}


	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("640px");
		horizontalLayout_1.setHeight("78px");
		horizontalLayout_1.setMargin(true);
		
		// titulo
		titulo = new Label();
		titulo.setImmediate(false);
		titulo.setWidth("560px");
		titulo.setHeight("60px");
		titulo.setValue("Componer mensaje SMS");
		horizontalLayout_1.addComponent(titulo);
		horizontalLayout_1.setComponentAlignment(titulo, new Alignment(48));
		
		return horizontalLayout_1;
	}


	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_2() {
		// common part: create layout
		
		
		horizontalLayout_2 = new HorizontalLayout();
		horizontalLayout_2.setImmediate(false);
		horizontalLayout_2.setWidth("740px");
		horizontalLayout_2.setHeight("75px");
		horizontalLayout_2.setMargin(true);
		horizontalLayout_2.setDefaultComponentAlignment(Alignment.TOP_LEFT);
				
		// btnEnviar
		btnEnviar = new NativeButton();
		btnEnviar.setCaption("Enviar SMS");
		btnEnviar.setImmediate(true);
		btnEnviar.setWidth("160px");
		btnEnviar.setHeight("37px");
		horizontalLayout_2.addComponent(btnEnviar);
		
		// btnEnviarBandejaSalida
		btnEnviarBandejaSalida = new NativeButton();
		btnEnviarBandejaSalida.setCaption("Enviar Bandeja Salida");
		btnEnviarBandejaSalida.setImmediate(true);
		btnEnviarBandejaSalida.setWidth("160px");
		btnEnviarBandejaSalida.setHeight("37px");
		btnEnviarBandejaSalida.setIcon(FontAwesome.SEND);
		horizontalLayout_2.addComponent(btnEnviarBandejaSalida);
		
		// btnLimpiar
		btnLimpiar = new NativeButton();
		btnLimpiar.setCaption("Limpiar");
		btnLimpiar.setImmediate(true);
		btnLimpiar.setWidth("160px");
		btnLimpiar.setHeight("37px");
		horizontalLayout_2.addComponent(btnLimpiar);
					
		return horizontalLayout_2;
	}


	@AutoGenerated
	private AbsoluteLayout buildAbsoluteLayout_3() {
		// common part: create layout
		absoluteLayout_3 = new AbsoluteLayout();
		absoluteLayout_3.setImmediate(false);
		absoluteLayout_3.setWidth("602px");
		absoluteLayout_3.setHeight("100px");
		
		// txtNumeros
		txtNumeros = new TextField();
		txtNumeros.setImmediate(false);
		txtNumeros.setWidth("100.0%");
		txtNumeros.setHeight("-1px");
		absoluteLayout_3.addComponent(txtNumeros, "top:0.0px;right:20.0px;left:82.0px;");
		
		// txtAsunto
		txtAsunto = new TextField();
		txtAsunto.setImmediate(false);
		txtAsunto.setWidth("100.0%");
		txtAsunto.setHeight("-1px");
		absoluteLayout_3.addComponent(txtAsunto, "top:73.0px;right:20.0px;left:82.0px;");
		
		// cmbGrupo
		cmbGrupo = new ComboBox();
		cmbGrupo.setImmediate(true);
		cmbGrupo.setWidth("100.0%");
		cmbGrupo.setHeight("-1px");
		absoluteLayout_3.addComponent(cmbGrupo, "top:36.0px;right:20.0px;left:82.0px;");
		
		// label_2
		label_2 = new Label();
		label_2.setImmediate(false);
		label_2.setWidth("-1px");
		label_2.setHeight("-1px");
		label_2.setValue("A numeros:");
		absoluteLayout_3.addComponent(label_2, "top:0.0px;left:2.0px;");
		
		// label_3
		label_3 = new Label();
		label_3.setImmediate(false);
		label_3.setWidth("-1px");
		label_3.setHeight("-1px");
		label_3.setValue("Grupo:");
		absoluteLayout_3.addComponent(label_3, "top:40.0px;left:2.0px;");
		
		// label_4
		label_4 = new Label();
		label_4.setImmediate(false);
		label_4.setWidth("-1px");
		label_4.setHeight("-1px");
		label_4.setValue("Asunto:");
		absoluteLayout_3.addComponent(label_4, "top:79.0px;left:2.0px;");
		
		return absoluteLayout_3;
	}


}
