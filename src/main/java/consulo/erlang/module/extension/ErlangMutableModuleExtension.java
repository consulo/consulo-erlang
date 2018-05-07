package consulo.erlang.module.extension;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.annotation.Nullable;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.annotation.Nonnull;

import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.openapi.ui.VerticalFlowLayout;
import com.intellij.openapi.util.text.StringUtil;
import consulo.annotations.RequiredDispatchThread;
import consulo.extension.ui.ModuleExtensionSdkBoxBuilder;
import consulo.module.extension.MutableModuleExtensionWithSdk;
import consulo.module.extension.MutableModuleInheritableNamedPointer;
import consulo.roots.ModuleRootLayer;

/**
 * @author VISTALL
 * @since 08.02.14
 */
public class ErlangMutableModuleExtension extends ErlangModuleExtension implements MutableModuleExtensionWithSdk<ErlangModuleExtension>
{
	public ErlangMutableModuleExtension(@Nonnull String id, @Nonnull ModuleRootLayer moduleRootLayer)
	{
		super(id, moduleRootLayer);
	}

	@Nonnull
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

		JTextField parseTransformsField = new JTextField(StringUtil.join(myParseTransforms, ","));
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
	public boolean isModified(@Nonnull ErlangModuleExtension erlangModuleExtension)
	{
		return isModifiedImpl(erlangModuleExtension) || !myParseTransforms.equals(erlangModuleExtension
				.myParseTransforms);
	}
}
