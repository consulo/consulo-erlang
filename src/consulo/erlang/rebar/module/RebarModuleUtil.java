package consulo.erlang.rebar.module;

import consulo.erlang.rebar.module.extension.RebarModuleExtension;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.projectRoots.Sdk;

/**
 * @author VISTALL
 * @since 08.02.14
 */
public class RebarModuleUtil
{
	public static String getRebarPath(Module module)
	{
		if(module == null)
		{
			return null;
		}

		Sdk sdk = ModuleUtilCore.getSdk(module, RebarModuleExtension.class);
		return sdk == null ? null : sdk.getHomePath(); //TODO [VISTALL] rebar path
	}
}
