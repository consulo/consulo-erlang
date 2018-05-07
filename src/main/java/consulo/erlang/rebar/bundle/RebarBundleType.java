package consulo.erlang.rebar.bundle;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.intellij.erlang.ErlangIcons;
import com.intellij.openapi.projectRoots.SdkType;
import consulo.ui.image.Image;

/**
 * @author VISTALL
 * @since 08.02.14
 */
public class RebarBundleType extends SdkType
{
	public RebarBundleType()
	{
		super("REBAR_BUNDLE");
	}

	@Override
	public boolean isValidSdkHome(String s)
	{
		return true;
	}

	@Nullable
	@Override
	public String getVersionString(String s)
	{
		return null;
	}

	@Override
	public String suggestSdkName(String s, String s2)
	{
		return null;
	}

	@Nonnull
	@Override
	public String getPresentableName()
	{
		return "Rebar";
	}

	@Nullable
	@Override
	public Image getIcon()
	{
		return ErlangIcons.REBAR;
	}
}
