package com.fpmislata.modelo;

import java.util.*;
import java.io.Serializable;


public class ColaMensajes extends LinkedList<Mensaje> implements Serializable {

	private static final long serialVersionUID = -2681008235066722777L;

	public final static int DEFAULT_SIZE = 20;

	int max_size;

	public ColaMensajes() {
		max_size = DEFAULT_SIZE;
	}

	public synchronized void addMessage(Mensaje msg) {
		addLast(msg);
		if(size() > max_size) {
			removeFirst();
		}
	}
}
