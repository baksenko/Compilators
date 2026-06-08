// Generated from compiler/parser/Proto3.g4 by ANTLR 4.13.2
package compiler.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Proto3Parser}.
 */
public interface Proto3Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#proto}.
	 * @param ctx the parse tree
	 */
	void enterProto(Proto3Parser.ProtoContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#proto}.
	 * @param ctx the parse tree
	 */
	void exitProto(Proto3Parser.ProtoContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#topLevelItem}.
	 * @param ctx the parse tree
	 */
	void enterTopLevelItem(Proto3Parser.TopLevelItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#topLevelItem}.
	 * @param ctx the parse tree
	 */
	void exitTopLevelItem(Proto3Parser.TopLevelItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(Proto3Parser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(Proto3Parser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#syntaxStatement}.
	 * @param ctx the parse tree
	 */
	void enterSyntaxStatement(Proto3Parser.SyntaxStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#syntaxStatement}.
	 * @param ctx the parse tree
	 */
	void exitSyntaxStatement(Proto3Parser.SyntaxStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterImportStatement(Proto3Parser.ImportStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitImportStatement(Proto3Parser.ImportStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#importModifier}.
	 * @param ctx the parse tree
	 */
	void enterImportModifier(Proto3Parser.ImportModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#importModifier}.
	 * @param ctx the parse tree
	 */
	void exitImportModifier(Proto3Parser.ImportModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#packageStatement}.
	 * @param ctx the parse tree
	 */
	void enterPackageStatement(Proto3Parser.PackageStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#packageStatement}.
	 * @param ctx the parse tree
	 */
	void exitPackageStatement(Proto3Parser.PackageStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#optionStatement}.
	 * @param ctx the parse tree
	 */
	void enterOptionStatement(Proto3Parser.OptionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#optionStatement}.
	 * @param ctx the parse tree
	 */
	void exitOptionStatement(Proto3Parser.OptionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#fullIdent}.
	 * @param ctx the parse tree
	 */
	void enterFullIdent(Proto3Parser.FullIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#fullIdent}.
	 * @param ctx the parse tree
	 */
	void exitFullIdent(Proto3Parser.FullIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#optionName}.
	 * @param ctx the parse tree
	 */
	void enterOptionName(Proto3Parser.OptionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#optionName}.
	 * @param ctx the parse tree
	 */
	void exitOptionName(Proto3Parser.OptionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#optionNamePart}.
	 * @param ctx the parse tree
	 */
	void enterOptionNamePart(Proto3Parser.OptionNamePartContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#optionNamePart}.
	 * @param ctx the parse tree
	 */
	void exitOptionNamePart(Proto3Parser.OptionNamePartContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#typeReference}.
	 * @param ctx the parse tree
	 */
	void enterTypeReference(Proto3Parser.TypeReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#typeReference}.
	 * @param ctx the parse tree
	 */
	void exitTypeReference(Proto3Parser.TypeReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(Proto3Parser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(Proto3Parser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#type_}.
	 * @param ctx the parse tree
	 */
	void enterType_(Proto3Parser.Type_Context ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#type_}.
	 * @param ctx the parse tree
	 */
	void exitType_(Proto3Parser.Type_Context ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#scalarType}.
	 * @param ctx the parse tree
	 */
	void enterScalarType(Proto3Parser.ScalarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#scalarType}.
	 * @param ctx the parse tree
	 */
	void exitScalarType(Proto3Parser.ScalarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#keyType}.
	 * @param ctx the parse tree
	 */
	void enterKeyType(Proto3Parser.KeyTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#keyType}.
	 * @param ctx the parse tree
	 */
	void exitKeyType(Proto3Parser.KeyTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#fieldNumber}.
	 * @param ctx the parse tree
	 */
	void enterFieldNumber(Proto3Parser.FieldNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#fieldNumber}.
	 * @param ctx the parse tree
	 */
	void exitFieldNumber(Proto3Parser.FieldNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(Proto3Parser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(Proto3Parser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void enterFieldModifier(Proto3Parser.FieldModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void exitFieldModifier(Proto3Parser.FieldModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#fieldOptions}.
	 * @param ctx the parse tree
	 */
	void enterFieldOptions(Proto3Parser.FieldOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#fieldOptions}.
	 * @param ctx the parse tree
	 */
	void exitFieldOptions(Proto3Parser.FieldOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#fieldOption}.
	 * @param ctx the parse tree
	 */
	void enterFieldOption(Proto3Parser.FieldOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#fieldOption}.
	 * @param ctx the parse tree
	 */
	void exitFieldOption(Proto3Parser.FieldOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#oneofDef}.
	 * @param ctx the parse tree
	 */
	void enterOneofDef(Proto3Parser.OneofDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#oneofDef}.
	 * @param ctx the parse tree
	 */
	void exitOneofDef(Proto3Parser.OneofDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#oneofItem}.
	 * @param ctx the parse tree
	 */
	void enterOneofItem(Proto3Parser.OneofItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#oneofItem}.
	 * @param ctx the parse tree
	 */
	void exitOneofItem(Proto3Parser.OneofItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#oneofField}.
	 * @param ctx the parse tree
	 */
	void enterOneofField(Proto3Parser.OneofFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#oneofField}.
	 * @param ctx the parse tree
	 */
	void exitOneofField(Proto3Parser.OneofFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#mapField}.
	 * @param ctx the parse tree
	 */
	void enterMapField(Proto3Parser.MapFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#mapField}.
	 * @param ctx the parse tree
	 */
	void exitMapField(Proto3Parser.MapFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#reserved}.
	 * @param ctx the parse tree
	 */
	void enterReserved(Proto3Parser.ReservedContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#reserved}.
	 * @param ctx the parse tree
	 */
	void exitReserved(Proto3Parser.ReservedContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#ranges}.
	 * @param ctx the parse tree
	 */
	void enterRanges(Proto3Parser.RangesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#ranges}.
	 * @param ctx the parse tree
	 */
	void exitRanges(Proto3Parser.RangesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#range_}.
	 * @param ctx the parse tree
	 */
	void enterRange_(Proto3Parser.Range_Context ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#range_}.
	 * @param ctx the parse tree
	 */
	void exitRange_(Proto3Parser.Range_Context ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#fieldNames}.
	 * @param ctx the parse tree
	 */
	void enterFieldNames(Proto3Parser.FieldNamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#fieldNames}.
	 * @param ctx the parse tree
	 */
	void exitFieldNames(Proto3Parser.FieldNamesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#messageDef}.
	 * @param ctx the parse tree
	 */
	void enterMessageDef(Proto3Parser.MessageDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#messageDef}.
	 * @param ctx the parse tree
	 */
	void exitMessageDef(Proto3Parser.MessageDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#messageBody}.
	 * @param ctx the parse tree
	 */
	void enterMessageBody(Proto3Parser.MessageBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#messageBody}.
	 * @param ctx the parse tree
	 */
	void exitMessageBody(Proto3Parser.MessageBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#messageBodyItem}.
	 * @param ctx the parse tree
	 */
	void enterMessageBodyItem(Proto3Parser.MessageBodyItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#messageBodyItem}.
	 * @param ctx the parse tree
	 */
	void exitMessageBodyItem(Proto3Parser.MessageBodyItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#enumDef}.
	 * @param ctx the parse tree
	 */
	void enterEnumDef(Proto3Parser.EnumDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#enumDef}.
	 * @param ctx the parse tree
	 */
	void exitEnumDef(Proto3Parser.EnumDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#enumBody}.
	 * @param ctx the parse tree
	 */
	void enterEnumBody(Proto3Parser.EnumBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#enumBody}.
	 * @param ctx the parse tree
	 */
	void exitEnumBody(Proto3Parser.EnumBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#enumBodyItem}.
	 * @param ctx the parse tree
	 */
	void enterEnumBodyItem(Proto3Parser.EnumBodyItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#enumBodyItem}.
	 * @param ctx the parse tree
	 */
	void exitEnumBodyItem(Proto3Parser.EnumBodyItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#enumField}.
	 * @param ctx the parse tree
	 */
	void enterEnumField(Proto3Parser.EnumFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#enumField}.
	 * @param ctx the parse tree
	 */
	void exitEnumField(Proto3Parser.EnumFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#enumValueOptions}.
	 * @param ctx the parse tree
	 */
	void enterEnumValueOptions(Proto3Parser.EnumValueOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#enumValueOptions}.
	 * @param ctx the parse tree
	 */
	void exitEnumValueOptions(Proto3Parser.EnumValueOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Proto3Parser#enumValueOption}.
	 * @param ctx the parse tree
	 */
	void enterEnumValueOption(Proto3Parser.EnumValueOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Proto3Parser#enumValueOption}.
	 * @param ctx the parse tree
	 */
	void exitEnumValueOption(Proto3Parser.EnumValueOptionContext ctx);
}