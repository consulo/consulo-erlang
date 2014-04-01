package org.mustbe.consulo.erlang.rebar.module.extension;

import org.consulo.module.extension.impl.ModuleExtensionWithSdkImpl;
import org.jetbrains.annotations.NotNull;
import org.mustbe.consulo.erlang.rebar.bundle.RebarBundleType;
import com.intellij.openapi.projectRoots.SdkType;
import com.intellij.openapi.roots.ModifiableRootModel;

/**
 * @author VISTALL
 * @since 08.02.14
 */
public class RebarModuleExtension extends ModuleExtensionWithSdkImpl<RebarModuleExtension>
{
	public RebarModuleExtension(@NotNull String id, @NotNull ModifiableRootModel module)
	{
		super(id, module);
	}

	@NotNull
	@Override
	public Class<? extends SdkType> getSdkTypeClass()
	{
		return RebarBundleType.class;
	}
}
