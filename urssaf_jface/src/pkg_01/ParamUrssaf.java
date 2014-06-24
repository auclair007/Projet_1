package pkg_01;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

import paUtils.Fileini;

public class ParamUrssaf extends ApplicationWindow {
	private static ParamUrssaf w1;
	private Text text_0;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	private static String[] args1;

	/**
	 * Create the application window.
	 */
	public ParamUrssaf() {
		super(null);
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
		System.out.println("public ParamUrssaf()");
	}

	/**
	 * Create contents of the application window.
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		
		text_0 = new Text(container, SWT.BORDER);
		text_0.setBounds(161, 10, 263, 21);
		text_0.setText(args1[1]);
		
		text_1 = new Text(container, SWT.BORDER);
		text_1.setBounds(161, 37, 263, 21);
		text_1.setText(args1[2]);
		
		text_2 = new Text(container, SWT.BORDER);
		text_2.setBounds(161, 64, 76, 21);
		text_2.setText(args1[3]);
		
		text_3 = new Text(container, SWT.BORDER);
		text_3.setBounds(161, 91, 76, 21);
		text_3.setText(args1[4]);

		text_4 = new Text(container, SWT.BORDER);
		text_4.setBounds(161, 118, 76, 21);
		text_4.setText(args1[5]);

		text_5 = new Text(container, SWT.BORDER);
		text_5.setBounds(161, 145, 76, 21);
		text_5.setText(args1[6]);

		text_6 = new Text(container, SWT.BORDER);
		text_6.setBounds(161, 172, 76, 21);
		text_6.setText(args1[7]);

		text_7 = new Text(container, SWT.BORDER);
		text_7.setBounds(161, 199, 76, 21);
		text_7.setText(args1[8]);

		text_8 = new Text(container, SWT.BORDER);
		text_8.setBounds(161, 226, 76, 21);
		text_8.setText(args1[9]);

		text_9 = new Text(container, SWT.BORDER);
		text_9.setBounds(161, 253, 76, 21);
		text_9.setText(args1[10]);

		text_10 = new Text(container, SWT.BORDER);
		text_10.setBounds(161, 280, 76, 21);
		text_10.setText(args1[11]);
		
		Label lblFichierExcel = new Label(container, SWT.NONE);
		lblFichierExcel.setBounds(24, 13, 117, 15);
		lblFichierExcel.setText("Fichier Excel \u00E0 traiter");
		
		Label lblFichierXrt = new Label(container, SWT.NONE);
		lblFichierXrt.setText("Fichier XRT");
		lblFichierXrt.setBounds(24, 40, 117, 15);
		
		Label lblNomDeLonglet = new Label(container, SWT.NONE);
		lblNomDeLonglet.setText("Nom de l'onglet");
		lblNomDeLonglet.setBounds(24, 67, 117, 15);
		
		Label lblPremireLigne = new Label(container, SWT.NONE);
		lblPremireLigne.setText("Premi\u00E8re ligne \u00E0 traiter");
		lblPremireLigne.setBounds(24, 94, 131, 15);
		
		Label lblDernireLigne = new Label(container, SWT.NONE);
		lblDernireLigne.setText("Derni\u00E8re ligne \u00E0 traiter");
		lblDernireLigne.setBounds(24, 121, 131, 15);
		
		Label lblColonneMagasin = new Label(container, SWT.NONE);
		lblColonneMagasin.setText("Colonne magasin");
		lblColonneMagasin.setBounds(24, 148, 131, 15);
		
		Label lblColonneMontant = new Label(container, SWT.NONE);
		lblColonneMontant.setText("Colonne montant");
		lblColonneMontant.setBounds(24, 175, 131, 15);
		
		Label lblColonneYyyytm = new Label(container, SWT.NONE);
		lblColonneYyyytm.setText("Colonne yyyytm");
		lblColonneYyyytm.setBounds(24, 202, 131, 15);
		
		Label lblColonneTiers = new Label(container, SWT.NONE);
		lblColonneTiers.setText("Colonne tiers");
		lblColonneTiers.setBounds(24, 229, 131, 15);
		
		Label lblColonneRef1 = new Label(container, SWT.NONE);
		lblColonneRef1.setText("Colonne Ref1");
		lblColonneRef1.setBounds(24, 256, 131, 15);
		
		Label lblColonneRef2 = new Label(container, SWT.NONE);
		lblColonneRef2.setText("Colonne Ref2");
		lblColonneRef2.setBounds(24, 283, 131, 15);
		
		Label lbl3 = new Label(container, SWT.NONE);
		lbl3.setText("3");
		lbl3.setBounds(243, 94, 117, 15);
		
		Label lbl105 = new Label(container, SWT.NONE);
		lbl105.setText("105");
		lbl105.setBounds(243, 121, 117, 15);
		
		Label lblNomDuMagasin = new Label(container, SWT.NONE);
		lblNomDuMagasin.setText("Nom du magasin");
		lblNomDuMagasin.setBounds(243, 148, 117, 15);
		
		Label lblEuros = new Label(container, SWT.NONE);
		lblEuros.setText("Euros");
		lblEuros.setBounds(243, 175, 117, 15);
		
		Label lblTo = new Label(container, SWT.NONE);
		lblTo.setText("201411 to 201443");
		lblTo.setBounds(243, 202, 117, 15);
		
		Label lblUrssaf = new Label(container, SWT.NONE);
		lblUrssaf.setText("URSSAF");
		lblUrssaf.setBounds(243, 229, 117, 15);
		
		Label lblRef1 = new Label(container, SWT.NONE);
		lblRef1.setText("99S1");
		lblRef1.setBounds(243, 256, 117, 15);
		
		Label lblRef2 = new Label(container, SWT.NONE);
		lblRef2.setText("1234567890123");
		lblRef2.setBounds(243, 283, 117, 15);
		
		Button btnSauvegarder = new Button(container, SWT.NONE);
		btnSauvegarder.setBounds(24, 320, 75, 25);
		btnSauvegarder.setText("Sauvegarder");
		btnSauvegarder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Click Sauvegarder");
				args1[1]=text_0.getText();
				args1[2]=text_1.getText();
				args1[3]=text_2.getText();
				args1[4]=text_3.getText();
				args1[5]=text_4.getText();
				args1[6]=text_5.getText();
				args1[7]=text_6.getText();
				args1[8]=text_7.getText();
				args1[9]=text_8.getText();
				args1[10]=text_9.getText();
				args1[11]=text_10.getText();

				Fileini.writeUrssafCfg(args1);
			}
		});
		
		
		Button btnVrifierLeFichier = new Button(container, SWT.NONE);
		btnVrifierLeFichier.setText("V\u00E9rifier le fichier Excel");
		btnVrifierLeFichier.setBounds(161, 320, 131, 25);
		btnVrifierLeFichier.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent ee) {
				System.out.println("Click btnVrifierLeFichier");
////////////////////////////////////////////////////////////////////////////
		        File f = new File(args1[1]);
		        if( ! f.exists()){
		        	System.out.println("File NOT existed -->" + args1[1]);
		  		  }else{
		  			int ligne=0;
				    String pdv ;
				    long montant=(long) 0;
				    String tiers ;
				    String ref1 ;
				    long ref2=(long) 0 ;
			        String liste = "";
				    long mois=(long) 0;
				    long total=(long) 0; 
				    
					String[] magArray;
					long[] euroArray;
					String[] tiersArray;
					String[] ref1Array;
					long[] ref2Array;
			        magArray = new String[150];
			        euroArray = new long[150];
			        tiersArray = new String[150];
			        ref1Array = new String[150];
			        ref2Array = new long[150];
//
			        System.out.println("0 " +args1[0]);		        
			        System.out.println("1 " +args1[1]);		        
			        System.out.println("2 " +args1[2]);		        
			        System.out.println("3 " +args1[3]);		        
			        System.out.println("4 " +args1[4]);		        
			        System.out.println("5 " +args1[5]);		        
			        System.out.println("6 " +args1[6]);		        
			        System.out.println("7 " +args1[7]);		        
			        System.out.println("8 " +args1[8]);		        
			        System.out.println("9 " +args1[9]);		        
			        System.out.println("10 " +args1[10]);		        
			        System.out.println("11 " +args1[11]);		        
//			        
			        Workbook wb = null;
					try {
						wb = WorkbookFactory.create(new File(args1[1]));
					} catch (InvalidFormatException | IOException e) {
						System.out.println("fichier excel -->" +args1[1]);
						e.printStackTrace();
					}
					Sheet onglet = wb.getSheet(args1[3]);
					int ii = 0;

					for (ligne = Integer.parseInt(args1[4])-1 ; ligne <= Integer.parseInt(args1[5])-1; ligne++) 
					{
					    // recuperation de chaque ligne
					    Row row = onglet.getRow(ligne);

						pdv = row.getCell(Integer.parseInt(args1[6])-1)!=null?row.getCell(Integer.parseInt(args1[6])-1).getStringCellValue():"?";
						mois = (long) (row.getCell(Integer.parseInt(args1[8])-1)!=null?row.getCell(Integer.parseInt(args1[8])-1).getNumericCellValue():0);
						montant = (long) (row.getCell(Integer.parseInt(args1[7])-1)!=null?row.getCell(Integer.parseInt(args1[7])-1).getNumericCellValue():0);
						tiers   = row.getCell(Integer.parseInt(args1[9])-1)!=null?row.getCell(Integer.parseInt(args1[9])-1).getStringCellValue():"?";
						ref1    = row.getCell(Integer.parseInt(args1[10])-1)!=null?row.getCell(Integer.parseInt(args1[10])-1).getStringCellValue():"?";
						ref2    = (long) (row.getCell(Integer.parseInt(args1[11])-1)!=null?row.getCell(Integer.parseInt(args1[11])-1).getNumericCellValue():0);
		//			    System.out.println(ligne + " " +pdv + " " + montant );
					    total = total + montant;
					    liste = liste + "<li>" + pdv + " --> " + montant + "</li>";
					    magArray[ii] = pdv;
					    euroArray[ii] = montant;
					    tiersArray[ii] = tiers;
					    ref1Array[ii] = ref1;
					    ref2Array[ii] = ref2;
					    ii++;
					}
		  		  
					System.out.println("Tiers "+tiersArray[0]);
					System.out.println("Ref1 "+ref1Array[0]);
					System.out.println("Ref2 "+ref2Array[0]);
					System.out.println(ligne+ " "+ mois);
		        	System.out.println("Fichier traiter --> " + args1[1] );
					int nbr = wb.getNumberOfSheets();
					System.out.println("Nrb de sheets --> " + nbr);
					System.out.println("Onglet actif --> " + args1[3] );
					nbr = onglet.getLastRowNum();
					System.out.println("Nrb de lignes --> " + nbr);
					System.out.println("Total Euro --> " + total);
		  		  
/////////////////////////////////////////////////////////////////////////////////////
					Display.getCurrent().dispose();
					w1.close();
					args1[13]= Long.toString(mois) ;
					args1[14]= Long.toString(total)  ;
					
					VerifExcel.main(args1);
				
		  		  }
			}
		});
		
		System.out.println("protected Control createContents(Composite parent)");
		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		System.out.println("private void createActions()");
		// Create the actions
	}

	/**
	 * Create the status line manager.
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		System.out.println("protected StatusLineManager createStatusLineManager()");
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main( String[] args ) {
		try {
			System.out.println("---------Arguments");
    		for ( int ii=0 ; ii < args.length ; ii++) {
    			System.out.println(args[ii]);
    		}
			System.out.println("------------------");
			args1=args.clone();
			
			System.out.println("public static void main( String[] args )");
			w1 = new ParamUrssaf();
			w1.setBlockOnOpen(true);
			System.out.println("window.open() start");
			w1.open();
			System.out.println("window.open() end");
//			Display.getCurrent().dispose();
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
		newShell.setText("Paramètres URSSAF");
		System.out.println("protected void configureShell(Shell newShell)");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 467);
	}
}
