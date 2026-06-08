// Generated from compiler/parser/Proto3.g4 by ANTLR 4.13.2
package compiler.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Proto3Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Proto3Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#proto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProto(Proto3Parser.ProtoContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#topLevelItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopLevelItem(Proto3Parser.TopLevelItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(Proto3Parser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#syntaxStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyntaxStatement(Proto3Parser.SyntaxStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStatement(Proto3Parser.ImportStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#importModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportModifier(Proto3Parser.ImportModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#packageStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageStatement(Proto3Parser.PackageStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#optionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionStatement(Proto3Parser.OptionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#fullIdent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullIdent(Proto3Parser.FullIdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#optionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionName(Proto3Parser.OptionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#optionNamePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionNamePart(Proto3Parser.OptionNamePartContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#typeReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeReference(Proto3Parser.TypeReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(Proto3Parser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#type_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_(Proto3Parser.Type_Context ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#scalarType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScalarType(Proto3Parser.ScalarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#keyType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyType(Proto3Parser.KeyTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#fieldNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldNumber(Proto3Parser.FieldNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(Proto3Parser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#fieldModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldModifier(Proto3Parser.FieldModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#fieldOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldOptions(Proto3Parser.FieldOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#fieldOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldOption(Proto3Parser.FieldOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#oneofDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneofDef(Proto3Parser.OneofDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#oneofItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneofItem(Proto3Parser.OneofItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#oneofField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneofField(Proto3Parser.OneofFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#mapField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapField(Proto3Parser.MapFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#reserved}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReserved(Proto3Parser.ReservedContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#ranges}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRanges(Proto3Parser.RangesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#range_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange_(Proto3Parser.Range_Context ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#fieldNames}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldNames(Proto3Parser.FieldNamesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#messageDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageDef(Proto3Parser.MessageDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#messageBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageBody(Proto3Parser.MessageBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#messageBodyItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageBodyItem(Proto3Parser.MessageBodyItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#enumDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDef(Proto3Parser.EnumDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#enumBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBody(Proto3Parser.EnumBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#enumBodyItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBodyItem(Proto3Parser.EnumBodyItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#enumField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumField(Proto3Parser.EnumFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#enumValueOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumValueOptions(Proto3Parser.EnumValueOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Proto3Parser#enumValueOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumValueOption(Proto3Parser.EnumValueOptionContext ctx);
}