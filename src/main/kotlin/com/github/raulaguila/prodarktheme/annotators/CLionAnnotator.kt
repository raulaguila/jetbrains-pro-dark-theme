package com.github.raulaguila.prodarktheme.annotators

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.util.ObjectUtils

class CLionAnnotator : BaseAnnotator() {
    companion object {
        val DEFAULT_KEYWORD: TextAttributesKey = ObjectUtils.notNull(
            TextAttributesKey.find("DEFAULT_KEYWORD"), DefaultLanguageHighlighterColors.KEYWORD
        )
        val SECONDARY_KEYWORD: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "DEFAULT_SECONDARY_KEYWORD",
            DEFAULT_KEYWORD
        )
        val SECONDARY_KEYWORD_BG: TextAttributesKey = ObjectUtils.notNull(
            TextAttributesKey.find("DEFAULT_SECONDARY_KEYWORD_WITH_BG"), DefaultLanguageHighlighterColors.KEYWORD
        )
    }
    override fun getKeywordType(element: PsiElement): TextAttributesKey? {
        var type: TextAttributesKey? = null
        when (element.text) {
            "using" -> type = SECONDARY_KEYWORD
            "return" -> type = SECONDARY_KEYWORD
            "if", "else", "switch", "case", "default", "break", "continue" -> type = SECONDARY_KEYWORD
            "try", "catch", "finally", "throw" -> type = SECONDARY_KEYWORD
            "for", "while", "do" -> type = SECONDARY_KEYWORD
            else -> {}
        }
        return type
    }

}