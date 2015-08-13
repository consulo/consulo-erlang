package org.mustbe.consulo.erlang.module.extension;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.consulo.module.extension.MutableModuleExtensionWithSdk;
import org.consulo.module.extension.MutableModuleInheritableNamedPointer;
import org.consulo.module.extension.ui.ModuleExtensionSdkBoxBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mustbe.consulo.RequiredDispatchThread;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.roots.ModuleRootLayer;
import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.openapi.ui.VerticalFlowLayout;
import com.intellij.openapi.util.text.StringUtil;
import lombok.val;

/**
 * @author VISTALL
 * @since 08.02.14
 */
public class ErlangMutableModuleExtension extends ErlangModuleExtension implements
		MutableModuleExtensionWithSdk<ErlangModuleExtension>
{
	public ErlangMutableModuleExtension(@NotNull String id, @NotNull ModuleRootLayer moduleRootLayer)
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
		JPanel panel = new JPanel(new VerticalFlowLayout());
		panel.add(ModuleExtensionSdkBoxBuilder.createAndDefine(this, runnable).build());

		val parseTransformsField = new JTextField(StringUtil.join(myParseTransforms, ","));
		parseTransformsField.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyReleased(KeyEvent e)
			{
				myParseTransforms.clear();
				myParseTransforms.addAll(StringUtil.split(parseTransformsField.getText(), ","));
			}
		});
		panel.add(LabeledComponent.left(parseTransformsField, "Parse transforms"));

		return panel;
	}

	@Override
	public void setEnabled(boolean b)
	{
		myIsEnabled = b;
	}

	@Override
	public boolean isModified(@NotNull ErlangModuleExtension erlangModuleExtension)
	{
		return isModifiedImpl(erlangModuleExtension) || !myParseTransforms.equals(erlangModuleExtension
				.myParseTransforms);
	}
}
