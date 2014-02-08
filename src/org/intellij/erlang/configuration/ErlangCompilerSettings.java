package org.intellij.erlang.configuration;

import org.consulo.lombok.annotations.ProjectService;
import org.jdom.Element;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.openapi.components.StorageScheme;

@State(
		name = "ErlangCompilerSettings",
		storages = {
				@Storage(file = StoragePathMacros.PROJECT_CONFIG_DIR + "/compiler.xml", scheme = StorageScheme.DIRECTORY_BASED)
		})
@ProjectService
public class ErlangCompilerSettings implements PersistentStateComponent<Element>
{
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