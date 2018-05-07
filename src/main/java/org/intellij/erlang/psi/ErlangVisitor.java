// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.Nonnull;

import com.intellij.psi.PsiElementVisitor;

public class ErlangVisitor extends PsiElementVisitor {

  public void visitAdditiveExpression(@Nonnull ErlangAdditiveExpression o) {
    visitFakeBinaryExpression(o);
  }

  public void visitAfterClause(@Nonnull ErlangAfterClause o) {
    visitCompositeElement(o);
  }

  public void visitAfterClauseBody(@Nonnull ErlangAfterClauseBody o) {
    visitCompositeElement(o);
  }

  public void visitAndalsoExpression(@Nonnull ErlangAndalsoExpression o) {
    visitFakeBinaryExpression(o);
  }

  public void visitAnonymousCallExpression(@Nonnull ErlangAnonymousCallExpression o) {
    visitExpression(o);
  }

  public void visitArgumentDefinition(@Nonnull ErlangArgumentDefinition o) {
    visitCompositeElement(o);
  }

  public void visitArgumentDefinitionList(@Nonnull ErlangArgumentDefinitionList o) {
    visitCompositeElement(o);
  }

  public void visitArgumentList(@Nonnull ErlangArgumentList o) {
    visitCompositeElement(o);
  }

  public void visitAssignmentExpression(@Nonnull ErlangAssignmentExpression o) {
    visitFakeBinaryExpression(o);
  }

  public void visitAtomAttribute(@Nonnull ErlangAtomAttribute o) {
    visitCompositeElement(o);
  }

  public void visitAttrVal(@Nonnull ErlangAttrVal o) {
    visitCompositeElement(o);
  }

  public void visitAttribute(@Nonnull ErlangAttribute o) {
    visitCompositeElement(o);
  }

  public void visitBeginEndBody(@Nonnull ErlangBeginEndBody o) {
    visitCompositeElement(o);
  }

  public void visitBeginEndExpression(@Nonnull ErlangBeginEndExpression o) {
    visitExpression(o);
  }

  public void visitBehaviour(@Nonnull ErlangBehaviour o) {
    visitCompositeElement(o);
  }

  public void visitBinBaseType(@Nonnull ErlangBinBaseType o) {
    visitType(o);
  }

  public void visitBinElement(@Nonnull ErlangBinElement o) {
    visitCompositeElement(o);
  }

  public void visitBinUnitType(@Nonnull ErlangBinUnitType o) {
    visitType(o);
  }

  public void visitBinaryExpression(@Nonnull ErlangBinaryExpression o) {
    visitExpression(o);
  }

  public void visitBinaryType(@Nonnull ErlangBinaryType o) {
    visitType(o);
  }

  public void visitBitType(@Nonnull ErlangBitType o) {
    visitCompositeElement(o);
  }

  public void visitCallbackSpec(@Nonnull ErlangCallbackSpec o) {
    visitCompositeElement(o);
  }

  public void visitCaseExpression(@Nonnull ErlangCaseExpression o) {
    visitExpression(o);
    // visitClauseOwner(o);
  }

  public void visitCatchExpression(@Nonnull ErlangCatchExpression o) {
    visitExpression(o);
  }

  public void visitClauseBody(@Nonnull ErlangClauseBody o) {
    visitCompositeElement(o);
  }

  public void visitClauseGuard(@Nonnull ErlangClauseGuard o) {
    visitCompositeElement(o);
  }

  public void visitColonQualifiedExpression(@Nonnull ErlangColonQualifiedExpression o) {
    visitExpression(o);
  }

  public void visitCompOpExpression(@Nonnull ErlangCompOpExpression o) {
    visitFakeBinaryExpression(o);
  }

  public void visitConfigCallExpression(@Nonnull ErlangConfigCallExpression o) {
    visitExpression(o);
  }

  public void visitConfigExpression(@Nonnull ErlangConfigExpression o) {
    visitExpression(o);
  }

  public void visitCrClause(@Nonnull ErlangCrClause o) {
    visitCompositeElement(o);
  }

  public void visitExport(@Nonnull ErlangExport o) {
    visitCompositeElement(o);
  }

  public void visitExportFunction(@Nonnull ErlangExportFunction o) {
    visitCompositeElement(o);
  }

  public void visitExportFunctions(@Nonnull ErlangExportFunctions o) {
    visitCompositeElement(o);
  }

  public void visitExportType(@Nonnull ErlangExportType o) {
    visitCompositeElement(o);
  }

  public void visitExportTypeAttribute(@Nonnull ErlangExportTypeAttribute o) {
    visitCompositeElement(o);
  }

  public void visitExportTypes(@Nonnull ErlangExportTypes o) {
    visitCompositeElement(o);
  }

  public void visitExpression(@Nonnull ErlangExpression o) {
    visitCompositeElement(o);
  }

  public void visitFakeBinaryExpression(@Nonnull ErlangFakeBinaryExpression o) {
    visitExpression(o);
  }

