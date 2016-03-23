package com.example.e4.login.dialogs;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class PasswordDialog extends Dialog {
	private Text userText;
	private Text passwordText;
	private String user = "";
	private String password = "";

	protected Composite loginComposite;
	private final Shell shell;
	private Image titleImage;
	private ImageDescriptor imageDescriptor;

	public PasswordDialog() {
		this(Display.getCurrent().getActiveShell());
	}

	public PasswordDialog(Shell parentShell) {
		super(parentShell);
		this.shell = parentShell;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("e4 Tutorial Login");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		parent.setBackgroundMode(SWT.INHERIT_DEFAULT);
		Composite control = createContentArea(parent);
		control.setData("org.eclipse.e4.ui.css.id", "LoginDialog");
		Rectangle controlRect = control.getBounds();
				
		Monitor primary = shell.getDisplay().getPrimaryMonitor();
	    Rectangle displayBounds = primary.getBounds();
	    
		int x = (displayBounds.width - controlRect.width) / 2;
		int y = (displayBounds.height - controlRect.height) / 2;
		shell.setBounds(x, y, controlRect.width, controlRect.height);

		return control;
	}

	protected Composite createContentArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setBackgroundMode(SWT.INHERIT_DEFAULT);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		composite.setLayout(gridLayout);

		Composite userPasswordComposite = new Composite(composite, SWT.NONE);
		userPasswordComposite.setData("org.eclipse.e4.ui.css.id", "LoginDialog");
		GridLayout gridLayout2 = new GridLayout(2,false);
		gridLayout2.marginHeight = 10;
		gridLayout2.marginWidth = 30;
		userPasswordComposite.setLayout(gridLayout2);
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		userPasswordComposite.setLayoutData(gridData);
	
		Label userLabel = new Label(userPasswordComposite, SWT.NONE);
		userLabel.setText("User  ");
		userText = new Text(userPasswordComposite, SWT.NONE);
		userText.setText(user);
		gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		userText.setLayoutData(gridData);
		
		Label passwordLabel = new Label(userPasswordComposite, SWT.NONE);
		passwordLabel.setText("Password  ");
		passwordText = new Text(userPasswordComposite, SWT.PASSWORD);
		passwordText.setText(password);
		
		gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		passwordText.setLayoutData(gridData);
		
		return composite;
	}
	
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		// create OK and Cancel buttons by default
		parent.setBackgroundMode(SWT.INHERIT_DEFAULT);
		super.createButtonsForButtonBar(parent);
	}

	@Override
	public boolean close() {
		if (titleImage != null) {
			titleImage.dispose();
		}
		return super.close();
	}
	
	@Override
	protected void okPressed() {
		user = userText.getText();
		password = passwordText.getText();
		
		// validate user input here ...
		super.okPressed();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
