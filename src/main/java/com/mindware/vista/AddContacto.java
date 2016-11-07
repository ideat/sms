package com.mindware.vista;

import com.mindware.domain.Contacto;
import com.mindware.services.ContactoService;
import com.mindware.util.Tools;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import de.steinwedel.messagebox.MessageBox;

import java.util.Date;


@SuppressWarnings("serial")
public class AddContacto extends Window implements ClickListener{

	/*- VaadinEditorProperties={"grid":"RegularGrid,10","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_4;
	@AutoGenerated
	private Button btncerrar;
	@AutoGenerated
	private Button btnguardar;
	@AutoGenerated
	private Label lbltitulo;
	@AutoGenerated
	private GridLayout gridLayout_1;
	@AutoGenerated
	private Label lblcampo6;
	@AutoGenerated
	private Label lblcampo5;
	@AutoGenerated
	private Label lblcampo4;
	@AutoGenerated
	private TextField textField_9;
	@AutoGenerated
	private Label lblcampo3;
	@AutoGenerated
	private TextField textField_8;
	@AutoGenerated
	private Label lblcampo2;
	@AutoGenerated
	private TextField textField_7;
	@AutoGenerated
	private Label lblcampo1;
	@AutoGenerated
	private TextField textField_6;
	@AutoGenerated
	private Label lbltelefono;
	@AutoGenerated
	private TextField textField_4;
	@AutoGenerated
	private Label lblnombre;
	private static ContactoService contactoService;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public AddContacto() {
		buildMainLayout();
		//setCompositionRoot(mainLayout);
		setContent(mainLayout);
		postBuild();
	}

	public void postBuild() {
		this.btnguardar.addClickListener((ClickListener)this);
		this.btncerrar.addClickListener((ClickListener)this);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getSource()==this.btnguardar){
			if(validarDatos()){
				contactoService = new ContactoService();
				Contacto contacto = new Contacto();
				contacto.setCelular(textField_6.getValue());
				contacto.setNombreContacto((textField_4.getValue()));
				contacto.setCampo1(textField_7.getValue());
				contacto.setCampo2(textField_8.getValue());
				contacto.setCampo3(textField_9.getValue());
				java.util.Date fecha = new Date();
				contacto.setFechaImportacion(fecha);
				contacto.setEstado("ACTIVO");
				contacto.setUsuarioId(1); //TODO reemplazar con el codigo del usuario de logeo
				contactoService.insertaContacto(contacto);
				MessageBox.createInfo()
						.withCaption("Registro")
						.withMessage("Datos registrados con exito!")
						.open();
				limpiarDatos();
			}
			else {
				MessageBox.createError()
						.withCaption("Error")
						.withMessage("Revisar numero de telefono")
						.withAbortButton()
						.open();
			}
		}
		if (event.getSource()==this.btncerrar) {
			UI.getCurrent().removeWindow(this);
		}

	}

	private void limpiarDatos() {
		textField_6.clear();
		textField_4.clear();
		textField_7.clear();
		textField_8.clear();
		textField_9.clear();
	}

	private boolean validarDatos() {

		if (Tools.ValidarTelefono(textField_6.getValue())) {
			return true;
		}
		else
			return false;
	}


	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("450px");
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("500px");
		
		// gridLayout_1
		gridLayout_1 = buildGridLayout_1();
		mainLayout.addComponent(gridLayout_1, "top:70.0px;left:20.0px;");
		
		// lbltitulo
		lbltitulo = new Label();
		lbltitulo.setImmediate(false);
		lbltitulo.setWidth("-1px");
		lbltitulo.setHeight("-1px");
		lbltitulo.setValue("REGISTRO NUEVO CONTACTO");
		mainLayout.addComponent(lbltitulo, "top:12.0px;left:210.0px;");
		
		// horizontalLayout_4
		horizontalLayout_4 = buildHorizontalLayout_4();
		mainLayout.addComponent(horizontalLayout_4, "top:300.0px;left:38.0px;");
		
		return mainLayout;
	}


	@AutoGenerated
	private GridLayout buildGridLayout_1() {
		// common part: create layout
		gridLayout_1 = new GridLayout();
		gridLayout_1.setImmediate(false);
		gridLayout_1.setWidth("500px");
		gridLayout_1.setHeight("300px");
		gridLayout_1.setMargin(false);
		gridLayout_1.setColumns(2);
		gridLayout_1.setRows(8);
		
		// lblnombre
		lblnombre = new Label();
		lblnombre.setImmediate(false);
		lblnombre.setWidth("-1px");
		lblnombre.setHeight("-1px");
		lblnombre.setValue("Nombre completo:");
		gridLayout_1.addComponent(lblnombre, 0, 0);
		
		// textField_4
		textField_4 = new TextField();
		textField_4.setImmediate(false);
		textField_4.setWidth("307px");
		textField_4.setHeight("-1px");
		gridLayout_1.addComponent(textField_4, 1, 0);
		
		// lbltelefono
		lbltelefono = new Label();
		lbltelefono.setImmediate(false);
		lbltelefono.setWidth("-1px");
		lbltelefono.setHeight("-1px");
		lbltelefono.setValue("Número celuar:");
		gridLayout_1.addComponent(lbltelefono, 0, 1);
		
		// textField_6
		textField_6 = new TextField();
		textField_6.setImmediate(false);
		textField_6.setWidth("307px");
		textField_6.setHeight("-1px");
		gridLayout_1.addComponent(textField_6, 1, 1);
		
		// lblcampo1
		lblcampo1 = new Label();
		lblcampo1.setImmediate(false);
		lblcampo1.setWidth("-1px");
		lblcampo1.setHeight("-1px");
		lblcampo1.setValue("Campo 1:");
		gridLayout_1.addComponent(lblcampo1, 0, 2);
		
		// textField_7
		textField_7 = new TextField();
		textField_7.setImmediate(false);
		textField_7.setWidth("307px");
		textField_7.setHeight("-1px");
		gridLayout_1.addComponent(textField_7, 1, 2);
		
		// lblcampo2
		lblcampo2 = new Label();
		lblcampo2.setImmediate(false);
		lblcampo2.setWidth("-1px");
		lblcampo2.setHeight("-1px");
		lblcampo2.setValue("Campo 2:");
		gridLayout_1.addComponent(lblcampo2, 0, 3);
		
		// textField_8
		textField_8 = new TextField();
		textField_8.setImmediate(false);
		textField_8.setWidth("307px");
		textField_8.setHeight("-1px");
		gridLayout_1.addComponent(textField_8, 1, 3);
		
		// lblcampo3
		lblcampo3 = new Label();
		lblcampo3.setImmediate(false);
		lblcampo3.setWidth("-1px");
		lblcampo3.setHeight("-1px");
		lblcampo3.setValue("Campo 3: ");
		gridLayout_1.addComponent(lblcampo3, 0, 4);
		
		// textField_9
		textField_9 = new TextField();
		textField_9.setImmediate(false);
		textField_9.setWidth("307px");
		textField_9.setHeight("-1px");
		gridLayout_1.addComponent(textField_9, 1, 4);
		
		
		
		return gridLayout_1;
	}


	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_4() {
		// common part: create layout
		horizontalLayout_4 = new HorizontalLayout();
		horizontalLayout_4.setImmediate(false);
		horizontalLayout_4.setWidth("510px");
		horizontalLayout_4.setHeight("50px");
		horizontalLayout_4.setMargin(false);
		
		// btnguardar
		btnguardar = new Button();
		btnguardar.setCaption("Guardar");
		btnguardar.setImmediate(true);
		btnguardar.setWidth("120px");
		btnguardar.setHeight("-1px");
		horizontalLayout_4.addComponent(btnguardar);
		horizontalLayout_4.setComponentAlignment(btnguardar, new Alignment(20));
		
		// btncerrar
//		btncerrar = new Button("Cerrar",new Button.ClickListener() {
//
//			@Override
//			public void buttonClick(ClickEvent event) {
//				close();
//
//			}
//		});
		btncerrar = new Button();
		btncerrar.setCaption("Cerrar");
		btncerrar.setImmediate(true);
		btncerrar.setWidth("120px");
		btncerrar.setHeight("-1px");
		horizontalLayout_4.addComponent(btncerrar);
		horizontalLayout_4.setComponentAlignment(btncerrar, new Alignment(20));
		
		return horizontalLayout_4;
	}

}
