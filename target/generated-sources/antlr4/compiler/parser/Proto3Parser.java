// Generated from compiler/parser/Proto3.g4 by ANTLR 4.13.2
package compiler.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class Proto3Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SYNTAX=1, IMPORT=2, PACKAGE=3, OPTION=4, MESSAGE=5, ENUM=6, REPEATED=7, 
		OPTIONAL=8, ONEOF=9, MAP=10, RESERVED=11, TO=12, MAX=13, PUBLIC=14, WEAK=15, 
		DOUBLE=16, FLOAT=17, INT32=18, INT64=19, UINT32=20, UINT64=21, SINT32=22, 
		SINT64=23, FIXED32=24, FIXED64=25, SFIXED32=26, SFIXED64=27, BOOL=28, 
		STRING=29, BYTES=30, TRUE=31, FALSE=32, LBRACE=33, RBRACE=34, LPAREN=35, 
		RPAREN=36, LBRACKET=37, RBRACKET=38, LANGLE=39, RANGLE=40, SEMI=41, COMMA=42, 
		DOT=43, EQ=44, MINUS=45, PLUS=46, STRING_LITERAL=47, FLOAT_LITERAL=48, 
		INTEGER_LITERAL=49, IDENTIFIER=50, LINE_COMMENT=51, BLOCK_COMMENT=52, 
		WS=53;
	public static final int
		RULE_proto = 0, RULE_topLevelItem = 1, RULE_emptyStatement = 2, RULE_syntaxStatement = 3, 
		RULE_importStatement = 4, RULE_importModifier = 5, RULE_packageStatement = 6, 
		RULE_optionStatement = 7, RULE_fullIdent = 8, RULE_optionName = 9, RULE_optionNamePart = 10, 
		RULE_typeReference = 11, RULE_constant = 12, RULE_type_ = 13, RULE_scalarType = 14, 
		RULE_keyType = 15, RULE_fieldNumber = 16, RULE_field = 17, RULE_fieldModifier = 18, 
		RULE_fieldOptions = 19, RULE_fieldOption = 20, RULE_oneofDef = 21, RULE_oneofItem = 22, 
		RULE_oneofField = 23, RULE_mapField = 24, RULE_reserved = 25, RULE_ranges = 26, 
		RULE_range_ = 27, RULE_fieldNames = 28, RULE_messageDef = 29, RULE_messageBody = 30, 
		RULE_messageBodyItem = 31, RULE_enumDef = 32, RULE_enumBody = 33, RULE_enumBodyItem = 34, 
		RULE_enumField = 35, RULE_enumValueOptions = 36, RULE_enumValueOption = 37;
	private static String[] makeRuleNames() {
		return new String[] {
			"proto", "topLevelItem", "emptyStatement", "syntaxStatement", "importStatement", 
			"importModifier", "packageStatement", "optionStatement", "fullIdent", 
			"optionName", "optionNamePart", "typeReference", "constant", "type_", 
			"scalarType", "keyType", "fieldNumber", "field", "fieldModifier", "fieldOptions", 
			"fieldOption", "oneofDef", "oneofItem", "oneofField", "mapField", "reserved", 
			"ranges", "range_", "fieldNames", "messageDef", "messageBody", "messageBodyItem", 
			"enumDef", "enumBody", "enumBodyItem", "enumField", "enumValueOptions", 
			"enumValueOption"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'syntax'", "'import'", "'package'", "'option'", "'message'", "'enum'", 
			"'repeated'", "'optional'", "'oneof'", "'map'", "'reserved'", "'to'", 
			"'max'", "'public'", "'weak'", "'double'", "'float'", "'int32'", "'int64'", 
			"'uint32'", "'uint64'", "'sint32'", "'sint64'", "'fixed32'", "'fixed64'", 
			"'sfixed32'", "'sfixed64'", "'bool'", "'string'", "'bytes'", "'true'", 
			"'false'", "'{'", "'}'", "'('", "')'", "'['", "']'", "'<'", "'>'", "';'", 
			"','", "'.'", "'='", "'-'", "'+'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SYNTAX", "IMPORT", "PACKAGE", "OPTION", "MESSAGE", "ENUM", "REPEATED", 
			"OPTIONAL", "ONEOF", "MAP", "RESERVED", "TO", "MAX", "PUBLIC", "WEAK", 
			"DOUBLE", "FLOAT", "INT32", "INT64", "UINT32", "UINT64", "SINT32", "SINT64", 
			"FIXED32", "FIXED64", "SFIXED32", "SFIXED64", "BOOL", "STRING", "BYTES", 
			"TRUE", "FALSE", "LBRACE", "RBRACE", "LPAREN", "RPAREN", "LBRACKET", 
			"RBRACKET", "LANGLE", "RANGLE", "SEMI", "COMMA", "DOT", "EQ", "MINUS", 
			"PLUS", "STRING_LITERAL", "FLOAT_LITERAL", "INTEGER_LITERAL", "IDENTIFIER", 
			"LINE_COMMENT", "BLOCK_COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Proto3.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Proto3Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProtoContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Proto3Parser.EOF, 0); }
		public SyntaxStatementContext syntaxStatement() {
			return getRuleContext(SyntaxStatementContext.class,0);
		}
		public List<TopLevelItemContext> topLevelItem() {
			return getRuleContexts(TopLevelItemContext.class);
		}
		public TopLevelItemContext topLevelItem(int i) {
			return getRuleContext(TopLevelItemContext.class,i);
		}
		public ProtoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterProto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitProto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitProto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProtoContext proto() throws RecognitionException {
		ProtoContext _localctx = new ProtoContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_proto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SYNTAX) {
				{
				setState(76);
				syntaxStatement();
				}
			}

			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2199023255676L) != 0)) {
				{
				{
				setState(79);
				topLevelItem();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TopLevelItemContext extends ParserRuleContext {
		public ImportStatementContext importStatement() {
			return getRuleContext(ImportStatementContext.class,0);
		}
		public PackageStatementContext packageStatement() {
			return getRuleContext(PackageStatementContext.class,0);
		}
		public OptionStatementContext optionStatement() {
			return getRuleContext(OptionStatementContext.class,0);
		}
		public MessageDefContext messageDef() {
			return getRuleContext(MessageDefContext.class,0);
		}
		public EnumDefContext enumDef() {
			return getRuleContext(EnumDefContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public TopLevelItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topLevelItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterTopLevelItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitTopLevelItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitTopLevelItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TopLevelItemContext topLevelItem() throws RecognitionException {
		TopLevelItemContext _localctx = new TopLevelItemContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_topLevelItem);
		try {
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IMPORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				importStatement();
				}
				break;
			case PACKAGE:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				packageStatement();
				}
				break;
			case OPTION:
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				optionStatement();
				}
				break;
			case MESSAGE:
				enterOuterAlt(_localctx, 4);
				{
				setState(90);
				messageDef();
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 5);
				{
				setState(91);
				enumDef();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 6);
				{
				setState(92);
				emptyStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EmptyStatementContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(Proto3Parser.SEMI, 0); }
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitEmptyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SyntaxStatementContext extends ParserRuleContext {
		public TerminalNode SYNTAX() { return getToken(Proto3Parser.SYNTAX, 0); }
		public TerminalNode EQ() { return getToken(Proto3Parser.EQ, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(Proto3Parser.STRING_LITERAL, 0); }
		public TerminalNode SEMI() { return getToken(Proto3Parser.SEMI, 0); }
		public SyntaxStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syntaxStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterSyntaxStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitSyntaxStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitSyntaxStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SyntaxStatementContext syntaxStatement() throws RecognitionException {
		SyntaxStatementContext _localctx = new SyntaxStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_syntaxStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(SYNTAX);
			setState(98);
			match(EQ);
			setState(99);
			match(STRING_LITERAL);
			setState(100);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportStatementContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(Proto3Parser.IMPORT, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(Proto3Parser.STRING_LITERAL, 0); }
		public TerminalNode SEMI() { return getToken(Proto3Parser.SEMI, 0); }
		public ImportModifierContext importModifier() {
			return getRuleContext(ImportModifierContext.class,0);
		}
		public ImportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterImportStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitImportStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitImportStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportStatementContext importStatement() throws RecognitionException {
		ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_importStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(IMPORT);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUBLIC || _la==WEAK) {
				{
				setState(103);
				importModifier();
				}
			}

			setState(106);
			match(STRING_LITERAL);
			setState(107);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportModifierContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(Proto3Parser.PUBLIC, 0); }
		public TerminalNode WEAK() { return getToken(Proto3Parser.WEAK, 0); }
		public ImportModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterImportModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitImportModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitImportModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportModifierContext importModifier() throws RecognitionException {
		ImportModifierContext _localctx = new ImportModifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_importModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_la = _input.LA(1);
			if ( !(_la==PUBLIC || _la==WEAK) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PackageStatementContext extends ParserRuleContext {
		public TerminalNode PACKAGE() { return getToken(Proto3Parser.PACKAGE, 0); }
		public FullIdentContext fullIdent() {
			return getRuleContext(FullIdentContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Proto3Parser.SEMI, 0); }
		public PackageStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterPackageStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitPackageStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitPackageStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageStatementContext packageStatement() throws RecognitionException {
		PackageStatementContext _localctx = new PackageStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_packageStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(PACKAGE);
			setState(112);
			fullIdent();
			setState(113);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OptionStatementContext extends ParserRuleContext {
		public TerminalNode OPTION() { return getToken(Proto3Parser.OPTION, 0); }
		public OptionNameContext optionName() {
			return getRuleContext(OptionNameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(Proto3Parser.EQ, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Proto3Parser.SEMI, 0); }
		public OptionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterOptionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitOptionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitOptionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionStatementContext optionStatement() throws RecognitionException {
		OptionStatementContext _localctx = new OptionStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_optionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(OPTION);
			setState(116);
			optionName();
			setState(117);
			match(EQ);
			setState(118);
			constant();
			setState(119);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FullIdentContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(Proto3Parser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(Proto3Parser.IDENTIFIER, i);
		}
		public List<TerminalNode> DOT() { return getTokens(Proto3Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Proto3Parser.DOT, i);
		}
		public FullIdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullIdent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterFullIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitFullIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitFullIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullIdentContext fullIdent() throws RecognitionException {
		FullIdentContext _localctx = new FullIdentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fullIdent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(IDENTIFIER);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(122);
				match(DOT);
				setState(123);
				match(IDENTIFIER);
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OptionNameContext extends ParserRuleContext {
		public List<OptionNamePartContext> optionNamePart() {
			return getRuleContexts(OptionNamePartContext.class);
		}
		public OptionNamePartContext optionNamePart(int i) {
			return getRuleContext(OptionNamePartContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(Proto3Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Proto3Parser.DOT, i);
		}
		public OptionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterOptionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitOptionName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitOptionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionNameContext optionName() throws RecognitionException {
		OptionNameContext _localctx = new OptionNameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_optionName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			optionNamePart();
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(130);
				match(DOT);
				setState(131);
				optionNamePart();
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OptionNamePartContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(Proto3Parser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(Proto3Parser.LPAREN, 0); }
		public FullIdentContext fullIdent() {
			return getRuleContext(FullIdentContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Proto3Parser.RPAREN, 0); }
		public TerminalNode DOT() { return getToken(Proto3Parser.DOT, 0); }
		public OptionNamePartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionNamePart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterOptionNamePart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitOptionNamePart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitOptionNamePart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionNamePartContext optionNamePart() throws RecognitionException {
		OptionNamePartContext _localctx = new OptionNamePartContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_optionNamePart);
		int _la;
		try {
			setState(145);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				match(IDENTIFIER);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				match(LPAREN);
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(139);
					match(DOT);
					}
				}

				setState(142);
				fullIdent();
				setState(143);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeReferenceContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(Proto3Parser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(Proto3Parser.IDENTIFIER, i);
		}
		public List<TerminalNode> DOT() { return getTokens(Proto3Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Proto3Parser.DOT, i);
		}
		public TypeReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterTypeReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitTypeReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitTypeReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeReferenceContext typeReference() throws RecognitionException {
		TypeReferenceContext _localctx = new TypeReferenceContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_typeReference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(147);
				match(DOT);
				}
			}

			setState(150);
			match(IDENTIFIER);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(151);
				match(DOT);
				setState(152);
				match(IDENTIFIER);
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantContext extends ParserRuleContext {
		public FullIdentContext fullIdent() {
			return getRuleContext(FullIdentContext.class,0);
		}
		public TerminalNode INTEGER_LITERAL() { return getToken(Proto3Parser.INTEGER_LITERAL, 0); }
		public TerminalNode MINUS() { return getToken(Proto3Parser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(Proto3Parser.PLUS, 0); }
		public TerminalNode FLOAT_LITERAL() { return getToken(Proto3Parser.FLOAT_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(Proto3Parser.STRING_LITERAL, 0); }
		public TerminalNode TRUE() { return getToken(Proto3Parser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(Proto3Parser.FALSE, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_constant);
		int _la;
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				fullIdent();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS || _la==PLUS) {
					{
					setState(159);
					_la = _input.LA(1);
					if ( !(_la==MINUS || _la==PLUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(162);
				match(INTEGER_LITERAL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS || _la==PLUS) {
					{
					setState(163);
					_la = _input.LA(1);
					if ( !(_la==MINUS || _la==PLUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(166);
				match(FLOAT_LITERAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(167);
				match(STRING_LITERAL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(168);
				match(TRUE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(169);
				match(FALSE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_Context extends ParserRuleContext {
		public ScalarTypeContext scalarType() {
			return getRuleContext(ScalarTypeContext.class,0);
		}
		public TypeReferenceContext typeReference() {
			return getRuleContext(TypeReferenceContext.class,0);
		}
		public Type_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterType_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitType_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitType_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_Context type_() throws RecognitionException {
		Type_Context _localctx = new Type_Context(_ctx, getState());
		enterRule(_localctx, 26, RULE_type_);
		try {
			setState(174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE:
			case FLOAT:
			case INT32:
			case INT64:
			case UINT32:
			case UINT64:
			case SINT32:
			case SINT64:
			case FIXED32:
			case FIXED64:
			case SFIXED32:
			case SFIXED64:
			case BOOL:
			case STRING:
			case BYTES:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				scalarType();
				}
				break;
			case DOT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				typeReference();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ScalarTypeContext extends ParserRuleContext {
		public TerminalNode DOUBLE() { return getToken(Proto3Parser.DOUBLE, 0); }
		public TerminalNode FLOAT() { return getToken(Proto3Parser.FLOAT, 0); }
		public TerminalNode INT32() { return getToken(Proto3Parser.INT32, 0); }
		public TerminalNode INT64() { return getToken(Proto3Parser.INT64, 0); }
		public TerminalNode UINT32() { return getToken(Proto3Parser.UINT32, 0); }
		public TerminalNode UINT64() { return getToken(Proto3Parser.UINT64, 0); }
		public TerminalNode SINT32() { return getToken(Proto3Parser.SINT32, 0); }
		public TerminalNode SINT64() { return getToken(Proto3Parser.SINT64, 0); }
		public TerminalNode FIXED32() { return getToken(Proto3Parser.FIXED32, 0); }
		public TerminalNode FIXED64() { return getToken(Proto3Parser.FIXED64, 0); }
		public TerminalNode SFIXED32() { return getToken(Proto3Parser.SFIXED32, 0); }
		public TerminalNode SFIXED64() { return getToken(Proto3Parser.SFIXED64, 0); }
		public TerminalNode BOOL() { return getToken(Proto3Parser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(Proto3Parser.STRING, 0); }
		public TerminalNode BYTES() { return getToken(Proto3Parser.BYTES, 0); }
		public ScalarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalarType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterScalarType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitScalarType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitScalarType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScalarTypeContext scalarType() throws RecognitionException {
		ScalarTypeContext _localctx = new ScalarTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_scalarType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2147418112L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KeyTypeContext extends ParserRuleContext {
		public TerminalNode INT32() { return getToken(Proto3Parser.INT32, 0); }
		public TerminalNode INT64() { return getToken(Proto3Parser.INT64, 0); }
		public TerminalNode UINT32() { return getToken(Proto3Parser.UINT32, 0); }
		public TerminalNode UINT64() { return getToken(Proto3Parser.UINT64, 0); }
		public TerminalNode SINT32() { return getToken(Proto3Parser.SINT32, 0); }
		public TerminalNode SINT64() { return getToken(Proto3Parser.SINT64, 0); }
		public TerminalNode FIXED32() { return getToken(Proto3Parser.FIXED32, 0); }
		public TerminalNode FIXED64() { return getToken(Proto3Parser.FIXED64, 0); }
		public TerminalNode SFIXED32() { return getToken(Proto3Parser.SFIXED32, 0); }
		public TerminalNode SFIXED64() { return getToken(Proto3Parser.SFIXED64, 0); }
		public TerminalNode BOOL() { return getToken(Proto3Parser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(Proto3Parser.STRING, 0); }
		public KeyTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterKeyType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitKeyType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitKeyType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyTypeContext keyType() throws RecognitionException {
		KeyTypeContext _localctx = new KeyTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_keyType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1073479680L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldNumberContext extends ParserRuleContext {
		public TerminalNode INTEGER_LITERAL() { return getToken(Proto3Parser.INTEGER_LITERAL, 0); }
		public FieldNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterFieldNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitFieldNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitFieldNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldNumberContext fieldNumber() throws RecognitionException {
		FieldNumberContext _localctx = new FieldNumberContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_fieldNumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(INTEGER_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldContext extends ParserRuleContext {
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(Proto3Parser.IDENTIFIER, 0); }
		public TerminalNode EQ() { return getToken(Proto3Parser.EQ, 0); }
		public FieldNumberContext fieldNumber() {
			return getRuleContext(FieldNumberContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Proto3Parser.SEMI, 0); }
		public FieldModifierContext fieldModifier() {
			return getRuleContext(FieldModifierContext.class,0);
		}
		public FieldOptionsContext fieldOptions() {
			return getRuleContext(FieldOptionsContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==REPEATED || _la==OPTIONAL) {
				{
				setState(182);
				fieldModifier();
				}
			}

			setState(185);
			type_();
			setState(186);
			match(IDENTIFIER);
			setState(187);
			match(EQ);
			setState(188);
			fieldNumber();
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(189);
				fieldOptions();
				}
			}

			setState(192);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldModifierContext extends ParserRuleContext {
		public TerminalNode REPEATED() { return getToken(Proto3Parser.REPEATED, 0); }
		public TerminalNode OPTIONAL() { return getToken(Proto3Parser.OPTIONAL, 0); }
		public FieldModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterFieldModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitFieldModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitFieldModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldModifierContext fieldModifier() throws RecognitionException {
		FieldModifierContext _localctx = new FieldModifierContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_fieldModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_la = _input.LA(1);
			if ( !(_la==REPEATED || _la==OPTIONAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldOptionsContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(Proto3Parser.LBRACKET, 0); }
		public List<FieldOptionContext> fieldOption() {
			return getRuleContexts(FieldOptionContext.class);
		}
		public FieldOptionContext fieldOption(int i) {
			return getRuleContext(FieldOptionContext.class,i);
		}
		public TerminalNode RBRACKET() { return getToken(Proto3Parser.RBRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(Proto3Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Proto3Parser.COMMA, i);
		}
		public FieldOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterFieldOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitFieldOptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitFieldOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldOptionsContext fieldOptions() throws RecognitionException {
		FieldOptionsContext _localctx = new FieldOptionsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_fieldOptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(LBRACKET);
			setState(197);
			fieldOption();
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(198);
				match(COMMA);
				setState(199);
				fieldOption();
				}
				}
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(205);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldOptionContext extends ParserRuleContext {
		public OptionNameContext optionName() {
			return getRuleContext(OptionNameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(Proto3Parser.EQ, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public FieldOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterFieldOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitFieldOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitFieldOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldOptionContext fieldOption() throws RecognitionException {
		FieldOptionContext _localctx = new FieldOptionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_fieldOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			optionName();
			setState(208);
			match(EQ);
			setState(209);
			constant();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OneofDefContext extends ParserRuleContext {
		public TerminalNode ONEOF() { return getToken(Proto3Parser.ONEOF, 0); }
		public TerminalNode IDENTIFIER() { return getToken(Proto3Parser.IDENTIFIER, 0); }
		public TerminalNode LBRACE() { return getToken(Proto3Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Proto3Parser.RBRACE, 0); }
		public List<OneofItemContext> oneofItem() {
			return getRuleContexts(OneofItemContext.class);
		}
		public OneofItemContext oneofItem(int i) {
			return getRuleContext(OneofItemContext.class,i);
		}
		public OneofDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oneofDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterOneofDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitOneofDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitOneofDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OneofDefContext oneofDef() throws RecognitionException {
		OneofDefContext _localctx = new OneofDefContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_oneofDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(ONEOF);
			setState(212);
			match(IDENTIFIER);
			setState(213);
			match(LBRACE);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1136897170538512L) != 0)) {
				{
				{
				setState(214);
				oneofItem();
				}
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(220);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OneofItemContext extends ParserRuleContext {
		public OptionStatementContext optionStatement() {
			return getRuleContext(OptionStatementContext.class,0);
		}
		public OneofFieldContext oneofField() {
			return getRuleContext(OneofFieldContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public OneofItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oneofItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterOneofItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitOneofItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitOneofItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OneofItemContext oneofItem() throws RecognitionException {
		OneofItemContext _localctx = new OneofItemContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_oneofItem);
		try {
			setState(225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				optionStatement();
				}
				break;
			case DOUBLE:
			case FLOAT:
			case INT32:
			case INT64:
			case UINT32:
			case UINT64:
			case SINT32:
			case SINT64:
			case FIXED32:
			case FIXED64:
			case SFIXED32:
			case SFIXED64:
			case BOOL:
			case STRING:
			case BYTES:
			case DOT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				oneofField();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				emptyStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OneofFieldContext extends ParserRuleContext {
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(Proto3Parser.IDENTIFIER, 0); }
		public TerminalNode EQ() { return getToken(Proto3Parser.EQ, 0); }
		public FieldNumberContext fieldNumber() {
			return getRuleContext(FieldNumberContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Proto3Parser.SEMI, 0); }
		public FieldOptionsContext fieldOptions() {
			return getRuleContext(FieldOptionsContext.class,0);
		}
		public OneofFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oneofField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterOneofField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitOneofField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitOneofField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OneofFieldContext oneofField() throws RecognitionException {
		OneofFieldContext _localctx = new OneofFieldContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_oneofField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			type_();
			setState(228);
			match(IDENTIFIER);
			setState(229);
			match(EQ);
			setState(230);
			fieldNumber();
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(231);
				fieldOptions();
				}
			}

			setState(234);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MapFieldContext extends ParserRuleContext {
		public TerminalNode MAP() { return getToken(Proto3Parser.MAP, 0); }
		public TerminalNode LANGLE() { return getToken(Proto3Parser.LANGLE, 0); }
		public KeyTypeContext keyType() {
			return getRuleContext(KeyTypeContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(Proto3Parser.COMMA, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode RANGLE() { return getToken(Proto3Parser.RANGLE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(Proto3Parser.IDENTIFIER, 0); }
		public TerminalNode EQ() { return getToken(Proto3Parser.EQ, 0); }
		public FieldNumberContext fieldNumber() {
			return getRuleContext(FieldNumberContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Proto3Parser.SEMI, 0); }
		public FieldOptionsContext fieldOptions() {
			return getRuleContext(FieldOptionsContext.class,0);
		}
		public MapFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterMapField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitMapField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitMapField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapFieldContext mapField() throws RecognitionException {
		MapFieldContext _localctx = new MapFieldContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_mapField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(MAP);
			setState(237);
			match(LANGLE);
			setState(238);
			keyType();
			setState(239);
			match(COMMA);
			setState(240);
			type_();
			setState(241);
			match(RANGLE);
			setState(242);
			match(IDENTIFIER);
			setState(243);
			match(EQ);
			setState(244);
			fieldNumber();
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(245);
				fieldOptions();
				}
			}

			setState(248);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReservedContext extends ParserRuleContext {
		public TerminalNode RESERVED() { return getToken(Proto3Parser.RESERVED, 0); }
		public TerminalNode SEMI() { return getToken(Proto3Parser.SEMI, 0); }
		public RangesContext ranges() {
			return getRuleContext(RangesContext.class,0);
		}
		public FieldNamesContext fieldNames() {
			return getRuleContext(FieldNamesContext.class,0);
		}
		public ReservedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reserved; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterReserved(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitReserved(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitReserved(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReservedContext reserved() throws RecognitionException {
		ReservedContext _localctx = new ReservedContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_reserved);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(RESERVED);
			setState(253);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER_LITERAL:
				{
				setState(251);
				ranges();
				}
				break;
			case STRING_LITERAL:
				{
				setState(252);
				fieldNames();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(255);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RangesContext extends ParserRuleContext {
		public List<Range_Context> range_() {
			return getRuleContexts(Range_Context.class);
		}
		public Range_Context range_(int i) {
			return getRuleContext(Range_Context.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Proto3Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Proto3Parser.COMMA, i);
		}
		public RangesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ranges; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterRanges(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitRanges(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitRanges(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangesContext ranges() throws RecognitionException {
		RangesContext _localctx = new RangesContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_ranges);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			range_();
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(258);
				match(COMMA);
				setState(259);
				range_();
				}
				}
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Range_Context extends ParserRuleContext {
		public List<TerminalNode> INTEGER_LITERAL() { return getTokens(Proto3Parser.INTEGER_LITERAL); }
		public TerminalNode INTEGER_LITERAL(int i) {
			return getToken(Proto3Parser.INTEGER_LITERAL, i);
		}
		public TerminalNode TO() { return getToken(Proto3Parser.TO, 0); }
		public TerminalNode MAX() { return getToken(Proto3Parser.MAX, 0); }
		public Range_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterRange_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitRange_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitRange_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Range_Context range_() throws RecognitionException {
		Range_Context _localctx = new Range_Context(_ctx, getState());
		enterRule(_localctx, 54, RULE_range_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(INTEGER_LITERAL);
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(266);
				match(TO);
				setState(267);
				_la = _input.LA(1);
				if ( !(_la==MAX || _la==INTEGER_LITERAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldNamesContext extends ParserRuleContext {
		public List<TerminalNode> STRING_LITERAL() { return getTokens(Proto3Parser.STRING_LITERAL); }
		public TerminalNode STRING_LITERAL(int i) {
			return getToken(Proto3Parser.STRING_LITERAL, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Proto3Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Proto3Parser.COMMA, i);
		}
		public FieldNamesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldNames; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterFieldNames(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitFieldNames(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitFieldNames(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldNamesContext fieldNames() throws RecognitionException {
		FieldNamesContext _localctx = new FieldNamesContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_fieldNames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(STRING_LITERAL);
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(271);
				match(COMMA);
				setState(272);
				match(STRING_LITERAL);
				}
				}
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MessageDefContext extends ParserRuleContext {
		public TerminalNode MESSAGE() { return getToken(Proto3Parser.MESSAGE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(Proto3Parser.IDENTIFIER, 0); }
		public MessageBodyContext messageBody() {
			return getRuleContext(MessageBodyContext.class,0);
		}
		public MessageDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterMessageDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitMessageDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitMessageDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageDefContext messageDef() throws RecognitionException {
		MessageDefContext _localctx = new MessageDefContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_messageDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(MESSAGE);
			setState(279);
			match(IDENTIFIER);
			setState(280);
			messageBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MessageBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Proto3Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Proto3Parser.RBRACE, 0); }
		public List<MessageBodyItemContext> messageBodyItem() {
			return getRuleContexts(MessageBodyItemContext.class);
		}
		public MessageBodyItemContext messageBodyItem(int i) {
			return getRuleContext(MessageBodyItemContext.class,i);
		}
		public MessageBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterMessageBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitMessageBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitMessageBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageBodyContext messageBody() throws RecognitionException {
		MessageBodyContext _localctx = new MessageBodyContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_messageBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			match(LBRACE);
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1136897170542576L) != 0)) {
				{
				{
				setState(283);
				messageBodyItem();
				}
				}
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(289);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MessageBodyItemContext extends ParserRuleContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public EnumDefContext enumDef() {
			return getRuleContext(EnumDefContext.class,0);
		}
		public MessageDefContext messageDef() {
			return getRuleContext(MessageDefContext.class,0);
		}
		public OptionStatementContext optionStatement() {
			return getRuleContext(OptionStatementContext.class,0);
		}
		public OneofDefContext oneofDef() {
			return getRuleContext(OneofDefContext.class,0);
		}
		public MapFieldContext mapField() {
			return getRuleContext(MapFieldContext.class,0);
		}
		public ReservedContext reserved() {
			return getRuleContext(ReservedContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public MessageBodyItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageBodyItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterMessageBodyItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitMessageBodyItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitMessageBodyItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageBodyItemContext messageBodyItem() throws RecognitionException {
		MessageBodyItemContext _localctx = new MessageBodyItemContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_messageBodyItem);
		try {
			setState(299);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REPEATED:
			case OPTIONAL:
			case DOUBLE:
			case FLOAT:
			case INT32:
			case INT64:
			case UINT32:
			case UINT64:
			case SINT32:
			case SINT64:
			case FIXED32:
			case FIXED64:
			case SFIXED32:
			case SFIXED64:
			case BOOL:
			case STRING:
			case BYTES:
			case DOT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				field();
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
				enumDef();
				}
				break;
			case MESSAGE:
				enterOuterAlt(_localctx, 3);
				{
				setState(293);
				messageDef();
				}
				break;
			case OPTION:
				enterOuterAlt(_localctx, 4);
				{
				setState(294);
				optionStatement();
				}
				break;
			case ONEOF:
				enterOuterAlt(_localctx, 5);
				{
				setState(295);
				oneofDef();
				}
				break;
			case MAP:
				enterOuterAlt(_localctx, 6);
				{
				setState(296);
				mapField();
				}
				break;
			case RESERVED:
				enterOuterAlt(_localctx, 7);
				{
				setState(297);
				reserved();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 8);
				{
				setState(298);
				emptyStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumDefContext extends ParserRuleContext {
		public TerminalNode ENUM() { return getToken(Proto3Parser.ENUM, 0); }
		public TerminalNode IDENTIFIER() { return getToken(Proto3Parser.IDENTIFIER, 0); }
		public EnumBodyContext enumBody() {
			return getRuleContext(EnumBodyContext.class,0);
		}
		public EnumDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterEnumDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitEnumDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitEnumDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumDefContext enumDef() throws RecognitionException {
		EnumDefContext _localctx = new EnumDefContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_enumDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(ENUM);
			setState(302);
			match(IDENTIFIER);
			setState(303);
			enumBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Proto3Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Proto3Parser.RBRACE, 0); }
		public List<EnumBodyItemContext> enumBodyItem() {
			return getRuleContexts(EnumBodyItemContext.class);
		}
		public EnumBodyItemContext enumBodyItem(int i) {
			return getRuleContext(EnumBodyItemContext.class,i);
		}
		public EnumBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterEnumBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitEnumBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitEnumBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumBodyContext enumBody() throws RecognitionException {
		EnumBodyContext _localctx = new EnumBodyContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_enumBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(LBRACE);
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1128098930100240L) != 0)) {
				{
				{
				setState(306);
				enumBodyItem();
				}
				}
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(312);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumBodyItemContext extends ParserRuleContext {
		public OptionStatementContext optionStatement() {
			return getRuleContext(OptionStatementContext.class,0);
		}
		public EnumFieldContext enumField() {
			return getRuleContext(EnumFieldContext.class,0);
		}
		public ReservedContext reserved() {
			return getRuleContext(ReservedContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public EnumBodyItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBodyItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterEnumBodyItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitEnumBodyItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitEnumBodyItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumBodyItemContext enumBodyItem() throws RecognitionException {
		EnumBodyItemContext _localctx = new EnumBodyItemContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_enumBodyItem);
		try {
			setState(318);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				optionStatement();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				enumField();
				}
				break;
			case RESERVED:
				enterOuterAlt(_localctx, 3);
				{
				setState(316);
				reserved();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 4);
				{
				setState(317);
				emptyStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumFieldContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(Proto3Parser.IDENTIFIER, 0); }
		public TerminalNode EQ() { return getToken(Proto3Parser.EQ, 0); }
		public TerminalNode INTEGER_LITERAL() { return getToken(Proto3Parser.INTEGER_LITERAL, 0); }
		public TerminalNode SEMI() { return getToken(Proto3Parser.SEMI, 0); }
		public TerminalNode MINUS() { return getToken(Proto3Parser.MINUS, 0); }
		public EnumValueOptionsContext enumValueOptions() {
			return getRuleContext(EnumValueOptionsContext.class,0);
		}
		public EnumFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterEnumField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitEnumField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitEnumField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumFieldContext enumField() throws RecognitionException {
		EnumFieldContext _localctx = new EnumFieldContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_enumField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(IDENTIFIER);
			setState(321);
			match(EQ);
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(322);
				match(MINUS);
				}
			}

			setState(325);
			match(INTEGER_LITERAL);
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(326);
				enumValueOptions();
				}
			}

			setState(329);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumValueOptionsContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(Proto3Parser.LBRACKET, 0); }
		public List<EnumValueOptionContext> enumValueOption() {
			return getRuleContexts(EnumValueOptionContext.class);
		}
		public EnumValueOptionContext enumValueOption(int i) {
			return getRuleContext(EnumValueOptionContext.class,i);
		}
		public TerminalNode RBRACKET() { return getToken(Proto3Parser.RBRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(Proto3Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Proto3Parser.COMMA, i);
		}
		public EnumValueOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumValueOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterEnumValueOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitEnumValueOptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitEnumValueOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumValueOptionsContext enumValueOptions() throws RecognitionException {
		EnumValueOptionsContext _localctx = new EnumValueOptionsContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_enumValueOptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(LBRACKET);
			setState(332);
			enumValueOption();
			setState(337);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(333);
				match(COMMA);
				setState(334);
				enumValueOption();
				}
				}
				setState(339);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(340);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumValueOptionContext extends ParserRuleContext {
		public OptionNameContext optionName() {
			return getRuleContext(OptionNameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(Proto3Parser.EQ, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public EnumValueOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumValueOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).enterEnumValueOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Proto3Listener ) ((Proto3Listener)listener).exitEnumValueOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Proto3Visitor ) return ((Proto3Visitor<? extends T>)visitor).visitEnumValueOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumValueOptionContext enumValueOption() throws RecognitionException {
		EnumValueOptionContext _localctx = new EnumValueOptionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_enumValueOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			optionName();
			setState(343);
			match(EQ);
			setState(344);
			constant();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u00015\u015b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0001\u0000\u0003\u0000N\b\u0000"+
		"\u0001\u0000\u0005\u0000Q\b\u0000\n\u0000\f\u0000T\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001^\b\u0001\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0003\u0004i\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0005\b}\b\b\n\b\f\b\u0080\t\b\u0001\t\u0001\t\u0001\t\u0005"+
		"\t\u0085\b\t\n\t\f\t\u0088\t\t\u0001\n\u0001\n\u0001\n\u0003\n\u008d\b"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\n\u0092\b\n\u0001\u000b\u0003\u000b\u0095"+
		"\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u009a\b\u000b"+
		"\n\u000b\f\u000b\u009d\t\u000b\u0001\f\u0001\f\u0003\f\u00a1\b\f\u0001"+
		"\f\u0001\f\u0003\f\u00a5\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00ab"+
		"\b\f\u0001\r\u0001\r\u0003\r\u00af\b\r\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0003\u0011\u00b8\b\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011"+
		"\u00bf\b\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u00c9\b\u0013\n\u0013"+
		"\f\u0013\u00cc\t\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0005\u0015\u00d8\b\u0015\n\u0015\f\u0015\u00db\t\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u00e2\b\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u00e9"+
		"\b\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0003\u0018\u00f7\b\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0003\u0019\u00fe\b\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u0105\b\u001a\n\u001a\f\u001a"+
		"\u0108\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u010d\b"+
		"\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u0112\b\u001c\n"+
		"\u001c\f\u001c\u0115\t\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001e\u0001\u001e\u0005\u001e\u011d\b\u001e\n\u001e\f\u001e"+
		"\u0120\t\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f"+
		"\u012c\b\u001f\u0001 \u0001 \u0001 \u0001 \u0001!\u0001!\u0005!\u0134"+
		"\b!\n!\f!\u0137\t!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0003"+
		"\"\u013f\b\"\u0001#\u0001#\u0001#\u0003#\u0144\b#\u0001#\u0001#\u0003"+
		"#\u0148\b#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0005$\u0150\b$\n"+
		"$\f$\u0153\t$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001%\u0000\u0000"+
		"&\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BDFHJ\u0000\u0006\u0001\u0000\u000e\u000f"+
		"\u0001\u0000-.\u0001\u0000\u0010\u001e\u0001\u0000\u0012\u001d\u0001\u0000"+
		"\u0007\b\u0002\u0000\r\r11\u0165\u0000M\u0001\u0000\u0000\u0000\u0002"+
		"]\u0001\u0000\u0000\u0000\u0004_\u0001\u0000\u0000\u0000\u0006a\u0001"+
		"\u0000\u0000\u0000\bf\u0001\u0000\u0000\u0000\nm\u0001\u0000\u0000\u0000"+
		"\fo\u0001\u0000\u0000\u0000\u000es\u0001\u0000\u0000\u0000\u0010y\u0001"+
		"\u0000\u0000\u0000\u0012\u0081\u0001\u0000\u0000\u0000\u0014\u0091\u0001"+
		"\u0000\u0000\u0000\u0016\u0094\u0001\u0000\u0000\u0000\u0018\u00aa\u0001"+
		"\u0000\u0000\u0000\u001a\u00ae\u0001\u0000\u0000\u0000\u001c\u00b0\u0001"+
		"\u0000\u0000\u0000\u001e\u00b2\u0001\u0000\u0000\u0000 \u00b4\u0001\u0000"+
		"\u0000\u0000\"\u00b7\u0001\u0000\u0000\u0000$\u00c2\u0001\u0000\u0000"+
		"\u0000&\u00c4\u0001\u0000\u0000\u0000(\u00cf\u0001\u0000\u0000\u0000*"+
		"\u00d3\u0001\u0000\u0000\u0000,\u00e1\u0001\u0000\u0000\u0000.\u00e3\u0001"+
		"\u0000\u0000\u00000\u00ec\u0001\u0000\u0000\u00002\u00fa\u0001\u0000\u0000"+
		"\u00004\u0101\u0001\u0000\u0000\u00006\u0109\u0001\u0000\u0000\u00008"+
		"\u010e\u0001\u0000\u0000\u0000:\u0116\u0001\u0000\u0000\u0000<\u011a\u0001"+
		"\u0000\u0000\u0000>\u012b\u0001\u0000\u0000\u0000@\u012d\u0001\u0000\u0000"+
		"\u0000B\u0131\u0001\u0000\u0000\u0000D\u013e\u0001\u0000\u0000\u0000F"+
		"\u0140\u0001\u0000\u0000\u0000H\u014b\u0001\u0000\u0000\u0000J\u0156\u0001"+
		"\u0000\u0000\u0000LN\u0003\u0006\u0003\u0000ML\u0001\u0000\u0000\u0000"+
		"MN\u0001\u0000\u0000\u0000NR\u0001\u0000\u0000\u0000OQ\u0003\u0002\u0001"+
		"\u0000PO\u0001\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000RP\u0001\u0000"+
		"\u0000\u0000RS\u0001\u0000\u0000\u0000SU\u0001\u0000\u0000\u0000TR\u0001"+
		"\u0000\u0000\u0000UV\u0005\u0000\u0000\u0001V\u0001\u0001\u0000\u0000"+
		"\u0000W^\u0003\b\u0004\u0000X^\u0003\f\u0006\u0000Y^\u0003\u000e\u0007"+
		"\u0000Z^\u0003:\u001d\u0000[^\u0003@ \u0000\\^\u0003\u0004\u0002\u0000"+
		"]W\u0001\u0000\u0000\u0000]X\u0001\u0000\u0000\u0000]Y\u0001\u0000\u0000"+
		"\u0000]Z\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]\\\u0001\u0000"+
		"\u0000\u0000^\u0003\u0001\u0000\u0000\u0000_`\u0005)\u0000\u0000`\u0005"+
		"\u0001\u0000\u0000\u0000ab\u0005\u0001\u0000\u0000bc\u0005,\u0000\u0000"+
		"cd\u0005/\u0000\u0000de\u0005)\u0000\u0000e\u0007\u0001\u0000\u0000\u0000"+
		"fh\u0005\u0002\u0000\u0000gi\u0003\n\u0005\u0000hg\u0001\u0000\u0000\u0000"+
		"hi\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jk\u0005/\u0000\u0000"+
		"kl\u0005)\u0000\u0000l\t\u0001\u0000\u0000\u0000mn\u0007\u0000\u0000\u0000"+
		"n\u000b\u0001\u0000\u0000\u0000op\u0005\u0003\u0000\u0000pq\u0003\u0010"+
		"\b\u0000qr\u0005)\u0000\u0000r\r\u0001\u0000\u0000\u0000st\u0005\u0004"+
		"\u0000\u0000tu\u0003\u0012\t\u0000uv\u0005,\u0000\u0000vw\u0003\u0018"+
		"\f\u0000wx\u0005)\u0000\u0000x\u000f\u0001\u0000\u0000\u0000y~\u00052"+
		"\u0000\u0000z{\u0005+\u0000\u0000{}\u00052\u0000\u0000|z\u0001\u0000\u0000"+
		"\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f"+
		"\u0001\u0000\u0000\u0000\u007f\u0011\u0001\u0000\u0000\u0000\u0080~\u0001"+
		"\u0000\u0000\u0000\u0081\u0086\u0003\u0014\n\u0000\u0082\u0083\u0005+"+
		"\u0000\u0000\u0083\u0085\u0003\u0014\n\u0000\u0084\u0082\u0001\u0000\u0000"+
		"\u0000\u0085\u0088\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0013\u0001\u0000\u0000"+
		"\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0089\u0092\u00052\u0000\u0000"+
		"\u008a\u008c\u0005#\u0000\u0000\u008b\u008d\u0005+\u0000\u0000\u008c\u008b"+
		"\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0001\u0000\u0000\u0000\u008e\u008f\u0003\u0010\b\u0000\u008f\u0090\u0005"+
		"$\u0000\u0000\u0090\u0092\u0001\u0000\u0000\u0000\u0091\u0089\u0001\u0000"+
		"\u0000\u0000\u0091\u008a\u0001\u0000\u0000\u0000\u0092\u0015\u0001\u0000"+
		"\u0000\u0000\u0093\u0095\u0005+\u0000\u0000\u0094\u0093\u0001\u0000\u0000"+
		"\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000"+
		"\u0000\u0096\u009b\u00052\u0000\u0000\u0097\u0098\u0005+\u0000\u0000\u0098"+
		"\u009a\u00052\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u009d"+
		"\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009c"+
		"\u0001\u0000\u0000\u0000\u009c\u0017\u0001\u0000\u0000\u0000\u009d\u009b"+
		"\u0001\u0000\u0000\u0000\u009e\u00ab\u0003\u0010\b\u0000\u009f\u00a1\u0007"+
		"\u0001\u0000\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00ab\u0005"+
		"1\u0000\u0000\u00a3\u00a5\u0007\u0001\u0000\u0000\u00a4\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000"+
		"\u0000\u0000\u00a6\u00ab\u00050\u0000\u0000\u00a7\u00ab\u0005/\u0000\u0000"+
		"\u00a8\u00ab\u0005\u001f\u0000\u0000\u00a9\u00ab\u0005 \u0000\u0000\u00aa"+
		"\u009e\u0001\u0000\u0000\u0000\u00aa\u00a0\u0001\u0000\u0000\u0000\u00aa"+
		"\u00a4\u0001\u0000\u0000\u0000\u00aa\u00a7\u0001\u0000\u0000\u0000\u00aa"+
		"\u00a8\u0001\u0000\u0000\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00ab"+
		"\u0019\u0001\u0000\u0000\u0000\u00ac\u00af\u0003\u001c\u000e\u0000\u00ad"+
		"\u00af\u0003\u0016\u000b\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae"+
		"\u00ad\u0001\u0000\u0000\u0000\u00af\u001b\u0001\u0000\u0000\u0000\u00b0"+
		"\u00b1\u0007\u0002\u0000\u0000\u00b1\u001d\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b3\u0007\u0003\u0000\u0000\u00b3\u001f\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b5\u00051\u0000\u0000\u00b5!\u0001\u0000\u0000\u0000\u00b6\u00b8\u0003"+
		"$\u0012\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00ba\u0003\u001a"+
		"\r\u0000\u00ba\u00bb\u00052\u0000\u0000\u00bb\u00bc\u0005,\u0000\u0000"+
		"\u00bc\u00be\u0003 \u0010\u0000\u00bd\u00bf\u0003&\u0013\u0000\u00be\u00bd"+
		"\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c0"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005)\u0000\u0000\u00c1#\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c3\u0007\u0004\u0000\u0000\u00c3%\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c5\u0005%\u0000\u0000\u00c5\u00ca\u0003(\u0014\u0000\u00c6"+
		"\u00c7\u0005*\u0000\u0000\u00c7\u00c9\u0003(\u0014\u0000\u00c8\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c9\u00cc\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001"+
		"\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb\u00cd\u0001"+
		"\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005"+
		"&\u0000\u0000\u00ce\'\u0001\u0000\u0000\u0000\u00cf\u00d0\u0003\u0012"+
		"\t\u0000\u00d0\u00d1\u0005,\u0000\u0000\u00d1\u00d2\u0003\u0018\f\u0000"+
		"\u00d2)\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005\t\u0000\u0000\u00d4"+
		"\u00d5\u00052\u0000\u0000\u00d5\u00d9\u0005!\u0000\u0000\u00d6\u00d8\u0003"+
		",\u0016\u0000\u00d7\u00d6\u0001\u0000\u0000\u0000\u00d8\u00db\u0001\u0000"+
		"\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000"+
		"\u0000\u0000\u00da\u00dc\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000"+
		"\u0000\u0000\u00dc\u00dd\u0005\"\u0000\u0000\u00dd+\u0001\u0000\u0000"+
		"\u0000\u00de\u00e2\u0003\u000e\u0007\u0000\u00df\u00e2\u0003.\u0017\u0000"+
		"\u00e0\u00e2\u0003\u0004\u0002\u0000\u00e1\u00de\u0001\u0000\u0000\u0000"+
		"\u00e1\u00df\u0001\u0000\u0000\u0000\u00e1\u00e0\u0001\u0000\u0000\u0000"+
		"\u00e2-\u0001\u0000\u0000\u0000\u00e3\u00e4\u0003\u001a\r\u0000\u00e4"+
		"\u00e5\u00052\u0000\u0000\u00e5\u00e6\u0005,\u0000\u0000\u00e6\u00e8\u0003"+
		" \u0010\u0000\u00e7\u00e9\u0003&\u0013\u0000\u00e8\u00e7\u0001\u0000\u0000"+
		"\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000"+
		"\u0000\u00ea\u00eb\u0005)\u0000\u0000\u00eb/\u0001\u0000\u0000\u0000\u00ec"+
		"\u00ed\u0005\n\u0000\u0000\u00ed\u00ee\u0005\'\u0000\u0000\u00ee\u00ef"+
		"\u0003\u001e\u000f\u0000\u00ef\u00f0\u0005*\u0000\u0000\u00f0\u00f1\u0003"+
		"\u001a\r\u0000\u00f1\u00f2\u0005(\u0000\u0000\u00f2\u00f3\u00052\u0000"+
		"\u0000\u00f3\u00f4\u0005,\u0000\u0000\u00f4\u00f6\u0003 \u0010\u0000\u00f5"+
		"\u00f7\u0003&\u0013\u0000\u00f6\u00f5\u0001\u0000\u0000\u0000\u00f6\u00f7"+
		"\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8\u00f9"+
		"\u0005)\u0000\u0000\u00f91\u0001\u0000\u0000\u0000\u00fa\u00fd\u0005\u000b"+
		"\u0000\u0000\u00fb\u00fe\u00034\u001a\u0000\u00fc\u00fe\u00038\u001c\u0000"+
		"\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fd\u00fc\u0001\u0000\u0000\u0000"+
		"\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff\u0100\u0005)\u0000\u0000\u0100"+
		"3\u0001\u0000\u0000\u0000\u0101\u0106\u00036\u001b\u0000\u0102\u0103\u0005"+
		"*\u0000\u0000\u0103\u0105\u00036\u001b\u0000\u0104\u0102\u0001\u0000\u0000"+
		"\u0000\u0105\u0108\u0001\u0000\u0000\u0000\u0106\u0104\u0001\u0000\u0000"+
		"\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u01075\u0001\u0000\u0000\u0000"+
		"\u0108\u0106\u0001\u0000\u0000\u0000\u0109\u010c\u00051\u0000\u0000\u010a"+
		"\u010b\u0005\f\u0000\u0000\u010b\u010d\u0007\u0005\u0000\u0000\u010c\u010a"+
		"\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000\u0000\u0000\u010d7\u0001"+
		"\u0000\u0000\u0000\u010e\u0113\u0005/\u0000\u0000\u010f\u0110\u0005*\u0000"+
		"\u0000\u0110\u0112\u0005/\u0000\u0000\u0111\u010f\u0001\u0000\u0000\u0000"+
		"\u0112\u0115\u0001\u0000\u0000\u0000\u0113\u0111\u0001\u0000\u0000\u0000"+
		"\u0113\u0114\u0001\u0000\u0000\u0000\u01149\u0001\u0000\u0000\u0000\u0115"+
		"\u0113\u0001\u0000\u0000\u0000\u0116\u0117\u0005\u0005\u0000\u0000\u0117"+
		"\u0118\u00052\u0000\u0000\u0118\u0119\u0003<\u001e\u0000\u0119;\u0001"+
		"\u0000\u0000\u0000\u011a\u011e\u0005!\u0000\u0000\u011b\u011d\u0003>\u001f"+
		"\u0000\u011c\u011b\u0001\u0000\u0000\u0000\u011d\u0120\u0001\u0000\u0000"+
		"\u0000\u011e\u011c\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000\u0000"+
		"\u0000\u011f\u0121\u0001\u0000\u0000\u0000\u0120\u011e\u0001\u0000\u0000"+
		"\u0000\u0121\u0122\u0005\"\u0000\u0000\u0122=\u0001\u0000\u0000\u0000"+
		"\u0123\u012c\u0003\"\u0011\u0000\u0124\u012c\u0003@ \u0000\u0125\u012c"+
		"\u0003:\u001d\u0000\u0126\u012c\u0003\u000e\u0007\u0000\u0127\u012c\u0003"+
		"*\u0015\u0000\u0128\u012c\u00030\u0018\u0000\u0129\u012c\u00032\u0019"+
		"\u0000\u012a\u012c\u0003\u0004\u0002\u0000\u012b\u0123\u0001\u0000\u0000"+
		"\u0000\u012b\u0124\u0001\u0000\u0000\u0000\u012b\u0125\u0001\u0000\u0000"+
		"\u0000\u012b\u0126\u0001\u0000\u0000\u0000\u012b\u0127\u0001\u0000\u0000"+
		"\u0000\u012b\u0128\u0001\u0000\u0000\u0000\u012b\u0129\u0001\u0000\u0000"+
		"\u0000\u012b\u012a\u0001\u0000\u0000\u0000\u012c?\u0001\u0000\u0000\u0000"+
		"\u012d\u012e\u0005\u0006\u0000\u0000\u012e\u012f\u00052\u0000\u0000\u012f"+
		"\u0130\u0003B!\u0000\u0130A\u0001\u0000\u0000\u0000\u0131\u0135\u0005"+
		"!\u0000\u0000\u0132\u0134\u0003D\"\u0000\u0133\u0132\u0001\u0000\u0000"+
		"\u0000\u0134\u0137\u0001\u0000\u0000\u0000\u0135\u0133\u0001\u0000\u0000"+
		"\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0138\u0001\u0000\u0000"+
		"\u0000\u0137\u0135\u0001\u0000\u0000\u0000\u0138\u0139\u0005\"\u0000\u0000"+
		"\u0139C\u0001\u0000\u0000\u0000\u013a\u013f\u0003\u000e\u0007\u0000\u013b"+
		"\u013f\u0003F#\u0000\u013c\u013f\u00032\u0019\u0000\u013d\u013f\u0003"+
		"\u0004\u0002\u0000\u013e\u013a\u0001\u0000\u0000\u0000\u013e\u013b\u0001"+
		"\u0000\u0000\u0000\u013e\u013c\u0001\u0000\u0000\u0000\u013e\u013d\u0001"+
		"\u0000\u0000\u0000\u013fE\u0001\u0000\u0000\u0000\u0140\u0141\u00052\u0000"+
		"\u0000\u0141\u0143\u0005,\u0000\u0000\u0142\u0144\u0005-\u0000\u0000\u0143"+
		"\u0142\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u0144"+
		"\u0145\u0001\u0000\u0000\u0000\u0145\u0147\u00051\u0000\u0000\u0146\u0148"+
		"\u0003H$\u0000\u0147\u0146\u0001\u0000\u0000\u0000\u0147\u0148\u0001\u0000"+
		"\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u014a\u0005)\u0000"+
		"\u0000\u014aG\u0001\u0000\u0000\u0000\u014b\u014c\u0005%\u0000\u0000\u014c"+
		"\u0151\u0003J%\u0000\u014d\u014e\u0005*\u0000\u0000\u014e\u0150\u0003"+
		"J%\u0000\u014f\u014d\u0001\u0000\u0000\u0000\u0150\u0153\u0001\u0000\u0000"+
		"\u0000\u0151\u014f\u0001\u0000\u0000\u0000\u0151\u0152\u0001\u0000\u0000"+
		"\u0000\u0152\u0154\u0001\u0000\u0000\u0000\u0153\u0151\u0001\u0000\u0000"+
		"\u0000\u0154\u0155\u0005&\u0000\u0000\u0155I\u0001\u0000\u0000\u0000\u0156"+
		"\u0157\u0003\u0012\t\u0000\u0157\u0158\u0005,\u0000\u0000\u0158\u0159"+
		"\u0003\u0018\f\u0000\u0159K\u0001\u0000\u0000\u0000 MR]h~\u0086\u008c"+
		"\u0091\u0094\u009b\u00a0\u00a4\u00aa\u00ae\u00b7\u00be\u00ca\u00d9\u00e1"+
		"\u00e8\u00f6\u00fd\u0106\u010c\u0113\u011e\u012b\u0135\u013e\u0143\u0147"+
		"\u0151";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}