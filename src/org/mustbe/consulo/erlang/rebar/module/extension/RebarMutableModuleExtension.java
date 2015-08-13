package org.mustbe.consulo.erlang.rebar.module.extension;

import javax.swing.JComponent;

import org.consulo.module.extension.MutableModuleExtensionWithSdk;
import org.consulo.module.extension.MutableModuleInheritableNamedPointer;
import org.consulo.module.extension.ui.ModuleExtensionSdkBoxBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mustbe.consulo.RequiredDispatchThread;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.roots.ModuleRootLayer;
import com.intellij.util.ui.JBUI;

/**
 * @author VISTALL
 * @since 08.02.14
 */
public class RebarMutableModuleExtension extends RebarModuleExtension implements
		MutableModuleExtensionWithSdk<RebarModuleExtension>
{
	public RebarMutableModuleExtension(@NotNull String id, @NotNull ModuleRootLayer moduleRootLayer)
	{
		super(id, moduleRootLayer);
	}

	@NotNull
	@Override
	public MutableModuleInheritableNamedPointer<Sdk> getInheritableSdk()
	{
		return (MutableModuleInheritableNamedPointer<Sdk>) super.getInheritableSdk();
	}

	@RequiredDispatchThread
	@Nullable
	@Override
	public JComponent createConfigurablePanel(@Nullable Runnable runnable)
	{
		return JBUI.Panels.verticalPanel().addComponent(ModuleExtensionSdkBoxBuilder.createAndDefine(this,
				runnable).build());
	}

	@Override
	public void setEnabled(boolean b)
	{
		myIsEnabled = b;
	}

	@Override
	public boolean isModified(@NotNull RebarModuleExtension rebarModuleExtension)
	{
		return isModifiedImpl(rebarModuleExtension);
	}
}
