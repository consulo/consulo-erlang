package org.mustbe.consulo.erlang.rebar.module.extension;

import org.consulo.module.extension.impl.ModuleExtensionWithSdkImpl;
import org.jetbrains.annotations.NotNull;
import org.mustbe.consulo.erlang.rebar.bundle.RebarBundleType;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.projectRoots.SdkType;

/**
 * @author VISTALL
 * @since 08.02.14
 */
public class RebarModuleExtension extends ModuleExtensionWithSdkImpl<RebarModuleExtension>
{
	public RebarModuleExtension(@NotNull String id, @NotNull Module module)
	{
		super(id, module);
	}

	@Override
	protected Class<? extends SdkType> getSdkTypeClass()
	{
		return RebarBundleType.class;
	}
}
