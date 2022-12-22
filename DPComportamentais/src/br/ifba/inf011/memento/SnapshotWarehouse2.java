package br.ifba.inf011.memento;

import java.util.HashMap;
import java.util.Map;

import br.ifba.inf011.AbstractControlador;
import br.ifba.inf011.Controlador;

public class SnapshotWarehouse2 {
	
	private Map<String, AbstractControlador.StateControlador> snapshots;
	private AbstractControlador controlador;
	
	public SnapshotWarehouse2(AbstractControlador controlador) {
		this.controlador = controlador;
		this.snapshots = new HashMap<String, AbstractControlador.StateControlador>();
	}
	
	public void save(String id) {
		this.snapshots.put(id, this.controlador.snapshot(id));
	}
	
	public void undo(String id) {
		AbstractControlador.StateControlador snapshot =  this.snapshots.get(id);
		this.controlador.restore(snapshot);
		
	}		

}
