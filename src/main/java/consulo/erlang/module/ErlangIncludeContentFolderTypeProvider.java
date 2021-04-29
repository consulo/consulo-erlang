package consulo.erlang.module;

import consulo.roots.ContentFolderTypeProvider;
import consulo.ui.color.ColorValue;
import consulo.ui.color.RGBColor;
import consulo.ui.ex.util.LightDarkColorValue;
import consulo.ui.image.Image;
import org.intellij.erlang.ErlangIcons;

import javax.annotation.Nonnull;

/**
 * @author VISTALL
 * @since 08.02.14
 */
public class ErlangIncludeContentFolderTypeProvider extends ContentFolderTypeProvider
{
	public static final ColorValue COLOR = new LightDarkColorValue(new RGBColor(140, 123, 79), new RGBColor(140, 123, 79));

	@Nonnull
	public static ErlangIncludeContentFolderTypeProvider getInstance()
	{
		return EP_NAME.findExtensionOrFail(ErlangIncludeContentFolderTypeProvider.class);
	}

	public ErlangIncludeContentFolderTypeProvider()
	{
		super("ERLANG_INCLUDE");
	}

	@Override
	public int getWeight()
	{
		return 125;
	}

	@Nonnull
	@Override
	public Image getIcon()
	{
		return ErlangIcons.IncludeRoot;
	}

	@Nonnull
	@Override
	public String getName()
	{
		return "Includes";
	}

	@Nonnull
	@Override
	public ColorValue getGroupColor()
	{
		return COLOR;
	}
}
