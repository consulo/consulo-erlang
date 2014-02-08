package org.mustbe.consulo.erlang.module.extension;

import org.consulo.module.extension.impl.ModuleExtensionWithSdkImpl;
import org.intellij.erlang.sdk.ErlangSdkType;
import org.jetbrains.annotations.NotNull;
import org.mustbe.consulo.erlang.module.ErlangIncludeContentFolderTypeProvider;
import org.mustbe.consulo.roots.ContentFoldersSupport;
import org.mustbe.consulo.roots.impl.ProductionContentFolderTypeProvider;
import org.mustbe.consulo.roots.impl.TestContentFolderTypeProvider;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.projectRoots.SdkType;

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
	public ErlangModuleExtension(@NotNull String id, @NotNull Module module)
	{
		super(id, module);
	}

	@Override
	protected Class<? extends SdkType> getSdkTypeClass()
	{
		return ErlangSdkType.class;
	}
}
