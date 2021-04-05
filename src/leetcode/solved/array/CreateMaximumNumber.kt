package leetcode.solved.array

//321. Create Maximum Number

private fun maxNumber(nums1: IntArray, nums2: IntArray, k: Int): IntArray {
    val arr = IntArray(k)
    return createMaxNumber(0, 0, nums1, nums2, k, arr, 0)
}

private fun createMaxNumber(n1Index: Int, n2Index: Int, nums1: IntArray, nums2: IntArray, k: Int, arr: IntArray, resArrIndex: Int): IntArray {

    val edgeNum1 = Math.min(n1Index + (nums1.size - n1Index) - (k - (nums2.size - n2Index)), nums1.size - 1)
    val edgeNum2 = Math.min(n2Index + (nums2.size - n2Index) - (k - (nums1.size - n1Index)), nums2.size - 1)

    var n1MaxDigit = -1
    var n1MaxDigitIndex = 0
    var n2MaxDigit = -1
    var n2MaxDigitIndex = 0

    for (i in n1Index..edgeNum1) {
        if (n1MaxDigit < nums1[i]) {
            n1MaxDigit = nums1[i]
            n1MaxDigitIndex = i
            if(n1MaxDigit==9)
                break
        }
    }
    for (i in n2Index..edgeNum2) {
        if (n2MaxDigit < nums2[i]) {
            n2MaxDigit = nums2[i]
            n2MaxDigitIndex = i
            if(n2MaxDigit==9)
                break
        }
    }

    if(k-1==0){
        arr[resArrIndex] = Math.max(n1MaxDigit, n2MaxDigit)
        return arr
    }
    when {
        n1MaxDigit>n2MaxDigit -> {
            arr[resArrIndex] = n1MaxDigit
            return createMaxNumber(n1MaxDigitIndex + 1, n2Index, nums1, nums2, k - 1, arr, resArrIndex + 1)
        }
        n2MaxDigit>n1MaxDigit -> {
            arr[resArrIndex] = n2MaxDigit
            return createMaxNumber(n1Index, n2MaxDigitIndex + 1, nums1, nums2, k - 1, arr, resArrIndex + 1)
        }
        else -> {
            val n1ResArr = arr.clone()
            n1ResArr[resArrIndex] = n1MaxDigit
            arr[resArrIndex] = n2MaxDigit

            val rr2 = createMaxNumber(n1Index, n2MaxDigitIndex + 1, nums1, nums2, k - 1, arr, resArrIndex + 1)
            val rr1 = createMaxNumber(n1MaxDigitIndex + 1, n2Index, nums1, nums2, k - 1, n1ResArr, resArrIndex + 1)

            return biggerIntArr(
                   rr1,
                    rr2)
        }
    }

}

private fun biggerIntArr(arr1: IntArray, arr2: IntArray): IntArray {
    for (i in 0..arr1.lastIndex) {
        if (arr1[i] > arr2[i])
            return arr1
        if (arr2[i] > arr1[i])
            return arr2
    }
    return arr1
}

