import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day3Test : DescribeSpec({
    describe("power consumption (gamma * epsilon)") {
        describe("single record") {
            it("single bit 0") {
                day3(listOf("0")) shouldBe 0
            }
            it("single bit 1") {
                day3(listOf("1")) shouldBe 0
            }
            it("multiple bits") {
                day3(listOf("1010")) shouldBe 50
            }
        }
        describe("multiple records") {
            it("single bit") {
                day3(listOf("0", "0", "1")) shouldBe 0
            }
            it("multiple bits") {
                day3(listOf("111", "110", "100")) shouldBe 6
            }
        }
    }
})