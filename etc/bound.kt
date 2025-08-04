typealias ll = Long
typealias vi = List<ll>
typealias vvi = List<vi>

fun cntLeqX(a: vi, x: ll): Int {
    return upperBound(a, x)
}

fun cntGeqX(a: vi, x: ll): Int {
    return a.size - lowerBound(a, x)
}

private fun upperBound(a: vi, x: ll): Int {
    var low = 0
    var high = a.size
    while (low < high) {
        val mid = (low + high) ushr 1
        if (a[mid] <= x) {
            low = mid + 1
        } else {
            high = mid
        }
    }
    return low
}

private fun lowerBound(a: vi, x: ll): Int {
    var low = 0
    var high = a.size
    while (low < high) {
        val mid = (low + high) ushr 1
        if (a[mid] < x) {
            low = mid + 1
        } else {
            high = mid
        }
    }
    return low
}