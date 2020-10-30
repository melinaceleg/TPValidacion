package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.BoxLayout;
import java.awt.Component;

import javax.swing.border.TitledBorder;

import excepciones.JuegoFinalizadoException;
import excepciones.NumeroInvalidoException;
import negocio.Monitor;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Dimension;

/**
 * <b>Invariante de clase:</b> el monitor no puede ser null. 
 * 
 */

public class Ventana extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panelCentro;
	private JPanel panelNorte;
	private JPanel panelNorte_Izq;
	private JPanel panelNorte_Centro;
	private JPanel panelSur;
	private JPanel panelSur_Izq;
	private JPanel panelSur_Centro;
	private JPanel panelSur_Der;
	private JPanel panelSur_CentroSup;
	private JButton btnJuegoNuevo;
	private JPanel panelSur_CentroInf;
	private JPanel panelNorte_Der;
	private JPanel panelNorte_IzqSup;
	private JLabel lblNewLabel;
	private JPanel panelNorte_IzqInf;
	private JPanel panelNorte_IzqCentro;
	private JPanel panelNorte_CentroSup;
	private JPanel panelNorte_CentroCentro;
	private JPanel panelNorte_CentroInf;
	private JTextField textField_NumIntentos;
	private JPanel panelNorte_DerSup;
	private JPanel panelNorte_DerCentro;
	private JPanel panelNorte_DerInf;
	private JButton btnProbar;
	private JPanel panelCentro_Izq;
	private JPanel panelCentro_Centro;
	private JPanel panelCentro_Der;
	private JPanel panelCentro_Sup;
	private JPanel panelCentro_Inf;
	private JTextPane txtpnEstado;
	private JTextPane textpnIntentos;
	private Monitor monitor = new Monitor();

	/**
	 * Ejecuta la aplicación.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la ventana.
	 */
	public Ventana() {
		setTitle("Juego para adivinar un n\u00FAmero");
		setMinimumSize(new Dimension(350, 350));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelNorte = new JPanel();
		contentPane.add(panelNorte);
		panelNorte.setLayout(new BoxLayout(panelNorte, BoxLayout.X_AXIS));
		
		panelNorte_Izq = new JPanel();
		panelNorte.add(panelNorte_Izq);
		panelNorte_Izq.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelNorte_IzqSup = new JPanel();
		panelNorte_Izq.add(panelNorte_IzqSup);
		panelNorte_IzqSup.setLayout(new GridLayout(1, 0, 0, 0));
		
		panelNorte_IzqCentro = new JPanel();
		panelNorte_Izq.add(panelNorte_IzqCentro);
		
		lblNewLabel = new JLabel("Ingrese n\u00FAmero");
		panelNorte_IzqCentro.add(lblNewLabel);
		
		panelNorte_IzqInf = new JPanel();
		panelNorte_Izq.add(panelNorte_IzqInf);
		
		panelNorte_Centro = new JPanel();
		panelNorte.add(panelNorte_Centro);
		panelNorte_Centro.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelNorte_CentroSup = new JPanel();
		panelNorte_Centro.add(panelNorte_CentroSup);
		panelNorte_CentroSup.setLayout(new GridLayout(1, 0, 0, 0));
		
		panelNorte_CentroCentro = new JPanel();
		panelNorte_Centro.add(panelNorte_CentroCentro);
		panelNorte_CentroCentro.setLayout(new GridLayout(1, 0, 0, 0));
		
		textField_NumIntentos = new JTextField();
		panelNorte_CentroCentro.add(textField_NumIntentos);
		textField_NumIntentos.setColumns(2);
		textField_NumIntentos.setEnabled(false);
		
		panelNorte_CentroInf = new JPanel();
		panelNorte_Centro.add(panelNorte_CentroInf);
		panelNorte_CentroInf.setLayout(new GridLayout(1, 0, 0, 0));
		
		panelNorte_Der = new JPanel();
		panelNorte.add(panelNorte_Der);
		panelNorte_Der.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelNorte_DerSup = new JPanel();
		panelNorte_Der.add(panelNorte_DerSup);
		panelNorte_DerSup.setLayout(new GridLayout(1, 0, 0, 0));
		
		panelNorte_DerCentro = new JPanel();
		panelNorte_Der.add(panelNorte_DerCentro);
		
		btnProbar = new JButton("Probar");
		btnProbar.addActionListener(this);
		panelNorte_DerCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnProbar.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelNorte_DerCentro.add(btnProbar);
		btnProbar.setEnabled(false);
		
		panelNorte_DerInf = new JPanel();
		panelNorte_Der.add(panelNorte_DerInf);
		panelNorte_DerInf.setLayout(new GridLayout(1, 0, 0, 0));
		
		this.panelCentro = new JPanel();
		this.contentPane.add(this.panelCentro);
		panelCentro.setLayout(new GridLayout(1, 0, 0, 0));
		
		panelCentro_Izq = new JPanel();
		panelCentro.add(panelCentro_Izq);
		
		panelCentro_Centro = new JPanel();
		panelCentro.add(panelCentro_Centro);
		panelCentro_Centro.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelCentro_Sup = new JPanel();
		panelCentro_Centro.add(panelCentro_Sup);
		panelCentro_Sup.setLayout(new GridLayout(1, 0, 0, 0));
		
		txtpnEstado = new JTextPane();
		txtpnEstado.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Estado", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCentro_Sup.add(txtpnEstado);
		txtpnEstado.setEnabled(false);
		
		panelCentro_Inf = new JPanel();
		panelCentro_Centro.add(panelCentro_Inf);
		panelCentro_Inf.setLayout(new GridLayout(1, 0, 0, 0));
		
		textpnIntentos = new JTextPane();
		textpnIntentos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Intentos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCentro_Inf.add(textpnIntentos);
		textpnIntentos.setEnabled(false);
		
		panelCentro_Der = new JPanel();
		panelCentro.add(panelCentro_Der);
		
		panelSur = new JPanel();
		contentPane.add(panelSur);
		panelSur.setLayout(new GridLayout(1, 0, 0, 0));
		
		panelSur_Izq = new JPanel();
		panelSur.add(panelSur_Izq);
		panelSur_Izq.setLayout(new GridLayout(1, 0, 0, 0));
		
		panelSur_Centro = new JPanel();
		panelSur.add(panelSur_Centro);
		panelSur_Centro.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelSur_CentroSup = new JPanel();
		panelSur_Centro.add(panelSur_CentroSup);
		panelSur_CentroSup.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnJuegoNuevo = new JButton("Juego nuevo");
		btnJuegoNuevo.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnJuegoNuevo.addActionListener(this);
		panelSur_Centro.add(btnJuegoNuevo);
		
		panelSur_CentroInf = new JPanel();
		panelSur_Centro.add(panelSur_CentroInf);
		
		panelSur_Der = new JPanel();
		panelSur.add(panelSur_Der);
		panelSur_Der.setLayout(new GridLayout(1, 0, 0, 0));
	}
	
	/**
	 * Método que recibe un evento determinado y de acuerdo al mismo ejecuta su correspondiente método. 
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Juego nuevo"))
            this.inicializarJuego();
        else
            this.probarNumero();
	}
	
	/**
	 * Método que notifica al monitor el número ingresado. Informa en la interfaz si el número es válido o si el juego finalizó.<br>
	 *
	 * <b>POST:</b> Si el juego finalizó, inhabilita los botones.
	 */
	private void probarNumero() {
		verificarInvariantes();
        try {
            monitor.probarNumero(Integer.parseInt(this.textField_NumIntentos.getText()));
            this.mostrarEstado();
            this.mostrarIntentos();
        } catch (NumeroInvalidoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (JuegoFinalizadoException e) {
        	btnProbar.setEnabled(false);
            textField_NumIntentos.setEnabled(false);
            txtpnEstado.setEnabled(false);
            textpnIntentos.setEnabled(false);
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un n\u00FAmero");
        }
        this.textField_NumIntentos.setText("");
        verificarInvariantes();
		
	}
	
	/**
	 * Método que le pide al monitor la inicialización de un nuevo juego.<br>
	 * 
	 * <b>POST:</b> Se habilitan los botones para poder jugar.
	 */
	private void inicializarJuego() {
		verificarInvariantes();
        monitor.inicializarJuego();
        this.mostrarEstado();
        this.mostrarIntentos();
        btnProbar.setEnabled(true);
        textField_NumIntentos.setEnabled(true);
        txtpnEstado.setEnabled(true);
        textpnIntentos.setEnabled(true);
        verificarInvariantes();
	}
	
	/**
	 * Método que trae el número de intentos realizados desde el monitor y lo muestra en la interfaz.
	 */
	private void mostrarIntentos() {
		verificarInvariantes();
        this.textpnIntentos.setText(monitor.traerIntentos().toString());
        verificarInvariantes();
	}
	
	/**
	 * Método que trae el estado desde el monitor y lo muestra en la interfaz.
	 */
	private void mostrarEstado() {
		verificarInvariantes();
        this.txtpnEstado.setText(monitor.traerEstado());
        verificarInvariantes();
		
	}
	/**
	 * Método que verifica las invariantes de clase.
	 * 
	 */
	private void verificarInvariantes() {
		assert monitor != null : "El monitor no existe";
	}

}