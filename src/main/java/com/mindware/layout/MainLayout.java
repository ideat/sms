package com.mindware.layout;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.*;

public class MainLayout extends VerticalLayout{
	private VerticalLayout upperSection = new VerticalLayout();
	private HorizontalSplitPanel lowerSection = new	HorizontalSplitPanel();
	private VerticalLayout menuLayout = new VerticalLayout();
	private VerticalLayout contentLayout = new VerticalLayout();

	
	public MainLayout() {
		
		upperSection.addComponent(new Label("Header"));
		menuLayout.addComponent(new Label("Menu"));
		contentLayout.addComponent(new Label("Content"));
		lowerSection.addComponent(menuLayout);
		lowerSection.addComponent(contentLayout);
		addComponent(upperSection);
		addComponent(lowerSection);
		setSizeFull();
		lowerSection.setSizeFull();
		//menuLayout.setSizeFull();
		contentLayout.setSizeFull();
		
		showBorders();
		setExpandRatio(lowerSection, 1);
		lowerSection.setSplitPosition(20);

	}
	
		
	private void showBorders() {
		String style = "v-ddwrapper-over";
		setStyleName(style);
		upperSection.setStyleName(style);
		lowerSection.setStyleName(style);
		menuLayout.setStyleName(style);
		contentLayout.setStyleName(style);
	}
	
	public void addMenuOption(String caption, final Component component) {
		NativeButton button = new NativeButton(caption);
		button.setWidth("100%");
		button.setHeight("40px");
		//menuLayout.setSpacing(true);
		
		menuLayout.addComponent(button);
		button.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				contentLayout.removeAllComponents();
				contentLayout.addComponent(component);



			}
		});
	}
	
	public void callContentLayout(final Component component) {
		contentLayout.removeAllComponents();
		contentLayout.addComponent(component);
	}
		
	
}

