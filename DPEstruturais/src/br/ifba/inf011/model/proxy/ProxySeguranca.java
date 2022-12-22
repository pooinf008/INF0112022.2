package br.ifba.inf011.model.proxy;

import java.util.Collection;
import java.util.Set;

import br.ifba.inf011.model.AmbienteNTermometros;
import br.ifba.inf011.model.DataSource;

public class ProxySeguranca implements AmbienteNTermometros{
	
	private String user;
	private String pwd;
	private AmbienteNTermometros ambiente;
	
	public ProxySeguranca(String user, String pwd) {
		this.setCredentials(user, pwd);
		this.ambiente = DataSource.getAmbiente02(27);
	}
	
	public void setCredentials(String user, String pwd) {
		this.user = user;
		this.pwd = pwd;
	}

	@Override
	public double getTemperatura(String id) {
		if(!this.user.equalsIgnoreCase("root") ||
		   !this.pwd.equalsIgnoreCase("sysadmin"))
			return -1;
		return this.ambiente.getTemperatura(id);
	}

	@Override
	public Set<String> getIds() {
		return this.ambiente.getIds();
	}
	
	

}
