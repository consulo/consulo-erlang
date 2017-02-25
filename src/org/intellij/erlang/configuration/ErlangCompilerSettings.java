package org.intellij.erlang.configuration;

import com.intellij.openapi.components.*;
import com.intellij.openapi.project.Project;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(name = "ErlangCompilerSettings", storages = @Storage(file = StoragePathMacros.PROJECT_CONFIG_DIR + "/compiler.xml"))
public class ErlangCompilerSettings implements PersistentStateComponent<Element>
{
	@NotNull
	public static ErlangCompilerSettings getInstance(@NotNull Project project)
	{
		return ServiceManager.getService(project, ErlangCompilerSettings.class);
	}

	private boolean myAddDebugInfoEnabled;

	@Nullable
	@Override
	public Element getState()
	{
		Element element = new Element("state");
		element.setAttribute("add-debug-info", String.valueOf(myAddDebugInfoEnabled));
		return element;
	}

	@Override
	public void loadState(Element state)
	{
		myAddDebugInfoEnabled = Boolean.parseBoolean(state.getAttributeValue("add-debug-info", "false"));
	}

	public boolean isAddDebugInfoEnabled()
	{
		return myAddDebugInfoEnabled;
	}

	public void setAddDebugInfoEnabled(boolean useDebugInfo)
	{
		myAddDebugInfoEnabled = useDebugInfo;
	}
}