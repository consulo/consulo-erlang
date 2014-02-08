package org.mustbe.consulo.erlang.rebar.bundle;

import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.projectRoots.AdditionalDataConfigurable;
import com.intellij.openapi.projectRoots.SdkAdditionalData;
import com.intellij.openapi.projectRoots.SdkModel;
import com.intellij.openapi.projectRoots.SdkModificator;
import com.intellij.openapi.projectRoots.SdkType;

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

	@Nullable
	@Override
	public String suggestHomePath()
	{
		return null;
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

	@Nullable
	@Override
	public AdditionalDataConfigurable createAdditionalDataConfigurable(SdkModel sdkModel, SdkModificator sdkModificator)
	{
		return null;
	}

	@NotNull
	@Override
	public String getPresentableName()
	{
		return null;
	}

	@Override
	public void saveAdditionalData(SdkAdditionalData sdkAdditionalData, Element element)
	{

	}
}
