class OutpostWorker(
    val name: String
) {
    var maxEnergy: Int = 100
        private set
    var enery: Int = maxEnergy
        set(value) {
            field = value.coerceIn(0, maxEnergy)
        }
    var mood: Int = 50
        get() = field + (enery / 10)
    var level: Int = 1
        private set
    fun work() {
        println("$name выполняет работу...")
        enery -= 15
        if (enery < 20) println("$name устал!")
    }
    fun rest() {
        println("$name отдыхает...")
        enery += 20
    }
    fun levelUp() {
        level++
        maxEnergy += 20
        enery = maxEnergy
        println("$name повышает уровень: $level | Максимальная энергия увеличена до: $maxEnergy")
    }
    fun main() {
        val worker = OutpostWorker("Алексей")
        println("Энергия: ${worker.enery}")
        println("Настроение: ${worker.mood}")
        for (i in 1..3) {
            worker.work()
        }
        println("Энергия: ${worker.enery}")
        println("Настроение: ${worker.mood}")
        worker.rest()
        worker.enery = 150
        //worker.level = 5
        worker.levelUp()
    }
}