  public void visitFieldType(@Nonnull ErlangFieldType o) {
    visitType(o);
  }

  public void visitFunClause(@Nonnull ErlangFunClause o) {
    visitCompositeElement(o);
  }

  public void visitFunClauses(@Nonnull ErlangFunClauses o) {
    visitCompositeElement(o);
  }

  public void visitFunExpression(@Nonnull ErlangFunExpression o) {
    visitExpression(o);
  }

  public void visitFunType(@Nonnull ErlangFunType o) {
    visitType(o);
  }

  public void visitFunType100T(@Nonnull ErlangFunType100T o) {
    visitType(o);
  }

  public void visitFunTypeArguments(@Nonnull ErlangFunTypeArguments o) {
    visitCompositeElement(o);
  }

  public void visitFunTypeSigs(@Nonnull ErlangFunTypeSigs o) {
    visitCompositeElement(o);
  }

  public void visitFunTypeSigsBraces(@Nonnull ErlangFunTypeSigsBraces o) {
    visitCompositeElement(o);
  }

  public void visitFunction(@Nonnull ErlangFunction o) {
    visitNamedElement(o);
  }

  public void visitFunctionCallExpression(@Nonnull ErlangFunctionCallExpression o) {
    visitExpression(o);
  }

  public void visitFunctionClause(@Nonnull ErlangFunctionClause o) {
    visitCompositeElement(o);
  }

  public void visitFunctionWithArity(@Nonnull ErlangFunctionWithArity o) {
    visitCompositeElement(o);
  }

  public void visitFunctionWithArityVariables(@Nonnull ErlangFunctionWithArityVariables o) {
    visitCompositeElement(o);
  }

  public void visitGenericFunctionCallExpression(@Nonnull ErlangGenericFunctionCallExpression o) {
    visitExpression(o);
  }

  public void visitGlobalFunctionCallExpression(@Nonnull ErlangGlobalFunctionCallExpression o) {
    visitExpression(o);
  }

  public void visitGuard(@Nonnull ErlangGuard o) {
    visitCompositeElement(o);
  }

  public void visitIfClause(@Nonnull ErlangIfClause o) {
    visitCompositeElement(o);
  }

  public void visitIfExpression(@Nonnull ErlangIfExpression o) {
    visitExpression(o);
  }

  public void visitImportDirective(@Nonnull ErlangImportDirective o) {
    visitCompositeElement(o);
  }

  public void visitImportFunction(@Nonnull ErlangImportFunction o) {
    visitCompositeElement(o);
  }

  public void visitImportFunctions(@Nonnull ErlangImportFunctions o) {
    visitCompositeElement(o);
  }

  public void visitInclude(@Nonnull ErlangInclude o) {
    visitCompositeElement(o);
  }

  public void visitIncludeLib(@Nonnull ErlangIncludeLib o) {
    visitCompositeElement(o);
  }

  public void visitIncludeString(@Nonnull ErlangIncludeString o) {
    visitCompositeElement(o);
  }

  public void visitIntType(@Nonnull ErlangIntType o) {
    visitType(o);
  }

  public void visitLcExpression(@Nonnull ErlangLcExpression o) {
    visitExpression(o);
  }

  public void visitLcExprs(@Nonnull ErlangLcExprs o) {
    visitCompositeElement(o);
  }

  public void visitListComprehension(@Nonnull ErlangListComprehension o) {
    visitExpression(o);
  }

  public void visitListExpression(@Nonnull ErlangListExpression o) {
    visitExpression(o);
  }

  public void visitListOpExpression(@Nonnull ErlangListOpExpression o) {
    visitFakeBinaryExpression(o);
  }

  public void visitMacros(@Nonnull ErlangMacros o) {
    visitCompositeElement(o);
  }

  public void visitMacrosArg(@Nonnull ErlangMacrosArg o) {
    visitCompositeElement(o);
  }

  public void visitMacrosBody(@Nonnull ErlangMacrosBody o) {
    visitCompositeElement(o);
  }

  public void visitMacrosCall(@Nonnull ErlangMacrosCall o) {
    visitCompositeElement(o);
  }

  public void visitMacrosDefinition(@Nonnull ErlangMacrosDefinition o) {
    visitNamedElement(o);
  }

  public void visitMacrosName(@Nonnull ErlangMacrosName o) {
    visitCompositeElement(o);
  }

  public void visitMaxExpression(@Nonnull ErlangMaxExpression o) {
    visitExpression(o);
  }

  public void visitModelFieldList(@Nonnull ErlangModelFieldList o) {
    visitCompositeElement(o);
  }

  public void visitModule(@Nonnull ErlangModule o) {
    visitNamedElement(o);
  }

  public void visitModuleRef(@Nonnull ErlangModuleRef o) {
    visitCompositeElement(o);
  }

  public void visitMultiplicativeExpression(@Nonnull ErlangMultiplicativeExpression o) {
    visitFakeBinaryExpression(o);
  }

