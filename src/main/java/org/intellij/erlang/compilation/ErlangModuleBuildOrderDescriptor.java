package org.intellij.erlang.compilation;

import java.util.ArrayList;
import java.util.List;

import com.intellij.util.xmlb.annotations.AbstractCollection;
import com.intellij.util.xmlb.annotations.Tag;

public class ErlangModuleBuildOrderDescriptor
{
	@Tag("module")
	public String myModuleName = "";

	@Tag("erlangModules")
	@AbstractCollection(surroundWithTag = false, elementTag = "path")
	public List<String> myOrderedErlangModulePaths = new ArrayList<String>();

	@Tag("testErlangModules")
	@AbstractCollection(surroundWithTag = false, elementTag = "path")
	public List<String> myOrderedErlangTestModulePaths = new ArrayList<String>();
}