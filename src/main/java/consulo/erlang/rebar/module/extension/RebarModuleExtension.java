package consulo.erlang.rebar.module.extension;

import org.jetbrains.annotations.NotNull;
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
	public RebarModuleExtension(@NotNull String id, @NotNull ModuleRootLayer moduleRootLayer)
	{
		super(id, moduleRootLayer);
	}

	@NotNull
	@Override
	public Class<? extends SdkType> getSdkTypeClass()
	{
		return RebarBundleType.class;
	}
}
