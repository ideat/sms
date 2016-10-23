package com.mindware.vista;

import au.com.bytecode.opencsv.CSVReader;
import com.csvreader.CsvReader;
import com.mindware.domain.Contacto;
import com.mindware.services.ContactoService;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.Page;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Upload.FinishedEvent;
import de.steinwedel.messagebox.MessageBox;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

//import com.mindware.utiles.ImportarCSV;

@SuppressWarnings("serial")
public class CargarArchivo extends Window  {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Table tblCSV;
	@AutoGenerated
	private Panel panelCSV;
	@AutoGenerated
	private VerticalLayout verticalLayout_1;
	@AutoGenerated
	private TextField txtSeparador;
	
	private NativeButton btnInsertar;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	
	private Upload upload;
    private File tempFile;
	private  static ContactoService contactoService;
    //private IndexedContainer indexedContainer;
	@SuppressWarnings("deprecation")
	public CargarArchivo() {
		buildMainLayout();

		//setCompositionRoot(mainLayout);
		
	/*	ImportarCSV receiver = new ImportarCSV();
		Upload upload = new Upload("",receiver);
		upload.addSucceededListener(receiver);
		upload.setReceiver(receiver);*/
		//mainLayout.addComponent(upload);
		
		setContent(mainLayout);

	}
	
	
	private void InsertarDatos() {
		btnInsertar.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				contactoService = new ContactoService();
				ArrayList <Contacto> listaContactos= new ArrayList <Contacto> ();
                Container container = tblCSV.getContainerDataSource();
                //Iterator<?> iterator = container.getItemIds().iterator();
				Collection<?> itemIDS= container.getItemIds();
				String[] columHeader = tblCSV.getColumnHeaders();

					if (columHeader.length>5) {
						Notification notif = new Notification(
								"Cuidado",
								"Numero de columnas excede lo permitido, se importaran las 5 primeras",
								Notification.TYPE_WARNING_MESSAGE);
						notif.setDelayMsec(20000);
						notif.show(Page.getCurrent());
					}
					for (Object itemID : itemIDS) {
						Contacto contacto = new Contacto();
						for (int i = 0; i < columHeader.length; i++) {
							Property property = container.getContainerProperty(itemID, columHeader[i]);
							Object data = property.getValue();
							switch (i) {
								case 0:
									contacto.setCelular(data.toString());
									break;
								case 1:
									contacto.setNombreContacto(data.toString());
									break;
								case 2:
									contacto.setCampo1(data.toString());
									break;
								case 3:
									contacto.setCampo2(data.toString());
									break;
								case 4:
									contacto.setCampo3(data.toString());
									break;
								default:
									break;
							}

						}
						contacto.setEstado("ACTIVO");
						contacto.setUsuarioId(1); //TODO cambiar por el usuario de logeo
						java.util.Date fecha = new Date();
						contacto.setFechaImportacion(fecha);
						listaContactos.add(contacto);

						//contactoService.insertarContacto(contacto);
					}
					try {
						contactoService.insertarContactos(listaContactos);

						MessageBox.createInfo()
								.withCaption("Registro")
								.withMessage("Datos importados con exito!")
								.open();

					} catch (Exception e) {
						MessageBox.createError()
								.withCaption("Error")
								.withMessage("Error al importar datos, revise origen ")
								.withAbortButton()
								.open();
					}

			}
		});
	}
	
	private void CrearColumnas (){
		String[] cabecera = {"Nombre","Celular","Campo1", "Campo2", "Campo3", "Campo4", "Campo5","Campo6"};
		try {
			CsvReader file = new CsvReader(tempFile.getAbsolutePath());
			file.setDelimiter(txtSeparador.getValue().charAt(0));
			file.readHeaders();
			int nroCol = file.getHeaderCount();
			//Crea cabeceras
			for (int i = 0; i < nroCol; i++) {
				//tblCSV.addContainerProperty(cabecera[i],String.class,null);
				//tblCSV.addColumn(cabecera[i], String.class);
				
			}
			
			//mostrarCSV(file);
			setContent(tblCSV);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	public Integer NumeroColumnasCSV(char separador) {
		
		try {
			CsvReader file = new CsvReader(tempFile.getAbsolutePath(),separador);
			file.readHeaders();
			//Integer i = file.getColumnCount();
			Integer i = file.getHeaderCount();
			return i;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
		
		// panelCSV
		panelCSV = buildPanelCSV();
		mainLayout.addComponent(panelCSV, "top:20.0px;left:20.0px;");
		
		// tblCSV
		tblCSV = new Table();
		tblCSV.setImmediate(false);
		tblCSV.setWidth("100.0%");
		tblCSV.setHeight("258px");
		mainLayout.addComponent(tblCSV, "top:200.0px;right:4.0px;left:20.0px;");
		

		btnInsertar = new NativeButton();
		btnInsertar.setCaption("Cargar Datos");
		InsertarDatos();
		
		mainLayout.addComponent(btnInsertar, "top:470.0px;right:4.0px;left:20.0px;");
		
		return mainLayout;
	}

	@AutoGenerated
	private Panel buildPanelCSV() {
		// common part: create layout
		panelCSV = new Panel();
		panelCSV.setCaption("Cargar archivo CSV");
		panelCSV.setImmediate(false);
		panelCSV.setWidth("540px");
		panelCSV.setHeight("140px");
		
		// verticalLayout_1
		verticalLayout_1 = buildVerticalLayout_1();
		panelCSV.setContent(verticalLayout_1);
		
		return panelCSV;
	}

	@SuppressWarnings("deprecation")
	@AutoGenerated
	private VerticalLayout buildVerticalLayout_1() {
		// common part: create layout
		verticalLayout_1 = new VerticalLayout();
		verticalLayout_1.setImmediate(false);
		verticalLayout_1.setWidth("99.24%");
		verticalLayout_1.setHeight("100.32%");
		verticalLayout_1.setMargin(false);
		
		// txtSeparador
		txtSeparador = new TextField();
		txtSeparador.setCaption("Separador");
		txtSeparador.setImmediate(false);
		txtSeparador.setWidth("59px");
		txtSeparador.setHeight("-1px");
		verticalLayout_1.addComponent(txtSeparador);
		

		Upload upload = new Upload("Cargar archivo", new Upload.Receiver() {
		@Override
		public OutputStream receiveUpload(String filename, String mimeType) {
			// TODO Auto-generated method stub
			try {
	            //tempFile = File.createTempFile(filename, "csv");
	            tempFile = new File(System.getProperty("java.io.tmpdir") , filename);
	            //tempFile.deleteOnExit();
	            return new FileOutputStream(tempFile);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return null;
		}
		});
		    
		upload.addFinishedListener(new Upload.FinishedListener() {
			
			@Override
			public void uploadFinished(FinishedEvent event) {
				try {
			          /* Let's build a container from the CSV File */
			          FileReader reader = new FileReader(tempFile);
			        
			          IndexedContainer indexedContainer = buildContainerFromCSV(reader);
			          reader.close();
			          tempFile.delete();
	
			          /* Finally, let's update the table with the container */
			          tblCSV.setCaption(event.getFilename());
			          tblCSV.setContainerDataSource(indexedContainer);
			          tblCSV.setVisible(true);
			        } catch (IOException e) {
			          e.printStackTrace();
			        }
				
			}
		});
		
		
		verticalLayout_1.addComponent(upload);
				
		return verticalLayout_1;
	}



	

	protected IndexedContainer buildContainerFromCSV(Reader reader) throws IOException {
		    IndexedContainer container = new IndexedContainer();
		    CSVReader csvReader = new CSVReader(reader,txtSeparador.getValue().charAt(0));
		    
		    String[] columnHeaders = null;
		    String[] record;
			while ((record = csvReader.readNext()) != null) {
		      if (columnHeaders == null) {
		        columnHeaders = record;
		        addItemProperties(container, columnHeaders);
		      } else {
		        addItem(container, columnHeaders, record);
		      }
		    }
		    return container;
	}
	
	private static void addItemProperties(IndexedContainer container, String[] columnHeaders) {
	    for (String propertyName : columnHeaders) {
	      container.addContainerProperty(propertyName, String.class, null);
	    }
	  }
	
	private static void addItem(IndexedContainer container, String[] propertyIds, String[] fields) {
	    if (propertyIds.length != fields.length) {
	      throw new IllegalArgumentException("Diferente numero de columnas y campos del registro");
	    }
	    Object itemId = container.addItem();
	    Item item = container.getItem(itemId);
	    for (int i = 0; i < fields.length; i++) {
	      String propertyId = propertyIds[i];
	      String field = fields[i];
	      item.getItemProperty(propertyId).setValue(field);
	    }
	  }
	
	

	

}
