package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import logica.Bocina;
import logica.Chasis;
import logica.ComponenteOrdenador;
import logica.DiscoDuro;
import logica.Fuente;
import logica.MemoriaRam;
import logica.Microprocesador;
import logica.Monitor;
import logica.Mouse;
import logica.TarjetaDeVideo;
import logica.TarjetaMadre;
import logica.Teclado;
import logica.TiendaDeComputadoras;

public class InformacionProductos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel panelPrincipal = new JPanel();
	private JLabel lblComponente;
	private JLabel lblMarca;
	private JLabel lblModelo;
	private JLabel lblAtributo1;
	private JLabel lblAtributo2;
	private JLabel lblCantidadDisp;
	private JLabel txtComponente;
	private JLabel txtMarca;
	private JLabel txtModelo;
	private JLabel txtAtributo1;
	private JLabel txtAtributo2;
	private JLabel txtCantidad;
	private JLabel txtPrecio;
	private JLabel txtNoSerie;
	private JLabel lblPrecio;
	private JLabel lblNoSerie;
	private static ComponenteOrdenador c = null;

	public InformacionProductos(Principal p, TiendaDeComputadoras tienda, String noSerie) {
		super(p, true);
		setAutoRequestFocus(false);
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Información del producto");
		setBounds(100, 100, 421, 286);
		getContentPane().setLayout(new BorderLayout());
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);

		lblComponente = new JLabel("Componente:");
		lblComponente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblComponente.setBounds(10, 26, 128, 21);
		panelPrincipal.add(lblComponente);

		lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMarca.setBounds(10, 53, 128, 21);
		panelPrincipal.add(lblMarca);

		lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblModelo.setBounds(10, 80, 128, 21);
		panelPrincipal.add(lblModelo);

		lblAtributo1 = new JLabel("");
		lblAtributo1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAtributo1.setBounds(10, 107, 179, 21);
		panelPrincipal.add(lblAtributo1);

		lblAtributo2 = new JLabel("");
		lblAtributo2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAtributo2.setBounds(10, 134, 179, 21);
		panelPrincipal.add(lblAtributo2);

		lblCantidadDisp = new JLabel("Cantidad disponible:\r\n");
		lblCantidadDisp.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCantidadDisp.setBounds(10, 156, 179, 21);
		panelPrincipal.add(lblCantidadDisp);

		lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrecio.setBounds(10, 188, 128, 21);
		panelPrincipal.add(lblPrecio);

		lblNoSerie = new JLabel("No Serie:");
		lblNoSerie.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNoSerie.setBounds(10, 215, 128, 21);
		panelPrincipal.add(lblNoSerie);

		txtComponente = new JLabel("");
		txtComponente.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(30, 144, 255)));
		txtComponente.setHorizontalAlignment(SwingConstants.CENTER);
		txtComponente.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtComponente.setBounds(199, 24, 196, 21);
		panelPrincipal.add(txtComponente);

		txtMarca = new JLabel("");
		txtMarca.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(30, 144, 255)));
		txtMarca.setHorizontalAlignment(SwingConstants.CENTER);
		txtMarca.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMarca.setBounds(199, 53, 196, 21);
		panelPrincipal.add(txtMarca);

		txtModelo = new JLabel("");
		txtModelo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(30, 144, 255)));
		txtModelo.setHorizontalAlignment(SwingConstants.CENTER);
		txtModelo.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtModelo.setBounds(199, 80, 196, 21);
		panelPrincipal.add(txtModelo);

		txtAtributo1 = new JLabel("");
		txtAtributo1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(30, 144, 255)));
		txtAtributo1.setHorizontalAlignment(SwingConstants.CENTER);
		txtAtributo1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtAtributo1.setBounds(199, 107, 196, 21);
		panelPrincipal.add(txtAtributo1);

		txtAtributo2 = new JLabel("");
		txtAtributo2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(30, 144, 255)));
		txtAtributo2.setHorizontalAlignment(SwingConstants.CENTER);
		txtAtributo2.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtAtributo2.setBounds(199, 134, 196, 21);
		panelPrincipal.add(txtAtributo2);

		txtCantidad = new JLabel("");
		txtCantidad.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(30, 144, 255)));
		txtCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtCantidad.setBounds(199, 161, 196, 21);
		panelPrincipal.add(txtCantidad);

		txtPrecio = new JLabel("");
		txtPrecio.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(30, 144, 255)));
		txtPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPrecio.setBounds(199, 188, 196, 21);
		panelPrincipal.add(txtPrecio);

		txtNoSerie = new JLabel("");
		txtNoSerie.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(30, 144, 255)));
		txtNoSerie.setHorizontalAlignment(SwingConstants.CENTER);
		txtNoSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNoSerie.setBounds(199, 215, 196, 21);
		panelPrincipal.add(txtNoSerie);

		c = tienda.buscarComponente(noSerie);
		if(c != null) {
			mostrarInfo(c);
		}
	}

	public void mostrarInfo(ComponenteOrdenador c) {
		txtComponente.setText(c.getClass().getSimpleName());
		txtMarca.setText(c.getMarca());
		txtModelo.setText(c.getModelo());
		if(c instanceof Bocina) {
			organizarLabelsUnAtrib(c);
			lblAtributo1.setText("Conectividad:");
			txtAtributo1.setText(((Bocina) c).getConectividad());
		}
		else if(c instanceof Chasis) {
			organizarLabelsUnAtrib(c);
			lblAtributo1.setText("Material:");
			txtAtributo1.setText(((Chasis) c).getMaterial());
		}
		else if(c instanceof DiscoDuro) {
			organizarLabelsDosAtrib(c);
			lblAtributo1.setText("Tipo de Conexión:");
			txtAtributo1.setText(((DiscoDuro) c).getTipoDeConexion());
			lblAtributo2.setText("Capacidad:");
			txtAtributo2.setText(String.valueOf(((DiscoDuro) c).getCapacidad()));
		}
		else if(c instanceof Fuente) {
			organizarLabelsUnAtrib(c);
			lblAtributo1.setText("Eficiencia:");
			txtAtributo1.setText(((Fuente) c).getEficiencia());
		}
		else if(c instanceof Microprocesador) {
			organizarLabelsDosAtrib(c);
			lblAtributo1.setText("Tipo de Conexión:");
			txtAtributo1.setText(((Microprocesador) c).getTipoDeConexion());
			lblAtributo2.setText("Procesamiento:");
			txtAtributo2.setText(String.valueOf(((Microprocesador) c).getVelocidadDeProcesamiento()));
		}
		else if(c instanceof MemoriaRam) {
			organizarLabelsDosAtrib(c);
			lblAtributo1.setText("Tipo de Memoria:");
			txtAtributo1.setText(((MemoriaRam) c).getTipoDeMemoria());
			lblAtributo2.setText("Cantidad de GB:");
			txtAtributo2.setText(String.valueOf(((MemoriaRam) c).getCantEspacio()));
		}
		else if(c instanceof Monitor) {
			organizarLabelsUnAtrib(c);
			lblAtributo1.setText("Resolución:");
			txtAtributo1.setText(((Monitor) c).getResolucion());
		}
		else if(c instanceof Mouse) {
			organizarLabelsUnAtrib(c);
			lblAtributo1.setText("Conectividad:");
			txtAtributo1.setText(((Mouse) c).getConectividad());
		}	
		else if(c instanceof TarjetaMadre) {
			organizarLabelsUnAtrib(c);
			lblAtributo1.setText("Tipo de Conector:");
			txtAtributo1.setText(((TarjetaMadre) c).getTipoDeConector());
		}
		else if(c instanceof TarjetaDeVideo) {
			organizarLabelsUnAtrib(c);
			lblAtributo1.setText("Refrigeración:");
			txtAtributo1.setText(((TarjetaDeVideo) c).getRefrigeracion());
		}
		else if(c instanceof Teclado) {
			organizarLabelsUnAtrib(c);
			lblAtributo1.setText("Retroiluminación:");
			int j = ((Teclado) c).getRetroiluminacion();
			if(j == 0) 
				txtAtributo1.setText("No");
			else
				txtAtributo1.setText("Sí");
		}
	}

	private void organizarLabelsUnAtrib(ComponenteOrdenador c) {
		lblAtributo2.setVisible(false);
		txtAtributo2.setVisible(false);
		lblCantidadDisp.setBounds(10, 134, 179, 21); 
		txtCantidad.setBounds(199, 134, 196, 21);
		txtCantidad.setText(String.valueOf(c.getCantDisponible()));
		lblPrecio.setBounds(10, 161, 160, 21);  
		txtPrecio.setBounds(199, 161, 196, 21);
		txtPrecio.setText(String.format("%.2f", c.getPrecio()));
		lblNoSerie.setBounds(10, 188, 128, 21); 
		txtNoSerie.setBounds(199, 188, 196, 21);
		txtNoSerie.setText(c.getNumSerie());
	}

	private void organizarLabelsDosAtrib(ComponenteOrdenador c) {
		lblAtributo2.setBounds(10, 134, 128, 21); 
		lblAtributo2.setVisible(true);
		txtAtributo2.setBounds(199, 134, 196, 21);
		txtAtributo2.setVisible(true);
		lblCantidadDisp.setBounds(10, 161, 179, 21);                   
		txtCantidad.setBounds(199, 161, 196, 21);
		txtCantidad.setText(String.valueOf(c.getCantDisponible()));
		lblPrecio.setBounds(10, 188, 128, 21);                         
		txtPrecio.setBounds(199, 188, 196, 21);
		txtPrecio.setText(String.format("%.2f", c.getPrecio()));
		lblNoSerie.setBounds(10, 215, 128, 21);
		txtNoSerie.setBounds(199, 215, 196, 21);
		txtNoSerie.setText(c.getNumSerie());
	}

}
