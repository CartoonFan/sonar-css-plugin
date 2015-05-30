/*
 * SonarQube CSS Plugin
 * Copyright (C) 2013 Tamas Kende
 * kende.tamas@gmail.com
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
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.css.checks.utils;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class CssColorsTest {

  @Test
  public void number_of_svg_colors() {
    assertThat(CssColors.SVG_COLORS.size()).isEqualTo(147);
  }

  @Test
  public void number_of_css4_colors() {
    assertThat(CssColors.CSS4_COLORS.size()).isEqualTo(1);
  }

  @Test
  public void number_of_css2_system_colors() {
    assertThat(CssColors.CSS2_SYSTEM_COLORS.size()).isEqualTo(28);
  }

}
