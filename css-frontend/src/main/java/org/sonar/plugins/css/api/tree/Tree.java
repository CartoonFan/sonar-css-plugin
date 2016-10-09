/*
 * SonarQube CSS / Less Plugin
 * Copyright (C) 2013-2016 Tamas Kende and David RACODON
 * mailto: kende.tamas@gmail.com and david.racodon@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.plugins.css.api.tree;

import java.util.Iterator;

import org.sonar.plugins.css.api.tree.css.*;
import org.sonar.plugins.css.api.tree.embedded.CssInScriptTagTree;
import org.sonar.plugins.css.api.tree.embedded.FileWithEmbeddedCssTree;
import org.sonar.plugins.css.api.tree.less.*;
import org.sonar.plugins.css.api.visitors.DoubleDispatchVisitor;
import org.sonar.sslr.grammar.GrammarRuleKey;

public interface Tree {

  boolean is(Kind... kind);

  void accept(DoubleDispatchVisitor visitor);

  Iterator<Tree> childrenIterator();

  String treeValue();

  enum Kind implements GrammarRuleKey {

    // CSS
    STYLESHEET(StyleSheetTree.class),
    AT_RULE(AtRuleTree.class),
    RULESET(RulesetTree.class),
    EMPTY_STATEMENT(EmptyStatementTree.class),
    RULESET_BLOCK(RulesetBlockTree.class),
    AT_RULE_BLOCK(AtRuleBlockTree.class),
    PARENTHESIS_BLOCK(ParenthesisBlockTree.class),
    BRACKET_BLOCK(BracketBlockTree.class),
    PROPERTY_DECLARATION(PropertyDeclarationTree.class),
    VARIABLE_DECLARATION(VariableDeclarationTree.class),
    PROPERTY(PropertyTree.class),
    FUNCTION(FunctionTree.class),
    VALUE(ValueTree.class),
    SELECTORS(SelectorsTree.class),
    SELECTOR(SelectorTree.class),
    SELECTOR_COMBINATOR(SelectorCombinatorTree.class),
    COMPOUND_SELECTOR(CompoundSelectorTree.class),
    TYPE_SELECTOR(TypeSelectorTree.class),
    KEYFRAMES_SELECTOR(KeyframesSelectorTree.class),
    CLASS_SELECTOR(ClassSelectorTree.class),
    ID_SELECTOR(IdSelectorTree.class),
    PSEUDO_SELECTOR(PseudoSelectorTree.class),
    PSEUDO_FUNCTION(PseudoFunctionTree.class),
    PSEUDO_IDENTIFIER(PseudoIdentifierTree.class),
    ATTRIBUTE_SELECTOR(AttributeSelectorTree.class),
    ATTRIBUTE_MATCHER_EXPRESSION(AttributeMatcherExpressionTree.class),
    ATTRIBUTE_MATCHER(AttributeMatcherTree.class),
    NAMESPACE(NamespaceTree.class),
    URI(UriTree.class),
    URI_CONTENT(UriContentTree.class),
    PERCENTAGE(PercentageTree.class),
    UNICODE_RANGE(UnicodeRangeTree.class),
    DIMENSION(DimensionTree.class),
    IMPORTANT(ImportantTree.class),
    AT_KEYWORD(AtKeywordTree.class),
    HASH(HashTree.class),
    UNIT(UnitTree.class),
    VARIABLE(StringTree.class),
    STRING(StringTree.class),
    IDENTIFIER(IdentifierTree.class),
    NUMBER(NumberTree.class),
    DELIMITER(DelimiterTree.class),
    CASE_INSENSITIVE_FLAG(CaseInsensitiveFlagTree.class),
    TOKEN(SyntaxToken.class),
    TRIVIA(SyntaxTrivia.class),
    SPACING(SyntaxSpacing.class),

    // Embedded CSS
    FILE_WITH_EMBEDDED_CSS(FileWithEmbeddedCssTree.class),
    CSS_IN_SCRIPT_TAG(CssInScriptTagTree.class),

    // Less
    LESS_VARIABLE_DECLARATION(LessVariableDeclarationTree.class),
    LESS_VARIABLE(LessVariableTree.class),
    LESS_EXTEND(LessExtendTree.class),
    LESS_PARENT_SELECTOR(LessParentSelectorTree.class),
    LESS_MIXIN_CALL(LessMixinCallTree.class),
    LESS_MIXIN_GUARD(LessMixinGuardTree.class),
    LESS_MIXIN_PARAMETERS(LessMixinParametersTree.class),
    LESS_MIXIN_PARAMETER(LessMixinParameterTree.class),
    LESS_ESCAPING(LessEscapingTree.class),

    ;

    final Class<? extends Tree> associatedInterface;

    Kind(Class<? extends Tree> associatedInterface) {
      this.associatedInterface = associatedInterface;
    }

    public Class<? extends Tree> getAssociatedInterface() {
      return associatedInterface;
    }
  }

}
