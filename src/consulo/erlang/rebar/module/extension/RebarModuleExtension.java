package consulo.erlang.rebar.module.extension;

import org.consulo.module.extension.impl.ModuleExtensionWithSdkImpl;
import org.jetbrains.annotations.NotNull;
import consulo.erlang.rebar.bundle.RebarBundleType;
import com.intellij.openapi.projectRoots.SdkType;
import com.intellij.openapi.roots.ModuleRootLayer;

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
