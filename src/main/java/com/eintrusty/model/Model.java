package com.eintrusty.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;


public class Model {
	
	private String id;

	public Model(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	 public static Comparator<Model> idComparator = new Comparator<Model>() {

		    @Override
			public int compare(Model m1, Model m2) {
		    	String model1 = m1.getId();
		    	String model2 = m1.getId();
			   //ascending order
			   return model1.compareTo(model2);

			   //descending order
			   //return model2.compareTo(model1);
		    }};

}
