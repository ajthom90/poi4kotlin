package com.andrewthom.poi

import com.andrewthom.poi.xssf.*
import java.io.FileOutputStream

fun main() {
    val wb = xssfWorkbook {
        val boldStyle = style {
            styleFont = font {
                fontName = "Times New Roman"
                bold = true
                fontSize = 12
            }
        }
        sheet(sheetName = "AJ Sheet") {
            for (r in 0..10) {
                row(r) {
                    for (i in 0..10) {
                        cell(i) {
                            setCellValue("Testing $r:$i")
                            cellStyle = boldStyle
                        }
                    }
                }
            }

            for (i in 0..10) {
                autoSize(i)
            }
        }
    }

    val fos = FileOutputStream("/Users/ajthom90/Desktop/text.xlsx")
    wb.write(fos)
    fos.flush()
    fos.close()
    wb.close()
}
