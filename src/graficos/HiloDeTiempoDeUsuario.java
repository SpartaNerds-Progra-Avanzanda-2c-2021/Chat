package graficos;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;

public class HiloDeTiempoDeUsuario extends Thread{
	private JLabel tiempoConectadoLabel;
	private Date conectadoDesde;
	
	public HiloDeTiempoDeUsuario(JLabel tiempoConectadoLabel, Date conectadoDesde) {
		super();
		this.tiempoConectadoLabel = tiempoConectadoLabel;
		this.conectadoDesde = conectadoDesde;
	}

	public void run() {
		while (true) {
		    long diffInMillies = Math.abs(this.conectadoDesde.getTime() - (new Date()).getTime());
		    long diff = TimeUnit.SECONDS.convert(diffInMillies,TimeUnit.MILLISECONDS);
			
			String mensaje = "Desde: "+String.valueOf(diff)+" sec";
			tiempoConectadoLabel.setText(mensaje);
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
