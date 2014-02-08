package org.mustbe.consulo.erlang.module.extension;

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
public class ErlangModuleExtensionProvider implements ModuleExtensionProvider<ErlangModuleExtension, ErlangMutableModuleExtension>
{
	@Nullable
	@Override
	public Icon getIcon()
	{
		return ErlangIcons.ERLANG;
	}

	@NotNull
	@Override
	public String getName()
	{
		return "Erlang";
	}

	@NotNull
	@Override
	public ErlangModuleExtension createImmutable(@NotNull String s, @NotNull Module module)
	{
		return new ErlangModuleExtension(s, module);
	}

	@NotNull
	@Override
	public ErlangMutableModuleExtension createMutable(@NotNull String s, @NotNull Module module)
	{
		return new ErlangMutableModuleExtension(s, module);
	}
}
