package org.intellij.erlang.configuration;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.project.Project;
import consulo.options.SimpleConfigurableByProperties;
import consulo.ui.CheckBox;
import consulo.ui.Component;
import consulo.ui.annotation.RequiredUIAccess;
import consulo.ui.layout.VerticalLayout;

import javax.annotation.Nonnull;

public class ErlangCompilerOptionsConfigurable extends SimpleConfigurableByProperties implements Configurable
{
	private final Project myProject;

	public ErlangCompilerOptionsConfigurable(final Project project)
	{
		myProject = project;
	}

	@RequiredUIAccess
	@Nonnull
	@Override
	protected Component createLayout(PropertyBuilder propertyBuilder)
	{
		ErlangCompilerSettings settings = ErlangCompilerSettings.getInstance(myProject);

		VerticalLayout layout = VerticalLayout.create();
		CheckBox enableDebugBox = CheckBox.create("Add &debug info");
		layout.add(enableDebugBox);
		propertyBuilder.add(enableDebugBox, settings::isAddDebugInfoEnabled, settings::setAddDebugInfoEnabled);
		return layout;
	}

	@Override
	public String getDisplayName()
	{
		return "Erlang Compiler";
	}
}
