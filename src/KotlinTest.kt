class KotlinTest {
    fun findPrimeNo(): List<Int>{
        var isPrime: Boolean = true
        val list: MutableList<Int> = mutableListOf()
        for (i in 1..100){
            isPrime = true
            for( j in 2..i/2){
                if(i%j == 0){
                    isPrime = false;
                    break
                }
            }
            if(isPrime){
                list.add(i)
            }
        }
        return list
    }
}

fun main() {
     KotlinTest().findPrimeNo().forEach { println(it) }
}


