package com.mindware.vista;

import com.mindware.domain.Contacto;
import com.mindware.domain.ContactoGrupo;
import com.mindware.domain.Grupo;
import com.mindware.services.ContactoGrupoService;
import com.mindware.services.ContactoService;
import com.mindware.services.GrupoService;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import de.steinwedel.messagebox.MessageBox;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EditGrupo extends Window {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

    @AutoGenerated
    private AbsoluteLayout mainLayout;
    @AutoGenerated
    private TextField edtGrupo;
    @AutoGenerated
    private Label label_1;
    @AutoGenerated
    private HorizontalLayout horizontalLayout_4;
    @AutoGenerated
    private Button btnCerrar;
    @AutoGenerated
    private Button btnGuardar;
    @AutoGenerated
    private HorizontalLayout horizontalLayout_1;
    private VerticalLayout verticalButton;
    private Table tableRight;
    private Table tableLeft;
    //	private NativeButton btnGuardarGrupo;
    private Button btnMoveLeft;
    private Button btnMoveRight;
    private Button btnMoveAllRight;
    private Button btnMoveAllLeft;
    private GrupoService grupoService;
    private ContactoService contactoService;
    final Label current = new Label("Selected: -");

    private List<Contacto> itemsSelectedLeft  = new ArrayList<>();
    private List<Contacto> itemsSelectedRight = new ArrayList<>();

    private Date fechaImportacion;

    private List<Integer> contactosId;

    private static ContactoGrupoService contactoGrupoService;





    public EditGrupo( int grupoEdit, String nombreGrupo) {
        buildMainLayout();

        fillTableMembersGroup(grupoEdit);
        fillTableNoMembersGroup(grupoEdit);
        edtGrupo.setValue(nombreGrupo);

        selectedTableLeftClick();
        selectedTableRightClick();
        moveToRightTable();

        btnCerrar.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                close();

            }
        });
        btnGuardar.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {


                updateGrupo(grupoEdit);
                deleteContactoGrupo(grupoEdit);
                insertContactoGrupo(grupoEdit);
                MessageBox.createInfo()
                        .withCaption("Registro")
                        .withMessage("Grupo Actualizado")
                        .open();
               // close();

            }
        });

        setContent(mainLayout);
    }

    private void insertContactoGrupo(int grupoId){
        contactoGrupoService = new ContactoGrupoService();
        contactoGrupoService.insertContactoGrupo(listaContactoGrupo(grupoId));
    }

    private void deleteContactoGrupo(int grupoId){
        contactoGrupoService = new ContactoGrupoService();
        contactoGrupoService.deleteContactosGrupo(grupoId);

    }

    private void updateGrupo(int grupoId) {
        Grupo grupo = new Grupo();
        int numeroMiembros = tableLeft.size();

        grupo.setNombreGrupo(edtGrupo.getValue());
        grupo.setNumeroMiembros(numeroMiembros);
        grupo.setEstado("V");
        grupo.setGrupoId(grupoId);
        grupoService = new GrupoService();
        grupoService.updateGrupo(grupo);
    }

    private List<ContactoGrupo> listaContactoGrupo(int grupoId) {

        IndexedContainer container = (IndexedContainer) tableLeft.getContainerDataSource();

        List<ContactoGrupo> listContactoGrupo = new ArrayList<ContactoGrupo>();
        List<Contacto> listContacto = (List<Contacto>) container.getItemIds();

        for ( int i=0; i< listContacto.size(); i++) {
            ContactoGrupo contactoGrupo = new ContactoGrupo();
            Contacto contacto = listContacto.get(i);

            contactoGrupo.setContactoId(contacto.getContactoId());
            contactoGrupo.setGrupoId(grupoId);
            listContactoGrupo.add(contactoGrupo);
        }
        return listContactoGrupo;
    }


    private void moveToRightTable() {

        btnMoveRight.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                moveDataToRight();

            }
        });

        btnMoveAllRight.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                selectAllTableLeft();
                moveDataToRight();
            }
        });

        btnMoveLeft.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                moveDataToLeft();
            }
        });

        btnMoveAllLeft.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                selectAllTableRight();
                moveDataToLeft();
            }
        });

    }

    private void moveDataToRight() {
        if (itemsSelectedLeft.size()>0) {
            fillTableRight(itemsSelectedLeft);
            refreshTableLeft();
            itemsSelectedLeft.clear();
        }
    }

    private void moveDataToLeft() {
        if (itemsSelectedRight.size()>0) {
            moveDataTableLeft(itemsSelectedRight);
            refreshTableRight();
            itemsSelectedRight.clear();
        }
    }


    private void refreshTableLeft() {

        IndexedContainer lista  = (IndexedContainer) tableLeft.getContainerDataSource();
        //List<Contacto> con = (List<Contacto>)lista.getItemIds();
        List<Contacto> modif  =  new CopyOnWriteArrayList(lista.getItemIds());
        //	Iterator<Contacto> iter = modif.iterator();
        for(Contacto c : modif) {
            //while (iter.hasNext()) {
            //	Contacto delete = iter.next();

            for(Contacto i : itemsSelectedLeft) {
                //if(delete.getContactoId() == i.getContactoId()) {
                if (c.getContactoId() == i.getContactoId()){
                    tableLeft.removeItem(c);
                }
            }

        }

    }


    private void refreshTableRight() {

        IndexedContainer lista  = (IndexedContainer) tableRight.getContainerDataSource();
        //List<Contacto> con = (List<Contacto>)lista.getItemIds();
        List<Contacto> modif  =  new CopyOnWriteArrayList(lista.getItemIds());
        //	Iterator<Contacto> iter = modif.iterator();
        for(Contacto c : modif) {
            for(Contacto i : itemsSelectedRight) {
                //if(delete.getContactoId() == i.getContactoId()) {
                if (c.getContactoId() == i.getContactoId()){
                    tableRight.removeItem(c);
                }
            }

        }

    }


    private void selectAllTableLeft(){
        IndexedContainer container = (IndexedContainer) tableLeft.getContainerDataSource();
        List<Contacto> contactos = (List<Contacto>) container.getItemIds();
        itemsSelectedLeft.clear(); //Limpia si tiene datos
        for(Contacto contacto : contactos) {
            itemsSelectedLeft.add(contacto);
        }
    }

    private void selectAllTableRight(){
        IndexedContainer container = (IndexedContainer) tableRight.getContainerDataSource();
        List<Contacto> contactos = (List<Contacto>) container.getItemIds();
        itemsSelectedRight.clear(); //Limpia si tiene datos
        for(Contacto contacto : contactos) {
            itemsSelectedRight.add(contacto);
        }
    }

    private void selectedTableLeftClick () {

        tableLeft.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent event) {

                //Object value = event.getItem(); // event.getItem().getItemProperty("Celular").getValue();//tableLeft.getValue();
                Contacto value = new Contacto();
                value.setCelular(event.getItem().getItemProperty("Celular").getValue().toString());
                value.setNombreContacto(event.getItem().getItemProperty("Contacto").getValue().toString());
                value.setCampo1(event.getItem().getItemProperty("Campo1").getValue().toString());
                value.setCampo2(event.getItem().getItemProperty("Campo2").getValue().toString());
                value.setCampo3(event.getItem().getItemProperty("Campo3").getValue().toString());
                value.setContactoId((Integer) event.getItem().getItemProperty("ID").getValue());

                if (!searchContacto(value.getContactoId(),itemsSelectedLeft)) {
                    itemsSelectedLeft.add(value);
                }
            }
        });
    }

    private boolean searchContacto(int id, List<Contacto> contactos){

        for (Contacto contacto:contactos) {
            if (contacto.getContactoId()==id) {
                contactos.remove(contacto);
                return true;
            }
        }

        return false;
    }

    private void selectedTableRightClick () {

        tableRight.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent event) {
                Contacto value = new Contacto();
                value.setCelular(event.getItem().getItemProperty("Celular").getValue().toString());
                value.setNombreContacto(event.getItem().getItemProperty("Contacto").getValue().toString());
                value.setCampo1(event.getItem().getItemProperty("Campo1").getValue().toString());
                value.setCampo2(event.getItem().getItemProperty("Campo2").getValue().toString());
                value.setCampo3(event.getItem().getItemProperty("Campo3").getValue().toString());
                value.setContactoId((Integer) event.getItem().getItemProperty("ID").getValue());

                if (!searchContacto(value.getContactoId(),itemsSelectedRight)) {
                    itemsSelectedRight.add(value);
                }
            }
        });
    }



    private int numeroMiembros() {
        int i = tableRight.size();
        return i;
    }

    private void fillTableRight(List<Contacto> contactos) {
        IndexedContainer containerContactoAvailable;
        if (tableRight.size() ==0) {
            containerContactoAvailable = new IndexedContainer();
        } else {
            containerContactoAvailable = (IndexedContainer) tableRight.getContainerDataSource();
        }

        containerContactoAvailable.addContainerProperty("Celular", String.class, null);
        containerContactoAvailable.addContainerProperty("Contacto", String.class, null);
        containerContactoAvailable.addContainerProperty("Campo1", String.class, null);
        containerContactoAvailable.addContainerProperty("Campo2", String.class, null);
        containerContactoAvailable.addContainerProperty("Campo3", String.class, null);
        containerContactoAvailable.addContainerProperty("ID", Integer.class, null);

        for (Contacto contacto : contactos) {
            Item item = containerContactoAvailable.addItem(contacto);
            item.getItemProperty("Celular").setValue(contacto.getCelular());
            item.getItemProperty("Contacto").setValue(contacto.getNombreContacto());
            item.getItemProperty("Campo1").setValue(contacto.getCampo1());
            item.getItemProperty("Campo2").setValue(contacto.getCampo2());
            item.getItemProperty("Campo3").setValue(contacto.getCampo3());
            item.getItemProperty("ID").setValue(contacto.getContactoId());
        }

        tableRight.setContainerDataSource(containerContactoAvailable);

    }


    private void moveDataTableLeft(List<Contacto> contactos) {
        IndexedContainer containerContactoAsignado = (IndexedContainer) tableLeft.getContainerDataSource();


        containerContactoAsignado.addContainerProperty("Celular", String.class, null);
        containerContactoAsignado.addContainerProperty("Contacto", String.class, null);
        containerContactoAsignado.addContainerProperty("Campo1", String.class, null);
        containerContactoAsignado.addContainerProperty("Campo2", String.class, null);
        containerContactoAsignado.addContainerProperty("Campo3", String.class, null);
        containerContactoAsignado.addContainerProperty("ID", Integer.class, null);

        for (Contacto contacto : contactos) {
            Item item = containerContactoAsignado.addItem(contacto);
            item.getItemProperty("Celular").setValue(contacto.getCelular());
            item.getItemProperty("Contacto").setValue(contacto.getNombreContacto());
            item.getItemProperty("Campo1").setValue(contacto.getCampo1());
            item.getItemProperty("Campo2").setValue(contacto.getCampo2());
            item.getItemProperty("Campo3").setValue(contacto.getCampo3());
            item.getItemProperty("ID").setValue(contacto.getContactoId());
        }

        tableLeft.setContainerDataSource(containerContactoAsignado);

    }

    private void fillTableNoMembersGroup(int grupo) {
        List<Contacto> contactos;
        contactoService = new ContactoService();
        IndexedContainer containerNoContactoGroup = new IndexedContainer();

        containerNoContactoGroup.addContainerProperty("Celular", String.class, null);
        containerNoContactoGroup.addContainerProperty("Contacto", String.class, null);
        containerNoContactoGroup.addContainerProperty("Campo1", String.class,  null);
        containerNoContactoGroup.addContainerProperty("Campo2", String.class, null);
        containerNoContactoGroup.addContainerProperty("Campo3", String.class, null);
        containerNoContactoGroup.addContainerProperty("ID", Integer.class, null);

        contactos = contactoService.findAvailableContactoByGroup(grupo, fechaImportacion);

        if (contactos.size() > 0) {
            for (Contacto contacto : contactos) {
                Item item = containerNoContactoGroup.addItem(contacto);
                item.getItemProperty("Celular").setValue(contacto.getCelular());
                item.getItemProperty("Contacto").setValue(contacto.getNombreContacto());
                item.getItemProperty("Campo1").setValue(contacto.getCampo1());
                item.getItemProperty("Campo2").setValue(contacto.getCampo2());
                item.getItemProperty("Campo3").setValue(contacto.getCampo3());
                item.getItemProperty("ID").setValue(contacto.getContactoId());
            }

        }

        tableRight.setContainerDataSource(containerNoContactoGroup);

    }

    private void fillTableMembersGroup(int grupo) {
        List<Contacto> contactos;
        contactoService = new ContactoService();
        IndexedContainer containerContactoGroup = new IndexedContainer();

        containerContactoGroup.addContainerProperty("Celular", String.class, null);
        containerContactoGroup.addContainerProperty("Contacto", String.class, null);
        containerContactoGroup.addContainerProperty("Campo1", String.class,  null);
        containerContactoGroup.addContainerProperty("Campo2", String.class, null);
        containerContactoGroup.addContainerProperty("Campo3", String.class, null);
        containerContactoGroup.addContainerProperty("ID", Integer.class, null);

        contactos = contactoService.findAsignedContactoByGroup(grupo);

        if (contactos.size() > 0) {
            for (Contacto contacto : contactos) {
                Item item = containerContactoGroup.addItem(contacto);
                item.getItemProperty("Celular").setValue(contacto.getCelular());
                item.getItemProperty("Contacto").setValue(contacto.getNombreContacto());
                item.getItemProperty("Campo1").setValue(contacto.getCampo1());
                item.getItemProperty("Campo2").setValue(contacto.getCampo2());
                item.getItemProperty("Campo3").setValue(contacto.getCampo3());
                item.getItemProperty("ID").setValue(contacto.getContactoId());
                fechaImportacion = contacto.getFechaImportacion();
            }

        }

        tableLeft.setContainerDataSource(containerContactoGroup);

    }

    @AutoGenerated
    private AbsoluteLayout buildMainLayout() {
        // common part: create layout
        mainLayout = new AbsoluteLayout();
        mainLayout.setImmediate(false);
        mainLayout.setWidth("100%");
        mainLayout.setHeight("400px");

        // top-level component properties
        setWidth("100.0%");
        setHeight("400px");

        // horizontalLayout_1
        horizontalLayout_1 = buildHorizontalLayout_1();
        mainLayout.addComponent(horizontalLayout_1, "top:60.0px;right:-1.0px;left:20.0px;");

        verticalButton = buildVerticalLayout_1();
        mainLayout.addComponent(verticalButton,"top:70.0px;right:430.0px;left:400.0px;");

        // horizontalLayout_4
        horizontalLayout_4 = buildHorizontalLayout_4();
        mainLayout.addComponent(horizontalLayout_4, "top:360.0px;left:18.0px;");

        // label_1
        label_1 = new Label();
        label_1.setImmediate(false);
        label_1.setWidth("-1px");
        label_1.setHeight("-1px");
        label_1.setValue("Nombre de Grupo:");
        mainLayout.addComponent(label_1, "top:22.0px;left:20.0px;");

        // edtGrupo
        edtGrupo = new TextField();
        edtGrupo.setImmediate(false);
        edtGrupo.setWidth("433px");
        edtGrupo.setHeight("24px");
        mainLayout.addComponent(edtGrupo, "top:20.0px;left:123.0px;");

        //btnGuardarGrupo
//		btnGuardarGrupo = new NativeButton();
//		btnGuardarGrupo.setCaption("Guardar Grupo");
//		btnGuardarGrupo.setImmediate(true);
//		btnGuardarGrupo.setWidth("120px");
//		btnGuardarGrupo.setHeight("-1px");
//		mainLayout.addComponent(btnGuardarGrupo,"top:20.0px;left:473.0px;");

        return mainLayout;
    }

    @AutoGenerated
    private HorizontalLayout buildHorizontalLayout_1() {
        // common part: create layout
        horizontalLayout_1 = new HorizontalLayout();
        horizontalLayout_1.setImmediate(false);
        horizontalLayout_1.setWidth("100.0%");
        horizontalLayout_1.setHeight("260px");
        horizontalLayout_1.setMargin(false);

        // Table Left
        tableLeft = new Table();
        //Allow selection Items from  table
        tableLeft.setSelectable(true);
        //tableLeft.setSelectionMode(Grid.SelectionMode.MULTI);
        // Send changes in selection immediately to server.r
        tableLeft.setImmediate(true);
        tableLeft.setMultiSelect(true);
        //desable selected null value
        tableLeft.setMultiSelectMode(MultiSelectMode.SIMPLE);
        tableLeft.setNullSelectionAllowed(false);
        tableLeft.setCaption("Contactos Grupo");
        tableLeft.setWidth("370px");
        tableLeft.setHeight("250px");
        horizontalLayout_1.addComponent(tableLeft);

        // Table Right
        tableRight = new Table();
        //Allow selection Items from  table
        tableRight.setSelectable(true);
        // Send changes in selection immediately to server.r
        tableRight.setImmediate(true);
        tableRight.setMultiSelect(true);
        //desable selected null value
        tableRight.setMultiSelectMode(MultiSelectMode.SIMPLE);
        tableRight.setNullSelectionAllowed(false);
        tableRight.setCaption("Contactos Disponibles");
        tableRight.setWidth("370px");
        tableRight.setHeight("250px");;
        horizontalLayout_1.addComponent(tableRight);

        return horizontalLayout_1;
    }

    private VerticalLayout buildVerticalLayout_1 () {
        verticalButton = new VerticalLayout();
        verticalButton.setWidth("5%");
        // btnMoveRight
        btnMoveRight = new Button();
        btnMoveRight.setCaption(" > ");
        btnMoveRight.setImmediate(true);
        verticalButton.addComponent(btnMoveRight);

        // btnMoveAllRight
        btnMoveAllRight = new Button();
        btnMoveAllRight.setCaption(" >> ");
        btnMoveAllRight.setImmediate(true);
        verticalButton.addComponent(btnMoveAllRight);

        // btnMoveLeft
        btnMoveLeft = new Button();
        btnMoveLeft.setCaption(" < ");
        btnMoveLeft.setImmediate(true);
        verticalButton.addComponent(btnMoveLeft);

        // btnMoveAllLeft
        btnMoveAllLeft = new Button();
        btnMoveAllLeft.setCaption(" << ");
        btnMoveAllLeft.setImmediate(true);
        verticalButton.addComponent(btnMoveAllLeft);

        return  verticalButton;
    }

    @AutoGenerated
    private HorizontalLayout buildHorizontalLayout_4() {
        // common part: create layout
        horizontalLayout_4 = new HorizontalLayout();
        horizontalLayout_4.setImmediate(false);
        horizontalLayout_4.setWidth("560px");
        horizontalLayout_4.setHeight("40px");
        horizontalLayout_4.setMargin(false);

        // btnGuardar
        btnGuardar = new Button();
        btnGuardar.setCaption("Guardar");
        btnGuardar.setImmediate(true);
        btnGuardar.setWidth("80px");
        btnGuardar.setHeight("-1px");
        horizontalLayout_4.addComponent(btnGuardar);
        horizontalLayout_4.setComponentAlignment(btnGuardar, Alignment.MIDDLE_RIGHT);

        // btnCerrar
        btnCerrar = new Button();
        btnCerrar.setCaption("Cerrar");
        btnCerrar.setImmediate(true);
        btnCerrar.setWidth("80px");
        btnCerrar.setHeight("-1px");
        horizontalLayout_4.addComponent(btnCerrar);
        horizontalLayout_4.setComponentAlignment(btnCerrar, Alignment.MIDDLE_RIGHT);

        return horizontalLayout_4;
    }


}