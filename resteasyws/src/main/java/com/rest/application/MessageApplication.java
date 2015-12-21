package com.rest.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.rest.MessageService;
import com.rest.UploadFileService;
import com.rest.jettison.JettisonService;
import com.rest.json.JSONService;
import com.rest.xml.XMLService;

public class MessageApplication extends Application{
	private Set<Object> singletons = new HashSet<Object>();

	public MessageApplication() {
		singletons.add(new MessageService());
		singletons.add(new UploadFileService());
		singletons.add(new XMLService());
		singletons.add(new JSONService());
		singletons.add(new JettisonService());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
