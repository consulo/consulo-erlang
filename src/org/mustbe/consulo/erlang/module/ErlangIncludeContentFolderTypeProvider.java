package org.mustbe.consulo.erlang.module;

import java.awt.Color;

import javax.swing.Icon;

import org.intellij.erlang.ErlangIcons;
import org.jetbrains.annotations.NotNull;
import org.mustbe.consulo.roots.impl.BaseContentFolderTypeProvider;
import com.intellij.ui.JBColor;

/**
 * @author VISTALL
 * @since 08.02.14
 */
public class ErlangIncludeContentFolderTypeProvider extends BaseContentFolderTypeProvider
{
	public static final Color COLOR = new JBColor(new Color(140, 123, 79), new Color(140, 123, 79));

	@NotNull
	public static ErlangIncludeContentFolderTypeProvider getInstance()
	{
		return EP_NAME.findExtension(ErlangIncludeContentFolderTypeProvider.class);
	}

	public ErlangIncludeContentFolderTypeProvider()
	{
		super("ERLANG_INCLUDE");
	}

	@NotNull
	@Override
	public Icon getIcon()
	{
		return ErlangIcons.IncludeRoot;
	}

	@NotNull
	@Override
	public String getName()
	{
		return "Includes";
	}

	@NotNull
	@Override
	public Color getGroupColor()
	{
		return COLOR;
	}
}
