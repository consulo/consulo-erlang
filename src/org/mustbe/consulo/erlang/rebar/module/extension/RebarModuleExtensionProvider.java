package org.mustbe.consulo.erlang.rebar.module.extension;

import javax.swing.Icon;

import org.consulo.module.extension.ModuleExtensionProvider;
import org.intellij.erlang.ErlangIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.module.Module;

/**
 * @author VISTALL
 * @since 08.02.14
 */
public class RebarModuleExtensionProvider implements ModuleExtensionProvider<RebarModuleExtension, RebarMutableModuleExtension>
{
	@Nullable
	@Override
	public Icon getIcon()
	{
		return ErlangIcons.REBAR;
	}

	@NotNull
	@Override
	public String getName()
	{
		return "Rebar";
	}

	@NotNull
	@Override
	public RebarModuleExtension createImmutable(@NotNull String s, @NotNull Module module)
	{
		return new RebarModuleExtension(s, module);
	}

	@NotNull
	@Override
	public RebarMutableModuleExtension createMutable(@NotNull String s, @NotNull Module module)
	{
		return new RebarMutableModuleExtension(s, module);
	}
}
