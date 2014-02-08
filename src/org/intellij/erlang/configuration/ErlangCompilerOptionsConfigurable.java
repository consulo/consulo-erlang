package org.intellij.erlang.configuration;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.intellij.compiler.options.CompilerConfigurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;

public class ErlangCompilerOptionsConfigurable extends CompilerConfigurable
{
	private JPanel myRootPanel;

	private JCheckBox myAddDebugInfoCheckBox;
	private final ErlangCompilerSettings mySettings;

	public ErlangCompilerOptionsConfigurable(final Project project)
	{
		super(project);

		mySettings = ErlangCompilerSettings.getInstance(project);
	}

	@Override
	public String getDisplayName()
	{
		return "Erlang Compiler";
	}

	@Override
	public JComponent createComponent()
	{
		return myRootPanel;
	}

	@Override
	public void reset()
	{

		myAddDebugInfoCheckBox.setSelected(mySettings.isAddDebugInfoEnabled());
	}

	@Override
	public void apply() throws ConfigurationException
	{
		mySettings.setAddDebugInfoEnabled(myAddDebugInfoCheckBox.isSelected());
	}

	@Override
	public boolean isModified()
	{
		return mySettings.isAddDebugInfoEnabled() != myAddDebugInfoCheckBox.isSelected();
	}
}
