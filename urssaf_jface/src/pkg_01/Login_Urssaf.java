package pkg_01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.InputStream;
import java.util.Properties;

import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

import paUtils.ConnPostgres;

public class Login_Urssaf extends ApplicationWindow {
	private static Login_Urssaf w1;
	private Text text;
	private Text text_1;

	/**
	 * Create the application window.
	 */
	public Login_Urssaf() {
		super(null);
		setShellStyle(SWT.DIALOG_TRIM | SWT.MIN);
		createActions();
	}

	/**
	 * Create contents of the application window.
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		
			Button btnLogin = new Button(container, SWT.NONE);
			btnLogin.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					System.out.println("Click Login");
					String username=text.getText();
					String password=text_1.getText() ;
//
			    	Properties p = new Properties();
			    	String fini="c:/jardiland/urssaf/urssaf.cfg";

					try {
						p.load(new FileInputStream (fini));
					} catch (FileNotFoundException e1) {
							e1.printStackTrace();
					} catch ( IOException e1) {
						e1.printStackTrace();
					}

					String[] args1 = new String[13];
					args1[0] = fini;
					args1[1] = p.getProperty("fichier_excel");
					args1[2] = p.getProperty("fichier_xrt");
					args1[3] = p.getProperty("onglet");
					args1[4] = p.getProperty("premiere_ligne");
					args1[5] = p.getProperty("derniere_ligne");
					args1[6] = p.getProperty("colonne_magasin");
					args1[7] = p.getProperty("colonne_montant");
					args1[8] = p.getProperty("colonne_yyyytm");
					args1[9] = p.getProperty("colonne_tiers");
					args1[10] = p.getProperty("colonne_ref1");
					args1[11] = p.getProperty("colonne_ref2");
					args1[12] = p.getProperty("url_bdd");
					
//					InputStream fileConfig = ParamUrssaf.class.getResourceAsStream("urssaf.cfg");
// pour créer le fichier par défaut s'il n'existe pas					
					
			   		String[] args = {
			   				args1[12],
			   				username,password 
			   				};
					if ( ConnPostgres.check_conn(args) == 0 ){
						System.out.println("Ouverture de ParamUrssaf");
						w1.close();
				        

						ParamUrssaf.main(args1);
					};
				}
			});
			btnLogin.setBounds(109, 95, 75, 25);
			btnLogin.setText("Login");
		
			text = new Text(container, SWT.BORDER);
			text.setBounds(88, 29, 120, 21);
		
			text_1 = new Text(container, SWT.BORDER | SWT.PASSWORD);
			text_1.setBounds(88, 56, 120, 21);

		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

		

	/**
	 * Create the status line manager.
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			w1 = new Login_Urssaf();
			w1.setBlockOnOpen(true);
			w1.open();
			//Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Configure the shell.
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Login URSSAF");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(299, 211);
	}

}
