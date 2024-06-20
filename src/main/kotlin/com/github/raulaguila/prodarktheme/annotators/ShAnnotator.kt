package com.github.raulaguila.prodarktheme.annotators

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import com.intellij.sh.ShTypes.*

class ShAnnotator : BaseAnnotator() {
    companion object {
        val KEYWORD: TextAttributesKey = DefaultLanguageHighlighterColors.KEYWORD
        val VARIBLE: TextAttributesKey = DefaultLanguageHighlighterColors.LOCAL_VARIABLE

    }

    override fun getKeywordType(element: PsiElement): TextAttributesKey? {
        var type: TextAttributesKey? = null

        if (element.elementType == WORD) {
            val parent = PsiTreeUtil.findFirstContext(element, false) {
                it.elementType == ARITHMETIC_EXPANSION
            }
            if (parent != null) {
                type = VARIBLE
            }

        }

        return type
    }

}
