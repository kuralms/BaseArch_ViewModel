package quickstartx.kural.utils

import android.util.Log
import java.text.SimpleDateFormat

class DateConverter {

    fun getConvertedDate(obj: String): String? {
        if (obj is String) {
            var date = obj                          //2019-08-03T12:34:29.731Z
            var spf :SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")//"MMM dd, yyyy hh:mm:ss aaa
            val newDate = spf.parse(date)
            spf = SimpleDateFormat("dd MMM yyyy")
            date = spf.format(newDate)
            return date
        }

        // `obj` is still of type `Any` outside of the type-checked branch
        return ""
    }
    fun getConvertedDateAudio(obj: String): String? {
        if (obj is String) {
            var date = obj                          //2019-08-03T12:34:29.731Z
            var spf :SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd")//"MMM dd, yyyy hh:mm:ss aaa
            val newDate = spf.parse(date)
            spf = SimpleDateFormat("dd MMM yyyy")
            date = spf.format(newDate)
            return date
        }

        // `obj` is still of type `Any` outside of the type-checked branch
        return ""
    }
    fun getConvertedDateCalender(obj: String): String? {
        if (obj is String) {
            var date = obj                          //2019-08-03T12:34:29.731Z
            var spf :SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd")//"MMM dd, yyyy hh:mm:ss aaa
            val newDate = spf.parse(date)
            spf = SimpleDateFormat("dd MMM yyyy")
            date = spf.format(newDate)
            return date
        }

        // `obj` is still of type `Any` outside of the type-checked branch
        return ""
    }

}
