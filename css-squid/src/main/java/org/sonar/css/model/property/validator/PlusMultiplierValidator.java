/*
 * SonarQube CSS Plugin
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
package org.sonar.css.model.property.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;

import org.sonar.css.model.Value;
import org.sonar.css.model.value.CssValueElement;

/**
 * Validator to check property values than can be multiplied: [xxx]+
 * See https://developer.mozilla.org/en-US/docs/Web/CSS/Value_definition_syntax#Plus_()
 */
public class PlusMultiplierValidator implements ValueValidator {

  private final List<ValueElementValidator> validators;

  public PlusMultiplierValidator(ValueElementValidator... validators) {
    this.validators = Arrays.asList(validators);
  }

  @Override
  public boolean isValid(Value value) {
    boolean isValid;
    for (CssValueElement valueElement : value.getValueElements()) {
      isValid = false;
      for (ValueElementValidator validator : validators) {
        if (validator.isValid(valueElement)) {
          isValid = true;
          break;
        }
      }
      if (!isValid) {
        return false;
      }
    }
    return true;
  }

  @Override
  @Nonnull
  public String getValidatorFormat() {
    StringBuilder format = new StringBuilder();

    String joinedValidatorsFormat = validators.stream()
      .map(v -> v.getValidatorFormat())
      .collect(Collectors.joining(" | "));

    if (joinedValidatorsFormat.contains(" | ")) {
      format.append("[ ");
    }
    format.append(joinedValidatorsFormat);
    if (joinedValidatorsFormat.contains(" | ")) {
      format.append(" ]");
    }
    format.append("+");
    return format.toString();
  }

}
