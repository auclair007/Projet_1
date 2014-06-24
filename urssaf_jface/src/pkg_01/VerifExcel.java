package pkg_01;

import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class VerifExcel extends ApplicationWindow {
	private static String[] args1;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;

	/**
	 * Create the application window.
	 */
	public VerifExcel() {
		super(null);
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
	}

	/**
	 * Create contents of the application window.
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		
		text_1 = new Text(container, SWT.BORDER | SWT.READ_ONLY);
		text_1.setBounds(166, 10, 263, 21);
		text_1.setText(args1[1]);
		
		text_2 = new Text(container, SWT.BORDER);
		text_2.setBounds(166, 37, 263, 21);
		text_2.setText(args1[2]);
		
		text_3 = new Text(container, SWT.BORDER);
		text_3.setBounds(166, 64, 76, 21);
		text_3.setText(args1[13]);
		
		text_4 = new Text(container, SWT.BORDER | SWT.READ_ONLY);
		text_4.setBounds(166, 91, 76, 21);
		text_4.setText(args1[14]);
		
		Label lblFichierExcelTraite = new Label(container, SWT.NONE);
		lblFichierExcelTraite.setBounds(10, 13, 150, 15);
		lblFichierExcelTraite.setText("Fichier Excel trait\u00E9");
		
		Label lblFichierXrt = new Label(container, SWT.NONE);
		lblFichierXrt.setText("Fichier XRT");
		lblFichierXrt.setBounds(10, 40, 150, 15);
		
		Label lblYyyytm = new Label(container, SWT.NONE);
		lblYyyytm.setText("YYYYTM");
		lblYyyytm.setBounds(10, 67, 150, 15);
		
		Label lblTotaleuro = new Label(container, SWT.NONE);
		lblTotaleuro.setText("Total (Euro)");
		lblTotaleuro.setBounds(10, 94, 150, 15);
		
		Button btnCreerLeFichierXRT = new Button(container, SWT.NONE);
		btnCreerLeFichierXRT.setBounds(166, 118, 112, 25);
		btnCreerLeFichierXRT.setText("Cr\u00E9er le fichier XRT");
		btnCreerLeFichierXRT.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Click btnCreerLeFichierXRT");
			}
		});

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
			for ( int ii = 0 ; ii < args.length ; ii++){
				System.out.println(ii + " --> " + args[ii]);
			}
			args1 = args.clone();
			VerifExcel window = new VerifExcel();
			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
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
		newShell.setText("Vérification du fichier Excel");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(471, 302);
	}
}
