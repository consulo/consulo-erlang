package consulo.erlang.module;

import java.awt.Color;

import javax.annotation.Nonnull;

import org.intellij.erlang.ErlangIcons;
import com.intellij.ui.JBColor;
import consulo.roots.ContentFolderTypeProvider;
import consulo.ui.image.Image;

/**
 * @author VISTALL
 * @since 08.02.14
 */
public class ErlangIncludeContentFolderTypeProvider extends ContentFolderTypeProvider
{
	public static final Color COLOR = new JBColor(new Color(140, 123, 79), new Color(140, 123, 79));

	@Nonnull
	public static ErlangIncludeContentFolderTypeProvider getInstance()
	{
		return EP_NAME.findExtension(ErlangIncludeContentFolderTypeProvider.class);
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
	public Color getGroupColor()
	{
		return COLOR;
	}
}
