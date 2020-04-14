/*
 * Copyright 2020 Andrew J. Thom
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.andrewthom.poi.xssf

import com.andrewthom.poi.PoiDslMarker
import org.apache.poi.xssf.usermodel.*

@PoiDslMarker
fun xssfWorkbook(block: XSSFWorkbook.() -> Unit): XSSFWorkbook {
    val wb = XSSFWorkbook()
    wb.block()
    return wb
}

@PoiDslMarker
fun XSSFWorkbook.sheet(block: XSSFSheet.() -> Unit): XSSFSheet {
    val sheet = this.createSheet()
    sheet.block()
    return sheet
}

@PoiDslMarker
fun XSSFWorkbook.sheet(sheetName: String, block: XSSFSheet.() -> Unit): XSSFSheet {
    val sheet = this.createSheet(sheetName)
    sheet.block()
    return sheet
}

@PoiDslMarker
fun XSSFSheet.row(rowNum: Int, block: XSSFRow.() -> Unit): XSSFRow {
    val row = this.createRow(rowNum)
    row.block()
    return row
}

@PoiDslMarker
fun XSSFRow.cell(columnNum: Int, block: XSSFCell.() -> Unit): XSSFCell {
    val cell = this.createCell(columnNum)
    cell.block()
    return cell
}

@PoiDslMarker
fun XSSFWorkbook.style(block: XSSFCellStyle.() -> Unit): XSSFCellStyle {
    val style = this.createCellStyle()
    style.block()
    return style
}

var XSSFCellStyle.styleFont: XSSFFont
    get() {
        return font
    }
    set(value) {
        setFont(value)
    }

@PoiDslMarker
fun XSSFWorkbook.font(block: XSSFFont.() -> Unit): XSSFFont {
    val font = this.createFont()
    font.block()
    return font
}

var XSSFFont.fontSize: Int
    get() {
        return fontHeightInPoints.toInt()
    }
    set(value) {
        fontHeightInPoints = value.toShort()
    }

fun XSSFSheet.autoSize(columnNum: Int) {
    this.autoSizeColumn(columnNum)
}
