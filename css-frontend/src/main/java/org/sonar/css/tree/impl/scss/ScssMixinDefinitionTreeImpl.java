/*
 * SonarQube CSS / SCSS / Less Analyzer
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
package org.sonar.css.tree.impl.scss;

import com.google.common.collect.Iterators;
import org.sonar.plugins.css.api.tree.Tree;
import org.sonar.plugins.css.api.tree.css.IdentifierTree;
import org.sonar.plugins.css.api.tree.css.StatementBlockTree;
import org.sonar.plugins.css.api.tree.css.SyntaxToken;
import org.sonar.plugins.css.api.tree.scss.ScssMixinDefinitionTree;
import org.sonar.plugins.css.api.tree.scss.ScssParametersTree;
import org.sonar.plugins.css.api.visitors.DoubleDispatchVisitor;

import javax.annotation.Nullable;
import java.util.Iterator;

public class ScssMixinDefinitionTreeImpl extends ScssDirectiveWithNameAndParametersTreeImpl implements ScssMixinDefinitionTree {

  private final StatementBlockTree block;

  public ScssMixinDefinitionTreeImpl(SyntaxToken directive, IdentifierTree name, @Nullable ScssParametersTree parameters, StatementBlockTree block) {
    super(directive, name, parameters);
    this.block = block;
  }

  @Override
  public Kind getKind() {
    return Kind.SCSS_MIXIN_DEFINITION;
  }

  @Override
  public Iterator<Tree> childrenIterator() {
    return Iterators.forArray(directive(), name(), parameters(), block);
  }

  @Override
  public void accept(DoubleDispatchVisitor visitor) {
    visitor.visitScssMixinDefinition(this);
  }

  @Override
  public StatementBlockTree block() {
    return block;
  }

}
