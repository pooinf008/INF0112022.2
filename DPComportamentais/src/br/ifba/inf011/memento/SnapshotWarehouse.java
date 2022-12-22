package br.ifba.inf011.memento;

import java.util.HashMap;
import java.util.Map;

import br.ifba.inf011.AbstractControlador;

public class SnapshotWarehouse {
	
	private Map<String, Memento> snapshots;
	private AbstractControlador controlador;
	
	public SnapshotWarehouse(AbstractControlador controlador) {
		this.controlador = controlador;
		this.snapshots = new HashMap<String, Memento>();
	}
	
	public void save(String id) {
		Memento memento = this.controlador.memento(id);
		this.snapshots.put(id, memento);
	}
	
	public void undo(String id) {
		Memento snapshot =  this.snapshots.get(id); 
		this.controlador.restore(snapshot);
		
	}		

}
