package consulo.erlang.rebar.module.extension;

import javax.annotation.Nonnull;

import com.intellij.openapi.projectRoots.SdkType;
import consulo.erlang.rebar.bundle.RebarBundleType;
import consulo.module.extension.impl.ModuleExtensionWithSdkImpl;
import consulo.roots.ModuleRootLayer;

/**
 * @author VISTALL
 * @since 08.02.14
 */
public class RebarModuleExtension extends ModuleExtensionWithSdkImpl<RebarModuleExtension>
{
	public RebarModuleExtension(@Nonnull String id, @Nonnull ModuleRootLayer moduleRootLayer)
	{
		super(id, moduleRootLayer);
	}

	@Nonnull
	@Override
	public Class<? extends SdkType> getSdkTypeClass()
	{
		return RebarBundleType.class;
	}
}
