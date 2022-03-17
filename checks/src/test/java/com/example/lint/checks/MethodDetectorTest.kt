package com.example.lint.checks

import com.android.tools.lint.checks.infrastructure.TestFiles
import com.android.tools.lint.checks.infrastructure.TestLintTask
import org.junit.Test

class MethodDetectorTest {
    @Test
    fun testBasic() {
        TestLintTask.lint().files(
                TestFiles.java(
                        """
                    package com.test.enums;
                        
                    public enum MyTestEnum {
                        MY_TEST_ENUM_VALUE
                    }
                    """
                ).indented()
        )
                .detector(MethodDetector())
                .run()
                .expectClean()
    }
}