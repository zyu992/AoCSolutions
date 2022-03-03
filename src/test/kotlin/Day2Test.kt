import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day2Test : DescribeSpec({
    describe("coordinates") {
        it("no commands") {
            day2(emptyList()) shouldBe Coordinate(0, 0)
        }
        it("single up command") {
            day2(listOf("up 1")) shouldBe Coordinate(0, -1)
        }
        it("single down command") {
            day2(listOf("down 1")) shouldBe Coordinate(0, 1)
        }
        it("single forward command") {
            day2(listOf("forward 1")) shouldBe Coordinate(1, 0)
        }
        it("multiple commands") {
            day2(listOf("forward 1", "up 2", "down 4")) shouldBe Coordinate(1, 2)
        }
    }
})