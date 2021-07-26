package hilmysf.eventapps.utils

import hilmysf.eventapps.data.source.entities.GuestEntity
import java.text.SimpleDateFormat
import java.util.*

object Helper {
    //Question 1
    fun isPalindrome(name: String): Boolean {
        var removeSpace = name.filter { !it.isWhitespace() }
        var reverseText = ""
        var length = removeSpace.length
        var i = length - 1
        while (i >= 0) {
            reverseText += removeSpace[i]
            i--
        }
        return removeSpace == reverseText
    }

    //Question 2
    fun isPrime(guest: GuestEntity?): String {
        val format = SimpleDateFormat("yyyy-MM-dd")
        val date = format.parse(guest?.birthDate)
        val myCal = GregorianCalendar()
        myCal.time = date
        val month = myCal.get(Calendar.MONTH) + 1

        var result = ""
        if (month == 0 || month == 1) {
            result = "not prime numbers"
        } else {
            for (i in 2..month) {
                if (month % i == 0) {
                    result = "not prime numbers"
                    break
                }
                else {
                    result = "prime numbers"
                    break
                }
            }
        }
        return result
    }

    fun convertBirthdayToHandphone(guest: GuestEntity?): String {
        val format = SimpleDateFormat("yyyy-MM-dd")
        val date = format.parse(guest?.birthDate)
        val myCal = GregorianCalendar()
        myCal.time = date
        val birthday = myCal.get(Calendar.DAY_OF_MONTH)
        return if (birthday % 2 == 0 && birthday % 3 == 0) {
            "iOS"
        } else if (birthday % 3 == 0) {
            "android"
        } else if (birthday % 2 == 0) {
            "blackberry"
        } else {
            "feature phone"
        }
    }
}