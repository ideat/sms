package com.mindware.vista;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class GrupoForm extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_3;
	@AutoGenerated
	private Table tblMiembros;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private Table tblListaGrupos;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private Button btnComponer;
	@AutoGenerated
	private Button btnEliminar;
	@AutoGenerated
	private Button btnEditar;
	@AutoGenerated
	private Button btnNuevo;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public GrupoForm() {
		buildMainLayout();
		cabeceraTablas();
		setCompositionRoot(mainLayout);
		
		btnNuevo.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				AddGrupo addGrupo = new AddGrupo();
				addGrupo.setModal(true);
				addGrupo.setWidth("600px");
				addGrupo.setHeight("460px");
				addGrupo.center();
				
				UI.getCurrent().addWindow(addGrupo);
				
			}
		});
	
		

		// TODO add user code here
	}
	
	private void cabeceraTablas(){
		tblListaGrupos.addContainerProperty("Grupo", String.class,null);
		tblListaGrupos.addContainerProperty("Nro de contactos", Integer.class,null);
		tblMiembros.addContainerProperty("Miembros", String.class, null);
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
		mainLayout.addComponent(horizontalLayout_1, "top:20.0px;right:0.0px;left:20.0px;");
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		mainLayout.addComponent(horizontalLayout_2, "top:80.0px;left:20.0px;");
		
		// horizontalLayout_3
		horizontalLayout_3 = buildHorizontalLayout_3();
		mainLayout.addComponent(horizontalLayout_3, "top:340.0px;left:20.0px;");
		
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
		
		// btnNuevo
		btnNuevo = new Button();
		btnNuevo.setCaption("Nuevo");
		btnNuevo.setImmediate(true);
		btnNuevo.setWidth("100px");
		btnNuevo.setHeight("-1px");
		horizontalLayout_1.addComponent(btnNuevo);
		horizontalLayout_1.setComponentAlignment(btnNuevo, new Alignment(20));
		
		// btnEditar
		btnEditar = new Button();
		btnEditar.setCaption("Editar");
		btnEditar.setImmediate(true);
		btnEditar.setWidth("100px");
		btnEditar.setHeight("-1px");
		horizontalLayout_1.addComponent(btnEditar);
		horizontalLayout_1.setComponentAlignment(btnEditar, new Alignment(20));
		
		// btnEliminar
		btnEliminar = new Button();
		btnEliminar.setCaption("Eliminar");
		btnEliminar.setImmediate(true);
		btnEliminar.setWidth("100px");
		btnEliminar.setHeight("-1px");
		horizontalLayout_1.addComponent(btnEliminar);
		horizontalLayout_1.setComponentAlignment(btnEliminar, new Alignment(20));
		
		// btnComponer
		btnComponer = new Button();
		btnComponer.setCaption("Componer");
		btnComponer.setImmediate(true);
		btnComponer.setWidth("100px");
		btnComponer.setHeight("-1px");
		horizontalLayout_1.addComponent(btnComponer);
		horizontalLayout_1.setComponentAlignment(btnComponer, new Alignment(20));
		
		return horizontalLayout_1;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_2() {
		// common part: create layout
		horizontalLayout_2 = new HorizontalLayout();
		horizontalLayout_2.setImmediate(false);
		horizontalLayout_2.setWidth("100.0%");
		horizontalLayout_2.setHeight("240px");
		horizontalLayout_2.setMargin(false);
		
		// tblListaGrupos
		tblListaGrupos = new Table();
		tblListaGrupos.setImmediate(false);
		tblListaGrupos.setWidth("100.0%");
		tblListaGrupos.setHeight("240px");
		horizontalLayout_2.addComponent(tblListaGrupos);
		horizontalLayout_2.setExpandRatio(tblListaGrupos, 1.0f);
		
		return horizontalLayout_2;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_3() {
		// common part: create layout
		horizontalLayout_3 = new HorizontalLayout();
		horizontalLayout_3.setImmediate(false);
		horizontalLayout_3.setWidth("100.0%");
		horizontalLayout_3.setHeight("160px");
		horizontalLayout_3.setMargin(false);
		
		// tblMiembros
		tblMiembros = new Table();
		tblMiembros.setImmediate(false);
		tblMiembros.setWidth("100.0%");
		tblMiembros.setHeight("-1px");
		horizontalLayout_3.addComponent(tblMiembros);
		horizontalLayout_3.setExpandRatio(tblMiembros, 1.0f);
		
		return horizontalLayout_3;
	}

}