  public void visitOptBitTypeList(@Nonnull ErlangOptBitTypeList o) {
    visitCompositeElement(o);
  }

  public void visitOrelseExpression(@Nonnull ErlangOrelseExpression o) {
    visitFakeBinaryExpression(o);
  }

  public void visitParenthesizedExpression(@Nonnull ErlangParenthesizedExpression o) {
    visitExpression(o);
  }

  public void visitPrefixExpression(@Nonnull ErlangPrefixExpression o) {
    visitExpression(o);
  }

  public void visitQAtom(@Nonnull ErlangQAtom o) {
    visitCompositeElement(o);
  }

  public void visitQVar(@Nonnull ErlangQVar o) {
    visitNamedElement(o);
  }

  public void visitQualifiedExpression(@Nonnull ErlangQualifiedExpression o) {
    visitExpression(o);
  }

  public void visitReceiveExpression(@Nonnull ErlangReceiveExpression o) {
    visitExpression(o);
    // visitClauseOwner(o);
  }

  public void visitRecordDefinition(@Nonnull ErlangRecordDefinition o) {
    visitNamedElement(o);
  }

  public void visitRecordExpression(@Nonnull ErlangRecordExpression o) {
    visitExpression(o);
  }

  public void visitRecordField(@Nonnull ErlangRecordField o) {
    visitCompositeElement(o);
  }

  public void visitRecordFields(@Nonnull ErlangRecordFields o) {
    visitCompositeElement(o);
  }

  public void visitRecordLikeType(@Nonnull ErlangRecordLikeType o) {
    visitType(o);
  }

  public void visitRecordRef(@Nonnull ErlangRecordRef o) {
    visitCompositeElement(o);
  }

  public void visitRecordTuple(@Nonnull ErlangRecordTuple o) {
    visitCompositeElement(o);
  }

  public void visitRule(@Nonnull ErlangRule o) {
    visitCompositeElement(o);
  }

  public void visitRuleBody(@Nonnull ErlangRuleBody o) {
    visitCompositeElement(o);
  }

  public void visitRuleClause(@Nonnull ErlangRuleClause o) {
    visitCompositeElement(o);
  }

  public void visitSendExpression(@Nonnull ErlangSendExpression o) {
    visitFakeBinaryExpression(o);
  }

  public void visitSpecFun(@Nonnull ErlangSpecFun o) {
    visitCompositeElement(o);
  }

  public void visitSpecification(@Nonnull ErlangSpecification o) {
    visitCompositeElement(o);
  }

  public void visitStringLiteral(@Nonnull ErlangStringLiteral o) {
    visitExpression(o);
    // visitPsiLanguageInjectionHost(o);
  }

  public void visitTopType(@Nonnull ErlangTopType o) {
    visitCompositeElement(o);
  }

  public void visitTopType100T(@Nonnull ErlangTopType100T o) {
    visitType(o);
  }

  public void visitTopTypeClause(@Nonnull ErlangTopTypeClause o) {
    visitCompositeElement(o);
  }

  public void visitTryCatch(@Nonnull ErlangTryCatch o) {
    visitCompositeElement(o);
  }

  public void visitTryClause(@Nonnull ErlangTryClause o) {
    visitCompositeElement(o);
  }

  public void visitTryClauses(@Nonnull ErlangTryClauses o) {
    visitCompositeElement(o);
  }

  public void visitTryExpression(@Nonnull ErlangTryExpression o) {
    visitExpression(o);
    // visitClauseOwner(o);
  }

  public void visitTryExpressionsClause(@Nonnull ErlangTryExpressionsClause o) {
    visitCompositeElement(o);
  }

  public void visitTupleExpression(@Nonnull ErlangTupleExpression o) {
    visitExpression(o);
  }

  public void visitType(@Nonnull ErlangType o) {
    visitCompositeElement(o);
  }

  public void visitTypeDefinition(@Nonnull ErlangTypeDefinition o) {
    visitNamedElement(o);
  }

  public void visitTypeGuard(@Nonnull ErlangTypeGuard o) {
    visitCompositeElement(o);
  }

  public void visitTypeRef(@Nonnull ErlangTypeRef o) {
    visitCompositeElement(o);
  }

  public void visitTypeSig(@Nonnull ErlangTypeSig o) {
    visitCompositeElement(o);
  }

  public void visitTypeSigGuard(@Nonnull ErlangTypeSigGuard o) {
    visitCompositeElement(o);
  }

  public void visitTypedAttrVal(@Nonnull ErlangTypedAttrVal o) {
    visitCompositeElement(o);
  }

  public void visitTypedExpr(@Nonnull ErlangTypedExpr o) {
    visitNamedElement(o);
  }

  public void visitTypedRecordFields(@Nonnull ErlangTypedRecordFields o) {
    visitCompositeElement(o);
  }

  public void visitNamedElement(@Nonnull ErlangNamedElement o) {
    visitCompositeElement(o);
  }

  public void visitCompositeElement(@Nonnull ErlangCompositeElement o) {
    visitElement(o);
  }

}
