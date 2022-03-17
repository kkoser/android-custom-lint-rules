package com.example.lint.checks

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.*
import com.android.tools.lint.detector.api.Detector.UastScanner
import com.intellij.psi.PsiParameter
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UMethod

class MethodDetector : Detector(), UastScanner {
    override fun createUastHandler(context: JavaContext): UElementHandler {
        return MethodHandler(context)
    }

    override fun getApplicableUastTypes(): List<Class<out UElement?>>? {
        return listOf<Class<out UElement?>>(UMethod::class.java)
    }

    companion object {
        val ISSUE = Issue.create(
                id = "methodFinderIssue",
                briefDescription = "Found a method",
                explanation = "Found a method",
                category = Category.CUSTOM_LINT_CHECKS,
                priority = 10,
                implementation = Implementation(
                        MethodDetector::class.java,
                        Scope.JAVA_FILE_SCOPE
                )
        )
    }
}

class MethodHandler internal constructor(val context: JavaContext) : UElementHandler() {
    override fun visitMethod(node: UMethod) {
        node.parameterList.parameters.forEachIndexed { index, psiParameter ->
            checkMethodParameter(psiParameter, node)
        }

        context.report(MethodDetector.ISSUE, node, context.getLocation(node.returnTypeElement), "found a method ${node.name}")
    }

    private fun checkMethodParameter(psiParam: PsiParameter, node: UMethod) {

        context.report(MethodDetector.ISSUE, node, context.getLocation(psiParam), "found a param named ${psiParam.name} in method ${node.name}")
    }


}