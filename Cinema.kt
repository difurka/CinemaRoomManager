package cinema



fun print_arr(arr: Array<Array<String>>, r: Int, c: Int): Unit {
    println("Cinema:")
    for (i in 0..r) {
        for (j in 0..c) print("${arr[i][j]} ")
        println( )
    }
}

fun buy(r: Int, c: Int, rows: Int, columns: Int): Int {
    val a: Int
    if (rows * columns <=60) {
        a = 10
    } else {
        if (r <= rows/2) a = 10 else a = 8
    }

    println("Ticket price: \$$a")
    return a
}

fun main() {
    println("Enter the number of rows:")
    val rows = readLine()!!.toInt()
    println("Enter the number of seats in each row:")
    val columns = readLine()!!.toInt()


    var arr = Array<Array<String>>(rows + 1, {Array<String>(columns + 1, {""})})
    arr[0][0] = " "
    for (i in 1..columns) arr[0][i]= "$i"
    for (j in 1..rows) {
        arr[j][0] = "$j"
        for (i in 1..columns) arr[j][i] = "S"}

    var numberPurshased: Int = 0 // The number of purchased tickets
    var percentagePurchased: Float = 0F // The number of purchased tickets represented as a percentage. Percentages should be rounded to 2 decimal places
    var income: Int = 0 // Current income
    val totalIncome: Int =  if (rows * columns <=60) {
        rows * columns * 10
    } else {
        rows/2 *  columns * 10 + (rows - rows/2) *  columns * 8
    }  // The total income that shows how much money the theatre will get if all the tickets are sold


    do{
        println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit")
        val a = readLine()!!.toInt()
        when (a) {
            1 -> print_arr(arr, rows, columns)
            2 -> {var flag = true
                do{
                    println("Enter a row number:")
                    val rows_your = readLine()!!.toInt()
                    println("Enter a seat number in that row:")
                    val columns_your = readLine()!!.toInt()
                    if (rows_your > rows || columns_your > columns ) {
                        println("Wrong input!")
                    } else if (arr[rows_your][columns_your] == "S") {
                        val priсe = buy(rows_your, columns_your, rows, columns)
                        numberPurshased++
                        income += priсe
                        percentagePurchased = numberPurshased.toFloat() * 100 / (rows * columns).toFloat()
                        arr[rows_your][columns_your] = "B"
                        flag = false
                    } else {
                        println("That ticket has already been purchased!")
                    }
                } while (flag)
            }
            3 -> {
                println("Number of purchased tickets: ${numberPurshased}")
                println("Percentage: ${String.format("%.2f", percentagePurchased)}%")
                println("Current income: \$$income")
                println("Total income: \$$totalIncome")

            }
        }
    } while ( a != 0)

}