fun main() {
    val arr = maxNumber(intArrayOf(8,9,7,3,5,9,1,0,8,5,3,0,9,2,7,4,8,9,8,1,0,2,0,2,7,2,3,5,4,7,4,1,4,0,1,4,2,1,3,1,5,3,9,3,9,0,1,7,0,6,1,8,5,6,6,5,0,4,7,2,9,2,2,7,6,2,9,2,3,5,7,4,7,0,1,8,3,6,6,3,0,8,5,3,0,3,7,3,0,9,8,5,1,9,5,0,7,9,6,8,5,1,9,6,5,8,2,3,7,1,0,1,4,3,4,4,2,4,0,8,4,6,5,5,7,6,9,0,8,4,6,1,6,7,2,0,1,1,8,2,6,4,0,5,5,2,6,1,6,4,7,1,7,2,2,9,8,9,1,0,5,5,9,7,7,8,8,3,3,8,9,3,7,5,3,6,1,0,1,0,9,3,7,8,4,0,3,5,8,1,0,5,7,2,8,4,9,5,6,8,1,1,8,7,3,2,3,4,8,7,9,9,7,8,5,2,2,7,1,9,1,5,5,1,3,5,9,0,5,2,9,4,2,8,7,3,9,4,7,4,8,7,5,0,9,9,7,9,3,8,0,9,5,3,0,0,3,0,4,9,0,9,1,6,0,2,0,5,2,2,6,0,0,9,6,3,4,1,2,0,8,3,6,6,9,0,2,1,6,9,2,4,9,0,8,3,9,0,5,4,5,4,6,1,2,5,2,2,1,7,3,8,1,1,6,8,8,1,8,5,6,1,3,0,1,3,5,6,5,0,6,4,2,8,6,0,3,7,9,5,5,9,8,0,4,8,6,0,8,6,6,1,6,2,7,1,0,2,2,4,0,0,0,4,6,5,5,4,0,1,5,8,3,2,0,9,7,6,2,6,9,9,9,7,1,4,6,2,8,2,5,3,4,5,2,4,4,4,7,2,2,5,3,2,8,2,2,4,9,8,0,9,8,7,6,2,6,7,5,4,7,5,1,0,5,7,8,7,7,8,9,7,0,3,7,7,4,7,2,0,4,1,1,9,1,7,5,0,5,6,6,1,0,6,9,4,2,8,0,5,1,9,8,4,0,3,1,2,4,2,1,8,9,5,9,6,5,3,1,8,9,0,9,8,3,0,9,4,1,1,6,0,5,9,0,8,3,7,8,5), intArrayOf(7,8,4,1,9,4,2,6,5,2,1,2,8,9,3,9,9,5,4,4,2,9,2,0,5,9,4,2,1,7,2,5,1,2,0,0,5,3,1,1,7,2,3,3,2,8,2,0,1,4,5,1,0,0,7,7,9,6,3,8,0,1,5,8,3,2,3,6,4,2,6,3,6,7,6,6,9,5,4,3,2,7,6,3,1,8,7,5,7,8,1,6,0,7,3,0,4,4,4,9,6,3,1,0,3,7,3,6,1,0,0,2,5,7,2,9,6,6,2,6,8,1,9,7,8,8,9,5,1,1,4,2,0,1,3,6,7,8,7,0,5,6,0,1,7,9,6,4,8,6,7,0,2,3,2,7,6,0,5,0,9,0,3,3,8,5,0,9,3,8,0,1,3,1,8,1,8,1,1,7,5,7,4,1,0,0,0,8,9,5,7,8,9,2,8,3,0,3,4,9,8,1,7,2,3,8,3,5,3,1,4,7,7,5,4,9,2,6,2,6,4,0,0,2,8,3,3,0,9,1,6,8,3,1,7,0,7,1,5,8,3,2,5,1,1,0,3,1,4,6,3,6,2,8,6,7,2,9,5,9,1,6,0,5,4,8,6,6,9,4,0,5,8,7,0,8,9,7,3,9,0,1,0,6,2,7,3,3,2,3,3,6,3,0,8,0,0,5,2,1,0,7,5,0,3,2,6,0,5,4,9,6,7,1,0,4,0,9,6,8,3,1,2,5,0,1,0,6,8,6,6,8,8,2,4,5,0,0,8,0,5,6,2,2,5,6,3,7,7,8,4,8,4,8,9,1,6,8,9,9,0,4,0,5,5,4,9,6,7,7,9,0,5,0,9,2,5,2,9,8,9,7,6,8,6,9,2,9,1,6,0,2,7,4,4,5,3,4,5,5,5,0,8,1,3,8,3,0,8,5,7,6,8,7,8,9,7,0,8,4,0,7,0,9,5,8,2,0,8,7,0,3,1,8,1,7,1,6,9,7,9,7,2,6,3,0,5,3,6,0,5,9,3,9,1,1,0,0,8,1,4,3,0,4,3,7,7,7,4,6,4,0,0,5,7,3,2,8,5,1,4,5,8,5,6,7,5,7,3,3,9,6,8,1,5,1,1,1,0,3),
            21)
    var s = 2
    print("sads")
}

