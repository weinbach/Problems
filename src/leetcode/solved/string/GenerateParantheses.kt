package leetcode.solved.string

//22. Generate Parentheses

//Runtime: 156 ms, faster than 100.00%
//Memory Usage: 35.1 MB, less than 54.28%
fun generateParenthesis(n: Int): List<String> {
    return generate(n,n, "", ArrayList())
}

fun generate(openB: Int, closeB: Int, string: String, list: ArrayList<String>): List<String>{
    if(openB ==0 && closeB ==0)
        list.add(string)

    if(openB>0)
        generate(openB-1, closeB, "$string(", list)

    if (closeB>openB)
        generate(openB, closeB-1, "$string)", list)

    return list
}

fun main(){
    generateParenthesis(3)
}