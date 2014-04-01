package org.mustbe.consulo.erlang.module.extension;

import java.util.ArrayList;
import java.util.List;

import org.consulo.module.extension.impl.ModuleExtensionWithSdkImpl;
import org.intellij.erlang.sdk.ErlangSdkType;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.mustbe.consulo.erlang.module.ErlangIncludeContentFolderTypeProvider;
import org.mustbe.consulo.roots.ContentFoldersSupport;
import org.mustbe.consulo.roots.impl.ProductionContentFolderTypeProvider;
import org.mustbe.consulo.roots.impl.TestContentFolderTypeProvider;
import com.intellij.openapi.projectRoots.SdkType;
import com.intellij.openapi.roots.ModifiableRootModel;

/**
 * @author VISTALL
 * @since 08.02.14
 */
@ContentFoldersSupport(value = {
		ProductionContentFolderTypeProvider.class,
		TestContentFolderTypeProvider.class,
		ErlangIncludeContentFolderTypeProvider.class
})
public class ErlangModuleExtension extends ModuleExtensionWithSdkImpl<ErlangModuleExtension>
{
	protected List<String> myParseTransforms = new ArrayList<String>();

	public ErlangModuleExtension(@NotNull String id, @NotNull ModifiableRootModel module)
	{
		super(id, module);
	}

	@Override
	protected void getStateImpl(@NotNull Element element)
	{
		super.getStateImpl(element);

		for(String parseTransform : myParseTransforms)
		{
			element.addContent(new Element("parse-transforms").setText(parseTransform));
		}
	}

	@Override
	protected void loadStateImpl(@NotNull Element element)
	{
		super.loadStateImpl(element);

		for(Element e : element.getChildren("parse-transforms"))
		{
			myParseTransforms.add(e.getText());
		}
	}

	@Override
	public void commit(@NotNull ErlangModuleExtension mutableModuleExtension)
	{
		super.commit(mutableModuleExtension);

		myParseTransforms.clear();
		myParseTransforms.addAll(mutableModuleExtension.myParseTransforms);
	}

	@NotNull
	public List<String> getParseTransforms()
	{
		return myParseTransforms;
	}

	@NotNull
	@Override
	public Class<? extends SdkType> getSdkTypeClass()
	{
		return ErlangSdkType.class;
	}
}
