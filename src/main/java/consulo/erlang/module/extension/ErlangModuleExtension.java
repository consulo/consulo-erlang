package consulo.erlang.module.extension;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import org.intellij.erlang.sdk.ErlangSdkType;
import org.jdom.Element;
import com.intellij.openapi.projectRoots.SdkType;
import consulo.annotations.RequiredReadAction;
import consulo.module.extension.impl.ModuleExtensionWithSdkImpl;
import consulo.roots.ModuleRootLayer;

/**
 * @author VISTALL
 * @since 08.02.14
 */
public class ErlangModuleExtension extends ModuleExtensionWithSdkImpl<ErlangModuleExtension>
{
	protected List<String> myParseTransforms = new ArrayList<>();

	public ErlangModuleExtension(@Nonnull String id, @Nonnull ModuleRootLayer moduleRootLayer)
	{
		super(id, moduleRootLayer);
	}

	@Override
	protected void getStateImpl(@Nonnull Element element)
	{
		super.getStateImpl(element);

		for(String parseTransform : myParseTransforms)
		{
			element.addContent(new Element("parse-transforms").setText(parseTransform));
		}
	}

	@RequiredReadAction
	@Override
	protected void loadStateImpl(@Nonnull Element element)
	{
		super.loadStateImpl(element);

		for(Element e : element.getChildren("parse-transforms"))
		{
			myParseTransforms.add(e.getText());
		}
	}

	@Override
	public void commit(@Nonnull ErlangModuleExtension mutableModuleExtension)
	{
		super.commit(mutableModuleExtension);

		myParseTransforms.clear();
		myParseTransforms.addAll(mutableModuleExtension.myParseTransforms);
	}

	@Nonnull
	public List<String> getParseTransforms()
	{
		return myParseTransforms;
	}

	@Nonnull
	@Override
	public Class<? extends SdkType> getSdkTypeClass()
	{
		return ErlangSdkType.class;
	}
}
