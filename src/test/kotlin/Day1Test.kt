import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day1Test : DescribeSpec({
    describe("single depth measurement increases") {
        it("no measurement") {
            day1(emptyList()) shouldBe 0
        }
        it("decreasing measurement") {
            day1(listOf("3", "2", "1")) shouldBe 0
        }
        it("increasing measurement") {
            day1(listOf("1", "2", "3")) shouldBe 2
        }
        it("oscillating measurement") {
            day1(listOf("1", "2", "1", "2", "1")) shouldBe 2
        }
    }
})